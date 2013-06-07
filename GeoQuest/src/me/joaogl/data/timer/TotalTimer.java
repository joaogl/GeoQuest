package me.joaogl.data.timer;

import java.awt.Toolkit;

import me.joaogl.data.ProgramInfo;

public class TotalTimer {
	static int sec = 0;
	static int min = 0;
	static String time = null;

	public static void Timer() {
		new Thread(new Runnable() {
			public void run() {
				while (min != ProgramInfo.totalTime) {
					if (sec == 59) {
						sec = 0;
						min++;
					}
					time = min + ":" + sec;
					sec++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (min == ProgramInfo.totalTime) time = "O tempo acabou.";
				Toolkit.getDefaultToolkit().beep();
			}
		}).start();
	}

	public static String getTime() {
		return time;
	}
}