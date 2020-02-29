/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import EscapeTheHutch.behaviorTree.Routine;
import java.util.ArrayList;
import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;

/**
 *
 * @author codeHeartedWoman
 */
public abstract class Character 
{
    //PROPERTIES
    protected String name;
    protected int  SPRITE_HEIGHT;
    protected int SPRITE_WIDTH;

    protected Coordinates location;
    protected Coordinates velocity;
    
    protected BoundingBox bounds; 
    protected String direction;
    
    protected boolean isVisible;
    protected Routine routine;
    
    
    protected Image idle1;
    protected Image idle2;
    
    //GETTERS
    public String getName() {return name;}
    public int getSpriteHeight(){return SPRITE_HEIGHT;}
    public int getSpriteWidth(){return SPRITE_WIDTH;}
    
    public Coordinates getVelocity(){return velocity;}
    public double getVelocityX(){return velocity.getX();}
    public double getVelocityY(){return velocity.getY();}
    
    public Coordinates getLocation(){return location;}
    public double getLocationX(){return location.getX();}
    public double getLocationY(){return location.getY();}

    
    public BoundingBox getBounds(){return bounds;}
    public String getDirection(){return direction;}
    
    public Boolean isVisible(){return isVisible;}
    public Routine getRoutine(){return routine;}
    
    //SETTERS
    public void setName(String name) {this.name = name;}
    public void setSpriteHeight(int height){SPRITE_HEIGHT = height;}
    public void setSpriteWidth(int width){SPRITE_WIDTH = width;}
    
    public void setVelocity(Coordinates velocity){ this.velocity = velocity;}
    public void setVelocityX(double x){this.velocity.setX((int) x);}
    public void setVelocityY(double y){this.velocity.setY((int) y);}
    
    public void setLocation(Coordinates location){this.location = location;}
    public void setLocationX(double x){ this.location.setX((int) x);}
    public void setLocationY(double y){this.location.setY((int) y);}
   
    public void setBounds(BoundingBox bounds){this.bounds = bounds;}
    public void setDirection(String direction){this.direction = direction;}
    
    public void setIsVisible(boolean isVisible){this.isVisible = isVisible;}
    public void setRoutine(Routine routine){this.routine = routine;}
}
