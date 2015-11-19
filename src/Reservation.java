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
public class Reservation {
	
	private String username;																						// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DO THAT.
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
	public Reservation(String car_id, String pickUpDate1, String dropOffDate1, int confirmationNumber1, boolean insurance1, double quote1) {
		username = "";
		
		
		
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
	public static void makeReservation(ArrayList<Car> cars, ArrayList<Reservation> reservations) {

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

		carLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		carLabel.setForeground(Color.DARK_GRAY);
		carField.setBackground(Color.DARK_GRAY);
		carField.setForeground(Color.WHITE);
		pickUpDateLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		pickUpDateLabel.setForeground(Color.GRAY);
		pickUpDateField.setBackground(Color.DARK_GRAY);
		pickUpDateField.setForeground(Color.WHITE);
		dropOffDateLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		dropOffDateLabel.setForeground(Color.DARK_GRAY);
		dropOffDateField.setBackground(Color.DARK_GRAY);
		dropOffDateField.setForeground(Color.WHITE);
		insuranceLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		insuranceLabel.setForeground(Color.GRAY);
		insuranceField.setBackground(Color.DARK_GRAY);
		insuranceField.setForeground(Color.WHITE);
		okButton.setBackground(Color.RED);

		// change this to wherever your workspace is.
		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		frame.add(headerLabel, BorderLayout.NORTH);

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
				double quote = ;		// need to make a makeQuote method.
				
				Reservation resv = new Reservation(car, pickupDate, dropOffDate, number, Boolean.parseBoolean(insurance), quote);

				UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.DARK_GRAY);
				UI.put("Panel.background", Color.RED);
				UI.put("OptionPane.messageFont", new FontUIResource(new Font("High Tower Text", Font.PLAIN, 13)));

				JOptionPane.showMessageDialog(null,
						" Car: " + car + "\n Pick Up Date: " + pickupDate
						+ "\n Drop Off Date: " + dropOffDate
						+ "\n Insurance: " + insurance,
						"Information Saved",
						JOptionPane.INFORMATION_MESSAGE, img);
			}
		});

		headerLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				// this is where it picks up on the menu button.
				if (x > 670 && x < 800 && y > 226 && y < 250) {
					// Originally had the x and y printed out to make sure i had
					// the dimensions right
					// System.out.println(x+ " " + y);

					// just change this line of code to match the frame you want
					// closed.
					// For the love of all that is holy, DO NOT use the same
					// name for the main frame vs everything else!
					frame.dispose();
				}
			}

			// Eclipse was freaking out when I didn't have these methods listed,
			// for whatever reason.
			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		// we remove the original one, then add the one newly updated one.

	}

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
		
		final int TEXT_FIELD_SIZE = 15;

		JFrame frame = new JFrame("Check Credit Card Info");
		frame.setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		// change this to wherever your workspace is
		ImageIcon img = new ImageIcon("./Car.jpg");
		frame.setIconImage(img.getImage());

		JLabel creditLabel = new JLabel("Please enter your Credit Card number: ");
		final JTextField creditField = new JTextField(TEXT_FIELD_SIZE);
		JButton okButton = new JButton("Submit");

		// all the formatting that one could ever need.
		creditLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		creditLabel.setForeground(Color.DARK_GRAY);
		creditField.setBackground(Color.DARK_GRAY);
		creditField.setForeground(Color.WHITE);
		okButton.setBackground(Color.RED);

		// change this to wherever your workspace is.
		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		frame.add(headerLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		panel.setBackground(Color.BLACK);

		panel.add(creditLabel);
		panel.add(creditField);
		panel.add(new JLabel(""));
		panel.add(okButton);
		frame.add(panel);

		frame.pack();
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String creditCard = creditField.getText();

				if (aCustomer.getCreditCardNumber().equals(creditCard)) {
					check = true;
					// cant do a check here because the boolean will disappear after the actionPerformed runs.. so idk what I'm going to do yet.
				}
			}
		});
		
		headerLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				// this is where it picks up on the menu button.
				if (x > 670 && x < 800 && y > 226 && y < 250) {
					// Originally had the x and y printed out to make sure i had the dimensions right
					// System.out.println(x+ " " + y);

					// just change this line of code to match the frame you want closed.
					// For the love of all that is holy, DO NOT use the same name for the main frame vs everything else!
					frame.dispose();
				}
			}

			// Eclipse was freaking out when I didn't have these methods listed, for whatever reason.
			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

		});

		return check;
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
		JFrame frame = new JFrame(); 
		
		frame.setTitle("Reservation Report");
		
		frame.setLayout(new BorderLayout());

		
		frame.setVisible(true);
		
		//change this to wherever your workspace is
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
	
		//all the formatting that one could ever need.
		frame.setBackground(Color.BLACK);
         
		carLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		carLabel.setForeground(Color.DARK_GRAY);
		carField.setBackground(Color.DARK_GRAY);
		carField.setForeground(Color.WHITE);
		pickUpDateLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		pickUpDateLabel.setForeground(Color.GRAY);
		pickUpDateField.setBackground(Color.DARK_GRAY);
		pickUpDateField.setForeground(Color.WHITE);
		dropOffDateLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		dropOffDateLabel.setForeground(Color.DARK_GRAY);
		dropOffDateField.setBackground(Color.DARK_GRAY);
		dropOffDateField.setForeground(Color.WHITE);
		insuranceLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		insuranceLabel.setForeground(Color.GRAY);
		insuranceField.setBackground(Color.DARK_GRAY);
		insuranceField.setForeground(Color.WHITE);
		okButton.setBackground(Color.RED);
         
        //change this to wherever your workspace is. 
        JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
        frame.add(headerLabel, BorderLayout.NORTH);
         
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(8,2));
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
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				String car = carField.getText(); 
				String pickupDate = pickUpDateField.getText(); 
				String dropOffDate = dropOffDateField.getText(); 
				String insurance = insuranceField.getText();
				
				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Color.DARK_GRAY);
				UI.put("Panel.background", Color.RED);
				UI.put("OptionPane.messageFont", new FontUIResource(new Font("High Tower Text", Font.PLAIN, 13))); 

				JOptionPane.showMessageDialog(null," Car: "+ car
						+ "\n Pick Up Date: " + pickupDate
						+ "\n Drop Off Date: " + dropOffDate
						+ "\n Insurance: " + insurance,
						"Information Saved",
			  			JOptionPane.INFORMATION_MESSAGE, img);
			} 	
		});
		
		
		
		headerLabel.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				
				//this is where it picks up on the menu button. 
				if(x > 670 && x < 800 && y > 226 && y < 250) {
					//Originally had the x and y printed out to make sure i had the dimensions right
					//System.out.println(x+ " " + y);
					
					//just change this line of code to match the frame you want closed. 
					//For the love of all that is holy, DO NOT use the same name for the main frame vs everything else!
					frame.dispose();
				}
		    }
		    
	    	//Eclipse was freaking out when I didn't have these methods listed, for whatever reason. 
			@Override	public void mouseEntered(MouseEvent e) {
				
			}
	
			@Override	public void mouseExited(MouseEvent e) {
				
			}
	
			@Override	public void mousePressed(MouseEvent e) {
				
			}
	
			@Override	public void mouseReleased(MouseEvent e) {
				
			}
		});
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


