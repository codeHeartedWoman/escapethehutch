/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import EscapeTheHutch.behaviorTree.Routine;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author codeHeartedWoman
 */
public class Enemy extends Character
{
    //properties
    protected double duration;
    protected Rabbit prey;
    
    protected  int range;
    
    protected Grid grid;
    
    protected boolean canChange;
    protected double changeTime;
    
    
    protected ArrayList <Image> enemyAnimationR= new ArrayList<>();
    protected ArrayList <Image> enemyAnimationL= new ArrayList<>();
    protected ArrayList <Image> enemyAnimationF= new ArrayList<>();
    protected ArrayList <Image> enemyAnimationB= new ArrayList<>();
    protected ArrayList <Image> enemyAnimationP= new ArrayList<>();
    
    protected ArrayList <Image> attackR = new ArrayList<>();
    protected ArrayList <Image> attackL = new ArrayList<>();
    protected ArrayList <Image> idleR = new ArrayList<>();
    protected ArrayList <Image> idleL = new ArrayList<>();
    
    
    protected Path path1 = new Path();
    protected Path path2 = new Path();
    protected Path path3 = new Path();
    protected Path path4 = new Path();
    protected Path path5 = new Path();
    protected Path path6 = new Path();
    protected Path path7 = new Path();
    
    
    protected ArrayList <Image> impactAnimation = new ArrayList<>();
    
    protected ArrayList <Coordinates> steps =  new ArrayList<>();
    BoundingBox rangeXY;
    
    
    //constructor
    public Enemy(String name, Coordinates location,  int health, int damage, int range, Rabbit prey ) {
    this.name = name;
    this.range = range;
    this.prey = prey;
    
    isVisible = true;
    canChange = false;
    changeTime = 0;
    
    duration = .2;
    
        if ("fox".equals(name) || "bigBird".equals(name)){
        for (int i = 0; i < 3; i++)
        {    
            enemyAnimationR.add( new Image("images/foe/"+name+"/"+name+"R" + (i+1) + ".png" ));
            enemyAnimationL.add( new Image("images/foe/"+name+"/"+name+"L" + (i+1) + ".png" ));
            enemyAnimationF.add( new Image("images/foe/"+name+"/"+name+"F" + (i+1) + ".png" ));
            enemyAnimationB.add( new Image("images/foe/"+name+"/"+name+"B" + (i+1) + ".png" ));
            duration = .1;
            
            this.location = location;
            
            int xCenter = (int) (location.getX() + (.5*SPRITE_WIDTH));
            int yCenter = (int) (location.getY() + (.5*SPRITE_HEIGHT));
            
            rangeXY = new BoundingBox(xCenter, yCenter, range * 100, range*100);
        }
        }
        if ("wolf".equals(name)) {
            for (int i = 0; i < 12; i++)
            {
                enemyAnimationR.add( new Image("images/foe/"+name+"/"+name+"R" + (i+1) + ".png" ));
                enemyAnimationL.add( new Image("images/foe/"+name+"/"+name+"L" + (i+1) + ".png" ));
                attackR.add(new Image("images/foe/"+name+"/"+name+"AR" + (i+1) + ".png" ));
                attackL.add(new Image("images/foe/"+name+"/"+name+"AL" + (i+1) + ".png" ));
                idleR.add(new Image("images/foe/"+name+"/"+name+"IR" + (i+1) + ".png" ));
                idleL.add(new Image("images/foe/"+name+"/"+name+"IL" + (i+1) + ".png" ));
//                impactAnimation.add(new Image("images/foe/wolf/impactEffect/impactEffect_" +(i+1)));
                
                duration = .1;
                
                this.location = location;

                int xCenter = (int) (location.getX() + (.5*SPRITE_WIDTH));
                int yCenter = (int) (location.getY() + (.5*SPRITE_HEIGHT));

                rangeXY = new BoundingBox(xCenter, yCenter, range * 30, range*30);
            }
        }
            if ("wwIIGuy".equals(name)){
      
          for (int i = 0; i < 3; i++){    
            enemyAnimationP.add( new Image("images/foe/"+name+"/"+name+"P" + (i+1) + ".png" ));
            enemyAnimationR.add( new Image("images/foe/"+name+"/"+name+"R" + (i+1) + ".png" ));
            enemyAnimationL.add( new Image("images/foe/"+name+"/"+name+"L" + (i+1) + ".png" ));
            enemyAnimationF.add( new Image("images/foe/"+name+"/"+name+"F" + (i+1) + ".png" ));
            enemyAnimationB.add( new Image("images/foe/"+name+"/"+name+"B" + (i+1) + ".png" ));
            duration = .1;
            
            this.location = location;
            
            int xCenter = (int) (location.getX() + (.5*SPRITE_WIDTH));
            int yCenter = (int) (location.getY() + (.5*SPRITE_HEIGHT));
            
            rangeXY = new BoundingBox(xCenter, yCenter, range * 100, range*100);
            }
        }
    
    }
    
