import java.util.*; 

public class HuffmanDecode {
	public static void main(String[] args) {
		/* Java Hash table is like a Python dictionary 
		 * where there is a key and value. Keys must be unique.
		 */
		Hashtable<String, Character> my_dict = new Hashtable<String, Character>();
		
		/* Adding items into the dictionary/hash table
		 * following is the mapping after Huffman coding algorithm is applied 
		 */
		my_dict.put("0000", 'o');
		my_dict.put("0001", 'x');
		my_dict.put("0010", 'i');
		my_dict.put("0011", 'b');
		my_dict.put("01", 'a');
		my_dict.put("11", 'n');
		my_dict.put("10", ' ');
		
		/* Example of how to print all the keys and values */
		Set<String> keys = my_dict.keySet();
        for(String key: keys){
            System.out.println("Value of "+key+" is: "+my_dict.get(key));
        }
		
        /* Example of how to find 1 item using the key */
        System.out.println("Value is: "+my_dict.get("0010"));  // This prints 'i'
        
		/* Following is the code for a specific text based on the dictionary */
		String code = "0011011101110110001011100110001100000001";
		
		/* Task: Figure out the original text */
		String s = "";
		int begin=0;
		for(int i = 0; i <= code.length(); i++) {
			s = code.substring(begin, i);
			if(my_dict.containsKey(s)) {
				System.out.print(my_dict.get(s));
				begin += i - begin;
				continue;
			}
			
		}
	}
}
