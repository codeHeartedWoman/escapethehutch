/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Coordinates;
import EscapeTheHutch.Enemy;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;
import java.util.Random;
import javafx.util.Duration;

/**
 *
 * @author codeHeartedWoman
 */

public class MoveTo extends Routine {

    final protected Coordinates C;
    Duration duration;



    public MoveTo(Coordinates C) {
        super();
        this.C = C;
    }

    @Override
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
            if (!isEnemyAtDestination(enemy)) {
                moveEnemy(enemy);
            }
        }
    }
    
    
    private void moveEnemy(Enemy enemy) {
        if (C.getY() != enemy.getLocationY()) {
            if (C.getY() > enemy.getLocationY()) {
                enemy.setLocationY((enemy.getLocationY() + 1));
            } else {
                enemy.setLocationY((enemy.getLocationY() - 1));
            }
        }
        if (C.getX() != enemy.getLocationX()) {
            if (C.getX() > enemy.getLocationX()) {
                enemy.setLocationX((enemy.getLocationX() + 1));
            } else {
                enemy.setLocationX((enemy.getLocationX() - 1));
            }
        }
        if (isEnemyAtDestination(enemy)) {
            succeed();
        }
    }

    private boolean isEnemyAtDestination(Enemy enemy) {
        return C.getX() == enemy.getLocationX() && C.getY() == enemy.getLocationY();
    }
 
}
