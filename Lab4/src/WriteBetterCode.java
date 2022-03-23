import java.util.Scanner;
import java.util.Random;

public class WriteBetterCode {

	/*
	 * Method 1 
	 * Purpose: This method takes a boolean value, checks if true or false,
	 * and then returns the same thing.
	 * Task: Re-write these 5 lines with just 1 line.
	 */
	public static boolean isTrue(boolean value) {
		return value;
	}

	/*
	 * Method 2 
	 * Purpose: From 1 to 10, it prints even or odd 
	 * Task1: Avoid else clause
	 * Task2: Avoid duplicate code
	 */
	public static void noElse() {
		for (int i = 1; i <= 10; ++i) {
			System.out.println(i + " is " + ((i % 2 == 0)? "even" : "odd") + " number");
			
//			if (i % 2 == 0) {
//				System.out.print(i + " is even number");
//				continue;
//			}
//			System.out.print(i + " is odd number");
		}
	}

	/*
	 * Method 3 
	 * Purpose: It takes an array and a value and returns true/false based
	 * on the value exists or not. 
	 * Task 1: Re-write the code using Java "for each loop" 
	 * Task 2: Get rid of the variable "found"
	 */
	public static boolean isFound(int[] array, int val) {
		for(int a : array) {
			if(a == val) {
				return true;
			}
		}
		return false;
		
//		boolean found = false;
//		for (int i = 0; i < array.length; ++i) {
//			if (array[i] == val) {
//				found = true;
//			}
//		}
//		return found;
	}

	/*
	 * Method 4 Purpose: It takes an input from the user and prints
	 * associated index fruit name.
	 * Task: Handle probable exception using try...catch block
	 */
	public static void handleException() {
		String array[] = { "Apple", "Banana", "Pear", "Mango", "Orange" };
		Scanner scan = new Scanner(System.in);
		int userInput;
		try {
			userInput = scan.nextInt();
			System.out.print("You chose " + array[userInput]);
		}
		catch (Exception ex){
			//handle exception types from scanner or index out of bounds
		}
		finally {
			scan.close();	
		}
		
//		String array[] = { "Apple", "Banana", "Pear", "Mango", "Orange" };
//		Scanner scan = new Scanner(System.in);
//		int userInput = scan.nextInt();
//		System.out.print("You chose " + array[userInput]);
//		scan.close();
	}
	
	/*
	 * Method 5 
	 * Purpose: It calculates total tax based on the salary passed in.
	 * Task 1: Re-write the logic without dual conditions (avoid &&)
	 * Task 2: Avoid else clause
	 * Task 3: Get rid of any redundant variable
	 */
	public static double getTotalTax(double salary) {
		
		if(salary > 2600) {
			return salary * .30;
		} else if (salary > 1500) {
			return salary * .20;			
		} else if (salary > 500) {
			return salary * .15;			
		}
		return salary * .10;
//		double taxRate;
//		double totalTax;
//
//		if (salary < 500) {
//			taxRate = .10;
//		} else if ((salary >= 500) && (salary < 1500)) {
//			taxRate = .15;
//		} else if ((salary >= 1500) && (salary < 2600)) {
//			taxRate = .20;
//		} else {
//			taxRate = .30;
//		}
//
//		totalTax = salary * taxRate;
//		return totalTax;
	}

	/*
	 * Method 6 
	 * Purpose: It returns if the number is even or odd
	 * Task: Rewrite these 4 lines with only 1 line using Java "ternary operator"
	 */
	public static String evenOrOdd(int number) {
		return (number % 2 == 0) ? "even" : "odd";
//		if (number % 2 == 0) {
//			return "Even";
//		} else {
//			return "odd";
//		}
	}

