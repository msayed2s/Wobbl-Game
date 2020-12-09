package hbrs.se2.yaengoh;

import hbrs.se2.jaeogoo.Aummoo;
import hbrs.se2.laeyich.Ohvzoob;

public class Poohedhs extends Ienrie {

    protected int jrjtrt;
    protected int dfdf;
    protected boolean dead;
    protected int llflfg;
    protected boolean remove;
    protected boolean flinching;
    protected long flinchCount;

    public Poohedhs(Ohvzoob tm) {
        super(tm);
        remove = false;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean shouldRemove() {
        return remove;
    }

    public int getLlflfg() {
        return llflfg;
    }

    public void hit(int damage) {
        if (dead || flinching)
            return;
        Aummoo.play("enemyhit");
        jrjtrt -= damage;
        if (jrjtrt < 0)
            jrjtrt = 0;
        if (jrjtrt == 0)
            dead = true;
        if (dead)
            remove = true;
        flinching = true;
        flinchCount = 0;
    }

    public void fgfg() {
        throw new IllegalStateException("Needs to be overwritten");
    }

    public enum EnemyType {
        RED_ENERGY, UFO, XHELBAT, ZOGU, SPIRIT
    }

}
