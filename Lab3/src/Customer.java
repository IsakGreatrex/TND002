public class Customer {
    private String name;
    private Current currentAccount;
    private Savings savingsAccount;

    public String Customer(String arg) {
        name = arg;
        return name;
    }

    public String getName() {
        return name;
    }

    public Current getCurrentAccount() {
        return currentAccount;
    }

    public void addAccounts(Current arg1, Savings arg2) {
        currentAccount = arg1;
        savingsAccount = arg2;
    }

    public String toString() {
        final String formater = "%15s %16s \n";
        return String.format(formater, "Name of customer", name)
                + (currentAccount != null ? String.format(formater, "Current acoount", currentAccount) : "")
                + (savingsAccount != null ? String.format(formater, "Savings account", savingsAccount):"");
    }
}
