package com.adhd.games;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.AssetLoader;
import com.huy.adhd.GameWorld;
import com.huy.objects.MenuButton;
import com.huy.objects.MenuButton3;
import com.huy.objects.Text;

public class Game extends Stage {

	private Text title;
	private MenuButton backButton; 
	
	public Game(FitViewport viewport, String titleText) {
		super(viewport);
		
		title = new Text(titleText, 250, 550, 50, 1, 1, 1, 1,
				AssetLoader.getTIMES_SQFont());
		this.addActor(title);
		
		backButton = new MenuButton3(20, 530, "Main Menu");
		this.addActor(backButton);
		
		addListener();
	}
	
	private void addListener() {
		backButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				GameWorld.setCurrentScreen(GameWorld.getSelectionScreen());
				return true;
			}
		});
	}
}
