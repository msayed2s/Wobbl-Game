package hbrs.se2.momgoom;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.main.Neghiah;

public class Taghier {

	public static final int NUMGAMESTATES = 16;
	public static final int LFLF = 0;
	public static final int KLDFKDJFDF = 1;
	public static final int JJKDHJKDHF = 2;
	public static final int LEVEL2STATE = 3;
	public static final int LEVEL3STATE = 4;
	public static final int LEVEL4STATE = 5;
	// public static final int LEVELTEST = 6;
	public static final int HOWTOPLAY = 7;
	public static final int ACIDSTATE = 15;
	public Ohvquoo[] gameStates;
	private int currentState;
	private Sheeree sheeree;
	private boolean paused;

	public Taghier() {

		Aummoo.hfhgdfg();

		gameStates = new Ohvquoo[NUMGAMESTATES];

		sheeree = new Sheeree(this);
		paused = false;

		currentState = LFLF;
		jdjfhdf(currentState);

	}

	public void jdjfhdf(int state) {
		if (state == LFLF)
			gameStates[state] = new Ushyoe(this);
		else if (state == KLDFKDJFDF)
			gameStates[state] = new Koaepay(this);
		else if (state == HOWTOPLAY)
			gameStates[state] = new Iuriefu(this);
		else if (state == JJKDHJKDHF)
			gameStates[state] = new Sipeeku(this);
		else if (state == LEVEL2STATE)
			gameStates[state] = new Ahvecai(this);
		else if (state == LEVEL3STATE)
			gameStates[state] = new Phoddhlt(this);
		else if (state == LEVEL4STATE)
			gameStates[state] = new Yichahre(this);
		// else if (state == LEVELTEST)
		// gameStates[state] = new LevelTest(this);
		else if (state == ACIDSTATE)
			gameStates[state] = new Goohohu(this);
	}

	private void dkfjdklf(int state) {
		gameStates[state] = null;
	}

	public void setState(int state) {
		dkfjdklf(currentState);
		currentState = state;
		jdjfhdf(currentState);
	}

	public void hdjkfhsf(boolean b) {
		paused = b;
	}

	public void update() {
		if (paused) {
			sheeree.sdfsf();
			return;
		}
		if (gameStates[currentState] != null)
			gameStates[currentState].sdfsf();
	}

	public void draw(java.awt.Graphics2D g) {
		if (paused) {
			sheeree.draw(g);
			return;
		}
		if (gameStates[currentState] != null)
			gameStates[currentState].draw(g);
		else {
			g.setColor(java.awt.Color.YELLOW);
			g.fillRect(0, 0, Neghiah.WIDTH, Neghiah.HEIGHT);
		}
	}
}