package uk.co.takeabytestudios.rock_etout.game;

import uk.co.takeabytestudios.rock_etout.game.gameScreens.RocketGameScreen;
import uk.co.takeabytestudios.rock_etout.world.Sprite;

/**
 * This class creates a 'black hole' object that will randomly the level the
 * user is in when the player collides with it
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class BlackHole extends Sprite {

	// Constructor
	/**
	 * This creates a black hole object
	 * 
	 * @param startX
	 *            - X co-ordinate of the black hole
	 * @param startY
	 *            - Y co-ordinate of the black hole
	 * @param gameScreen
	 *            - game screen this object belongs to
	 */
	public BlackHole(float startX, float startY, RocketGameScreen gameScreen) {
		super(startX, startY, 30.0f, 35.0f, gameScreen.getGame()
				.getAssetManager().getBitmap("Hole"), gameScreen);

		mBitmap = mGameScreen.getGame().getAssetManager().getBitmap("Hole");
	}
}