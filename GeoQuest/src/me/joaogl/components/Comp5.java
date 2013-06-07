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
import me.joaogl.data.timer.TotalTimer;
import me.joaogl.game.question.Questions5;
import me.joaogl.game.resolution.Resolution5;

public class Comp5 {

	static JLabel lversion, welcome, tempo;

	public static void drawCredits() {
		lversion = new JLabel(ProgramInfo.Nome + "  Grupo: " + ProgramInfo.Group + "  Turma: " + ProgramInfo.Class + "  Ano: " + ProgramInfo.Year);
		lversion.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 10));
		int size = 560;
		lversion.setBounds(((Questions5.width - size) / 2), (Questions5.height - 80), size, 15);
		Questions5.window.add(lversion);
	}

	public static void counterDisplay() {
		new Thread(new Runnable() {
			public void run() {
				while (Questions5.running == true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!(TotalTimer.getTime() == null)) {
						if (TotalTimer.getTime() == "15:0" || TotalTimer.getTime() == "O tempo acabou.") Questions5.counter.setText("Acabou!");
						else Questions5.counter.setText("Tempo: " + TotalTimer.getTime());
					}
					if (!(QuestionTimer.getTime() == 0)) {
						if (QuestionTimer.getTime() == QuestionTimer.sec) {
							Questions5.countersec.setText("Acabou!");
						} else {
							Questions5.countersec.setText("Tempo: " + QuestionTimer.getTime());
						}
					}
				}
			}
		}).start();

	}

	public static void drawMenu() {
		// Menus
		JMenu About = new JMenu("Menu");
		About.setMnemonic('M');
		JMenu Points = new JMenu("Pontuacao");
		Points.setMnemonic('P');
		JMenu Debugging = new JMenu("Debugging");
		Debugging.setMnemonic('D');

		Questions5.bar.add(About);
		Questions5.bar.add(Points);
		if (ProgramInfo.debugging) Questions5.bar.add(Debugging);

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

		// Items Debbug

		JMenuItem plus = new JMenuItem("Debugging +");
		plus.setMnemonic('+');
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramInfo.debugquestions++;
			}
		});

		JMenuItem less = new JMenuItem("Debugging -");
		less.setMnemonic('-');
		less.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramInfo.debugquestions--;
			}
		});

		Debugging.add(plus);
		Debugging.add(less);
	}

	public static void drawTeams() {
		int size;

		welcome = new JLabel("Equipa 1 - " + Points.getRed() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds((Questions5.width - size) / 8, 200, size, 50);
		Questions5.window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Points.getBlue() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds(((Questions5.width - size) * 7) / 8, 200, size, 50);
		Questions5.window.add(welcome);

	}

	public static void drawTimers() {
		int size;
		tempo = new JLabel("Tempo total de apresentacao:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 210;
		tempo.setBounds(((Questions5.width - size) / 2) - 250, Questions5.height - 140, size, 50);
		Questions5.window.add(tempo);

		Questions5.counter = new JLabel("Tempo: 0");
		Questions5.counter.setFont(new Font("Arial", Font.BOLD, 15));
		size = 100;
		Questions5.counter.setBounds(((Questions5.width - size) / 2) - 250, Questions5.height - 120, size, 50);
		Questions5.window.add(Questions5.counter);

		tempo = new JLabel("Tempo Restante:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 130;
		tempo.setBounds((Questions5.width - size) / 2, 120, size, 12);
		Questions5.window.add(tempo);

		Questions5.countersec = new JLabel("Tempo: " + (QuestionTimer.sec - 1));
		Questions5.countersec.setFont(new Font("Arial", Font.BOLD, 15));
		size = 80;
		Questions5.countersec.setBounds((Questions5.width - size) / 2, 140, size, 12);
		Questions5.window.add(Questions5.countersec);

	}

	public static void close() {
		Questions5.window.removeAll();
		if (ProgramInfo.debugging) {
			if (ProgramInfo.debugquestions == Questions5.pageid) new Questions5();
			else new Resolution5();
		} else new Resolution5();
	}
}