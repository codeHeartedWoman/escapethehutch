/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Enemy;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;
import EscapeTheHutch.TimeStamper;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;

/**
 *
 * @author codeHeartedWoman
 */
public class Pause extends Routine
{

    final protected int pauseX;
    final protected int pauseY;
    Duration duration;

    public Pause(int pauseX, int pauseY) {
        super();
        this.pauseX = pauseX;
        this.pauseY = pauseY;
    }

    public void reset() {
        start();
    }

    @Override
    public void act(Enemy enemy, Rabbit rabbit, Grid grid) {
        if (isRunning()) {
            if (!enemy.isAlive()) {
                fail();
                return;
            }
          
        pauseEnemy(enemy);}
    }
    
    
    private void pauseEnemy(Enemy enemy) {

        enemy.setLocationY((enemy.getLocationY())+0);
        enemy.setLocationX((enemy.getLocationX())+0);
        enemy.setDirection("PAUSE");
        if (isEnemyAtDestination(enemy)) {
            succeed();
        }
    }

    private boolean isEnemyAtDestination(Enemy enemy) {
        return pauseX == enemy.getLocationX() && pauseY == enemy.getLocationY();
    }
}
