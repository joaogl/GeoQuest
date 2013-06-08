package me.joaogl.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import me.joaogl.launcher.Credits;
import me.joaogl.launcher.Launcher;
import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.ChangePoints;
import me.joaogl.data.points.SeePoints;
import me.joaogl.data.timer.TotalTimer;
import me.joaogl.game.question.Questions1;

public class GameExplenation extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Inicio";
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 600;
	public int height = 400;
	protected int button_width = 90;
	protected int button_height = 40;
	JFrame frame = new JFrame();
	boolean running = true;
	protected JLabel counter;
	Thread thread;

	public GameExplenation() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(window);
		drawButtons();
		drawLabels();
		window.setLayout(null);
		setVisible(true);
		drawCredits();
		counterDisplay();
		drawMenu();
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(GameExplenation.class.getResource("/textures/start.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton comecar = new JButton(new ImageIcon(buttonIcon));
		comecar.setBounds((width / 2) - (button_width / 2) + 50, height - 100, button_width, button_height);
		window.add(comecar);

		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//QuestionTimer.Time();
				new Questions1();
				dispose();
			}
		});
		
		comecar = new JButton("Exemplo");
		comecar.setBounds((width / 2) - (button_width / 2) + 70 + button_width, height - 100, button_width, button_height);
		window.add(comecar);

		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Example();
			}
		});
	}

	private void drawLabels() {
		int size;
		JLabel welcome = new JLabel("O Jogo da Fome vai comecar!");
		welcome.setFont(new Font("Arial", Font.BOLD, 34));
		size = 490;
		welcome.setBounds(((width - size) / 2), 20, size, 50);
		window.add(welcome);

		counter = new JLabel("Tempo: 0");
		counter.setFont(new Font("Arial", Font.BOLD, 15));
		size = 90;
		counter.setBounds(((width - size) / 2) - 150, height - 100, size, 50);
		window.add(counter);

		JLabel tempo = new JLabel("Tempo total de apresentacao:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 210;
		tempo.setBounds(((width - size) / 2) - 150, height - 120, size, 50);
		window.add(tempo);

		String text;

		text = "<html>Agora que a turma esta dividida em duas equipas, e que cada uma tem um representante vamos começar a jogar." + "<br>Por cada pergunta é dado 12 segundos para a equipa decidir e comunicar ao seu representante" + "<br>a sua resposta." + "<br>Em seguida o grupo irá pedir a resposta e validá-la." + "<br>Existem 10 perguntas e no fim de cada uma o nosso grupo irá explicar a resposta." + "<br><br>" + "<br>Esperamos que gostem,<br>" + ProgramInfo.Group + "  </html> ";

		JLabel exp = new JLabel(text);
		exp.setFont(new Font("Arial", Font.BOLD, 12));
		size = 550;
		exp.setBounds(((width - size) / 2), 70, size, 200);
		window.add(exp);
	}

	private void drawMenu() {
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu About = new JMenu("Menu");
		About.setMnemonic('M');

		JMenu Points = new JMenu("Pontuacao");
		Points.setMnemonic('P');

		bar.add(About);
		bar.add(Points);
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
				dispose();
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

	private void drawCredits() {
		JLabel lversion = new JLabel(ProgramInfo.Nome + "  Grupo: " + ProgramInfo.Group + "  Turma: " + ProgramInfo.Class + "  Ano: " + ProgramInfo.Year);
		lversion.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 10));
		int size = 560;
		lversion.setBounds(((width - size) / 2), (height - 50), size, 15);
		window.add(lversion);
	}

	private void counterDisplay() {
		new Thread(new Runnable() {
			public void run() {
				while (running == true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!(TotalTimer.getTime() == null)) counter.setText("Tempo: " + TotalTimer.getTime());
					if (TotalTimer.getTime() == "15:00") counter.setText("O tempo Acabou!");
				}
			}
		}).start();
	}
}