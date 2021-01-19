
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the superclass of all the other ticket objects. This method implemtns
 * some functions such as getters of the parameters and a toString method
 * 
 * @author Anthony Nguyen
 *
 */

public abstract class Ticket implements Serializable, Matchable<String> {

    private static final long serialVersionUID = 1L;
    private String customerID; // ID of customer
    private String ticketID; // ticket ID
    private String showName; // name of show
    protected Date date; // date of the show

    /**
     * Consturtor of ticket object
     * 
     * @param date       show date
     * @param customerID Id of customer
     * @param showName   show name
     */
    public Ticket(Date date, String customerID, String showName) {
	this.customerID = customerID;
	this.date = date;
	this.showName = showName;
    }

    /**
     * Get price of ticket
     * 
     * @return price of ticket
     */
    public double getPrice() {
	return getPrice();
    }

    /**
     * Get customer ID on the ticket
     * 
     * @return customer ID
     */
    public String getCustomerID() {
	return customerID;
    }

    /**
     * get name of show on ticket
     * 
     * @return name of show
     */
    public String getShowName() {
	return showName;
    }

    /**
     * get date of show
     * 
     * @return date of show
     */
    public Date getShowDate() {
	return date;
    }

    /**
     * 
     * check if equal with id
     * 
     * @param id the id of ticket
     * @return ticket id
     */
    public boolean matches(String id) {
	return (this.ticketID.equals(id));
    }

    /**
     * return string version of ticket
     * 
     * @return string version of ticket object
     */
    @Override
    public String toString() {
	SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yy");
	String stringDate = DateFor.format(date);
	return "Ticket Show: " + showName + "\nDate of Show: " + stringDate + "\nCustomer ID: " + customerID;
    }

}
