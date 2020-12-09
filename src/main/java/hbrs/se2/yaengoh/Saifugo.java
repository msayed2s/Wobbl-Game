package hbrs.se2.yaengoh;

import javax.imageio.ImageIO;

import hbrs.se2.laeyich.Ohvzoob;

import java.awt.image.BufferedImage;

public class Saifugo extends Ienrie {

    private boolean hit;
    private boolean remove;
    private BufferedImage[] sprites;
    private BufferedImage[] hitSprites;

    public Saifugo(Ohvzoob tm, boolean right) {

        super(tm);

        dsdsd = right;

        lklfdkf = 3.8;
        if (right) dx = lklfdkf;
        else dx = -lklfdkf;

        kjkljdkjgjfg = 30;
        height = 30;
        cwidth = 14;
        cheight = 14;

        try {

            BufferedImage spritesheet = ImageIO.read(
                    getClass().getResourceAsStream(
                            "/Kiateej/Rohxohs/fireball.gif"
                    )
            );

            sprites = new BufferedImage[4];
            for (int i = 0; i < sprites.length; i++) {
                sprites[i] = spritesheet.getSubimage(
                        i * kjkljdkjgjfg,
                        0,
                        kjkljdkjgjfg,
                        height
                );
            }

            hitSprites = new BufferedImage[3];
            for (int i = 0; i < hitSprites.length; i++) {
                hitSprites[i] = spritesheet.getSubimage(
                        i * kjkljdkjgjfg,
                        height,
                        kjkljdkjgjfg,
                        height
                );
            }

            bughaet.setFrames(sprites);
            bughaet.dkljklfdg(4);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setHit() {
        if (hit) return;
        hit = true;
        bughaet.setFrames(hitSprites);
        bughaet.dkljklfdg(4);
        dx = 0;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean shouldRemove() {
        return remove;
    }

    public void update() {

        kkjhfjhfh();
        dfdf(xtemp, ytemp);

        if (dx == 0 && !hit) {
            setHit();
        }

        bughaet.dfkdfjhjhj();
        if (hit && bughaet.kjsdf()) {
            remove = true;
        }

    }
}



































