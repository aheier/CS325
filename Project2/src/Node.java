
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
