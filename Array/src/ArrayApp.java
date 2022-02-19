public class ArrayApp {
	public static void main(String[] args) {
		int maxSize = 50; // array max size
		
		Array arrObject = new Array(maxSize); 

		// insert 10 random numbers into the array
		arrObject.insert(9);
		arrObject.insert(19);
		arrObject.insert(7);
		arrObject.insert(23);
		arrObject.insert(47);
		arrObject.insert(58);
		arrObject.insert(30);
		arrObject.insert(92);
		arrObject.insert(48);
		arrObject.insert(19);

		
		arrObject.display(); // display items

		// Print the largest number in that array
		long maxItem = arrObject.getMax();
		System.out.println("Largest key is " + maxItem);
		
		// find an item
		if (arrObject.find(47)) {
			System.out.println("I found it. ");
		} else {
			System.out.println("I didn't find it. ");
		}
		
		// inserting a new number 
		arrObject.insert(29);
		arrObject.display(); // display items
		
		// delete a number
		arrObject.delete(30);
		arrObject.display(); // display items

		System.out.println("Here");
//		arrObject.bubbleSort();
		arrObject.bubbleSort();
		arrObject.display();
	}
}
