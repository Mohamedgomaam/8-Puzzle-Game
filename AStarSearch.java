package assignment1;
import java.util.*;
public class AStarSearch {
    PriorityQueue<CostlyStep> frontier;
    Queue<CostlyStep> visited = new LinkedList<>();
    CostlyStep currentCostlyState;
    Search search = new Search();
    Double totalCost=0.0;
    ArrayList<Integer> initialState;

    public boolean AStarSearching ()
    {
    	frontier = new PriorityQueue<>((o1, o2)->o1.priority()-(o2.priority()));
        search=new Search();
        initialState = search.insertT();
        frontier.add(new CostlyStep(initialState,search.returnHeuristicType()));
        
        while (!frontier.isEmpty())
        {
            long start = System.nanoTime();
           currentCostlyState=frontier.remove();
           totalCost+=currentCostlyState.getFn();
           visited.add(currentCostlyState);
            search.moves++;
         //   search.printMatrix(currentCostlyState.currentState,search.moves);
            if (currentCostlyState.currentState.equals(search.GoalTest))
            {
            	 long elapsed = System.nanoTime() - start;
            	search.Success(search.moves,currentCostlyState.Gn,totalCost,currentCostlyState.depth);
                System.out.println("Elapsed Time in Milliseconds = " + elapsed/1000000);
                search.printFinalCostlyPath(currentCostlyState,currentCostlyState.pathToGoal);

                return true;
            }
            addSuccessor(currentCostlyState.moveUp());
            addSuccessor(currentCostlyState.moveLeft());
            addSuccessor(currentCostlyState.moveRight());
            addSuccessor(currentCostlyState.moveDown());
        }
        return false; 
        }

    void addSuccessor(CostlyStep neighbour)
    {
        if (neighbour != null && !visited.contains(neighbour) && !frontier.contains(neighbour)){
            frontier.add(neighbour);
        search.numberNodesExpanded++;}
    }
    
}