package view;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Check {
	/**
	 * 
	 */
	private JTextField textField1;
	private JTextField textField2;
	private JPanel contentPane;
	private MyButton actionBtn;
	private JLabel warningLbl;

	public Check(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
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

	public JTextField getTextField2() {
		return textField2;
	}

	public void setTextField2(JTextField textField2) {
		this.textField2 = textField2;
	}

	public JTextField getTextField1() {
		return textField1;
	}

	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
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

	// LOG IN CLIENT PANNEL
	public JPanel logInPanel(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 560, 420);
		mainPanel.setBackground(new Color(50, 60, 80, 150));
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);

		JLabel lbl1 = new JLabel("Username");
		lbl1.setForeground(new Color(248, 248, 255));
		lbl1.setFont(new Font("Lato", Font.PLAIN, 16));
		lbl1.setBounds(85, 74, 100, 20);
		mainPanel.add(lbl1);

		textField1 = setTxtField(graylight);
		textField1.setBounds(85, 105, 360, 40);
		
		mainPanel.add(textField1);

		JLabel lbl2 = new JLabel("Password");
		lbl2.setForeground(new Color(248, 248, 255));
		lbl2.setFont(new Font("Lato", Font.PLAIN, 16));
		lbl2.setBounds(85, 169, 100, 20);
		mainPanel.add(lbl2);

		textField2 = setTxtField(graylight);
		textField2.setBounds(85, 200, 360, 40);
		mainPanel.add(textField2);

		JLabel lblTitle = new JLabel("INTEGRATION APP");
		lblTitle.setBounds(139, 32, 313, 32);
		lblTitle.setForeground(new Color(240, 248, 255));
		lblTitle.setFont(new Font("Lato", Font.BOLD, 24));
		mainPanel.add(lblTitle);

		warningLbl = new JLabel();
		warningLbl.setBounds(10, 380, 400, 32);
		warningLbl.setForeground(color2);
		warningLbl.setFont(new Font("Lato", Font.BOLD, 20));
		mainPanel.add(warningLbl);

		actionBtn = new MyButton("LOG IN");
		actionBtn.setFocusPainted(false);
		actionBtn.setFont(new Font("Lato", Font.PLAIN, 18));
		actionBtn.setBackground(color1);
		actionBtn.setForeground(new Color(240, 240, 250));
		actionBtn.setHoverBackgroundColor(color1.darker());
		actionBtn.setPressedBackgroundColor(color1);
		actionBtn.setBounds(85, 285, 360, 45);
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
