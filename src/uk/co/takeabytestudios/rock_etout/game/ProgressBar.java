package uk.co.takeabytestudios.rock_etout.game;

import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.game.gameScreens.RocketGameScreen;
import uk.co.takeabytestudios.rock_etout.graphics.IGraphics2D;
import uk.co.takeabytestudios.rock_etout.world.Sprite;
import android.graphics.Rect;

/**
 * This class creates a progress bar that is used to represent the fuel level
 * within the game
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class ProgressBar extends Sprite {

	protected Rect mRect;
	protected int width, height;
	protected RocketGameScreen hGameScreen;

	// Constructor

	/**
	 * Creates a progress bar that is displayed in the game for fuel level
	 * 
	 * @param startX
	 *            - the X co-ordinate of the progress bar
	 * @param startY
	 *            - the Y co-ordinate of the progress bar
	 * @param gameScreen
	 *            - the game screen to which this progress bar belongs to
	 */
	public ProgressBar(float startX, float startY, RocketGameScreen gameScreen) {
		super(startX, startY, 30.0f, 4.0f, gameScreen.getGame()
				.getAssetManager().getBitmap("Probar"), gameScreen);

		mBitmap = mGameScreen.getGame().getAssetManager().getBitmap("Probar");
		mRect = new Rect(100, 0, gameScreen.getPlayerRocket().getFuelLevel(),
				50);
		width = mBitmap.getWidth();
		height = mBitmap.getHeight();
		hGameScreen = gameScreen;
	}

	// Methods

	@Override
	public void update(ElapsedTime elapsedTime) {
		mRect.set(0, 0, width = hGameScreen.getPlayerRocket().getFuelLevel(),
				50);
		drawScreenRect.set(mRect);
		super.update(elapsedTime);
	}

	public void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D) {
		graphics2D.drawBitmap(mBitmap, drawSourceRect, mRect, null);
	}
}