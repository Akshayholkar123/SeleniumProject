package importantJavaPrograms;
import java.util.Scanner;

public class frequentlyAskedJavaPrograms {
	public static void main(String[] args) {


		int num=1234567;
		int ecount=0;
		int ocount=0;
		while(num>0)
		{
			int rem=num%10;
			if(rem%2==0) 
			ecount++;
		
			else {
				ocount++;
			}
			num=num/10;
			
		}
		System.out.println("odd degit count is "+ocount);
		System.out.println("even digit count is "+ecount);
		}
	}
/*int num=1234;
int sum=0;
while(num>0)
{
	int rem=num%10;
	sum=sum+rem;
	num=num/10;
	}
System.out.println(sum);*/




