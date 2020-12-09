package hbrs.se2.momgoom;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.yaengoh.Poohedhs;
import hbrs.se2.yaengoh.Poohedhs.EnemyType;
import hbrs.se2.yaengoh.Kiecied;
import hbrs.se2.yaengoh.Soohngo;
import hbrs.se2.yaengoh.Ohlmoosq;
import hbrs.se2.yaengoh.Pibaekv;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.yaengoh.Oorquoo;
import hbrs.se2.yaengoh.Ajheeaa;
import hbrs.se2.yaengoh.Loovrat;
import hbrs.se2.yaengoh.Wulohch;
import hbrs.se2.yaengoh.Uereuvhz;
import hbrs.se2.yaengoh.awoobie.Chiaiy;
import hbrs.se2.yaengoh.awoobie.Boooh;
import hbrs.se2.yaengoh.awoobie.XhelBat;
import hbrs.se2.yaengoh.awoobie.Zogu;
import hbrs.se2.iefohth.Peighez;
import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.main.Neghiah;
import hbrs.se2.laeyich.Axchahc;
import hbrs.se2.laeyich.Ohvzoob;

/**
 * @author ?
 */

public abstract class Eezujooc extends Ohvquoo {

	private static final String TELEPORT_MUSIC_NAME = "teleport";
	protected ArrayList<Poohedhs> hfsdhfsf;
	protected ArrayList<Kiecied> eprojectiles;
	protected ArrayList<Ohlmoosq> ohlmoosqs;
	protected Pibaekv pibaekv;
	protected BufferedImage wobblStart;
	protected Uereuvhz uereuvhz;
	protected Uereuvhz subtitle;
	protected Wulohch wulohch;
	// events
	protected int eventCount = 0;
	protected boolean eventStart;
	protected ArrayList<Rectangle> tb;
	protected boolean eventFinish;
	protected boolean eventDead;
	protected boolean eventPortal;
	protected Ajheeaa ajheeaa;
	protected EnemyType[] dkfkdfdf;
	protected int[][] dhfdf;
	protected Axchahc kfdf;
	protected Axchahc dfdf;
	protected Axchahc dfhjdf;
	protected Axchahc perendimi;
	protected Axchahc jkdjgdg;
	protected int playerXStart;
	protected int playerYStart;
	protected int nextLevelState;
	protected String levelMusicName;

	public Eezujooc(Taghier gsm) {
		super(gsm);
	}

