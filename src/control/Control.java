package control;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DBops;
import view.MyButton;
import view.View;

public class Control {
	private ArrayList<JPanel> views;
	private ArrayList<JButton> btns;
	private View view;
	private File payFile;
	private File loaderDir;
	private String username;
	private String password;
	private DBops dbOps;
	
	public Control(View view) {
		dbOps = new DBops();
		this.view = view;
		loadArrays();
		runListeners();
	}

	class MyActionEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.getWelcome().getActionBtn()) {
				view.getWindowView().removeAll();
				view.getWindowView().add(view.getNav().getContentPane());
				view.getWindowView().add(view.getCheck().getContentPane());
				view.setMovingPanel();
				view.revalidate();
				view.repaint();
				toggleBtns(0);

			}

			if (e.getSource() == view.getCheck().getActionBtn())
				cntrlCheck();
			else if (e.getSource() == view.getProcess().getPickFileBtn())
				cntrlPickfile();
			else if (e.getSource() == view.getProcess().getPickDirBtn())
				cntrlPickDir();
			else if (e.getSource() == view.getProcess().getActionBtn())
				cntrlProcess();
			else if (e.getSource() == view.getPerform().getActionBtn())
				cntrlPerform();
			else if (e.getSource() == view.getExport().getActionBtn())
				cntrlExport();
			else if (e.getSource() == view.getNav().getCloseBtn())
				cntrlClose();
		}

		private void cntrlCheck() {

			JLabel warning = view.getCheck().getWarningTxt();
			warning.setText("");
			JTextField user = view.getCheck().getTextField1();
			JTextField pass = view.getCheck().getTextField2();

			// username = user.getText();
			// password = pass.getText();
			username = "cprg307";
			password = "password";

			try {
				dbOps.getConnection(username, password);

				if (dbOps.checkPriviledges()) {
					updateView(1);
				} else
					warning.setText("Insufficient Privileges");
			} catch (SQLException e) {
				warning.setText("Incorrect Credentials");
				e.printStackTrace();
			}

		}

		//// PROCESS

		private void cntrlPickfile() {
			JFileChooser fc = new JFileChooser();
			int selection = fc.showSaveDialog(null);

			if (selection == JFileChooser.APPROVE_OPTION) {
				payFile = fc.getSelectedFile();
				view.getProcess().getTextField1().setText(payFile.getName());
				view.getProcess().getPickDirBtn().setEnabled(true);
			}
		}

		private void cntrlPickDir() {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int selection = fc.showSaveDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION) {
				loaderDir = fc.getSelectedFile();
				view.getProcess().getTextField2().setText(loaderDir.getName());
				view.getProcess().getActionBtn().setEnabled(true);
			}

		}

		private void cntrlProcess() {
			File loaderFile = new File(loaderDir.getPath() + "/payrollLoader.ctl");
			FileWriter fw;
			try {
				fw = new FileWriter(loaderFile);

				String loadIntoFile = "";
				loadIntoFile += "LOAD DATA\n";
				loadIntoFile += "INFILE '" + payFile.getPath() + "'\"STR '\n";
				loadIntoFile += "'\"\n";
				loadIntoFile += "REPLACE\n";
				loadIntoFile += "INTO TABLE payroll_load\n";
				loadIntoFile += "FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '\"'\n";
				loadIntoFile += "TRAILING NULLCOLS\n";
				loadIntoFile += "(payroll_date DATE \"Month dd, yyyy\",\n";
				loadIntoFile += "employee_id,\n";
				loadIntoFile += "amount,\n";
				loadIntoFile += "status)\n";

				fw.write(loadIntoFile);
				fw.close();

				String commandLoader = "sqlldr userid=" + username + "/" + password + " control=";
				commandLoader += loaderFile.getPath() + "\nlog=" + loaderDir.getPath() + "/loaderLog.log";

				Runtime rt = Runtime.getRuntime();
				Process pro = rt.exec(commandLoader);
				int exitValue = pro.waitFor();

			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				updateView(2);
			}
		}

		private void cntrlPerform() {
			dbOps.zeroOut(); 
			updateView(3);

		}

		private void cntrlExport() {
			JLabel warning = view.getExport().getWarningTxt();
			JTextField field1 = view.getExport().getTextField1();
			JTextField field2 = view.getExport().getTextField2();
			JTextField field3 = view.getExport().getTextField2();
			updateView(0);

		}

		private void cntrlClose() {
			System.exit(0);

		}

	}

	// Utility Methods

	public void runListeners() {
		view.getWelcome().getActionBtn(new MyActionEvent());
		view.getCheck().getActionBtn(new MyActionEvent());
		view.getProcess().getPickFileBtn(new MyActionEvent());
		view.getProcess().getPickDirBtn(new MyActionEvent());
		view.getProcess().getActionBtn(new MyActionEvent());
		view.getPerform().getActionBtn(new MyActionEvent());
		view.getExport().getActionBtn(new MyActionEvent());
		view.getNav().getCloseBtn(new MyActionEvent());
	}

	public void updateView(int index) {
		view.getWindowView().removeAll();
		view.getWindowView().add(view.getNav().getContentPane());
		view.getWindowView().add(views.get(index));
		view.setMovingPanel();
		view.revalidate();
		view.repaint();
		toggleBtns(index);
	}

	private void loadArrays() {
		views = new ArrayList<JPanel>();
		views.add(view.getCheck().getContentPane());
		views.add(view.getProcess().getContentPane());
		views.add(view.getPerform().getContentPane());
		views.add(view.getExport().getContentPane());
		btns = new ArrayList<JButton>();
		btns.add(view.getNav().getCheckBtn());
		btns.add(view.getNav().getProcessBtn());
		btns.add(view.getNav().getPerformBtn());
		btns.add(view.getNav().getExportBtn());
	}

	private void toggleBtns(int index) {
		for (JButton btn : btns) {
			btn.setBackground(new Color(50, 60, 80));
			((MyButton) btn).setHoverBackgroundColor(new Color(50, 60, 80));
		}
		btns.get(index).setBackground(new Color(70, 130, 180));
		((MyButton) btns.get(index)).setHoverBackgroundColor(new Color(70, 130, 180));
	}

}
