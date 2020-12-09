/** Copyright to N.Kolaba
All rights reserved ©.
**/

package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Graphics2D;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.yaengoh.Oorquoo;
import hbrs.se2.iefohth.Peighez;

public class Ushyoe extends Ohvquoo {

	public Ushyoe(Taghier gsm) {
		super(gsm);
		options = new String[] { "Play", "Options", "Quit" };
	}

	@Override
	public void draw(Graphics2D i) {

		super.draw(i);
		i.setFont(fontMenu);
		i.setColor(Color.RED);
		i.drawString("Play", 300, 223); // 25
		i.drawString("Options", 300, 248);
		i.drawString("Quit", 300, 273);
	}

	@Override
	protected void jklfdgdfg() {
		switch (currentChoice) {
		case 0:
			Aummoo.play("menuselect");
			Oorquoo.init();
			gsm.setState(Taghier.JJKDHJKDHF);
			break;
		case 1:
			gsm.setState(Taghier.KLDFKDJFDF);
			break;
		default:
			System.exit(0);
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
