package uk.co.takeabytestudios.rock_etout;

import uk.co.takeabytestudios.rock_etout.engine.AssetStore;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import uk.co.takeabytestudios.rock_etout.engine.ScreenManager;
import uk.co.takeabytestudios.rock_etout.game.Money;
import uk.co.takeabytestudios.rock_etout.game.gameScreens.GameOverScreen;
import uk.co.takeabytestudios.rock_etout.game.gameScreens.ShopScreen;
import uk.co.takeabytestudios.rock_etout.graphics.CanvasRenderSurface;
import uk.co.takeabytestudios.rock_etout.graphics.IRenderSurface;
import uk.co.takeabytestudios.rock_etout.input.Input;
import uk.co.takeabytestudios.rock_etout.io.FileIO;
import uk.co.takeabytestudios.rock_etout.world.GameScreen;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This is the central game class, providing access to core game services and
 * management of the update/render cycle. NB: The save and load idea for the
 * game using Shared Preferences was derived from an answer on stack overflow
 * that we found: This is the original question here:
 * http://stackoverflow.com/questions
 * /12231064/how-to-store-and-read-an-integer-in-internal-storage
 * 
 * @authors Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public abstract class RocketOutFragment extends Fragment {

	// Properties: Frames per Second

	// Variable used to record the target number of update/draw iterations in a
	// one second interval. The game thread will sleep between iterations if
	// possible.
	private int mTargetFramesPerSecond = 5;

	/**
	 * This method gets the target number of frames per second
	 * 
	 * @return - Target number of frames per second
	 */
	public int getTargetFramesPerSecond() {
		return mTargetFramesPerSecond;
	}

	/**
	 * This method sets the target number of frames per second
	 * 
	 * @param targetFramesPerSecond
	 *            - the new target number of frames per second
	 */
	public void setTargetFramesPerSecond(int targetFramesPerSecond) {
		mTargetFramesPerSecond = targetFramesPerSecond;

		// Update the target update/draw period in the game thread (which is
		// stored in ns)
		if (mLoop != null) {
			mLoop.targetStepPeriod = 1000000000 / targetFramesPerSecond;
		}
	}

	// Average number of frames per second that is being achieved
	private float mAverageFramesPerSecond;

	/**
	 * This method gets the average number of frames per second that is being
	 * achieved
	 * 
	 * @return - Average number of frames per second that is being achieved
	 */
	public float getAverageFramesPerSecond() {
		return mAverageFramesPerSecond;
	}

	// Properties: Managers and Services

	// Asset Manager
	protected AssetStore mAssetManager;

	/**
	 * This method gets the game's asset manager
	 * 
	 * @return - Asset manager
	 */
	public AssetStore getAssetManager() {
		return mAssetManager;
	}

	// Screen Manager
	protected ScreenManager mScreenManager;

	/**
	 * This method gets the game's screen manager
	 * 
	 * @return Asset manager
	 */
	public ScreenManager getScreenManager() {
		return mScreenManager;
	}

	// Input Service
	protected Input mInput;

	/**
	 * This method gets the game's input service
	 * 
	 * @return - Input service
	 */
	public Input getInput() {
		return mInput;
	}

	// File IO Service
	protected FileIO mFileIO;

	/**
	 * This method gets the game's file IO service
	 * 
	 * @return - File IO service
	 */
	public FileIO getFileIO() {
		return mFileIO;
	}

	// Render Surface
	protected IRenderSurface mRenderSurface;

	// Properties: Game Loop

	// Game loop thread
	private GameLoop mLoop;

	// Properties: Screen Size

	// Width of the game window in pixels
	private int mScreenWidth = -1;

	/**
	 * This method gets the width of the game window
	 * 
	 * @return - Width of the game window
	 */
	public int getScreenWidth() {
		return mScreenWidth;
	}

	// Height of the game window in pixels
	private int mScreenHeight = -1;

	/**
	 * This method gets the height of the game window
	 * 
	 * @return - Height of the game window
	 */
	public int getScreenHeight() {
		return mScreenHeight;
	}

	// Methods: State Management

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create a new game loop
		mLoop = new GameLoop();

		// Manager/Service Creation : None-view/context dependent

		// Create the file IO service
		mFileIO = new FileIO(getActivity().getApplicationContext());

		// Create the asset manager
		mAssetManager = new AssetStore(mFileIO);

		// Create the screen manager
		mScreenManager = new ScreenManager();

		// loading in music so game knows they exist when back is pressed
		// GameMusic taken from Sonic Generations, Explosion and Launch taken from soundbible
		mAssetManager.loadAndAddMusic("GameMusic", "Audio/GameMusic.mp3");
		mAssetManager.loadAndAddMusic("Explosion", "Sfx/Explosion.mp3");
		mAssetManager.loadAndAddMusic("Launch", "Sfx/Launch.mp3");
		// loads the game with the previous data when the game starts
		load();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Manager/Service Creation : View/context dependent

		// Create the output view and associated renderer
		mRenderSurface = new CanvasRenderSurface(this, getActivity());
		View view = mRenderSurface.getAsView();

		// Get our input from the created view
		mInput = new Input(getActivity(), view);

		// Store the size of the window we're using
		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metrics);
		mScreenWidth = metrics.widthPixels;
		mScreenHeight = metrics.heightPixels;

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();

		// Start the audio playback whenever the fragment is resumed

		// If needed, resume the current game screen
		if (mScreenManager.getCurrentScreen() != null)
			mScreenManager.getCurrentScreen().resume();

		// Resume the game loop
		mLoop.resume();
	}

	@Override
	public void onPause() {
		super.onPause();

		// Pause/release the audio whenever the fragment is paused/deleted
		mAssetManager.getMusic("GameMusic").pause();
		// Pause the game loop
		mLoop.pause();

		// If needed, pause the current game screen
		if (mScreenManager.getCurrentScreen() != null)
			mScreenManager.getCurrentScreen().pause();

		super.onPause();
	}

	@Override
	public void onDestroy() {
		// Dispose of any game screens
		mAssetManager.getMusic("GameMusic").stop();
		mScreenManager.dispose();

		super.onDestroy();
	}

	/**
	 * This method is called from the activity whenever the back key has been
	 * pressed.
	 * 
	 * @return True if the back event has been consumed by the game, false
	 *         otherwise.
	 */
	public boolean onBackPressed() {
		mAssetManager.getMusic("GameMusic").stop();
		mAssetManager.getMusic("Launch").stop();
		mAssetManager.getMusic("Explosion").stop();
		// Stop method does not work for the stop method in the sound class
		return false;
	}

	// Methods: Update and Draw

	// To best exploit the multi-threaded nature of current CPUs, a planning
	// phase could be added here
	// - invoked currently with the draw phase within the game loop. Given this
	// structure the update phase
	// is reduced to swapping the world from state n to state n+1.
	// public void doPrep(ElapsedTime elapsedTime) { }

	/**
	 * This method performs the update step
	 * 
	 * @param elapsedTime
	 *            - Elapsed time information for the current frame
	 */
	private void doUpdate(ElapsedTime elapsedTime) {
		// Reset accumulators for keys/touch events for the current frame
		((Input) mInput).resetAccumulators();

		// Get and update the current game screen
		GameScreen gameScreen = mScreenManager.getCurrentScreen();
		if (gameScreen != null)
			gameScreen.update(elapsedTime);

		// It is assumed that if the update is multi-threaded then the
		// method call will not return until all update processes have
		// completed. Once this happens, notify the game loop.
		notifyUpdateCompleted();
	}

	/**
	 * This method notifies the game loop that the update has completed. This
	 * method is in invoked automatically once control has returned from the
	 * Game update() method.
	 */
	public void notifyUpdateCompleted() {
		mLoop.notifyUpdateCompleted();
	}

	/**
	 * This method performs the draw step
	 * 
	 * @param elapsedTime
	 *            - Elapsed time information for the current frame
	 */
	private void doDraw(ElapsedTime elapsedTime) {
		// Get and draw the current screen. The render surface will
		// invoked Game.notifyDrawCompleted when the draw is done.
		GameScreen gameScreen = mScreenManager.getCurrentScreen();
		if (gameScreen != null) {
			mRenderSurface.render(elapsedTime, gameScreen);
		}
	}

	/**
	 * This method notifies the game loop that the draw has completed. This
	 * method is in invoked automatically by the render surface when the draw
	 * has completed.
	 */
	public void notifyDrawCompleted() {
		mLoop.notifyDrawCompleted();
	}

	// Game Loop

	/**
	 * This is the Core game loop thread
	 */
	private class GameLoop implements Runnable {
		// Properties

		/**
		 * Concurrent boolean lock that can be used to control update and draw
		 * inter-thread sequencing.
		 */
		class BooleanLock {
			boolean isLocked;

			public BooleanLock(boolean isLocked) {
				this.isLocked = isLocked;
			}
		}

		// Sequence locks for the update and draw steps
		volatile BooleanLock update;
		volatile BooleanLock draw;

		// Thread on which the game loop will run
		Thread renderThread = null;

		// Flag determining if the update/draw thread is running
		volatile boolean running = false;

		ElapsedTime elapsedTime;

		// Variable holding the duration (in ns) of the target game step period.
		// Changes to the Game's mTargetUpdatesPerSecond will change this value.
		long targetStepPeriod;

		// Because an update/draw might load a lot of graphics, etc. a maximum
		// step period is introduced to provide a ceiling on the maximum step
		// size that will be reported
		// to game objects (guarding them against the need to check for
		// abnormally long frames). By
		// default, a value of three times the target step period is assumed.
		double maximumStepPeriodScale = 3.0f;

		// Constructor

		/**
		 * Create a new game loop (the update/draw process will not commence
		 * until the run method is executed).
		 */
		public GameLoop() {
			// Setup the target step period
			targetStepPeriod = 1000000000 / mTargetFramesPerSecond;
			// Create a new time structure
			elapsedTime = new ElapsedTime();
			// Create update and draw locks
			update = new BooleanLock(false);
			draw = new BooleanLock(false);
		}

		// Methods: Update/Draw Loop

		/**
		 * Start the update/draw process within a new thread.
		 * 
		 * A relatively simple approach is employed that can support basic
		 * multi-threading. A more sophisticated threaded approach might adopt a
		 * three-phase prep-update-draw approach where the prep of frame n+1
		 * occurs concurrently (across one or more threads) whilst the draw of
		 * frame n executes. A more sophisticated timing approach might decouple
		 * the draw and render phases, skipping the render of a frame if needed
		 * to maintain a target update rate.
		 */
		@Override
		public void run() {
			// Ensure that we have a game screen available to update and render
			if (mScreenManager.getCurrentScreen() == null) {
				String errorTag = getActivity().getResources().getString(
						R.string.ERROR_TAG);
				String errorMessage = "You need to add a game screen to the screen mananger.";
				Log.e(errorTag, errorMessage);
				throw new RuntimeException(errorTag + errorMessage);
			}

			/**
			 * Define variables which will be used to provide timing information
			 * to enable precise control of the update/render cycle.
			 * 
			 * startRun records the time at which the first iteration commenced
			 * and is used to track total run time.
			 * 
			 * The startStep and endStep variables record the time before and
			 * time immediately after the update/render step.
			 * 
			 * sleepTime records how long the thread should sleep before it is
			 * necessary to start on the next update/render cycle (this may be a
			 * negative period - i.e. the update/render process took longer than
			 * desired). overSleepTime records how much longer the thread sleep
			 * than was originally requested (i.e. accounting for the
			 * unpredictable delay in waking up the thread).
			 */
			long startRun;
			long startStep, endStep;
			long sleepTime, overSleepTime;

			/**
			 * Define default starting values. The startTime and postRender
			 * times are set to one frame 'in the past' to avoid near zero
			 * timings for the first iteration. overSleepTime is set to zero.
			 */
			startRun = System.nanoTime() - targetStepPeriod;
			startStep = startRun;
			overSleepTime = 0L;

			try {
				while (running) {
					// Update the timing information
					long currentTime = System.nanoTime();
					elapsedTime.totalTime = (currentTime - startRun) / 1000000000.0;
					elapsedTime.stepTime = (currentTime - startStep) / 1000000000.0;
					startStep = currentTime;

					// Weighted average update of the average number of frames
					// per second
					mAverageFramesPerSecond = 0.85f * mAverageFramesPerSecond
							+ 0.15f * (1.0f / (float) elapsedTime.stepTime);

					// If needed ensure the reported step time is not abnormally
					// large
					if (elapsedTime.stepTime > (targetStepPeriod / 1000000000.0)
							* maximumStepPeriodScale)
						elapsedTime.stepTime = (targetStepPeriod / 1000000000.0)
								* maximumStepPeriodScale;

					// Trigger an update
					synchronized (update) {
						update.isLocked = true;
					}
					doUpdate(elapsedTime);
					// Wait for the update to complete before progressing
					synchronized (update) {
						if (update.isLocked) {
							update.wait();
						}
					}

					// Trigger a draw request
					synchronized (draw) {
						draw.isLocked = true;
					}
					doDraw(elapsedTime);
					// Wait for the draw to complete before progressing
					// If a plan-update-draw approach was employed the
					// wait for the draw would be tested post plan completion.
					synchronized (draw) {
						if (draw.isLocked) {
							draw.wait();
						}
					}

					// Measure how long the update/draw took to complete and
					// how long to sleep until the next cycle is due. This may
					// be a negative number (we've exceeded the 'available'
					// time).
					endStep = System.nanoTime();
					sleepTime = (targetStepPeriod - (endStep - startStep))
							- overSleepTime;

					// If needed put the thread to sleep
					if (sleepTime > 0) {
						Thread.sleep(sleepTime / 1000000L); // Covert ns into ms

						// Determine how much longer we slept than was
						// originally requested, we'll correct for this error
						// next frame
						overSleepTime = (System.nanoTime() - endStep)
								- sleepTime;
					} else {
						overSleepTime = 0L;
					}
				}

			} catch (InterruptedException e) {
			}
		}

		/**
		 * This method notifies the game loop that the draw has completed. This
		 * method will be called by the game when it is notified that the draw
		 * has completed.
		 */
		public void notifyDrawCompleted() {
			synchronized (draw) {
				draw.isLocked = false;
				draw.notifyAll();
			}
		}

		/**
		 * This method notifies the game loop that the update has completed.
		 * This method will be called by the game when it is notified that the
		 * update has completed.
		 */
		public void notifyUpdateCompleted() {
			synchronized (update) {
				update.isLocked = false;
				update.notifyAll();
			}
		}

		// Methods: Pause/Resume

		/**
		 * This method pauses the game loop. This method will be called by the
		 * game whenever it is paused.
		 */
		public void pause() {
			running = false;
			while (true) {
				try {
					renderThread.join();
					return;
				} catch (InterruptedException e) {
					Log.e("RocketOut", "Could not pause");
				}
			}
		}

		/**
		 * Resume the game loop. This method will be called by the game whenever
		 * it is resumed.
		 */
		public void resume() {
			running = true;

			draw.isLocked = false;
			update.isLocked = false;

			renderThread = new Thread(this);
			renderThread.start();
		}
	}

	/**
	 * This method saves the game's coins, high score and shop items so it can
	 * be played from where the user left off.
	 */
	public void save() {
		getActivity();
		SharedPreferences prefs = getActivity().getSharedPreferences(
				"my_prefs", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("coins", Money.getTotalMoney());
		editor.putInt("highScore", (int) GameOverScreen.getHighScore());
		editor.putInt("eTick", ShopScreen.getETick());
		editor.putInt("fTick", ShopScreen.getFTick());
		editor.commit();
	}

	/**
	 * This method loads in the coin value, high score value and the shop data
	 * from the save data in shared preferences whenever the user opens the game
	 */
	public void load() {
		getActivity();
		SharedPreferences prefs = getActivity().getSharedPreferences(
				"my_prefs", Context.MODE_PRIVATE);
		Money.setTotalMoney(prefs.getInt("coins", 0));
		GameOverScreen.setHighScore(prefs.getInt("highScore", 0));
		ShopScreen.setETick(prefs.getInt("eTick", 0));
		ShopScreen.setFTick(prefs.getInt("fTick", 0));
	}
}