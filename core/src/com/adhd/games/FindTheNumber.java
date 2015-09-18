package com.adhd.games;


import com.adhd.gameObjects.findTheNumber.NumberSquare;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.huy.adhd.AssetLoader;
import com.huy.objects.Shape;
import com.huy.objects.StopWatch;

public class FindTheNumber extends Game {
	
	private StopWatch stopWatch;
	private Shape smileyFace;
	private NumberSquare[][] squares;
	private int currentNumber = 1;
	
	
	public FindTheNumber(FitViewport viewport) {
		super(viewport, "Find The Number");
		
		// Add Stopwatch
		stopWatch = new StopWatch(250, 480, 50);
		this.addActor(stopWatch);
		
		// Add smiley faces
		smileyFace = new Shape(250, 100, 300, 300, AssetLoader.getSmileyFace(),
				false);
		this.addActor(smileyFace);
		// Add the number
		/*squares = new NumberSquare[10][5];
	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				squares[i][j] = new NumberSquare(100 + i*60, 100 + j*60, currentNumber);
				this.addActor(squares[i][j]);
				currentNumber++;
			}
		}*/
	
		addListener();
	}
	
	private void addListener() {
		
	}
}
