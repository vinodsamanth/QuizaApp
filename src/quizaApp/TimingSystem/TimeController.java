package quizaApp.TimingSystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimeController {
	ScheduledExecutorService bgthread;
	StringProperty timejfx;

	public TimeController() {
		// TODO Auto-generated constructor stub
		timejfx = new SimpleStringProperty("");
	}

	public void startTimer(final int minPar, final int secPar) {
		this.bgthread = Executors.newSingleThreadScheduledExecutor();

		this.bgthread.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {

				int sec = secPar;
				int min = minPar;
				if (sec == 0) {
					if (min == 0) {

						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								submitQuiz();
							}

							private void submitQuiz() {
								// TODO Auto-generated method stub

							}
						});
						bgthread.shutdown();
					} else {
						sec = 60;
						min--;
					}

				} else {
					sec--;
				}
				// TODO Auto-generated method stub
				timejfx.set("Time: " + min + ":" + sec);

			}

		}, 0, 1, TimeUnit.SECONDS);
	}

}
