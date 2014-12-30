package com.adhd.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.GameWorld;
import com.huy.objects.MenuButton;

public class GameSelectionScreen extends Stage{
	
	private MenuButton dragAndDrop;
	
	public GameSelectionScreen (){
		super(new FitViewport(800, 600));

		dragAndDrop = new MenuButton(200, 220, "DRAG & DROP");
		dragAndDrop.setTouchable(Touchable.enabled);
		this.addActor(dragAndDrop);
		
		linkButton();
	}
	
	private void linkButton() {
		dragAndDrop.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				GameWorld.setCurrentScreen(GameWorld.getDragAndDropGame());
				return true;
			}
		});
	}
}
