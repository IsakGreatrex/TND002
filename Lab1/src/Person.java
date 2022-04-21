
public class Person {

    private int age;

    private String firstName, secondName;

    private Building address;

    private static boolean theFormat = true;

    public final static boolean WITHAGE = true;
    public final static boolean NOAGE = false;

    public Person(String infirstName, String insecondName, int inage){
        firstName = infirstName;
        secondName = insecondName;
        age = inage;
    }

    public void setAddress(Building inBuilding) {address = inBuilding;}

    public Building getAddress() {return address;}

    public boolean isPerson(String infirstName, String insecondName, int inage) {
        if (firstName == infirstName && secondName == insecondName && age == inage) {
            return true;
        } else {
            return false;
        }
    }

    public static void changeFormat(boolean inage) {
        if (inage) {
            theFormat = WITHAGE;
        } else {
            theFormat = NOAGE;
        }
    }

    public String toString() {

        if (theFormat == NOAGE) {
            return String.format("%7s %10s", firstName, secondName);

        } else { //theFormat == WITHAGE
            return String.format("%7s %10s, age: %3d", firstName, secondName, age);
        }
    }
}
