package com.huy.adhd;

import com.badlogic.gdx.Game;

public class AdhdGame extends Game{

	@Override
	public void create() {
		// TODO Auto-generated method stub
		AssetLoader.initResources();
		GameWorld gameWorld = new GameWorld();
		GameScreen gameScreen = new GameScreen();
		gameWorld.setMainScreen(gameScreen);
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose() {
		
	}
}
