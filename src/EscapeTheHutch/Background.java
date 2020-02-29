/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;

/**
 *
 * @author codeHeartedWoman
 */
public class Background
    {
        private Coordinates location;
        private Rabbit rabbit;
        private Image image;
        private BoundingBox bounds;
        private BoundingBox leftBounds;
        private BoundingBox rightBounds;
        private BoundingBox centerBounds;
        //800X600;

        public Background(Coordinates location, Image image, Rabbit rabbit)
        {
            this.location = location;
            this.image = image;
            this.rabbit = rabbit;
            this.bounds = new BoundingBox(location.getX(), location.getY(), 800, 600);
            this.leftBounds = new BoundingBox(location.getX(), location.getY(),100, 600);
            this.rightBounds = new BoundingBox(location.getX()+700, location.getY(), 100, 600);
        }

        public void UpdateBackground()
        {

//           boolean farthestLeft;
//           boolean farthestRight;
//            Bounds bunBounds = rabbit.getBounds();
//            
//           if (location.getX() == 0)
//           {farthestLeft = true;}
//           if (location.getX() == )
//            
//            if(bunBounds.intersects(leftBounds))
//            {//move background 600px left
//                
//            }
//            else if (bunBounds.intersects(rightBounds))
//            {//move background }
        
        }
            
        }
