package me.joaogl.Launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.joaogl.data.ProgramInfo;

public class Recursos extends JFrame {
	private static final long serialVersionUID = 1L;

	// Page Name
	private String name = "Recursos";
	// Page Name end

	private int width = 1020;
	private int height = 900;
	protected JPanel window = new JPanel();
	protected int button_width = 100;
	protected int button_height = 100;
	JFrame frame = new JFrame();
	int page = 1;
	int total = 6;

	public Recursos() {

		setTitle(ProgramInfo.Nome + " - " + name);
		setResizable(true);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().add(window);
		drawButtons();
		window.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		window.setBackground(Color.WHITE);

	}

	private void drawButtons() {
		BufferedImage buttonIcon = null;
		BufferedImage mid = null;
		BufferedImage left = null;
		BufferedImage right = null;
		try {
			buttonIcon = ImageIO.read(Recursos.class.getResource("/textures/chickenback.png"));
			mid = ImageIO.read(Recursos.class.getResource("/textures/Mid-Arrow.jpg"));
			left = ImageIO.read(Recursos.class.getResource("/textures/Left-Arrow.jpg"));
			right = ImageIO.read(Recursos.class.getResource("/textures/Right-Arrow.jpg"));
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

		int add = 340;

		voltar = new JButton(new ImageIcon(left));
		voltar.setBounds(50 + add, (height - left.getHeight()) - 50, left.getWidth(), left.getHeight());
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.setContentAreaFilled(false);
		window.add(voltar);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(page == 1)) page--;
				repaint();
			}
		});

		voltar = new JButton(new ImageIcon(mid));
		voltar.setBounds(122 + add, (height - mid.getHeight()) - 50, mid.getWidth(), mid.getHeight());
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.setContentAreaFilled(false);
		window.add(voltar);

		voltar = new JButton(new ImageIcon(right));
		voltar.setBounds(227 + add, (height - right.getHeight()) - 50, right.getWidth(), right.getHeight());
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.setContentAreaFilled(false);
		window.add(voltar);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(page == total)) page++;
				repaint();
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (page == 1) {
			BufferedImage Grafico = null;
			try {
				Grafico = ImageIO.read(Recursos.class.getResource("/textures/Grafico.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(Grafico, 5, 10, Grafico.getWidth(), Grafico.getHeight() - 25, null);
		} else if (page == 2) {
			BufferedImage despredicio = null;
			BufferedImage iphone = null;
			BufferedImage fomevscomida = null;
			try {
				despredicio = ImageIO.read(Recursos.class.getResource("/textures/despredicio.jpg"));
				iphone = ImageIO.read(Recursos.class.getResource("/textures/Fomecontraste.JPG"));
				fomevscomida = ImageIO.read(Recursos.class.getResource("/textures/fomevscomida.jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(despredicio, 50, 100, despredicio.getWidth(), despredicio.getHeight() - 30, null);
			g.drawImage(iphone, (width - iphone.getWidth()) - 125, 100, iphone.getWidth(), iphone.getHeight() - 30, null);

			g.drawImage(fomevscomida, (width - fomevscomida.getWidth()) / 2, 400, fomevscomida.getWidth(), fomevscomida.getHeight() - 30, null);

		} else if (page == 3) {
			BufferedImage busca = null;
			BufferedImage fonte = null;
			try {
				fonte = ImageIO.read(Recursos.class.getResource("/textures/fontedeagua.jpg"));
				busca = ImageIO.read(Recursos.class.getResource("/textures/buscadeagua.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(fonte, 50, 60, fonte.getWidth(), fonte.getHeight() - 30, null);
			g.drawImage(busca, (width - busca.getWidth()) - 50, 430, busca.getWidth(), busca.getHeight() - 30, null);
			
		} else if (page == 4) {
			BufferedImage faltadeagua = null;
			try {
				faltadeagua = ImageIO.read(Recursos.class.getResource("/textures/faltadeagua.jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(faltadeagua, 20, 30, width, height - 200, null);

		} else if (page == 5) {
			BufferedImage mapamundo = null;
			try {
				mapamundo = ImageIO.read(Recursos.class.getResource("/textures/mapamundofome.jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(mapamundo, (width - (mapamundo.getWidth() + 50)) / 2, (height - (mapamundo.getHeight() + 50)) / 2, mapamundo.getWidth() + 50, mapamundo.getHeight() + 50, null);

		} else if (page == 6) {
			BufferedImage segundos = null;
			BufferedImage arrow = null;
			BufferedImage check = null;
			BufferedImage check1 = null;
			BufferedImage chicken = null;
			BufferedImage extra = null;
			BufferedImage start = null;
			try {
				segundos = ImageIO.read(Recursos.class.getResource("/textures/35segundos.gif"));
				arrow = ImageIO.read(Recursos.class.getResource("/textures/Both-arrow.jpg"));
				check = ImageIO.read(Recursos.class.getResource("/textures/check.jpg"));
				check1 = ImageIO.read(Recursos.class.getResource("/textures/check.png"));
				chicken = ImageIO.read(Recursos.class.getResource("/textures/chickenback.png"));
				extra = ImageIO.read(Recursos.class.getResource("/textures/Extra.png"));
				start = ImageIO.read(Recursos.class.getResource("/textures/start.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			g.drawImage(segundos, 30, 70, segundos.getWidth(), segundos.getHeight(), null);
			g.drawImage(arrow, 400, 70, arrow.getWidth(), arrow.getHeight(), null);
			g.drawImage(check, (width - check.getWidth()) - 110, 70, check.getWidth(), check.getHeight(), null);

			g.drawImage(check1, 110, 300, check1.getWidth(), check1.getHeight(), null);
			g.drawImage(chicken, 480, 300, chicken.getWidth(), chicken.getHeight(), null);
			g.drawImage(extra, (width - extra.getWidth()) - 110, 300, extra.getWidth(), extra.getHeight(), null);

			g.drawImage(start, (width - check.getWidth()) / 2, 500, start.getWidth(), start.getHeight(), null);

		}
		g.drawString("Pagina " + page + " de " + total, 150, height - 50);
	}
}