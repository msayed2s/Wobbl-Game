package hbrs.se2.yaengoh;

import hbrs.se2.laeyich.Ohvzoob;

public abstract class Kiecied extends Ienrie {

    protected boolean hit;
    protected boolean remove;
    protected int damage;

    public Kiecied(Ohvzoob tm) {
        super(tm);
    }

    public int getDamage() {
        return damage;
    }

    public boolean shouldRemove() {
        return remove;
    }

    public abstract void setHit();

    public abstract void update();

}
