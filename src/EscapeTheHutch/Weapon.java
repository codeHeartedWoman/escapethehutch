/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import java.util.ArrayList;
import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;

/**
 *
 * @author codeHeartedWoman
 */
public class Weapon 
{
    protected Rabbit gunOwner;
    protected int SPRITE_HEIGHT;
    protected int SPRITE_WIDTH;
    protected String name;
    protected boolean isVisible;
    protected int x;
    protected int y;
    protected BoundingBox bounds; 
    protected  Image img;
    protected int bulletCapacity;
    protected  int bulletCount;
    protected ArrayList<Image> impactEffect;
    protected Bullet bullet;
    
    double velx, vely;
    
    
    Weapon(Rabbit gunOwner, String name, int bulletCapacity, int bulletCount, int x, int y, Image img) 
    {
        this.name = name;
        this.bulletCapacity = bulletCapacity;
        this.bulletCount = bulletCount;
        this.x = x;
        this.y = y;
        this.img = img;
        SPRITE_HEIGHT = (int) img.getHeight();
        SPRITE_WIDTH = (int) img.getWidth();
        bounds = new BoundingBox(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
        
        isVisible = true; 
     }
    
    
    
    public boolean isVisible() {return isVisible;}

    public void setIsVisible(boolean isVisible) {this.isVisible = isVisible;}
    
    public String getName() {return name;}
    public int getX() { return x;}
    public int getY() { return y;}
    public Bullet getBullet(){return bullet;}
    
    public void setName(String name) {this.name = name;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    
//    public void updateBullets()
//    {
//        for (int i = 0; i<=bulletCapacity; i++){
//        if (gunOwner.getDirection() == "LEFT")
//        {bullets.add(new Bullet(gunOwner.getLocation(), new Coordinates(50,0)));}
//        else if (gunOwner.getDirection() == "RIGHT")
//        {bullets.add(new Bullet(gunOwner.getLocation(), new Coordinates(-50,0)));}
//        else if (gunOwner.getDirection() == "FRONT")
//         {bullets.add(new Bullet(gunOwner.getLocation(), new Coordinates(0,50)));}
//        else if (gunOwner.getDirection() == "BACK")
//         {bullets.add(new Bullet(gunOwner.getLocation(), new Coordinates(0,-50)));}
//        }
//    }
    
//    public void RemoveDestroyedBullets()
//    {
//        for (int i = 0; i < bullets.size(); i++)
//            if (bullets.get(i).getIsVisible() == false)
//                bullets.remove(i);
//    }

    public boolean checkWeaponCollision(Rabbit rabbit)
    {
        
        if (this.bounds.contains(rabbit.getLocationX() + 12, rabbit.getLocationY() + 12))
        {return true;}
        else return false;
   }
    
//     Image getCurrentFrame(double time, ArrayList<Image> array)
//    {
//        int index = (int)((time % (array.size() * duration)) / duration);
//        return array.get(index);
//    }
   
    public void Shoot(ArrayList<Enemy> enemies, Coordinates velocity){
    bullet = new Bullet(new Coordinates(gunOwner.getLocationX(), gunOwner.getLocationY()), velocity);}
   
//       for (Enemy enemy : enemies){
//        
//            if(enemy.getBounds().contains(bullet.getBounds().getMinX(), bullet.getBounds().getMinY()))
//            {
//                System.out.println("HIT!!!!!!");
//                enemy.setisVisible(false);
//                enemies.remove(this);
//            }
//        }
        
    }
    
    

//private static Random random = new Random();
//    private final Board board;
//    private MoveTo moveTo;
//
//    @Override
//    public void start() {
//        super.start();
//        this.moveTo.start();
//    }
//
//    public void reset() {
//        this.moveTo = new MoveTo(random.nextInt(board.getWidth()), random.nextInt(board.getHeight()));
//    }
//
//    public Wander(Board board) {
//        super();
//        this.board = board;
//        this.moveTo = new MoveTo(random.nextInt(board.getWidth()), random.nextInt(board.getHeight()));
//    }
//
//    
//}