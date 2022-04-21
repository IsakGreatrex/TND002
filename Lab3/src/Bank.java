import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer>customerList;
    private ArrayList<Account>accountList;
    private int accountNumber;

    public Bank(){
        customerList = new ArrayList<Customer>();
        accountList = new ArrayList<Account>();
        accountNumber = 1000;
    }

    public String addCustomer(String arg1, double arg2){
        Customer dummy = findCustomer(arg1);
        String result = new String();
        if(dummy==null){
            customerList.add(new Customer());
            accountList.add(new Current(customerList.get(accountList.size()-1), accountNumber++, arg2));
            Current dummyCurrent = (Current)accountList.get(accountList.size()-1);
            accountList.add(new Savings(accountNumber++,dummyCurrent));
            customerList.get(customerList.size()-1).addAccounts(dummyCurrent,(Savings)accountList.get(accountList.size()-1));
            result = "Customer added";
        }
        else {
            result = "Customer already exist";
        }
        return result;
    }

    public Customer findCustomer(String arg){
        Customer result = null;
        for (int i = 0; i<customerList.size();i++){
            if(arg.trim().equals(customerList.get(i).getName())){
                result = customerList.get(i);
            }
        }
        return result;
    }

    public void transfer(String arg1, double arg2){
        Customer customer = findCustomer(arg1);
        if(customer != null){
            customer.getCurrentAccount().transfer(arg2);
        }
    }

    public void transfer(String arg1, String arg2, double arg3){
        Customer customerFrom = findCustomer(arg1);
        Customer customerTo = findCustomer(arg1);
        customerFrom.getCurrentAccount().transfer(customerTo.getCurrentAccount(),arg3);
        customerTo.getCurrentAccount().deposit(customerFrom.getCurrentAccount(), arg3);
    }

    public String checkAccount(int arg){
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getNumber() == arg){
                return accountList.get(i).toString();
            }
        }
        return "Not a current account";
    }

    public void annualChange(){
        for (int i = 0; i < accountList.size(); i++){
            accountList.get(i).annualChange();
        }
    }

    public String toString(){
        String ret = "Bank statistics\n ====================\n";
        final String formater = "%10s %12d\n";
        ret += String.format(formater, "Customers: ", customerList.size());
        double money = 0;
        for (int i = 0;i< accountList.size(); i++){
            money += accountList.get(i).getBalance();
        }
        ret += String.format("%10s %10f", "Money",money);
        return ret;
    }


}
