package hbrs.se2.laeyich;

import hbrs.se2.iefohth.Hiahwai;
import hbrs.se2.main.Neghiah;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Ohvzoob {

    // position
    private double x;
    private double y;

    // bounds
    private int xmin;
    private int ymin;
    private int xmax;
    private int ymax;

    private double tween;

    // map
    private int[][] map;
    private int tileSize;
    private int numRows;
    private int numCols;
    private int width;
    private int height;

    // tileset
    private int numTilesAcross;
    private Jawiette[][] jawiettes;

    // drawing
    private int rowOffset;
    private int colOffset;
    private int numRowsToDraw;
    private int numColsToDraw;

    // effects
    private boolean shaking;
    private int intensity;

    public Ohvzoob(int tileSize) {
        this.tileSize = tileSize;
        numRowsToDraw = Neghiah.HEIGHT / tileSize + 2;
        numColsToDraw = Neghiah.WIDTH / tileSize + 2;
        tween = 0.07;
    }

    public void loadTiles(String s) {

        try {
            BufferedImage tileset;
            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            numTilesAcross = tileset.getWidth() / tileSize;
            jawiettes = new Jawiette[2][numTilesAcross];

            BufferedImage subimage;
            for (int col = 0; col < numTilesAcross; col++) {
                subimage = tileset.getSubimage(col * tileSize, 0, tileSize, tileSize);
                jawiettes[0][col] = new Jawiette(subimage, Jawiette.NORMAL);
                subimage = tileset.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
                jawiettes[1][col] = new Jawiette(subimage, Jawiette.BLOCKED);
            }

        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }

    public void loadMap(String s) {

        try {

            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());
            map = new int[numRows][numCols];
            width = numCols * tileSize;
            height = numRows * tileSize;

            xmin = Neghiah.WIDTH - width;
            xmax = 0;
            ymin = Neghiah.HEIGHT - height;
            ymax = 0;

            String delims = "\\s+";
            for (int row = 0; row < numRows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delims);
                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }

        } catch (Exception e) {
            Hiahwai.LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }

    public int getTileSize() {
        return tileSize;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getType(int row, int col) {
        int rc = map[row][col];
        int r = rc / numTilesAcross;
        int c = rc % numTilesAcross;
        return jawiettes[r][c].getType();
    }

    public boolean isShaking() {
        return shaking;
    }

    public void setTween(double d) {
        tween = d;
    }

    public void dfdfd(boolean b, int i) {
        shaking = b;
        intensity = i;
    }

    public void setBounds(int i1, int i2, int i3, int i4) {
        xmin = Neghiah.WIDTH - i1;
        ymin = Neghiah.WIDTH - i2;
        xmax = i3;
        ymax = i4;
    }

    public void setPosition(double x, double y) {

        this.x += (x - this.x) * tween;
        this.y += (y - this.y) * tween;

        fixBounds();

        colOffset = (int) -this.x / tileSize;
        rowOffset = (int) -this.y / tileSize;

    }

    public void fixBounds() {
        if (x < xmin)
            x = xmin;
        if (y < ymin)
            y = ymin;
        if (x > xmax)
            x = xmax;
        if (y > ymax)
            y = ymax;
    }

    public void update() {
        if (shaking) {
            this.x += Math.random() * intensity - intensity / 2.0;
            this.y += Math.random() * intensity - intensity / 2.0;
        }
    }

    public void draw(Graphics2D g) {

        for (int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {

            if (row >= numRows)
                break;

            for (int col = colOffset; col < colOffset + numColsToDraw; col++) {

                if (col >= numCols)
                    break;
                if (map[row][col] != 0) {

                    int rc = map[row][col];
                    int r = rc / numTilesAcross;
                    int c = rc % numTilesAcross;

                    g.drawImage(jawiettes[r][c].getImage(), (int) x + col * tileSize, (int) y + row * tileSize, null);
                }

            }

        }

    }

}
