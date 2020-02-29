/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch.behaviorTree;

import EscapeTheHutch.Coordinates;
import EscapeTheHutch.Enemy;
import EscapeTheHutch.Grid;
import EscapeTheHutch.Rabbit;
import static EscapeTheHutch.behaviorTree.Routines.pause;

/**
 *
 * @author codeHeartedWoman
 */
public class Routines {

    public static Routine sequence(Routine... routines) {
        Sequence sequence = new Sequence();
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine selector(Routine... routines) {
        Selector selector = new Selector();
        for (Routine routine : routines) {
            selector.addRoutine(routine);
        }
        return selector;
    }
    public static Routine moveTo(Coordinates C) {
        return new MoveTo(C);
    }
    public static Routine pause(int x, int y) {
    return new Pause(x, y);
    }
    public static Routine repeatInfinite(Routine routine) {
        return new Repeat(routine);
    }
    public static Routine repeat(Routine routine, int times) {
        return new Repeat(routine, times);
    }
    public static Routine wander(Grid grid) {return new Wander(grid);}

}

