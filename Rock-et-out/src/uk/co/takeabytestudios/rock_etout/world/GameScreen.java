package uk.co.takeabytestudios.rock_etout.world;

import uk.co.takeabytestudios.rock_etout.RocketOutFragment;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.graphics.IGraphics2D;

/**
 * This Game screen class acts as a container for a coherent section of the game
 * (a level, configuration screen, etc.).
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public abstract class GameScreen {

	// Properties

	// Name that is given to this game screen
	protected final String mName;

	// Game to which game screen belongs
	protected final RocketOutFragment mGame;

	// Constructors

	/**
	 * Create a new game screen associated with the specified game instance
	 * 
	 * @param name
	 *            - name of this game screen
	 * @param game
	 *            - Game instance to which the game screen belongs
	 */
	public GameScreen(String name, RocketOutFragment game) {
		mName = name;
		mGame = game;
	}

	/**
	 * This method returns the name of this game screen
	 * 
	 * @return - Name of this game screen
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Return the game to which this game screen is attached
	 * 
	 * @return Game to which screen is attached
	 */
	public RocketOutFragment getGame() {
		return mGame;
	}

	// Update and Draw

	/**
	 * This method updates the game screen. Invoked automatically from the game.
	 * 
	 * NOTE: If the update is multi-threaded control should not be returned from
	 * the update call until all update processes have completed.
	 * 
	 * @param elapsedTime
	 *            - Elapsed time information for the frame
	 */
	public abstract void update(ElapsedTime elapsedTime);

	/**
	 * This method draws the game screen. Invoked automatically from the game.
	 * 
	 * @param elapsedTime
	 *            - Elapsed time information for the frame
	 * @param graphics2D
	 *            - Graphics instance used to draw the screen
	 */
	public abstract void draw(ElapsedTime elapsedTime, IGraphics2D graphics2D);

	// Android Life Cycle

	/**
	 * This method is invoked automatically by the game whenever the app is
	 * paused.
	 */
	public void pause() {
	}

	/**
	 * This method is invoked automatically by the game whenever the app is
	 * resumed.
	 */
	public void resume() {
	}

	/**
	 * This method is invoked automatically by the game whenever the app is
	 * disposed.
	 */
	public void dispose() {
	}
}