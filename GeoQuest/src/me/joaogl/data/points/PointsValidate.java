package me.joaogl.data.points;

public class PointsValidate {

	public static void Validar(String TeamA, String TeamB, int id) {
		if (id == 1) {
			if (TeamA.equalsIgnoreCase("3,5 Segundos")) Points.rq1 = true;
			else Points.rq1 = false;
			if (TeamB.equalsIgnoreCase("3,5 Segundos")) Points.bq1 = true;
			else Points.bq1 = false;
		} else if (id == 2) {
			if (TeamA.equalsIgnoreCase("Índice Global da Fome")) Points.rq2 = true;
			else Points.rq2 = false;
			if (TeamB.equalsIgnoreCase("Índice Global da Fome")) Points.bq2 = true;
			else Points.bq2 = false;
		} else if (id == 3) {
			if (TeamA.equalsIgnoreCase("Nauru")) Points.rq3 = true;
			else Points.rq3 = false;
			if (TeamB.equalsIgnoreCase("Nauru")) Points.bq3 = true;
			else Points.bq3 = false;
		} else if (id == 4) {
			if (TeamA.equalsIgnoreCase("815 milhões")) Points.rq4 = true;
			else Points.rq4 = false;
			if (TeamB.equalsIgnoreCase("815 milhões")) Points.bq4 = true;
			else Points.bq4 = false;
		} else if (id == 5) {
			if (TeamA.equalsIgnoreCase("1100 milhões")) Points.rq5 = true;
			else Points.rq5 = false;
			if (TeamB.equalsIgnoreCase("1100 milhões")) Points.bq5 = true;
			else Points.bq5 = false;
		} else if (id == 6) {
			if (TeamA.equalsIgnoreCase("150 litros")) Points.rq6 = true;
			else Points.rq6 = false;
			if (TeamB.equalsIgnoreCase("150 litros")) Points.bq6 = true;
			else Points.bq6 = false;
		} else if (id == 7) {
			if (TeamA.equalsIgnoreCase("160")) Points.rq7 = true;
			else Points.rq7 = false;
			if (TeamB.equalsIgnoreCase("160")) Points.bq7 = true;
			else Points.bq7 = false;
		} else if (id == 8) {
			if (TeamA.equalsIgnoreCase("1%")) Points.rq8 = true;
			else Points.rq8 = false;
			if (TeamB.equalsIgnoreCase("1%")) Points.bq8 = true;
			else Points.bq8 = false;
		} else if (id == 9) {
			if (TeamA.equalsIgnoreCase("17%")) Points.rq9 = true;
			else Points.rq9 = false;
			if (TeamB.equalsIgnoreCase("17%")) Points.bq9 = true;
			else Points.bq9 = false;
		} else if (id == 10) {
			if (TeamA.equalsIgnoreCase("Brasil")) Points.rq10 = true;
			else Points.rq10 = false;
			if (TeamB.equalsIgnoreCase("Brasil")) Points.bq10 = true;
			else Points.bq10 = false;
		}
	}

	public static String getStats(boolean showPoints) {
		String status = null;
		if (showPoints) {
			if (Points.getRed() > Points.getBlue()) status = "A ganhar: Vermelha";
			if (Points.getRed() < Points.getBlue()) status = "A ganhar: Azul";
			if (Points.getRed() == Points.getBlue()) status = "Empate: " + Points.getRed() + " a " + Points.getBlue();
			return status;
		} else {
			if (Points.getRed() > Points.getBlue()) status = "Equipa Vermelha";
			if (Points.getRed() < Points.getBlue()) status = "Equipa Azul";
			if (Points.getRed() == Points.getBlue()) status = "Empate";
			return status;
		}
	}
}