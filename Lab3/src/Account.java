public class Account {
    protected int accountNumber;
    protected String accountType;
    protected double balance;
    protected Account otherAccount;
    public static double FEE = 10.0, INTEREST = 0.02;

    public Account(int arg) {
        accountNumber = arg;
        accountType = "Current";
    }

    public Account(int arg1, Current arg2) {
        accountNumber = arg1;
        otherAccount = arg2;
        accountType = "Savings";
    }

    public String getAccountType() {
        return accountType;
    }

    public int getNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void annualChange() {

        if (accountType == "Current") {
            balance = balance - FEE;
            if (accountType == "savings") {
                balance = balance + INTEREST;
            }

        }
    }
}
