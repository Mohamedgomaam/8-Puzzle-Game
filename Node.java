package assignment1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Node {
public ArrayList<Integer> currentState;
    int Gn;
    int zeroPosition;
    Node previousStep;
    int depth;
    Stack<ArrayList> pathToGoal = new Stack<>();
    public Node(ArrayList<Integer> state)
    {
        this.currentState = state;
        this.zeroPosition = this.ZeroPosition(this.currentState);
        Gn = 0;
        previousStep = null;
        depth = 0;
    }

Node(Node prev, int newZeroPosition)
{
        this.currentState =  (ArrayList<Integer>)prev.currentState.clone();
        Collections.swap(this.currentState,prev.zeroPosition,newZeroPosition);
        this.zeroPosition = newZeroPosition;
        Gn = prev.Gn + 1;
        this.previousStep = prev;
        depth = prev.depth +1;
    }
    public Node() { }
    public double getFn()
    {
        return this.Gn;
    }
  
    public int ZeroPosition (ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0)
                return i;
        }
        return -1;
    }
    
    Node moveUP() {
        return zeroPosition > 2 ? new Node(this, zeroPosition - 3) : null; }
    Node moveDown() {
        return zeroPosition < 6 ? new Node(this, zeroPosition + 3) : null; }
    Node moveLeft() {
        return zeroPosition % 3 > 0 ? new Node(this, zeroPosition - 1) : null; }
    Node moveRight() {
        return zeroPosition % 3 < 2 ? new Node(this, zeroPosition + 1) : null; }
}