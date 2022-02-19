import java.util.Stack;

public class NewStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(5);
		for(int i : stack) {
			System.out.println(i);
		}
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
