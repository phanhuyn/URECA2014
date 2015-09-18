package com.adhd.gameObjects.findTheNumber;

import com.adhd.gameObjects.dragAndDrop.Square;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.huy.adhd.AssetLoader;
import com.huy.objects.Text;

public class NumberSquare extends Group {

	private int number;
	private Text numberText;
	private Square square;
	private int offsetX;
	private int width = 50;
	private int height = 50; 
	
	public NumberSquare(float x, float y, int number) {
		square = new Square (x, y, width, height, AssetLoader.getNumberSquare());
		this.number = number;
		if (number < 10) {
			offsetX = 15;
		}
		else offsetX = 2;
		numberText = new Text(Integer.toString(number), x + offsetX , y + 40, 50, 0.2f,
				0.2f, 0f, 0.8f);
		addActor(square);
		addActor(numberText);
	}

	public int getNumber() {
		return number;
	}
}
