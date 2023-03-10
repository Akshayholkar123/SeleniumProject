package importantJavaPrograms;

public class SwapNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int b=20;
		int a=10;
		//int t=a;
		//a=b;
		//b=t;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a +" "+b);*/
		String str=" akshay s holkar";
		int count =1;
		for (int i=1;i<str.length()-1;i++)
		{
			if (str.charAt(i)==' '&&(str.charAt(i+1)!=' ')) {
				count++;
			}
		}
System.out.println(count);
	}

}
