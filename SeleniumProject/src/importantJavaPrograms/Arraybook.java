package importantJavaPrograms;

class Book 
{
	String name;
	int pages;

	Book (String name,int pages)
		{
		this.name = name;
		this.pages= pages;
		}
	@Override
		public String toString()
		{
		return "name:= "+name+"pages:- "+pages;
	}
		
}
class Arraybook
	{
		public static void main(String[] args)		
			{
			Book [] bookar = new Book[3];

			Book b1 = new Book("java",1000);
			Book b2 = new Book("python",500);
			Book b3 = new Book("c++",200);

			bookar[0] =b1;
			bookar[1] =b2;
			bookar[2] =b3;

			for(int i= 0; i<bookar.length;i++)
			{
				System.out.println(bookar[i]);
			}
		}
	}

	
