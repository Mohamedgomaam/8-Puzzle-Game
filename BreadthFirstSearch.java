package assignment1;
import java.util.*;
public class BreadthFirstSearch {
	Queue<Node> frontier;
    Queue<ArrayList> visited = new LinkedList<>();
    Search search;
    Node currentStateBFS;
    
    public boolean BreadthFirstSearching () 
    {
        frontier = new LinkedList<>();
        search=new Search();
        visited.clear();
         frontier.add(new Node(search.insertT()));
         
          while (!frontier.isEmpty())
          {
              currentStateBFS=frontier.remove();
              long start = System.nanoTime();
              search.moves++;
              visited.add(currentStateBFS.currentState);
            //  search.printMatrix(currentStateBFS.currentState,search.moves);
              
           if (currentStateBFS.currentState.equals(search.GoalTest))
           {
                  long elapsed = System.nanoTime() - start;
                  System.out.println("Elapsed Time in Milliseconds = " + elapsed/1000000);
                  search.Success(search.moves,currentStateBFS.Gn,currentStateBFS.Gn,currentStateBFS.depth);
                  search.printFinalPath(currentStateBFS,currentStateBFS.pathToGoal);
                  return true;
              }
              addSuccessor(currentStateBFS.moveUP());
              addSuccessor(currentStateBFS.moveDown());
              addSuccessor(currentStateBFS.moveLeft());
              addSuccessor(currentStateBFS.moveRight());
          }
          return false;
    
    }
    
    void addSuccessor(Node neighbour) 
    {
        if (neighbour != null && !visited.contains(neighbour.currentState) &&!frontier.contains(neighbour)){
            frontier.add(neighbour);
        }
    
    }

}
