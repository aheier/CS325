import java.util.*;

public class MyQueue {
	public static void main(String[] args) {
		Queue<Task> myQueue = new PriorityQueue<>(new TaskComparator());
		
		myQueue.add(new Task("Doing Assignment", 4));
		myQueue.add(new Task("Live Streaming", 1));
		myQueue.add(new Task("Video Editing", 2));
		myQueue.add(new Task("Playing Game", 3));
		myQueue.add(new Task("Playing Video Game", 9));
		myQueue.add(new Task("Sleeping", 1));

		
		while(!myQueue.isEmpty()) {
			System.out.printf("%s\n", myQueue.poll().print());
		}
		
	}
}

class Task{
	public String name;
	public int priority;
	public Task(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	public String print() {
		return this.name + " -> " + this.priority;
	}
}
class TaskComparator implements Comparator<Task>{
	public int compare(Task t1, Task t2) {
		return t1.priority - t2.priority;
//		return 0;
	}
	public TaskComparator(){
		
	}
	
}
