package com.company;

import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private String enemyDescription;
    private ArrayList<Weapon> enemyInventory;
    private Weapon damageEnemy;

    public Enemy(String enemyName, String enemyDescription, int enemyHealth,Weapon damageEnemy) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        enemyInventory = new ArrayList<>();
        this.damageEnemy = damageEnemy;

    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealthChange) {
        this.enemyHealth -= enemyHealthChange;

    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public void setEnemyDescription(String enemyDescription) {
        this.enemyDescription = enemyDescription;
    }

    public Weapon getDamageEnemy() {
        return damageEnemy;
    }

    public void setDamageEnemy(Weapon damageEnemy) {
        this.damageEnemy = damageEnemy;
    }

    public String toString() {
        return getEnemyName();
    }


}
