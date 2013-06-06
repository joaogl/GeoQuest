package me.joaogl.Launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class Referencias extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Referência bibliográfica";
	// Page Name end

	private int width = 600;
	private int height = 600;
	protected JPanel window = new JPanel();
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Referencias() {

		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(true);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
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
			buttonIcon = ImageIO.read(Referencias.class.getResource("/textures/chickenback.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton voltar = new JButton(new ImageIcon(buttonIcon));
		voltar.setBounds((width - buttonIcon.getWidth()) - 50, (height - buttonIcon.getHeight()) - 50, buttonIcon.getWidth(), buttonIcon.getHeight());
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
		JLabel creditos = new JLabel("Referência bibliográficas");
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 250;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);
		
		creditos = new JLabel("<html>Aqui encontrao-se todos os recursos bibliograficos usados pelo"
				+ "<br>nosso grupo:"
				+ "<br><br>"
				+ "<br><br> http://confrontos.no.sapo.pt/page4.html"
				+ "<br><br> http://geoportugal.wordpress.com/contrastes/"
				+ "<br><br> http://pt.wikipedia.org/wiki/%C3%8Dndice_Global_da_Fome"
				+ "<br><br> http://www.brasilescola.com/geografia/a-fome-no-mundo-atual.htm"
				+ "<br><br> http://www.google.pt"
				+ "</html>");
		creditos.setFont(new Font("Arial", Font.BOLD, 15));
		creditos.setBounds(50, 80, width - 40, 300);
		window.add(creditos);
	}
}