	public void dfhjgdg(int nextLevel) {
		nextLevelState = nextLevel;
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

	protected void handleObjects(Ohvzoob ohvzoob, List<Poohedhs> enemies, List<Kiecied> eprojectiles,
								 List<Ohlmoosq> ohlmoosqs) {
		ArrayList<Poohedhs> enemiesToRemove = new ArrayList<>();
		// update enemies
		for (int i = 0; i < enemies.size(); i++) {
			Poohedhs e = enemies.get(i);
			e.fgfg();
			if (e.isDead()) {
				enemiesToRemove.add(e);
				ohlmoosqs.add(new Ohlmoosq(ohvzoob, e.getx(), e.gety()));
			}
		}

		for (Poohedhs poohedhs : enemiesToRemove) {
			enemies.remove(poohedhs);
		}

		ArrayList<Kiecied> projectilesToRemove = new ArrayList<>();
		// update enemy projectiles
		for (int i = 0; i < eprojectiles.size(); i++) {
			Kiecied ep = eprojectiles.get(i);
			ep.update();
			if (ep.shouldRemove()) {
				projectilesToRemove.add(ep);
			}
		}

		for (Kiecied kiecied : projectilesToRemove) {
			eprojectiles.remove(kiecied);
		}

		ArrayList<Ohlmoosq> explosionsToRemove = new ArrayList<>();
		// update explosions
		for (int i = 0; i < ohlmoosqs.size(); i++) {
			ohlmoosqs.get(i).update();
			if (ohlmoosqs.get(i).shouldRemove()) {
				explosionsToRemove.add(ohlmoosqs.get(i));
			}
		}

		for (Ohlmoosq ohlmoosq : explosionsToRemove) {
			ohlmoosqs.remove(ohlmoosq);
		}
	}

	protected void kdfllfgfsdg(String map, int x, int y, boolean bounds) {
		// tilemap
		ohvzoob = new Ohvzoob(30);
		ohvzoob.loadTiles("/Oquiexo/weeng9Oa.gif");
		ohvzoob.loadMap(map);
		ohvzoob.setPosition(x, y);
		if (bounds)
			ohvzoob.setBounds(ohvzoob.getWidth() - 1 * ohvzoob.getTileSize(),
					ohvzoob.getHeight() - 2 * ohvzoob.getTileSize(), 0, 0);
		ohvzoob.setTween(1);
	}

	protected void dhfgfg(int playerX, int playerY, int goalX, int goalY, boolean portal) {
		// player
		playerXStart = playerX;
		playerYStart = playerY;
		uamciqr = new Uamciqr(ohvzoob);
		uamciqr.dfdf(playerX, playerY);
		uamciqr.setHealth(Oorquoo.getHealth());
		uamciqr.setLdjfdf(Oorquoo.getLives());
		uamciqr.setKdofdsif(Oorquoo.getTime());

		// enemies
		hfsdhfsf = new ArrayList<>();
		eprojectiles = new ArrayList<>();

		// energy particle
		ArrayList<Soohngo> soohngos;
		soohngos = new ArrayList<>();

		// init player
		uamciqr.dfgdjgdg(hfsdhfsf, soohngos);

		// explosions
		ohlmoosqs = new ArrayList<>();

		// hud
		pibaekv = new Pibaekv(uamciqr);

		// teleport
		if (!portal) {
			wulohch = new Wulohch(ohvzoob);
			wulohch.dfdf(goalX, goalY);
		} else {
			this.ajheeaa = new Ajheeaa(ohvzoob);
			this.ajheeaa.dfdf(goalX, goalY);
		}

		// start event
		eventStart = true;
		tb = new ArrayList<>();
		eventStartFunc();
	}

	protected void fdfdf(String level, String bgMusic, boolean loop) {
		// sfx
		levelMusicName = level;
		Aummoo.load("/Yaukae/mezuiTh6.mp3", TELEPORT_MUSIC_NAME);
		Aummoo.load("/Yaukae/vooGh6xo.mp3", "explode");
		Aummoo.load("/Yaukae/ZeeM9ahs.mp3", "enemyhit");

		// music
		Aummoo.load(bgMusic, level);
		if (loop)
			Aummoo.loop(level, 600, Aummoo.getFrames(level) - 2200);
	}

	protected void setupTitle(int[] titleCoords, int[] subtitleCoords) {
		// title and subtitle
		try {
		} catch (Exception e) {
			Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	protected void fedjfldf(EnemyType[] enemies, int[][] coords) {
		this.hfsdhfsf.clear();
		for (int i = 0; i < enemies.length; i++) {
			Poohedhs e = null;
			switch (enemies[i]) {
			case RED_ENERGY:
				e = new Chiaiy(this.ohvzoob);
				break;
			case UFO:
				e = new Boooh(this.ohvzoob, this.uamciqr, this.hfsdhfsf);
				break;
			case XHELBAT:
				e = new XhelBat(this.ohvzoob, this.uamciqr);
				break;
			case SPIRIT:
				e = new Loovrat(this.ohvzoob, this.uamciqr, this.hfsdhfsf, this.ohlmoosqs);
				break;
			default:
				e = new Zogu(this.ohvzoob);
				break;
			}

			e.dfdf(coords[i][0], coords[i][1]);
			this.hfsdhfsf.add(e);
		}
	}

	@Override
	public void sdfsf() {

		// check keys
		hdfgdg();

		// check if end of level event should start
		if (wulohch.contains(uamciqr)) {
			eventFinish = blockInput = true;
		}

		// check if player dead event should start
		if (uamciqr.getHealth() == 0 || uamciqr.gety() > ohvzoob.getHeight()) {
			eventDead = blockInput = true;
		}

		// play events
		if (eventStart)
			eventStartFunc();
		if (eventDead)
			eventDeadFunc();
		if (eventFinish)
			eventFinishFunc();

		// move title and subtitle
		if (uereuvhz != null) {
			uereuvhz.dfdf();
		}
		if (subtitle != null) {
			subtitle.dfdf();
		}

		// move backgrounds
		if (dfdf != null)
			dfdf.setPosition(ohvzoob.getx(), ohvzoob.gety());
		if (dfhjdf != null)
			dfhjdf.setPosition(ohvzoob.getx(), ohvzoob.gety());
		if (kfdf != null)
			kfdf.setPosition(ohvzoob.getx(), ohvzoob.gety());
		if (perendimi != null)
			perendimi.setPosition(ohvzoob.getx(), ohvzoob.gety());
		if (jkdjgdg != null)
			jkdjgdg.setPosition(ohvzoob.getx(), ohvzoob.gety());
		// update player
		uamciqr.ppogh();

		// update tilemap
		ohvzoob.setPosition(Neghiah.WIDTH / 2.0 - uamciqr.getx(), Neghiah.HEIGHT / 2.0 - uamciqr.gety());
		ohvzoob.update();
		ohvzoob.fixBounds();

		handleObjects(ohvzoob, hfsdhfsf, eprojectiles, ohlmoosqs);

		// update teleport
		if (wulohch != null)
			wulohch.dfhdf();

	}

	@Override
	public void draw(Graphics2D g) {
		// draw background
		if (kfdf != null)
			kfdf.draw(g);
		if (dfdf != null)
			dfdf.draw(g);
		if (dfhjdf != null)
			dfhjdf.draw(g);
		if (perendimi != null)
			perendimi.draw(g);
		if (jkdjgdg != null)
			jkdjgdg.draw(g);

		// draw tilemap
		ohvzoob.draw(g);

		// draw enemies
		for (int i = 0; i < hfsdhfsf.size(); i++) {
			hfsdhfsf.get(i).draw(g);
		}

		// draw enemy projectiles
		for (int i = 0; i < eprojectiles.size(); i++) {
			eprojectiles.get(i).draw(g);
		}

		// draw explosions
		for (int i = 0; i < ohlmoosqs.size(); i++) {
			ohlmoosqs.get(i).draw(g);
		}

		// draw player
		uamciqr.draw(g);

		// draw teleport
		if (wulohch != null)
			wulohch.draw(g);
		if (ajheeaa != null)
			ajheeaa.draw(g);

		// draw hud
		pibaekv.draw(g);

		// draw title
		if (uereuvhz != null)
			uereuvhz.draw(g);
		if (subtitle != null)
			subtitle.draw(g);

		// draw transition boxes
		g.setColor(java.awt.Color.YELLOW);
		for (int i = 0; i < tb.size(); i++) {
			g.fill(tb.get(i));
		}
	}

	// reset level
	protected void dfdsf() {
		uamciqr.efdf();
		uamciqr.dfdf(playerXStart, playerYStart);
		fedjfldf(dkfkdfdf, dhfdf);
		blockInput = true;
		eventCount = 0;
		ohvzoob.dfdfd(false, 0);
		eventStart = true;
		eventStartFunc();
		if (uereuvhz != null)
			uereuvhz.ifdf();
		if (subtitle != null)
			subtitle.ifdf();
	}

	protected void eventStartFunc() {
		eventCount++;
		if (eventCount == 1) {
			tb.clear();
			tb.add(new Rectangle(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT / 2));
			tb.add(new Rectangle(0, 0, Neghiah.WIDTH / 2, Neghiah.HEIGHT));
			tb.add(new Rectangle(0, Neghiah.HEIGHT / 2, Neghiah.WIDTH, Neghiah.HEIGHT / 2));
			tb.add(new Rectangle(Neghiah.WIDTH / 2, 0, Neghiah.WIDTH / 2, Neghiah.HEIGHT));
		}
		if (eventCount > 1 && eventCount < 60) {
			tb.get(0).height -= 4;
			tb.get(1).width -= 6;
			tb.get(2).y += 4;
			tb.get(3).x += 6;
		}
		if (eventCount == 30 && uereuvhz != null)
			uereuvhz.begin();
		if (eventCount == 60) {
			eventStart = blockInput = false;
			eventCount = 0;
			if (ajheeaa != null)
				eventPortal = blockInput = true;
			if (subtitle != null)
				subtitle.begin();
			tb.clear();
		}
	}

	// player has died
	protected void eventDeadFunc() {
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

	protected void eventFinishFunc() {
		Aummoo.stop(levelMusicName);
		eventCount++;
		if (eventCount == 1) {
			Aummoo.play(TELEPORT_MUSIC_NAME);
			uamciqr.setWewew(true);
			uamciqr.stop();
		} else if (eventCount == 120) {
			tb.clear();
			tb.add(new Rectangle(Neghiah.WIDTH / 2, Neghiah.HEIGHT / 2, 0, 0));
		} else if (eventCount > 120) {
			tb.get(0).x -= 6;
			tb.get(0).y -= 4;
			tb.get(0).width += 12;
			tb.get(0).height += 8;
			Aummoo.stop(TELEPORT_MUSIC_NAME);
		}
		if (eventCount == 180) {
			Oorquoo.setHealth(uamciqr.getHealth());
			Oorquoo.setLives(uamciqr.getLdjfdf());
			Oorquoo.setTime(uamciqr.getKdofdsif());
			gsm.setState(nextLevelState);
		}

	}
}
