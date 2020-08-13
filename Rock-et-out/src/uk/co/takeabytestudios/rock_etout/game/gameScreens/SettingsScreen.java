package uk.co.takeabytestudios.rock_etout.game.gameScreens;

import java.util.List;

import uk.co.takeabytestudios.rock_etout.RocketOutFragment;
import uk.co.takeabytestudios.rock_etout.engine.AssetStore;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.graphics.IGraphics2D;
import uk.co.takeabytestudios.rock_etout.input.Input;
import uk.co.takeabytestudios.rock_etout.input.TouchEvent;
import uk.co.takeabytestudios.rock_etout.world.GameScreen;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * This class creates the settings screen for the game NB: The settings screen
 * was created by David Walsh by using Photoshop
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class SettingsScreen extends GameScreen {

	// Define the trigger touch region for the settings screen
	private Rect mPlayBound;

	// the buttons for the different options on settings
	private Rect mBackEvent;
	private Rect mMuteMusicEvent;
	private Rect mMuteSfxEvent;

	// ints to determine whether music and sound are muted
	private static int musicMute = 0;
	private static int soundMute = 0;

	// Constructor
	/**
	 * Create the settings screen
	 * 
	 * @param game
	 *            - Game to which this screen belongs
	 */
	public SettingsScreen(RocketOutFragment game) {
		super("SettingsScreen", game);

		// Load in the bitmap used on the settings screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager.loadAndAddBitmap("Settings", "Images/Settings.jpg");

		// Define the rects what will be used to 'hold' the images
		int spacingX = (int) (game.getScreenWidth() / 2);
		int spacingY = (int) (game.getScreenHeight() / 2);
		mPlayBound = new Rect(0, 0, 2 * spacingX, 2 * spacingY);

		// Define the rects used for button events
		mBackEvent = new Rect(
				(int) (game.getScreenWidth() / 51.42857142857143),
				(int) (game.getScreenHeight() / 83.47826086956522),
				(int) (game.getScreenWidth() / 3.059490084985836),
				(int) (game.getScreenHeight() / 8.421052631578947));

		mMuteMusicEvent = new Rect(
				(int) (game.getScreenWidth() / 6.101694915254237),
				(int) (game.getScreenHeight() / 5.503716814159292),
				(int) (game.getScreenWidth() / 1.171366594360087),
				(int) (game.getScreenHeight() / 2.848391167192429));

		mMuteSfxEvent = new Rect(
				(int) (game.getScreenWidth() / 6.101694915254237),
				(int) (game.getScreenHeight() / 2.250379746835443),
				(int) (game.getScreenWidth() / 1.171366594360087),
				(int) (game.getScreenHeight() / 1.600227894257065));
	}

	@Override
	public void update(ElapsedTime elapsedTime) {
		// Process any touch events occurring since the update
		Input input = mGame.getInput();

		List<TouchEvent> touchEvents = input.getTouchEvents();

		if (touchEvents.size() > 0) {
			// Just check the first touch event that occurred in the frame.
			// It means pressing the screen with several fingers may not
			// trigger a 'button'
			TouchEvent touchEvent = touchEvents.get(0);

			// Event for when the back button is pressed
			if (mBackEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the back button game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				MenuScreen menuScreen = new MenuScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(menuScreen);
			}

			// Event for when the mute music button is pressed
			if (mMuteMusicEvent
					.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (getMute() == 0) {
					setMute(1);
				} else if (getMute() == 1) {
					setMute(0);
				}
			}

			// Event for when the mute sound effects button is pressed
			if (mMuteSfxEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (getSoundMute() == 0) {
					setSoundMute(1);
				} else if (getSoundMute() == 1) {
					setSoundMute(0);
				}
			}
		}
	}

	/**
	 * This method returns the mute state for music
	 * 
	 * @return - 0 or 1 depending on whether music is muted or not
	 */
	public static int getMute() {
		return musicMute;
	}

	/**
	 * This method sets the mute state for music
	 * 
	 * @param musicMute
	 *            - 0 or 1 (off or on)
	 */
	public static void setMute(int musicMute) {
		SettingsScreen.musicMute = musicMute;
	}

	/**
	 * This method returns the mute state for sound effects
	 * 
	 * @return - 0 or 1 depending on whether sound effects are muted or not
	 */
	public static int getSoundMute() {
		return soundMute;
	}

	/**
	 * This method sets the mute state for sound effects
	 * 
	 * @param soundMute
	 *            - 0 or 1 (off or on)
	 */
	public static void setSoundMute(int soundMute) {
		SettingsScreen.soundMute = soundMute;
	}

	@Override
	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		// Get and draw the bitmaps into the defined rectangles
		Bitmap playSpaceShipGame = mGame.getAssetManager()
				.getBitmap("Settings");
		graphics2D.clear(Color.BLACK);
		graphics2D.drawBitmap(playSpaceShipGame, null, mPlayBound, null);

		// Paint is used to set the font for the text to be drawn to the screen
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize((mGame.getScreenHeight() / 21));

		// Draws text to screen depending on mute states
		if (getMute() == 1) {
			graphics2D.drawText("Muted", (mGame.getScreenWidth() / 4),
					mGame.getScreenHeight() / 4, paint);
		} else if (getMute() == 0) {
			graphics2D.drawText("Unmuted", (mGame.getScreenWidth() / 4),
					mGame.getScreenHeight() / 4, paint);
		}
		if (getSoundMute() == 1) {
			graphics2D.drawText("Muted", (mGame.getScreenWidth() / 4),
					mGame.getScreenHeight() / 2, paint);
		} else if (getSoundMute() == 0) {
			graphics2D.drawText("Unmuted", (mGame.getScreenWidth() / 4),
					mGame.getScreenHeight() / 2, paint);
		}
	}
}