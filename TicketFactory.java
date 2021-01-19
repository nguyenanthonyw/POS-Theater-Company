import java.util.Date;

public class TicketFactory {

    private static TicketFactory factory;

    /**
     * Private for singleton
     */
    private TicketFactory() {
    }

    /**
     * Returns the only instance of the class.
     * 
     * @return the instance
     */
    public static TicketFactory instance() {
	if (factory == null) {
	    factory = new TicketFactory();
	}
	return factory;
    }

    public Ticket createTicket(int type, Date date, String customerID, String showName, double price) {
	switch (type) {
	case Theater.GENERALTICKET:
	    return new GeneralTicket(date, customerID, showName, price);
	case Theater.ADVANCETICKET:
	    return new AdvanceTicket(date, customerID, showName, price);
	case Theater.STUDENTTICKET:
	    return new StudentTicket(date, customerID, showName, price);
	default:
	    return null;
	}
    }

}
