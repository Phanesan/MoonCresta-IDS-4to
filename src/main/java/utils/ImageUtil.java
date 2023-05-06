package main.java.utils;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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

    /**
     * Obtienes el {@link InputStream} de algun archivo
     * @param path la ruta relativa del archivo
     * @return el {@link InputStream} del archivo
     */
    public static InputStream getStream(String path) {
        return ImageUtil.class.getClassLoader().getResourceAsStream(path);
    }
	
}
