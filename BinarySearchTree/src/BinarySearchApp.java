import java.util.Stack;

	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	class BinarySearchTree{
		Node root;
		BinarySearchTree() {
			this.root = null;
		}
		void addNode(int data) {
			Node newNode = new Node(data);
			if(root == null) {
				root = newNode;
				return;
			}
			Node previous = root;
			Node current = root;
			while(current != null) {
				previous = current;
				if(newNode.data <= root.data) {
					current = current.left;
					continue;
				}
				if(newNode.data > root.data) {
					current = current.right;
					continue;
				}
			}
			if(newNode.data <= previous.data) {
				previous.left = newNode;
				return;
			}
			previous.right = newNode;
		}
		
		void printInOrder() {
			if(root==null) return;
			Stack<Node> s = new Stack<Node>();
			Node current = root;
			while(current != null || s.size() > 0){
				while(current != null) {
					s.push(current);
					current = current.left;
				}
				current = s.pop();
				System.out.print(current.data + " ");
				current = current.right;
			}
		}
		
		
	}

public class BinarySearchApp {
	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.addNode(10);
		b.addNode(13);
		b.addNode(14);
		b.addNode(18);
		b.addNode(20);
		b.addNode(30);
		b.addNode(50);
		b.addNode(2);
		b.addNode(3);
		b.addNode(4);
		b.addNode(5);
		b.addNode(3);
		b.printInOrder();
	}
}
