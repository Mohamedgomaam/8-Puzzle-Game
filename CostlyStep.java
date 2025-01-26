package assignment1;
import java.util.*;
public class CostlyStep extends Node  {

	 public ArrayList<Integer> currentState;
	    public double Fn;
	    //GN==nodes_expanded
	    int Gn;
	    int Hn;
	    int zeroPosition;
	    ArrayList<Integer> GoalTest = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
	    CostlyStep previousStep;
	    int depth;
	    String heuristicType;
	    Stack<ArrayList> pathToGoal = new Stack<>();
	    
	    public CostlyStep(ArrayList<Integer> state,String heuristic)
	    {
	        super();
	        this.currentState = state;
	        this.zeroPosition = this.ZeroPosition(this.currentState);
	        Gn = 0;
	        Hn = getHeuristics(heuristic);
	        previousStep = null;
	        depth = 0;
	        this.heuristicType = heuristic;
	    }
	    
	    CostlyStep(CostlyStep prev, int newZeroPosition)
	    {
	        super();
	        this.currentState =  (ArrayList<Integer>)prev.currentState.clone();
	        Collections.swap(this.currentState,prev.zeroPosition,newZeroPosition);
	       this.zeroPosition = newZeroPosition;
	        Gn = prev.Gn + 1;
	        Hn = getHeuristics(prev.heuristicType);
	        this.heuristicType = prev.heuristicType;
	       this.previousStep = prev;
	       depth = prev.depth +1;
	    }
	    
	    public int heuristicManhattan(ArrayList<Integer> currentState,ArrayList<Integer> goalTest) 
	    {
	        int difference = 0;
	        for (int i = 0; i < currentState.size(); i++)
	            for (int j = 0; j < goalTest.size(); j++)
	                if (currentState.get(i) == goalTest.get(j))
	                    difference = difference + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 - j / 3));
	        return difference;
	    }
	    
	    public int heuristicEuclidean(ArrayList<Integer> currentState,ArrayList<Integer> goalTest)
	    {
	        int difference = 0;
	        for (int i = 0; i < currentState.size(); i++)
	            for (int j = 0; j < goalTest.size(); j++)
	                if (currentState.get(i) == goalTest.get(j))
	                    difference = difference + (int)(Math.sqrt(Math.pow((i % 3 - j % 3),2) + Math.pow((i / 3 - j / 3),2)));
	        return difference;
	    }
	    
	    public double getFn()
	    {
	        return this.Gn + this.Hn;
	    }
	    
	    public int getHeuristics(String heuristic)
	    {
	        if(heuristic.equalsIgnoreCase("m"))
	            return heuristicManhattan(this.currentState,this.GoalTest);

	            return heuristicEuclidean(this.currentState,this.GoalTest);
	    }
	    
	    CostlyStep moveUp() {
	        return zeroPosition > 2 ? new CostlyStep(this, zeroPosition - 3) : null; }
	    CostlyStep moveDown() {
	        return zeroPosition < 6 ? new CostlyStep(this, zeroPosition + 3) : null; }
	    CostlyStep moveLeft() {
	        return zeroPosition % 3 > 0 ? new CostlyStep(this, zeroPosition - 1) : null; }
	    CostlyStep moveRight() {
	        return zeroPosition % 3 < 2 ? new CostlyStep(this, zeroPosition + 1) : null; }

	    public int priority(){
	        return this.Gn + this.Hn;
	    }

	}

