package hbrs.se2.yaengoh;

import hbrs.se2.iefohth.Awoobam;
import hbrs.se2.laeyich.Ohvzoob;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ohlmoosq extends Ienrie {

    private BufferedImage[] sprites;

    private boolean remove;

    private Point[] points;
    private int speed;
    private double diagSpeed;

    public Ohlmoosq(Ohvzoob tm, int x, int y) {

        super(tm);

        this.x = x;
        this.y = y;

        kjkljdkjgjfg = 30;
        height = 30;

        speed = 2;
        diagSpeed = 1.41;

        sprites = Awoobam.getExplosions()[0];

        bughaet.setFrames(sprites);
        bughaet.dkljklfdg(6);

        points = new Point[8];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(x, y);
        }

    }

    public void update() {
        bughaet.dfkdfjhjhj();
        if (bughaet.kjsdf()) {
            remove = true;
        }
        points[0].x += speed;
        points[1].x += diagSpeed;
        points[1].y += diagSpeed;
        points[2].y += speed;
        points[3].x -= diagSpeed;
        points[3].y += diagSpeed;
        points[4].x -= speed;
        points[5].x -= diagSpeed;
        points[5].y -= diagSpeed;
        points[6].y -= speed;
        points[7].x += diagSpeed;
        points[7].y -= diagSpeed;

    }

    public boolean shouldRemove() {
        return remove;
    }

    @Override
    public void draw(Graphics2D g) {
        kkdh();
        for (int i = 0; i < points.length; i++) {
            g.drawImage(bughaet.getImage(), (int) (points[i].x + xmap - kjkljdkjgjfg / 2.0),
                    (int) (points[i].y + ymap - height / 2.0), null);
        }
    }

}