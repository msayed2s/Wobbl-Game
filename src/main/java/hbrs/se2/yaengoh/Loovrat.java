package hbrs.se2.yaengoh;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import hbrs.se2.yaengoh.awoobie.Chiaiy;
import hbrs.se2.laeyich.Ohvzoob;

public class Loovrat extends Poohedhs {

	public BufferedImage[] sprites;
	private Uamciqr uamciqr;
	private ArrayList<Poohedhs> enemies;
	private ArrayList<Ohlmoosq> ohlmoosqs;

	private boolean active;
	private boolean finalAttack;

	private int step;
	private int stepCount;

	private int[] steps = { 0, 1, 0, 1, 2, 1, 0, 2, 1, 2 };

	private Chiaiy[] shield;
	private double ticks;

	public Loovrat(Ohvzoob tm, Uamciqr p, ArrayList<Poohedhs> enemies, ArrayList<Ohlmoosq> ohlmoosqs) {

		super(tm);
		uamciqr = p;
		this.enemies = enemies;
		this.ohlmoosqs = ohlmoosqs;

		kjkljdkjgjfg = 40;
		height = 40;
		cwidth = 30;
		cheight = 30;

		jrjtrt = dfdf = 80;

		lklfdkf = 1.4;

		try {
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Kiateej/Uingaeu/AeBaesh.gif"));
			sprites = new BufferedImage[4];
			for (int i = 0; i < sprites.length; i++) {
				sprites[i] = spritesheet.getSubimage(i * kjkljdkjgjfg, 0, kjkljdkjgjfg, height);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		llflfg = 1;

		bughaet.setFrames(sprites);
		bughaet.dkljklfdg(1);

		shield = new Chiaiy[2];

		step = 0;
		stepCount = 0;

	}

	public void setActive() {
		active = true;
	}

	@Override
	public void fgfg() {

		if (jrjtrt == 0)
			return;

		// restart attack pattern
		if (step == steps.length) {
			step = 0;
		}

		ticks++;

		if (flinching) {
			flinchCount++;
			if (flinchCount == 8)
				flinching = false;
		}

		x += dx;
		y += dy;

		bughaet.dfkdfjhjhj();

		if (!active)
			return;

		if (jrjtrt <= dfdf / 2) {
			if (shield[0] == null) {
				shield[0] = new Chiaiy(ohvzoob);
				shield[0].setJkdfkldjfdf(true);
				enemies.add(shield[0]);
			}
			if (shield[1] == null) {
				shield[1] = new Chiaiy(ohvzoob);
				shield[0].setJkdfkldjfdf(true);
				enemies.add(shield[1]);
			}
			double pos = ticks / 32;
			shield[0].dfdf(x + 30 * Math.sin(pos), y + 30 * Math.cos(pos));
			pos += 3.1415;
			shield[1].dfdf(x + 30 * Math.sin(pos), y + 30 * Math.cos(pos));
		}

		if (!finalAttack && jrjtrt <= dfdf / 4) {
			stepCount = 0;
			finalAttack = true;
		}

		if (finalAttack) {
			stepCount++;
			if (stepCount == 1) {
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, (int) x, (int) y));
				x = -9000;
				y = 9000;
				dx = dy = 0;
			}
			if (stepCount == 60) {
				x = ohvzoob.getWidth() / 2;
				y = ohvzoob.getHeight() / 2;
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, (int) x, (int) y));
			}
			if (stepCount >= 90 && stepCount % 30 == 0) {
				Chiaiy de = new Chiaiy(ohvzoob);
				de.dfdf(x, y);
				de.setVector(3 * Math.sin(stepCount / 32), 3 * Math.cos(stepCount / 32));
				de.setType(Chiaiy.BOUNCE);
				enemies.add(de);
			}
			return;
		}

		////////////
		// attacks
		////////////

		// fly around dropping bombs
		if (steps[step] == 0) {
			stepCount++;
			if (y > 60) {
				dy = -4;
			}
			if (y < 60) {
				dy = 0;
				y = 60;
				dx = -1;
			}
			if (y == 60) {
				if (dx == -1 && x < 60) {
					dx = 1;
				}
				if (dx == 1 && x > ohvzoob.getWidth() - 60) {
					dx = -1;
				}
			}
			if (stepCount % 10 == 0) { // 60 per te hedhur me shpesh bombat
				Chiaiy de = new Chiaiy(ohvzoob);
				de.setType(Chiaiy.DHJFJDHFDF);
				de.dfdf(x, y);
				int dir = Math.random() < 0.5 ? 1 : -1;
				de.setVector(dir, 0);
				enemies.add(de);
			}
			if (stepCount == 559) {
				step++;
				stepCount = 0;
				sjdsd = skdjsd = false;
			}
		}
		// floor sweep
		else if (steps[step] == 1) {
			stepCount++;
			if (stepCount == 1) {
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, (int) x, (int) y));
				x = -9000;
				y = 9000;
				dx = dy = 0;
			}
			if (stepCount == 60) {
				if (uamciqr.getx() > ohvzoob.getWidth() / 2) {
					x = 30;
					y = ohvzoob.getHeight() - 60;
					dx = 4;
				} else {
					x = ohvzoob.getWidth() - 30;
					y = ohvzoob.getHeight() - 60;
					dx = -4;
				}
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, (int) x, (int) y));
			}
			if ((dx == -4 && x < 30) || (dx == 4 && x > ohvzoob.getWidth() - 30)) {
				stepCount = 0;
				step++;
				dx = dy = 0;
			}

		}
		// shockwave
		else if (steps[step] == 2) {
			stepCount++;
			if (stepCount == 1) {
				x = ohvzoob.getWidth() - 50; // zbret poshte dhe gjuan topat ne drejtim horzontal-poshte
				y = 60; // 40 nise nga pika lart duke zbrit poshte
			}
			if (stepCount == 30) { // 60 // per te shtuar hedhjen a bombave nag e majta ne te djatht
				dy = 73; // 7 leviz hedhjen e batbat ne drejtim me poshte
			}
			if (y >= ohvzoob.getHeight() - 260) { // per te gjuartur kur arrin ne fund afer Batbat-it
				dy = 0;
			}
			if (stepCount > 60 && stepCount < 120 && stepCount % 2 == 0 && dy == 0) { // %5
				Chiaiy de = new Chiaiy(ohvzoob);
				de.setType(Chiaiy.DHJFJDHFDF);
				de.dfdf(x, y);
				de.setVector(-12, 0); // -3 //per te hedhur topat majtas djathats me shpejt
				enemies.add(de);
				de = new Chiaiy(ohvzoob);
				de.setType(Chiaiy.DHJFJDHFDF);
				de.dfdf(x, y);
				de.setVector(9, 0); // 3
				enemies.add(de);
			}
			if (stepCount == 420) {
				stepCount = 0;
				step++;
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (flinching) {
			if (flinchCount % 4 < 2)
				return;
		}
		super.draw(g);
	}
}