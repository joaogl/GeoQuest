package me.joaogl.Launcher;

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

public class Credits extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Creditos";
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 400;
	public int height = 320;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Credits() {

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
			buttonIcon = ImageIO.read(Credits.class.getResource("/textures/chickenback.png"));
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
		JLabel creditos = new JLabel("Creditos");
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 80;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);

		JLabel Credits;
		Credits = new JLabel("Grupo: " + ProgramInfo.Group);
		Credits.setFont(new Font("Arial", Font.BOLD, 12));
		size = 300;
		Credits.setBounds((width - size) / 2, 100, size, 16);
		window.add(Credits);

		Credits = new JLabel("Turma: " + ProgramInfo.Class + " Ano: " + ProgramInfo.Year);
		Credits.setFont(new Font("Arial", Font.BOLD, 12));
		size = 160;
		Credits.setBounds((width - size) / 2, 120, size, 16);
		window.add(Credits);

		Credits = new JLabel("Disciplina: " + ProgramInfo.Subject);
		Credits.setFont(new Font("Arial", Font.BOLD, 12));
		size = 120;
		Credits.setBounds((width - size) / 2, 140, size, 16);
		window.add(Credits);

		Credits = new JLabel("Programador: " + ProgramInfo.Author);
		Credits.setFont(new Font("Arial", Font.BOLD, 12));
		size = 170;
		Credits.setBounds((width - size) / 2, 160, size, 16);
		window.add(Credits);

		Credits = new JLabel("Programa: " + ProgramInfo.Nome);
		Credits.setFont(new Font("Arial", Font.BOLD, 12));
		size = 240;
		Credits.setBounds((width - size) / 2, 180, size, 16);
		window.add(Credits);
	}
}