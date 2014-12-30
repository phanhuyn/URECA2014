package com.huy.objects;

public class StopWatch extends Text {
	private float playTime;
	private boolean running = true;

	public StopWatch(float x, float y, int size) {
		super("", x, y, size);
		playTime = 0;
	}

	public StopWatch(float x, float y, int size, float red, float blue,
			float green, float alpha) {
		super("", x, y, size, red, blue, green, alpha);
		playTime = 0;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		// System.out.println(playTime);
		if (running) {
			playTime += delta;
			setContain(String.format("%.2f", playTime));
		}
	}
	
	public void stop(){
		running = false;
	}
}
