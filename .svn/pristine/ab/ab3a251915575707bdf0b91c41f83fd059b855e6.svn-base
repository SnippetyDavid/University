package uk.co.takeabytestudios.rock_etout.ai;

import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.game.gameScreens.RocketGameScreen;
import uk.co.takeabytestudios.rock_etout.util.Vector2;
import uk.co.takeabytestudios.rock_etout.world.Sprite;
import android.graphics.Bitmap;

/**
 * Class used to define the behaviours of the AI Objects
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class AIObjects extends Sprite {

	// Properties
	private float width = mGameScreen.getGame().getScreenWidth();

	// AI control behaviour
	public enum AIBehaviour {
		Helicopter, Fireball, Comet, AlienSpaceship, Aeroplane
	}

	private AIBehaviour mAIBehaviour;

	// Distance at which the spaceship should avoid other game objects
	private float separateThresholdShip = 75.0f;

	// Accumulators used to build up the net steering outcome
	private Vector2 accAccumulator = new Vector2();
	private Vector2 accComponent = new Vector2();

	// Constructors
	/**
	 * Create a AI controlled object
	 * 
	 * @param startX
	 *            - x location of the AI spaceship
	 * @param startY
	 *            - y location of the AI spaceship
	 * @param shipBehaviour
	 *            - Steering behaviour to be used by the AI ship
	 * @param gameScreen
	 *            - Gamescreen to which AI belongs
	 */
	public AIObjects(float startX, float startY, float width, float height,
			AIBehaviour aiBehaviour, RocketGameScreen gameScreen, Bitmap aBitmap) {
		super(startX, startY, width, height, aBitmap, gameScreen);

		mAIBehaviour = aiBehaviour;

		// determines the behaviours for the different AI
		switch (mAIBehaviour) {
		case Helicopter:
			maxAcceleration = 30.0f;
			maxVelocity = 50.0f;
			maxAngularVelocity = 150.0f;
			maxAngularAcceleration = 300.0f;
			break;

		case Fireball:
			maxAcceleration = 50.0f;
			maxVelocity = 100.0f;
			maxAngularVelocity = 0;
			break;

		case Aeroplane:
			maxAcceleration = 25.0f;
			maxVelocity = 50.0f;
			maxAngularVelocity = 0;
			break;

		case AlienSpaceship:
			maxAcceleration = 50.0f;
			maxVelocity = 80.0f;
			maxAngularVelocity = 200.0f;
			maxAngularAcceleration = 300.0f;
			break;

		case Comet:
			maxAcceleration = 50.0f;
			maxVelocity = 100.0f;
			maxAngularVelocity = 100.0f;
			maxAngularAcceleration = 50.0f;
			break;
		default:
			break;
		}
	}

	// Methods

	@Override
	public void update(ElapsedTime elapsedTime) {

		switch (mAIBehaviour) {
		case Helicopter:
			// Seek towards the player
			SteeringBehaviours
					.seek(this,
							((RocketGameScreen) mGameScreen).getPlayerRocket().position,
							acceleration);
			// Try to avoid a collision with the other helicopters
			SteeringBehaviours.separate(this,
					((RocketGameScreen) mGameScreen).getAIHelicopters(),
					separateThresholdShip, 1.0f, accComponent);
			accAccumulator.add(accComponent);

			// If we are trying to avoid a collision then combine it with the
			// seek behaviour,
			// placing more emphasis on avoiding the collision.
			if (!accAccumulator.isZero()) {
				acceleration.x = 0.3f * acceleration.x + 0.7f
						* accAccumulator.x;
				acceleration.y = 0.3f * acceleration.y + 0.7f
						* accAccumulator.y;
			}
			// Make sure we point in the direction of travel.
			angularAcceleration = SteeringBehaviours.alignWithMovement(this);
			break;

		case Fireball:
			// Fall straight down from the top of the screen
			SteeringBehaviours.seek(this, new Vector2(position.x, 0),
					acceleration);
			break;

		case Aeroplane:
			// Head directly to the left side of the screen
			SteeringBehaviours.seek(this, new Vector2(width, position.y),
					acceleration);
			break;

		case AlienSpaceship:
			// Seek towards the player
			SteeringBehaviours
					.seek(this,
							((RocketGameScreen) mGameScreen).getPlayerRocket().position,
							acceleration);
			// Try to avoid a collision with the other spaceships
			SteeringBehaviours.separate(this,
					((RocketGameScreen) mGameScreen).getAIHelicopters(),
					separateThresholdShip, 1.0f, accComponent);
			accAccumulator.add(accComponent);
			// If we are trying to avoid a collision then combine
			// it with the seek behaviour, placing more emphasis on avoiding the
			// collision.
			if (!accAccumulator.isZero()) {
				acceleration.x = 0.3f * acceleration.x + 0.7f
						* accAccumulator.x;
				acceleration.y = 0.3f * acceleration.y + 0.7f
						* accAccumulator.y;
			}
			// Make sure we point in the direction of travel.
			angularAcceleration = SteeringBehaviours.alignWithMovement(this);
			break;

		case Comet:
			// Head directly to the origin
			SteeringBehaviours.seek(this, new Vector2(0, 0), acceleration);
			break;

		default:
			break;
		}

		// Call the sprite's superclass to apply the determine accelerations
		super.update(elapsedTime);
	}
}