
/**
 * Program to model a customer database
 * This program would also allow a customer to rent a movie from a video store
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable, Comparable<Customer> {

	private String name;
	private int id;
	DLL<String, Video> rentVideo;
/**
 * Default constructor
 */
	public Customer() {

		this("null", 0);
	}

	/**
	 * Overloaded constructor
	 * @param name is the name of the customer
	 * @param id is the id of the customer
	 */
	public Customer(String name, int id) {

		this.name = name;
		this.id = id;
	}

	/**
	 * Function to get the name of the customer
	 * @return the name 
	 */
	public String getName() {

		return name;
	}

	/**
	 * Function to get the id of the customer
	 * @return the id
	 */
	public int getId() {

		return id;
	}
	
	/**
	 * Function to allow a customer to rent a video
	 * @param name is the name of the video
	 * @param v is the video object
	 */
	public void setRentVideos(String name, Video v) {
		
		rentVideo.insert(name, v);
	}

	/**
	 * Function to get the videos rented by customers
	 * @return all the videos rented by customers
	 */
	public DLL<String, Video> getRentVideos() {

		return rentVideo;
	}
	
	/**
	 * String representation of the customers information
	 */
	public String toString() {

		return "Name : " + name + "\nId : " + id;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
