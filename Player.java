import java.util.ArrayList;

public class Player {
    String item;
    String direction;
    int x;
    int y;
    int z;
    double size;
    int turns = 0;
    ArrayList<String> moves = new ArrayList<String>();

public void grab(String item){

}

public String drop(String item){

}

public void examine(String item){
    System.out.println("This is a " + item);
}

public void use(String item){

}

public boolean walk(String direction){

}

public boolean fly(int x, int y){

}

public double shrink(){

}

public double grow(){

}

public void rest(){

}

public void undo(){

}

}
