import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		String input, postfix;
		Scanner scnr = new Scanner(System.in);
		
		do {
			System.out.println("Enter in your Expression:");
			input = getExpression(scnr);
//			System.out.printf("Input: %s\n", input);
		}
		while(!validateExpression(input));
		
		postfix = getPostfixNotation(input);
		HashMap<Character, Integer> map = getValues(postfix, scnr);
		int value = calculatePostfix(postfix, map);
		
		System.out.printf("Postfix expression: %s\n", postfix);
		System.out.printf("Result: %d", value);
		
	}
	
	static String getExpression(Scanner scnr) {
		String input = scnr.nextLine();
		//valid characters must match regex and length limit, if not get new line
		while(!input.matches("[a-z +\\-\\*\\/]+") && (input.length()<=100)) {
			System.out.println("Invalid syntax");
			input = scnr.nextLine();
		}
		return input;
	}
	
	static boolean validateExpression(String expression) {
		int index = 0;
		// The expression must go operand, operator, operand... and end in an operand
		char[] characters = expression.toCharArray();
		//TODO: replace whitespace characters
		for(Character c : characters) {
			//check if a-z if even in sequence
			if((index % 2) == 0) {
				if(c < 97) {	
					System.out.printf("Unexpected character %s found at %d: Operand expected.\n", c, index);
					return false;
				}
				index++;
				continue;
			}
			//check its not a-z
			if( c > 97) {
				System.out.printf("Unexpected character %s found at %d: Operator expected.\n", c, index);
				return false;
			}
			index++;
		}
		Character d;
		if((d = characters[characters.length-1]) < 97) {
			System.out.printf("Unexpected character %s: Cannot end in operator.\n", d);
			return false;			
		}
		return true;
	}
	
	static String getPostfixNotation(String input) {
		Stack<Character> operators = new Stack<Character>();
		input = input.replace(" ", "");
		String temp="";
		
		for(Character c:input.toCharArray()) {
			//if is character a-z using ASCII
			if(c >= 97) {
				temp += c;
				continue;
			}
			//if there are no opperators or the current operator has higher precedence
			if(operators.isEmpty() || (getOperatorPrecedence(c) > getOperatorPrecedence(operators.peek())) ) {
				operators.add(c);
				continue;
			}
			//loop while the current operator has lower or equal precedence to the next operator
			//exit 
			while(getOperatorPrecedence(c) <= getOperatorPrecedence(operators.peek()) ) {
				temp+=operators.pop();
				if(operators.isEmpty()) {
					//push last operator on stack 
					operators.add(c);
					break;
				}
			}
			//TODO: push last operator on stack in case stack not empty
			if(operators.size() > 1) {
				operators.add(c);
			}
		}
		while(!operators.isEmpty()) {
			temp+=operators.pop();
		}
		return temp;
	}
	
	static int getOperatorPrecedence(Character c) {
		if(c == '*' || c=='/') {
			return 2;
		}
		return 1;
	}
	
	static HashMap<Character, Integer> getValues(String input, Scanner scnr){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c : input.toCharArray()) {
			//if already in Hashmap or is not a-z
			if(map.containsKey(c) || c < 97) {
				continue;
			}
			while(true) {
				try {
					System.out.printf("%s : ", c);
					map.put(c, scnr.nextInt());
					break;
				}
				catch(InputMismatchException e) {
					System.out.print("bad input ");
					scnr.next();
				}
			}
		}
		
		return map;		
	}
	
	static int calculatePostfix(String input, HashMap<Character, Integer> map) {
		int temp=0, first, second;
		Stack<Integer> operands = new Stack<Integer>();
		for(Character c : input.toCharArray()) {
			//if character, get value and add to stack
			if(c >= 97) {
				operands.add(map.get(c));
				continue;
			}
			//else pull first and second from stack and operate
			first = operands.pop();
			second = operands.pop();
			switch(c) {
			case '/':
				temp = second / first;
				break;
			case '*':
				temp = second * first;
				break;
			case '+':
				 temp = second + first;
				 break;
			case '-':
				temp = second - first;
				break;
			}
			//add value back to
			operands.add(temp);
		}
		//check 1 value left in stack
		if(operands.size()> 0) {
			return operands.pop();
		}
		return 0;
	}
}
