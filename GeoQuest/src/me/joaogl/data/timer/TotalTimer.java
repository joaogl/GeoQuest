package me.joaogl.data.timer;

import java.awt.Toolkit;

public class TotalTimer {
	static int sec = 0;
	static int min = 0;
	static String time = null;

	public static void Time() {
		new Thread(new Runnable() {
			public void run() {
				while (min != 15) {
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
				if(min == 15){
					time = "O tempo acabou.";					
				}
				Toolkit.getDefaultToolkit().beep();
			}
		}).start();
	}

	public static String getTime() {
		return time;
	}
}