import java.util.ArrayList;

public class Current extends Account {
    private Customer theCustomer;
    private ArrayList<Transaction>theTransactions;

    public Current(Customer arg1, int arg2, double arg3){
        super(arg2);
        theCustomer = arg1;
        balance = arg3;
        theTransactions = new ArrayList<Transaction>();
    }
    public Customer getCustomer(){
        return theCustomer;
    }
    public void transfer(double arg) {
        if(arg > 0) {
            if(arg != 0 && balance >= arg) {
                balance -= arg;
                theTransactions.add(new Transaction("To", otherAccount.accountNumber, arg));
            } else {
                double temp = arg - (balance - arg);
                balance -= temp;
                theTransactions.add(new Transaction("To", otherAccount.accountNumber, arg));
            }
        }
        else if (arg < 0) {
            double transfer = -arg;
            if (balance >= transfer) {
                otherAccount.balance -= transfer;
                balance -= transfer;
                theTransactions.add(new Transaction("From", otherAccount.accountNumber, arg));
            } else if (balance < transfer) {
                double temp = arg - (balance-arg);
                otherAccount.balance -= temp;
                balance -= temp;
                theTransactions.add(new Transaction("From", otherAccount.accountNumber, arg));
            }
        }
    }

    public void deposit(Current arg1, double arg2){
        if (arg2 != 0.0){
            balance += arg2;
            theTransactions.add(new Transaction("From", arg1.accountNumber,arg2));
        }
    }

    public void transfer(Current arg1, double arg2) {
        if(arg2 > 0 && arg2 <= balance) {
            deposit(arg1, arg2);
            balance -= arg2;
        }
        else if(arg2 > 0) {
            double temp = arg2 - (balance-arg2);
            balance -= temp;
            theTransactions.add(new Transaction("To", otherAccount.accountNumber, temp));
        }
    }

    public String toString(){
        String f = "%20s %15s";
        String ret = String.format(f,"Customer", theCustomer.getName());
        ret+= String.format(f, "Account number", accountNumber);
        ret += String.format(f, "Savings", otherAccount.getBalance());
        for (int i = 0; i < theTransactions.size(); i++){
            ret += theTransactions.get(i) + toString() + "\n";
        }

        return ret;
    }
}
