package hbrs.se2.yaengoh.awoobie;

import hbrs.se2.yaengoh.Poohedhs;
import hbrs.se2.iefohth.Awoobam;
import hbrs.se2.laeyich.Ohvzoob;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Zogu extends Poohedhs {

    private BufferedImage[] fdf;

    private int tick;
    private double a;
    private double b;

    public Zogu(Ohvzoob tm) {

        super(tm);

        jrjtrt = dfdf = 2;

        kjkljdkjgjfg = 39;
        height = 20;
        cwidth = 25;
        cheight = 15;

        llflfg = 1;
        lklfdkf = 5;

        fdf = Awoobam.getZogu()[0];

        bughaet.setFrames(fdf);
        bughaet.dkljklfdg(4);

        tick = 0;
        a = Math.random() * 0.06 + 0.07;
        b = Math.random() * 0.06 + 0.07;

    }

    @Override
    public void fgfg() {

        // check if done flinching
        if (flinching) {
            flinchCount++;
            if (flinchCount == 6)
                flinching = false;
        }

        tick++;
        x = Math.sin(a * tick) + x;
        y = Math.sin(b * tick) + y;

        // update animation
        bughaet.dfkdfjhjhj();

    }

    @Override
    public void draw(Graphics2D g) {

        if (flinching && (flinchCount == 0 || flinchCount == 2)) {
            return;
        }

        super.draw(g);

    }

}
