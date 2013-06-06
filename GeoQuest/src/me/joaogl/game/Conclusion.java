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
	private String name = "Conclusão | " + Points.getWinner();
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
			welcome = new JLabel("O Vencedor é: " + Points.getSpecialWinner());
		}
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		size = 300;
		welcome.setBounds(((width - size) / 2), 20, size, 50);
		window.add(welcome);
	}
	
	private void drawConclusion() {
		int size;
		String text = "<html>"
				+ "A fome é definida como a escassez de alimentos, e afecta uma grande quantidade da população mundial.<br>"
				+ "Este problema é especialmente preocupante no continente africano, onde existem cerca de 30 milhões<br>"
				+ "de pessoas a sofrer de subnutrição crónica ou grave. No entanto, a fome existe em todos os<br>"
				+ "continentes, e, globalmente, existem mais de um bilião de pessoas afectadas por este problema.<br>"
				+ "<br>"
				+ "Contrariamente, existem países onde a maior parte da população se encontra num estado de excesso<br>"
				+ "de peso, resultado da elevada importação de alimentos industrializados. Nauru, por exemplo, não só é<br>"
				+ "um destes países, como é o país que apresenta o IMC (Índice de Massa Corporal) per capita mais elevado<br>"
				+ "de todo o planeta.<br>"
				+ "<br>"
				+ "Existem ainda países, com especial destaque para os países desenvolvidos, onde quase metade do total<br>"
				+ "dos alimentos que os mesmos produzem anualmente é completamente desperdiçada, mesmo que grande<br>"
				+ "parte deles se encontre em condições de ser consumido.<br>"
				+ "<br>"
				+ "Para além dos alimentos, também a água potável é escassa em grande parte do globo, apesar do<br>"
				+ "planeta ser constituído essencialmente por água, apenas 0,007% desta é potável e está em condições de<br>"
				+ "ser consumida imediatamente. Mais uma vez são os países africanos onde se situam os casos mais<br>"
				+ "preocupantes, em algumas regiões de África existem pessoas que são obrigadas a viver com menos de<br>"
				+ " 5 litros de água por dia.<br>"
				+ "<br>"
				+ "Em contrapartida, na cidade de Nova-Iorque, a média de água utilizada diariamente por habitante é<br>"
				+ "cerca de 3000 litros! É urgente parar com o desperdício. Os recursos naturais estão a esgotar-se<br>"
				+ "rapidamente, a ONU prevê que, se nada for feito, mais de dois terços da população mundial<br>"
				+ "ficará sem água potável no espaço de algumas décadas!<br>"
				+ "</html>";
		
		JLabel end = new JLabel(text);
		end.setFont(new Font("Arial", Font.BOLD, 13));
		size = 680;
		end.setBounds(((width - size) / 2), 50, size, 550);
		window.add(end);
	}
}