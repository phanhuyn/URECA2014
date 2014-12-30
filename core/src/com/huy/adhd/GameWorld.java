package com.huy.adhd;

import com.adhd.games.DragAndDrop;
import com.adhd.screens.GameSelectionScreen;
import com.adhd.screens.StartScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameWorld {

	private static GameScreen mainScreen;

	private static Stage startScreen;
	private static Stage selectionScreen;

	private static Stage currentScreen;
	private static Stage dragAndDrop;

	public GameWorld() {
	
		//SCREENS
		startScreen = new StartScreen();
		selectionScreen = new GameSelectionScreen();
		
		//GAMES
		dragAndDrop = new DragAndDrop();

		currentScreen = startScreen;
		Gdx.input.setInputProcessor(currentScreen);
	}

	public static void setCurrentScreen (Stage newScreen){
		currentScreen = newScreen;
		mainScreen.updateCurrentScreen(currentScreen);
		Gdx.input.setInputProcessor(currentScreen);
	}
	
	public void setMainScreen(GameScreen mainScreen){
		GameWorld.mainScreen = mainScreen;
	}
	
	public static Stage getStartScreen() {
		return startScreen;
	}

	public static Stage getSelectionScreen() {
		return selectionScreen;
	}
	
	public static Stage getDragAndDropGame(){
		return dragAndDrop;
	}
}
