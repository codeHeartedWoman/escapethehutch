/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import java.util.ArrayList;

/**
 *
 * @author codeHeartedWoman
 */
public class Path 
{
    //properties
    protected Coordinates[] p;
    protected ArrayList <Coordinates> path = new ArrayList();
    
    //constructor 
    public Path(){}
    public Path(Coordinates[] p){ this.p = p; }
    
    public void addCoordinates(){

   }
    
    public void createPath(){
        for (int i=0; i<p.length; i++)
        {path.add(p[i]);}
    }
}
