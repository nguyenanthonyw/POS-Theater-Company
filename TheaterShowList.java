
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class TheaterShowList implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static ArrayList<TheaterShow> showArray = new ArrayList<TheaterShow>();
    private static TheaterShowList theaterShowList;

    private TheaterShowList() {
    }

    /*
     * Singleton practices
     */
    public static TheaterShowList instance() {
	if (theaterShowList == null) {
	    return (theaterShowList = new TheaterShowList());
	} else {
	    return theaterShowList;
	}
    }

    /*
     * Takes in ID, showName, start and end date ID must be real to add
     */
    public static boolean addShow(String id, String name, Date startDate, Date endDate, double price) {
	// Asks the user for the name date and a valid
	// Need to close on exit
	boolean output = false;
	if (PeopleList.searchPeople(id)) {
	    System.out.println("Client found");
	    if (canAdd(startDate, endDate)) {
		showArray.add(new TheaterShow(id, name, startDate, endDate, price));
		output = true;
	    }
	}
	return output;
    }

    public static TheaterShow searchShow(String ID) {
	for (Iterator<TheaterShow> iterator = showArray.iterator(); iterator.hasNext();) {
	    TheaterShow theaterShow = (TheaterShow) iterator.next();
	    if (theaterShow.getName().contentEquals(ID)) {
		return theaterShow;
	    }
	}
	return null; // customer not found
    }

    /*
     * Prints out each show in the arrayList
     */
    public static void listShows() {
	// Print each Show
	for (TheaterShow i : showArray) {
	    System.out.println(i);
	}
    }

    /*
     * Checks to see if the dates conflict with other existing show dates
     */
    private static boolean canAdd(Date startDate, Date endDate) {
	boolean output = true;
	for (TheaterShow i : showArray) {
	    if (i.getStart().compareTo(endDate) < 0 && i.getEnd().compareTo(startDate) > 0) {
		output = false;
		System.out.println("Conflicting Show times");
	    }
	}
	return output;
    }

    /*
     * Checks to see that the Client can be removed by making sure that the client
     * has no upcoming dates
     */
    public static boolean canRemove(String clientId) {
	// Tests to see that the client can be removed and does not have any shows that
	// are open at this time.
	boolean output = true;
	try {
	    Date currentDate = new Date();
	    for (TheaterShow i : showArray) {
		if (ClientIdServer.contains(i.getcId()) && i.getEnd().compareTo(currentDate) > 0) {
		    output = false;
		}
	    }
	} catch (NullPointerException e) {
	    output = false;
	}
	return output;
    }

    public static void writeObject(java.io.ObjectOutputStream output) {
	try {
	    output.writeObject(showArray);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    // read object from file work around
    @SuppressWarnings("unchecked")
    public static void readObject(java.io.ObjectInputStream input) {
	try {
	    showArray = (ArrayList<TheaterShow>) input.readObject();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
