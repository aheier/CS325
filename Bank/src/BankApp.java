
public class BankApp {
	public static void main(String[] args) {
		CheckingAccount testAccount = new CheckingAccount("Bob", "Max", 1001, 2000.00);
		System.out.println("Begin test");
		testBench(testAccount);
		System.out.println("End test");

	}

	public static void testBench(CheckingAccount testAccount) {
		// test normal withdrawal
		testAccount.displayAccount();
		testAccount.processWithdrawal(1000);
		assert (testAccount.getBalance() == 1000.00) : "Assertion balance == 1000 failed";

		// test bank overdraw
		testAccount.processWithdrawal(2000);
		assert (testAccount.getBalance() == -1030.00) : "Assertion balance == -1030 failed";
		testAccount.displayAccount();

		// test deposit
		testAccount.deposit(2000);
		assert (testAccount.getBalance() == 970.00) : "Assertion balance == 870 failed";
		testAccount.displayAccount();
	} // end test
}
