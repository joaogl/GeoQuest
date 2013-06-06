package me.joaogl.data.points;

public class Team1 {

	public static boolean q1 = false;
	public static boolean q2 = false;
	public static boolean q3 = false;
	public static boolean q4 = false;
	public static boolean q5 = false;
	public static boolean q6 = false;
	public static boolean q7 = false;
	public static boolean q8 = false;
	public static boolean q9 = false;
	public static boolean q10 = false;

	public static String Right(int id) {
		String awnser = "Falhou";
		if (id == 1) if (q1) awnser = "Acertou";
		if (id == 2) if (q2) awnser = "Acertou";
		if (id == 3) if (q3) awnser = "Acertou";
		if (id == 4) if (q4) awnser = "Acertou";
		if (id == 5) if (q5) awnser = "Acertou";
		if (id == 6) if (q6) awnser = "Acertou";
		if (id == 7) if (q7) awnser = "Acertou";
		if (id == 8) if (q8) awnser = "Acertou";
		if (id == 9) if (q9) awnser = "Acertou";
		if (id == 10) if (q10) awnser = "Acertou";
		return awnser;
	}
	
	public static int get(){
		int red = 0;
		if(q1) red++;
		if(q2) red++;
		if(q3) red++;
		if(q4) red++;
		if(q5) red++;
		if(q6) red++;
		if(q7) red++;
		if(q8) red++;
		if(q9) red++;
		if(q10) red++;	
		
		return red;
	}	

}
