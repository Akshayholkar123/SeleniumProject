package importantJavaPrograms;

public class A 
{5/7/2023
	//1
	/*static int a=10;
	void fun() {
		int b=20;
		System.out.println(a+" "+b);
		++a;   ++b;
	}
	public static void main(String []args)
	{
		 A r=new A();
		r.fun();
		r.fun();*/
	public static void main(String[] args)
	{
		int a=10;
		int b=20;
		System.out.println(a+" "+b);
		/*a=a+b;//30
		b=a-b; //10
		a=a-b;  //20*/
		int temp=a;
		a=b;
		b=temp;
		System.out.println(a+" "+b);
		
	}
		
	

}
