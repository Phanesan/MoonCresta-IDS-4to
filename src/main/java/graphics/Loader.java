package main.java.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	
	public static BufferedImage imageLoader(String path) {
		try {
			return ImageIO.read(Loader.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Image resizeImage(int width, int height, BufferedImage img) {
        return img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
    }
	
}
