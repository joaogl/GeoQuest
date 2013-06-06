package me.joaogl.game.resolution;

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
import me.joaogl.data.points.Points;
import me.joaogl.data.points.Team1;
import me.joaogl.data.points.Team2;
import me.joaogl.game.Conclusion;
import me.joaogl.game.question.Questions10;

public class Resolution10 extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Resolução - " + Questions10.pageid + " | " + Points.getWinner();
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 800;
	public int height = 420;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Resolution10() {

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
			buttonIcon = ImageIO.read(Resolution10.class.getResource("/textures/chickenback.png"));
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
				new Conclusion();
				dispose();
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
	
	public void drawPoins(){
		int size;
		int dist = 20;
		JLabel welcome = new JLabel("Equipa 1 - " + Team1.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds(((width - size) / 8) - dist, 100, size, 50);
		window.add(welcome);

		welcome = new JLabel("Equipa 2 - " + Team2.get() + " Pontos");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + dist, 100, size, 50);
		window.add(welcome);
		
		welcome = new JLabel("Questao " + Questions10.pageid + " - " + Team1.Right(Questions10.pageid));
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.RED);
		size = 170;
		welcome.setBounds(((width - size) / 8) - dist, 150, size, 50);
		window.add(welcome);

		welcome = new JLabel("Questao " + Questions10.pageid + " - " + Team2.Right(Questions10.pageid));
		welcome.setFont(new Font("Arial", Font.BOLD, 15));
		welcome.setForeground(Color.BLUE);
		welcome.setBounds((((width - size) * 7) / 8) + dist, 150, size, 50);
		window.add(welcome);	
		
	}	
	
	public void drawWhy(){
		String text = "<html>O Brasil possui a maior reserva de água do planeta, cerca de 8% da água doce disponível."
				+ "<br>Mas 80% destas águas estão na Amazónia, onde a população é de apenas 5%; os 20% restantes"
				+ "<br>respondem pelo abastecimento de 95% da população. Esta água que abastece os grandes"
				+ "<br>centros urbanos é cada vez mais poluída, por causa do desmatamento das florestas e da" 
				+ "<br>ocupação irregulares margens dos rios.</html>";
		JLabel why = new JLabel(text);
		why.setFont(new Font("Arial", Font.BOLD, 14));
		why.setBounds(60, 150, width - 110, 200);
		window.add(why);		
	}
}