package main.java.utils;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public abstract class FrameUtil {
	
	/**
	 * Cambia de panel principal
	 * @param panelFrame panel principal (contentPane)
	 * @param panel panel a cambiar
	 */
	public static void changePanel(JPanel panelFrame,JPanel panel) {
		if(panelFrame.getComponents().length != 0) {
			panelFrame.remove(0);
		}
		panelFrame.add(panel,BorderLayout.CENTER);
	}
	
}
