import java.util.ArrayList;
public class Building {

    private ArrayList<Person> residents = new ArrayList<Person>();

    private int number;

    private String streetName;

    public Building (String instreetName, int innumber) {
        streetName = instreetName;
        number = innumber;
    }

    public boolean addPerson(Person inperson) {
        //Would like a try statement here instead
        boolean person_added = false;
        int i = residents.size();
        residents.add(inperson);

        if(residents.size() > i)
        {person_added = true;}

        return person_added;
    }


    public void removePerson(Person inPerson) {

        for (int i=0; i < residents.size(); i++) {
            if(residents.get(i) == inPerson) {
                residents.remove(i);
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return streetName;
    }

    public int residents() {
        return residents.size();
    }

    public String toString() {
        //might want to make this formatted
        return (streetName + " " + number + ", number of residents: " + residents());
    }
}
