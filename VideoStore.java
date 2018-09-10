
/**
 * Program to model a video store
 * Video store would have a list of movies 
 * Video store would have customers and they can perform certain transactions such as checkout and check in
 */
import java.util.Scanner;

public class VideoStore<T extends Comparable<T>> {

	SLL<String, Video> videoInstore;
	SLL<Integer, Customer> customer;
	Customer c = new Customer();

	/**
	 * Function to get videos in store
	 */
	public void getVideoInstore() {
		printInStoreVideos();
	}

	/**
	 * Function to add videos to the store
	 * @param name is the name of the video
	 * @param newVideoInstore is the video object
	 */
	public void setVideoInstore(String name, Video newVideoInstore) {

		videoInstore.insert(name, newVideoInstore);
	}

	/**
	 * Function to add a customer
	 * @param id is the customer id
	 * @param newVcustomer is the Customer object
	 */
	public void setCustomer(Integer id, Customer newVcustomer) {

		customer.insert(id, newVcustomer);

	}
	/**
	 * Function to delete a customer
	 * @param id is the id of the customer to delete
	 */
	public void deleteCustomer(Integer id) {

		customer.remove(id);
	}

	/**
	 * Function to check if a video is in store
	 * @param name
	 * @return
	 */

	public boolean check(String name) {

		return videoInstore.contains(name);

	}

	/**
	 * Function to delete a video
	 * @param name is the name of the movie to delete
	 */
	public void deleteVideo(String name) {
		if (videoInstore.contains(name) == true) {
			videoInstore.remove(name);
		} else {

			System.out.println("Video not available in store for delete");
		}
	}
	/**
	 * Function to checkout a video
	 * @param name is the name of the movie to check out
	 */
	public void checkOut(String name) {
		tempHoldCheckOut(name, videoInstore.getData(name));
		//c.rentVideo.insert(name, videoInstore.getData(name));
		videoInstore.remove(name);

	}
	/**
	 * Function to hold check out videos
	 * @param name is name of the video to temporary hold
	 * @param v is the video object
	 */
	public void tempHoldCheckOut(String name, Video v) {
		c.setRentVideos(name, v);
	}

	/**
	 * Function to check in a video
	 * @param name is the name of tyhe movies to be checked in
	 * @param v is the video object
	 */

	public void checkIn(String name, Video v) {

		videoInstore.insert(name, v);
		if (c.getRentVideos().contains(name) == true) {
		c.getRentVideos().remove(name);

		}

	}

	/**
	 * Function to get checked in videos
	 */
	public void getCheckedInVideos() {
		videoInstore.print();

	}
/**
 * Function to print out all customers
 */
	public void printAllCustomers() {
		if (!customer.isEmpty()) {
			System.out.println("Printing all customers");
			customer.print();
		} else {

			System.out.println("No customer");
		}

	}

	/**
	 * Function to print all videos
	 */

	public void printAllVideos() {
		
		if (!videoInstore.isEmpty() || !c.getRentVideos().isEmpty()) {
			System.out.println("Printing all videos");
			videoInstore.print();
			c.getRentVideos().print();
		} else {

			System.out.println("No videos available");
		}
	}
	
	/**
	 * Function to print all the videos in the store
	 */

	public void printInStoreVideos() {
		if (!videoInstore.isEmpty()) {
			System.out.println("Printing in stores videos");
			videoInstore.print();
		} else {

			System.out.println("No video in store");
		}
	}

	/**
	 * Function to print out all checked out videsos
	 */

	public void printAllRentVideos() {
		
		if(!c.getRentVideos().isEmpty()) {
			
			System.out.println("Printing all rented vidoes");

			c.getRentVideos().print();
		} else {

			System.out.println("No video has been rented");
		}

	}
	/**
	 * Function to print all customers rented videos
	 */
	public void printVideosRentByACustomer() {
		
		if(!c.getRentVideos().isEmpty()) {
			
				System.out.println("Printing all rented vidoes");
			
				c.getRentVideos().print();
			} else {

				System.out.println("No video has been rented");
			}

		}

