import java.util.Scanner;

class Node {
	String key;
	int phone_number;
	Node next;
}

class SingleLinkedList {
	Node head;

	SingleLinkedList() {
		this.head = null;
	}

	void addNode(String k, int phone) {
		Node newNode = new Node();
		newNode.key = k;
		newNode.phone_number = phone;
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

	void findNode(String k) {
		if (head == null) {
			System.out.print("List is empty, nothing to find");
			return;
		}
		boolean found = false;
		Node current = head;
		while (current != null) {
//			System.out.println(current.key);
			//Change from == to .equals
			if (current.key.equals(k)) {
				System.out.println(current.phone_number);
				found = true;
				break;
			}
			current = current.next;
		}
		if (!found) {
			System.out.println("No Such Key Found");
		}
	}
}

public class Hashing {
	public static void main(String[] args) {
		SingleLinkedList[] indices = new SingleLinkedList[11];

		// Create 11 linked lists and assign them to corresponding array index

		// Below is an example of 1 set of input.
		// You need to put these in a loop which runs 11 times
		// Inside the loop, you will generate the index based on the hash function
		// Then add the key and value into the right linked list.
		Scanner scan = new Scanner(System.in);
		String key = "";
		int phone, index;
		int i = 0;

		while (i < 11) {
			key = scan.next().strip();
			phone = scan.nextInt();
			index = hashFunc(key);
			if (indices[index] == null) {
				indices[index] = new SingleLinkedList();
				indices[index].addNode(key, phone);
				System.out.printf("%s %s added at %s\n", key, phone, index);
				i++;
				continue;
			}
			indices[index].addNode(key, phone);
			System.out.printf("%s %s added at %s\n", key, phone, index);
			i++;
		}

		System.out.print("Enter a name : ");
		String name = scan.next();
		while (!name.equals("Q")) {

			index = hashFunc(name);
			if (indices[index] != null) {
				indices[index].findNode(name);
				name = scan.next();
				continue;
			}
			System.out.println("No such key found");
			name = scan.next();
		}

		// Using the hash function, generate the index
		// Search the appropriate linked list based on the index
		// If found, print the phone number
		// If not found, print 'Not found'

	}

	public static int hashFunc(String key) {
		int sum = 0;
		for (char c : key.toCharArray()) {
			sum += c;
		}
		return sum % 11;
	}

	/*
	 * Mia 1111
Tim 2222
Bea 3333
Zoe 4444
Sue 5555
Len 6666
Moe 7777
Lou 8888
Rae 9999
Max 1010
Tod 2020

	 */
}
