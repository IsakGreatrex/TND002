import java.util.ArrayList;

public class Inhabitants {

    private ArrayList<Person> thePeople;

    public Inhabitants() {
        thePeople = new ArrayList<Person>();
    }

    public Person addPerson(String infirstName, String insecondName, int inage) {

        Person p = searchPerson(infirstName, insecondName, inage);

        if(p != null) {
            return null;
        } else {
            p = new Person(infirstName, insecondName, inage);
            thePeople.add(p);
        }
        return p;
    }

    public Person searchPerson(String infirstName, String insecondName, int inage) {

        for (int i=0; i < thePeople.size(); i++) {
            if(thePeople.get(i).isPerson(infirstName, insecondName, inage)) {
                return thePeople.get(i);
            }
        }
        return null;
    }


    public String getNumberOfPeople() {
        return String.format("%s", thePeople.size());
    }

    public String toString() {

        String s = new String("List of inhabitants:\n");

        for (int i=0; i < thePeople.size(); i++) {
            s = s + String.valueOf(thePeople.get(i)) + "\n";
        }
        return s;
    }

}
