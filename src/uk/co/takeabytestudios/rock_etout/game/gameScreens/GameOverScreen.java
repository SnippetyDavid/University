package uk.co.takeabytestudios.rock_etout.game.gameScreens;

import java.util.List;

import uk.co.takeabytestudios.rock_etout.RocketOutFragment;
import uk.co.takeabytestudios.rock_etout.engine.AssetStore;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.game.Money;
import uk.co.takeabytestudios.rock_etout.graphics.IGraphics2D;
import uk.co.takeabytestudios.rock_etout.input.Input;
import uk.co.takeabytestudios.rock_etout.input.TouchEvent;
import uk.co.takeabytestudios.rock_etout.world.GameScreen;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * This class creates the Game Over screen for whenever the 'player' 'dies' in
 * the game NB: The game over screen was created by David Walsh by using
 * Photoshop
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class GameOverScreen extends GameScreen {

	// Define the trigger touch region for playing the 'games'
	private Rect mPlayBound;

	// buttons for back to main menu and retry
	private Rect mMenuEvent;
	private Rect mRetryEvent;

	// variables to store high score and level for displaying results on the
	// game over screen
	static int mHighScore = 0;
	private int mLevel;

	// Constructor

	/**
	 * Creates a Game Over screen
	 * 
	 * @param game
	 *            - Game to which this screen belongs
	 * @param score
	 *            - Score that the player got before they 'died'
	 * @param level
	 *            - Level the user was on before they 'died'
	 */
	public GameOverScreen(RocketOutFragment game, int score, int level) {
		super("GameOver", game);

		// Load in the bitmap used on the game over screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager.loadAndAddBitmap("GameOver", "Images/GameOver.jpg");

		// Define the rects what will be used to 'hold' the images
		int spacingX = (int) (game.getScreenWidth() / 2);
		int spacingY = (int) (game.getScreenHeight() / 2);
		mPlayBound = new Rect(0, 0, 2 * spacingX, 2 * spacingY);

		// Define the rects for the button events
		mMenuEvent = new Rect(
				(int) (game.getScreenWidth() / 18.62068965517241),
				(int) (game.getScreenHeight() / 64.2),
				(int) (game.getScreenWidth() / 2.240663900414938),
				(int) (game.getScreenHeight() / 5.063128491620112));

		mRetryEvent = new Rect(
				(int) (game.getScreenWidth() / 1.881533101045296),
				(int) (game.getScreenHeight() / 64.2),
				(int) (game.getScreenWidth() / 1.070366699702676),
				(int) (game.getScreenHeight() / 5.063128491620112));

		// sets the high score to the score when the player dies if the score is
		// higher than the high score
		if (score > mHighScore) {
			mHighScore = score;
		}
		// makes the level the user was on equal to the mLevel variable in this
		// class
		mLevel = level;

		// saves the game automatically when the game over screen is displayed
		mGame.save();
	}

	// Methods

	/**
	 * This method returns the high score the user got
	 * 
	 * @return - high score
	 */
	public static int getHighScore() {
		return mHighScore;
	}

	/**
	 * This method is used to set the high score. Mostly used with the load
	 * method when game is opened
	 * 
	 * @param newScore
	 *            - the new high score
	 */
	public static void setHighScore(int newScore) {
		mHighScore = newScore;
	}

	@Override
	public void update(ElapsedTime elapsedTime) {
		// stops the music playing when on this screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager.getMusic("GameMusic").stop();
		assetManager.getMusic("Launch").stop();
		assetManager.getMusic("Explosion").stop();

		// sleeps the game over screen so a button isn't accidently pressed when
		// the user gets to it
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			Log.e("RocketOut", "Game Over screen update failed");
		}
		// Process any touch events occurring since the update
		Input input = mGame.getInput();

		List<TouchEvent> touchEvents = input.getTouchEvents();

		if (touchEvents.size() > 0) {
			// Just check the first touch event that occurred in the frame.
			// It means pressing the screen with several fingers may not
			// trigger a 'button'

			TouchEvent touchEvent = touchEvents.get(0);

			// Event for when menu button is pressed
			if (mMenuEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the menu button game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					Log.e("RocketOut", "Could not swap screens");
				}
				MenuScreen menuScreen = new MenuScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(menuScreen);
			}

			// Event for when retry button is pressed
			if (mRetryEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the retry button game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				RocketGameScreen steeringDemoGameScreen = new RocketGameScreen(
						mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(steeringDemoGameScreen);
			}
		}
	}

	@Override
	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		// Get and draw the bitmaps into the defined rectangles
		Bitmap playSpaceShipGame = mGame.getAssetManager()
				.getBitmap("GameOver");
		graphics2D.clear(Color.BLACK);
		graphics2D.drawBitmap(playSpaceShipGame, null, mPlayBound, null);

		// creates the format for text drawn to the screen by using paint
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(80);

		// Draws scores, level and money values to the result part of the game
		// over screen. This will
		// be displayed in the same location for every screen resolution
		graphics2D.drawText("" + (RocketGameScreen.getScore() - 1),
				(float) (mGame.getScreenWidth() / 1.7),
				(float) (mGame.getScreenHeight() / 1.96), paint);

		graphics2D.drawText("" + mHighScore,
				(float) (mGame.getScreenWidth() / 1.7),
				(float) (mGame.getScreenHeight() / 1.65), paint);

		graphics2D.drawText("" + Money.getTotalMoney(),
				(float) (mGame.getScreenWidth() / 1.7),
				(float) (mGame.getScreenHeight() / 1.44), paint);

		graphics2D.drawText("" + mLevel,
				(float) (mGame.getScreenWidth() / 1.7),
				(float) (mGame.getScreenHeight() / 1.28), paint);
	}
}