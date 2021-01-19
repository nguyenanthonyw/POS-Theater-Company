
import java.io.Serializable;
import java.text.DecimalFormat;

public class Client extends People implements Serializable {
    private double balance;
    private static final long serialVersionUID = 1L;
    private static DecimalFormat df2 = new DecimalFormat("#0.00"); // format of double

    // Constructor for the client object
    public Client(String name, String address, String phoneNumber) {
	super(name, address, phoneNumber);
	balance = 0;
	// this is to make sure that there are not duplicates
	this.id = "cl" + (ClientIdServer.instance()).getId();
	System.out.println("New Client: " + toString());
    }

    /**
     * get balance
     * 
     * @return balance
     */
    public double getBalance() {
	return balance;
    }

    /**
     * set balance
     * 
     * @param balance how much money to set as balance
     */
    public void setBalance(double balance) {
	this.balance = balance;
    }

    /**
     * add to balance
     * 
     * @param addBalance how much money to add to balance
     */
    public void addBalance(double addBalance) {
	balance += addBalance;
    }

    /**
     * subtract from balance
     * 
     * @param subBalance how much money to reduce
     */
    public void subBalance(double subBalance) {
	this.balance += subBalance;
    }

    public Client getClient() {
	return this;
    }

    /**
     * String version of client
     */
    public String toString() {
	return super.toString() + "Balance:$" + df2.format(balance);
    }

}
