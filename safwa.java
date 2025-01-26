package assignment1;
import  java.util.*;

public class safwa {

	public static void main(String[] args) {
	Stack<Integer> x=new Stack<Integer>();
	Queue<Integer> y=new LinkedList<Integer>();
	Scanner s=new Scanner(System.in);
	
	x.push(1);
	x.push(2);
	x.push(3);
	x.push(4);
	x.push(5);
	System.out.println("your stack contain : "+x.toString());  
	System.out.println("enter number to search for");
	int num=s.nextInt();
	check(x,y,num);
	}

public static void check(Stack<Integer> S,Queue<Integer> Q,int x) 
{
	int test=S.search(x);
	if(test==-1) System.out.print("Stack doesnt contain number "+x);
	else if(test!=1) {
int cou=0;	
for(int i=0;i<2;i++) {
while(!S.isEmpty()) 
{
cou++;
if(S.peek()==x)
{
	if(i==0) {
System.out.println("number "+ x+" found after "+cou+" trails");
	System.out.println("back to stack its original order ");
	}
break;
}
Q.add(S.pop());
}

while(!Q.isEmpty()) 
{
S.push(Q.poll());	
}
System.out.println(S.toString());
}
 }
  }	
		
}