	public static void main(String[] args) {
	
		
		if(args.length < 3 && args[0].equalsIgnoreCase("SLL")) {
			
		
				testFunction(args[0]);
				
		}else if(args.length > 3 && args[0].equalsIgnoreCase("SLL")) {
			
		
				testRunningTime(args[0], args[1], args[2], args[3]);
				
		}
				
	}
		public static void testFunction(String s) {
	
			VideoStore<Video> storeVideos = new VideoStore<Video>();
			storeVideos.videoInstore = new SLL<String, Video>();
			storeVideos.c.rentVideo = new SLL<String, Video>();
			VideoStore<Customer> storeCustomers = new VideoStore<Customer>();
			storeCustomers.customer = new SLL<Integer, Customer>();
		int exit = 0;	

		do {
			System.out.println("\t\t\t*****" + "Welcome to Terry's Video Store" + "*****");
			System.out.println("\t\t\t  ****" + "The store for all movies" + "****");
			System.out.println("\t\t\t\t***" + "Open 24/7 " + "***");
			System.out.println("\t\t**" + "2025 SW Primrose Bentonville, Arkansas, 72712. " + "**");
			System.out.println("\t\t\t*" + "Contact us 24/7 on 479 306-0159" + "*");
			System.out.println(
					"Main Menu\n1.To add a video\n2.To delete a video\n3.To add a customer\n4.To delete a customer\n5.To check if a particular video is in store"
							+ "\n6.To check out a video\n7.To check in a video\n8.To print all customers\n9.To print all videos\n10.To print in store videos\n11.To print all rent videos\n"
							+ "12.To print the videos rent by customers\n13.To exit");

			Scanner scan = new Scanner(System.in);
			System.out.println("\nPlease use keys 1 - 13 to navigate");
			int enter = scan.nextInt();
			exit = enter;
			switch (enter) {

			case 1:
				System.out.println("Enter the name of the movie");
				String name = scan.next();
				System.out.println("Enter Id for the movie");
				int id = scan.nextInt();
				System.out.println("Enter the year the movie was released");
				int year = scan.nextInt();
				System.out.println("Enter the name of the movie director");
				String director = scan.next();
				storeVideos.setVideoInstore(name, new Video(name, id, year, director));
				System.out.println(name + " was successfully added to the video store");
				storeVideos.videoInstore.getData(name);
				break;
			case 2:
				System.out.println("Enter the name of the movie you want to delete");
				String dname = scan.next();
				storeVideos.deleteVideo(dname);

				break;
			case 3:
				System.out.println("Name of customer");
				String cname = scan.next();
				System.out.println("Enter ID for the customer");
				int cid = scan.nextInt();
				storeCustomers.setCustomer(cid, new Customer(cname, cid));
				System.out.println(cname + " Successfully added to store customers");
				break;
			case 4:
				System.out.println("Enter the ID of the customer you want to delete");
				int delcustomer = scan.nextInt();
				if (storeCustomers.customer.contains(delcustomer)) {
					System.out.println("Successfully deleted\n" + storeCustomers.customer.getData(delcustomer));
					storeCustomers.deleteCustomer(delcustomer);

				} else {

					System.out.println("Customer with that ID does not exist");
				}
				break;
			case 5:
				System.out.println("Enter your id");
				int idd = scan.nextInt();
				if (storeCustomers.customer.contains(idd)) {
					System.out.println("Enter the  name of the movie to check if it's available in the store");
					String checkname = scan.next();
					if (storeVideos.check(checkname) == true) {
						System.out.println("AVailability : Yes");
						System.out.println(storeVideos.videoInstore.getData(checkname));
					} else {
						System.out.println("Video not available in store. Check back later");
					}

				} else {

					System.out.println("ID does not exist");
				}
				break;
			case 6:
				System.out.println("Enter your id");
				int idd2 = scan.nextInt();
				if (storeCustomers.customer.contains(idd2)) {
					System.out.println("Enter the  name of the movie to check if it's available in the store");
					String checkname2 = scan.next();
					if (storeVideos.check(checkname2) == true) {
						System.out.println("AVailability : Yes");
						System.out.println(storeVideos.videoInstore.getData(checkname2));
						storeVideos.checkOut(checkname2);
						System.out.println("Checkout successful");
					} else {
						System.out.println("Video not available in store. Check back later");
					}

				} else {

					System.out.println("ID does not exist");
				}
				break;
			case 7:

				System.out.println("Enter your id");
				int idd3 = scan.nextInt();
				if (storeCustomers.customer.contains(idd3)) {
					System.out.println("Enter the name of the movie to check in");
					String chinname = scan.next();
					if (storeVideos.check(chinname) == false && storeVideos.c.rentVideo.contains(chinname) == true) {
						storeVideos.checkIn(chinname, storeVideos.c.rentVideo.getData(chinname));
						System.out.println(storeVideos.videoInstore.getData(chinname));
						System.out.println("Checkin successful");
					} else if (storeVideos.c.rentVideo.contains(chinname) != true
							&& storeVideos.check(chinname) == false) {

						System.out.println("Video name is invalid. Try check in again");

					} else if (storeVideos.check(chinname) == true) {

						System.out.println("Video available in store. Check in another video");
					}

				} else {

					System.out.println("ID does not exist");
				}
				break;
			case 8:
				storeCustomers.printAllCustomers();
				break;
			case 9:
				storeVideos.printAllVideos();
				break;
			case 10:
				storeVideos.printInStoreVideos();
				break;
			case 11:
				storeVideos.printAllRentVideos();
				break;
			case 12:

				storeVideos.printVideosRentByACustomer();
			}

		} while (exit < 13);
		System.out.println("Thank you for your time. Good Bye!");
		
		}
		
		public static void testRunningTime(String s, String s1, String s2, String s3) {
			
			VideoStore<Video> storeVideos = new VideoStore<Video>();
			storeVideos.videoInstore = new SLL<String, Video>();
			storeVideos.c.rentVideo = new SLL<String, Video>();
			VideoStore<Customer> storeCustomers = new VideoStore<Customer>();
			storeCustomers.customer = new SLL<Integer, Customer>();
			
				int v = Integer.valueOf(s1);
				int c = Integer.valueOf(s2);
				int t = Integer.valueOf(s3);

				// Generating x number of videos
				
				long t1 = System.currentTimeMillis();
				for (int i = 1; i <= v; i++) {

					String n = String.valueOf(i);

					storeVideos.setVideoInstore(n, new Video(n, i, i, n));
				}

				for (int i = 1; i <= c; i++) {

					String n = String.valueOf(i);

					storeCustomers.setCustomer(i, new Customer(n, i));
				}

				for (int i = 1; i <= t; i++) {

					String n = String.valueOf(i);

					storeVideos.checkOut(n);
				}
				long t2 = System.currentTimeMillis();
				long t3 = ( t2 - t1);
				
				System.out.println("Total running time for SLL is : " + t3 + "milliseconds");
			}
		
	
	
	}

