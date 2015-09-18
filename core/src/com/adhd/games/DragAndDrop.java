package com.adhd.games;

import com.adhd.gameObjects.dragAndDrop.Square;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emotiv.emostatelog.Edk;
import com.emotiv.emostatelog.EdkErrorCode;
import com.emotiv.emostatelog.EmoState;
import com.huy.adhd.AssetLoader;
import com.huy.objects.MenuButton;
import com.huy.objects.MenuButton2;
import com.huy.objects.MenuButton3;
import com.huy.objects.StatisticInfo;
import com.huy.objects.StopWatch;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class DragAndDrop extends Game {

	private Square square;
	private Square hole;
	private boolean hasFinished = false;
	private StopWatch stopWatch;
	private MenuButton restartButton;

	private Pointer eEvent = Edk.INSTANCE.EE_EmoEngineEventCreate();
	private Pointer eState = Edk.INSTANCE.EE_EmoStateCreate();
	private IntByReference userID = null;
	private short composerPort = 1726;
	private int option = 1;
	private int state = 0;

	// statistics
	private double excitementShort = 0;
	private double excitementLong = 0;
	private double boredom = 0;
	private long count = 0;
	private StatisticInfo statisticPrint;

	public DragAndDrop(FitViewport viewport) {
		super(viewport, "Drag & Drop");

		hole = new Square(600, 150, 150, 150, AssetLoader.getSquare2());
		square = new Square(100, 150, 150, 150, AssetLoader.getSquare());
		stopWatch = new StopWatch(250, 480, 50);
		restartButton = new MenuButton3(20, 480, "Restart");

		this.addActor(hole);
		this.addActor(square);
		this.addActor(stopWatch);
		this.addActor(restartButton);

		addListener();

		initEmotiv();
	}

	private void addListener() {
		/*
		 * square.addListener(new InputListener() { public boolean
		 * touchDown(InputEvent event, float x, float y, int pointer, int
		 * button) { square.updatePosition(x, y); hasFinished =
		 * (Math.abs((square.getX() - hole.getX())) <= hole .getWidth() / 3) &&
		 * (Math.abs((square.getY() - hole.getY())) <= hole .getHeight() / 3);
		 * return true; }
		 * 
		 * 
		 * });
		 */

		square.addListener((new DragListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchDragged(InputEvent event, float x, float y,
					int pointer) {
				square.updatePosition(x, y);
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				updateFinished();
			}

		}));

		restartButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				restartGame();
				return true;
			}
		});
	}

	private void restartGame() {
		hasFinished = false;
		stopWatch.restart();
		square.setPosition(100, 150);
		square.addAction(Actions.scaleTo(1f, 1f, 0.3f));
		excitementShort = 0;
		excitementLong = 0;
		boredom = 0;
		count = 0;
		statisticPrint.remove();
	}

	private void updateFinished() {
		hasFinished = (Math.abs((square.getX() - hole.getX())) <= hole
				.getWidth() / 3)
				&& (Math.abs((square.getY() - hole.getY())) <= hole.getHeight() / 3);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (hasFinished) {
			// System.out.println("Game is over!");
			square.addAction(Actions.scaleTo(0.1f, 0.1f, 0.3f));
			stopWatch.stop();
			hasFinished = false;
			printStatistic();
		} else {
			getEmotivSignal();
		}
	}

	private void printStatistic() {
		String excitementShortText = "Excitement Short Term: "
				+ String.format("%.7f", excitementShort / count);
		String excitementLongText = "Excitement Long Term: "
				+ String.format("%.7f", excitementLong / count);
		String boredomText = "Boredom: "
				+ String.format("%.7f", boredom / count);

		statisticPrint = new StatisticInfo(200, 150, excitementShortText,
				excitementLongText, boredomText);
		this.addActor(statisticPrint);
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public void getEmotivSignal() {
		// System.out.println("in getEmotivSignal()");
		state = Edk.INSTANCE.EE_EngineGetNextEvent(eEvent);

		// New event needs to be handled
		if (state == EdkErrorCode.EDK_OK.ToInt()) {

			int eventType = Edk.INSTANCE.EE_EmoEngineEventGetType(eEvent);
			Edk.INSTANCE.EE_EmoEngineEventGetUserId(eEvent, userID);

			// Log the EmoState if it has been updated
			if (eventType == Edk.EE_Event_t.EE_EmoStateUpdated.ToInt()) {

				Edk.INSTANCE.EE_EmoEngineEventGetEmoState(eEvent, eState);
				if (EmoState.INSTANCE.ES_ExpressivIsBlink(eState) == 1)
					System.out.println("Blink");
				if (EmoState.INSTANCE.ES_ExpressivIsLeftWink(eState) == 1) {
					System.out.println("LeftWink");
					square.moveBy(-3, 0);
					updateFinished();

				}
				if (EmoState.INSTANCE.ES_ExpressivIsRightWink(eState) == 1) {
					System.out.println("RightWink");
					square.moveBy(20, 0);
					updateFinished();
				}
				if (EmoState.INSTANCE.ES_ExpressivIsLookingLeft(eState) == 1) {
					System.out.println("LookingLeft");
					square.moveBy(-3, 0);
					updateFinished();
				}
				if (EmoState.INSTANCE.ES_ExpressivIsLookingRight(eState) == 1) {
					System.out.println("LookingRight");
					square.moveBy(20, 0);
					updateFinished();
				}

				excitementShort += EmoState.INSTANCE
						.ES_AffectivGetExcitementShortTermScore(eState);
				excitementLong += EmoState.INSTANCE
						.ES_AffectivGetExcitementLongTermScore(eState);
				boredom += EmoState.INSTANCE
						.ES_AffectivGetEngagementBoredomScore(eState);
				count++;

			}
		} else if (state != EdkErrorCode.EDK_NO_EVENT.ToInt()) {
			System.out.println("Internal error in Emotiv Engine!");
		}
	}

	public void initEmotiv() {

		userID = new IntByReference(0);

		switch (option) {
		case 1: {
			if (Edk.INSTANCE.EE_EngineConnect("Emotiv Systems-5") != EdkErrorCode.EDK_OK
					.ToInt()) {
				System.out.println("Emotiv Engine start up failed.");
				return;
			}
			break;
		}
		case 2: {
			System.out.println("Target IP of EmoComposer: [127.0.0.1] ");

			if (Edk.INSTANCE.EE_EngineRemoteConnect("127.0.0.1", composerPort,
					"Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
				System.out
						.println("Cannot connect to EmoComposer on [127.0.0.1]");
				return;
			}
			System.out.println("Connected to EmoComposer on [127.0.0.1]");
			break;
		}
		default:
			System.out.println("Invalid option...");
			return;
		}
	}

}
