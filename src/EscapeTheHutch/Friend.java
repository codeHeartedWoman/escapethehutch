/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import EscapeTheHutch.behaviorTree.Routine;
import java.util.ArrayList;
import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

/**
 *
 * @author codeHeartedWoman
 */
public class Friend extends Character
{
    protected double duration;
    protected Rabbit prey;
    protected Grid grid;
    
    protected boolean canChange;
    protected double changeTime;
    
    
    protected ArrayList <Image> animationR= new ArrayList<>();
    protected ArrayList <Image> animationL= new ArrayList<>();
    protected ArrayList <Image> animationF= new ArrayList<>();
    protected ArrayList <Image> animationB= new ArrayList<>();
    protected ArrayList <Image> animationP= new ArrayList<>();
    
    protected ArrayList <Image> impactAnimation = new ArrayList<>();
    
    protected ArrayList <Coordinates> steps =  new ArrayList<>();
    BoundingBox rangeXY;
    
    
    
    public Friend(String name, Coordinates location) {
    this.name = name;
    this.prey = prey;
    
    isVisible = true;
    canChange = false;
    changeTime = 0;
    
    duration = .2;
    
        if ("fox".equals(name) || "bigBird".equals(name)){
        for (int i = 0; i < 3; i++)
        {    
            animationR.add( new Image("images/friend/"+name+"/"+name+"R" + (i+1) + ".png" ));
            animationL.add( new Image("images/friend/"+name+"/"+name+"L" + (i+1) + ".png" ));
            animationF.add( new Image("images/friend/"+name+"/"+name+"F" + (i+1) + ".png" ));
            animationB.add( new Image("images/friend/"+name+"/"+name+"B" + (i+1) + ".png" ));
            duration = .1;
            
            this.location = location;
        }    
    }
    
//    public void update() {
//        if (routine.getState() == null) {
//            // hasn't started yet so we start it
//            routine.start();
//        }
//        routine.act(this, prey, grid);
    } 
    
    public Routine getRoutine() {return routine;}
    public BoundingBox getRangeXY(){return rangeXY;}
    public boolean getIsVisible(){return isVisible;}
    
    public ArrayList<Image> getAnimationR(){return animationR;}
    public ArrayList<Image> getAnimationL(){return animationL;}
    public ArrayList<Image> getAnimationF(){return animationF;}
    public ArrayList<Image> getAnimationB(){return animationB;}
   
    
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
            
    

    @Override
    public String toString() {
        return "Friend{" +
                "name=" + name +
                ", x=" + location.getX() +
                ", y=" + location.getY() +
                '}';
    }
    }