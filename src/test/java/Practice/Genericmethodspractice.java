package Practice;

public class Genericmethodspractice {

	public static void main(String[] args)//caller function
	{
		//addition
		//		int a=10;
		//		int b=30;
		//		int c=a+b;
		//		System.out.println(c);

		int sum =add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,50));
		System.out.println(add(100,500));
		System.out.println(add(70,sum));
		System.out.println(add(sum,60));
		System.out.println(add(40,sum));
		int sum2 = add(sum,80);
		System.out.println(sum2);
		int sub=subtract(50,10);
		System.out.println(sub);
		int pro=product(sum2, sub);
		System.out.println(pro);
		System.out.println(product(40, 70));
		int div=divide(45,15);
		System.out.println(div);
	}
	//logic-controlled execution
	private static int add(int a, int b) //called function-generic
	{
		int c=a+b;
		return c;
	}
	public static int subtract(int i,int j)
	{
		int k=i-j;
		return k;	
	}
	public static int product(int x,int y)
	{
		int z=x*y;
		return z;	
	}
	public static int divide(int d,int e)
	{
		int f=d/e;
		return f;	
	}
	

	

}




	
