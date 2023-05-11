package main.java.graphics;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public abstract class Assets {
	
	public static final BufferedImage PLAYER = Loader.imageLoader("/main/resources/airship.png");
	//public static final BufferedImage MENU_BACKGROUND = Loader.imageLoader("/main/resources/Fondo.png");
	public static final BufferedImage LOGO = Loader.imageLoader("/main/resources/Titulo.png");
	public static final BufferedImage SHOT = Loader.imageLoader("/main/resources/Disparo.png");
	public static final BufferedImage BACKGROUND_GAME = Loader.imageLoader("/main/resources/background_game.png");
	public static final BufferedImage SHOT_ENEMY = Loader.imageLoader("/main/resources/DisparoEnemigo.png");
	public static final BufferedImage ENEMY1 = Loader.imageLoader("/main/resources/enemy.png");
	
	// SONIDOS
	
	public static final String BACKGROUND_OST = "/main/resources/sounds/background/track1.wav";
	public static final String SHOT_LASER = "/main/resources/sounds/sfx/DisparoLaser.wav";
	public static final String IMPACT = "/main/resources/sounds/sfx/impact.wav";
	public static final String DEATH = "/main/resources/sounds/sfx/death.wav";
	public static final String DOWNGRADE = "/main/resources/sounds/sfx/downgrade.wav";
	public static final String UPGRADE = "/main/resources/sounds/sfx/upgrade.wav";

}
