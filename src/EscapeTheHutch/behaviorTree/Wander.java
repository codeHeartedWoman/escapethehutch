/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Enemy;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;
import EscapeTheHutch.Coordinates;
import EscapeTheHutch.behaviorTree.MoveTo;
import EscapeTheHutch.behaviorTree.Routine;
import java.util.Random;

/**
 *
 * @author codeHeartedWoman
 */
public class Wander extends Routine
{

    private static Random random = new Random();
    private final Grid grid;
    private MoveTo moveTo;
    
@Override
    public void start() {
        super.start();
        this.moveTo.start();
    }

    public void reset() {
        this.moveTo = new MoveTo( new Coordinates(random.nextInt(grid.getWidth()), random.nextInt(grid.getHeight())));
    }
    
    public Wander(Grid grid) {
        super();
        this.grid = grid;
        this.moveTo = new MoveTo(new Coordinates(random.nextInt(grid.getWidth()), random.nextInt(grid.getHeight())));
    }
    
    @Override
    public void act(Enemy enemy, Rabbit rabbit, Grid grid) {
        if (!moveTo.isRunning()) {
            return;
        }
        this.moveTo.act(enemy, rabbit, grid);
        if (this.moveTo.isSuccess()) {
            succeed();
        } else if (this.moveTo.isFailure()) {
            fail();
        }
    }
    
//    public Wander(Grid grid, Enemy enemy, double timeStamp, double amount) {
//        
//        Random rnd = new Random();
//        if(enemy.getCanChange() == true)
//        {
//            if(rnd.nextDouble() > .2)
//            {
//            double direction = rnd.nextDouble() * 2 * Math.PI;
//            
//            double velX = Math.sin(direction) * amount * 6;
//            double velY = Math.cos(direction) * amount * 6;
//            enemy.setVelocity(new Coordinates(velX,velY));
//            }
//            else
//            {
//                enemy.setVelocity(new Coordinates(0,0));
//            }
//            enemy.setCanChange(false);
//        }
//        
//        if(enemy.getChangeTime() > 1)
//        {
//            enemy.setChangeTime(0);
//            enemy.setCanChange(true);
//        }
//        
//        enemy.setChangeTime(enemy.getChangeTime()+ timeStamp);
//    }
        
    }