    public void update() {
        if (routine.getState() == null) {
            // hasn't started yet so we start it
            routine.start();
        }
        routine.act(this, prey, grid);
    }
    public int getRange() {return range;}

    

    
    
    public Routine getRoutine() {return routine;}
    public BoundingBox getRangeXY(){
        
        return rangeXY;}
    public boolean getIsVisible(){return isVisible;}
    
    public ArrayList<Image> getAnimationR(){return enemyAnimationR;}
    public ArrayList<Image> getAnimationL(){return enemyAnimationL;}
    public ArrayList<Image> getAnimationF(){return enemyAnimationF;}
    public ArrayList<Image> getAnimationB(){return enemyAnimationB;}
    public ArrayList<Image> getAnimationP(){return enemyAnimationP;}
    
    public ArrayList<Coordinates> getSteps(){return steps;}
    public void setRoutine(Routine routine) {this.routine = routine;}
    public void setGrid(Grid grid) {this.grid = grid;}
    @Override
    public void setDirection(String direction){this.direction = direction;}
    public boolean getCanChange(){ return canChange;}
    public double getChangeTime(){ return changeTime;}
    public void setCanChange(boolean canChange){this.canChange = canChange;}
    public void setChangeTime(double changeTime){ this.changeTime = changeTime;}
    public void setisVisible(boolean isVisible){this.isVisible = isVisible;}
    
    public char Collision(double lX, double tY, double rX, double bY, int enmH, int enmW)
    {
        char collision = 'n';
//        
//        System.out.println("Rabbit " + rX + ", Block: " + x);
//        
//        if(rX > x && lX < x + enmW && tY < y + enmH && bY > y)
//        {
//            System.out.println("HIT");
//            collision = 'y';
//        }
//        
        return collision;
    }
    
    public boolean isInRange() {
        System.out.println("ENEMY RANGE: "+getRangeXY());
        System.out.println("Bunny is at:" + prey.getLocation().getX() + ", " + prey.getLocation().getY());
        if (getRangeXY().contains(prey.getLocation().getX(), prey.getLocation().getY()))
            {   System.out.println("isINRANGE is TRUE");
                return true;}
        else 
            {   System.out.println("isINRANGE is FALSE");
                return false;}
    }
    public void Chase() {
       // If (isInRange()==true){
        //move immediately to chase coordinates
    Coordinates chaseCrd = new Coordinates(prey.getSteps().get(prey.getSteps().size() - 10).getX(), prey.getSteps().get(prey.getSteps().size() -10).getY());
    }

    public boolean isAlive() {
        return true;
    }
    
    Image getCurrentFrame(double time, ArrayList<Image> array)
    {
        int index = (int)((time % (array.size() * duration)) / duration);
        return array.get(index);
    }
    
    void determineSteps()
    {
        for (int i = 0; i<steps.size();i++){
            if (steps.size()>20)
            {steps.subList(0, 10).clear();}

            
            if (steps.size() > 3){
            Coordinates lastStep = steps.get(steps.size()-3);
        
                double stepXDelta = lastStep.getX() - getLocationX();
                //System.out.print("STEPX:"+stepXDelta+", ");
                double stepYDelta = lastStep.getY() - getLocationY();
                //System.out.println("STEPY:"+ stepYDelta);
                    double xDiff;
                    if(stepXDelta<1)
                    {xDiff = stepXDelta/-1;}
                    else {xDiff = stepXDelta;}
                
                    double yDiff;
                    if(stepYDelta<1)
                    {yDiff = stepYDelta/-1;}
                    else {yDiff = stepYDelta;}
         
                    if(xDiff >= yDiff && stepXDelta < 0)
                        {setDirection("RIGHT");}
                    else if (xDiff >= yDiff && stepXDelta > 0)
                        {setDirection("LEFT");}
                    else if (yDiff >= xDiff && stepYDelta < 0)
                        {setDirection("FRONT");}
                    else if (yDiff <= xDiff && stepYDelta > 0)
                        {setDirection("BACK");}
                    }
                
                }    
         //System.out.println("DIRECTION: "+  direction);
            }
            
    

}