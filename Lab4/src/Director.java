import java.util.*;
public class Director extends Employee implements Comparable<Employee> {
    ArrayList<Employee>theWorkers;

    Director(String arg1, String arg2, int arg3, double arg4){
    super(arg1, arg2, arg3, arg4);
    theWorkers = new ArrayList<Employee>();
    }

    public void addEmployee(Worker arg){
        theWorkers.add(arg);
    }

    public double computeBonus(){
        double tot = 0;
        for (int i = 0; i < theWorkers.size(); i++){
            tot += theWorkers.get(i).getSalary();
        }
        tot = tot * 0.1;
        return tot;
    }

    public double computeTaxes(){
        return 0.25*(salary + computeBonus());
    }
}
