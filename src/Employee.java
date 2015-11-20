
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * This is the Employee class, it holds the information that is used to create, and get information about a employee.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Employee extends Customer {

	private int salary;
	private String hire;

	ArrayList<Employee> employees = new ArrayList<Employee>();

	/**
	 * This is the constructor of Employee. It will construct a manager with the given attributes.
	 * 
     * @param name1 is the name of the manager
     * @param username1 is the username of the manager
     * @param email1 is the email of the manager
     * @param password1 is the password of the manager
     * @param phone1 is the phone of the manager
     * @param birthday1 is the birthday of the manager
     * @param credit1 is the credit card number of the manager
     * @param hire1 is the hire date of the manager
     * @param salary1 is the salary of the manager
	 */
	public Employee(String name1, String username1, String email1, String password1, String phone1, String birthday1, String credit1, String hire1, int salary1) {
		
		super(name1, username1, email1, password1, phone1, birthday1, credit1);

		salary = salary1;
		hire = hire1;
	}
	
	/**
	 * This method will get the salary of this employee
	 * 
	 * @return a int containing the salary of the employee
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * This method will get the hire date of this employee
	 * 
	 * @return a string containing the hire date of the employee
	 */
	public String getHireDate() {
		return hire;
	}

	/**
	 * This method will allow the employee to update one aspect of the car.
	 * 
	 * @param cars
	 * 			is the array list of cars that contains every car.
	 * 
	 */
	public void updateVehicle(ArrayList<Car> cars) {

		JFrame frame = new JFrame();
		frame.setTitle("Update Vehicle");
		frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;
		JLabel IDNumber = new JLabel("ID number");
		final JTextField idField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carModel = new JLabel("Car model");
		final JTextField carModelField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carYear = new JLabel("Car Year");
		final JTextField carYearField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMake = new JLabel("Car Make");
		final JTextField carMakeField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carColor = new JLabel("Car Color");
		final JTextField carColorField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carPrice = new JLabel("Car Price");
		final JTextField carPriceField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMilage = new JLabel("Car Milage");
		final JTextField carMilageField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMPG = new JLabel("Car MPG");
		final JTextField carMPGField = new JTextField(TEXT_FIELD_SIZE);

		JButton submitButton = new JButton("Submit");

		frame.setLayout(new GridLayout(10, 2));

		frame.add(IDNumber);
		frame.add(idField);
		frame.add(carModel);
		frame.add(carModelField);
		frame.add(carYear);
		frame.add(carYearField);
		frame.add(carMake);
		frame.add(carMakeField);
		frame.add(carColor);
		frame.add(carColorField);
		frame.add(carPrice);
		frame.add(carPriceField);
		frame.add(carMilage);
		frame.add(carMilageField);
		frame.add(carMPG);
		frame.add(carMPGField);
		frame.add(submitButton);

		frame.pack();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car OG = null;
				
				String carID = idField.getText();
				
				for(Car c : cars) {
					if(c.getID().equals(carID)) {
						OG = c;
						break;
					}
				}
				
				String model = carModelField.getText();
				String year = carYearField.getText();
				String make = carMakeField.getText();
				String color = carColorField.getText();
				String price = carPriceField.getText();
				String mileage = carMilageField.getText();
				String MPG = carMPGField.getText();
				
				if (model.equals(null)) {
					model = OG.getModel();
				}
				if(year.equals(null)) {
					year = String.valueOf(OG.getYear());
				}
				if(make.equals(null)) {
					make = OG.getMake();
				}
				if(color.equals(null)) {
					color = OG.getColor();
				}
				if(price.equals(null)) {
					price = String.valueOf(OG.getPrice());
				}
				if(mileage.equals(null)) {
					mileage = String.valueOf(OG.getMileage());
				}
				if(MPG.equals(null)) {
					MPG = String.valueOf(OG.getMPG());
				}
				
				Car new_car = new Car(model, Integer.parseInt(year), make, color, Double.parseDouble(price), Integer.parseInt(mileage), Integer.parseInt(MPG), carID);
				
				cars.add(new_car);
				
				JOptionPane.showMessageDialog(null,
						" Model: " + model
						+ "\n Year " + year
						+ "\n Make " + make
						+ "\n Color " + color
						+ "\n Price " + price
						+ "\n Milage " + mileage
						+ "\n MPG " + MPG,
						"Information saved", JOptionPane.INFORMATION_MESSAGE);	
				
				frame.dispose();
			}

		});

	}

	/**
	 * This method will allow the employee to add a new vehicle to the list of vehicles.
	 * 
	 * @param cars
	 * 			is the array list of cars that contains every car.
	 * 
	 */
	public void registerNewVehicle(ArrayList<Car> cars) {

		JFrame frame = new JFrame();
		frame.setTitle("Register New Vehicle");
		frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;
		JLabel carModel = new JLabel("Car model");
		final JTextField carModelField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carYear = new JLabel("Car Year");
		final JTextField carYearField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMake = new JLabel("Car Make");
		final JTextField carMakeField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carColor = new JLabel("Car Color");
		final JTextField carColorField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carPrice = new JLabel("Car Price");
		final JTextField carPriceField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMilage = new JLabel("Car Milage");
		final JTextField carMilageField = new JTextField(TEXT_FIELD_SIZE);
		JLabel carMPG = new JLabel("Car MPG");
		final JTextField carMPGField = new JTextField(TEXT_FIELD_SIZE);
		JLabel IDNumber = new JLabel("ID number");
		final JTextField idField = new JTextField(TEXT_FIELD_SIZE);

		JButton submitButton = new JButton("Submit");

		frame.setLayout(new GridLayout(10, 2));

		frame.add(IDNumber);
		frame.add(idField);
		frame.add(carModel);
		frame.add(carModelField);
		frame.add(carYear);
		frame.add(carYearField);
		frame.add(carMake);
		frame.add(carMakeField);
		frame.add(carColor);
		frame.add(carColorField);
		frame.add(carPrice);
		frame.add(carPriceField);
		frame.add(carMilage);
		frame.add(carMilageField);
		frame.add(carMPG);
		frame.add(carMPGField);
		frame.add(submitButton);

		frame.pack();

		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				
				String model = carModelField.getText();
				String year = carYearField.getText();
				String make = carMakeField.getText();
				String color = carColorField.getText();
				String price = carPriceField.getText();
				String mileage = carMilageField.getText();
				String MPG = carMPGField.getText();
				String carID = idField.getText();
				
				for(Car c : cars) {
					if(c.getID().equals(carID)) {
						found = true;
						
						JOptionPane.showMessageDialog(null, "That Car ID is already in use, please choose another", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				if(!found) {
					Car new_car = new Car(model, Integer.parseInt(year), make, color, Double.parseDouble(price), Integer.parseInt(mileage), Integer.parseInt(MPG), carID);
	
					cars.add(new_car);
					
					JOptionPane.showMessageDialog(null,
							"The vehicles"
							+ " Model: " + model
							+ "\n Year " + year
							+ "\n Make " + make 
							+ "\n Color " + color
							+ "\n Price " + price
							+ "\n Milage " + mileage
							+ "\n MPG " + MPG,
							"Information saved",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				frame.dispose();
			}
		}); 
	}

	/**
	 * This method will remove a selected car from the list of cars
	 * 
	 * @param cars
	 * 			an array list of cars the contains every car
	 * 
	 */
	public void deleteVehicle(ArrayList<Car> cars) {

		JFrame frame = new JFrame("Delete Vehicle");
		frame.setLayout(new GridLayout(10, 2));

		frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;
		JLabel IDNumber = new JLabel("ID number of vehicle to delete");
		final JTextField idField = new JTextField(TEXT_FIELD_SIZE);

		JButton submitButton = new JButton("Submit");

		frame.add(IDNumber);
		frame.add(idField);
		frame.add(submitButton);

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				
				String carID = idField.getText();
				// checking to see if the entered number is an actual id number.
				for (Car car : cars) {
					if (car.getID().equals(carID)) {
						found = true;
						
						cars.remove(car);
						
						JOptionPane.showMessageDialog(null, "The car is removed", "\n ", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}

				if (!found) {
					JOptionPane.showMessageDialog(null, "The car ID is not found", "\n ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		});
	}
        
	/**
	 * This method will display every customer in the list.
	 * 
	 * @param customers 
	 * 			an array list of customers the contains every customer.
	 * 
	 */
	public void displayAllCustomers(ArrayList<Customer> customers) {

		JFrame frame = new JFrame("Display all Customers");
		frame.setVisible(true);
		frame.setLayout(new GridLayout(10, 2));

		final int TEXT_FIELD_SIZE = 20;
		JLabel allCustomers = new JLabel("All customers");
		final JTextField Customers = new JTextField(TEXT_FIELD_SIZE);

		JButton submitButton = new JButton("Submit");

		frame.add(allCustomers);
		frame.add(Customers);
		frame.add(submitButton);

		frame.pack();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String header[] = { "Name", "Username", "Email", "Phone Number", "Birthday" };
				Object data[][] = new Object[customers.size()][5];
				String info = "";
				List<String> list;
				int count = 0;

				for (Customer C : customers) {
					info = C.getAttributes();
					list = Arrays.asList(info.split(", "));

					for (int j = 0; j < 5; j++) {
						data[count][j] = list.get(j);
					}

					count++;
				}
				
				JTable table = new JTable(data, header) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// all cells false
						return false;
					}
				};
				Color primary = new Color(75, 75, 75);

				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3, 3));
				panel.setBackground(primary);

				Container c = frame.getContentPane();
				c.setBackground(primary);
				panel.add(table.getTableHeader());
				panel.add(table);
				frame.add(panel);
				frame.setLocationRelativeTo(null);
				frame.setSize(800, 500);
				frame.setVisible(true);
			}
		});
	}

	/**
	 * This method will find and print information about a certain reservation
	 * 
	 * @param reservations
	 *            is an array list of reservations that contains every reservation.
	 */
	public void findByConfirmationNumber(ArrayList<Reservation> reservations, ArrayList<Car> cars) {

		JFrame frame = new JFrame("Find confirmation number");
		frame.setVisible(true);
		frame.setLayout(new GridLayout(10, 2));

		final int TEXT_FIELD_SIZE = 20;
		JLabel confirmationNumber = new JLabel("Confirmation number your trying find");
		final JTextField confirmationNumberField = new JTextField(TEXT_FIELD_SIZE);
		JButton submitButton = new JButton("Submit");

		frame.add(confirmationNumber);
		frame.add(confirmationNumberField);
		frame.add(submitButton);

		frame.pack();
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int number = Integer.parseInt(confirmationNumberField.getText());
				
				// checking to see if the entered confirmation number is an actual
				// reservation number.
				for (Reservation reservation : reservations) {
					if (reservation.getConfirmationNumber() == number) {
						found = true;
						
						reservation.makeReservationReport(cars);
					}
				}

				if(!found) {
					JOptionPane.showMessageDialog(null, "Sorry that Reservation was not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public static void viewCustomerHistory(ArrayList<Reservation> reservations, String username) {
		ArrayList<Reservation> user_history = new ArrayList<Reservation>();
		
		JFrame frame = new JFrame("Customer History");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		for(Reservation R : reservations) {
			if(R.getUserName().equals(username)) {
				user_history.add(R);
			}
		}

		String header[] = { "Name", "Username", "Car", "Pick Up Date", "Drop Off Date", "Confirmation Number", "Quote" };
		Object data[][] = new Object[reservations.size()][7];
		String info = "";
		List<String> list;
		int count = 0;

		for (Reservation R : reservations) {
			info = R.getAttributes();
			list = Arrays.asList(info.split(", "));

			for (int j = 0; j < 7; j++) {
				data[count][j] = list.get(j);
			}

			count++;
		}
		
		JTable table = new JTable(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		Color primary = new Color(75, 75, 75);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.setBackground(primary);

		Container c = frame.getContentPane();
		c.setBackground(primary);
		panel.add(table.getTableHeader());
		panel.add(table);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
	}
	
	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
    public String getAttributes() {
    	String info = getName() + ", " + getUserName() + ", " + getEmail() + ", " + getPassword() + ", " + getPhoneNumber() + ", " + getBirthday() + ", " + getCreditCardNumber() + ", " + getHireDate() + ", " + getSalary();
    	
    	return info;
    }
}
