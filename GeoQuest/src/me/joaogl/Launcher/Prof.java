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

public class Prof extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Para a Professora";
	// Page Name end

	private int width = 600;
	private int height = 850;
	protected JPanel window = new JPanel();
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Prof() {

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
			buttonIcon = ImageIO.read(Prof.class.getResource("/textures/chickenback.png"));
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
		JLabel creditos = new JLabel(name);
		creditos.setFont(new Font("Arial", Font.BOLD, 20));
		size = 170;
		creditos.setBounds(((width - size) / 2), 20, size, 50);
		window.add(creditos);

		creditos = new JLabel("<html>Este trabalho esta pensado para ocupar entre 16 a 18 minutos" 
				+ "<br>com o programa." 
				+ "<br><br>Como o programa esta organizado:" 
				+ "<br>&nbsp;-&nbsp;No menu principal exitem 5 botoes:" 
				+ "<br>&nbsp;-&nbsp;Jogo - Onde o jogo comeca;" 
				+ "<br>&nbsp;-&nbsp;Referencias - Contem todas as referencias Bibliograficas;" 
				+ "<br>&nbsp;-&nbsp;Recursos - Contem todos os Recursos a imagens/videos;" 
				+ "<br>&nbsp;-&nbsp;Professora - Explicação do trabalho para a professora;" 
				+ "<br>&nbsp;-&nbsp;Creditos - Contem os autores do Trabalho:" 
				+ "<br><br>Jogo:" 
				+ "<br>&nbsp;O  Programa contem dois contadores, um de 0 a 15 minutos" 
				+ "<br>para que o grupo nao perca a noção do tempo, e um de 0 a 12 segundos" 
				+ "<br>tempo de resposta dado pelo grupo para os alunos darem<br> as suas respostas." 
				+ "<br>&nbsp;Ao clicar em Exemplo abrirá uma pagina igual á do jogo para que" 
				+ "<br>o grupo possa explicar á turma como funciona." 
				+ "<br>&nbsp;Após a explicacao podemos clicar no botao do START!" 
				+ "<br>&nbsp;Agora abre se o jogo, existem um total de 10 mais ou menos." 
				+ "<br>&nbsp;Ao escolher a resposta certa poderá clicar no validar," 
				+ "<br>em seguida abrirá uma pagina onde esta a resposta, se qual das" 
				+ "<br>equipas acertou e os pontos totais." 
				+ "<br>&nbsp;No final de cada pergunta o grupo irá falar um pouco" 
				+ "<br>sobre a resposta e sobre o assunto(texto por de baixo da imagem)." 
				+ "<br>&nbsp;Ao clicar no « + » dar lhe á acesso aos extras onde" 
				+ "<br>esta um grafico mais aperfundado sobre o tema." 
				+ "<br>&nbsp;Após estar tudo explicado, passamos para a proxima pergunta," 
				+ "<br>aqui o processo repete-se." 
				+ "<br><br> Obrigado" 
				+ "<br>" + ProgramInfo.Group 
				+ "</html>");
		creditos.setFont(new Font("Arial", Font.PLAIN, 15));
		creditos.setBounds(50, 80, width - 40, 690);
		window.add(creditos);
	}

}