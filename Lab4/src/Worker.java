import java.util.*;
public class Worker extends Employee implements Comparable<Employee>{

    Worker(String arg1, String arg2, int arg3, double arg4){
        super(arg1, arg2, arg3, arg4);
    }

    public double computeTaxes(){
        return 0.25*salary;
    }

}
