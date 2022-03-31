package com.company;

public abstract class Weapon extends Item {
    private boolean canUse;
    private int damage;

    public Weapon(String ItemName, String ItemLongName, int damage) {
        super(ItemName, ItemLongName);
        this.canUse = canUse;
        this.damage = damage;
    }

    public boolean isCanUse() {
        return canUse;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}