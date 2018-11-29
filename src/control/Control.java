package control;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.MyButton;
import view.View;

public class Control {
	private ArrayList<JPanel> views;
	private ArrayList<JButton> btns;
	private View view;

	public Control(View view) {
		this.view = view;
		loadArrays();
		toggleBtns(0);
		runListeners();
	}

	class MyActionEvent implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.getCheck().getActionBtn())
				cntrlCheck();
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
			JTextField username = view.getCheck().getTextField1();
			JTextField password = view.getCheck().getTextField2();
			updateView(1);
		}

		private void cntrlProcess() {
			JLabel warning = view.getProcess().getWarningTxt();
			JTextField field1 = view.getProcess().getTextField1();
			JTextField field2 = view.getProcess().getTextField2();
			JTextField field3 = view.getProcess().getTextField2();
			updateView(2);

		}

		private void cntrlPerform() {
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
	
//	Utility Methods
	
	public void runListeners() {
		view.getCheck().getActionBtn(new MyActionEvent());
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
