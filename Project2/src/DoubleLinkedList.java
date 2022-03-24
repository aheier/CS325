import java.util.Scanner;

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
                newNode.prev = current;
                break;
            }
            current = current.next;
        }   
	}

	/* This method asks the user for the value of an existing node, 
	 * if found, print â€œFound itâ€�, otherwise print â€œNot foundâ€�
	 */
	void findNode(int data) {	
		boolean found = false;
		if (head == null) { // if the list was empty
			System.out.println("Not found");
			return;
		}
		Node current = head; 
        while(current != null) {
        	// add the new node.
            if (current.data == data) {
            	System.out.print("Found it. ");
            	current.print();
            	found = true;
            }
            current = current.next;
        }   
        if(!found) System.out.println("Not Found");
	}

	/* This method asks the user for the value (old) of an existing node, 
	 * then ask for a new value and update the list with the new value.
	 * No update happens if user provided value is not found. Then it prints
	 * appropriate message. (Example: No update, value not found)
     * If multiple nodes have the same value, then all of them get update
     * with the new value.
     */
	void updateNode(int oldData, int newData) {
		boolean found = false;
		if (isEmpty()) {
			System.out.println("No Update, List is empty.");
			return;
		}
		Node current = head; 
        while(current != null) {
        	// add the new node.
            if (current.data == oldData) {
            	System.out.printf("Node %s updated from %s to %s.\n", current, current.data, newData);
            	current.data = newData;
            	found = true;
            }
            current = current.next;
        }   
        if(!found) System.out.println("Not Found");
	}
	
	/*
	 * If the list is empty and there is nothing to delete, then
	 * this method simply prints â€œList is empty, nothing to deleteâ€�
	 * Otherwise, asks the user for the value of an existing node, 
	 * If found delete the node and displays all the remaining node(s). 
	 * If not found, prints "Value not found"
	 * To display all node, you can simply call the existing method: displayAll()
	 * If multiple nodes have the same value, delete all of them. 
	 * If all the nodes had the same value, after deleting all of them 
	 * print â€œList is emptyâ€�
	 */
	void deleteNode(int val) {
		boolean found = false;
		if (isEmpty()) { // if the list was empty
			System.out.println("List is empty, nothing to delete.");
			return;
		}
		Node current = head; 
        while(current != null) {
        	// add the new node.
            if (current.data == val) {
            	System.out.printf("Node %s deleted.\n", current);
        		if(current==head) {
                	deleteFirstNode();
                	current = current.next;
                	found = true;
                	continue;
        		}
            	current.prev.next = current.next;
            	current.next.prev = current.prev;
            	found=true;
            }
            current = current.next;
        }   
        if(!found)System.out.println("Not Found");
	}
	
	/* This method deletes the first node. If the list is empty 
	 * means nothing to delete, it prints â€œList is empty, nothing to deleteâ€�
	 * If that was the only node, after deleting it prints â€œList is emptyâ€�
	 * There is no user input in this method
	 */
	void deleteFirstNode() {
		if (isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
    	if(head.next == null) {
    		head=null;
    		return;
    	}
		head = head.next;
		head.prev = null;
	}

	/* This method deletes the last node. If the list is empty 
	 * means nothing to delete, it prints â€œList is empty, nothing to deleteâ€�
	 * If that was the only node, after deleting it prints â€œList is emptyâ€�
	 * There is no user input in this method
	 */
	void deleteLastNode() {
		if (isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
		Node current = head;
		while(current.next != null) {
            current = current.next;			
		}
		if(current.prev == null) { //only item
			head = null;
			return;
		}
		current.prev.next = null;
	}
	
	/* This method prints the total size of the list
	 * There is no user input in this method
	 */
	void size() {
		int size=0;
		Node current = head;
		while(current != null) {
			size++;
			current = current.next;
		}
		System.out.printf("Total node(s): %s\n", size);
	}
	
	/* This method prints all the nodes.
	 * If the list is empty, it prints "List is empty, nothing to display
	 */
	void displayAll() {
		if (isEmpty()) {
			System.out.println("List is empty, nothing display");
			return;
		}
		Node current = head;
		while (current != null) {
			//System.out.print(current.data + " ");
			current.print();
			current = current.next;
		}
		System.out.println();
	}
	
	boolean isEmpty() {
		if(head == null) return true;
		return false;
	}

	boolean find(int data) {
		if(isEmpty()) return false;
		Node current = head; 
        while(current != null) {
            if (current.data == data) {
            	return true;
            }
            current = current.next;
        }   
        return false;
	}

	public static void main(String[] args) {
		DoubleLinkedList d = new DoubleLinkedList();
		Scanner scnr = new Scanner(System.in);
	
		int input;
		d.addNode(5);
		d.addNode(10);
		d.addNode(15);
		d.addNode(20);
		d.displayAll();
		do {
			printMenu();
			input = getInput(scnr);
			switch(input) {
			case 1:
				System.out.print("Enter in item to add: ");
				d.addNode(getInput(scnr));
				break;
			case 2:
				System.out.print("Enter in item to Delete: ");
				d.deleteNode(getInput(scnr));
				break;
			case 3:
				System.out.print("Enter in item to Find: ");
				d.findNode(getInput(scnr));
				break;
			case 4:
				System.out.println("Deleting first Node.");
				d.deleteFirstNode();;
				break;
			case 5:
				System.out.println("Deleting last Node.");
				d.deleteLastNode();;
				break;
			case 6:
				d.displayAll();
				break;
			case 7:
				d.size();
				break;
			case 8:
				System.out.print("Enter in item to Update: ");
				int update = getInput(scnr);
				if(!d.find(update)) {
					System.out.println("Not Found");
					break;
				}
				System.out.print("Enter in new value: ");
				d.updateNode(update, getInput(scnr));
				break;
			default:
				System.out.println("Bad input");
				break;
			}
		}
		while(input != 0);
		
		
	}
	
	public static void printMenu() {
		System.out.println(
		"|-----------------Menu-----------------|\n"+
		"|    1. Add          2. Delete         |\n"+
		"|    3. Find         4. Delete First   |\n"+
		"|    5. Delete Last  6. Display All    |\n"+
		"|    7. Size         8. Update         |\n"+
		"|               0. Exit                |\n"+
		"|-----------Select An Option-----------|\n"
				);
	}
	public static int getInput(Scanner sc) {
		int input = -1;
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				input = sc.nextInt();
				break;
			}
			else {
				sc.next();
			}
		}
		return input;
	}

public class Node {
	int data;
	Node prev;
	Node next;
	
	public void print() {//								'No prev node
		System.out.println("| " + ((this.prev == null)? "No prev node " : this.prev)  + 
				" < " + this.toString()  + " : " + this.data + " > " + 
				((this.next == null)? "No next node " : this.next) + " |");
	}
}

}


