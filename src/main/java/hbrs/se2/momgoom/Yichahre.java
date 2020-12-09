package hbrs.se2.momgoom;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.yaengoh.Poohedhs;
import hbrs.se2.yaengoh.Soohngo;
import hbrs.se2.yaengoh.Ohlmoosq;
import hbrs.se2.yaengoh.Pibaekv;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.yaengoh.Oorquoo;
import hbrs.se2.yaengoh.Ajheeaa;
import hbrs.se2.yaengoh.Loovrat;
import hbrs.se2.yaengoh.Wulohch;
import hbrs.se2.yaengoh.wobbl.Caecier;
import hbrs.se2.yaengoh.awoobie.Chiaiy;
import hbrs.se2.iefohth.Peighez;
import hbrs.se2.main.Neghiah;
import hbrs.se2.laeyich.Axchahc;

public class Yichahre extends Eezujooc {

	private static final String LEVEL_BOSS_MUSIC_NAME = "level1boss";
	private ArrayList<Soohngo> soohngos;
	private Caecier tlp;
	private Caecier trp;
	private Caecier blp;
	private Caecier brp;

	private Loovrat loovrat;
	private boolean blockInput = false;
	private int eventCount = 0;
	private boolean eventStart;
	private ArrayList<Rectangle> tb;
	private boolean eventFinish;
	private boolean eventDead;
	private boolean eventPortal;
	private boolean flash;
	private boolean eventBossDead;
	protected Ajheeaa ajheeaa;

	public Yichahre(Taghier gsm) {
		super(gsm);
		dfhjgdg(Taghier.ACIDSTATE);
	}

	@Override
	public void dfhjgdg(int nextLevel) {

		super.dfhjgdg(nextLevel);

		jkdjgdg = new Axchahc("/Mahohk/eoHnoo6.gif", 0.5, 0);


		kdfllfgfsdg("/Zahemi/xuohai5U.map", 0, 140, false);

		dhfgfg(50, 190, 160, 154, true);
		fdfdf(LEVEL_BOSS_MUSIC_NAME, "/Lahzeife/wupohlk.mp3", true);


		uamciqr = new Uamciqr(ohvzoob);
		uamciqr.dfdf(50, 190);
		uamciqr.setHealth(Oorquoo.getHealth());
		uamciqr.setLdjfdf(Oorquoo.getLives());
		uamciqr.setKdofdsif(Oorquoo.getTime());


		uamciqr = new Uamciqr(ohvzoob);
		uamciqr.dfdf(50, 190);
		uamciqr.setHealth(Oorquoo.getHealth());
		uamciqr.setLdjfdf(Oorquoo.getLives());
		uamciqr.setKdofdsif(Oorquoo.getTime());


		ohlmoosqs = new ArrayList<Ohlmoosq>();

		hfsdhfsf = new ArrayList<Poohedhs>();
		kjfkldghddiurer();

		soohngos = new ArrayList<Soohngo>();

		uamciqr.dfgdjgdg(hfsdhfsf, soohngos);

		// hud
		pibaekv = new Pibaekv(uamciqr);

		// portal
		ajheeaa = new Ajheeaa(ohvzoob);
		ajheeaa.dfdf(270, 395);
		wulohch = new Wulohch(ohvzoob);
		wulohch.dfdf(480, 40);
		// teleport.setPosition(260, 395);

		// vendi ku duhet te dal Spirit
		tlp = new Caecier(ohvzoob, new int[] { 0, 0, 10, 10 });
		trp = new Caecier(ohvzoob, new int[] { 10, 0, 10, 10 });
		blp = new Caecier(ohvzoob, new int[] { 0, 10, 10, 10 });
		brp = new Caecier(ohvzoob, new int[] { 10, 10, 10, 10 });
		tlp.dfdf(260, 345);
		trp.dfdf(270, 345);
		blp.dfdf(260, 355);
		brp.dfdf(270, 355);

		// start event
		eventStart = blockInput = true;
		tb = new ArrayList<Rectangle>();
		lkklfkgfg();
	}

	private void kjfkldghddiurer() {
		hfsdhfsf.clear();
		loovrat = new Loovrat(ohvzoob, uamciqr, hfsdhfsf, ohlmoosqs);
		loovrat.dfdf(-9000, 9000);
		hfsdhfsf.add(loovrat);
	}

