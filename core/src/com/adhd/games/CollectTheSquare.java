package com.adhd.games;

import java.util.Random;

import com.adhd.gameObjects.dragAndDrop.Square;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.AssetLoader;
import com.huy.objects.StopWatch;

public class CollectTheSquare extends Game {
	private Square[] squares;
	private Square hole;
	private Random random;
	private boolean hasFinished;
	private StopWatch stopWatch;
	private int ballInHole;

	public CollectTheSquare(FitViewport viewport) {
		super(viewport, "Collect the squares");

		hole = new Square(400, 200, 200, 200, AssetLoader.getHole());
		this.addActor(hole);

		squares = new Square[10];
		random = new Random();
		for (int i = 0; i < 10; i++) {
			while (squares[i] == null || squares[i].updateInHole(hole)) {
				squares[i] = new Square(random.nextFloat() * 700 + 5,
						random.nextFloat() * 400 + 5, 50f, 50f,
						AssetLoader.getSmallSquare());
			}
			this.addActor(squares[i]);
		}

		addListener();
		
		stopWatch = new StopWatch(250, 480, 50);
		this.addActor(stopWatch);
		
		hasFinished = false;
		
		ballInHole = 0;
	}

	private void addListener() {
		for (int i = 0; i < 10; i++) {
			squares[i].addListener((new DragListener() {
				@Override
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					return true;
				}

				@Override
				public void touchDragged(InputEvent event, float x, float y,
						int pointer) {
					((Square) (event.getTarget())).updatePosition(x, y);
				}

				@Override
				public void touchUp(InputEvent event, float x, float y,
						int pointer, int button) {
					if (((Square) event.getTarget()).updateInHole(hole))
						updateGame();
				}
			}

			));
		}
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if (hasFinished) {
			// System.out.println("Game is over!");
			stopWatch.stop();
			hasFinished = false;
		}
	}

	public boolean hasFinished() {
		return hasFinished;
	}
	
	private void updateGame(){
		ballInHole++;
		if (ballInHole == 10){
			hasFinished = true;
		}
	}
}
