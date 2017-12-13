package uk.co.takeabytestudios.rock_etout.graphics;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * The graphics 2D interface defines the set of graphical operations that can be
 * applied to a render surface.
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public interface IGraphics2D {

	/**
	 * This method get the width of the render surface
	 * 
	 * @return - Width of the render surface
	 */
	public int getSurfaceWidth();

	/**
	 * This method get the height of the render surface
	 * 
	 * @return - Height of the render surface
	 */
	public int getSurfaceHeight();

	/**
	 * This method inserts the specified rectangular clip region
	 * 
	 * @param - clipRegion
	 */
	public void clipRect(Rect clipRegion);

	/**
	 * This method sets the surface colour to that specified colour (assumed to
	 * be in the same format as the Color class - ARGB).
	 * 
	 * @param colour
	 *            - ARGB formatted colour
	 */
	public void clear(int colour);

	/**
	 * This method draws the specified text string
	 * 
	 * @param text
	 *            - String of text to be rendered
	 * @param x
	 *            - Location of text on x-axis
	 * @param y
	 *            - Location of text on y-axis
	 * @param paint
	 *            - Paint parameters controlling text render format
	 */
	public void drawText(String text, float x, float y, Paint paint);

	/**
	 * This method draws the specified bitmap
	 * 
	 * @param bitmap
	 *            - Bitmap to be rendered
	 * @param srcRect
	 *            - Source region to be rendered (if null full source is
	 *            rendered)
	 * @param desRect
	 *            - Destination region for the render
	 * @param paint
	 *            - Paint parameters controlling how the bitmap is rendered
	 */
	public void drawBitmap(Bitmap bitmap, Rect srcRect, Rect desRect,
			Paint paint);

	/**
	 * This method draws the specified bitmap
	 * 
	 * @param bitmap
	 *            - Bitmap to be rendered
	 * @param matrix
	 *            - Matrix defining bitmap scaling, rotation, translation, etc.
	 * @param paint
	 *            - Paint parameters controlling how the bitmap is rendered
	 */
	public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint);
}