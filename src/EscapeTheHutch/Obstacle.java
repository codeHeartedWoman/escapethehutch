/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscapeTheHutch;

import javafx.scene.image.Image;

/**
 *
 * @author jostros
 * 
 * new Obstacle(new Coordinates(X, Y);, 1);
 * 
 * 
 * 
 * 
 * 
 */
public class Obstacle
{
    
    private Image obst;
    Coordinates C;
    private double x;
    private double y;
    
    Obstacle(Coordinates C, int imgNum)
    {
        this.obst = new Image("/images/obstacles/obstacle" + imgNum +".png" );
        this.C = C;
        this.x = C.getX();
        this.y = C.getY();
    }

    public double getX() {return x;}

    public double getY() {return y;}
    
    public Image getImage() {return obst;}
    
    public boolean Collision(double lX, double tY, double rX, double bY)
    {
        boolean collision = false;
        
        System.out.println("Ship: " + rX + ", Block: " + x);
        
        if(rX > x && lX < x + 30 && tY < y + 120 && bY > y)
        {
            System.out.println("HIT");
            collision = true;
        }
        
        return collision;
    }
    
}
