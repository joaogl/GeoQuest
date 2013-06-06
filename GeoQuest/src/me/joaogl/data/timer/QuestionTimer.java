package me.joaogl.data.timer;

import java.awt.Toolkit;

public class QuestionTimer {
	private static int sec = 13;
	public static int TotalTime = 13;
	public static int TotalTime_Mask = TotalTime - 1;

	private static void Time() {
		if (sec == 13) {
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
					sec = 13;
					Toolkit.getDefaultToolkit().beep();
				}
			}).start();
		}
	}

	public static int getTime() {
		return sec;
	}
	
	public static void startTime() {
		if(sec == 13){
			Time();
		}
	}
}
