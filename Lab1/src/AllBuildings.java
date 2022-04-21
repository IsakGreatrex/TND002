import java.util.ArrayList;
public class AllBuildings {

    private ArrayList<Building> theBuildings;

    public AllBuildings() {
        theBuildings = new ArrayList<Building>();
    }

    public Building getBuilding (String instreetName, int innumber) {

        Building result = null;
        boolean add_new_building = true;

        for (int i=0; i < theBuildings.size(); i++) {

            if((theBuildings.get(i).getStreet() == instreetName) && (theBuildings.get(i).getNumber() == innumber)) {
                result = theBuildings.get(i);
                System.out.println("Building exists already");
                add_new_building = false;
                break;
            }
        }

        if(add_new_building) {


            Building unlisted = new Building (instreetName, innumber);
            theBuildings.add(unlisted);
            System.out.println("Building added");
            result = unlisted;
        }

        if (theBuildings.size() == 0) {
            Building unlisted = new Building (instreetName, innumber);
            theBuildings.add(unlisted);
            System.out.println("Building added");
            result = unlisted;
        }

        return result;
    }

    public String getNumberOfBuildings() {
        return theBuildings.size() +"";
    }

    public void cleanUp() {
        for (int i=0; i < theBuildings.size(); i++) {
            if(theBuildings.get(i).residents() == 0) {
                theBuildings.remove(i);
            }
        }
    }

    public String toString() {

        String s = new String("List of buildings:\n");

        for(int i=0; i < theBuildings.size(); i++) {
            s = s + String.valueOf(theBuildings.get(i) + "\n");
        }

        return s;
    }

}
