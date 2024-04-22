import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class MyWorld2 extends World {

    /**
     * Constructor for objects of class MyWorld2.
     */
    public MyWorld2() {
        super(600, 400, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        Enemy enemy = new Enemy();
        addObject(enemy, 500, 280);
        Knight knight = new Knight(this); 
        addObject(knight, 20, 250);    
    }
}
