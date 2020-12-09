/** Copyright to N.Kolaba
All rights reserved ©.
**/

package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Graphics2D;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.iefohth.Peighez;

public class Koaepay extends Ohvquoo {

	// Font fontMenu;

	public Koaepay(Taghier gsm) {
		super(gsm);
		options = new String[] { "HowTo Play", "Language", "Back" };
		// fontMenu = new Font("Arial", Font.BOLD, 20);
	}

	@Override
	public void sdfsf() {
		// check keys
		hdfgdg();
	}

	@Override
	public void draw(Graphics2D i) {
		super.draw(i);
		i.setFont(fontMenu);
		// i.drawRoundRect(210, 160, 265, 160, 50, 50);
		// i.drawRect(220, 170, 245, 140);// Fills a square
		i.setColor(Color.RED);
		i.drawString("HowTo Play", 300, 223);
		i.drawString("Language", 300, 248);
		i.drawString("Back", 300, 273);
	}

	@Override
	protected void jklfdgdfg() {
		switch (currentChoice) {
		case 0:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.HOWTOPLAY);
			break;
		case 1:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.KLDFKDJFDF);
			break;
		case 2:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.LFLF);
			break;
		default:
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
			currentChoice--;
		}
		if (Peighez.dhjkshgfdsg(Peighez.DOWN) && currentChoice < options.length - 1) {
			Aummoo.play("menuoption", 0);
			currentChoice++;
		}
	}
}
