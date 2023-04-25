
package importantJavaPrograms;

import java.util.Arrays;

public class SortElementsinArray {

	public static void main(String[] args) {
		int a[]= {2,4,6,1,5,7,9};
		int l=a.length;
		
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l-1;j++) // changed to l-1
			{
				if(a[j]>a[j+1] ) // added j+1 < l
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
