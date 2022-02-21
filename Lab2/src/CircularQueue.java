
public class CircularQueue {
	int front, rear, size;
	int arr[];
	boolean isEmpty;
	int currElems;

	public CircularQueue(int size) {
		this.arr = new int[size];
		this.size = size;
		this.front = -1;
		this.rear = -1;
		currElems=0;
	}
	
	public void add(int item) throws Exception {
		if(currElems == arr.length) {
			throw new Exception("Queue is full, can't add");
		}
		increaseRear();
		arr[rear] = item;
		currElems++;
		if(front == -1) {
			front = rear;
		}
	}
	public int poll() throws Exception {
		if(currElems == 0)
			throw new Exception("Que is empty, can't delete");
		int r = arr[front];
		currElems--;
		increaseFront();
		return r;
	}
	
	public void displayAll() {
		if(currElems ==0) {
			System.out.println("Queue is empty");
		}
		for(int i = 0; i < currElems; i++) {
			System.out.print(arr[(front+i)%size] + ", ");
		}
		System.out.println("");
	}
	
	private void increaseFront() {
		front = (front+1) % size;
	}	
	private void increaseRear() {
		rear = (rear+1) % size;
	}
}
