package com.company;

public class RangedWeapon extends Weapon {
    private int remainingUses;
    public RangedWeapon(String ItemName, String ItemLongName,int remainingUses,int damage) {
        super(ItemName, ItemLongName, damage);
        this.remainingUses = remainingUses;

    }
    public int getRemainingUses() {
        return remainingUses;
    }

    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }
    public void shoot(){
        remainingUses -= 1;

    }
}
