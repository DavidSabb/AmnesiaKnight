import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Slash extends Actor
{

    /**
     * Act - do whatever the Slash wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int moveSpeed = 5; // Speed of the slash movement
    private static int rangeLimit = 150; // Maximum distance the slash can travel. MUST HAVE BIG NUMBER
    private int distanceTraveled = 0; // Track the distance the slash has traveled
    
    public void act() {
        // setLocation(getX() + moveSpeed, getY()); // Move the slash to the right
        move(8);
        // Increment the distance traveled
        distanceTraveled += moveSpeed;
    
        // Check if the slash has reached its range limit
        if (distanceTraveled >= rangeLimit) {
            getWorld().removeObject(this); // Remove the slash if it reaches the range limit
            return;
        }
    
        // Check if the slash has reached the edge of the world
        if (getX() >= getWorld().getWidth() - 1) {
            getWorld().removeObject(this); // Remove the slash if it reaches the edge
            return;
        }
    }
}
