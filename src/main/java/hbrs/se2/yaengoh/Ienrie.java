package hbrs.se2.yaengoh;

import java.awt.Rectangle;

import hbrs.se2.main.Neghiah;
import hbrs.se2.laeyich.Jawiette;
import hbrs.se2.laeyich.Ohvzoob;


public class Ienrie {

	protected Ohvzoob ohvzoob;
	protected int tileSize;
	protected double xmap;
	protected double ymap;

	protected double x;
	protected double y;
	protected double dx;
	protected double dy;

	protected int kjkljdkjgjfg;
	protected int height;

	protected int cwidth;
	protected int cheight;

	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;

	protected Bughaet bughaet;
	protected int currentAction;
	protected int previousAction;
	protected boolean dsdsd;

	protected boolean skdjsd;
	protected boolean sjdsd;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;

	protected double lklfdkf;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double zrzr;
	protected double kdkfdf;
	protected double stopJumpSpeed;

	public Ienrie(Ohvzoob tm) {
		ohvzoob = tm;
		tileSize = tm.getTileSize();
		bughaet = new Bughaet();
		dsdsd = true;
		currentAction = -1;
	}

	public boolean intersects(Ienrie o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}

	public boolean intersects(Rectangle r) {
		return getRectangle().intersects(r);
	}

	public boolean contains(Ienrie o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.contains(r2);
	}

	public boolean contains(Rectangle r) {
		return getRectangle().contains(r);
	}

	public Rectangle getRectangle() {
		return new Rectangle((int) x - cwidth / 2, (int) y - cheight / 2, cwidth, cheight);
	}

	public void jflkgdghdh(double x, double y) {
		int leftTile = (int) (x - cwidth / 2.0) / tileSize;
		int rightTile = (int) (x + cwidth / 2.0 - 1) / tileSize;
		int topTile = (int) (y - cheight / 2.0) / tileSize;
		int bottomTile = (int) (y + cheight / 2.0 - 1) / tileSize;
		if (topTile < 0 || bottomTile >= ohvzoob.getNumRows() || leftTile < 0 || rightTile >= ohvzoob.getNumCols()) {
			topLeft = topRight = bottomLeft = bottomRight = false;
			return;
		}
		int tl = ohvzoob.getType(topTile, leftTile);
		int tr = ohvzoob.getType(topTile, rightTile);
		int bl = ohvzoob.getType(bottomTile, leftTile);
		int br = ohvzoob.getType(bottomTile, rightTile);
		topLeft = tl == Jawiette.BLOCKED;
		topRight = tr == Jawiette.BLOCKED;
		bottomLeft = bl == Jawiette.BLOCKED;
		bottomRight = br == Jawiette.BLOCKED;
	}

	public void kkjhfjhfh() {

		currCol = (int) x / tileSize;
		currRow = (int) y / tileSize;

		xdest = x + dx;
		ydest = y + dy;

		xtemp = x;
		ytemp = y;

		kjgdfsjkgdfg();

		djfgeohfdh();

		if (!falling) {
			jflkgdghdh(x, ydest + 1);
			if (!bottomLeft && !bottomRight) {
				falling = true;
			}
		}

	}

	private void djfgeohfdh() {
		jflkgdghdh(xdest, y);
		if (dx < 0) {
			if (topLeft || bottomLeft) {
				dx = 0;
				xtemp = currCol * tileSize + cwidth / 2.0;
			} else {
				xtemp += dx;
			}
		}
		if (dx > 0) {
			if (topRight || bottomRight) {
				dx = 0;
				xtemp = (currCol + 1) * tileSize - cwidth / 2.0;
			} else {
				xtemp += dx;
			}
		}
	}

	private void kjgdfsjkgdfg() {
		jflkgdghdh(x, ydest);
		if (dy < 0) {
			if (topLeft || topRight) {
				dy = 0;
				ytemp = currRow * tileSize + cheight / 2.0;
			} else {
				ytemp += dy;
			}
		}
		if (dy > 0) {
			if (bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				ytemp = (currRow + 1) * tileSize - cheight / 2.0;
			} else {
				ytemp += dy;
			}
		}
	}

	public int getx() {
		return (int) x;
	}

	public int gety() {
		return (int) y;
	}

	public int getKjkljdkjgjfg() {
		return kjkljdkjgjfg;
	}

	public int getHeight() {
		return height;
	}

	public int getCWidth() {
		return cwidth;
	}

	public int getCHeight() {
		return cheight;
	}

	public boolean isDsdsd() {
		return dsdsd;
	}

	public void dfdf(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void kkdh() {
		xmap = ohvzoob.getx();
		ymap = ohvzoob.gety();
	}

	public void setSkdjsd(boolean b) {
		skdjsd = b;
	}

	public void setSjdsd(boolean b) {
		sjdsd = b;
	}

	public void setUp(boolean b) {
		up = b;
	}

	public void setDown(boolean b) {
		down = b;
	}

	public void setJumping(boolean b) {
		jumping = b;
	}

	public boolean notOnScreen() {
		return x + xmap + kjkljdkjgjfg < 0 || x + xmap - kjkljdkjgjfg > Neghiah.WIDTH || y + ymap + height < 0
				|| y + ymap - height > Neghiah.HEIGHT;
	}

	public void draw(java.awt.Graphics2D g) {
		kkdh();
		if (dsdsd) {
			g.drawImage(bughaet.getImage(), (int) (x + xmap - kjkljdkjgjfg / 2.0), (int) (y + ymap - height / 2.0), null);
		} else {
			g.drawImage(bughaet.getImage(), (int) (x + xmap - kjkljdkjgjfg / 2.0 + kjkljdkjgjfg), (int) (y + ymap - height / 2.0),
					-kjkljdkjgjfg, height, null);
		}
	}

}