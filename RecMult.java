package hw5_q1;

public class RecMult {
	
	public static long mult(long x, long y) 
	{
		if (y != 1)
			return x + mult(x, y - 1);
		else
			return x;
	}
	
	public static void main(String[] args) 
	{
		long x = 6, y = 7;
		long mul = mult(x, y);
		System.out.println("the multiplication of "+x+" and "+y+" is :" + mul);
	}
}
