import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Customer class, it holds the information that is used to create, and get information about a customer.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Customer {

	private String name;
	private String username;
	private String email;
	private String password;
	private String phoneNumber;
	private String birthday;
	private String creditCardNumber;
	
	// we need this line below if we are going to create a history of customer reservations.
	//private ArrayList<Reservation> prev_reservations;

	/**
	 * 
	 * @param name
	 *            is to be a valid String that holds the name of the customer.
	 * @param username
	 *            is to be a valid String that holds the username of the customer.
	 * @param email
	 *            is to be a valid String that holds the email of the customer.
	 * @param password
	 *            is to be a valid String that holds the password of the customer.
	 * @param phoneNumber
	 *            is to be a valid String that holds the phone number of the customer.
	 * @param birthday
	 *            is to be a valid String that holds the birthday of the customer.
	 * @param creditCardNumber
	 *            is to be a valid String that holds the credit card number of the customer.
	 */
	public Customer(String name, String username, String email, String password, String phoneNumber, String birthday, String creditCardNumber) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.creditCardNumber = creditCardNumber;

		// ArrayList<int> prev_reservations = new ArrayList<>();
	}

	/**
	 * Will get the name of this customer.
	 * 
	 * @return a String that holds the name of the customer.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Will get the username of this customer.
	 * 
	 * @return a String that holds the username of the customer.
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * Will get the email of this customer.
	 * 
	 * @return a String that holds the email of the customer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Will get the password of this customer.
	 * 
	 * @return a String that holds the password of the customer.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Will get the phone number of this customer.
	 * 
	 * @return a String that holds the phone number of the customer.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Will get the birthday of this customer.
	 * 
	 * @return a String that holds the birthday of the customer.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Will get the credit card number of this customer.
	 * 
	 * @return a String that holds the credit card number of the customer.
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * This method calls the reservation's getQuote method.
	 * 
	 * @param newReservation
	 *            is to be the reservation that the quote is to be gotten from.
	 */
	public void requestQuote(Reservation newReservation) {
		newReservation.getQuote();
	}

	/**
	 * This method will create a new customers.
	 * 
	 * @param customers
	 *            is to be the array list of customer that contains every customer.
	 * 
	 * @return the customer that was just created.
	 */
	public static Customer createNewCustomer(ArrayList<Customer> customers) {
		System.out.println("We will now create you an account.");

		Scanner in = new Scanner(System.in);

		String name = null;
		String username = null;
		String password = null;

		// create new user.
		System.out.println("Enter your name: ");
		name = in.nextLine();

		System.out.println("Enter a username: ");
		username = in.nextLine();

		// checking to see if the username is already taken.
		for (Customer customer : customers) {
			if (customer.getUserName().equals(username)) {
				while (customer.getUserName().equals(username)) {
					System.out.print("That username is taken, please enter a different username: ");
					username = in.nextLine();
				}
			}
		}

		// getting the users information.
		System.out.println("Please enter a password: ");
		password = in.nextLine();

		System.out.println("Please enter your email: ");
		String email = in.nextLine();

		System.out.println("Please enter your phone number: ");
		String phone = in.nextLine();

		System.out.println("Please enter your birthday: ");
		String birth = in.nextLine();

		System.out.println("Please enter your credit card number: ");
		String credit = in.nextLine();

		Customer customer = new Customer(name, username, email, password, phone, birth, credit);

		return customer;
	}
	
	/**
	 * This is a method that will determines if the customer's entered username was found in the list of customers.
	 * 
	 * @param customers
	 *            is to be the array list of customers that contains every
	 *            customer.
	 * @param username
	 *            is the be the username of that is to be found.
	 * 
	 * @return a boolean that tells whether the username was found.
	 */
	public static boolean findUsername(ArrayList<Customer> customers, String username) {
		boolean found = false;

		for (Customer customer : customers) {
			if (customer.getUserName().equals(username)) {
				found = true;
			}
		}

		return found;
	}

	/**
	 * This method will update this customer profile inforamtion.
	 * 
	 * @return a Customer that is the newly upated customer.
	 */
	public Customer updateProfile() {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your new name");
		String new_name = input.nextLine();

		System.out.println("Please enter your new username");
		String new_username = input.nextLine();

		System.out.println("Please enter your new email");
		String new_email = input.nextLine();

		System.out.println("Please enter your new password");
		String new_password = input.nextLine();

		System.out.println("Please enter your new phone number");
		String new_phone = input.nextLine();

		System.out.println("Please enter your new birthday");
		String new_birthday = input.nextLine();

		System.out.println("Please enter your new credit card number");
		String new_creditCardNumber = input.nextLine();

		Customer customer = new Customer(new_name, new_username, new_email, new_password, new_phone, new_birthday, new_creditCardNumber);

		return customer;
	}

	/**
	 * This method will call the make reservation method and will print the new confirmation number.
	 * 
	 * @param cars
	 *            is to be an array list of cars that contains every car.
	 * @param reservations
	 *            is to be an array list of reservation that contains every reservation.
	 * 
	 * @return the array list of reservtion that contains every reservation, including the newly made one.
	 */
	public ArrayList<Reservation> makeReservation(ArrayList<Car> cars, ArrayList<Reservation> reservations) {
		// somehow make this point to reservation make reservation.
		Reservation resv = Reservation.makeReservation(cars, reservations);

		// The below line will not be included until I figure out how to make
		// the previous reservation array.
		// prev_reservations.add(resv.getConfirmationNumber);
		reservations.add(resv);

		System.out.println("Your reservation has been made.");
		System.out.println("Your confirmation number is: " + resv.getConfirmationNumber());

		return reservations;
	}
	
	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
	public String getAttributes() {
		String info = getName() + ", " + getUserName() + ", " + getEmail() + ", " + getPassword() + ", " + getPhoneNumber() + ", " + getBirthday() + ", " + getCreditCardNumber();
		
		return info;
	}
}
