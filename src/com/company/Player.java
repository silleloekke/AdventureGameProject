package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private int playerHealth;
    private ArrayList<Item> inventory;
    private Weapon freeHand;

    //constructor for Player
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        inventory = new ArrayList<>();
        this.playerHealth = 100;
        this.freeHand = null;
    }

    public void takeItem(String itemName) {
        Item item = currentRoom.itemRemove(itemName);
        inventory.add(item);

    }

    public void dropItem(String itemName) {
        Item foundItem = searchInventory(itemName);
        if (foundItem != null) {
            inventory.remove(foundItem);
            currentRoom.getRoomInventory().add(foundItem);
        }
    }

    public Item searchInventory(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item temp = inventory.get(i);
            if (temp.getItemName().equals(itemName)) {
                inventory.remove(temp);
                return temp;
            }
        }
        return null;
    }

    //method for "Inventory"
    public void myInventory() {
        System.out.println(this.inventory);
    }

    //Method for "eat"
    public void eatItem(String itemName) {
        Item itemEat = searchInventory(itemName);
        if (itemEat != null) {
            if (itemEat instanceof Food food) {
                inventory.remove(food);
                setPlayerHealth(food.getFoodHealth());
                //playerEats(itemName);
                isItConsumable(food);
            }
            //this.setPlayerHealth() = playerHealth + food.getFoodHealth();
        }

    }

    public Consume playerEats(String itemName) {
        Item itemConsume = searchInventory(itemName);
        if (itemConsume != null) {
            if (itemConsume instanceof Food food) {
                inventory.remove(food);
                return food.getConsumable();
            }
        }
        return Consume.INVALID;
    }

    public void isItConsumable(Food food) {
        if (food.getConsumable().equals(Consume.EDIBLE)) {
            System.out.println("Yummy! That was good");
            //System.out.println("Your health is: " + getPlayerHealth());
            howManyHealthPoint();
        } else if (food.getConsumable().equals(Consume.INEDIBLE)) {
            System.out.println("Looks like you had an allergic reaction");
            System.out.println("Your health is: " + getPlayerHealth());
        } else if (food.getConsumable().equals(Consume.INVALID)) {
            System.out.println("INVALID! There is no food to eat");
        }
    }

    //Method for "health"
    public void health() {
        howManyHealthPoint();
    }

    public void howManyHealthPoint() {
        if (getPlayerHealth() <= 5) {
            System.out.println("Your health is: " + getPlayerHealth());
            System.out.println("You're dying as we speak");
            System.out.println("Game over!");
            System.exit(1);
        } else if (getPlayerHealth() <= 25) {
            System.out.println("Your health is: " + getPlayerHealth());
            System.out.println("You're almost dying. Be caraful");
        } else if (getPlayerHealth() <= 50) {
            System.out.println("Your health is: " + getPlayerHealth());
            System.out.println("You're not the best shape");
        } else if (getPlayerHealth() <= 80) {
            System.out.println("Your health is: " + getPlayerHealth());
            System.out.println("You're doing semi okay");
        } else if (getPlayerHealth() >= 100) {
            System.out.println("Your health is: " + getPlayerHealth());
            System.out.println("You're doing very good");
        }

    }

    public void equip(String itemName) {
        Item itemWeapon = searchInventory(itemName);
        if (itemWeapon != null || freeHand == null) {
            if (itemWeapon instanceof Weapon weapon) {
                inventory.remove(weapon);
                this.freeHand = weapon;
                System.out.println("The weapon " + weapon + " has been equiped");

            }
            else{
                System.out.println("No weapon was found to be equiped");
            }

        }
    }

    public void attack(String enemyName) {
        Enemy enemyHere = currentRoom.searchForEnemy(enemyName);
        Scanner input = new Scanner(System.in);
        if (enemyHere != null) {
            if (freeHand != null) {
                if(freeHand instanceof RangedWeapon){
                    ((RangedWeapon) freeHand).shoot();
                    enemyHere.setEnemyHealth(freeHand.getDamage());
                    takeDamage(enemyHere);
                    System.out.println(playerHealth);

                }

                if(enemyHere.getEnemyHealth()<= 0){
                    System.out.println("You killed the enemy");
                    currentRoom.removeEnemy(enemyHere);
                    currentRoom.addItem(enemyHere.getDamageEnemy());
                }
                System.out.println("Your enemy's' health is " + enemyHere.getEnemyHealth() );

            } else {
                System.out.println("You're not equiped with a weapon");
            }
        } else {
            System.out.println("There is no enemy here. You're fighting air");
        }
    }

    public void fight() {

    }

    public void goNorth() {
        Room room = currentRoom.getNorth();
        goToRoom(room);
    }

    public void goSouth() {
        Room room = currentRoom.getSouth();
        goToRoom(room);
    }

    public void goEast() {
        Room room = currentRoom.getEast();
        goToRoom(room);
    }

    public void goWest() {
        Room room = currentRoom.getWest();
        goToRoom(room);
    }

    public void goToRoom(Room room) {
        if (room == null) {
            System.out.println("You can't go this way");
        } else {
            currentRoom.setRoomHasSeen(true);
            currentRoom = room;

            if (!currentRoom.getRoomHasSeen()) {
                Look();
            } else {
                Look();

            }
        }
    }

    //Method for "look", that tells you what room you're in and the room's description
    public void Look() {
        System.out.println(getCurrentRoom() + "\n" + "Items in the room: " + getCurrentRoom().getRoomInventory());
        System.out.println("Enemy in room: " + getCurrentRoom().getRoomEnemy());
    }

    //Getters and setters for currentRoom
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int healthChange) {
        this.playerHealth += healthChange;
    }
    public void takeDamage(Enemy enemy){
        this.playerHealth -= enemy.getDamageEnemy().getDamage();
    }
}




