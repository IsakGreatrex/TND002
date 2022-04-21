import java.util.*;
public class Phonebook {
    private ArrayList<Person>listOfNumbers;

    public Phonebook (){
        listOfNumbers = new ArrayList<Person>();
    }

    public String load (String arg){

    }

    public ArrayList<Person> search (String arg){
        ArrayList<Person> foundPerson = new ArrayList<Person>();
        String[] findPerson = arg.split(" ",2);
        for (int i = 0; i < listOfNumbers.size(); i++){
            Person p = listOfNumbers.get(i);
            if (listOfNumbers.get(i).getSurname().equals(findPerson[1]) ||
                    String.valueOf(p.getPhoneNumber()).equals(findPerson[2]));
            foundPerson.add(p);
        }
        return foundPerson;
    }

    public String deletePerson(String arg1, int arg2){
       String s = new String();
        for (int i = 0; i < listOfNumbers.size(); i++){
            if (listOfNumbers.get(i).getFullName().equals(arg1) && listOfNumbers.get(i).getPhoneNumber()==arg2){
                listOfNumbers.remove(arg1);
                listOfNumbers.remove(arg2);
                 s = "Person deleted";
            }
            else{
                 s = "The person/number does not exist";
            }
        }
        return s;
    }

    public boolean addPerson(String arg1, String arg2){
        for (int i = 0; i < listOfNumbers.size(); i++){
            if (){

            }
        }
    }

    public String save (String arg){

    }
}
