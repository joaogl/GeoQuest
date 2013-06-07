package me.joaogl.data.points;

public class Points {

	public static boolean rq1 = false;
	public static boolean rq2 = false;
	public static boolean rq3 = false;
	public static boolean rq4 = false;
	public static boolean rq5 = false;
	public static boolean rq6 = false;
	public static boolean rq7 = false;
	public static boolean rq8 = false;
	public static boolean rq9 = false;
	public static boolean rq10 = false;

	public static boolean bq1 = false;
	public static boolean bq2 = false;
	public static boolean bq3 = false;
	public static boolean bq4 = false;
	public static boolean bq5 = false;
	public static boolean bq6 = false;
	public static boolean bq7 = false;
	public static boolean bq8 = false;
	public static boolean bq9 = false;
	public static boolean bq10 = false;

	public static String checkBlue(int id) {
		String awnser = "Falhou";
		if (id == 1) if (bq1) awnser = "Acertou";
		if (id == 2) if (bq2) awnser = "Acertou";
		if (id == 3) if (bq3) awnser = "Acertou";
		if (id == 4) if (bq4) awnser = "Acertou";
		if (id == 5) if (bq5) awnser = "Acertou";
		if (id == 6) if (bq6) awnser = "Acertou";
		if (id == 7) if (bq7) awnser = "Acertou";
		if (id == 8) if (bq8) awnser = "Acertou";
		if (id == 9) if (bq9) awnser = "Acertou";
		if (id == 10) if (bq10) awnser = "Acertou";
		return awnser;
	}

	public static String checkRed(int id) {
		String awnser = "Falhou";
		if (id == 1) if (rq1) awnser = "Acertou";
		if (id == 2) if (rq2) awnser = "Acertou";
		if (id == 3) if (rq3) awnser = "Acertou";
		if (id == 4) if (rq4) awnser = "Acertou";
		if (id == 5) if (rq5) awnser = "Acertou";
		if (id == 6) if (rq6) awnser = "Acertou";
		if (id == 7) if (rq7) awnser = "Acertou";
		if (id == 8) if (rq8) awnser = "Acertou";
		if (id == 9) if (rq9) awnser = "Acertou";
		if (id == 10) if (rq10) awnser = "Acertou";
		return awnser;
	}

	public static int getBlue() {
		int blue = 0;
		if (bq1) blue++;
		if (bq2) blue++;
		if (bq3) blue++;
		if (bq4) blue++;
		if (bq5) blue++;
		if (bq6) blue++;
		if (bq7) blue++;
		if (bq8) blue++;
		if (bq9) blue++;
		if (bq10) blue++;

		return blue;
	}

	public static int getRed() {
		int red = 0;
		if (rq1) red++;
		if (rq2) red++;
		if (rq3) red++;
		if (rq4) red++;
		if (rq5) red++;
		if (rq6) red++;
		if (rq7) red++;
		if (rq8) red++;
		if (rq9) red++;
		if (rq10) red++;

		return red;
	}
}
