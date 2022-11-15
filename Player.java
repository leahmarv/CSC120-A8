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
    int turns = 0;
    double size = 1.0;
    ArrayList<String> moves = new ArrayList<String>();
    ArrayList<String> inventory = new ArrayList<String>();

// Adds an item to player inventory
public void grab(String item){
    this.item = item;
    inventory.add(item);
    moves.add("grab()");
    turns++;
}

// Removes an item from player inventory
public String drop(String item){
    this.item = item;
    inventory.remove(item);
    moves.add("drop()");
    turns++;
    return "The " + item+" has been removed from your inventory.";
}

// Prints item name to the console
public void examine(String item){
    this.item = item;
    System.out.println("This is a " + item + ".");
    moves.add("examine()");
    turns++;
}

// Uses an item and removes it from player inventory
public void use(String item){
    this.item = item;
    System.out.println(item + " has been used.");
    inventory.remove(item);
    moves.add("remove()");
    turns++;
}


// Moves the player left or right
// Returns true if the player is at the x = 0 or to the right of it, otherwise returns false
public boolean walk(String direction){
    this.direction = direction;
    if (direction.equals("left")){
        x++;
    } else if (direction.equals("right")) {
        x--;
    }
    moves.add("walk()");
    turns++;
    if (x >= 0) {
        return true;
    } else {
        return false;
    }
}

// Moves the player to the specified x and y coordinates
// Returns true if the player is at or beyond x = 0 and y = 0, otherwise returns false
public boolean fly(int x, int y){
    this.x = x;
    this.y = y;
    moves.add("fly()");
    turns++;
    if (x >= 0 && y >= 0) {
        return true;
    } else {
        return false;
    }
}

// Halves the player's size
public double shrink(){
    this.size = size/2;
    moves.add("shrink()");
    turns++;
    return size;
}

// Doubles the player's size
public double grow(){
    this.size = size*2;
    moves.add("grow()");
    turns++;
    return size;
}

// Increases the turn count without taking action;
public void rest(){
    moves.add("rest()");
    turns++;
}

// Reverses the effects of the previous action and reduces turns by 1
public void undo(){
    turns--;
    if((moves.get(moves.size()-1)).equals("grab()")){
        inventory.remove(item);
    }
    if((moves.get(moves.size()-1)).equals("drop()")){
        inventory.add(item);
    }
    if((moves.get(moves.size()-1)).equals("use()")){
        inventory.add(item);
    }
    if((moves.get(moves.size()-1)).equals("walk()")){
        if (direction.equals("left")){
            x--;
        } else if (direction.equals("right")) {
            x++;
        }
    }
    if((moves.get(moves.size()-1)).equals("fly()")){
        this.x -= x;
        this.y -= y;
    }
    if((moves.get(moves.size()-1)).equals("shrink()")){
        this.size = size*2;
    }
    if((moves.get(moves.size()-1)).equals("grow()")){
        this.size = size/2;
    }
}

public static void main(String[] args){
    Player player1 = new Player();
    player1.examine("thing");
    System.out.println(player1.drop("thing"));
}
}