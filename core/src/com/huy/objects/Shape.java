package com.huy.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Shape extends Actor {

	protected Texture texture;

	public Shape(float x, float y, float width, float height, Texture texture,
			boolean touchable) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);

		this.texture = texture;

		if (touchable)
			setBounds(x, y, width, height);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, this.getX(), getY(), this.getOriginX(),
				this.getOriginY(), this.getWidth(), this.getHeight(),
				this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0,
				texture.getWidth(), texture.getHeight(), false, false);
	}
}
