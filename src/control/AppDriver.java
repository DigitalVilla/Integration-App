package control;

import control.Control;
import view.View;

/**
 * This class is the runner for the Manager APP 
 */
public class AppDriver {
	public static void main(String[] args) {
		new Control(new View());
	}
}
