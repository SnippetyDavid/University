package uk.co.takeabytestudios.rock_etout.world;

import android.graphics.Rect;

/**
 * This class is the Screen viewport
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class ScreenViewport {

	// Properties

	// Left hand x-coordinate of the viewport
	public int left;

	// Top y-coordinate of the viewport
	public int top;

	// Right hand x-coordinate of the viewport
	public int right;

	// Bottom y-coordinate of the viewport
	public int bottom;

	// Width of the viewport
	public int width;

	// Height of the viewport
	public int height;

	// Private Rect representation of this viewport
	private Rect rect = new Rect();

	// Constructors and Methods

	/**
	 * Create a screen viewport with a default 480x320 resolution
	 */
	public ScreenViewport() {
		this.left = 0;
		this.top = 0;
		this.right = 320;
		this.bottom = 480;

		width = right - left;
		height = bottom - top;
	}

	/**
	 * Create a screen viewport of the specified dimensions
	 * 
	 * @param left
	 *            - Left hand x-coordinate of the viewport
	 * @param top
	 *            - Top y-coordinate of the viewport
	 * @param right
	 *            - Right hand x-coordinate of the viewport
	 * @param bottom
	 *            - Bottom y-coordinate of the viewport
	 */
	public ScreenViewport(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;

		width = right - left;
		height = bottom - top;
	}

	/**
	 * Set the viewport using the specified dimensions
	 * 
	 * @param left
	 *            - Left hand x-coordinate of the viewport
	 * @param top
	 *            - Top y-coordinate of the viewport
	 * @param right
	 *            - Right hand x-coordinate of the viewport
	 * @param bottom
	 *            - Bottom y-coordinate of the viewport
	 */
	public void set(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;

		width = right - left;
		height = bottom - top;
	}

	/**
	 * This method gets the centre x-location of the screen viewport
	 * 
	 * @return - centre x-location
	 */
	public final int centerX() {
		return (left + right) >> 1;
	}

	/**
	 * This method gets the centre y-location of the screen viewport
	 * 
	 * @return - centre y-location
	 */
	public final int centerY() {
		return (top + bottom) >> 1;
	}

	/**
	 * Determine if the viewport contains the specified point
	 * 
	 * @param x
	 *            - Test point x-coordinate
	 * @param y
	 *            - Test point y-coordinate
	 * @return - boolean true if the point is contained within the
	 *         viewport,otherwise false
	 */
	public boolean contains(int x, int y) {
		return left < right && top < bottom // check for empty first
				&& x >= left && x < right && y >= top && y < bottom;
	}

	/**
	 * This method determines if the viewport intersects with the specified rect
	 * region
	 * 
	 * @param left
	 *            - Left hand x-coordinate of the rect region
	 * @param top
	 *            - Top y-coordinate of the rect region
	 * @param right
	 *            - Right hand x-coordinate of the rect region
	 * @param bottom
	 *            - Bottom y-coordinate of the rect region
	 * @return boolean true if the rect is within the viewport, otherwise false
	 */
	public boolean contains(int left, int top, int right, int bottom) {
		return this.left < this.right && this.top < this.bottom
				&& this.left <= left && this.top <= top && this.right >= right
				&& this.bottom >= bottom;
	}

	/**
	 * This method returns a Rect representation of this viewport
	 * 
	 * @return - Rect representation of this viewport
	 */
	public Rect toRect() {
		rect.left = left;
		rect.right = right;
		rect.top = top;
		rect.bottom = bottom;
		return rect;
	}
}