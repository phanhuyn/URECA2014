package com.huy.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.huy.adhd.AssetLoader;

public class Text extends Actor {

	private String contain;
	private BitmapFont font;

	//public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

	public Text(String contain, float x, float y, int size) {
		setX(x);
		setY(y);
		this.contain = contain;
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		font = (AssetLoader.getTIMES_SQFont()).generateFont(parameter);
		
		//font = TrueTypeFontFactory.createBitmapFont(AssetLoader.TIMES_SQ, FONT_CHARACTERS,
		//		800, 600, size, 800,
		//		600);
	}

	public Text(String contain, float x, float y, int size,
			FreeTypeFontGenerator fontType) {
		setX(x);
		setY(y);
		this.contain = contain;
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		font = fontType.generateFont(parameter);
	}

	public Text(String contain, float x, float y, int size, float red,
			float blue, float green, float alpha) {
		setX(x);
		setY(y);
		this.contain = contain;
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		font = (AssetLoader.getTIMES_SQFont()).generateFont(parameter);
		font.setColor(red, blue, green, alpha);
	}

	public Text(String contain, float x, float y, int size, float red,
			float blue, float green, float alpha, FreeTypeFontGenerator fontType) {
		setX(x);
		setY(y);
		this.contain = contain;
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		font = fontType.generateFont(parameter);
		font.setColor(red, blue, green, alpha);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		font.draw(batch, contain, getX(), getY());
	}
	
	public void setContain(String newContain){
		contain = newContain;
	}
}
