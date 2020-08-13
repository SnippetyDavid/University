package uk.co.takeabytestudios.rock_etout.graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * This is a Graphics2D class that provides basic draw functionality for a
 * canvas.
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class CanvasGraphics2D implements IGraphics2D {

	// Methods: Properties

	// Canvas onto which this graphics instance will render
	private Canvas mCanvas;

	// Height and width of the canvas
	private int mWidth;
	private int mHeight;

	// Methods: Constructors
	/**
	 * CanvasGraphics2D constructor
	 * 
	 * @param assets
	 *            - the assets to be used
	 */
	public CanvasGraphics2D(AssetManager assets) {
	}

	// Methods: Draw

	/**
	 * This method sets the canvas onto which this graphics instance can render
	 * 
	 * @param canvas
	 *            - the canvas to render to
	 */
	public void setCanvas(Canvas canvas) {
		mCanvas = canvas;
		mWidth = canvas.getWidth();
		mHeight = canvas.getHeight();
	}

	@Override
	public void drawBitmap(Bitmap bitmap, Rect srcRect, Rect desRect,
			Paint paint) {
		mCanvas.drawBitmap(bitmap, srcRect, desRect, paint);
	}

	@Override
	public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
		mCanvas.drawBitmap(bitmap, matrix, paint);
	}

	@Override
	public void drawText(String text, float x, float y, Paint paint) {
		mCanvas.drawText(text, x, y, paint);
	}

	@Override
	public void clear(int color) {
		mCanvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
				(color & 0xff));
	}

	// Methods: Configuration
	@Override
	public void clipRect(Rect clipRegion) {
		mCanvas.clipRect(clipRegion);
	}

	@Override
	public int getSurfaceWidth() {
		return mWidth;
	}

	@Override
	public int getSurfaceHeight() {
		return mHeight;
	}
}