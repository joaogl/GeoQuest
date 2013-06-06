package me.joaogl.data.points;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JComboBox;

import me.joaogl.data.ProgramInfo;

public class ChangePoints extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Alterar Pontuacão | " + Points.getWinner();
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 400;
	public int height = 600;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();
	@SuppressWarnings("rawtypes")
	JComboBox q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
	@SuppressWarnings("rawtypes")
	JComboBox qq1, qq2, qq3, qq4, qq5, qq6, qq7, qq8, qq9, qq10;
	String[] Answers = { "Acertou", "Falhou" };

	public ChangePoints() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(window);
		drawButtons();
		drawLabels();
		drawTextFlields1();
		drawTextFlields2();
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(ChangePoints.class.getResource("/textures/chickenback.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton voltar = new JButton(new ImageIcon(buttonIcon));
		voltar.setBounds(width - 105, height - 125, buttonIcon.getWidth(), buttonIcon.getHeight());
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.setContentAreaFilled(false);
		window.add(voltar);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		BufferedImage buttonIcons = null;
		try {
			buttonIcons = ImageIO.read(ChangePoints.class.getResource("/textures/check.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton voltares = new JButton(new ImageIcon(buttonIcons));
		voltares.setBounds(20, height - 125, buttonIcon.getWidth(), buttonIcon.getHeight());
		voltares.setBorder(BorderFactory.createEmptyBorder());
		voltares.setContentAreaFilled(false);
		window.add(voltares);

		voltares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPoints1();
				checkPoints2();
				new ChangePoints();
				dispose();
			}
		});
	}

	public void drawLabels() {
		int size;
		JLabel creditos = new JLabel("Alterar Pontuações");
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 190;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);

		int distx = 20;
		int disty = 200;

		JLabel welcome = new JLabel("Equipa 1 - " + Team1.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.RED);
		size = 140;
		welcome.setBounds(((width - size) / 8) - distx, ((height - 17) / 2) - disty, size, 17);
		window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Team2.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + distx, ((height - 17) / 2) - disty, size, 17);
		window.add(welcome);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void drawTextFlields1() {
		q1 = new JComboBox(Answers);
		int select = 1;
		if (Team1.q1) select = 0;
		q1.setSelectedIndex(select);
		q1.setBounds(15, 130, 100, 25);
		window.add(q1);
		
		select = 1;
		if (Team1.q2) select = 0;
		q2 = new JComboBox(Answers);
		q2.setSelectedIndex(select);
		q2.setBounds(15, 160, 100, 25);
		window.add(q2);

		select = 1;
		if (Team1.q3) select = 0;
		q3 = new JComboBox(Answers);
		q3.setSelectedIndex(select);
		q3.setBounds(15, 190, 100, 25);
		window.add(q3);

		select = 1;
		if (Team1.q4) select = 0;
		q4 = new JComboBox(Answers);
		q4.setSelectedIndex(select);
		q4.setBounds(15, 220, 100, 25);
		window.add(q4);

		select = 1;
		if (Team1.q5) select = 0;
		q5 = new JComboBox(Answers);
		q5.setSelectedIndex(select);
		q5.setBounds(15, 250, 100, 25);
		window.add(q5);

		select = 1;
		if (Team1.q6) select = 0;
		q6 = new JComboBox(Answers);
		q6.setSelectedIndex(select);
		q6.setBounds(15, 280, 100, 25);
		window.add(q6);

		select = 1;
		if (Team1.q7) select = 0;
		q7 = new JComboBox(Answers);
		q7.setSelectedIndex(select);
		q7.setBounds(15, 310, 100, 25);
		window.add(q7);

		select = 1;
		if (Team1.q8) select = 0;
		q8 = new JComboBox(Answers);
		q8.setSelectedIndex(select);
		q8.setBounds(15, 340, 100, 25);
		window.add(q8);

		select = 1;
		if (Team1.q9) select = 0;
		q9 = new JComboBox(Answers);
		q9.setSelectedIndex(select);
		q9.setBounds(15, 370, 100, 25);
		window.add(q9);

		select = 1;
		if (Team1.q10) select = 0;
		q10 = new JComboBox(Answers);
		q10.setSelectedIndex(select);
		q10.setBounds(15, 400, 100, 25);
		window.add(q10);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void drawTextFlields2() {
		qq1 = new JComboBox(Answers);
		int select = 1;
		if (Team2.q1) select = 0;
		qq1.setSelectedIndex(select);
		qq1.setBounds((width - 100) - 15, 130, 100, 25);
		window.add(qq1);

		select = 1;
		if (Team2.q2) select = 0;
		qq2 = new JComboBox(Answers);
		qq2.setSelectedIndex(select);
		qq2.setBounds((width - 100) - 15, 160, 100, 25);
		window.add(qq2);

		select = 1;
		if (Team2.q3) select = 0;
		qq3 = new JComboBox(Answers);
		qq3.setSelectedIndex(select);
		qq3.setBounds((width - 100) - 15, 190, 100, 25);
		window.add(qq3);

		select = 1;
		if (Team2.q4) select = 0;
		qq4 = new JComboBox(Answers);
		qq4.setSelectedIndex(select);
		qq4.setBounds((width - 100) - 15, 220, 100, 25);
		window.add(qq4);

		select = 1;
		if (Team2.q5) select = 0;
		qq5 = new JComboBox(Answers);
		qq5.setSelectedIndex(select);
		qq5.setBounds((width - 100) - 15, 250, 100, 25);
		window.add(qq5);

		select = 1;
		if (Team2.q6) select = 0;
		qq6 = new JComboBox(Answers);
		qq6.setSelectedIndex(select);
		qq6.setBounds((width - 100) - 15, 280, 100, 25);
		window.add(qq6);

		select = 1;
		if (Team2.q7) select = 0;
		qq7 = new JComboBox(Answers);
		qq7.setSelectedIndex(select);
		qq7.setBounds((width - 100) - 15, 310, 100, 25);
		window.add(qq7);

		select = 1;
		if (Team2.q8) select = 0;
		qq8 = new JComboBox(Answers);
		qq8.setSelectedIndex(select);
		qq8.setBounds((width - 100) - 15, 340, 100, 25);
		window.add(qq8);

		select = 1;
		if (Team2.q9) select = 0;
		qq9 = new JComboBox(Answers);
		qq9.setSelectedIndex(select);
		qq9.setBounds((width - 100) - 15, 370, 100, 25);
		window.add(qq9);

		select = 1;
		if (Team2.q10) select = 0;
		qq10 = new JComboBox(Answers);
		qq10.setSelectedIndex(select);
		qq10.setBounds((width - 100) - 15, 400, 100, 25);
		window.add(qq10);
	}

	public void checkPoints1() {
		if (q1.getSelectedIndex() == 0) Team1.q1 = true;
		if (q1.getSelectedIndex() == 1) Team1.q1 = false;

		if (q2.getSelectedIndex() == 0) Team1.q2 = true;
		if (q2.getSelectedIndex() == 1) Team1.q2 = false;

		if (q3.getSelectedIndex() == 0) Team1.q3 = true;
		if (q3.getSelectedIndex() == 1) Team1.q3 = false;

		if (q4.getSelectedIndex() == 0) Team1.q4 = true;
		if (q4.getSelectedIndex() == 1) Team1.q4 = false;

		if (q5.getSelectedIndex() == 0) Team1.q5 = true;
		if (q5.getSelectedIndex() == 1) Team1.q5 = false;

		if (q6.getSelectedIndex() == 0) Team1.q6 = true;
		if (q6.getSelectedIndex() == 1) Team1.q6 = false;

		if (q7.getSelectedIndex() == 0) Team1.q7 = true;
		if (q7.getSelectedIndex() == 1) Team1.q7 = false;

		if (q8.getSelectedIndex() == 0) Team1.q8 = true;
		if (q8.getSelectedIndex() == 1) Team1.q8 = false;

		if (q9.getSelectedIndex() == 0) Team1.q9 = true;
		if (q9.getSelectedIndex() == 1) Team1.q9 = false;

		if (q10.getSelectedIndex() == 0) Team1.q10 = true;
		if (q10.getSelectedIndex() == 1) Team1.q10 = false;
	}

	public void checkPoints2() {
		if (qq1.getSelectedIndex() == 0) Team2.q1 = true;
		if (qq1.getSelectedIndex() == 1) Team2.q1 = false;

		if (qq2.getSelectedIndex() == 0) Team2.q2 = true;
		if (qq2.getSelectedIndex() == 1) Team2.q2 = false;

		if (qq3.getSelectedIndex() == 0) Team2.q3 = true;
		if (qq3.getSelectedIndex() == 1) Team2.q3 = false;

		if (qq4.getSelectedIndex() == 0) Team2.q4 = true;
		if (qq4.getSelectedIndex() == 1) Team2.q4 = false;

		if (qq5.getSelectedIndex() == 0) Team2.q5 = true;
		if (qq5.getSelectedIndex() == 1) Team2.q5 = false;

		if (qq6.getSelectedIndex() == 0) Team2.q6 = true;
		if (qq6.getSelectedIndex() == 1) Team2.q6 = false;

		if (qq7.getSelectedIndex() == 0) Team2.q7 = true;
		if (qq7.getSelectedIndex() == 1) Team2.q7 = false;

		if (qq8.getSelectedIndex() == 0) Team2.q8 = true;
		if (qq8.getSelectedIndex() == 1) Team2.q8 = false;

		if (qq9.getSelectedIndex() == 0) Team2.q9 = true;
		if (qq9.getSelectedIndex() == 1) Team2.q9 = false;

		if (qq10.getSelectedIndex() == 0) Team2.q10 = true;
		if (qq10.getSelectedIndex() == 1) Team2.q10 = false;
	}
}