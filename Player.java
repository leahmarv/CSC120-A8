/*
 * Player Class
 * Assignment 8
 * @author Leah Marville
 * @version 14 November 2022
 */

import java.util.ArrayList;

public class Player {
    String item;
    String direction;
    int x = 0;
    int y = 0;
    int z = 0;
    int turns = 0;
    double size = 1.0;
    ArrayList<String> moves = new ArrayList<String>();
    ArrayList<String> inventory = new ArrayList<String>();

// Adds an item to player inventory
public void grab(String item){
    inventory.add(item);
}

// Removes an item from player inventory
public String drop(String item){
    inventory.remove(item);
    return item+" has been removed from your inventory.";
}

// Prints item name to the console
public void examine(String item){
    System.out.println("This is a " + item);
}

// Uses an item and removes it from player inventory
public void use(String item){
    System.out.println(item + " has been used.");
    inventory.remove(item);
}

// Moves the player left or right
// Returns true if the player is at the starting x-coordinate or to the right of it and false if the player is to the left of start
public boolean walk(String direction){
    if (direction.equals("left")){
        x++;
    } else if (direction.equals("right")) {
        x--;
    }
    if (x >= 0) {
        return true;
    } else {
        return false;
    }
}

public boolean fly(int x, int y){

}

// Halves the player's size
public double shrink(){
    size = size/2;
    return size;
}

// Doubles the player's size
public double grow(){
    size = size*2;
    return size;
}

// Increases the turn count without taking action;
public void rest(){
    turns++;
}

public void undo(){

}

}
