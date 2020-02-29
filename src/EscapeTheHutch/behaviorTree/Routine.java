/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Enemy;
import EscapeTheHutch.Friend;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;

/**
 *
 * @author codeHeartedWoman
 */
public abstract class Routine {    

    public enum routineState {SUCCESS, FAILURE, RUNNING};
    protected routineState state;
    protected Routine() { }

    public void start() {
        System.out.println(">>> Starting routine: " + this.getClass().getSimpleName());
        this.state = routineState.RUNNING;
    }

    public abstract void reset();

    public void act(Rabbit rabbit, Grid grid){};
    public void act(Friend friend, Grid grid){};
    public void act(Enemy enemy, Rabbit rabbit, Grid grid){};

    protected void succeed() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED");
        this.state = routineState.SUCCESS;
    }

    protected void fail() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED");
        this.state = routineState.FAILURE;
    }

    public boolean isSuccess() {
        return state.equals(routineState.SUCCESS);
    }

    public boolean isFailure() {
        return state.equals(routineState.FAILURE);
    }

    public boolean isRunning() {
        return state.equals(routineState.RUNNING);
    }

    public routineState getState() {
        return state;
    }
}
