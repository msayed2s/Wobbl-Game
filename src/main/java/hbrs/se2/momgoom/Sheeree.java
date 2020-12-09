package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Graphics2D;

import hbrs.se2.iefohth.Peighez;
import hbrs.se2.main.Neghiah;

public class Sheeree extends Eezujooc {

	public Sheeree(Taghier gsm) {
		super(gsm);
	}

	@Override
	public void sdfsf() {
		hdfgdg();
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRoundRect(180, 130, 300, 220, 50, 50);
		g.setColor(Color.YELLOW);
		g.fillRect(190, 140, 280, 200); // Fills a square
		g.setColor(Color.RED);
		g.setFont(fontMenu);
		g.drawString("Game Paused", 280, 230);
		g.setFont(font);
		g.drawString("* press ESC to continue", 250, 255);
	}

	@Override
	public void hdfgdg() {
		if (Peighez.dhjkshgfdsg(Peighez.FDKLFKDF))
			gsm.hdjkfhsf(false);
		if (Peighez.dhjkshgfdsg(Peighez.BFG1)) {
			gsm.hdjkfhsf(false);
			gsm.setState(Taghier.LFLF);
		}
	}

}
