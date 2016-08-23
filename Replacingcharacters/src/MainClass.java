
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String text = "Hello World !"
		 		+ "Hello";
         
		 if(!text.isEmpty())
		 {
		 //Method 1 Iteration approach
		 System.out.println("Replacing Characters using Iteration Approach");
		 System.out.println(replace(text,'o','s'));
		 
		 //Method 2 Recursion approach
         char [] temp = new char[text.length()];
         temp = text.toCharArray();
		 
	    recursiveapproach(temp,0,temp.length,'o','s');
	    System.out.println("Replacing characters using Recursion Approach");
		System.out.print(String.valueOf(temp));
		 }
		 
		 
        
        
        else
        {
        	System.out.println("Empty String");
        }
	   
	    
	    
	   
	    
	}
	
	public static String replace(String str, char ch,char r)
	{
		char[] c = new char [str.length()]; // O(1);
		
		
		
			c = str.toCharArray(); //assuming it to be O(1)
			for(int i=0;i<c.length;i++)//O(n)
			{
				if(ch==c[i]) // O(1)
				{
					c[i] = r; // O(1)
				}
			}
			
			//for(int i=0;i<c.length;i++)
				//System.out.print(c[i] + "\t");
			
		
		
		String s = String.valueOf(c); //// O(1)
		
		return s; //// O(1)
		
		
		// Time complexity is O(n) for the above code.
		
		
		
		
	}

	 public static void replacechar(char[] a,int start,char c,char r)
		{
	      
			if(a[start]== c)
			{
				a[start] = r;
	         
			}
		}
		public static void recursiveapproach(char[] a,int start,int end,char c,char r)
		{
		   
		 
		
			
			int mid;
	      
	      int s = a.length-1;
		    
			if(start<end)
			{
				mid = start + (end - start)/2;
	         
	         
				recursiveapproach(a,start,mid,c,r);
	         
	           
				recursiveapproach(a,mid+1,end,c,r);
				
	           
				
			}
		     
			
				if(start==end && start<=s)
				{
	            
				replacechar(a,start,c,r);
	            
				}

	      
	      
				
			
		
		}
	
	

}
