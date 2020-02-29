/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;

/**
 *
 * @author codeHeartedWoman
 */
public class Bullet 
{
 
        private Coordinates location;
        private Coordinates velocity;
        private Image image; 
        private BoundingBox bounds;
        private boolean isVisible;

        public Bullet(Coordinates location, Coordinates velocity)
        {
            this.location = location;
            this.velocity = velocity;
            this.image = new Image("images/WWIIweapons/bullet.png");
            this.bounds = new BoundingBox(location.getX(),location.getY(), image.getWidth(),image.getHeight());
            this.isVisible = false;
        }
        public void updateLoc(){
            location.setX(location.getX()+velocity.getX());
            location.setY(location.getY()+velocity.getY());

        }
        public Image getImage(){return image;}
        public Coordinates getLocation(){return location;}
        public Coordinates getVelocity(){return velocity;}
        public double getLocationX(){return location.getX();}
        public double getLocationY(){return location.getY();}
        public boolean getIsVisible() {return isVisible;}
        public BoundingBox getBounds() {return bounds;}
        public void setLocation(Coordinates location){this.location = location;}
        public void setLocationX(double x){location.setX(x);}
        public void setLocationY(double y){location.setY(y);}
        public void setIsVisible(boolean isVisible) {this.isVisible=isVisible;}
        public void setBounds(BoundingBox bounds) {this.bounds=bounds;}
    }
