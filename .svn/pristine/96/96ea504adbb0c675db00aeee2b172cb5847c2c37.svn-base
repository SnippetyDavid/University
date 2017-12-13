package uk.co.takeabytestudios.rock_etout.input;

import java.util.List;

import android.content.Context;
import android.view.View;

/**
 * This class is used for the Touch input support
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class Input {

	// Define the touch handler that is responsible for managing the different
	// types of touch input
	private TouchHandler mTouchHandler;

	// Constructor
	/**
	 * Create a new input manager for the specified content view
	 * 
	 * @param context
	 *            - Context within which this handler will operate
	 * @param view
	 *            - View that this handler will collect input from
	 */
	public Input(Context context, View view) {
		mTouchHandler = new TouchHandler(view);
	}

	// Touch Input Events

	/**
	 * This method determines if there is an ongoing touch event for the
	 * specified pointer ID
	 * 
	 * @param pointerId
	 *            - Touch pointer ID to test for
	 * @return - true if there is an ongoing touch event, otherwise false
	 */
	public boolean existsTouch(int pointerId) {
		return mTouchHandler.existsTouch(pointerId);
	}

	/**
	 * This method gets the x-coordinate for the specified pointer ID. A value
	 * of Float.NaN is returned if the pointer ID does not exist
	 * 
	 * @param pointerId
	 *            - Touch pointer ID to retrieve
	 * @return - x touch location
	 */
	public float getTouchX(int pointerId) {
		return mTouchHandler.getTouchX(pointerId);
	}

	/**
	 * Get the y-coordinate for the specified pointer ID. A value of Float.NaN
	 * is returned if the pointer ID does not exist
	 * 
	 * @param pointerId
	 *            - Touch pointer ID to retrieve
	 * @return y touch location
	 */
	public float getTouchY(int pointerId) {
		return mTouchHandler.getTouchY(pointerId);
	}

	/**
	 * This method returns a list of captured touch events occurring for this
	 * update tick.
	 * 
	 * @return List of captured touch events
	 */
	public List<TouchEvent> getTouchEvents() {
		return mTouchHandler.getTouchEvents();
	}

	// Support Methods

	/**
	 * Reset the touch accumulator so that all touch events accumulated since
	 * the last accumulator reset are now returned through the getTouchEvents()
	 * method.
	 * 
	 * This method should be invoked once per update tick (ideally as part the
	 * standard game loop's update actions).
	 */
	public void resetAccumulators() {
		mTouchHandler.resetAccumulator();
	}
}