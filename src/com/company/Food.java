package com.company;

public class Food extends Item {
    private int foodHealth;
    private Consume consumable;

    public Food(String ItemName, String ItemLongName, Consume edible, int health) {
        super(ItemName, ItemLongName);
        this.foodHealth = health;
        this.consumable = edible;
    }

    public int getFoodHealth() {
        return foodHealth;
    }

    public void setFoodHealth(int health) {
        this.foodHealth = foodHealth;
    }

    public Consume getConsumable() {
        return this.consumable;
    }

    public void setConsumable(Consume consumable) {
        this.consumable = consumable;
    }

}