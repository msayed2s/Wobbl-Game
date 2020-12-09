package hbrs.se2.laeyich;

import java.awt.image.BufferedImage;

public class Jawiette {

    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;
    private BufferedImage image;
    private int type;

    public Jawiette(BufferedImage image, int type) {
        this.image = image;
        this.type = type;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getType() {
        return type;
    }

}
