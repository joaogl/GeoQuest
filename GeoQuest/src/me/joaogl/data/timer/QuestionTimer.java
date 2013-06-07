package me.joaogl.data.timer;

import java.awt.Toolkit;

import me.joaogl.data.ProgramInfo;

public class QuestionTimer {

	public static int sec = ProgramInfo.questionTime;
	
	private static void Timer() {
		new Thread(new Runnable() {
			public void run() {
				while (sec != 0) {
					sec--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sec = ProgramInfo.questionTime;
				Toolkit.getDefaultToolkit().beep();
			}
		}).start();
	}

	public static int getTime() {
		return sec;
	}

	public static void startTime() {
		if (sec == ProgramInfo.questionTime) Timer();
	}
}
