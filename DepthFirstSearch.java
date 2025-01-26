package assignment1;
import java.util.*;
public class DepthFirstSearch {
    Stack<Node> frontier;
    Queue<ArrayList> visited = new LinkedList<>();
    Search search = new Search();
    Node currentStateDFS;
    
    public boolean DepthFirstSearching ()
    {
        frontier = new Stack<>();
        visited.clear();
        frontier.push(new Node(search.insertT()));
        while (!frontier.empty())
        {
            currentStateDFS=frontier.pop();
            long start = System.nanoTime();
            search.moves++;
            visited.add(currentStateDFS.currentState);
            search.printMatrix(currentStateDFS.currentState,search.moves);
            if (currentStateDFS.currentState.equals(search.GoalTest))
            {
            	search.Success(search.moves,currentStateDFS.Gn,search.moves,currentStateDFS.depth);
          	  long elapsed = System.nanoTime() - start;
              System.out.println("Elapsed Time in Milliseconds = " + elapsed/1000000);
            	return true;
            }
            addSuccessor(currentStateDFS.moveDown());
            addSuccessor(currentStateDFS.moveRight());
            addSuccessor(currentStateDFS.moveLeft());
            addSuccessor(currentStateDFS.moveUP());
        }
        return false;
    }
    void addSuccessor(Node neighbour)
    {
        if (neighbour != null && !visited.contains(neighbour.currentState) && !frontier.contains(neighbour)){
            frontier.push(neighbour);
            search.numberNodesExpanded++;}
    }


}
