package importantJavaPrograms;

import java.util.Arrays;

public class SortElementsinArray {

	public static void main(String[] args) {
int a[]= {1,3,5,2,4,6,8,7};
int n=a.length;

for (int i=0;i<n-1;i++)
{
	for (int j=0;j<n-1;j++)
	{
		if(a[j]>a[j+1])
		{
			
			int temp=a[j];
			a[j]=a[j+1];
			a[j+1]=temp;
		}
	}
}
System.out.println(Arrays.toString(a));

	}

}
