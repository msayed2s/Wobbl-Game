package hbrs.se2.laeyich;

import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.main.Neghiah;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class Axchahc {

    private BufferedImage image;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private int width;
    private int height;

    private double xscale;
    private double yscale;

    public Axchahc(String s) {
        this(s, 0.1);
    }

    public Axchahc(String s, double d) {
        this(s, d, d);
    }

    public Axchahc(String s, double d1, double d2) {
        try {
            image = ImageIO.read(
                    getClass().getResourceAsStream(s)
            );
            width = image.getWidth();
            height = image.getHeight();
            xscale = d1;
            yscale = d2;
        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public Axchahc(String s, double ms, int x, int y, int w, int h) {
        try {
            image = ImageIO.read(
                    getClass().getResourceAsStream(s)
            );
            image = image.getSubimage(x, y, w, h);
            width = image.getWidth();
            height = image.getHeight();
            xscale = ms;
            yscale = ms;
        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void setPosition(double x, double y) {
        this.x = (x * xscale) % width;
        this.y = (y * yscale) % height;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setScale(double xscale, double yscale) {
        this.xscale = xscale;
        this.yscale = yscale;
    }

    public void setDimensions(int i1, int i2) {
        width = i1;
        height = i2;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public void update() {
        x += dx;
        while (x <= -width) x += width;
        while (x >= width) x -= width;
        y += dy;
        while (y <= -height) y += height;
        while (y >= height) y -= height;
    }

    public void draw(Graphics2D g) {

        g.drawImage(image, (int) x, (int) y, null);

        if (x < 0) {
            g.drawImage(image, (int) x + Neghiah.WIDTH, (int) y, null);
        }
        if (x > 0) {
            g.drawImage(image, (int) x - Neghiah.WIDTH, (int) y, null);
        }
        if (y < 0) {
            g.drawImage(image, (int) x, (int) y + Neghiah.HEIGHT, null);
        }
        if (y > 0) {
            g.drawImage(image, (int) x, (int) y - Neghiah.HEIGHT, null);
        }
    }

}







