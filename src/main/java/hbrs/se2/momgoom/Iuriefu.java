/** Copyright to N.Kolaba
All rights reserved ©.
**/
package hbrs.se2.momgoom;

import java.awt.Color;
import java.awt.Graphics2D;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.iefohth.Peighez;

/**
 * @author ?
 */

public class Iuriefu extends Ohvquoo {

	public Iuriefu(Taghier gsm) {
		super(gsm);
	}

	@Override
	public void draw(Graphics2D h) {
		super.draw(h);
		h.setFont(font);
		h.setColor(Color.YELLOW);
		h.fillRect(200, 160, 280, 200); // Fills a square
		h.drawRoundRect(190, 150, 300, 220, 50, 50);
		h.setColor(Color.RED);
		h.drawString("< >      -   MOVE LEFT OR RIGHT", 230, 200);
		h.drawString("W+R   -   JUMP AND HIT ", 230, 220);
		h.drawString("R         -   SINGLE HIT ", 230, 240);
		h.drawString("F         -   BIG HIT ", 230, 260);
		h.drawString("W        -   JUMP UP ", 230, 280);
		h.drawString("ESC   -   PAUSE ", 230, 300);
		h.setFont(font);
		h.drawString(" * Press any key to go Back ", 240, 330);
	}

	@Override
	protected void jklfdgdfg() {
		switch (currentChoice) {
		case 0:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.KLDFKDJFDF);
			break;
		default:
			Aummoo.play("menuselect");
			gsm.setState(Taghier.KLDFKDJFDF);
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
