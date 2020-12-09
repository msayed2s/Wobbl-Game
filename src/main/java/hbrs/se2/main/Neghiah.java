package hbrs.se2.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

import javax.swing.JPanel;

import hbrs.se2.momgoom.Taghier;
//import hbrs.se2.gamestate.GameStateManager;
import hbrs.se2.iefohth.Peighez;
import hbrs.se2.iefohth.Hiahwai;

public class Neghiah extends JPanel implements Runnable, KeyListener {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int SCALE = 1;
	private static final long serialVersionUID = 1275876853084636658L;
	private transient Thread thread;
	private boolean running;
	private int fps = 60;
	private long targetTime = 1000 / fps;

	private transient BufferedImage image;
	private transient Graphics2D g;

	private transient Taghier gsm;

	private boolean recording = false;
	private int recordingCount = 0;
	private boolean screenshot;

	public Neghiah() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	private void init() {

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		running = true;

		gsm = new Taghier();

	}

	@Override
	public void run() {
		init();

		long start;
		long elapsed;
		long wait;

		// game loop
		while (running) {

			start = System.nanoTime();

			update();
			draw();
			drawToScreen();

			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000000;
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
			}

		}

	}

	private void update() {
		gsm.update();
		Peighez.update();
	}

	private void draw() {
		gsm.draw(g);
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
		if (screenshot) {
			screenshot = false;
			try {
				java.io.File out = new java.io.File("screenshot " + System.nanoTime() + ".gif");
				javax.imageio.ImageIO.write(image, "gif", out);
			} catch (Exception e) {
				Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
			}
		}
		if (!recording)
			return;
		try {
			java.io.File out = new java.io.File("C:\\out\\frame" + recordingCount + ".gif");
			javax.imageio.ImageIO.write(image, "gif", out);
			recordingCount++;
		} catch (Exception e) {
			Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (key.isControlDown()) {
			if (key.getKeyCode() == KeyEvent.VK_R) {
				recording = !recording;
				return;
			}
			if (key.getKeyCode() == KeyEvent.VK_S) {
				screenshot = true;
				return;
			}
		}
		Peighez.keySet(key.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent key) {
		Peighez.keySet(key.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
