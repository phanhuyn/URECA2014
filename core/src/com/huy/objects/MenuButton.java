package com.huy.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MenuButton extends Shape {

	private Text text;
	
	public MenuButton(float x, float y, float width, float height, String text,
			float offsetX, float offsetY, int textSize, float red, float green,
			float blue, float alpha, Texture texture) {
		super(x, y, width, height, texture, true);
		this.text = new Text(text, x + offsetX, y + offsetY, textSize, red,
				green, blue, alpha);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		text.draw(batch, alpha);
	}
}
