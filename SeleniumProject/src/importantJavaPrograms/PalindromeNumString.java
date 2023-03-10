package importantJavaPrograms;

import java.util.Scanner;

public class PalindromeNumString {

	public static void main(String[] args) {
		/*Scanner sc=new Scanner(System.in);
		System.out.println("enter a String");
		String str=sc.nextLine();
		String rev="";
		String org=str;
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
			
		}
if (rev.equals(org))
{
	System.out.println("palindrome string");
}
else
{
	System.out.println("not palindrome string");
	}
	}*/
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter the string");
		String str=sc.nextLine();
		String rev="";
		String org=str;
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		if(rev.equals(org))
		{
		System.out.println("palindrome string");	
		}
		else
		{
			System.out.println("not palindrome string");
		}
	}
	}
