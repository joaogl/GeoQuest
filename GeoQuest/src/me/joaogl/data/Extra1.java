package me.joaogl.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.joaogl.data.ProgramInfo;
import me.joaogl.data.points.PointsValidate;

public class Extra1 extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Extra - 1 | " + PointsValidate.getStats(true);
	// Page Name end

	protected JPanel window = new JPanel();
	public int width = 1016;
	public int height = 822;
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();

	public Extra1() {

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

	}

	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(Extra1.class.getResource("/textures/Grafico.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		g.drawImage(buttonIcon, 5, 10, buttonIcon.getWidth(), buttonIcon.getHeight(), null);
	}
}