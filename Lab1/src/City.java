public class City {

    private AllBuildings infrastructure;
    private Inhabitants people;

    public City() {
        infrastructure = new AllBuildings();
        people = new Inhabitants();
    }

    public void addPerson(String infirstName, String insecondName, int inage, String instreet, int innumber) {
        Person tempP = people.addPerson(infirstName, insecondName, inage);


        if(tempP == null) {
            System.out.println("Person already exists");
        } else {
            Building tempB = infrastructure.getBuilding(instreet, innumber);
            tempP.setAddress(tempB);
            tempB.addPerson(tempP);
            System.out.println("Person added");
        }
    }


    public void movePerson(String infirstName, String insecondName, int inage, String instreet, int innumber) {

        Person tempP = people.searchPerson(infirstName, insecondName, inage);
        Building tempB = infrastructure.getBuilding(instreet, innumber);
        Building oldB = tempP.getAddress();


        if(tempP == null) {
            System.out.println("Person does not exist");
        } else {
            System.out.println("Found person...");
            oldB.removePerson(tempP);
            tempB.addPerson(tempP);
            infrastructure.cleanUp();
        }




    }


    public String listBuildings() {
        return String.valueOf(infrastructure);
    }


    public String listPeople() {
        return String.valueOf(people);
    }


    public String toString() {

        return "City statistics\n Number of buildings: " + infrastructure.getNumberOfBuildings() + "\n Number of people: "+ people.getNumberOfPeople();
    }


}
