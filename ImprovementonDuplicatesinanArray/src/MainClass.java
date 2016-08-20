//This code has been written by Surajit Das. Any suggestions or corrections on the code. Please direct it @smartsurajit2008@gmail.com
import java.util.HashSet;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      HashSet<Integer> hs = new HashSet<Integer>();
	       int [] a= {10,7,100,7,9,9,10,10,11,11,1};
	       
	       for(int i=0;i<a.length;i++)
	       {
	    	   hs.add(a[i]);
	       }
	       
	       Integer [] rtrn = new Integer[hs.size()];
	       rtrn = hs.toArray(rtrn);
	       
	       for(int i=0;i<rtrn.length;i++)
	    	   System.out.print(rtrn[i] +"\t");

	}

}
