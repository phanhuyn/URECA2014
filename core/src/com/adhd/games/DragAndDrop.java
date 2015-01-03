package com.adhd.games;

import com.adhd.gameObjects.dragAndDrop.Square;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.AssetLoader;
import com.huy.objects.StopWatch;
import com.huy.objects.Text;

public class DragAndDrop extends Stage {

	private Text title;
	private Square square;
	private Square hole;
	private boolean hasFinished = false;
	private StopWatch stopWatch;

	public DragAndDrop(FitViewport viewport) {
		super(viewport);

		title = new Text("Drag & Drop", 250, 550, 50, 1, 1, 1, 1,
				AssetLoader.getTIMES_SQFont());
		this.addActor(title);
		hole = new Square(600, 150, 150, 150, AssetLoader.getSquare2());
		square = new Square(100, 150, 150, 150, AssetLoader.getSquare());
		stopWatch = new StopWatch(250, 480, 50);

		this.addActor(hole);
		this.addActor(square);
		this.addActor(stopWatch);

		addListener();
	}

	private void addListener() {
		/*
		 * square.addListener(new InputListener() { public boolean
		 * touchDown(InputEvent event, float x, float y, int pointer, int
		 * button) { square.updatePosition(x, y); hasFinished =
		 * (Math.abs((square.getX() - hole.getX())) <= hole .getWidth() / 3) &&
		 * (Math.abs((square.getY() - hole.getY())) <= hole .getHeight() / 3);
		 * return true; }
		 * 
		 * 
		 * });
		 */

		square.addListener((new DragListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchDragged(InputEvent event, float x, float y,
					int pointer) {
				square.updatePosition(x, y);
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				hasFinished = (Math.abs((square.getX() - hole.getX())) <= hole
						.getWidth() / 3)
						&& (Math.abs((square.getY() - hole.getY())) <= hole
								.getHeight() / 3);
			}

		}));
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (hasFinished) {
			// System.out.println("Game is over!");
			square.addAction(Actions.scaleTo(0f, 0f, 0.3f));
			stopWatch.stop();
			hasFinished = false;
		}
	}

	public boolean hasFinished() {
		return hasFinished;
	}

}
