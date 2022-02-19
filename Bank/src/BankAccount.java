class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    BankAccount() { // default constructor
        balance = 0;
        firstName = "";
        lastName = "";
        accountID = 0;

    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccountID(int id) {
        accountID = id;
    }

    public int getAccountID() {
        return accountID;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdrawal(double withdrawalAmount) {
        balance -= withdrawalAmount;

    }
   
    public double getBalance() {
        return balance;
    }

    public void accountSummary() {
        System.out.println("Account details:");
        System.out.println("Account: " + accountID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.printf("Account balance: $%.2f\n", balance);

    } 
}