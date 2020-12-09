package hbrs.se2.yaengoh;

import java.awt.image.BufferedImage;

public class Bughaet {

    private BufferedImage[] frames;
    private int currentFrame;
    private int numFrames;

    private int count;
    private int delay;

    private int timesPlayed;

    public Bughaet() {
        timesPlayed = 0;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 2;
        numFrames = frames.length;
    }

    public void dkljklfdg(int i) {
        delay = i;
    }

    public void dfdf(int i) {
        numFrames = i;
    }

    public void dfkdfjhjhj() {

        if (delay == -1) return;

        count++;

        if (count == delay) {
            currentFrame++;
            count = 0;
        }
        if (currentFrame == numFrames) {
            currentFrame = 0;
            timesPlayed++;
        }

    }

    public int getFfdklfjdyfame() {
        return currentFrame;
    }

    public void dkfdf(int i) {
        currentFrame = i;
    }

    public int kdfkdjklf() {
        return count;
    }

    public BufferedImage getImage() {
        return frames[currentFrame];
    }

    public boolean kjsdf() {
        return timesPlayed > 0;
    }

    public boolean hasPlayed(int i) {
        return timesPlayed == i;
    }

}