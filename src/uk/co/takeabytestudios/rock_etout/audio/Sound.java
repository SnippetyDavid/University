package uk.co.takeabytestudios.rock_etout.audio;

import android.media.SoundPool;

/**
 * This class is used to play sound effects within our game. This class was not
 * used since it caused us issues with playing back sound effects. In the end we
 * ended up using the Music.java class for our sounds
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class Sound {

	// Properties

	// Maximum number of sounds that can be played concurrently
	public static final int MAX_CONCURRENT_SOUNDS = 20;

	// Sound Id of this effect
	private int mSoundId;

	// Sound pool containing this sound effect
	private SoundPool mSoundPool;

	// Play back volume of this sound effect
	private float mVolume;

	// Constructors
	/**
	 * Create a new sound effect
	 * 
	 * @param soundPool
	 *            - Sound pool to which this effect belongs
	 * @param soundId
	 *            - Id of this effect within the sound pool
	 */
	public Sound(SoundPool soundPool, int soundId) {
		// Store the parameters and assume a default playback volume
		mSoundId = soundId;
		mSoundPool = soundPool;
		mVolume = 1.0f;
	}

	// Methods

	/**
	 * This method plays the sound effect
	 */
	public void play() {
		mSoundPool.play(mSoundId, mVolume, mVolume, 0, 0, 1);
	}

	/**
	 * This method plays the sound effect with a playback volume that is set
	 * 
	 * @param volume
	 *            - Play back volume (0-1)
	 */
	public void play(float volume) {
		mSoundPool.play(mSoundId, volume, volume, 0, 0, 1);
	}

	/**
	 * This method plays the sound effect with volume set for both the left and
	 * right speakers
	 * 
	 * @param leftVolume
	 *            - Left channel play back volume (0-1)
	 * @param rightVolume
	 *            - Right channel play back volume (0-1)
	 */
	public void play(float leftVolume, float rightVolume) {
		mSoundPool.play(mSoundId, leftVolume, rightVolume, 0, 0, 1);
	}

	/**
	 * This method sets the default play back volume
	 * 
	 * @param volume
	 */
	public void setVolume(float volume) {
		mVolume = volume;
	}

	/**
	 * This method disposes of the sound effect
	 */
	public void dispose() {
		mSoundPool.unload(mSoundId);
	}

	/**
	 * This method stops the sound effect.
	 */
	public void stop() {
		mSoundPool.autoPause();
	}
}