
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class IdServer implements Serializable {

    private static final long serialVersionUID = 1L;
    protected static IdServer server;
    protected static ArrayList<String> idList = new ArrayList<String>();

    protected IdServer() {
	super();
    }

    public static IdServer instance() {
	if (server == null) {
	    return server = new IdServer();
	} else {
	    return server;
	}
    }

    public static boolean matchID(String id) {
	for (java.util.Iterator<String> iterator = idList.iterator(); iterator.hasNext();) {
	    String ID = (String) iterator.next();
	    System.out.println(ID);
	    if (ID.matches(id)) {
		return true;
	    }
	}
	return false;
    }

    public String getId() {
	Random rnd = new Random();
	char[] digits = new char[6];
	String output = "";

	do {
	    digits[0] = (char) (rnd.nextInt(9) + '1');
	    for (int i = 1; i < digits.length; i++) {
		digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    output = new String(digits);
	} while (idList.contains(output));
	idList.add(output);
	return new String(digits);
    }

    public static void retrieve(ObjectInputStream input) {
	try {
	    server = (IdServer) input.readObject();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	} catch (Exception cnfe) {
	    cnfe.printStackTrace();
	}
    }

    public static boolean remove(String id) {
	return idList.remove(id);
    }

    public static boolean contains(String id) {
	return idList.contains(id);
    }

    public static boolean matches(String id) {
	return idList.toString().contains(id);
    }

    @SuppressWarnings("unchecked")
    public static void readObject(java.io.ObjectInputStream input) {
	try {
	    idList = (ArrayList<String>) input.readObject();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public static void writeObject(java.io.ObjectOutputStream output) throws IOException {
	try {
	    output.writeObject(idList);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
