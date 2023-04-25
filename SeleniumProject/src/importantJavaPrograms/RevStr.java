package importantJavaPrograms;

import java.util.Scanner;


public class RevStr {
	public static void main(String[] args) {		
	Scanner sc=new Scanner (System.in);
System.out.println(" enter a string");
	String str=sc.nextLine();
	String org_str=str;
	String rev="";
	int l=str.length();
	for(int i=l-1;i>=0;i--)
	{
		rev=rev+str.charAt(i);		
	}
	if(rev.equals(org_str))
	{
		System.out.println(str+ " is palindrome string");
	}
	else {
		System.out.println(str+ " is not palindrome string");

	}
	}
}