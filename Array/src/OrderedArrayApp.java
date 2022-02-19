
public class OrderedArrayApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		OrdededArray arrObject; // reference to array
		arrObject = new OrdededArray(maxSize); // create the array
		int searchKey;

		// insert 10 items
		arrObject.insert(77); 
		arrObject.insert(99);
		arrObject.display();
		arrObject.insert(44);
		arrObject.display();
		arrObject.insert(55);
		arrObject.display();
		arrObject.insert(22);
		arrObject.display();
		arrObject.insert(88);
		arrObject.insert(11);
		arrObject.insert(00);
		arrObject.insert(66);
		arrObject.insert(33);
		arrObject.insert(77);
		arrObject.display();
		arrObject.delete(33);

		arrObject.display();

		searchKey = 55;

		if (arrObject.find(searchKey) != arrObject.size()) {
			System.out.println("Found " + searchKey);
		}
		else {
			System.out.println("Can't find " + searchKey);
		}

		if (arrObject.delete(searchKey) == true) {
			System.out.println("Deleted " + searchKey); 
		}
		else {
			System.out.println("Can't find " + searchKey);
		}

		searchKey = 56;

		if (arrObject.find(searchKey) != arrObject.size()) {
			System.out.println("Found " + searchKey);
		}
		else {
			System.out.println("Can't find " + searchKey);
		}

		if (arrObject.delete(searchKey) == true) {
			System.out.println("Deleted " + searchKey);
		}
		else {
			System.out.println("Can't delete " + searchKey);
		}

		arrObject.display();
		
		// adding a new item 
		int newItem = 47;
		arrObject.insert(47);
		arrObject.display();
		
	}
}

	