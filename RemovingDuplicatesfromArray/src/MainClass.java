//This code is written by Surajit Das. The code elements duplicates from an array.
//For more query contact him @smartsurajit2008gmail.com for your mean comments.



public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] a= {1,7,7,7,9,9,10,10,10,11,11,1};
		removeduplicates(a);
		
		
		
		
	}
	
	public static void removeduplicates(int[]a)
	{
		int flag=0;
		int b =0;
		int k=0;
		int [] temp = new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			int key = a[i];
			for(int j=i+1;j<a.length;j++)
			{
				if(key==a[j])
				{
					flag++;
					
				}
			}
			
			if(flag==0)
			{
				temp[k] = key;
				k++;
				
			}
			
			else
			{
				for( int m=0;m<temp.length;m++)
				{
					if(key==temp[m])
					{
						b++;
					}
				}
				
				if(b==0)
				{
					temp[k] = key;
					k++;
				}
			}
			
			b = 0;
		}
		
		for(int i=0;i<k;i++)
			System.out.println(temp[i]);
		
	}
	
	
}
