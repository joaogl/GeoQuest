package me.joaogl.game.resolution;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.joaogl.data.Extra1;
import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.Points;
import me.joaogl.data.points.PointsValidate;
import me.joaogl.game.question.Questions1;
import me.joaogl.game.question.Questions2;

public class Resolution1 extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Resolução - " + Questions1.pageid + " | " + PointsValidate.getStats(true);
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 700;
	public int height = 500;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Resolution1() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(window);
		drawButtons();
		drawLabels();
		drawPoins();
		drawWhy();
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(Resolution1.class.getResource("/textures/chickenback.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton voltar = new JButton(new ImageIcon(buttonIcon));
		voltar.setBounds(width - 105, (height - buttonIcon.getHeight()) - 50, buttonIcon.getWidth(), buttonIcon.getHeight());
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.setContentAreaFilled(false);
		window.add(voltar);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Questions2();
				dispose();
			}
		});

		BufferedImage buttonIcons = null;
		try {
			buttonIcons = ImageIO.read(Resolution1.class.getResource("/textures/Extra.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton voltars = new JButton(new ImageIcon(buttonIcons));
		voltars.setBounds(25, (height - buttonIcons.getHeight()) - 50, buttonIcons.getWidth(), buttonIcons.getHeight());
		voltars.setBorder(BorderFactory.createEmptyBorder());
		voltars.setContentAreaFilled(false);
		window.add(voltars);

		voltars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Extra1();
			}
		});
	}

	public void drawLabels() {
		int size;
		JLabel creditos = new JLabel("Será que acertas-te?");
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 200;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);
	}

	public void drawPoins() {
		int size;
		int dist = 20;
		JLabel welcome = new JLabel("Equipa 1 - " + Points.getRed() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds(((width - size) / 8) - dist, 100, size, 50);
		window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Points.getBlue() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + dist, 100, size, 50);
		window.add(welcome);

		welcome = new JLabel("Questao " + Questions1.pageid + " - " + Points.checkRed(Questions1.pageid));
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds(((width - size) / 8) - dist, 150, size, 50);
		window.add(welcome);

		welcome = new JLabel("Questao " + Questions1.pageid + " - " + Points.checkBlue(Questions1.pageid));
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + dist, 150, size, 50);
		window.add(welcome);

	}

	public void drawWhy() {
		String text = "<html>Apesar das mortes devidas á subnutrição acontecerem um pouco por todo o mundo,<br> é sobretudo nos paises africanos que este número é mais elevado.<br>Actualmente existem cerca de 30 milhões de famintos e subnutridos no continente africano.</html>";
		JLabel why = new JLabel(text);
		why.setFont(new Font("Arial", Font.BOLD, 14));
		why.setBounds(25, 210, width - 20, 200);
		window.add(why);
	}

	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(Resolution1.class.getResource("/textures/35segundos.gif"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		g.drawImage(buttonIcon, (width - buttonIcon.getWidth()) / 2, ((height - buttonIcon.getHeight()) / 2) - 50, buttonIcon.getWidth(), buttonIcon.getHeight(), null);
	}
}