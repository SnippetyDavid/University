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
 * This class creates the instruction screen for the game when the player
 * selects how to play from the main menu NB: The instruction screen was created
 * by David Walsh by using Photoshop
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class InstructionScreen extends GameScreen {

	// Define the trigger touch region for the screen
	private Rect mPlayBound;
	// The button for going back to the main menu
	private Rect mBackEvent;

	// Constructor

	/**
	 * Create an Instruction screen
	 * 
	 * @param game
	 *            - Game to which this screen belongs
	 */
	public InstructionScreen(RocketOutFragment game) {
		super("InstructionScreen", game);

		// Load in the bitmap used on the Instruction screen
		AssetStore assetManager = mGame.getAssetManager();
		assetManager
				.loadAndAddBitmap("Instructions", "Images/Instructions.jpg");

		// Define the rects what will be used to 'hold' the images
		int spacingX = (int) (game.getScreenWidth() / 2);
		int spacingY = (int) (game.getScreenHeight() / 2);
		mPlayBound = new Rect(0, 0, 2 * spacingX, 2 * spacingY);
		// Define the rect for button events
		mBackEvent = new Rect(
				(int) (game.getScreenWidth() / 51.42857142857143),
				(int) (game.getScreenHeight() / 83.47826086956522),
				(int) (game.getScreenWidth() / 3.059490084985836),
				(int) (game.getScreenHeight() / 8.421052631578947));
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

			// Event for when back button is pressed
			if (mBackEvent.contains((int) touchEvent.x, (int) touchEvent.y)) {
				// If the back button game area has been touched then swap
				// screens
				mGame.getScreenManager().removeScreen(this.getName());
				MenuScreen menuScreen = new MenuScreen(mGame);
				// As it's the only added screen it will become active.
				mGame.getScreenManager().addScreen(menuScreen);
			}
		}
	}

	@Override
	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		// Get and draw the bitmaps into the defined rectangles
		Bitmap playSpaceShipGame = mGame.getAssetManager().getBitmap(
				"Instructions");
		graphics2D.clear(Color.BLACK);
		graphics2D.drawBitmap(playSpaceShipGame, null, mPlayBound, null);
	}
}