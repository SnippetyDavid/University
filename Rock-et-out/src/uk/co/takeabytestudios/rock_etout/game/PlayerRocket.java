package uk.co.takeabytestudios.rock_etout.game;

import java.util.ArrayList;

import uk.co.takeabytestudios.rock_etout.ai.SteeringBehaviours;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.input.Input;
import uk.co.takeabytestudios.rock_etout.util.Vector2;
import uk.co.takeabytestudios.rock_etout.world.GameScreen;
import uk.co.takeabytestudios.rock_etout.world.Sprite;
import android.graphics.Bitmap;

/**
 * This class creates a player controlled Rocket to represent the player in the
 * game
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class PlayerRocket extends Sprite {

	// Properties

	// Centre of the screen (used to determine the offset of touch events)
	private Vector2 screenCentre = new Vector2();

	// Acceleration vector based on the player's touch input
	private Vector2 playerTouchAcceleration = new Vector2();

	// start off with image0
	int imageNum = 0;

	private int mFuelLevel;

	private ArrayList<Bitmap> animationArray;

	// Constructor

	/**
	 * Create a player controlled rocket
	 * 
	 * @param startX
	 *            - x location of the player rocket
	 * @param startY
	 *            - y location of the player rocket
	 * @param gameScreen
	 *            - Game Screen to which rocket belongs
	 */
	public PlayerRocket(float startX, float startY, GameScreen gameScreen,
			int fuelLevel) {
		super(startX, startY, 50.0f, 50.0f, gameScreen.getGame()
				.getAssetManager().getBitmap("Rocket"), gameScreen);

		mFuelLevel = fuelLevel;
		// Store the centre of the screen
		screenCentre.x = gameScreen.getGame().getScreenWidth() / 2;
		screenCentre.y = gameScreen.getGame().getScreenHeight() / 2;

		// Define the maximum velocities and accelerations of the rocket
		maxAcceleration = 1000.0f;
		maxVelocity = 1000.0f;
		maxAngularVelocity = 1440.0f;
		maxAngularAcceleration = 1440.0f;

		animationArray = new ArrayList<Bitmap>();
		animationArray.add(0, mGameScreen.getGame().getAssetManager()
				.getBitmap("Rocket"));
		animationArray.add(1, mGameScreen.getGame().getAssetManager()
				.getBitmap("Rocket2"));
		animationArray.add(2, mGameScreen.getGame().getAssetManager()
				.getBitmap("Rocket3"));
		animationArray.add(3, mGameScreen.getGame().getAssetManager()
				.getBitmap("Rocket4"));
	}

	// Methods

	/**
	 * This rethod returns the fuel level of the rocket
	 * 
	 * @return - Fuel level of the rocket
	 */
	public int getFuelLevel() {
		return mFuelLevel;
	}

	/**
	 * This method sets a new fuel level for the rocket
	 * 
	 * @param mFuelLevel
	 *            - the new fuel level
	 */
	public void setFuelLevel(int mFuelLevel) {
		this.mFuelLevel = mFuelLevel;
	}

	@Override
	public void update(ElapsedTime elapsedTime) {
		// Animation Code
		animationChanger(animationArray);

		// Consider any touch events occurring since the update
		Input input = mGameScreen.getGame().getInput();

		if (input.existsTouch(0)) {
			// Get the primary touch event
			playerTouchAcceleration.x = (input.getTouchX(0) - screenCentre.x)
					/ screenCentre.x;
			playerTouchAcceleration.y = (screenCentre.y - input.getTouchY(0))
					/ screenCentre.y;
			// Invert the for y axis
			// Convert into an input acceleration
			acceleration.x = playerTouchAcceleration.x * maxAcceleration;
			acceleration.y = playerTouchAcceleration.y * maxAcceleration;
		}

		// Ensure that the rocket points in the direction of movement
		angularAcceleration = SteeringBehaviours.alignWithMovement(this);

		// Dampen the linear and angular acceleration and velocity
		angularAcceleration *= 0.95f;
		angularVelocity *= 0.75f;
		acceleration.multiply(0.75f);
		velocity.multiply(0.95f);

		// Apply the determined accelerations
		super.update(elapsedTime);
	}
}