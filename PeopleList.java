
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class PeopleList implements Serializable {

    private static final long serialVersionUID = 1L;
    private static PeopleList peopleList;
    private static ArrayList<People> peopleArray = new ArrayList<People>();

    public static PeopleList instance() {
	if (peopleList != null) {
	    peopleList = new PeopleList();
	}
	return peopleList;
    }

    public static People search(String clientId) {
	if (ClientIdServer.contains(clientId)) {
	    for (People i : peopleArray) {
		if (i.getId().equals(clientId)) {
		    return i;
		}
	    }
	}
	return null;
    }

    public static boolean searchPeople(String clientId) {
	for (People i : peopleArray) {
	    if (i.getId().equals(clientId)) {
		return true;
	    }
	}
	return false;
    }

    public static boolean insert(People people) {
	peopleArray.add(people);
	return true;
    }

    public static boolean removeFromList(String clientId) {
	if (TheaterShowList.canRemove(clientId)) {
	    peopleArray.remove(search(clientId));
	    ClientIdServer.remove(clientId);
	    return true;
	} else {
	    return false;
	}
    }

    public static void listPeople() {
	if (peopleArray.isEmpty()) {
	    System.out.println("Empty List");
	} else {
	    for (People i : peopleArray) {
		System.out.println(i.toString());
	    }
	}
    }

    public static void listClient() {
	String output = "";
	if (peopleArray.isEmpty()) {
	    System.out.println("Empty List");
	} else {

	    for (Iterator<People> iterator = peopleArray.iterator(); iterator.hasNext();) {
		People people = (People) iterator.next();

		if (people.getId().contains("c") && !people.getId().contains("cl")) {
		    output += people.toString();
		}

	    }
	}
	System.out.println(output);

    }

    public static void writeObject(java.io.ObjectOutputStream output) {
	try {
	    output.writeObject(peopleArray);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @SuppressWarnings("unchecked")
    public static void readObject(java.io.ObjectInputStream input) {
	try {
	    peopleArray = (ArrayList<People>) input.readObject();
	    // input.close();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
