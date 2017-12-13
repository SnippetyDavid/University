package uk.co.takeabytestudios.rock_etout.game;

import uk.co.takeabytestudios.rock_etout.R;
import uk.co.takeabytestudios.rock_etout.engine.ElapsedTime;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * This class was trying to create a score that updated over time. It didn't end
 * up working so we used a different way in the RocketGameScreen.java class.
 * This score class is never used but we left it in for reference NB: This score
 * class was created with the help of a stack overflow question as referenced
 * below: http://stackoverflow.com/questions/4597690/android-timer-how
 * 
 * @author Nathan Harrison, Niall Shannon, David Walsh, Reece Magee
 */
public class Score extends Activity {

	// Constructor
	/**
	 * Creates a score object
	 */
	public Score() {
	}

	TextView scoreTextView;
	TextView finalScoreTextView;
	TextView highScoreTextView;

	long startTime = 0;
	int finalScore = 0;
	int highScore = 0;
	int points = 0;

	// runs without a timer by reposting this handler at the end of the runnable
	Handler timerHandler = new Handler();
	Runnable timerRunnable = new Runnable() {

		// Methods
		public void run() {
			long millis = System.currentTimeMillis() - startTime;
			// every second is equal to 10 points
			points = (int) (millis / 100);

			// setting counter to appear with six zeros
			scoreTextView.setText(String.format("%06d", points));
			// refreshes every 100 milliseconds
			timerHandler.postDelayed(this, 100);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// creating textViews
		scoreTextView = new TextView(this);
		finalScoreTextView = new TextView(this);
		highScoreTextView = new TextView(this);

		// sets timer to zero
		startTime = System.currentTimeMillis();
		timerHandler.postDelayed(timerRunnable, 0);
	}

	@Override
	public void onPause() {
		super.onPause();
		timerHandler.removeCallbacks(timerRunnable);
	}

	// can be used instead of runnable
	public void update(ElapsedTime elapsedTime) {
		long millis = System.currentTimeMillis() - startTime;
		// every second is equal to 10 points
		points = (int) (millis / 100);

		// setting counter to appear with six zeros
		scoreTextView.setText(String.format("%06d", points));
	}
}