package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import view.Check;
import view.Process;
import view.Perform;
import view.Export;

/**
 * This class is the View in the MVC model. It brings all the JPanels together
 * and draws them to the JFrame
 */
public class View extends JFrame {
	private static final long serialVersionUID = -6296281019082418930L;
	private JPanel windowView;
	private UINav nav;
	private Check check;
	private Process process;
	private Perform perform;
	private Export export;

	/**
	 * This constructor sets the size of the JFrame and initiates the imported
	 * JPanels in the order they should be painted
	 */
	public View() {

		// global colors
		Color color1 = new Color(70, 130, 180);
		Color color1H = new Color(90, 150, 200);
		Color color2 = new Color(255, 80, 100);
		Color dark = new Color(50, 60, 80);
		Color dark2 = new Color(60, 70, 90);
		Color light = new Color(240, 240, 250);
		Color light2 = new Color(211, 211, 211);

		//initiate windows
		nav = new UINav(color1, color1H, color2, dark, light);
		check = new Check(color1, color2, dark, dark2, light, light2);
		process = new Process(color1, color2, dark, dark2, light, light2);
		perform = new Perform(color1, color2, dark, dark2, light, light2);
		export = new Export(color1, color2, dark, dark2, light, light2);
		
		// window design
		setUndecorated(true);
		setResizable(false);
		setBounds(300, 150, 720, 420);

		windowView = new JPanel();
		windowView.setBackground(dark2);
		windowView.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowView.setLayout(null);
		windowView.add(nav.getContentPane());
		windowView.add(check.getContentPane());
		setMovingPanel();
		setContentPane(windowView);
		this.setVisible(true);
	}


	/**
	 * * This method returns the JPanel for the main panels container
	 * 
	 * @return windowView
	 */
	public JPanel getWindowView() {
		return windowView;
	}
	
	//window getters

	public Check getCheck() {
		return check;
	}
	public Process getProcess() {
		return process;
	}
	public Perform getPerform() {
		return perform;
	}
	public Export getExport() {
		return export;
	}

	public UINav getNav() {
		return nav;
	}

	
	/**
	 * This method sets a JPanel in the navigation menu that allows the user to move
	 * the window around
	 */
	public void setMovingPanel() {
		JPanel movingPanel = new MotionPanel(this);
		movingPanel.setBounds(0, 0, 720, 420);
		movingPanel.setBackground(new Color(30, 50, 60, 150));
		windowView.add(movingPanel);
	}
	
	
	/**
	 * This class adds custom functionality to a JPanel, so it can be used as the
	 * moving panel container
	 */
	public class MotionPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private Point initialClick;
		@SuppressWarnings("unused")
		private JFrame parent;

		public MotionPanel(final JFrame parent) {
			this.parent = parent;

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					initialClick = e.getPoint();
					getComponentAt(initialClick);
				}
			});

			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					// get location of Window
					int thisX = parent.getLocation().x;
					int thisY = parent.getLocation().y;
					// Determine how much the mouse moved since the initial click
					int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
					int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);
					// Move window to this position
					int X = thisX + xMoved;
					int Y = thisY + yMoved;
					parent.setLocation(X, Y);
				}
			});
		}
	}
}