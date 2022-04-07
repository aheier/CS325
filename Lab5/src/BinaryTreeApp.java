import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	Node(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {
	static final int COUNT = 10;
	Node root;

	BinarySearchTree() {
		this.root = null;
	}

	/*
	 * Task 1 - (2 points) Perform a BFS (Breadth first search) on a binary search
	 * tree Print all the nodes (including root) visited during the search
	 */
	void BFS(int data) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node current;
		while (!queue.isEmpty()) {
			current = queue.remove();
			System.out.println("Search: " + current.data);
			if (current.data == data) {
				System.out.println("Found " + current.data);
				return;
			}
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}

		}
		System.out.println("Not Found");
	}

	/*
	 * Task 2 - (2 points) Perform a DFS (Depth first search) on a binary search
	 * tree Print all the nodes (including root) visited during the search
	 */
	void DFS(int data) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		Node current;
		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.println("Search: " + current.data);
			if (current.data == data) {
				System.out.println("Found " + current.data);
				return;
			}
			if (current.right != null) {
				stack.add(current.right);
			}
			if (current.left != null) {
				stack.add(current.left);
			}

		}
		System.out.println("Not Found");
	}

	/*
	 * Task 3 - (2 points) Remove a node based on the data passed. Print the 2D tree
	 * after the removal.
	 */
	void removeNode(int data) {
		if (root == null) {
			return;
		}
		if (root.data == data) {
			System.out.println(root.data + " removed.");
			root = null;
			return;
		}
		Node current = root;
		Node prev = current;
		
		while (current != null) {
			System.out.println("Search: " + current.data);
			if (current.data == data) {
				if(prev.right== current) {
					prev.right = null;
					System.out.println(current.data + " removed.");
					return;
				}
				///can get rid of this if statement 
				if(prev.left == current) {
					prev.left = null;
					System.out.println(current.data + " removed.");
					return;
				}
			}
			if (current.data > data) {
				prev = current;
				current = current.left;
				continue;
			}
			prev = current;
			current = current.right;
		}
		System.out.println("Not Found");

	}

	/*
	 * Task 4 - (2 points) Check if the binary search tree is a full binary tree or
	 * not. If it is then prints "Full Binary Tree", otherwise
	 * "Not a full binary tree". A full Binary tree is a special type of binary tree
	 * in which every parent node has either two or no children.
	 */
	void isFullBinaryTree(int data) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node current;
		while (!queue.isEmpty()) {
			current = queue.remove();
//			System.out.println("Search: " + current.data);
			if (!(current.left == null && current.right ==null) && !(current.left != null && current.right != null)) {
				System.out.print("Not A full Binary Tree: ");
				System.out.println(current.data);
				return;
			}
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}

		}
		System.out.println("Full Binary Tree");
	}

	void addNode(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node prev = null;
		while (current != null) {
			prev = current;
			if (data < current.data) {
				current = current.left;
				continue;
			}
			current = current.right;
		}

		if (data < prev.data) {
			prev.left = newNode;
			return;
		}
		prev.right = newNode;
	}

	// Function to perform inOrder traversal on the tree using recursion
	public void PrintInorderRecursive(Node root) {
		if (root == null) {
			return;
		}
		PrintInorderRecursive(root.left);
		System.out.print(root.data + " ");
		PrintInorderRecursive(root.right);
	}

	// Function to perform inOrder traversal using iterative approach
	void PrintInOrder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		Node current = root;
		while (current != null || s.size() > 0) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}
			current = s.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}

	/* This prints the binary tree in 2D fashion */
	void print2DTree(Node root, int space) {
		if (root == null)
			return;

		space += COUNT;

		print2DTree(root.right, space);
		System.out.print("\n");
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.data + "\n");

		print2DTree(root.left, space);
	}
}

public class BinaryTreeApp {
	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();

		b.addNode(10);
		b.addNode(4);
		b.addNode(3);
		b.addNode(5);
		b.addNode(15);
		b.addNode(12);
		b.addNode(11);
		b.addNode(6);
		b.addNode(17);
		b.PrintInOrder(b.root);
		b.print2DTree(b.root, 0);

//		System.out.println("Breadth");
//		b.BFS(11);
//		b.BFS(1);
//		b.BFS(15);

//		System.out.println("Depth");
//		b.DFS(11);
//		b.DFS(1);
//		b.DFS(15);

		b.removeNode(12);
//		b.removeNode(6);
//		b.removeNode(11);
		b.PrintInOrder(b.root);
		b.addNode(11);
		b.print2DTree(b.root, 0);
		b.isFullBinaryTree(0);
	}
}