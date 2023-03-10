package importantJavaPrograms;

import java.util.Scanner;

public class RevNumString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int number=sc.nextInt();
		int rev=0;
		while (number>0)
		{
			int dig=number%10;
			rev=rev*10+dig;
			number=number/10;
			
		}
		System.out.println(rev);
				/*Scanner sc=new Scanner(System.in);
				System.out.println("enter a String");
				String str=sc.nextLine();
				String rev="";
				for(int i=str.length()-1;i>=0;i--)
				{
					rev=rev+str.charAt(i);
					
				}
				System.out.println(rev);
								String str="akshay";
			char a[]=str.toCharArray();
			String rev="";
			for (int i=a.length-1;i>=0;i--)
			{
				rev=rev+a[i];
			}
			System.out.println(rev);

				
*/
	}

}
