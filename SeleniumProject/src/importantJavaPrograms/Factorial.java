package importantJavaPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.apache.poi.hslf.record.TextCharsAtom;

public class Factorial {

	public static void main(String[] args) 
	{
		/*Scanner sc=new Scanner (System.in);
		System.out.println("enter a number");
		int number=sc.nextInt();
		double factorial=1;
		for(int i=1;i<=number;i++)
		{
			factorial=factorial*i;

		}
	System.out.println(factorial);*/
		/*int []a= {1,2,3,4,5,6,7,8,9,5,10,15};
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		System.out.println(sum);*/
		/*for(int value:a)
		{
			sum=sum+value;
		}
		System.out.println(sum);*/
		/*String []a= {"java","python","c++","c","kotlin","javaScript","java","python"};
		boolean flag=false;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j]) 
				{
					System.out.println( a[i]+ " is duplicate element");
					flag=true;
				}
			}
		}
		if(flag==false)
		{
			System.out.println(" duplicate element not found");
		}*/
		/*Integer []a= {10,20,30,40,50,60,70,80};		
	Arrays.sort(a,Collections.reverseOrder());
	System.out.println(Arrays.toString(a));*/
		/*String s=" java is a proggraming laguage";
		int count1=s.length();
	int count2=s.replace("a","").length();
		int no_OfOccurance=(count1-count2);
		System.out.println("total no.of occurance of char count is " +no_OfOccurance);*/
		String s="I am a software tester";
		/*int count=1;
		for(int i=0;i<s.length();i++)
		{
			if((s.charAt(i)==' ') && (s.charAt(i+1)!=' '))
			{
                count++;
			}
		}
		System.out.println(count);*/
	int num=5;
	int fact=1;
	for(int i=1;i<=num;i++)
	{
		 fact=fact*i;
		
		
	}
	System.out.println(fact);
		}
}
