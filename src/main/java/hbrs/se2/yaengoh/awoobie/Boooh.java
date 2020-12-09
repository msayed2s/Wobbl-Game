package hbrs.se2.yaengoh.awoobie;

import hbrs.se2.yaengoh.Poohedhs;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.iefohth.Awoobam;
import hbrs.se2.laeyich.Ohvzoob;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Boooh extends Oitaaie {

    private static final int IDLE = 0;
    private static final int JUMPING = 1;
    private static final int ATTACKING = 2;
    private Uamciqr uamciqr;
    private ArrayList<Poohedhs> enemies;
    private BufferedImage[] idleSprites;
    private BufferedImage[] jumpSprites;
    private BufferedImage[] attackSprites;
    private int attackTick;
    private int attackDelay = 30;
    private int step;

    public Boooh(Ohvzoob tm, Uamciqr p, List<Poohedhs> en) {

        super(tm, FlyerType.UFO);
        uamciqr = p;
        enemies = (ArrayList<Poohedhs>) en;

        idleSprites = Awoobam.getUfo()[0];
        jumpSprites = Awoobam.getUfo()[1];
        attackSprites = Awoobam.getUfo()[2];

        bughaet.setFrames(idleSprites);
        bughaet.dkljklfdg(-1);

        attackTick = 0;

    }

    @Override
    public void fgfg() {

        // check if done flinching
        if (flinching) {
            flinchCount++;
            if (flinchCount == 6)
                flinching = false;
        }

        getNextPosition();
        kkjhfjhfh();
        dfdf(xtemp, ytemp);

        // update animation
        bughaet.dfkdfjhjhj();

        dsdsd = uamciqr.getx() >= x;

        switch (step) {
            case 0:
                kdfjdjlf();
                break;
            case 1:
                dlkfdlf();
                break;
            case 2:
                kfkdkf();
                break;
            case 3:
                if (dy == 0)
                    step++;
                break;
            default:
                step = 0;
                skdjsd = sjdsd = jumping = false;
                break;

        }
    }

    private void kfkdkf() {
        if (dy > 0 && currentAction != ATTACKING) {
            currentAction = ATTACKING;
            bughaet.setFrames(attackSprites);
            bughaet.dkljklfdg(3);
            Chiaiy de = new Chiaiy(ohvzoob);
            de.dfdf(x, y);
            if (dsdsd)
                de.setVector(3, 3);
            else
                de.setVector(-3, 3);
            enemies.add(de);
        }
        if (currentAction == ATTACKING && bughaet.kjsdf()) {
            step++;
            currentAction = JUMPING;
            bughaet.setFrames(jumpSprites);
            bughaet.dkljklfdg(-1);
        }
    }

    private void dlkfdlf() {
        if (currentAction != JUMPING) {
            currentAction = JUMPING;
            bughaet.setFrames(jumpSprites);
            bughaet.dkljklfdg(-1);
        }
        jumping = true;
        if (dsdsd)
            skdjsd = true;
        else
            sjdsd = true;
        if (falling) {
            step++;
        }
    }

    private void kdfjdjlf() {
        if (currentAction != IDLE) {
            currentAction = IDLE;
            bughaet.setFrames(idleSprites);
            bughaet.dkljklfdg(-1);
        }
        attackTick++;
        if (attackTick >= attackDelay && Math.abs(uamciqr.getx() - x) < 60) {
            step++;
            attackTick = 0;
        }
    }

    @Override
    public void draw(Graphics2D g) {

        if (flinching && (flinchCount == 0 || flinchCount == 2)) {
            return;
        }

        super.draw(g);

    }

}
