package importantJavaPrograms;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter a number ");
		int num=sc.nextInt();
		/*int org_num=num;
		int rev=0;
		while(num!=0)
		{
			int dig=num%10;
			rev=rev*10+dig;
			num=num/10;
		}
if(rev==org_num)
{
	System.out.println(org_num +" is palindrom number");
}
else {
	System.out.println(org_num +" is not a palindrome number ");*/
		int count=0;
		while(num!=0)
		{
			num=num/10;
			count++;
						}
		System.out.println(count);
	}

}
