class Node {
	int data;
	Node next;
}

class SortedSingleLinkedList {
	Node head;

	SortedSingleLinkedList() {
		this.head = null;
	}

	/* Implement this */
	void addNode(int val) {
		Node newNode = new Node();
		newNode.data = val;
		newNode.next = null;

		if (head == null) {
			this.head = newNode;
			return;
		}

		Node current = this.head;
		while (current != null) {
			if (current.data < newNode.data) {
				newNode.next = current.next;
				int temp = current.data;
				current.data = newNode.data;
				newNode.data = temp;
				current.next = newNode;
				break;

			}
			current = current.next;
		}
	}

	/* Implement this */
	void deleteNode(int val) {
		Node current = this.head;
		Node previous = this.head;
		if(this.head == null) {
			System.out.println("Cant remove, List is empty");
			return;
		}
		if(current.data == val) {
			this.head = head.next;
			deleteNode(val);
		}
		while (current != null) {
			if(current.data == val) {
				previous.next = current.next;
				current = current.next;
				continue;
			}
//			if(val < current.data) {
//				return;
//			}
			previous = current;
			current = current.next;
		}
	}

	/* Implement this */
	void findNode(int val) {
		int pos = 0;
		Node current = this.head;
		while (current != null) {
			if(current.data == val) {
				System.out.printf("Node found at pos %s\n", pos);
			}
			pos++;
			current = current.next;
		}
	}

	void displayAll() {
		if (head == null) {
			System.out.println("List is empty! nothing to display");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}

public class SortedLinkedList {

	public static void main(String[] args) {
		SortedSingleLinkedList sll = new SortedSingleLinkedList();
		/* Test your program here */
		
		sll.addNode(25);

		sll.displayAll();
		System.out.println("delete here");

		sll.deleteNode(20);
		sll.deleteNode(25);

		sll.displayAll();


		sll.addNode(25);
		sll.findNode(5);
		sll.findNode(25);
	}
}