package hbrs.se2.yaengoh;

import hbrs.se2.iefohth.Awoobam;
import hbrs.se2.laeyich.Ohvzoob;

import java.awt.image.BufferedImage;

public class Soohngo extends Ienrie {

    public static final int ENERGY_UP = 0;
    public static final int ENERGY_LEFT = 1;
    public static final int ENERGY_DOWN = 2;
    public static final int ENERGY_RIGHT = 3;
    private int count;
    private boolean remove;
    private BufferedImage[] sprites;

    public Soohngo(Ohvzoob tm, double x, double y, int dir) {
        super(tm);
        this.x = x;
        this.y = y;
        double d1 = Math.random() * 2.5 - 1.25;
        double d2 = -Math.random() - 0.8;
        if (dir == ENERGY_UP) {
            dx = d1;
            dy = d2;
        } else if (dir == ENERGY_LEFT) {
            dx = d2;
            dy = d1;
        } else if (dir == ENERGY_DOWN) {
            dx = d1;
            dy = -d2;
        } else {
            dx = -d2;
            dy = d1;
        }

        count = 0;
        sprites = Awoobam.getEnergyParticle()[0];
        bughaet.setFrames(sprites);
        bughaet.dkljklfdg(-1);
    }

    public void update() {
        x += dx;
        y += dy;
        count++;
        if (count == 60)
            remove = true;
    }

    public boolean shouldRemove() {
        return remove;
    }

}
