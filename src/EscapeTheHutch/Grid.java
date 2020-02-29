/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author codeHeartedWoman
 */
public class Grid 
{
    final int width;
    final int height;

    private List<Enemy> enemies = new ArrayList<Enemy>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addEnemy(Enemy enemy) {
        if (isTileWalkable(enemy.getLocationX(), enemy.getLocationY())) {
            enemies.add(enemy);
            enemy.setGrid(this);
        }
    }

    public boolean isTileWalkable(double x, double y) {
        for (Enemy enemy : enemies) {
            if (enemy.getLocationX() == x && enemy.getLocationY() == y) {
                return false;
            }
        }
        return true;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
