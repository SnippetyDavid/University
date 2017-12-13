package uk.co.takeabytestudios.rock_etout.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * This class is used for animation, however we have found an easier method to
 * include animation. This class has been left as a reference
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class Animation {
	// Animation Properties

	// Bitmap holding the frames of this animation
	private Bitmap animationFrames;

	// Width and height of each frame of the animation
	private int frameWidth;
	private int frameHeight;

	// Number of frames in the animation
	private int frameCount;

	// Index of the current frame of animation
	private int currentFrame;

	// Display period for each frame alongside a frame timer
	private double frameTimer;
	private double framePeriod;

	// Boolean flag determining if the animation should loop
	private boolean isLooping = false;

	// Boolean flag determining if the animation is currently playing
	private boolean isPlaying = false;

	// Animation Constructor and Methods

	/**
	 * Create a new animation
	 * 
	 * @param animationFrames
	 *            - Bitmap holding the frames of the animation
	 * @param frameCount
	 *            - Number of horizontal frames in the animation (assumed to be
	 *            of equal width)
	 */
	public Animation(Bitmap animationFrames, int frameCount) {
		this.animationFrames = animationFrames;
		this.frameCount = frameCount;

		frameHeight = animationFrames.getHeight();
		frameWidth = animationFrames.getWidth() / frameCount;
	}

	/**
	 * This method returns the animation frames for a bitmap
	 * 
	 * @return - the animation frames
	 */
	public Bitmap getBitmap() {
		return animationFrames;
	}

	/**
	 * This method triggers the playback of this animation
	 * 
	 * @param animationPeriod
	 *            - Period over which the animation should play
	 * @param loop
	 *            - True if the animation should play repeatedly
	 */
	public void play(double animationPeriod, boolean loop) {
		framePeriod = animationPeriod / (double) frameCount;
		currentFrame = -1;
		isLooping = loop;
		isPlaying = true;
	}

	/**
	 * This method updates which frame of the animation should be displayed
	 * 
	 * @param elapsedTime
	 *            - Elapsed time since the last update
	 */
	public void update(double elapsedTime) {
		if (!isPlaying) {
			return;
		}

		// If this is the first time update has been called since the
		// play method was called then reset the current frame and timer
		if (currentFrame == -1) {
			currentFrame = 0;
			frameTimer = 0.0;
		}

		// Update the amount of time accumulated against this frame
		frameTimer += elapsedTime;

		// If the frame display duration has been exceeded then try to
		// go on to the next frame, looping or stopping if the end of
		// the animation has been reached.
		if (frameTimer >= framePeriod) {
			currentFrame++;
			if (currentFrame >= frameCount) {
				if (isLooping) {
					currentFrame = 0;
				} else {
					currentFrame = frameCount - 1;
					isPlaying = false;
				}
			}
			// 'Reset' the frame timer
			frameTimer -= framePeriod;
		}
	}

	/**
	 * This method updates the specified rect object to contain the region of
	 * the bitmap holding the current frame of animation.
	 * 
	 * @param sourceRect
	 *            - Rect object to be updated
	 */
	public void getSourceRect(Rect sourceRect) {
		if (currentFrame >= 0) {
			sourceRect.set(currentFrame * frameWidth, 0, currentFrame
					* frameWidth + frameWidth, frameHeight);
		}
	}
}