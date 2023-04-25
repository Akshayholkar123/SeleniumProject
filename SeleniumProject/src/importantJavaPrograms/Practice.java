package importantJavaPrograms;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner (System.in);
		System.out.println(" enter a number");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int largest=(a>b)?(a>c?a:c):(b>c?b:c);
		
		System.out.println("largest number is "+ largest);
		}
	}


