package main.java.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class ImageUtil {
	
	/**
     * Cambia de tamaño una imagen
     * @param width anchura de la nueva imagen
     * @param height altura de la nueva imagen
     * @param inputStream el stream de la imagen
     * @return un objeto de tipo {@link Image} con el nuevo tamaño asignado
     */
    public static Image resizeImage(int width, int height, InputStream inputStream) {
        Image img;

        try {
            img = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
    }
    
    public static ImageIcon getSourceImageIcon(URL url) {
        return new ImageIcon(url);
    }
	
}
