package me.joaogl.game.question;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import me.joaogl.components.Comp1;
import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.PointsValidate;
import me.joaogl.data.timer.QuestionTimer;

public class Questions1 extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	public static int pageid = 1;
	private String name = "Pergunta " + pageid + " | " + PointsValidate.getStats(true);
	// Page Name end

	public static JPanel window = new JPanel();
	public static int width = 800;
	public static int height = 800;
	protected int button_width = 90;
	protected int button_height = 40;
	JFrame frame = new JFrame();
	public static boolean running = true;
	public static JLabel counter, countersec;
	Thread thread;
	@SuppressWarnings("rawtypes")
	JComboBox team1an, team2an;
	public static JMenuBar bar;
	private static JButton comecar;

	public Questions1() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(window);
		drawButtonsStart();
		drawQuestion();
		Comp1.drawTimers();
		Comp1.drawTeams();
		Comp1.drawCredits();
		drawMenu();
		Comp1.drawMenu();
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	public void paint(Graphics g) {
		super.paint(g);
		int size = 130;

		g.drawLine((Questions1.width - size) / 2 - 10, 160, (Questions1.width - size) / 2 + size + 10, 160);
		g.drawLine((Questions1.width - size) / 2 - 10, 207, (Questions1.width - size) / 2 + size + 10, 207);

		g.drawLine((Questions1.width - size) / 2 - 10, 160, (Questions1.width - size) / 2 - 10, 207);
		g.drawLine((Questions1.width - size) / 2 + size + 10, 160, (Questions1.width - size) / 2 + size + 10, 207);
	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(Questions1.class.getResource("/textures/check.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton validar = new JButton(new ImageIcon(buttonIcon));
		validar.setBounds((width - buttonIcon.getWidth()) / 2, 600, buttonIcon.getWidth(), buttonIcon.getHeight());
		validar.setBorder(BorderFactory.createEmptyBorder());
		validar.setContentAreaFilled(false);
		window.add(validar);

		validar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PointsValidate.Validar((String) team2an.getSelectedItem(), (String) team1an.getSelectedItem(), pageid);
				Comp1.close(true);
				dispose();
			}
		});
	}

	private void drawButtonsStart() {
		BufferedImage buttonIcon2 = null;
		try {
			buttonIcon2 = ImageIO.read(Questions1.class.getResource("/textures/start.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		comecar = new JButton(new ImageIcon(buttonIcon2));
		comecar.setBounds(((width - button_width) / 2), height - 250, button_width, button_height);
		window.add(comecar);

		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionTimer.startTime();
				drawButtons();
				drawAnswer();
				Comp1.counterDisplay();
				window.remove(comecar);
				repaint();
			}
		});
	}

	private void drawQuestion() {
		int size;
		JLabel welcome = new JLabel("Em m�dia, a cada x segundos morre um ser humano de subnutri��o, sendo x igual a:");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		size = 750;
		welcome.setBounds(((width - size) / 2), 20, size, 50);
		window.add(welcome);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void drawAnswer() {
		int size;
		JLabel answer = new JLabel("�X� Corresponde a?");
		answer.setFont(new Font("Arial", Font.BOLD, 15));
		size = 150;
		answer.setBounds((width - size) / 8, 300, size, 50);
		window.add(answer);

		answer = new JLabel("�X� Corresponde a?");
		answer.setFont(new Font("Arial", Font.BOLD, 15));
		answer.setBounds(((width - size) * 7) / 8, 300, size, 50);
		window.add(answer);

		String text = "<html> Respostas Possiveis:" + "<br><br> 1,5 Segundo" + "<br><br> 2 Segundos" + "<br><br> 3,5 Segundos" + "<br><br> 4 Segundos";
		answer = new JLabel(text);
		answer.setFont(new Font("Arial", Font.BOLD, 15));
		size = 155;
		answer.setBounds((width - size) / 2, 200, size, 360);
		window.add(answer);

		String[] Answers = { "1,5 Segundos", "2 Segundos", "3,5 Segundos", "4 Segundos" };

		team1an = new JComboBox(Answers);
		size = 100;
		int selected = 3;
		team1an.setSelectedIndex(selected);
		team1an.setBounds(((width - size) * 7) / 8, 350, size, 50);
		window.add(team1an);

		team2an = new JComboBox(Answers);
		team2an.setSelectedIndex(selected);
		team2an.setBounds((width - size) / 8, 350, size, 50);
		window.add(team2an);

	}

	private void drawMenu() {
		bar = new JMenuBar();
		setJMenuBar(bar);
	}

	public void dispose() {
		dispose();
	}

}