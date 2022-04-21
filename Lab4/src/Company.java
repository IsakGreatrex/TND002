import java.util.*;
public class Company {
    ArrayList<Employee>theWorkersAndDirectors;
    public Company(){
        theWorkersAndDirectors = new ArrayList<Employee>();
    }

    public void addEmployee(Director arg){
        theWorkersAndDirectors.add(arg);
    }

    public void addEmployee(Worker arg1, Director arg2){
        theWorkersAndDirectors.add(arg1);
        arg2.addEmployee(arg1);
    }

    public String toString() {
        Collections.sort(theWorkersAndDirectors);

        String ret = "List of Employees\n------------\n";
        int c = Employee.getCriterion();
        ret += String.format("%-12s %-12s %-12s", "First name", "Surname", "Number");
        switch(c) {
            case 0:
                ret += "\n";
                for(int i = 0; i < theWorkersAndDirectors.size(); i++) {
                    ret += theWorkersAndDirectors.get(i).toString() + "\n";
                }
                break;
            case 2:
                ret += "Taxes\n";
                for(int i = 0; i < theWorkersAndDirectors.size(); i++) {
                    ret += theWorkersAndDirectors.get(i).toString() + String.format("%20f", theWorkersAndDirectors.get(i).computeTaxes()) + "\n";
                }
                break;
            case 1:
            default:
                ret += "Salary\n";
                for(int i = 0; i < theWorkersAndDirectors.size(); i ++) {
                    ret += theWorkersAndDirectors.get(i).toString() + String.format("%20f", theWorkersAndDirectors.get(i).getSalary()) + "\n";
                }
                break;
        }
        return ret;
    }
}
