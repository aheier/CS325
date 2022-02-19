
class CheckingAccount extends BankAccount {
    private double interestRate;
    private int lateFee = 30;

    CheckingAccount(String first, String last, int ID, double balance) {
        this.balance = balance;
        firstName = first;
        lastName = last;
        accountID = ID;
        interestRate = 2.5;
    }

    void processWithdrawal(double withdrawalAmount) {
        if (balance > withdrawalAmount) {
            balance -= withdrawalAmount;
            return;
        }
        balance -= (lateFee + withdrawalAmount);
    } 
    
    void displayAccount() {
        accountSummary();
        System.out.println("Current interest rate: " + interestRate);
        System.out.println("------------------------------");
    }

} // end 
