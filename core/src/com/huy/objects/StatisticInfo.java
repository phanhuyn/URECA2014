package com.huy.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.huy.adhd.AssetLoader;

public class StatisticInfo extends Shape {

	private Text excitementShort;
	private Text excitementLong;
	private Text boredom;
	
	public StatisticInfo(float x, float y, String excitementShort, String excitementLong, String boredom) {
		super(x, y, 400, 250, AssetLoader.getMenuButton2(), true);
		this.excitementShort = new Text(excitementShort, x + 30, y + 60, 25);
		this.excitementLong = new Text(excitementLong, x + 30, y + 120, 25);
		this.boredom = new Text(boredom, x + 30, y + 180, 25);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		excitementShort.draw(batch, alpha);
		excitementLong.draw(batch, alpha);
		boredom.draw(batch, alpha);
	}
}
