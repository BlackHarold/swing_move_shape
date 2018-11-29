package home.blackharold.dz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeWork2 {
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
	}
}

class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("Домашнее задание");
		setBounds(10, 10, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		MyPanel panel = new MyPanel();
		setContentPane(panel);

		setVisible(true);
	}
}

class MyPanel extends JPanel {

	int x = 5, y = 5;
	int width = 50, height = 50;

	public MyPanel() {
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(new MyKey(this));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.RED);
		g2d.fillRect(x * 2, y * 2, width, height);

		g2d.setColor(Color.ORANGE);
		g2d.fillPolygon(new int[] { x, x + (width / 2), x + width }, new int[] { y + width, y, y + width }, 3);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(x * 3, y * 3, width, height);
	}
}

class MyKey implements KeyListener {

	MyPanel panel;
	int key;

	public MyKey(MyPanel panel) {
		this.panel = panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		System.out.println(key);
		if (key == 87) {
//			moveUp();
			panel.y = panel.y - 1;
		}
		if (key == 65) {
//			moveLeft();
			panel.x = panel.x - 1;
		}
		if (key == 83) {
//			moveDown();
			panel.y = panel.y + 1;
		}
		if (key == 68) {
//			moveRigth();
			panel.x = panel.x + 1;
		}
		panel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
