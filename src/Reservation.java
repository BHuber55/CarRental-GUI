import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * This is the reservation class. It holds the information that is needed to create and retrieve a reservation.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Reservation extends formatter{
	
	private String username;
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
	public Reservation(String username1, String car_id, String pickUpDate1, String dropOffDate1, int confirmationNumber1, boolean insurance1, double quote1) {
		username = username1;
		car = car_id;
		confirmationNumber = confirmationNumber1;
		insurance = insurance1;

		pickUpDate = stringToDay(pickUpDate1);
		dropOffDate = stringToDay(dropOffDate1);

		quote = quote1;
	}
	
	public String getUserName() {
		return username;
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
	
	public static double makeQuote(ArrayList<Car> cars, String carID, String pickup, String dropoff) {
		double price = 0;
		double total = 0;
		
		Day pick = Reservation.stringToDay(pickup);
		Day drop = Reservation.stringToDay(dropoff);
		
		int days = pick.daysFrom(drop);
		
		if(days < 0) {
			days = days * -1;
		}
		
		for(Car C : cars) {
			if(C.getID().equals(carID)) {
				price = C.getPrice();
				break;
			}
		}
		
		total = price * days;
		
		return total;
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
	public static void makeReservation(ArrayList<Car> cars, ArrayList<Reservation> reservations, String username1) {

		JFrame frame = new JFrame("Make a Reservation");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		
		// So at the moment I'm just going to have a display pop up and the user copy the carID from the pop up over to carId field cause that'll just be easiest for now. <<<<<<<<<<<<<<<<<<<<<<<<
		Car.advancedSearch(cars);

		// change this to wherever your workspace is
		ImageIcon img = new ImageIcon("./Car.jpg");
		frame.setIconImage(img.getImage());

		final int TEXT_FIELD_SIZE = 20;
		JLabel carLabel = new JLabel("Car: ");
		final JTextField carField = new JTextField(TEXT_FIELD_SIZE);
		JLabel pickUpDateLabel = new JLabel("Pick Up Date: ");
		final JTextField pickUpDateField = new JTextField(TEXT_FIELD_SIZE);
		JLabel dropOffDateLabel = new JLabel("Drop Off Date: ");
		final JTextField dropOffDateField = new JTextField(TEXT_FIELD_SIZE);
		JLabel insuranceLabel = new JLabel("Insurance: ");
		final JTextField insuranceField = new JTextField(TEXT_FIELD_SIZE);
		JButton okButton = new JButton("Submit");

		// all the formatting that one could ever need.
		frame.setBackground(Color.BLACK);

		format(carLabel);
		format(carField);
		format(pickUpDateLabel);
		format(pickUpDateField);
		format(dropOffDateLabel);
		format(dropOffDateField);
		format(insuranceLabel);
		format(insuranceField);
		format(okButton);

		// change this to wherever your workspace is.
		addHeader(frame);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		panel.setBackground(Color.BLACK);

		panel.add(carLabel);
		panel.add(carField);
		panel.add(pickUpDateLabel);
		panel.add(pickUpDateField);
		panel.add(dropOffDateLabel);
		panel.add(dropOffDateField);
		panel.add(insuranceLabel);
		panel.add(insuranceField);
		panel.add(new JLabel(""));
		panel.add(okButton);

		frame.add(panel);

		frame.pack();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car = carField.getText();
				String pickupDate = pickUpDateField.getText();
				String dropOffDate = dropOffDateField.getText();
				String insurance = insuranceField.getText();
				
				int number = Reservation.makeConfirmationNumber(reservations);
				double quote = Reservation.makeQuote(cars, car, pickupDate, dropOffDate);		// need to make a makeQuote method.
				
				Reservation resv = new Reservation(username1, car, pickupDate, dropOffDate, number, Boolean.parseBoolean(insurance), quote);
				reservations.add(resv);

				JOptionPane pane = new JOptionPane(); 
				format(pane);

				JOptionPane.showMessageDialog(null,
						" Car: " + car + "\n Pick Up Date: " + pickupDate
						+ "\n Drop Off Date: " + dropOffDate
						+ "\n Insurance: " + insurance,
						"Information Saved",
						JOptionPane.INFORMATION_MESSAGE, img);
			}
		});


		// we remove the original one, then add the one newly updated one.

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

		List<String> list = Arrays.asList(d.split("/"));

		int month = Integer.parseInt(list.get(0));
		int day = Integer.parseInt(list.get(1));
		int year = Integer.parseInt(list.get(2));

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
	public void makeReservationReport(ArrayList<Car> cars) {
		JOptionPane pane = new JOptionPane(); 
		format(pane);

		JOptionPane.showMessageDialog(null,
				" Username: " + username
				+ " Car: "+ car
				+ "\n Pick Up Date: " + pickUpDate
				+ "\n Drop Off Date: " + dropOffDate
				+ "\n Insurance: " + insurance,
				"Information Saved",
	  			JOptionPane.INFORMATION_MESSAGE);	
		}
	
	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
	public String getAttributes() {
		String info = (getUserName() + ", " + getCar() + ", " + getPickUpDate().toString() + ", " + getDropOffDate().toString() + ", " + getConfirmationNumber() + ", " + getInsurance() + ", " + String.valueOf(getQuote()));
		
		return info;
	}
		}