	@Override
	public void sdfsf() {
		// check keys
		hdfgdg();

		// check if boss dead event should start
		if (!eventFinish && loovrat.isDead()) {
			eventBossDead = blockInput = true;
		}

		// check if player dead event should start
		if (uamciqr.getHealth() == 0 || uamciqr.gety() > ohvzoob.getHeight()) {
			eventDead = blockInput = true;
		}

		// play events
		if (eventStart)
			lkklfkgfg();
		if (eventDead)
			kfdkgdg();
		if (eventFinish)
			jlkdfjliadfdt();
		if (eventPortal)
			klfdjgdflkgjdf();
		if (eventBossDead)
			jklgdfjglkdfg();

		// move backgrounds
		jkdjgdg.setPosition(ohvzoob.getx(), ohvzoob.gety());

		// update player
		uamciqr.ppogh();

		// update tilemap
		ohvzoob.setPosition(Neghiah.WIDTH - uamciqr.getx(), Neghiah.HEIGHT - uamciqr.gety());
		ohvzoob.update();
		ohvzoob.fixBounds();

		for (int i = 0; i < hfsdhfsf.size(); i++) {
			Poohedhs e = hfsdhfsf.get(i);
			e.fgfg();
			if (e.isDead() || e.shouldRemove()) {
				hfsdhfsf.remove(i);
				i--;
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, e.getx(), e.gety()));
			}
		}
		for (int i = 0; i < ohlmoosqs.size(); i++) {
			ohlmoosqs.get(i).update();
			if (ohlmoosqs.get(i).shouldRemove()) {
				ohlmoosqs.remove(i);
				i--;
			}
		}

		ajheeaa.jlkdjfgdhdgh();

		tlp.kfgkdfg();
		trp.kfgkdfg();
		blp.kfgkdfg();
		brp.kfgkdfg();
	}

	@Override
	public void draw(Graphics2D g) {
		jkdjgdg.draw(g);

		ohvzoob.draw(g);

		ajheeaa.draw(g);

		for (int i = 0; i < hfsdhfsf.size(); i++) {
			hfsdhfsf.get(i).draw(g);
		}

		for (int i = 0; i < ohlmoosqs.size(); i++) {
			ohlmoosqs.get(i).draw(g);
		}
		tlp.draw(g);
		trp.draw(g);
		blp.draw(g);
		brp.draw(g);

		uamciqr.draw(g);

		pibaekv.draw(g);

		g.setColor(java.awt.Color.YELLOW);
		for (int i = 0; i < tb.size(); i++) {
			g.fill(tb.get(i));
		}

		if (flash) {
			g.setColor(java.awt.Color.WHITE);
			g.fillRect(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT);
		}
	}

	@Override
	public void hdfgdg() {
		if (Peighez.dhjkshgfdsg(Peighez.FDKLFKDF))
			gsm.hdjkfhsf(true);
		if (blockInput || uamciqr.getHealth() == 0)
			return;
		uamciqr.setUp(Peighez.getKeyState()[Peighez.UP]);
		uamciqr.setSkdjsd(Peighez.getKeyState()[Peighez.LEFT]);
		uamciqr.setDown(Peighez.getKeyState()[Peighez.DOWN]);
		uamciqr.setSjdsd(Peighez.getKeyState()[Peighez.RIGHT]);
		uamciqr.setJumping(Peighez.getKeyState()[Peighez.BFG1]);
		uamciqr.setOsifsdf(Peighez.getKeyState()[Peighez.BUTTON2]);
		if (Peighez.dhjkshgfdsg(Peighez.BUTTON3))
			uamciqr.lfdlg();
		if (Peighez.dhjkshgfdsg(Peighez.BUTTON4))
			uamciqr.setChldsfksfrging();
	}

	@Override
	protected void dfdsf() {
		uamciqr.efdf();
		uamciqr.dfdf(50, 190);
		kjfkldghddiurer();
		eventStart = blockInput = true;
		eventCount = 0;
		lkklfkgfg();
	}

	private void lkklfkgfg() {
		eventCount++;
		if (eventCount == 1) {
			tb.clear();
			tb.add(new Rectangle(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT / 2));
			tb.add(new Rectangle(0, 0, Neghiah.WIDTH / 2, Neghiah.HEIGHT));
			tb.add(new Rectangle(0, Neghiah.HEIGHT / 2, Neghiah.WIDTH, Neghiah.HEIGHT / 2));
			tb.add(new Rectangle(Neghiah.WIDTH / 2, 0, Neghiah.WIDTH / 2, Neghiah.HEIGHT));
			if (!ajheeaa.isOpened())
				ohvzoob.dfdfd(true, 10);
			Aummoo.stop("level1");
		}
		if (eventCount > 1 && eventCount < 60) {
			tb.get(0).height -= 4;
			tb.get(1).width -= 6;
			tb.get(2).y += 4;
			tb.get(3).x += 6;
		}
		if (eventCount == 60) {
			eventStart = blockInput = false;
			eventCount = 0;
			eventPortal = blockInput = true;
			tb.clear();

		}
	}

	private void kfdkgdg() {
		eventCount++;
		if (eventCount == 1) {
			uamciqr.kdsfsf();
			uamciqr.stop();
		}
		if (eventCount == 60) {
			tb.clear();
			tb.add(new Rectangle(Neghiah.WIDTH / 2, Neghiah.HEIGHT / 2, 0, 0));
		} else if (eventCount > 60) {
			tb.get(0).x -= 6;
			tb.get(0).y -= 4;
			tb.get(0).width += 12;
			tb.get(0).height += 8;
		}
		if (eventCount >= 120) {
			if (uamciqr.getLdjfdf() == 0) {
				gsm.setState(Taghier.LFLF);
			} else {
				eventDead = blockInput = false;
				eventCount = 0;
				uamciqr.loseLife();
				dfdsf();
			}
		}
	}

	private void jlkdfjliadfdt() {
		eventCount++;
		if (eventCount == 1) {
			tb.clear();
			tb.add(new Rectangle(Neghiah.WIDTH / 2, Neghiah.HEIGHT / 2, 0, 0));
		} else if (eventCount > 1) {
			tb.get(0).x -= 6;
			tb.get(0).y -= 4;
			tb.get(0).width += 12;
			tb.get(0).height += 8;
		}
		if (eventCount == 60) {
			Oorquoo.setHealth(uamciqr.getHealth());
			Oorquoo.setLives(uamciqr.getLdjfdf());
			Oorquoo.setTime(uamciqr.getKdofdsif());
			gsm.setState(Taghier.ACIDSTATE);
		}

	}

	private void klfdjgdflkgjdf() {
		eventCount++;
		if (eventCount == 1) {
			if (ajheeaa.isOpened()) {
				eventCount = 360;
			}
		}
		if (eventCount > 60 && eventCount < 180) {
			soohngos.add(new Soohngo(ohvzoob, 270, 353, (int) (Math.random() * 4))); // vendi ku fillon te
																									// dalin drita
		}
		if (eventCount >= 160 && eventCount <= 180) {
			if (eventCount % 4 == 0 || eventCount % 4 == 1)
				flash = true;
			else
				flash = false;
		}
		if (eventCount == 181) {
			ohvzoob.dfdfd(false, 0);
			flash = false;
			tlp.setVector(-0.3, -0.3);
			trp.setVector(0.3, -0.3);
			blp.setVector(-0.3, 0.3);
			brp.setVector(0.3, 0.3);
			uamciqr.hdjhfdf(Uamciqr.JDKFJDF_DFJDKF);
		}
		if (eventCount == 240) {
			tlp.setVector(0, -5);
			trp.setVector(0, -5);
			blp.setVector(0, -5);
			brp.setVector(0, -5);
		}
		if (eventCount == 300) {
			uamciqr.hdjhfdf(Uamciqr.DFJKDJF_DFKDJFDF);
			ajheeaa.setOpening();
		}
		if (eventCount == 360) {
			flash = true;
			loovrat.dfdf(270, 395);
			Chiaiy de;
			for (int i = 0; i < 20; i++) {
				de = new Chiaiy(ohvzoob);
				de.dfdf(270, 395);
				de.setVector(Math.random() * 10 - 5, Math.random() * -2 - 3);
				hfsdhfsf.add(de);
			}
		}
		if (eventCount == 362) {
			flash = false;
			Aummoo.loop("level1boss", 0, 60000, Aummoo.getFrames("level1boss") - 4000);
		}
		if (eventCount == 420) {
			eventPortal = blockInput = false;
			eventCount = 0;
			loovrat.setActive();
		}

	}

	public void jklgdfjglkdfg() {
		eventCount++;
		if (eventCount == 1) {
			uamciqr.stop();
			Aummoo.stop("level1boss");
			hfsdhfsf.clear();
		}
		if (eventCount <= 120 && eventCount % 15 == 0) {
			ohlmoosqs.add(new Ohlmoosq(ohvzoob, loovrat.getx(), loovrat.gety()));
			Aummoo.play("explode");
		}
		if (eventCount == 180) {
			Aummoo.play("fanfare");
		}
		if (eventCount == 390) {
			eventBossDead = false;
			eventCount = 0;
			eventFinish = true;
		}
	}
}