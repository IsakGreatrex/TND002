public class Transaction {
    private int theAccount;
    private double theAmount;
    private String tofrom;

    public Transaction(String arg1, int arg2, double arg3){
        theAccount = arg2;
        theAmount = arg3;
        tofrom = arg1;
    }
    public String toString(){
        String result = new String();
        result = String.format("Money transfer: ");
        return result;
    }


}
