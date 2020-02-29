/*
 *  Alicia Moreland 2018;
 */
package EscapeTheHutch;

import EscapeTheHutch.behaviorTree.Routine;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;

/**
 *
 * @author Alicia
 */
public class EscapeTheHutch extends Application {
    
    @Override
    public void start(Stage window) {
    
          
    //RNDM NUMS
    int rndmX = new Random().nextInt(800);
    int rndmY = new Random().nextInt(600);
    
    //ADD IMAGES
    Image bkgrd1 =new Image(getClass().getResourceAsStream("/images/bkgrd/bkgrd1.png"));
    Image bunImg = new Image("images/bun/bunF_3.png");
    Image shadow = new Image("images/bun/Shadow.png");    
    Image cloverImg = new Image("images/powerUp/powerUp_11.png");
    Image strawberryImg = new Image("images/powerUp/powerUp_12.png");
    Image carrotImg = new Image("images/powerUp/powerUp_13.png");
    Image bananaImg = new Image("images/powerUp/powerUp_14.png");
    Image lettuceImg = new Image("images/powerUp/powerUp_3.png");
    Image bazookaImg = new Image("images/WWIIweapons/Bazooka.png");
    Image mk2GrenadeImg = new Image("images/WWIIweapons/");
    Image grenadeImg = new Image("images/WWIIweapons/");
    Image thompsonImg = new Image("images/WWIIweapons/");
    Image karabinerImg = new Image("images/WWIIweapons/");
    Image cagedBun = new Image("images/friend/cagedBun.gif");
    Image hunterImg = new Image("images/foe/badGuy1/badGuy1_F1.png");
    
    //ADD AUDIO
    AudioClip getItemSound = new AudioClip(getClass().getResource("/sounds/collectPowerUp.wav").toString()); 
    Media backgroundMusic = new Media(getClass().getResource("/sounds/music_happy_bounce.wav").toString());
    //Media foxIsNear = new Media(getClass().getResource("/sounds/music_happy_bounce.wav").toString());
    MediaPlayer bkgrdMusic = new MediaPlayer(backgroundMusic);
    Media runLittleRabbit = new Media(getClass().getResource("/sounds/runLittleRabbit.m4a").toString());
    MediaPlayer introMusic = new MediaPlayer(backgroundMusic);
    
    
    //ADD LISTS
    ArrayList<String> input = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Friend> friends = new ArrayList<>();
    ArrayList<PowerUp> powerups = new ArrayList<>();
    ArrayList<Routine> weapons = new ArrayList<>();

    
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    
    window.setTitle( "ESCAPE THE HUTCH!" );

    Group root = new Group();
    
    Scene scene1 = new Scene( root );
    window.setScene( scene1 );
    Grid grid =  new Grid(1000,800);    
    Canvas canvas = new Canvas( 1000, 800);
    root.getChildren().addAll( canvas);
         
    GraphicsContext gc = canvas.getGraphicsContext2D();
    introMusic.play();

    scene1.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
 
                    // only add once... prevent duplicates
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });
    
    scene1.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
   
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    
//ADD RABBIT, FOXES, OBSTACLES
    //Obstacle obstacle = new Obstacle(new Coordinates(300,300));
    
    Rabbit msAshpaw = new Rabbit(new Coordinates(509, 522));
    
    
    Friend hen = new Friend("hen", new Coordinates(700, 700));
    Friend hen2 = new Friend("hen", new Coordinates(710, 720));
    Friend hen3 = new Friend("hen", new Coordinates(720, 710));
         friends.add(hen); friends.add(hen2); friends.add(hen3);
    Friend cow =  new Friend("cow", new Coordinates(800, 800));
    Friend cow2 =  new Friend("cow", new Coordinates(800, 800));
    Friend cow3 =  new Friend("cow", new Coordinates(800, 800));
    Friend calf = new Friend("calf", new Coordinates(810,810));
         friends.add(cow);  friends.add(cow2);  friends.add(cow3);  friends.add(calf);
    Friend pig = new Friend("pig", new Coordinates(810,810));
    Friend pig2 = new Friend("pig", new Coordinates(810,810));
    Friend pig3 = new Friend("pig", new Coordinates(810,810));
    Friend piglet = new Friend("piglet", new Coordinates(810,810));
    Friend piglet2 = new Friend("piglet", new Coordinates(810,810));
         friends.add(pig); friends.add(pig2); friends.add(pig3); friends.add(piglet); friends.add(piglet2);
    Friend squirrel = new Friend("greySquirrel", new Coordinates(5, 5));
        friends.add(squirrel);
    Friend buck = new Friend("buck", new Coordinates(5,20));
    Friend deer = new Friend("deer", new Coordinates(5,20));
    Friend fawn = new Friend("fawn", new Coordinates(5,20));
        friends.add(buck); friends.add(deer); friends.add(fawn);
    Friend hedgehog = new Friend("hedgeHog", new Coordinates(30,30));
        friends.add(hedgehog);
   
    
    Enemy fox0 = new Enemy("fox", new Coordinates(rndmX, rndmY), 100, 0, 3, msAshpaw);
        enemies.add(fox0);
    Enemy fox1 = new Enemy("fox", new Coordinates(rndmX, rndmY), 100, 0, 3, msAshpaw);
        enemies.add(fox1);
    Enemy fox2 = new Enemy("fox", new Coordinates(rndmX, rndmY), 100, 0, 3, msAshpaw);
        enemies.add(fox2);
    Enemy fox3 = new Enemy("fox", new Coordinates(rndmX, rndmY), 100, 0, 2, msAshpaw);
        enemies.add(fox3);
    Enemy fox4 = new Enemy("fox", new Coordinates(rndmX, rndmY), 100, 0, 4, msAshpaw);
        enemies.add(fox4);
    Enemy wwIIGuy = new Enemy("wwIIGuy", new Coordinates(rndmX, rndmY), 100, 0, 4, msAshpaw);
        enemies.add(wwIIGuy);
     Enemy bigBird = new Enemy("bigBird", new Coordinates(rndmX, rndmY), 100, 0, 4, msAshpaw);
        enemies.add(bigBird);
    Enemy wolfBoss = new Enemy("wolf", new Coordinates(rndmX, rndmY), 100, 0, 4, msAshpaw);
        enemies.add(wolfBoss);

    System.out.println(wwIIGuy.getAnimationF().size());
    System.out.println(wwIIGuy.getAnimationP().size());
        
    PowerUp clover = new PowerUp("clover", new Random().nextInt(800), new Random().nextInt(600), cloverImg, 2);
        powerups.add(clover);
    PowerUp strawberry = new PowerUp("strawberry", new Random().nextInt(800), new Random().nextInt(600), strawberryImg, 3 );
        powerups.add(strawberry);
    PowerUp carrot = new PowerUp("carrot", new Random().nextInt(800), new Random().nextInt(600), carrotImg, 1);
        powerups.add(carrot);
    PowerUp banana = new PowerUp("banana", new Random().nextInt(800), new Random().nextInt(600), bananaImg, 10);
        powerups.add(banana);
    PowerUp lettuce = new PowerUp("lettuce", new Random().nextInt(800), new Random().nextInt(600), lettuceImg, 5);
        powerups.add(lettuce);

    Weapon bazooka = new Weapon(msAshpaw, "rocketLauncher", 30, 30, 300, 300, bazookaImg);
    Weapon mk2Grenade = new Weapon(msAshpaw, "grenade", 30, 30, 300, 300, mk2GrenadeImg);
    Weapon grenade = new Weapon(msAshpaw, "grenade", 30, 30, 300, 300, grenadeImg);
    Weapon thompson = new Weapon(msAshpaw, "machineGun", 30, 30, 300, 300, thompsonImg);
    Weapon karabiner98K = new Weapon(msAshpaw, "rifle", 30, 30, 300, 300, karabinerImg);
    
    

  
  
  
    TimeStamper timeStamp = new TimeStamper(System.nanoTime());
    
    new AnimationTimer(){
        public void handle(long currentNanoTime)
        {
            double cycleTime = timeStamp.updateStamp(currentNanoTime) / 1000000000.0;
            
            double t = (currentNanoTime - timeStamp.getStartTime()) / 1000000000.0; 
 
            double x = 350 + 180 * Math.cos(t);
            double y = 250 + 180 * Math.sin(t);
            
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
            
        //UPDATE BUNNY 
        if(input.contains("RIGHT"))
        {msAshpaw.updateX(1);}

        if(input.contains("Z"))
        {msAshpaw.accelerateHorizontal(cycleTime * 2);}

        if(input.contains("LEFT"))
        {msAshpaw.updateX(-1);}

        if(input.contains("X"))
        {msAshpaw.accelerateHorizontal(-cycleTime * 2);}

        if(input.contains("UP"))    
        {msAshpaw.updateY(-1);}

        if(input.contains("DOWN"))
        {msAshpaw.updateY(1);}

        if (input.contains("SPACE"))
        {
            msAshpaw.setVDelta(5);
            if(msAshpaw.getV()>0 || msAshpaw.getVDelta()!=0)
            {msAshpaw.setV(msAshpaw.getV()+msAshpaw.getVDelta());   
        }}
        
        msAshpaw.updateLoc();
        
            
        for(Enemy enemy : enemies){
            enemy.update();  
            enemy.getSteps().add(new Coordinates(enemy.getLocationX(), enemy.getLocationY()));
        }
              
            System.out.println(t);
 
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
            //DRAW BACKGROUND
            gc.drawImage( bkgrd1, 0, 0 ); 
            
            //DRAW STATIC OBJECTS
            gc.drawImage(cagedBun, 706, 187);
            
            //DRAW POWERUPS
            for(PowerUp p : powerups)
            {
              if (p.isVisible() == true){
              gc.drawImage(p.getImage(), p.getX(), p.getY());   
                if (p.checkPowerupCollision(msAshpaw) ==true){ 
                     getItemSound.play();                     
                     p.setIsVisible(false);
               }}
            }
            
            //DRAW WEAPONS
            if (bazooka.isVisible() == true){
              gc.drawImage(bazookaImg, bazooka.getX(), bazooka.getY());   
              if (bazooka.checkWeaponCollision(msAshpaw) ==true){                    
                    bazooka.setIsVisible(false);
                }
            }
    
            
            
            //DRAW ENEMIES GOING IN PROPER DIRECTION
            for (Enemy enemy : enemies)
                
            { 
                    enemy.determineSteps();
                    if (enemy.getDirection()=="PAUSE")
                    {gc.drawImage( enemy.getCurrentFrame(t, enemy.getAnimationP()), enemy.getLocationX(), enemy.getLocationY());} 
                 
                    if (enemy.getDirection() == "RIGHT")
                    { gc.drawImage( enemy.getCurrentFrame(t, enemy.getAnimationR()), enemy.getLocationX(), enemy.getLocationY());}    
            
                    if (enemy.getDirection() == "LEFT")
                    {gc.drawImage( enemy.getCurrentFrame(t, enemy.getAnimationL()), enemy.getLocationX(), enemy.getLocationY());}
                 
                    if (enemy.getDirection() == "FRONT")
                    {gc.drawImage( enemy.getCurrentFrame(t, enemy.getAnimationF()), enemy.getLocationX(), enemy.getLocationY());}
                 
                    if (enemy.getDirection() == "BACK")
                    {gc.drawImage( enemy.getCurrentFrame(t, enemy.getAnimationB()), enemy.getLocationX(), enemy.getLocationY());}
                
            }
            
                        //DRAW ENEMIES GOING IN PROPER DIRECTION
            for (Friend friend : friends)
                
            { 
                    friend.determineSteps();
//                    if (friend.getDirection()=="PAUSE")
//                    {gc.drawImage( friend.getCurrentFrame(t, friend.getAnimationP()), friend.getLocationX(), friend.getLocationY());} 
                 
                    if (friend.getDirection() == "RIGHT")
                    { gc.drawImage( friend.getCurrentFrame(t, friend.getAnimationR()), friend.getLocationX(), friend.getLocationY());}    
            
                    if (friend.getDirection() == "LEFT")
                    {gc.drawImage( friend.getCurrentFrame(t, friend.getAnimationL()), friend.getLocationX(), friend.getLocationY());}
                 
                    if (friend.getDirection() == "FRONT")
                    {gc.drawImage( friend.getCurrentFrame(t, friend.getAnimationF()), friend.getLocationX(), friend.getLocationY());}
                 
                    if (friend.getDirection() == "BACK")
                    {gc.drawImage( friend.getCurrentFrame(t, friend.getAnimationB()), friend.getLocationX(), friend.getLocationY());}
                
            }
            
            //DRAW BUNNY
          
            if(msAshpaw.getV()!=0){gc.drawImage(shadow, msAshpaw.getLocationX(), msAshpaw.getLocationY()-msAshpaw.getV());}
            
        
            if (input.contains("RIGHT")){gc.drawImage( msAshpaw.getCurrentFrame(t, msAshpaw.getBunAnimationR()), msAshpaw.getLocationX(), msAshpaw.getLocationY()+msAshpaw.getV());}
            else if (input.contains("LEFT")){gc.drawImage( msAshpaw.getCurrentFrame(t, msAshpaw.getBunAnimationL()), msAshpaw.getLocationX(), msAshpaw.getLocationY()+msAshpaw.getV());}
            else if (input.contains("UP")){gc.drawImage( msAshpaw.getCurrentFrame(t, msAshpaw.getBunAnimationB()), msAshpaw.getLocationX(), msAshpaw.getLocationY()+msAshpaw.getV());}
            else if (input.contains("DOWN")){gc.drawImage( msAshpaw.getCurrentFrame(t, msAshpaw.getBunAnimationF()), msAshpaw.getLocationX(), msAshpaw.getLocationY()+msAshpaw.getV());}
            else {gc.drawImage( bunImg, msAshpaw.getLocationX(), msAshpaw.getLocationY()+msAshpaw.getV());}
        }
    }.start();
         
    window.show();
}  
            
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void readCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}