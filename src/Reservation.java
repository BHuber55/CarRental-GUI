import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the reservation class. It holds the information that is needed to create and retrieve a reservation.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Reservation {
	
	private String car;
	private Day pickUpDate;
	private Day dropOffDate;
	private int confirmationNumber;
	private boolean insurance;
	private double quote;

	/**
	 * Constructs a Reservation
	 * 
	 * @param car_id
	 *            Must be a valid, and unique, string that is suppose to be the ID of the car the customer wants.
	 * @param pickUpDate1
	 *            Must be a valid string that holds the date the reservation is to begin. (formatted 11/11/2000).
	 * @param dropOffDate1
	 *            Must be a valid string that holds the date the reservation is to end. (formatted 11/11/2000).
	 * @param confirmationNumber1
	 *            Must be a valid and unique integer that holds the customers confirmation number of the reservation.
	 * @param insurance1
	 *            Must be a valid boolean that holds whether or not the user would like to include car insurance in the reservation.
	 * @param quote1
	 *            Must be a valid string that holds the price of the reservation.
	 */
	public Reservation(String car_id, String pickUpDate1, String dropOffDate1, int confirmationNumber1, boolean insurance1, String quote1) {
		this.car = car_id;
		this.confirmationNumber = confirmationNumber1;
		this.insurance = insurance1;

		pickUpDate = Reservation.stringToDay(pickUpDate1);
		dropOffDate = Reservation.stringToDay(dropOffDate1);

		quote = Double.parseDouble(quote1);
	}

	/**
	 * Will return the car ID of this reservation
	 * 
	 * @return a String that holds the car ID of this reservation.
	 */
	public String getCar() {
		return car;
	}

	/**
	 * Will return the day that the reservation is to begin.
	 *
	 * @return a Day that the reservation is suppose to begin.
	 */
	public Day getPickUpDate() {
		return pickUpDate;
	}

	/**
	 * Will return the day that the reservation is to end.
	 *
	 * @return a Day that the reservation is suppose to end.
	 */
	public Day getDropOffDate() {
		return dropOffDate;
	}

	/**
	 * Will return the confirmation number of this reservation.
	 * 
	 * @return an Integer that holds the confirmation number of this
	 *         reservation.
	 */
	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	/**
	 * Will return whether or not the user wants insurance in the reservation.
	 * 
	 * @return a Boolean that determines whether or not the user wants
	 *         insurance.
	 */
	public boolean getInsurance() {
		return insurance;
	}

	/**
	 * Will return the price (quote) of the reservation.
	 * 
	 * @return a double that holds the price of this reservation.
	 */
	public double getQuote() {
		return quote;
	}

	/**
	 * This will create a confirmation number for the reservation.
	 * 
	 * @param reservations
	 *            is to be the arrayList of reservation containing every reservation.
	 * 
	 * @return the randomly generated yet unique confirmation number.
	 */
	public static int makeConfirmationNumber(ArrayList<Reservation> reservations) {
		Random rand = new Random();
		int num = rand.nextInt(10000);

		for (int i = 0; i < reservations.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (reservations.get(i).getConfirmationNumber() == num) {
					num = rand.nextInt(10000);
				}
				else {
					if (reservations.get(j).getConfirmationNumber() == num) {
						num = rand.nextInt(10000);
					}
				}
			}
		}

		return num;
	}

	/**
	 * This method creates a reservation, by asking the user for input.
	 * 
	 * @param cars
	 *            is to be the array list of cars containing every car.
	 * @param reservations
	 *            is to be the array list of reservation containing every reservation.
	 * 
	 * @return a new reservation containing the information that the user inputed.
	 */
	public static Reservation makeReservation(ArrayList<Car> cars, ArrayList<Reservation> reservations) {
		Scanner in = new Scanner(System.in);

		boolean insur = false;
		double price = 0;

		Car.displayVehicles(cars);

		System.out.println("Please choose a car from the list above");
		int car = in.nextInt();
		String car_id = cars.get(car - 1).getID();

		System.out.println("Please enter a pick up date seperated by slashes. For Example: 10/31/1989");
		String pdate = in.nextLine();
		pdate = in.nextLine();

		System.out.println("Plese enter a drop off date seperated by slashes. For Example: 10/31/1989");
		String ddate = in.nextLine();

		System.out.println("Do you want insurance? (1 for yes, 2 for no)");
		int ins = in.nextInt();

		while (ins < 1 || ins > 2) {
			System.out.println("Plese choose one of the availible options.");
			ins = in.nextInt();
		}

		if (ins == 1) {
			insur = true;
		}
		else {
			insur = false;
		}

		Day d1 = Reservation.stringToDay(pdate);
		Day d2 = Reservation.stringToDay(ddate);

		int days = d2.daysFrom(d1);

		for (Car car1 : cars) {
			if (car1.getID().equals(car_id)) {
				price = car1.getPrice();
			}
		}

		double quotes = days * price;

		Reservation resv = new Reservation(car_id, pdate, ddate, Reservation.makeConfirmationNumber(reservations), insur, String.valueOf(quotes));
		
		return resv;
	}

	/**
	 * This method will update one aspect of a reservation.
	 * 
	 * @param cars
	 *            is to be the array list of cars containing every car.
	 * @param reservations
	 *            is to be the array list of reservation containing every reservation.
	 * @param number
	 *            is a valid integer that holds the confirmation number of the reservation that is to be edited.
	 * 
	 * @return a list of reservation that holds every reservation, including the
	 *         updated reservation.
	 */
	public ArrayList<Reservation> updateProfile(ArrayList<Car> cars, ArrayList<Reservation> reservations, int number) {
		Reservation res = null;
		for (Reservation reservation : reservations) {
			if (reservation.getConfirmationNumber() == number) {
				res = reservation;
				break;
			}
		}

		reservations.remove(res);
		res = makeReservation(cars, reservations);
		reservations.add(res);

		return reservations;
	}

	// not used atm.. but maybe later.
	/**
	 * This is a method that checks the credit card of the user.
	 * 
	 * @param aCustomer
	 *            is to be the customer that is to be checked.
	 * @param creditCard
	 *            is to be the credit card number.
	 * 
	 * @return a boolean that determines whether or not the user is correct.
	 */
	public boolean checkCreditCard(Customer aCustomer, String creditCard) {
		boolean check = false;
		String credit = null;

		Scanner in = new Scanner(System.in);

		System.out.println("aCustomer.getCreditCardNumber()" + aCustomer.getCreditCardNumber());
		if (aCustomer.getCreditCardNumber().equals(creditCard)) {
			check = true;
		}
		else {
			System.out.println("Sorry that is not the correct credit card number");
			while (!check) {
				System.out.println("Please enter it again.");
				credit = in.nextLine();

				if (aCustomer.getCreditCardNumber().equals(credit)) {
					check = true;
				}
			}
		}

		return check;
	}

	// not used atm.. but maybe later.
	/**
	 * At the moment this is pointless, however it will just print a line that states it is sending an email to the user.
	 * 
	 * @param aCustomer
	 *            is to be the customer that is to recieve the email.
	 */
	public void sendEmailConfirmation(Customer aCustomer) {
		System.out.println("Sending an email to " + aCustomer.getEmail());
	}
	
	/**
	 * This method will convert a String type to a Day type. Formatted 11/11/2000
	 * 
	 * @param d
	 *            is to a valid string that holds a date that is to be converted. Formatted 11/11/2000
	 * 
	 * @return a Day type that holds the information provided from the string.
	 */
	public static Day stringToDay(String d) {

		List<String> list1 = Arrays.asList(d.split("/"));

		int month = Integer.parseInt(list1.get(0));
		int day = Integer.parseInt(list1.get(1));
		int year = Integer.parseInt(list1.get(2));

		Day date = new Day(year, month, day);

		return date;
	}

	/**
	 * This method will print out a report displaying all the information of the reservation.
	 * 
	 * @param aReservation
	 *            is the be the reservation that the report is to be made for.
	 * @param cars
	 *            is to be the array list of cars that contains every car.
	 */
	public static void makeReservationReport(Reservation aReservation, ArrayList<Car> cars) {
		System.out.println();
		System.out.print("Your Car: ");

		for (Car car : cars) {
			if (aReservation.getCar().equals(car.getID())) {
				System.out.println(car.getMake() + " " + car.getModel());
			}
		}

		System.out.println("The pickup date is " + aReservation.getPickUpDate().toString());
		System.out.println("The drop off date is " + aReservation.getDropOffDate().toString());
		System.out.println("The confirmation number is " + aReservation.getConfirmationNumber());
		System.out.println("Do you have insurance? " + aReservation.getInsurance());
		System.out.println("The quote is " + aReservation.getQuote());
	}

	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
	public String getAttributes() {
		String info = (getCar() + ", " + getPickUpDate().toString() + ", " + getDropOffDate().toString() + ", " + getConfirmationNumber() + ", " + getInsurance() + ", " + String.valueOf(getQuote()));
		
		return info;
	}
}
