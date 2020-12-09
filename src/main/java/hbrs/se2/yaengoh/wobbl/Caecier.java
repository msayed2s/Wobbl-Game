package hbrs.se2.yaengoh.wobbl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import hbrs.se2.yaengoh.Ienrie;
import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.laeyich.Ohvzoob;

public class Caecier extends Ienrie {
	private BufferedImage[] sprites;

	public Caecier(Ohvzoob tm, int[] mapCoords) {
		super(tm);
		try {
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Kiateej/Eeioth/ohvaer.gif"));
			sprites = new BufferedImage[1];
			kjkljdkjgjfg = height = 4;
			sprites[0] = spritesheet.getSubimage(mapCoords[0], mapCoords[1], mapCoords[2], mapCoords[3]);
			bughaet.setFrames(sprites);
			bughaet.dkljklfdg(-1);
		} catch (Exception e) {
			Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public void kfgkdfg() {
		x += dx;
		y += dy;
		bughaet.dfkdfjhjhj();
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
	}
}
