package main.java.utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.InputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.WindowFrame;

public abstract class FrameUtil {
	
	/**
	 * Cambia de panel principal
	 * @param panelFrame panel principal (contentPane)
	 * @param panel panel a cambiar
	 */
	public static void changePanel(WindowFrame instanceMain,JPanel panel) {
		JPanel panelFrame = instanceMain.getContentPanel();
		
		if(panelFrame.getComponentCount() != 0) {
			panelFrame.remove(0);
		}
		panelFrame.add(panel,BorderLayout.CENTER);
	}
	
	/**
     * Obtienes el {@link InputStream} de algun archivo
     * @param path la ruta relativa del archivo
     * @return el {@link InputStream} del archivo
     */
    public static InputStream getStream(String path) {
        return ImageUtil.class.getClassLoader().getResourceAsStream(path);
    }
	
}
