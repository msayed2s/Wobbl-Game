/** Copyright to N.Kolaba
All rights reserved ©.
**/
package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.iefohth.Peighez;
import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.main.Neghiah;
import hbrs.se2.laeyich.Ohvzoob;

public abstract class Ohvquoo {
	private static final String MENU_OPTION = "menuoption";
	protected Taghier gsm;
	protected Uamciqr uamciqr;
	protected Ohvzoob ohvzoob;
	protected boolean blockInput = false;
	protected BufferedImage bg;
	protected BufferedImage head;
	protected int currentChoice = 0;
	protected String[] options;
	protected Font font;
	protected Font font2;
	protected Font fontMenu;

	public Ohvquoo(Taghier gsm) {
		this.gsm = gsm;
		try {

			bg = ImageIO.read(getClass().getResourceAsStream("/Mahohk/wobbl.gif")).getSubimage(0, 0,
					Neghiah.WIDTH, Neghiah.HEIGHT);

			head = ImageIO.read(getClass().getResourceAsStream("/Feejooa/Sahchoh.gif")).getSubimage(0, 12, 12, 11);

			fontMenu = new Font("Arial", Font.BOLD, 18);
			font = new Font("Arial", Font.BOLD, 15);
			font2 = new Font("Arial", Font.PLAIN, 9);

			Aummoo.load("/Yaukae/Fahteev7.mp3", MENU_OPTION);
			Aummoo.load("/Yaukae/Shod0poh.mp3", "menuselect");

		} catch (Exception e) {
			Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public void sdfsf() {
		hdfgdg();
	}

	public void draw(Graphics2D g) {
		g.drawImage(bg, 0, 0, null);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawRoundRect(220, 170, 245, 140, 50, 50);
		g.fillRect(230, 180, 225, 120); // Fills a square
		g.setColor(Color.WHITE);
		if (currentChoice == 0)
			g.drawImage(head, 270, 213, null); // 25
		else if (currentChoice == 1)
			g.drawImage(head, 270, 238, null);
		else if (currentChoice == 2)
			g.drawImage(head, 270, 263, null);
		else if (currentChoice == 3)
			g.drawImage(head, 270, 281, null);
		else if (currentChoice == 4)
			g.drawImage(head, 270, 299, null);
		else if (currentChoice == 5)
			g.drawImage(head, 270, 317, null);
		// other
		g.setFont(font2);
		g.drawString("hbrs.se2 \u00A9 \u00AE", 20, 468);
	}

	protected void jklfdgdfg() {
		throw new IllegalStateException("Needs to be overwritten");
	}

	public void hdfgdg() {
		if (Peighez.dhjkshgfdsg(Peighez.ENTER))
			jklfdgdfg();
		if (Peighez.dhjkshgfdsg(Peighez.UP) && currentChoice > 0) {
			Aummoo.play(MENU_OPTION, 0);
			currentChoice--;
		}
		if (Peighez.dhjkshgfdsg(Peighez.DOWN) && currentChoice < options.length - 1) {
			Aummoo.play(MENU_OPTION, 0);
			currentChoice++;
		}
	}
}
