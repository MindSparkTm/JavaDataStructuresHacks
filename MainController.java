//This project is Developed by Surajit Das and is licensed under CraftSilicon Kenya
//Feel free to contact @ smartsurajit2008@gmail.com

package application;


import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private Label myMessage;
	
	@FXML
	private TextField fname;
	
	@FXML
	private TextField mname;
	

	
	
	
	public void generateRandom(ActionEvent e)
	{
	
		
		String firstname = fname.getText();
		
		String middlename = mname.getText();
		
		
		String original = firstname;
		
		preprocess(original);
		original = original.toLowerCase();
		
		String [] n = BreakdownString(original);
		
		int v;
		int sum =0;
        
		 	String a = original;
		    a = a.toLowerCase();

		      
		      String [] temp;
		      int [] arr = new int [10];
		            
		      		  
		    	  //Then do Pre processing and separate white spaces
		    	  String b = preprocess(a);
		        //  System.out.println(b);
		          temp = BreakdownString(b);
		          String current = middlename;
		          current = current.toLowerCase();
		 		 String [] c = BreakdownString(current);
		 		 String res ="";
		 	    StringBuilder buffer =new StringBuilder();

		          
		          int count =0;
		          double max = 0;
		          double sim ;
		          double [] val = new double[temp.length];
		          for(int i=0;i<temp.length;i++)
		          {
		        	  //System.out.println(temp[i]);
		        	  int j =0;
		        	  while(j<c.length)
		        	  
		        	  {
		        	   v = EditDistance(c[j],temp[i]);
		        	   sim = similarity(temp[i],c[j]);
		        	   sim = sim*100;
		        	   if(max<sim)
		        		   max = sim;
		        	   
		        	  buffer.append(temp[i] + "\t" + c[j] + "\t"+"EditDistance" + "\t"+ v+"\t" + sim);
		        	  buffer.append(System.getProperty("line.separator"));
		        	  
		        	  j++;
		        	  
		        	  }
		        	  
		        	val[i] = max;
		        	max = 0;
		        	  
		          }

		        	 double s = 0; 
                 for(int i=0;i<val.length;i++)
                 {
                	 System.out.println(val[i]);
                	 s = s + val[i];
                 }
		        	 s = s/val.length; 
		          

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
       // infoBox(buffer.toString(), "Welcome", null);
        
        infoBox("The match percentage is:"+Double.toString(s) + "%","Welcome",null);
        
        
        

		
		
}
	
	public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
	
	public static String preprocess(String pattern)
	{
		 pattern = pattern.trim().replaceAll(" +", " "); 
		 return pattern ;
	}
	
	public static String[] BreakdownString(String a)
	{
		String [] temp;
		 temp = a.split(" ");
		 
		 return temp;

	}


	public static double similarity(String s1, String s2) {
		  String longer = s1, shorter = s2;
		  if (s1.length() < s2.length()) { // longer should always have greater length
		    longer = s2; shorter = s1;
		  }
		  int longerLength = longer.length();
		  if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
		  return (longerLength - EditDistance(longer, shorter)) / (double) longerLength;
		}

	public static int EditDistance(String original, String pattern )
	{
		int distance = 0;
		int len1 = original.length();
		int len2 = pattern.length();
	
		if(original.length()==0)
		{
			//The only thing we can do is to insert every character in the second string into first string
			return pattern.length();
		}
		
		if(pattern.length()==0)
		{
			//The only option is to remove all characters from the first string
			return original.length();
		}
		
		else
		{
			int[][] dp = new int[len1 + 1][len2 + 1];
			 
			for (int i = 0; i <= len1; i++) {
				dp[i][0] = i;
			}
		 
			for (int j = 0; j <= len2; j++) {
				dp[0][j] = j;
			}
		 
			//iterate though, and check last char
			for (int i = 0; i < len1; i++) {
				char c1 = original.charAt(i);
				for (int j = 0; j < len2; j++) {
					char c2 = pattern.charAt(j);
		 
					//if last two chars equal
					if (c1 == c2) {
						//update dp value for +1 length
						dp[i + 1][j + 1] = dp[i][j];
					} else {
						int replace = dp[i][j] + 1;
						int insert = dp[i][j + 1] + 1;
						int delete = dp[i + 1][j] + 1;
		 
						int min = replace > insert ? insert : replace;
						min = delete > min ? min : delete;
						dp[i + 1][j + 1] = min;
					}
				}
			}
			
			return dp[len1][len2];

		}
		
	}
}
