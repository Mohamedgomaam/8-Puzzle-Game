package assignment1;
import java.util.*;
public class tests {

	public static void main(String[] args) {
Scanner s=new Scanner(System.in);	
stopwatch w=new stopwatch();
w.start();
System.out.println("enter how many random number you want to sort");		
int size=s.nextInt();
int[] ar=new int[size];

for(int i=0;i<ar.length;i++) 
{
ar[i]=(int)(Math.random()*size);	
}

int pos=0;
int q=ar[0];

for(int i=0;i<ar.length;i++) 
{
 q=ar[i];
 int qw=q;
for(int j=i+1;j<ar.length;j++)
{
	int a=ar[j];
if(a<q)	
{
q=a;
pos=j;
}
}
if(qw==q) {}
else {
int ee=ar[i];
ar[pos]=ee;

ar[i]=q;
}
}	
	w.end();
System.out.print("time took to sort aray of size "+ size+" is: "+w.geteclips());	
	
	}
}
