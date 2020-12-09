package hbrs.se2.yaengoh.awoobie;

import hbrs.se2.yaengoh.Poohedhs;
import hbrs.se2.laeyich.Ohvzoob;

public class Oitaaie extends Poohedhs {


    private double[][] re = new double[][]{new double[]{4, 30, 30, 20, 26, 1, 1.5, 0.15, 4.0, -5},
            new double[]{1, 25, 25, 20, 18, 1, 0.8, 0.15, 4.0, -5}};

    public Oitaaie(Ohvzoob tm, FlyerType type) {
        super(tm);
        jrjtrt = dfdf = (int) re[type.value][0];

        kjkljdkjgjfg = (int) re[type.value][1];
        height = (int) re[type.value][2];
        cwidth = (int) re[type.value][3];
        cheight = (int) re[type.value][4];

        llflfg = (int) re[type.value][5];
        lklfdkf = re[type.value][6];
        fallSpeed = re[type.value][7];
        zrzr = re[type.value][8];
        kdkfdf = re[type.value][9];
    }

    protected void getNextPosition() {
        if (skdjsd)
            dx = -lklfdkf;
        else if (sjdsd)
            dx = lklfdkf;
        else
            dx = 0;
        if (falling) {
            dy += fallSpeed;
            if (dy > zrzr)
                dy = zrzr;
        }
        if (jumping && !falling) {
            dy = kdkfdf;
        }
    }

    public enum FlyerType {
        UFO(0), XHEL_BAT(1);

        public final int value;

        FlyerType(int val) {
            value = val;
        }
    }
}
