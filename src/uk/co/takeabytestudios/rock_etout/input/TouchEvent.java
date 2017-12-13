package uk.co.takeabytestudios.rock_etout.input;

/**
 * This class is used for Touch event behaviours.
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class TouchEvent {

	// Touch event constants
	public static final int TOUCH_DOWN = 0;
	public static final int TOUCH_UP = 1;
	public static final int TOUCH_DRAGGED = 2;

	// Type of touch event that has occurred (TOUCH_DOWN, TOUCH_UP,
	// TOUCH_DRAGGED)
	public int type;

	// Screen position (pixel) at which the touch event occurred.
	public float x, y;

	// Pointer ID associated with this touch event
	public int pointer;
}