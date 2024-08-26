import java.util.Arrays;

public class Practice {

	public static void main(String[] args)
	{
		/*String s="nitin";
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				String s1=s.substring(i,j);
         if(s1.length()>=3 && isPalindrome(s1))
         {
        	 System.out.println(s1);
         }
			}}
		}
		
		public static boolean isPalindrome(String str)
		{
			String rev="";
			for(int i=0;i<str.length();i++)
			{
				rev=str.charAt(i)+rev;
			}
			if(rev.equals(str))
			{
			return true;
		    }
			else
			{
				return false;
			}*/
		
		/*String s="aaabbcda";
		int count=1,i;
		String op="";
		for(i=0;i<s.length()-1;i++)
		{
			
			if(s.charAt(i)==s.charAt(i+1))
			{
			count++;	
			}
			else
			{
				op=op+s.charAt(i)+count;
				count=1;
			}
		}
		if(i==s.length()-1)
		{
			op=op+s.charAt(i)+count;

		}
		System.out.println(op);*/
		
		String s="my name is akshay";
		String a[]=s.split(" ");
		String temp=a[0];
		a[0]=a[a.length-1];
		a[a.length-1]=temp;
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}

}
