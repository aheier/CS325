
public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sayHello(5);
		System.out.println(fact(25));
		
		for( int i=0; i<10; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	public static void sayHello(int count) {
		if(count <= 1) { //breaking condition
			return;
		}
		sayHello(--count);
		System.out.println("Hello " + count);
	}

	public static int fact(int n) {
		return (n <= 1) ? 1 : n * fact(--n);
	}
	
	public static int fib(int n) {
		if (n <= 1)
			return n;
    return fib(n - 1) + fib(n - 2);
	}
}
