package view;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Export {
	/**
	 * 
	 */
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPanel contentPane;
	private MyButton actionBtn;
	private JLabel warningLbl;
	private MyButton pickDir;

	public Export(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0, 0));
		contentPane.setBounds(190, 0, 530, 420);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.add(logInPanel(color1, color2, dark, dark2, light, graylight));
		panelBG("prog.jpg");
	}

	public JLabel getWarningTxt() {
		return warningLbl;
	}
	
	public JTextField getTextField1() {
		return textField1;
	}

	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
	}
	
	public JTextField getTextField2() {
		return textField2;
	}

	public void setTextField2(JTextField textField2) {
		this.textField2 = textField2;
	}

	public JTextField getTextField3() {
		return textField3;
	}

	public void setTextField3(JTextField textField3) {
		this.textField3 = textField3;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getActionBtn() {
		return actionBtn;
	}

	public void getActionBtn(ActionListener action) {
		actionBtn.addActionListener(action);
	}

	public JButton getPickDirBtn() {
		return pickDir;
	}
	
	public void getPickDirBtn(ActionListener action) {
		pickDir.addActionListener(action);
	}
	
	
	// LOG IN CLIENT PANNEL
	public JPanel logInPanel(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 560, 420);
		mainPanel.setBackground(new Color(50, 60, 80, 150));
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);

		JLabel lbl1 = new JLabel("Export Directory");
		lbl1.setForeground(new Color(248, 248, 255));
		lbl1.setFont(new Font("Lato", Font.PLAIN, 16));
		lbl1.setBounds(85, 74, 200, 20);
		mainPanel.add(lbl1);

		textField1 = setTxtField(graylight);
		textField1.setBounds(85, 95, 200, 40);
		textField1.setEditable(false);
		mainPanel.add(textField1);

		pickDir = new MyButton("Select Dir");
		pickDir.setFocusPainted(false);
		pickDir.setFont(new Font("Lato", Font.PLAIN, 18));
		pickDir.setBackground(color1);
		pickDir.setForeground(new Color(240, 240, 250));
		pickDir.setHoverBackgroundColor(color1.darker());
		pickDir.setPressedBackgroundColor(color1);
		pickDir.setBounds(315, 95, 130, 40);
		pickDir.setBorder(new EmptyBorder(0, 0, 0, 0));
		pickDir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(pickDir);
		
		
		JLabel lbl2 = new JLabel("Directory Alias");
		lbl2.setForeground(new Color(248, 248, 255));
		lbl2.setFont(new Font("Lato", Font.PLAIN, 16));
		lbl2.setBounds(85, 154, 200, 20);
		mainPanel.add(lbl2);

		textField2 = setTxtField(graylight);
		textField2.setBounds(85, 175, 360, 40);
		mainPanel.add(textField2);
		
		JLabel lbl3 = new JLabel("Export Filename");
		lbl3.setForeground(new Color(248, 248, 255));
		lbl3.setFont(new Font("Lato", Font.PLAIN, 16));
		lbl3.setBounds(85, 233, 200, 20);
		mainPanel.add(lbl3);
		
		textField3 = setTxtField(graylight);
		textField3.setBounds(85, 253, 360, 40);
		mainPanel.add(textField3);
		
		JLabel lblTitle = new JLabel("EXPORT DATA");
		lblTitle.setBounds(139, 32, 313, 32);
		lblTitle.setForeground(new Color(240, 248, 255));
		lblTitle.setFont(new Font("Lato", Font.BOLD, 24));
		mainPanel.add(lblTitle);

		warningLbl = new JLabel();
		warningLbl.setBounds(10, 380, 313, 32);
		warningLbl.setForeground(color2);
		warningLbl.setFont(new Font("Lato", Font.BOLD, 20));
		mainPanel.add(warningLbl);

		actionBtn = new MyButton("EXPORT");
		actionBtn.setFocusPainted(false);
		actionBtn.setFont(new Font("Lato", Font.PLAIN, 18));
		actionBtn.setBackground(color1);
		actionBtn.setForeground(new Color(240, 240, 250));
		actionBtn.setHoverBackgroundColor(color1.darker());
		actionBtn.setPressedBackgroundColor(color1);
		actionBtn.setBounds(85, 330, 360, 45);
		actionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		actionBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(actionBtn);
		return mainPanel;
	}

	public JTextField setTxtField(Color color) {
		JTextField txtf = new JTextField();
		txtf.setFont(new Font("Lato", Font.PLAIN, 18));
		txtf.setForeground(new Color(248, 248, 255));
		txtf.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtf.setBackground(color.darker());
		txtf.setColumns(10);
		return txtf;
	}

	public void panelBG(String image) {
		JLabel panelBG = new JLabel("");
		panelBG.setBounds(0, 0, 892, 621);
		panelBG.setIcon(new ImageIcon(("res/images/" + image)));
		contentPane.add(panelBG);
	}
}
