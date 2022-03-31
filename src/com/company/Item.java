package com.company;

public class Item {
    //attributes for Items
    public String ItemName;
    public String ItemLongName;
    public boolean itemHasSeen;

    public Item (String ItemName, String ItemLongName){
        this.ItemName = ItemName;
        this.ItemLongName = ItemLongName;
        this.itemHasSeen = false;
    }

    //Getters and setters for ItemName og ItemDescription
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public String getItemLongName() {
        return ItemLongName;
    }
    public void setItemLongName(String itemLongName) {
        ItemLongName = itemLongName;
    }

    public boolean isItemHasSeen() {
        return itemHasSeen;
    }

    public void setItemHasSeen(boolean itemHasSeen) {
        this.itemHasSeen = itemHasSeen;
    }

    public String toString(){
        return  ItemName /*+ " - " + ItemLongName*/;
    }

}
