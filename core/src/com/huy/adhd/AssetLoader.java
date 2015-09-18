package com.huy.adhd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class AssetLoader {

	// IMAGES
	private static Texture menuButton1;
	private static Texture menuButton2;
	// drag&drop
	private static Texture square;
	private static Texture square2;
	// collect the square
	private static Texture smallSquare;
	private static Texture hole;
	// find the number
	private static Texture numberSquare;
	// smiley face
	private static Texture smileyFace;
	
	// FONTS
	private static FreeTypeFontGenerator TIMES_SQ;

	public static void initResources() {
		loadImages();
		loadFonts();
	}

	private static void loadImages() {
		menuButton1 = new Texture(Gdx.files.internal("images/menuButton.png"));
		menuButton2 = new Texture(Gdx.files.internal("images/menuButton2.png"));
		// drag and drop
		square = new Texture(Gdx.files.internal("images/square.png"));
		square2 = new Texture(Gdx.files.internal("images/square2.png"));
		// collect the square
		smallSquare = new Texture(Gdx.files.internal("images/smallWhiteSquare.png"));
		hole = new Texture(Gdx.files.internal("images/hole.png"));
		//find the number
		numberSquare = new Texture (Gdx.files.internal("images/numberSquare.png"));
		//smiley face
		smileyFace = new Texture (Gdx.files.internal("images/smileyFace.png"));
	}

	private static void loadFonts() {
		TIMES_SQ = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/TIMES_SQ.TTF"));
	}
	
	public static Texture getNumberSquare() {
		return numberSquare;
	}

	public static Texture getMenuButton1() {
		return menuButton1;
	}
	
	public static Texture getMenuButton2(){
		return menuButton2;
	}

	public static Texture getSquare() {
		return square;
	}

	public static Texture getSquare2() {
		return square2;
	}
	
	public static Texture getSmallSquare(){
		return smallSquare;
	}
	
	public static Texture getHole(){
		return hole;
	}
	
	public static Texture getSmileyFace(){
		return smileyFace;
	}

	public static FreeTypeFontGenerator getTIMES_SQFont() {
		return TIMES_SQ;
	}
}
