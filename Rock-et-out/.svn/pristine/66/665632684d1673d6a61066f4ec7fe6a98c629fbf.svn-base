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
import android.graphics.Rect;

/**
 * This class creates the Main Menu that is automatically loaded when the user
 * starts the game NB: The main menu screen was created by David Walsh by using
 * Photoshop
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class MenuScreen extends GameScreen {

	// Define the trigger touch region for the screen
	private Rect mPlayBound;
	// The buttons on the main menu
	private Rect mInstructionEvent;
	private Rect mShopEvent;
	private Rect mPlayEvent;
	private Rect mSettingsEvent;

	// Constructor
	/**
	 * Create a menu screen
	 * 
	 * @param game
	 *            - Game to which this screen belongs
	 */
	public MenuScreen(RocketOutFragment game) {
		super("MenuScreen", game);

		// Load in the bitmap used on the menu screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager.loadAndAddBitmap("MainMenu", "Images/Main Menu.jpg");

		// Define the rects what will be used to 'hold' the images
		int spacingX = (int) (game.getScreenWidth() / 2);
		int spacingY = (int) (game.getScreenHeight() / 2);
		mPlayBound = new Rect(0, 0, 2 * spacingX, 2 * spacingY);

		// Define the rects for the button events
		mPlayEvent = new Rect(
				(int) (game.getScreenWidth() / 27.69230769230769),
				(int) (game.getScreenHeight() / 1.837436932391524),
				(int) (game.getScreenWidth() / 0.743801652892562),
				(int) (game.getScreenHeight() / 1.460975609756098));
		mInstructionEvent = new Rect(
				(int) (game.getScreenWidth() / 27.69230769230769),
				(int) (game.getScreenHeight() / 1.436),
				(int) (game.getScreenWidth() / 0.743801652892562),
				(int) (game.getScreenHeight() / 1.196421336934504));
		mShopEvent = new Rect(
				(int) (game.getScreenWidth() / 27.69230769230769),
				(int) (game.getScreenHeight() / 1.16984126984127),
				(int) (game.getScreenWidth() / 0.743801652892562),
				(int) (game.getScreenHeight() / 1.021549053356282));
		mSettingsEvent = new Rect(
				(int) (game.getScreenWidth() / 1.153846153846154),
				(int) (game.getScreenHeight() / 384),
				(int) (game.getScreenWidth() / 1.004651162790698),
				(int) (game.getScreenHeight() / 12.30769230769231));
	}

	@Override
	public void update(ElapsedTime elapsedTime) {
		// Process any touch events occurring since the update
		Input input = mGame.getInput();

		List<TouchEvent> touchEvents = input.getTouchEvents();
		if (touchEvents.size() > 0) {
			// Just check the first touch event that occurred in the frame.
			// It means pressing the screen with several fingers may not trigger
			// a 'button'
			TouchEvent touchEvent = touchEvents.get(0);

			// Event for when play button is pressed
			if (mPlayEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the play game area has been touched then swap screens
				mGame.getScreenManager().removeScreen(this.getName());
				RocketGameScreen steeringDemoGameScreen = new RocketGameScreen(
						mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(steeringDemoGameScreen);
			}

			// Event for when how to play button is pressed
			if (mInstructionEvent.contains((int) touchEvent.x,
					(int) touchEvent.y)) {
				// If the how to play game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				InstructionScreen instructionScreen = new InstructionScreen(
						mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(instructionScreen);
			}

			// Event for when the shop button is pressed
			if (mShopEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the shop game area has been touched then swap screens
				mGame.getScreenManager().removeScreen(this.getName());
				ShopScreen shopScreen = new ShopScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(shopScreen);
			}

			// Event for when the settings button is pressed
			if (mSettingsEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the settings game area has been touched then swap screens
				mGame.getScreenManager().removeScreen(this.getName());
				SettingsScreen settingsScreen = new SettingsScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(settingsScreen);
			}
		}
	}

	@Override
	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		// Get and draw the bitmaps into the defined rectangles
		Bitmap playSpaceShipGame = mGame.getAssetManager()
				.getBitmap("MainMenu");
		graphics2D.clear(Color.BLACK);
		graphics2D.drawBitmap(playSpaceShipGame, null, mPlayBound, null);
	}
}