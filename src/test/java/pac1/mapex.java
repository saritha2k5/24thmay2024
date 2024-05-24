package pac1;
import java.util.*;
import java.util.Map.Entry;

public class mapex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	HashMap<String, Double> hm=new HashMap<String,Double>();
		//hm.put("Hello Hi Bye !! Welcome to Pune Pune Hi !!",1000.00);
		//hm.put("ramya",3000.55);
		
		HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		   map.put(1,"Mango");  //Put elements in Map  
		   map.put(2,"Apple");    
		   map.put(3,"Banana"); 
		   map.put(5,"Banana"); 
		   map.put(4,"Grapes");   
		       
		   System.out.println("Iterating Hashmap...");  
		   for(Entry<Integer, String> m : map.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   }  
		}  
		

		
		
	

}
