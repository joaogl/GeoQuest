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

import me.joaogl.data.ProgramInfo;

public class SeePoints extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Pontuacao | " + Points.getWinner();
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 400;
	public int height = 320;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public SeePoints() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(window);
		drawButtons();
		drawLabels();
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(SeePoints.class.getResource("/textures/chickenback.png"));
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
	}

	public void drawLabels() {
		int size;
		JLabel creditos = new JLabel("Pontuacoes");
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 120;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);

		int dist = 30;
		
		JLabel welcome = new JLabel("Equipa 1 - " + Team1.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds(((width - size) / 8) - 20, ((height - 17) / 2) - dist, size, 17);
		window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Team2.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + 20, ((height - 17) / 2) - dist, size, 17);
		window.add(welcome);
	}
}