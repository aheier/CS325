
public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 11;
		SingleLinkedList arr[] = new SingleLinkedList[SIZE];
		for(int i=0; i < SIZE; i++) {
			arr[i] = new SingleLinkedList();
		}

	}

}

class Node {
	public int phone_number;
	public String key;
	public Node next;
}

class SingleLinkedList {
	Node head;

	SingleLinkedList() {
		this.head = null;
	}

	void addNode(String key, int value) {
		Node newNode = new Node();
		newNode.key = key;
		newNode.phone_number = value;
		newNode.next = null;

		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current != null) {
			if (current.next == null) {
				current.next = newNode;
				break;
			}
			current = current.next;
		}
	}

	void findNode(String key) {
		if (head == null) {
			System.out.println("Not found");
			return;
		}
		boolean found = false;
		Node current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				System.out.println(current.phone_number);
				found = true;
				return;
			}
		}
		System.out.println("Not found");
	}
}