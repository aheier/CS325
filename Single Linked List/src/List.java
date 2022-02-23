

public class List {
	public static void main(String args[]) {
		SingleLinkedList list = new SingleLinkedList();

		list.add(5);
		list.add(6);
		list.display();
	
		list.remove(6);
		list.remove(7);
		list.remove(5);
		list.remove(7);
		
		list.display();

		list.add(20);
		list.add(7);
		list.add(15);
		list.remove(7);
		
		list.display();
	}
}
