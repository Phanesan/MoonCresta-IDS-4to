package main.java;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import main.java.graphics.Assets;
import main.java.graphics.objects.Enemy;
import main.java.state.GameState;

public class Spawner implements Updateable,Drawable {
	
	private GameState gameState;
	private Random random;
	private int numEnemyPerWave = 0;
	private int spawn = 0;
	private int averageTimeToSpawn = 12;
	private int secondsToSpawn = 0;
	private int enemiesSpawned = 0;
	private int spawnPerWaveMax = 2;
	private int spawnPerWaveMin = 1;
	public static int enemiesKilled = 0;
	
	public static double DROP_RATE_UPGRADE = 2.9;
	public static double DROP_RATE_KILL_ALL = 0.8;
	
	private int fps = 0;
	
	public Spawner(GameState gameState) {
		random = new Random();
		this.gameState = gameState;
		randomize();
	}

	@Override
	public void update() {
		fps++;
		if(fps >= WindowFrame.FPS_TARGET) {
			
			if(secondsToSpawn >= averageTimeToSpawn) {
				spawn = random.nextInt(spawnPerWaveMin)+spawnPerWaveMax;
				for(int i = 0; i < spawn; i++) {
					int x;
					do {
						x = random.nextInt(WindowFrame.WIDTH);
					}while(!(x >= 80 && x <= WindowFrame.WIDTH-80));
					gameState.getHandler().add(new Enemy(gameState,Assets.ENEMY1,new Vector2D(x,-20),0.3f,100));
				}
				enemiesSpawned+=spawn;
				secondsToSpawn = 0;
			}
			
			if(enemiesSpawned >= numEnemyPerWave) {
				randomize();
				System.out.println(averageTimeToSpawn);
				enemiesSpawned = 0;
			}
			secondsToSpawn++;
			fps = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
	}
	
	public void randomize() {
		if(averageTimeToSpawn > 5) {
			averageTimeToSpawn--;
			spawnPerWaveMax++;
		} else {
			spawnPerWaveMax = 8;
			spawnPerWaveMin = 3;
		}
		
		if(averageTimeToSpawn == 9) {
			DROP_RATE_UPGRADE = 4;
		}
		System.out.println(spawnPerWaveMax + "-" + spawnPerWaveMin);
		
		numEnemyPerWave = random.nextInt(5)+15;
		
	}
	
}
