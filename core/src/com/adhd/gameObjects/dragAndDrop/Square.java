package com.adhd.gameObjects.dragAndDrop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.huy.objects.Shape;

public class Square extends Shape {

	public Square(float x, float y, float width, float height, Texture texture,
			boolean touchable) {
		super(x, y, width, height, texture, touchable);
	}

	public void updatePosition(float x, float y) {
		//System.out.println(x + " - " + y);
		setX(getX() + (x - 75f));
		setY(getY() + y - 75f);
		setBounds(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, this.getX(), getY(), this.getOriginX() + getWidth()/2,
				this.getOriginY() + getHeight()/2 , this.getWidth(), this.getHeight(),
				this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0,
				texture.getWidth(), texture.getHeight(), false, false);
	}
}
