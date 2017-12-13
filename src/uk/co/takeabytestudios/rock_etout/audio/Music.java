package uk.co.takeabytestudios.rock_etout.audio;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;

/**
 * This class is used for playing music within our game
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class Music implements OnCompletionListener {

	// Properties

	// Media player that will be used to playback this music clip
	private MediaPlayer mMediaPlayer;

	// Flag indicating if playback can commence
	private boolean mIsPrepared = false;

	// Asset filename
	private String mAssetFile;

	// Constructors

	/**
	 * This constructor creates a new music clip
	 * 
	 * @param assetDescriptor
	 *            - Asset descriptor linked to this audio file
	 */
	public Music(AssetFileDescriptor assetDescriptor) {
		mAssetFile = assetDescriptor.getFileDescriptor().toString();

		// Create a new play player linked to the specified music asset
		mMediaPlayer = new MediaPlayer();
		try {
			// Link the data source
			mMediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
					assetDescriptor.getStartOffset(),
					assetDescriptor.getLength());

			// Prep the audio for playback
			mMediaPlayer.prepare();
			mIsPrepared = true;

			// Add an on completion listener for the clip
			mMediaPlayer.setOnCompletionListener(this);
		} catch (IOException e) {
			String errorTag = "RocketOut Error:";
			String errorMessage = "Music clip " + mAssetFile
					+ " cannot be loaded.";
			Log.w(errorTag, errorMessage);
		}
	}

	// Methods

	/**
	 * This method plays the music clip. Note: If the music clip is already
	 * playing, the play request is ignored.
	 */
	public void play() {
		if (mMediaPlayer.isPlaying()) {
			return;
		}
		try {
			synchronized (this) {
				// Start the clip, preparing it if needed
				if (!mIsPrepared)
					mMediaPlayer.prepare();
				mMediaPlayer.start();
			}
		} catch (Exception e) {
			// Either IllegalStateException or IOException
			String errorTag = "RocketOut Error:";
			String errorMessage = "Music clip " + mAssetFile
					+ " cannot be played.";
			Log.w(errorTag, errorMessage);
		}
	}

	/**
	 * Stop the music clip.
	 */
	public void stop() {
		mMediaPlayer.stop();
		synchronized (this) {
			mIsPrepared = false;
		}
	}

	/**
	 * This method pauses the music clip.
	 */
	public void pause() {
		if (mMediaPlayer.isPlaying())
			mMediaPlayer.pause();
	}

	/**
	 * This method determines if the music clip will loop
	 * 
	 * @param looping
	 *            - Boolean true to loop, false for play once.
	 */
	public void setLooping(boolean looping) {
		mMediaPlayer.setLooping(looping);
	}

	/**
	 * This method sets the playback volume
	 * 
	 * @param volume
	 *            - Playback volume (0-1)
	 */
	public void setVolume(float volume) {
		mMediaPlayer.setVolume(volume, volume);
	}

	/**
	 * This method sets the playback volume for both the right and left speaker
	 * 
	 * @param leftVolume
	 *            - Left channel playback volume (0-1)
	 * @param rightVolume
	 *            - Right channel playback volume (0-1)
	 */
	public void setVolume(float leftVolume, float rightVolume) {
		mMediaPlayer.setVolume(leftVolume, rightVolume);
	}

	/**
	 * This method determines if the music clip is currently playing
	 * 
	 * @return Boolean true if the music clip is currently playing, otherwise
	 *         false
	 */
	public boolean isPlaying() {
		return mMediaPlayer.isPlaying();
	}

	/**
	 * This method determines if the music clip is set to loop
	 * 
	 * @return Boolean true if the clip is looping, otherwise false
	 */
	public boolean isLooping() {
		return mMediaPlayer.isLooping();
	}

	/**
	 * This method disposes of the music clip
	 */
	public void dispose() {
		if (mMediaPlayer.isPlaying()) {
			mMediaPlayer.stop();
		}
		mMediaPlayer.release();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.media.MediaPlayer.OnCompletionListener#onCompletion(android.media
	 * .MediaPlayer)
	 */
	public void onCompletion(MediaPlayer player) {
		synchronized (this) {
			mIsPrepared = false;
		}
	}
}