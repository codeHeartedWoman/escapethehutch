/*
 *  Alicia Moreland 2018;

REFERENCE LIST: 
Game AI: Intro to Behavior Trees: https://www.javacodegeeks.com/2014/08/game-ai-an-introduction-to-behaviour-trees.html
 */

package EscapeTheHutch;

import static java.lang.System.gc;
import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author codeHeartedWoman
 */
public class Rabbit extends Character
{


//PROPERTIES  
    
private double duration;

protected int health;
protected int range;
protected int damage;

private double v;
private double vDelta; // The vertical delta...

private double rbDelta; // Rebound delta...
private double rbDegDelta; // The amount the rebound is degradation...
private double gDelta; // Gravity, how much the vDelta will be reduced by over time...

private boolean grounded;
private boolean bounce;
private String action;

ArrayList <Image> bunAnimationR= new ArrayList<>();
ArrayList <Image> bunAnimationL= new ArrayList<>();
ArrayList <Image> bunAnimationF= new ArrayList<>();
ArrayList <Image> bunAnimationB= new ArrayList<>();

ArrayList<Coordinates> steps = new ArrayList<>();

ArrayList<AudioClip> hopSounds = new ArrayList<>();

private Weapon weapon;

Image heart100 = new Image("images/bun/heart100.png");
Image heart75 = new Image("images/bun/heart75.png");
Image heart50 = new Image("images/bun/heart50.png");
Image heart25 = new Image("images/bun/heart25.png");
Image heart0 = new Image("images/bun/heart0.png");

    

//CONSTRUCTOR 

    Rabbit(Coordinates location)
    {
        velocity = new Coordinates(0,0);
        grounded = true;
        bounce = false;
        direction = "right";
        action = "idle";
        
        v=0;
        vDelta = 0;
        gDelta = 0.25;
        rbDegDelta = 2.5;
        
        for (int i = 0; i < 3; i++)
        {    
            bunAnimationR.add( new Image( "images/bun/bunR_" + (i+1) + ".png" ));
            bunAnimationL.add( new Image( "images/bun/bunL_" + (i+1) + ".png" ));
            bunAnimationF.add( new Image( "images/bun/bunF_" + (i+1) + ".png" ));
            bunAnimationB.add( new Image( "images/bun/bunB_" + (i+1) + ".png" ));
            duration = .2;
            
            this.location = location;
        }
        for (int i = 0; i<10; i++)
        { hopSounds.add(new AudioClip(getClass().getResource("/sounds/pawStep"+(i+1)+".wav").toString()));}
        
        SPRITE_HEIGHT = 23;
        SPRITE_WIDTH = 23;
        bounds = new BoundingBox(location.getX(), location.getY(), SPRITE_WIDTH, SPRITE_HEIGHT);
    }
    
//<O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O>
//METHODS  METHODS  METHODS  METHODS  METHODS  METHODS  METHODS  METHODS  METHODS  MET  
//<O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O><O>    

//GETTERS∆««
//============
   

    public double getDuration(){return duration;}
    public double getV(){return v;}
    public double getVDelta(){return vDelta;}
    public double getRbDelta(){return rbDelta;} 
    public double getRbDegDelta(){return rbDegDelta;} 
    public double getGDelta(){return vDelta;}
    
    boolean getGrounded(){return grounded;}
    boolean getBounce(){return bounce;}
    String getAction(){return action;}
    
    ArrayList<Image> getBunAnimationR(){return bunAnimationR;}
    ArrayList<Image> getBunAnimationL(){return bunAnimationL;}
    ArrayList<Image> getBunAnimationF(){return bunAnimationF;}
    ArrayList<Image> getBunAnimationB(){return bunAnimationB;}
    
    public ArrayList<Coordinates> getSteps(){return steps;}
    

    Image getCurrentFrame(double time, ArrayList<Image> array)
    {
        int index = (int)((time % (array.size() * duration)) / duration);
        return array.get(index);
    }
    
//SETTERS∆««
//============ 
public void setGrounded(boolean grounded){ this.grounded = grounded;}
public void setBounce(boolean bounce){ this.bounce = bounce;}
public void setAction(String action){this.action = action;}

public void setV(double v){this.v = v;}
public void setVDelta(double vDelta){this.vDelta = vDelta;}
public void setRbDelta(double rbDelta){this.rbDelta = rbDelta;} 
public void setRbDegDelta(double rbDegDelta){this.rbDegDelta = rbDegDelta;} 
public void setGDelta(double gDelta){this.gDelta = gDelta;}
public void setWeapon(Weapon weapon){this.weapon = weapon;}
public Weapon getWeapon(){return weapon;}
        
//BUN METHODS∆««
//============
    void accelerateHorizontal(double amount) { velocity.setX(velocity.getX()+amount);}   
    void accelerateVertical(double amount) { velocity.setY(velocity.getY()+ amount);} 

    void bounceX() { velocity.setX(-velocity.getX());}
    
//    void gravityEffect(double gravity) {
//        velocity.setY(velocity.getY()+gravity);} 
    
    void updateLoc(){
        location.setX(location.getX()+velocity.getX());
        location.setY(location.getY()+velocity.getY()+v);
        getSteps().add(this.getLocation());     
    }
    
    void updateX(double uX)
    {location.setX(location.getX() +uX);}
    void updateY(double uY)
    {location.setY(location.getY() +uY);}
     
    public void setAcceleration(double x, double y) {
        velocity.setX(x);
        velocity.setY(y);
    }
}
            
//    public void jump(ArrayList<String>input){
//    
//        int index = steps.size()-1;
//        double floorX = steps.get(index).getX();
//        double floorHeight = 600 - floorX;
//        double y;
//        double gravity = 3;
//        double jumpStrength = gravity * 8;
//    
//    // Jump code 
//    for (int i = 0; i<input.size();i++)
//    {
//        if (input.get(i).equals("SPACE") && location.getY() >= floorHeight){    
//            y = (location.getY() - jumpStrength);
//            location.setY(y);
//            jumpStrength = jumpStrength - gravity; }
//    }
//    }}

