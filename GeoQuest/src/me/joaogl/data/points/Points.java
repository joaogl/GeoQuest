package me.joaogl.data.points;

public class Points {

	public static void Validar(String TeamA, String TeamB, int id) {
		if (id == 1) {
			if (TeamA.equalsIgnoreCase("3,5 Segundos")) {
				Team1.q1 = true;
			} else Team1.q1 = false;
			if (TeamB.equalsIgnoreCase("3,5 Segundos")) {
				Team2.q1 = true;
			} else Team2.q1 = false;
		} else if (id == 2) {
			if (TeamA.equalsIgnoreCase("Índice Global da Fome")) {
				Team1.q2 = true;
			} else Team1.q2 = false;
			if (TeamB.equalsIgnoreCase("Índice Global da Fome")) {
				Team2.q2 = true;
			} else Team2.q2 = false;
		} else if (id == 3) {
			if (TeamA.equalsIgnoreCase("Nauru")) {
				Team1.q3 = true;
			} else Team1.q3 = false;
			if (TeamB.equalsIgnoreCase("Nauru")) {
				Team2.q3 = true;
			} else Team2.q3 = false;
		} else if (id == 4) {
			if (TeamA.equalsIgnoreCase("815 milhões")) {
				Team1.q4 = true;
			} else Team1.q4 = false;
			if (TeamB.equalsIgnoreCase("815 milhões")) {
				Team2.q4 = true;
			} else Team2.q4 = false;
		} else if (id == 5) {
			if (TeamA.equalsIgnoreCase("1100 milhões")) {
				Team1.q5 = true;
			} else Team1.q5 = false;
			if (TeamB.equalsIgnoreCase("1100 milhões")) {
				Team2.q5 = true;
			} else Team2.q5 = false;
		} else if (id == 6) {
			if (TeamA.equalsIgnoreCase("150 litros")) {
				Team1.q6 = true;
			} else Team1.q6 = false;
			if (TeamB.equalsIgnoreCase("150 litros")) {
				Team2.q6 = true;
			} else Team2.q6 = false;
		} else if (id == 7) {
			if (TeamA.equalsIgnoreCase("160")) {
				Team1.q7 = true;
			} else Team1.q7 = false;
			if (TeamB.equalsIgnoreCase("160")) {
				Team2.q7 = true;
			} else Team2.q7 = false;
		} else if (id == 8) {
			if (TeamA.equalsIgnoreCase("1%")) {
				Team1.q8 = true;
			} else Team1.q8 = false;
			if (TeamB.equalsIgnoreCase("1%")) {
				Team2.q8 = true;
			} else Team2.q8 = false;
		} else if (id == 9) {
			if (TeamA.equalsIgnoreCase("17%")) {
				Team1.q9 = true;
			} else Team1.q9 = false;
			if (TeamB.equalsIgnoreCase("17%")) {
				Team2.q9 = true;
			} else Team2.q9 = false;
		} else if (id == 10) {
			if (TeamA.equalsIgnoreCase("Brasil")) {
				Team1.q10 = true;
			} else Team1.q10 = false;
			if (TeamB.equalsIgnoreCase("Brasil")) {
				Team2.q10 = true;
			} else Team2.q10 = false;
		}
	}

	public static String getWinner() {
		String winner = null;
		if (Team1.get() > Team2.get()) winner = "A ganhar: Vermelha";
		if (Team1.get() < Team2.get()) winner = "A ganhar: Azul";
		if (Team1.get() == Team2.get()) winner = "Empate: " + Team1.get() + " a " + Team2.get();
		return winner;
	}
	
	public static String getSpecialWinner() {
		String winner = null;
		if (Team1.get() > Team2.get()) winner = "Equipa Vermelha";
		if (Team1.get() < Team2.get()) winner = "Equipa Azul";
		if (Team1.get() == Team2.get()) winner = "Empate";
		return winner;
	}
}