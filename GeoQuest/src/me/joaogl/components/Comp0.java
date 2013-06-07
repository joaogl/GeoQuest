package me.joaogl.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import me.joaogl.Launcher.Credits;
import me.joaogl.Launcher.Launcher;
import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.ChangePoints;
import me.joaogl.data.points.Points;
import me.joaogl.data.points.SeePoints;
import me.joaogl.data.timer.QuestionTimer;
import me.joaogl.game.Example;
import me.joaogl.game.question.Questions1;

public class Comp0 {

	static JLabel lversion, welcome, tempo;

	public static void drawCredits() {
		lversion = new JLabel(ProgramInfo.Nome + "  Grupo: " + ProgramInfo.Group + "  Turma: " + ProgramInfo.Class + "  Ano: " + ProgramInfo.Year);
		lversion.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 10));
		int size = 560;
		lversion.setBounds(((Example.width - size) / 2), (Example.height - 90), size, 15);
		Example.window.add(lversion);
	}

	public static void counterDisplay() {
		Example.counter.setText("Tempo: " + "00");
		Example.countersec.setText("Tempo: " + "12");
	}

	public static void drawMenu() {
		// Menus
		JMenu About = new JMenu("Menu");
		About.setMnemonic('M');
		JMenu Points = new JMenu("Pontuacao");
		Points.setMnemonic('P');

		Example.bar.add(About);
		Example.bar.add(Points);

		// Items Account
		JMenuItem cred = new JMenuItem("Creditos");
		cred.setMnemonic('C');
		cred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Credits();
			}
		});

		JMenuItem main = new JMenuItem("Menu");
		main.setMnemonic('M');
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Launcher();
				close();
			}
		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		About.add(cred);
		About.add(main);
		About.add(exit);

		// Items App

		JMenuItem pont = new JMenuItem("Pontuacoes");
		pont.setMnemonic('P');
		pont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeePoints();
			}
		});

		JMenuItem change = new JMenuItem("Alterar Pontos");
		change.setMnemonic('A');
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePoints();
			}
		});

		Points.add(pont);
		Points.add(change);
	}

	public static void drawTeams() {
		int size;

		welcome = new JLabel("Equipa 1 - " + Points.getRed() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds((Questions1.width - size) / 8, 200, size, 50);
		Example.window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Points.getBlue() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds(((Questions1.width - size) * 7) / 8, 200, size, 50);
		Example.window.add(welcome);
	}

	public static void drawTimers() {
		int size;
		tempo = new JLabel("Tempo total de apresentacao:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 210;
		tempo.setBounds(((Example.width - size) / 2) - 250, Example.height - 140, size, 50);
		Example.window.add(tempo);

		Example.counter = new JLabel("Tempo: 0");
		Example.counter.setFont(new Font("Arial", Font.BOLD, 15));
		size = 90;
		Example.counter.setBounds(((Example.width - size) / 2) - 250, Example.height - 120, size, 50);
		Example.window.add(Example.counter);

		tempo = new JLabel("Tempo Restante:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 130;
		tempo.setBounds((Example.width - size) / 2, 120, size, 12);
		Example.window.add(tempo);

		Example.countersec = new JLabel("Tempo: 1");
		Example.countersec.setFont(new Font("Arial", Font.BOLD, 15));
		size = 80;
		Example.countersec.setBounds((Example.width - size) / 2, 140, size, 12);
		Example.window.add(Example.countersec);
	}

	public static void close() {
		Example.window.removeAll();
		if (QuestionTimer.getTime() == 40 || QuestionTimer.getTime() == 0) QuestionTimer.startTime();
	}
}