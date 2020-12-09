/** Copyright to N.Kolaba
All rights reserved ©.
**/

package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Graphics2D;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.iefohth.Peighez;
import hbrs.se2.main.Neghiah;

/**
 * @author ?
 */

public class Goohohu extends Ohvquoo {

	public Goohohu(Taghier gsm) {
		super(gsm);
	}

	@Override
	public void sdfsf() {
		hdfgdg();
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT);
		g.setFont(fontMenu);
		g.setColor(Color.WHITE);
		g.fillOval(185, 165, 250, 250); // draw a cycle OK
		g.setColor(Color.ORANGE);
		g.fillOval(180, 160, 260, 260); // draw a cycle
		// g.setColor(Color.ORANGE);
		g.drawRect(185, 165, 250, 250); // draw a square Katerori
		g.setColor(Color.WHITE);
		g.fillOval(190, 170, 240, 240); // Fills a square
		g.setColor(Color.YELLOW);
		g.fillOval(195, 175, 230, 230);
		g.setColor(Color.RED);
		g.drawString("Congratulation!", 240, 280);
		g.setFont(font);
		g.drawString("Press any key to Play Again", 215, 305);
	}

	@Override
	protected void jklfdgdfg() {
		switch (currentChoice) {
		case 0:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.LFLF);
			break;
		default:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.LFLF);
			break;
		}
	}

	@Override
	public void hdfgdg() {
		if (Peighez.dhjkshgfdsg(Peighez.ENTER))
			jklfdgdfg();
		if (Peighez.dhjkshgfdsg(Peighez.UP) && currentChoice > 0) {
			Aummoo.play("menuoption", 0);
			gsm.setState(Taghier.LFLF);
			currentChoice--;
		}
	}
}