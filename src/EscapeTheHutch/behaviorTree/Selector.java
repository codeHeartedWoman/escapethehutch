/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Enemy;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author codeHeartedWoman
 */
public class Selector extends Routine {

    public Selector() {
        super();
        this.currentRoutine = null;
    }

    private Routine currentRoutine;
    List<Routine> routines = new LinkedList<Routine>();
    Queue<Routine> routineQueue = new LinkedList<Routine>();


    public void addRoutine(Routine routine) {
        routines.add(routine);
    }

    @Override
    public void reset() {
        for (Routine routine : routines) {
            routine.reset();
        }
    }

    @Override
    public void start() {
        // start the current sequence
        super.start();
        // reset the current queue and copy the routines from setup
        routineQueue.clear();
        routineQueue.addAll(routines);
        currentRoutine = routineQueue.poll();
        currentRoutine.start();
    }

    @Override
    public void act(Enemy enemy, Rabbit rabbit, Grid grid) {

        currentRoutine.act(enemy, rabbit, grid);
        // if is still running, then carry on
        if (currentRoutine.isRunning()) {
            return;
        }

        // check if the routine is successful and finish the sequence
        if (currentRoutine.isSuccess()) {
            succeed();
            return;
        }

        // We need to progress the sequence. If there are no more routines
        // then the state is the last routine's state. (Success for OR was already handled)
        if (routineQueue.peek() == null) {
            this.state = currentRoutine.getState();
        } else {
            currentRoutine = routineQueue.poll();
            currentRoutine.start();
        }

    }
}
