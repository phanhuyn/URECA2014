package com.adhd.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.AssetLoader;
import com.huy.adhd.GameWorld;
import com.huy.objects.MenuButton;
import com.huy.objects.MenuButton1;
import com.huy.objects.Text;

public class StartScreen extends Stage {

	private MenuButton startButton;
	private MenuButton exitButton;
	private Text title;

	public StartScreen(FitViewport viewport) {
		super(viewport);

		startButton = new MenuButton1(200, 220, "START");
		startButton.setTouchable(Touchable.enabled);

		exitButton = new MenuButton1(200, 100, "EXIT");
		exitButton.setTouchable(Touchable.enabled);

		title = new Text("ADHD Games", 180, 400, 100, 1, 1, 1, 1,
				AssetLoader.getTIMES_SQFont());
		
		this.addActor(exitButton);
		this.addActor(startButton);
		this.addActor(title);
		linkButton();
	}

	private void linkButton() {
		startButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				GameWorld.setCurrentScreen(GameWorld.getSelectionScreen());
				//System.out.println("Touched");
				return true;
			}
		});
	}
}
