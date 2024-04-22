import greenfoot.*;
import java.util.*;
import java.lang.String;

public class Knight extends Actor {
    private int lives = 3;
    private int invincibleFrames = 0;
    private int invincibleDuration = 100; 
    private World currentWorld;
    private int shotDelay;
    public String picImage = "left";
    public int moveX = 0;
    public int moveY = 0;
    public int speed = 5;
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    public Knight(World world) {
        currentWorld = world;
        updateLivesDisplay(); // Display lives counter when Player is added to the world
    }
    public void act() {
        setLocation(getX(), getY());
        Actor slash = new Slash();
        if (Greenfoot.isKeyDown("left")) {
            //move(-3);
            moveX = -speed;
            turnTowards(getX(), getY());
            setImage("knightLeft.png");
            picImage = "left";
            left = true;
        }
        else if (left && !Greenfoot.isKeyDown("left"))
        {
            moveX = 0;
            left = false;
        }
        if (Greenfoot.isKeyDown("right")) {
            moveX = speed;
            
            turnTowards(getX(), getY());
            setImage("knightRight.png");
            picImage = "right";
            right = true;
        }
        else if (right && !Greenfoot.isKeyDown("right"))
        {
            right = false;
            moveX = 0;
        }
        if (Greenfoot.isKeyDown("up")) {
            moveY = -speed;
            up = true;
            picImage = "up";
        }
        else if (up && !Greenfoot.isKeyDown("up")) {
            up = false;
            moveY = 0;
        }
        if (Greenfoot.isKeyDown("down")) {
            moveY = speed;
            down = true;
            picImage = "down";
        }
        else if (down && !Greenfoot.isKeyDown("down")) {
            moveY = 0;
            down = false;
        }
        if (shotDelay == 0 && Greenfoot.isKeyDown("space")) {
            getWorld().addObject(slash, 0, 0); // Launch a new slash
            slash.setLocation(getX(), getY()); // Move the slash to the right
            slash.setRotation(getRotation());
            shotDelay = 30; // Set the shot delay to a non-zero value (adjust as needed)
            if (picImage.equals("left")) {
                slash.setRotation(180);
            }
        }
        // Decrease the shot delay counter
        if (shotDelay > 0) {
            shotDelay--;
        }
        // Handle collision with enemy
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null && invincibleFrames <= 0) {
            // Reduce lives if not invincible
            if (lives > 0) {
                lives--;
                invincibleFrames = invincibleDuration; // Set invincibility period
                updateLivesDisplay();
                // Handle other actions after losing a life
            }
        }
        // Check if lives reached zero and switch world
        if (lives <= 0) {
            Greenfoot.setWorld(new GameOverWorld()); 
        }
        // Decrease invincibility frames
        if (invincibleFrames > 0) {
            invincibleFrames--;
        }
        // Teleport if intersecting with Teleport object
        Actor teleport = getOneIntersectingObject(Teleport.class);
        if (teleport != null) {
            World myWorld2 = new MyWorld2();
            Greenfoot.setWorld(myWorld2);
        }
        checkCollision();
        setLocation(getX() + moveX, getY() + moveY);
    }
    public void checkCollision()
    {
        if (getX()< 50 )
        {
            moveX = 0;
            setLocation(51,getY());
        }
        if (getY()< 140 )
        {
            moveY = 0;
            setLocation(getX(),141);
        }
        if (getX()>getWorld().getWidth()- 50 )
        {
            moveX = 0;
            setLocation(getWorld().getWidth()-51,getY());
        }
        if (getY()>getWorld().getHeight() - 50 )
        {
            moveY = 0;
            setLocation(getX(), getWorld().getHeight()-51);
        }
    }
    private void updateLivesDisplay() {
        if (currentWorld != null) {
            currentWorld.showText("Lives: " + lives, 300, 40);
        }
    }
}