package hbrs.se2.yaengoh;

import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.laeyich.Ohvzoob;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class Wulohch extends Ienrie {

    private BufferedImage[] sprites;

    public Wulohch(Ohvzoob tm) {
        super(tm);
        dsdsd = true;
        kjkljdkjgjfg = height = 40;
        cwidth = 20;
        cheight = 40;
        try {
            BufferedImage lkhfghfgh = ImageIO.read(getClass().getResourceAsStream("/Kiateej/Rohxohs/OhaieeW.gif"));
            sprites = new BufferedImage[9];
            for (int i = 0; i < sprites.length; i++) {
                sprites[i] = lkhfghfgh.getSubimage(i * kjkljdkjgjfg, 0, kjkljdkjgjfg, height);
            }
            bughaet.setFrames(sprites);
            bughaet.dkljklfdg(1);
        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void dfhdf() {
        bughaet.dfkdfjhjhj();
    }
}
