public abstract class Employee implements Comparable<Employee> {
    protected String firstName;
    protected String secondName;
    protected int employeeNumber;
    protected double salary;
    protected static int sortCriterion = 0;
    public static final int BYNAME = 0;
    public static final int BYSALARY = 1;
    public static final int BYTAXES = 2;

    public Employee(String arg1, String arg2, int arg3, double arg4){
        firstName = arg1;
        secondName = arg2;
        employeeNumber = arg3;
        salary = arg4;
    }

    public int getNumber(){
        return employeeNumber;
    }

    public String getName(){
        return secondName;
    }

    public double getSalary(){
        return salary;
    }

    public static void changeCriterion(int arg){
        sortCriterion = arg;
    }

    public abstract double computeTaxes();

    public String toString(){
        return String.format("%8s %10s %8d", firstName, secondName, employeeNumber);
    }

    public static int getCriterion(){
        return sortCriterion;
    }

    public int compareTo(Employee arg){
        switch (sortCriterion){
            case BYNAME:
                return secondName.compareTo(arg.getName());
            case BYTAXES:
                if (computeTaxes()>arg.computeTaxes()){
                    return -1;
                }
                else if(computeTaxes()==arg.computeTaxes()){
                    return 0;
                }
                else{
                    return 1;
                }
            case BYSALARY:
            default:
                if (salary > arg.getSalary()){
                    return -1;
                }
                else if(salary==arg.getSalary()){
                    return 0;
                }
                else{
                    return 1;
                }
        }
    }

}
