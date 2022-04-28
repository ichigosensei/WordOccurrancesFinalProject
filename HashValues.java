package Module2;

public class HashValues {
	
    static final String addHashString = "add_hash_string";
	
     //returns values in strings
	static int addValues(String avString, int valueSize) {
		
		int nTotal = 0;
		
			for(int i = 0; i < 20 && i < avString.length(); i++) {
				nTotal += avString.charAt(i);
				nTotal %= valueSize;
			
		}	return nTotal; 
	}
}