package me.joaogl.Launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.joaogl.data.ProgramInfo;
import me.joaogl.data.timer.TotalTimer;
import me.joaogl.game.GameExplenation;

public class Launcher extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Menu Principal";
	// Page Name end

	protected JLabel counter;
	protected JPanel window = new JPanel();
	public int width = 700;
	public int height = 400;
	protected int button_width = 110;
	protected int button_height = 40;
	JFrame frame = new JFrame();
	boolean running = true;
	boolean reopen = false;

	public Launcher() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(window);
		drawButtons();
		drawLabels();
		drawCredits();
		window.setLayout(null);
		setVisible(true);
		TotalTimer.Timer();
		counterDisplay();
		if (!(ProgramInfo.open)) {
			ProgramInfo.open = true;
			new Credits();
		}
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		int base = 90;
		int difference = base + button_height + 10;
		int plus = 50;

		JButton login = new JButton("Jogo");
		login.setBounds((width / 2) - (button_width / 2), base, button_width, button_height);
		window.add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameExplenation();
				dispose();
			}
		});

		login = new JButton("Referencias");
		login.setBounds((width / 2) - (button_width / 2), difference, button_width, button_height);
		window.add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Referencias();
			}
		});

		login = new JButton("Recursos");
		login.setBounds((width / 2) - (button_width / 2), difference + plus, button_width, button_height);
		window.add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Recursos();
			}
		});

		login = new JButton("Professora");
		login.setBounds((width / 2) - (button_width / 2), difference + (plus * 2), button_width, button_height);
		login.setBackground(Color.CYAN);
		window.add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Prof();
			}
		});

		login = new JButton("Creditos");
		login.setBounds((width / 2) - (button_width / 2), difference + (plus * 3), button_width, button_height);
		window.add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Credits();
			}
		});
	}

	private void drawLabels() {
		int size;
		JLabel welcome = new JLabel("Bem Vindo ao Jogo da Fome!");
		welcome.setFont(new Font("Arial", Font.BOLD, 38));
		size = 540;
		welcome.setBounds(((width - size) / 2), 20, size, 50);
		window.add(welcome);

		counter = new JLabel("Tempo: 0");
		counter.setFont(new Font("Arial", Font.BOLD, 15));
		size = 90;
		counter.setBounds(((width - size) / 2) - 200, height - 120, size, 50);
		window.add(counter);

		JLabel tempo = new JLabel("Tempo total de apresentacao:");
		tempo.setFont(new Font("Arial", Font.BOLD, 15));
		size = 210;
		tempo.setBounds(((width - size) / 2) - 200, height - 140, size, 50);
		window.add(tempo);
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
					if (!(TotalTimer.getTime() == null)) {
						counter.setText("Time: " + TotalTimer.getTime());
					}
					if (TotalTimer.getTime() == "15:00") {
						counter.setText("O tempo Acabou!");
					}
				}
			}
		}).start();
	}
}
