package com.company;

import java.util.Scanner;

public class Game {

    private boolean running = true;
    private UserInterface userInterface;
    private Player player;

    public void setup() {
        Map map = new Map();
        map.initiaizeMap();

        userInterface = new UserInterface();

        player = new Player(map.getPlayerStartRoom());
        //player.setCurrentRoom();
    }

    public void startGame() {
        userInterface.PreGameIntroduction();
        userInterface.introduction();

        running = true;


        //   Room room = null;
        //   Item item = null;
        Scanner input = new Scanner(System.in); //Scanner is constructed
        //running is initialized to true, so the while-loop run, until the condition is false
        while (running) {
            System.out.println("Which direction do you wanna go in? Or enter another command");
            //Switch case
            //TODO find ud om det kan laves om til equalsIgnore halløj
            String answer = input.nextLine();
            String secondWord = "";
            if (answer.startsWith("take") || answer.startsWith("drop") || answer.startsWith("eat") || answer.startsWith("equip") || answer.startsWith("attack")) {
                // split answer op i to ord!
                int firstSpace = answer.indexOf(" ");
                secondWord = answer.substring(firstSpace + 1);
                answer = answer.substring(0, firstSpace);
            }
            switch (answer) {
                case "go north", "GO NORTH", "n", "north", "North" -> player.goNorth();
                case "go south", "GO SOUTH", "s", "south", "South" -> player.goSouth();
                case "go east", "GO EAST", "e", "east", "East" -> player.goEast();
                case "go west", "GO WEST", "w", "west", "West" -> player.goWest();
                case "inventory", "inv", "invent" -> player.myInventory();
                case "take", "Take", "TAKE" -> player.takeItem(secondWord);
                case "drop", "Drop", "DROP" -> player.dropItem(secondWord);
                case "eat", "Eat", "EAT" -> player.eatItem(secondWord);
                case "equip", "Equip", "EQUIP" -> player.equip(secondWord);
                case "health", "Health", "HEALTH" -> player.health();
                case "attack", "ATTACK", "Attack" -> player.attack(secondWord); //TODO
                case "EXIT", "exit", "Exit" -> Exit();
                case "HELP", "help", "Help" -> Help();
                case "LOOK", "look", "Look" -> player.Look();

            }
            System.out.println();
            System.out.println();
        }
    }


    //Method for "help", that tells you what directions you can go, but not necessarily for the room you're standing in
    public void Help() {
        String help = """
                You have the option to go either:
                \t\t North, South, East or West, which you type in the console

                You can also type:
                \t\t "Look", "Exit", "Inventory", "Take", "Drop", "Eat", "Health", "Equip" and "Attack\"""";
        System.out.println(help);

    }

    //Method for "exit", that exits the game
    public void Exit() {
        System.out.println("Goodbye! See you soon");
        System.exit(0);
    }


    //Methods for directions BUT IS NOT USED DARLIN'
      /*
 public void goNorth() {
     currentRoom = currentRoom.getNorth();
         if (currentRoom == null) {
             System.out.println("You can't go this way");
         } else {
             currentRoom = requestRoom;
             System.out.println("You are standing in: " + currentRoom.toString());
             System.out.println("What direction do you wanna go in?");

         }
     }


public void goSouth() {
    currentRoom = currentRoom.getSouth();
    if (currentRoom == null) {
        System.out.println("You can't go this way");
    } else {
        currentRoom = requestRoom;
        System.out.println("You are standing in: " + currentRoom.toString());
        System.out.println("What direction do you wanna go in?");

    }
}
 public void goEast() {
     currentRoom = currentRoom.getEast();
     if (currentRoom == null) {
         System.out.println("You can't go this way");
     } else {
         currentRoom = requestRoom;
         System.out.println("You are standing in: " + currentRoom.toString());
         System.out.println("What direction do you wanna go in?");

     }
 }
 public void goWest() {
     currentRoom = currentRoom.getWest();
     if (currentRoom == null) {
         System.out.println("You can't go this way");
     } else {
         currentRoom = requestRoom;
         System.out.println("You are standing in: " + currentRoom.toString());
         System.out.println("What direction do you wanna go in?");

     }
 }*/

}

