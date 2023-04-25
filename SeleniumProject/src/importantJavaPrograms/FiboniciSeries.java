package importantJavaPrograms;

public class FiboniciSeries {

	public static void main(String[] args) {
		//fibonici series
		/*int n1=0;
		int n2=1;
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum=n1+n2;
			System.out.print(sum+" ");
			n1=n2;

			n2=sum;*/
		int i,j,k;
		for( i=1;i<=5;i++)
		{
			for(j=5;j>i;j--)
			{
				System.out.print(" ");
			}
			for(k=1;k<=i;k++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
			for( i=5;i>=1;i--)
			{
				for(j=5;j>i;j--)
				{
					System.out.print(" ");
				}
				for(k=1;k<=i;k++)
				{
					System.out.print("* ");
				}
				System.out.println();
			}
			

	}

}