	/*
	 * Method 7 
	 * Purpose: It prints "vowel" if the passed character is 'a','e','i','o','u'
	 * Task: Re-write the switch but avoid duplicate code
	 */
	public static void handle_case(char ch) {
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println("This is vowel");
			break;
		default:
			System.out.println("This not a vowel");
		}
	}

	/* 
	 * Method 8
	 * Purpose: It generates a random number between 1 and 5 and then
	 * It gets an input from the user. The loop breaks only when it matches the 
	 * random number with the user input.
	 * Task1: Use "for" loop instead of while
	 * Task2: Avoid else clause
	 * Task3: Avoid unnecessary variable(s)
	*/
	public static void matchRandom() {
		try (Scanner scan = new Scanner(System.in)) {
			Random rand = new Random();

			for( ; (scan.nextInt() != rand.nextInt(5)); ) {
				System.out.println("No match, You are stuck.");
			}
			System.out.println("Match, You Won!!!!");
			scan.close();
		}
		
//		Scanner scan = new Scanner(System.in);
//		Random rand = new Random();
//
//		while(true) {
//			int randomNumber = rand.nextInt(5); // get a random number between 1 and 5
//			int userInput = scan.nextInt();
//			if (userInput == randomNumber) {
//				System.out.println("Match, You Won!!!!");
//				break;
//			} else {
//				System.out.println("No match, You are stuck.");
//			}
//		}
//		scan.close();
	}
	
	/*
	 * Method 9 
	 * Purpose: It adds only the even numbers from 1 to "number" and returns the sum
	 * Task: Re-write the method using recursion, avoid loop
	 */
	public static int sumOfEvenNumbers(int number) {
		if(number < 2) {
			return 0;
		}
//		if(number % 2 ==1) {
//			return  sumOfEvenNumbers(--number);
//		}
		return ((number % 2 ==1) ? 0 : number) + sumOfEvenNumbers(--number);
		
//		int sum = 0;
//		for (int i = 1; i <= number; ++i) {
//			if (i % 2 == 0) {
//				sum += i;
//			} 
//		}
//		return sum;
	}
	
	/* 
	 * Method 10
	 * Task: Implement the method based on these conditions:
	 * If the number is divisible by 3 it returns Fizz
	 * If the number is divisible by 5 it returns Buzz
	 * If the number is divisible both by 3 and 5 it returns FizzBuzz
	 * Otherwise it returns the number itself.
	*/
	public static String fizz_buzz(Integer number) {
		return((number % 5 == 0)) ? ((number % 3 == 0) ? "FizzBuzz" : "Buzz") : ((number%3 == 0) ? "Fizz" : number.toString());
	}

	public static void main(String[] args) {
		// Test all the 10 methods here and make sure they are
		// returning right value or output.
		
		System.out.println(isTrue(true));
		System.out.println(isTrue(false));
		//2
		noElse();
		//3
		int[] arr = {1, 2, 4, 6, 7, 9, 10};
		System.out.println(isFound(arr, 2)); //true
		System.out.println(isFound(arr, 4)); //true
		System.out.println(isFound(arr, 10)); //true
		System.out.println(isFound(arr, 11)); //false
		System.out.println(isFound(arr, 5)); //false
		
		//4 (0-4)
//		handleException();
		//5
		System.out.println(getTotalTax(10000));
		System.out.println(getTotalTax(4000));
		System.out.println(getTotalTax(1600));
		System.out.println(getTotalTax(1000));
		System.out.println(getTotalTax(800));
		System.out.println(getTotalTax(200));
		System.out.println(getTotalTax(10));
		
		//6
		System.out.println(evenOrOdd(3)); //odd
		System.out.println(evenOrOdd(4)); //even
		System.out.println(evenOrOdd(256)); //even
		System.out.println(evenOrOdd(333)); //odd
		
		//7
		handle_case('a');
		handle_case('e');
		handle_case('i');
		handle_case('o'); //vowel
		handle_case('c');// not vowels
		handle_case('x');
		handle_case('z');
		//8
//		matchRandom();
		//9
		System.out.println(sumOfEvenNumbers(2)); //2
		System.out.println(sumOfEvenNumbers(4)); //6
		System.out.println(sumOfEvenNumbers(5)); // 6
		System.out.println(sumOfEvenNumbers(7)); //12
		System.out.println(sumOfEvenNumbers(8));  //20
		System.out.println(sumOfEvenNumbers(14)); //56?
		//10
		System.out.println(fizz_buzz(3)); //fizz
		System.out.println(fizz_buzz(5)); //buzz
		System.out.println(fizz_buzz(15)); //fizzbuzz
		System.out.println(fizz_buzz(16)); //16
		System.out.println(fizz_buzz(17)); //17
		System.out.println(fizz_buzz(297)); //fizz
		System.out.println(fizz_buzz(295)); //buzz
		System.out.println(fizz_buzz(300)); //fizzbuzz
		
	}

}
