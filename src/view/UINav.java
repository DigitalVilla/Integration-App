package view;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class UINav {
	private JPanel contentPane;
	private MyButton closeBtn;
	private MyButton btnCheck_1;
	private MyButton btnProcess_2;
	private MyButton btnPerform_3;
	private MyButton btnExport_4;
	private Color color1;
	private Color color1H;
	private Color color2;
	private Color dark;
	private Color light;

	/**
	 * The main constructor that draws all the elements in the Residential JPanel
	 * 
	 * @param color1
	 *            primary color
	 * @param color1H
	 *            primary color for a hover effect
	 * @param color2
	 *            secondary color
	 * @param dark
	 *            primary black
	 * @param light
	 *            primary white
	 * @return the contentPane
	 */
	public UINav(Color color1, Color color1H, Color color2, Color dark, Color light) {
		this.color1 = color1;
		this.color1H = color1H;
		this.color2 = color2;
		this.dark = dark;
		this.light = light;
		contentPane = new JPanel();
		contentPane.setBackground(dark);
		contentPane.setBounds(0, 0, 190, 420);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		initpanel();
	}

	/**
	 * This method returns the main JPanel that holds all the client GUI methods
	 * 
	 * @return contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * * This method returns the JButton for CLOSE in the navigation JPanel
	 * 
	 * @return closeBtn
	 */
	public JButton getCloseBtn() {
		return closeBtn;
	}
	
	public void getCloseBtn(ActionListener action) {
		closeBtn.addActionListener(action);
	}
	

	/**
	 * * This method returns the JButton for DASHBORAD in the navigation JPanel
	 * 
	 * @return btnCheck_1
	 */
	public JButton getCheckBtn() {
		return btnCheck_1;
	}

	/**
	 * * This method returns the JButton for CLIENT in the navigation JPanel
	 * 
	 * @return btnProcess_2
	 */
	public JButton getProcessBtn() {
		return btnProcess_2;
	}

	/**
	 * * This method returns the JButton for RESIDENTIAL in the navigation JPanel
	 * 
	 * @return btnPerform_3
	 */
	public JButton getPerformBtn() {
		return btnPerform_3;
	}

	/**
	 * * This method returns the JButton for COMMERCIAL in the navigation JPanel
	 * 
	 * @return btnExport_4
	 */
	public JButton getExportBtn() {
		return btnExport_4;
	}

	/**
	 * This method draws all the elements in the navigation JPanel
	 */
	public void initpanel() {
		
		btnCheck_1 = coolBtn("   Check  ", "lock.png",dark);
		btnCheck_1.setBounds(0, 22, 190, 60);
		contentPane.add(btnCheck_1);
	
		btnProcess_2 = coolBtn("   Process   ", "text.png",dark);
		btnProcess_2.setBounds(0, 92, 190, 60);
		contentPane.add(btnProcess_2);
	
		btnPerform_3 = coolBtn("   Perform   ", "dash2.png",dark);
		btnPerform_3.setBounds(0, 162, 190, 60);
		contentPane.add(btnPerform_3);
		
		btnExport_4 = coolBtn("   Export   ", "paper-plane.png",dark);
		btnExport_4.setBounds(0, 232, 190, 60);
		contentPane.add(btnExport_4);

		closeBtn = coolBtn("   Exit  ", "exit.png",dark);
		closeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeBtn.setPressedBackgroundColor(color2);
		closeBtn.setHoverBackgroundColor(dark.brighter());
		closeBtn.setBounds(0, 380, 189, 40);
		contentPane.add(closeBtn);
	}

	private MyButton coolBtn(String title, String image, Color color) {
		MyButton myBtn = new MyButton(title);
		myBtn.setFocusPainted(false);
		myBtn.setIcon(new ImageIcon(("res/icons/"+image)));
		myBtn.setForeground(new Color(240, 240, 250));
		myBtn.setFont(new Font("Lato", Font.PLAIN, 18));
		myBtn.setBackground(color);
		// Personalized
		myBtn.setHoverBackgroundColor(color);
		myBtn.setPressedBackgroundColor(color);
//		myBtn.addActionListener(myAction);
		myBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
//		myBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return myBtn;
	}


}