/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import java.util.ArrayList;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author codeHeartedWoman
 */
public class PowerUp 
{
    private double duration;
    int SPRITE_HEIGHT;
    int SPRITE_WIDTH;
    private String name;
    private boolean isVisible;
    private int x;
    private int y;
    BoundingBox bounds; 
    private Image img;
    private ArrayList <Image> collectAnimation;
    private int health;
    
 
    
    public PowerUp(String name, int x, int y, Image img, int health) {
        
        this.name = name;
        this.x = x;
        this.y = y;
        this.img = img;
        this.health = health;
        SPRITE_HEIGHT = (int) img.getHeight();
        SPRITE_WIDTH = (int) img.getWidth();
        bounds = new BoundingBox(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
        collectAnimation = new ArrayList<>();
        
        isVisible = true;
        for (int j=0; j<20; j++){
        for(int i=0; i<7; i++)  
        {  
            collectAnimation.add(new Image("images/effects/energy3/energy3_0"+(i)+".png"));
            duration = .1;
        }}
    }

    public boolean isVisible() {return isVisible;}

    public void setIsVisible(boolean isVisible) {this.isVisible = isVisible;}
    
    public String getName() {return name;}
    public int getX() { return x;}
    public int getY() { return y;}
    public int getHealth() {return health;}
    
    public void setName(String name) {this.name = name;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setHealth(int health) {this.health = health;}
    
    public Image getImage(){return img;}

    public ArrayList<Image> getCollectAnimation() {return collectAnimation;}

    public void setCollectAnimation(ArrayList<Image> collectAnimation) {this.collectAnimation = collectAnimation;}
    
    public void removeDestroyedPowerups()
    {}
    public boolean checkPowerupCollision(Rabbit rabbit)
    {
        
        if (this.bounds.contains(rabbit.getLocationX() + 12, rabbit.getLocationY() + 12))
        {return true;}
        else return false;
   }
    
    public void collision(Rabbit rabbit, ArrayList<PowerUp> powerups)
    {
            this.setIsVisible(false);
//            rabbit.increaseHealth(2);
            powerups.remove(this);  
    }
    
     Image getCurrentFrame(double time, ArrayList<Image> array)
    {
        int index = (int)((time % (array.size() * duration)) / duration);
        return array.get(index);
    }

}

