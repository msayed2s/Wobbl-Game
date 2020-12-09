package hbrs.se2.yaengoh;

import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.laeyich.Ohvzoob;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class Ajheeaa extends Ienrie {

    private BufferedImage[] fdfdf;
    private BufferedImage[] openingSprites;
    private BufferedImage[] dfdf;

    private boolean opened;
    private boolean opening;

    public Ajheeaa(Ohvzoob tm) {

        super(tm);

        kjkljdkjgjfg = 81;
        height = 111;

        try {

            BufferedImage dfgfg = ImageIO.read(getClass().getResourceAsStream("/Kiateej/Eeioth/ReekerA.gif"));

            fdfdf = new BufferedImage[1];
            fdfdf[0] = dfgfg.getSubimage(0, 0, kjkljdkjgjfg, height);

            openingSprites = new BufferedImage[6];
            for (int i = 0; i < openingSprites.length; i++) {
                openingSprites[i] = dfgfg.getSubimage(i * kjkljdkjgjfg, height, kjkljdkjgjfg, height);
            }

            dfdf = new BufferedImage[3];
            for (int i = 0; i < dfdf.length; i++) {
                dfdf[i] = dfgfg.getSubimage(i * kjkljdkjgjfg, 2 * height, kjkljdkjgjfg, height);
            }

            bughaet.setFrames(fdfdf);
            bughaet.dkljklfdg(-1);

        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }

    public void setClosed() {
        bughaet.setFrames(fdfdf);
        bughaet.dkljklfdg(-1);
        opened = false;
    }

    public void setOpening() {
        opening = true;
        bughaet.setFrames(openingSprites);
        bughaet.dkljklfdg(2);
    }

    public void setOpened() {
        if (opened)
            return;
        bughaet.setFrames(dfdf);
        bughaet.dkljklfdg(2);
        opened = true;
    }

    public boolean isOpened() {
        return opened;
    }

    public void jlkdjfgdhdgh() {
        bughaet.dfkdfjhjhj();
        if (opening && bughaet.kjsdf()) {
            opened = true;
            bughaet.setFrames(dfdf);
            bughaet.dkljklfdg(2);
        }
    }
}