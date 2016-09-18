import java.util.Hashtable;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<Integer, String> hs= new Hashtable<Integer, String>();
		hs.put(1, "Raaj");
		hs.put(0, "Andy");
		
		hs.put(2, "Mohsen");
		
		
		System.out.println(hs);
        hs.put(0, hs.get(0)+"Lee");
        
        System.out.println(hs);
        
        
       /*Average case complexity 
        //Hash table insertion time = 0(1)
        //Hash table search time = 0(1)
        //Hash table deletion time = 0(1)
        
        */
        
        /*Worst case complexity 
        Hash table insertion time = 0(n)
        Hash table search time = 0(n)
        Hash table deletion time = 0(n)
        
        */

        //Worst case space complexity is 0(n)
        
		
		
	}
	
	

}
