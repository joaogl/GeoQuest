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
import javax.swing.JPanel;

import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.Points;
import me.joaogl.game.question.Questions1;

public class Conclusion extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Conclus�o | " + Points.getWinner();
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 800;
	public int height = 700;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Conclusion() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((dim.width - width) / 2), ((dim.height - height) / 2));
		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(false);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(window);
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);
		drawButtons();
		drawWinner();
		drawConclusion();

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(Questions1.class.getResource("/textures/theend.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton end = new JButton(new ImageIcon(buttonIcon));
		int widths = 300;
		int heights = 100;
		end.setBounds(((width - widths) - 9), ((height - heights) - 30), widths, heights);
		window.add(end);

		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void drawWinner() {
		int size;
		JLabel welcome;
		if (Points.getSpecialWinner().equalsIgnoreCase("Empate")) {
			welcome = new JLabel(Points.getWinner());
		} else {
			welcome = new JLabel("O Vencedor �: " + Points.getSpecialWinner());
		}
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		size = 300;
		welcome.setBounds(((width - size) / 2), 20, size, 50);
		window.add(welcome);
	}
	
	private void drawConclusion() {
		int size;
		String text = "<html>"
				+ "A fome � definida como a escassez de alimentos, e afecta uma grande quantidade da popula��o mundial.<br>"
				+ "Este problema � especialmente preocupante no continente africano, onde existem cerca de 30 milh�es<br>"
				+ "de pessoas a sofrer de subnutri��o cr�nica ou grave. No entanto, a fome existe em todos os<br>"
				+ "continentes, e, globalmente, existem mais de um bili�o de pessoas afectadas por este problema.<br>"
				+ "<br>"
				+ "Contrariamente, existem pa�ses onde a maior parte da popula��o se encontra num estado de excesso<br>"
				+ "de peso, resultado da elevada importa��o de alimentos industrializados. Nauru, por exemplo, n�o s� �<br>"
				+ "um destes pa�ses, como � o pa�s que apresenta o IMC (�ndice de Massa Corporal) per capita mais elevado<br>"
				+ "de todo o planeta.<br>"
				+ "<br>"
				+ "Existem ainda pa�ses, com especial destaque para os pa�ses desenvolvidos, onde quase metade do total<br>"
				+ "dos alimentos que os mesmos produzem anualmente � completamente desperdi�ada, mesmo que grande<br>"
				+ "parte deles se encontre em condi��es de ser consumido.<br>"
				+ "<br>"
				+ "Para al�m dos alimentos, tamb�m a �gua pot�vel � escassa em grande parte do globo, apesar do<br>"
				+ "planeta ser constitu�do essencialmente por �gua, apenas 0,007% desta � pot�vel e est� em condi��es de<br>"
				+ "ser consumida imediatamente. Mais uma vez s�o os pa�ses africanos onde se situam os casos mais<br>"
				+ "preocupantes, em algumas regi�es de �frica existem pessoas que s�o obrigadas a viver com menos de<br>"
				+ " 5 litros de �gua por dia.<br>"
				+ "<br>"
				+ "Em contrapartida, na cidade de Nova-Iorque, a m�dia de �gua utilizada diariamente por habitante �<br>"
				+ "cerca de 3000 litros! � urgente parar com o desperd�cio. Os recursos naturais est�o a esgotar-se<br>"
				+ "rapidamente, a ONU prev� que, se nada for feito, mais de dois ter�os da popula��o mundial<br>"
				+ "ficar� sem �gua pot�vel no espa�o de algumas d�cadas!<br>"
				+ "</html>";
		
		JLabel end = new JLabel(text);
		end.setFont(new Font("Arial", Font.BOLD, 13));
		size = 680;
		end.setBounds(((width - size) / 2), 50, size, 550);
		window.add(end);
	}
}