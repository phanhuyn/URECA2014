package com.huy.adhd;

import com.adhd.games.CollectTheSquare;
import com.adhd.games.DragAndDrop;
import com.adhd.games.FindTheNumber;
import com.adhd.screens.GameSelectionScreen;
import com.adhd.screens.StartScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameWorld {

	private static GameScreen mainScreen;

	private static Stage startScreen;
	private static Stage selectionScreen;

	private static Stage currentScreen;
	private static Stage dragAndDrop;
	private static Stage collectTheSquare;
	private static Stage findTheNumber;
	
	private static FitViewport viewport;
	
	public GameWorld() {
		
		//VIEWPORT 
		viewport = new FitViewport(800, 600);
	
		//SCREENS
		startScreen = new StartScreen(viewport);
		selectionScreen = new GameSelectionScreen(viewport);
		
		//GAMES
		dragAndDrop = new DragAndDrop(viewport);
		collectTheSquare = new CollectTheSquare(viewport);
		findTheNumber = new FindTheNumber(viewport);

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
	
	public static Stage getCollectTheSquareGame(){
		return collectTheSquare;
	}
	
	public static Stage getFindTheNumberGame(){
		return findTheNumber;
	}
	
	public static FitViewport getViewport(){
		return viewport;
	}

}
