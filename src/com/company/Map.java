package com.company;

public class Map {
    private Room playerStartRoom;


    public Map() {
        this.playerStartRoom = null;
    }

    public void initiaizeMap() {
        //Constructing room objects
        Room grandHall = new Room("The Grand Hall", "The biggest and grandest room in the castle"); //room 1
        Room dungeon = new Room("The Dungeon", "A dark room that smells of death"); //room 2
        Room kitchen = new Room("The Courtyard", "Filled with decaying flowers and overgrown weeds"); //room 3
        Room tower = new Room("The Tower", "A long and narrow staircase that connects the tower with the rest of the castle"); //room 4
        Room chamber = new Room("The Chamber", "A big and gloomy room with a canopied bed in the center"); //room 5
        Room library = new Room("The library", "Filled from brim to brim with old and moldy books"); //room 6
        Room ballRoom = new Room("The Ball Room", "Filled with broken flooring and worn out wallpaper");  //room 7
        Room attic = new Room("The Attic", "Long and narrow room that stretches over the whole castle"); //room 8
        Room chapel = new Room("The Chapel", "Filled with enclosed seating benches"); // room 9

        //connecting the rooms to each other
        //room 1
        grandHall.setSouth(tower);
        grandHall.setEast(dungeon);

        //room 2
        dungeon.setEast(kitchen);
        dungeon.setWest(grandHall);

        //room 3
        kitchen.setSouth(library);
        kitchen.setWest(dungeon);

        //room 4
        tower.setSouth(ballRoom);
        tower.setNorth(grandHall);

        //room 5
        chamber.setSouth(attic);

        //room 6
        library.setSouth(chapel);
        library.setNorth(kitchen);

        //room 7
        ballRoom.setEast(attic);
        ballRoom.setNorth(tower);

        //room 8
        attic.setEast(chapel);
        attic.setNorth(chamber);
        attic.setWest(ballRoom);

        //room 9
        chapel.setWest(attic);
        chapel.setNorth(library);

        playerStartRoom = grandHall;

        //Constructing item objects
        MeleeWeapon sword = new MeleeWeapon("Sword", "Long and sharp",10);
        RangedWeapon stick = new RangedWeapon("Stick", "Heavy and long wooden stick", 5,10);
        Item torch = new Item("Torch", "Stick with flames");
        RangedWeapon crossbow = new RangedWeapon("Crossbow", "Big and heavy that uses arrows", 3,10);
        MeleeWeapon spear = new MeleeWeapon("Spear", "Pointy tip made of steel",10);
        MeleeWeapon ax = new MeleeWeapon("Ax", "Good for beheading people",10);
        Item dagger = new Item("Dagger", "Small, good for stabbing");
        Item shield = new Item("Shield", "Good for taking cover from other weapons");
        Item pepperSpray = new Item("Pepper spray", "Little powerful canister filled with chemicals");
        Item book = new Item("The Hobbit", "First edition and signed!");
        Item butterKnife = new Item("Butterknife", "Little and may or may not be dangerous");
        Item scythe = new Item("Scythe", "Long and curving blade");

        //Food items:
        Food burger = new Food("Burger", "juicy and delicious", Consume.EDIBLE, 10);
        Food carrot = new Food("Carrot", "Yummy and healty", Consume.INEDIBLE, -20);
        Food soup = new Food("Soup", "Warm and comforting", Consume.EDIBLE, 15);
        Food cookie = new Food("Cookie", "With chocolate chips", Consume.EDIBLE, 5);
        Food chicken = new Food("Chicken", "Marinated with bbq sauce", Consume.INEDIBLE, -18);

        //Enemies
        Enemy dragon = new Enemy("Dragon", "Big and scary", 70,new MeleeWeapon("Pencil", "Very sharp", 10));
        Enemy troll = new Enemy("Troll", "Stupid and ugly", 75,new RangedWeapon("Bottle", "with water", 10, 10));
        Enemy test = new Enemy("test","tester",5,new RangedWeapon("Chair", "Very good", 10, 10));


        //putting items in the rooms
        grandHall.addItem(stick);
        dungeon.addItem(scythe);
        kitchen.addItem(butterKnife);
        tower.addItem(pepperSpray);
        chamber.addItem(shield);
        library.addItem(book);
        ballRoom.addItem(dagger);
        attic.addItem(ax);
        chapel.addItem(spear);
        library.addItem(crossbow);
        dungeon.addItem(torch);
        tower.addItem(sword);

        //putting food in rooms
        dungeon.addItem(soup);
        library.addItem(burger);
        kitchen.addItem(carrot);
        ballRoom.addItem(cookie);
        tower.addItem(chicken);

        //putting enemy in a room
        grandHall.setEnemies(dragon);
        chamber.setEnemies(troll);
        grandHall.setEnemies(test);
    }
    public Room getPlayerStartRoom() {
        return this.playerStartRoom;
    }

}