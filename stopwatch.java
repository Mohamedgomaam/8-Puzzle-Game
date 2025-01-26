package assignment1;

public class stopwatch {
private long starttime;
private long endtime;

public stopwatch() 
{
starttime=System.currentTimeMillis();	
}

public void start() 
{
	starttime=System.currentTimeMillis();
}

public void end() 
{
endtime=System.currentTimeMillis();	
}

public long getstart() 
{
return starttime;	
}

public long getend() 
{
return endtime;	
}

public long geteclips() 
{
	long x=starttime-endtime;
	return Math.abs(x);
}


}
