package com.adhd.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.GameWorld;
import com.huy.objects.MenuButton;
import com.huy.objects.MenuButton2;

public class GameSelectionScreen extends Stage {

	private MenuButton dragAndDrop;
	private MenuButton collectTheSquare;
	private MenuButton findTheNumber;

	public GameSelectionScreen(FitViewport viewport) {
		super(viewport);

		dragAndDrop = new MenuButton2(200, 220, "DRAG & DROP");
		collectTheSquare = new MenuButton2(200, 380, "COLLECT THE SQUARES");
		findTheNumber = new MenuButton2(200, 300, "FIND THE NUMBER");
		
		this.addActor(collectTheSquare);
		this.addActor(dragAndDrop);
		this.addActor(findTheNumber);
		
		linkButton();
	}

	private void linkButton() {
		dragAndDrop.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				GameWorld.setCurrentScreen(GameWorld.getDragAndDropGame());
				return true;
			}
		});
		
		collectTheSquare.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){
				GameWorld.setCurrentScreen(GameWorld.getCollectTheSquareGame());
				return true;
			}
		});
		
		findTheNumber.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){
				GameWorld.setCurrentScreen(GameWorld.getFindTheNumberGame());
				return true;
			}
		});
		
	}
}
