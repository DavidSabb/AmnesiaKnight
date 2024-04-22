import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class MyWorld extends World {

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld() {
        super(600, 400, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare() {
        Teleport teleport = new Teleport();
        addObject(teleport, 600, 250);
        Knight knight = new Knight(this); // Passing 'this' as the world reference to the Knight constructor
        addObject(knight, 300, 200); // Adjust the position according to your needs
        teleport.setLocation(578,240);
    }
}
