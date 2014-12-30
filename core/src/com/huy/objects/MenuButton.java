package com.huy.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.huy.adhd.AssetLoader;

public class MenuButton extends Shape {

	private Text text;

	public MenuButton(float x, float y, String text) {
		super(x, y, 400, 90, AssetLoader.getMenuButton(), true);
		this.text = new Text(text, x + 70, y +70, 60, 0, 0, 0, 1);
	}

	public MenuButton(float x, float y, float width, float height, String text) {
		super(x, y, width, height, AssetLoader.getMenuButton(), true);
		this.text = new Text(text, x + 70, y + 70, 60, 0, 0, 0, 1);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		super.draw(batch, alpha);
		text.draw(batch, alpha);
	}
}
