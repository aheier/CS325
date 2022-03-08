
public class DoubleLinkedList {
	Node head;

	DoubleLinkedList() {
		this.head = null;
	}

	void addNode(int val) {
		Node newNode = new Node();
		newNode.data = val;
		newNode.next = null;
		newNode.prev = null;
		
		if (head == null) { // if the list was empty
			head = newNode;
			return;
		}
		Node current = head; // current is a temporary node for traveling the list
        while(current != null) {
        	// Making sure current doesn't end up in null and 
        	// checking ahead of the time. If current next points to null
        	// add the new node.
            if (current.next == null) {
                current.next = newNode;
                break;
            }
            current = current.next;
        }   
	}

	/* This method asks the user for the value of an existing node, 
	 * if found, print “Found it”, otherwise print “Not found”
	 */
	void findNode(int data) {
	}

	/* This method asks the user for the value (old) of an existing node, 
	 * then ask for a new value and update the list with the new value.
	 * No update happens if user provided value is not found. Then it prints
	 * appropriate message. (Example: No update, value not found)
     * If multiple nodes have the same value, then all of them get update
     * with the new value.
     */
	void updateNode(int oldData, int newData) {
	}
	
	/*
	 * If the list is empty and there is nothing to delete, then
	 * this method simply prints “List is empty, nothing to delete”
	 * Otherwise, asks the user for the value of an existing node, 
	 * If found delete the node and displays all the remaining node(s). 
	 * If not found, prints "Value not found"
	 * To display all node, you can simply call the existing method: displayAll()
	 * If multiple nodes have the same value, delete all of them. 
	 * If all the nodes had the same value, after deleting all of them 
	 * print “List is empty”
	 */
	void deleteNode(int val) {
	}
	
	/* This method deletes the first node. If the list is empty 
	 * means nothing to delete, it prints “List is empty, nothing to delete”
	 * If that was the only node, after deleting it prints “List is empty”
	 * There is no user input in this method
	 */
	void deleteFirstNode() {
	}

	/* This method deletes the last node. If the list is empty 
	 * means nothing to delete, it prints “List is empty, nothing to delete”
	 * If that was the only node, after deleting it prints “List is empty”
	 * There is no user input in this method
	 */
	void deleteLastNode() {
	}
	
	/* This method prints the total size of the list
	 * There is no user input in this method
	 */
	void size() {
	}
	
	/* This method prints all the nodes.
	 * If the list is empty, it prints "List is empty, nothing to display
	 */
	void displayAll() {
		if (head == null) {
			System.out.println("List is empty, nothing display");
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
