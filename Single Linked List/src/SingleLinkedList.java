
public class SingleLinkedList {
	Node head;
	SingleLinkedList(){
		this.head = null;
	}
	
	void add(int value) {
		Node newNode = new Node(value, null);
//		newNode.data = value;
//		newNode.next = null;
		
		if(head == null) {
			this.head = newNode;
			return;
		}
		
		Node current = head;
		while(current != null) {
			if(current.next == null) {
				current.next = newNode;
				break;
			}
			current = current.next;
		}
	}
	
	void display() {
		if(head == null)
			System.out.println("List is empty");
		Node current = head;
		while(current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println("");
	}
	
	
	void remove(int value) {
		//check if list is empty
		if(this.head == null) {
			System.out.println("Cant remove, List is empty");
			return;
		}
		Node current = this.head;
		Node previous = this.head;
		//check if head
		if(current.data == value) {
			this.head = head.next;
			return;
		}
		//finds previous and current node
		while(current.data != value) {
			previous = current;
			current = current.next;
			//check if current is null, value not found
			if(current == null) {
				System.out.println("Couldnt find value");
				return;
			}
		}
		//skips over node
		previous.next = current.next;
		
	}
	

}
