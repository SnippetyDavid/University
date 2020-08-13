package uk.co.takeabytestudios.rock_etout.game;

import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.game.gameScreens.RocketGameScreen;
import uk.co.takeabytestudios.rock_etout.world.Sprite;

public class Fuel extends Sprite {

	// Constructor

	/**
	 * This creates a fuel object to be collected in the game
	 * 
	 * @param startX
	 *            - X co-ordinates of the fuel object
	 * @param startY
	 *            - Y co-ordinates of the fuel object
	 * @param gameScreen
	 *            - Game screen of what this object belongs to
	 */
	public Fuel(float startX, float startY, RocketGameScreen gameScreen) {
		super(startX, startY, 15.0f, 25.0f, gameScreen.getGame()
				.getAssetManager().getBitmap("Fuel"), gameScreen);

		mBitmap = mGameScreen.getGame().getAssetManager().getBitmap("Fuel");

	}

	// Methods

	@Override
	public void update(ElapsedTime elapsedTime) {
	}
}