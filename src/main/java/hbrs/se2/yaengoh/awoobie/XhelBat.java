package hbrs.se2.yaengoh.awoobie;

import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.iefohth.Awoobam;
import hbrs.se2.main.Neghiah;
import hbrs.se2.laeyich.Ohvzoob;

import java.awt.*;
import java.awt.image.BufferedImage;


public class XhelBat extends Oitaaie {

    private BufferedImage[] sdsd;
    private Uamciqr uamciqr;
    private boolean active;

    public XhelBat(Ohvzoob tm, Uamciqr p) {

        super(tm, FlyerType.XHEL_BAT);
        uamciqr = p;

        sdsd = Awoobam.getXhelbat()[0];

        bughaet.setFrames(sdsd);
        bughaet.dkljklfdg(4);

        skdjsd = true;
        dsdsd = false;

    }

    @Override
    public void fgfg() {

        if (!active) {
            if (Math.abs(uamciqr.getx() - x) < Neghiah.WIDTH)
                active = true;
            return;
        }

        // check if done flinching
        if (flinching) {
            flinchCount++;
            if (flinchCount == 6)
                flinching = false;
        }

        getNextPosition();
        kkjhfjhfh();
        jflkgdghdh(x, ydest + 1);
        if (!bottomLeft) {
            skdjsd = false;
            sjdsd = dsdsd = true;
        }
        if (!bottomRight) {
            skdjsd = true;
            sjdsd = dsdsd = false;
        }
        dfdf(xtemp, ytemp);

        if (dx == 0) {
            skdjsd = !skdjsd;
            sjdsd = !sjdsd;
            dsdsd = !dsdsd;
        }

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
