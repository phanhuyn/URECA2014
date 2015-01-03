package com.adhd.gameObjects.dragAndDrop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.huy.objects.Shape;

public class Square extends Shape {

	private boolean inHole;
	
	public Square(float x, float y, float width, float height, Texture texture) {
		super(x, y, width, height, texture, true);
		inHole = false;
	}

	public void updatePosition(float x, float y) {
		// System.out.println(x + " - " + y);
		setX(getX() + (x - getWidth() / 2));
		setY(getY() + y - getHeight() / 2);
		setBounds(getX(), getY(), getWidth(), getHeight());
		inHole = false;
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, this.getX(), getY(), this.getOriginX() + getWidth()
				/ 2, this.getOriginY() + getHeight() / 2, this.getWidth(),
				this.getHeight(), this.getScaleX(), this.getScaleY(),
				this.getRotation(), 0, 0, texture.getWidth(),
				texture.getHeight(), false, false);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (inHole) {
			// System.out.println("Game is over!");
			this.addAction(Actions.scaleTo(0f, 0f, 0.3f));
		}
	}

	public boolean updateInHole(Square hole) {
		if ((getX() <= hole.getX() + hole.getWidth() && getX() >= hole
				.getX()) && (getY() <= hole.getHeight() + hole.getY() && getY() >= hole
				.getHeight())){
			inHole = true;
			return true;
		}
		return false;
	}
	
}
