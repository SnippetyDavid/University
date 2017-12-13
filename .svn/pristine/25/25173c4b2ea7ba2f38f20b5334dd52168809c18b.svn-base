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

/**
 * This class creates the shop screen that will be used in the game
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class ShopScreen extends GameScreen {

	// Define the trigger touch regions for the buttons
	private Rect mPlayBound;
	private Rect mBackEvent;
	private Rect mFuelEvent1;
	private Rect mFuelEvent2;
	private Rect mFuelEvent3;
	private Rect mEngineEvent1;
	private Rect mEngineEvent2;
	private Rect mEngineEvent3;

	// these variables are used to define what has been bought already in the
	// shop
	private static int fTick = 0;
	private static int eTick = 0;

	// these variables are used to store the prices of the shop items
	private int sOptOne = 10;
	private int sOptTwo = 50;
	private int sOptThree = 100;

	// Constructor
	/**
	 * Create the shop screen
	 * 
	 * @param game
	 *            - Game to which this screen belongs
	 */
	public ShopScreen(RocketOutFragment game) {
		super("ShopScreen", game);

		// Load in the bitmap used on the menu screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager.loadAndAddBitmap("Shop", "Images/Shop.jpg");
		assetManager.loadAndAddBitmap("greenTick", "Images/tick.png");

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

		mFuelEvent1 = new Rect(
				(int) (game.getScreenWidth() / 13.01204819277108),
				(int) (game.getScreenHeight() / 3.64),
				(int) (game.getScreenWidth() / 3.385579937304075),
				(int) (game.getScreenHeight() / 2.000957283680175));

		mFuelEvent2 = new Rect(
				(int) (game.getScreenWidth() / 2.911051212938005),
				(int) (game.getScreenHeight() / 3.64),
				(int) (game.getScreenWidth() / 1.6289592760181),
				(int) (game.getScreenHeight() / 2.000957283680175));

		mFuelEvent3 = new Rect(
				(int) (game.getScreenWidth() / 1.565217391304348),
				(int) (game.getScreenHeight() / 3.64),
				(int) (game.getScreenWidth() / 1.06614017769003),
				(int) (game.getScreenHeight() / 2.000957283680175));

		mEngineEvent1 = new Rect(
				(int) (game.getScreenWidth() / 11.61290322580645),
				(int) (game.getScreenHeight() / 1.552323580034423),
				(int) (game.getScreenWidth() / 3.406940063091483),
				(int) (game.getScreenHeight() / 1.106030150753769));

		mEngineEvent2 = new Rect(
				(int) (game.getScreenWidth() / 2.991689750692521),
				(int) (game.getScreenHeight() / 1.552323580034423),
				(int) (game.getScreenWidth() / 1.616766467065868),
				(int) (game.getScreenHeight() / 1.106030150753769));

		mEngineEvent3 = new Rect(
				(int) (game.getScreenWidth() / 1.527581329561528),
				(int) (game.getScreenHeight() / 1.552323580034423),
				(int) (game.getScreenWidth() / 1.06614017769003),
				(int) (game.getScreenHeight() / 1.106030150753769));
	}

	/**
	 * This method returns the fTick value
	 * 
	 * @return - fTick value
	 */
	public static int getFTick() {
		return fTick;
	}

	/**
	 * This method returns the eTick value
	 * 
	 * @return - eTick value
	 */
	public static int getETick() {
		return eTick;
	}

	/**
	 * This method sets a new fTick value
	 * 
	 * @param newFTick
	 *            - the new fTick value
	 */
	public static void setFTick(int newFTick) {
		fTick = newFTick;
	}

	/**
	 * This method sets a new eTick value
	 * 
	 * @param newETick
	 *            - the new eTick value
	 */
	public static void setETick(int newETick) {
		eTick = newETick;
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

			// Event that happens when the back button is pressed
			if (mBackEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the back button game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				MenuScreen menuScreen = new MenuScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(menuScreen);
				// saves the shop for playing later
				mGame.save();
			}

			// Event that happens when the fuel event 1 button is pressed
			if (mFuelEvent1.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptOne && !(fTick >= 1)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptOne);
					if (fTick == 0) {
						fTick = 1;
					}
				}
			}

			// Event that happens when fuel event 2 button is pressed
			if (mFuelEvent2.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptTwo && !(fTick >= 2)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptTwo);
					if (fTick == 0 || fTick == 1) {
						fTick = 2;
					}
				}
			}

			// Event that happens when fuel event 3 button is pressed
			if (mFuelEvent3.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptThree && !(fTick >= 3)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptThree);
					fTick = 3;
				}
			}

			// Event that happens when engine event 1 button is pressed
			if (mEngineEvent1.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptOne && !(eTick >= 1)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptOne);
					if (eTick == 0) {
						eTick = 1;
					}
				}
			}

			// Event that happens when engine event 2 button is pressed
			if (mEngineEvent2.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptTwo && !(eTick >= 2)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptTwo);
					if (eTick == 0 || eTick == 1) {
						eTick = 2;
					}
				}
			}

			// Event that happens when engine event 3 button is pressed
			if (mEngineEvent3.contains((int) touchEvent.x, (int) touchEvent.y)) {
				if (Money.getTotalMoney() >= sOptThree && !(eTick >= 3)) {
					Money.setTotalMoney(Money.getTotalMoney() - sOptThree);
					eTick = 3;
				}
			}
		}
	}

	@Override
	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		// Get and draw the bitmaps into the defined rectangles
		Bitmap playSpaceShipGame = mGame.getAssetManager().getBitmap("Shop");
		graphics2D.clear(Color.BLACK);
		graphics2D.drawBitmap(playSpaceShipGame, null, mPlayBound, null);

		// Draws ticks to the shop items to show when they are bought
		Bitmap greenTick = mGame.getAssetManager().getBitmap("greenTick");

		if (fTick == 1) {
			graphics2D.drawBitmap(greenTick, null, mFuelEvent1, null);
		}
		if (fTick == 2) {
			graphics2D.drawBitmap(greenTick, null, mFuelEvent1, null);
			graphics2D.drawBitmap(greenTick, null, mFuelEvent2, null);
		}
		if (fTick == 3) {
			graphics2D.drawBitmap(greenTick, null, mFuelEvent1, null);
			graphics2D.drawBitmap(greenTick, null, mFuelEvent2, null);
			graphics2D.drawBitmap(greenTick, null, mFuelEvent3, null);
		}
		if (eTick == 1) {
			graphics2D.drawBitmap(greenTick, null, mEngineEvent1, null);
		}
		if (eTick == 2) {
			graphics2D.drawBitmap(greenTick, null, mEngineEvent1, null);
			graphics2D.drawBitmap(greenTick, null, mEngineEvent2, null);
		}
		if (eTick == 3) {
			graphics2D.drawBitmap(greenTick, null, mEngineEvent1, null);
			graphics2D.drawBitmap(greenTick, null, mEngineEvent2, null);
			graphics2D.drawBitmap(greenTick, null, mEngineEvent3, null);
		}

		// Paint is used to create the font for text to be drawn to the screen
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(80);
		graphics2D.drawText("" + Money.getTotalMoney(),
				(float) (mGame.getScreenWidth() / 1.3),
				mGame.getScreenHeight() / 12, paint);
	}
}