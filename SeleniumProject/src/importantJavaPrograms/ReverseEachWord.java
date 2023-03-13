package importantJavaPrograms;

public class ReverseEachWord {

	public static void main(String[] args) {
/*String str="akshay holkar";
String []a=str.split(" ");
for (int i=a.length-1;i>=0;i--)
{
	System.out.print(a[i]+" ");
}
}*/	
	String s="akshay holkar";
	String[] a=s.split(" ");
	for(int i=a.length-1;i>=0;i--)
	{
	System.out.print(a[i]+" ");	
	}
}
}