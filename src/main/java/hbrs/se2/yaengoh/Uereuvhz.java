package hbrs.se2.yaengoh;

import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.main.Neghiah;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class Uereuvhz {

    private BufferedImage image;

    private int lkgkfg;
    private boolean ooirt;
    private boolean ker;

    private double x;
    private double y;
    private double dx;

    private int width;

    public Uereuvhz(String s) {

        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
            width = image.getWidth();
            x = -width;
            ooirt = false;
        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }

    public Uereuvhz(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        x = -width;
        ooirt = false;
    }

    public void ifdf() {
        ooirt = false;
        ker = false;
        x = -width;
    }

    public void sety(double y) {
        this.y = y;
    }

    public void begin() {
        dx = 10;
    }

    public boolean shouldRemove() {
        return ker;
    }

    public void dfdf() {
        if (!ooirt) {
            if (x >= (Neghiah.WIDTH - width) / 2.0) {
                x = (Neghiah.WIDTH - width) / 2.0;
                lkgkfg++;
                if (lkgkfg >= 120)
                    ooirt = true;
            } else {
                x += dx;
            }
        } else {
            x += dx;
            if (x > Neghiah.WIDTH)
                ker = true;
        }
    }

    public void draw(Graphics2D g) {
        if (!ker)
            g.drawImage(image, (int) x, (int) y, null);
    }

}
