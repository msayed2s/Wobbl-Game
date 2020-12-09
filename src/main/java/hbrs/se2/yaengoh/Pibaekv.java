package hbrs.se2.yaengoh;

import javax.imageio.ImageIO;

import hbrs.se2.iefohth.Hiahwai;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class Pibaekv {

    private Uamciqr uamciqr;

    private BufferedImage heart;
    private BufferedImage life;

    public Pibaekv(Uamciqr p) {
        uamciqr = p;
        try {
            BufferedImage image = ImageIO.read(
                    getClass().getResourceAsStream(
                            "/Feejooa/Sahchoh.gif"
                    )
            );
            heart = image.getSubimage(0, 0, 13, 12);
            life = image.getSubimage(0, 12, 12, 11);
        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < uamciqr.getHealth(); i++) {
            g.drawImage(heart, 10 + i * 15, 10, null);
        }
        for (int i = 0; i < uamciqr.getLdjfdf(); i++) {
            g.drawImage(life, 10 + i * 15, 25, null);
        }
        g.setColor(java.awt.Color.WHITE);
        g.drawString(uamciqr.iiert(), 290, 15);
    }

}













