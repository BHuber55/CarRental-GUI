/*
 * Features that need to be added.
 * 
 * 1. Need to create the customer reservation history.
 * 		Store the confirmation number in an ArrayList<int>.
 * 		Then to find the information just look in reservations.
 * 		tbd on how to read that from a file though.
 * 
 * 2. Check the dates on the reservation to make sure that the cars are available for the customer selected dates.
 * 
 * 3. Add a customer name to the reservation. As to link it to the reservations.
 * 
 * 4. Convert the day class to the Calendar class.
 * 
 * 5. Convert the menu to frames.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Might have to add WRITE() to the last line of every button ActionListener.

public class Driver<T> {

	public static void main(String args[]) throws IOException {
		// Defining the names of the files used.
		final String FILE_CARS = "Cars.txt";
		final String FILE_CUSTOMERS = "Customers.txt";
		final String FILE_EMPLOYEES = "Employees.txt";
		final String FILE_MANAGERS = "Managers.txt";
		final String FILE_RESERVATIONS = "Reservations.txt";
		
		// Initializing the arrayList holding each Class
		ArrayList<Car> cars = readFile(FILE_CARS);
		ArrayList<Customer> customers = readFile(FILE_CUSTOMERS);
		ArrayList<Employee> employees = readFile(FILE_EMPLOYEES);
		ArrayList<Manager> managers = readFile(FILE_MANAGERS);
		ArrayList<Reservation> reservations = readFile(FILE_RESERVATIONS);

		int index = login(customers, employees, managers, reservations, cars);
		// Main menu is called after the user logs in.
	}
	
	public static void mainMenu(int index, ArrayList<Car> cars1, ArrayList<Customer> customers1, ArrayList<Employee> employees1, ArrayList<Manager> managers1, ArrayList<Reservation> reservations1) throws IOException {
		int i = 1000;
		
		boolean check = false;
		
		String beg_emp = "E_";
		String beg_man = "M_";
		
		final Customer C = customers1.get(index);
		// employee is defined below
		// manager is defined below.
		
		String username = C.getUserName();
		
		ArrayList<Car> cars = cars1;
		ArrayList<Customer> customers = customers1;
		ArrayList<Employee> employees = employees1;
		ArrayList<Manager> managers = managers1;
		ArrayList<Reservation> reservations = reservations1;
		
		// Defining the names of the files used.
		final String FILE_CARS = "Cars.txt";
		final String FILE_CUSTOMERS = "Customers.txt";
		final String FILE_EMPLOYEES = "Employees.txt";
		final String FILE_MANAGERS = "Managers.txt";
		final String FILE_RESERVATIONS = "Reservations.txt";
		
		// checking if user is an employee or manager
		String beginning = username.substring(0, 2);
		
		if (beginning.equals(beg_emp)) {
			for (Employee employee : employees) {
				if (employee.getUserName().equals(username)) {
					// the user is an employee
					i = employees.indexOf(employee);
				}
			}
		}
		
		if(i == 1000)
		{
			i = 0;
		}
		
		final Employee E = employees.get(i);	
		
		if (beginning.equals(beg_man)) {
			for (Manager manager : managers) {
				if (manager.getUserName().equals(username)) {
					// the user is a manager.
					i = managers.indexOf(manager);
				}
			}
		}

		final Manager M = managers.get(i);
		
		// Creating the frame and what not.
		JFrame menu_frame = new JFrame("Main Menu");
		menu_frame.setLayout(new FlowLayout());
		
		// creating all of the buttons.
		JButton b_c_logout = new JButton("Logout");
		JButton b_c_update_profile = new JButton("Update Profile");
		JButton b_c_make_resv = new JButton("Make Reservation");
		JButton b_c_view_resv = new JButton("Review your Reservations");
		
		JButton b_e_new_vehicle = new JButton("Register New Vehicle");
		JButton b_e_update_vehicle = new JButton("Update Vehicle");
		JButton b_e_delete_vehicle = new JButton("Delete Vehicle");
		JButton b_e_display_customers = new JButton("Display All Custmers");
		JButton b_e_view_cust_record = new JButton("View Customer record");
		JButton b_e_find_reservation = new JButton("Find Reservation");
		JButton b_e_review_reservation = new JButton("Review Reservation");
		
		JButton b_m_create_customer = new JButton("Create Customer");
		JButton b_m_create_employee = new JButton("Create Employee");
		JButton b_m_make_reservation = new JButton("Make Reservation for Customer");
		JButton b_m_change_password = new JButton("Change Password");
		JButton b_m_cancel_reservation = new JButton("Cancel a Reservation");
		JButton b_m_update_reservation = new JButton("Update Reservation");
		
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<TESTING DISPLAY ALL VEHICLES.
		// it works! now to modify it and make sure that it adds every vechicle using all the for loops.. all of them.
		JButton display = new JButton("Display all vechicles");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Car.advancedSearch(cars);
			}
		});
		
		menu_frame.add(display);
		// creating the action listener for these buttons.
		
		b_c_logout.setOpaque(false);
		b_c_logout.setContentAreaFilled(false);
		b_c_logout.setBorderPainted(false);
		b_c_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
					menu_frame.dispose();
				}
				catch (IOException e1) {
					// do something.. maybe.
				}
			}
		});
		
		b_c_update_profile.setOpaque(false);
		b_c_update_profile.setContentAreaFilled(false);
		b_c_update_profile.setBorderPainted(false);
		b_c_update_profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remove the first customer.
				int index = customers.indexOf(C);
				
				// now we add the modified customer back to the list.
				C.updateProfile(index, customers);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_c_make_resv.setOpaque(false);
		b_c_make_resv.setContentAreaFilled(false);
		b_c_make_resv.setBorderPainted(false);
		b_c_make_resv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C.makeReservation(cars, reservations);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});	
		
		b_c_view_resv.setOpaque(false);
		b_c_view_resv.setContentAreaFilled(false);
		b_c_view_resv.setBorderPainted(false);
		b_c_view_resv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C.displayUserReservations(reservations, cars);	
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_new_vehicle.setOpaque(false);
		b_e_new_vehicle.setContentAreaFilled(false);
		b_e_new_vehicle.setBorderPainted(false);
		b_e_new_vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.registerNewVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					M.registerNewVehicle(cars);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_update_vehicle.setOpaque(false);
		b_e_update_vehicle.setContentAreaFilled(false);
		b_e_update_vehicle.setBorderPainted(false);
		b_e_update_vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.updateVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					M.updateVehicle(cars);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_delete_vehicle.setOpaque(false);
		b_e_delete_vehicle.setContentAreaFilled(false);
		b_e_delete_vehicle.setBorderPainted(false);
		b_e_delete_vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.deleteVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					M.deleteVehicle(cars);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_display_customers.setOpaque(false);
		b_e_display_customers.setContentAreaFilled(false);
		b_e_display_customers.setBorderPainted(false);
		b_e_display_customers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.displayAllCustomers(customers);
				}
				if (beginning.equals(beg_man)) {
					M.displayAllCustomers(customers);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_view_cust_record.setOpaque(false);
		b_e_view_cust_record.setContentAreaFilled(false);
		b_e_view_cust_record.setBorderPainted(false);
//		b_e_view_cust_record.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					E.viewCustomerRecord(customers);
//				}
//				if (beginning.equals(beg_man)) {
//					M.viewCustomerRecord(customers);
//				}
		
//				try {
//					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
//				} catch (IOException e1) {
//					// Do Stuff
//				}
//			}
//		});

		b_e_find_reservation.setOpaque(false);
		b_e_find_reservation.setContentAreaFilled(false);
		b_e_find_reservation.setBorderPainted(false);
		b_e_find_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.findByConfirmationNumber(reservations);
				}
				if (beginning.equals(beg_man)) {
					M.findByConfirmationNumber(reservations);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_e_review_reservation.setOpaque(false);
		b_e_review_reservation.setContentAreaFilled(false);
		b_e_review_reservation.setBorderPainted(false);
		b_e_review_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.reviewReservation(reservations, cars);
				}
				if (beginning.equals(beg_man)) {
					M.reviewReservation(reservations, cars);
				}
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_create_customer.setOpaque(false);
		b_m_create_customer.setContentAreaFilled(false);
		b_m_create_customer.setBorderPainted(false);
		b_m_create_customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.createCustomer(customers);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_create_employee.setOpaque(false);
		b_m_create_employee.setContentAreaFilled(false);
		b_m_create_employee.setBorderPainted(false);
		b_m_create_employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.createEmployee(employees);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_make_reservation.setOpaque(false);
		b_m_make_reservation.setContentAreaFilled(false);
		b_m_make_reservation.setBorderPainted(false);
		b_m_make_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.makeReservation(cars, reservations);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_change_password.setOpaque(false);
		b_m_change_password.setContentAreaFilled(false);
		b_m_change_password.setBorderPainted(false);
		b_m_change_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.changePassword(customers, employees, managers, M.getUserName());
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_cancel_reservation.setOpaque(false);
		b_m_cancel_reservation.setContentAreaFilled(false);
		b_m_cancel_reservation.setBorderPainted(false);
		b_m_cancel_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.cancelReservation(reservations);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		b_m_update_reservation.setOpaque(false);
		b_m_update_reservation.setContentAreaFilled(false);
		b_m_update_reservation.setBorderPainted(false);
		b_m_update_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.updateReservation(reservations, cars);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}			
			}
		});
		
		// adding the buttons to the frame.
		menu_frame.add(b_c_logout);
		menu_frame.add(b_c_update_profile);
		menu_frame.add(b_c_make_resv);
		menu_frame.add(b_c_view_resv);

		// if the user is an employee or manager we want these buttons added.
		if (beginning.equals(beg_emp) || beginning.equals(beg_man)) {
			menu_frame.add(b_e_new_vehicle);
			menu_frame.add(b_e_update_vehicle);
			menu_frame.add(b_e_delete_vehicle);
			menu_frame.add(b_e_display_customers);
			menu_frame.add(b_e_view_cust_record);
			menu_frame.add(b_e_find_reservation);
			menu_frame.add(b_e_review_reservation);
		}
		// if the employee is a manager then we want these buttons added.
		if (beginning.equals(beg_man)) {
			menu_frame.add(b_m_create_customer);
			menu_frame.add(b_m_create_employee);
			menu_frame.add(b_m_make_reservation);
			menu_frame.add(b_m_change_password);
			menu_frame.add(b_m_cancel_reservation);
			menu_frame.add(b_m_update_reservation);
		}

		menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu_frame.setLocationRelativeTo(null);
		menu_frame.setSize(500, 300);
		menu_frame.setVisible(true);

		// going to add this to write to file after each choice was selected and completed.
		WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
}
	
	
	public static int login(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, ArrayList<Reservation> reservations, ArrayList<Car> cars) {
		int index = 0;
		
		// CREATING THE FRAME FOR LOGIN!!!
		JFrame login = new JFrame("Car Rental Name");
		
		JLabel username_label = new JLabel("Username: ");
		JLabel password_label = new JLabel("Password: ");
		
		JTextField username_text_field = new JTextField("M_loro");
		JTextField password_text_field = new JTextField("abc123");
//		JTextField username_text_field = new JTextField(15);
//		JTextField password_text_field = new JTextField(15);
		
		JButton login_button = new JButton("Login");
		JButton create_button = new JButton("Create Account");
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if the user click 'login' we will check their information.
				
				String username = username_text_field.getText();
				String password = password_text_field.getText();
				
				final int i = loginCheck(customers, username, password);
				
				if (i != -99) {
					try {
						login.dispose();
						Driver.mainMenu(i, cars, customers, employees, managers, reservations);
					}
					catch (IOException e1) {
						// do stuff.
					}
				}
			}
		});
		
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if they choose to create a new account.. we do that.
				
				Customer c = Customer.createNewCustomer(customers);				
				customers.add(c);
				
				final int i = customers.indexOf(c);
				
				try {
					login.dispose();
					Driver.mainMenu(i, cars, customers, employees, managers, reservations);
				}
				catch (IOException e1) {
					// do stuff.
				}
			}
		});
		
		login.add(username_label);
		login.add(username_text_field);
		
		login.add(password_label);
		login.add(password_text_field);

		login.add(create_button);
		login.add(login_button);
		
		login.setSize(300, 200);
		login.setLayout(new FlowLayout());
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		
		return index;
	}
	
	public static int loginCheck(ArrayList<Customer> customers, String username, String password) {
		boolean found = false;
		int index = -99;
		
		for(Customer customer : customers) {
			if(customer.getUserName().equals(username)) {
				found = true;

				if(customer.getPassword().equals(password)) {
					index = customers.indexOf(customer);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is incorrect", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
		if(!found) {
			JOptionPane.showMessageDialog(null, "Username was not found.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		return index;
	}
	
	public static <T> void WRITE(String FILE_CARS, String FILE_CUSTOMERS, String FILE_EMPLOYEES, String FILE_MANAGERS, String FILE_RESERVATIONS, ArrayList<Car> cars, ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, ArrayList<Reservation> reservations) throws IOException{
		writeFile(FILE_CARS, cars);
		writeFile(FILE_CUSTOMERS, customers);
		writeFile(FILE_EMPLOYEES, employees);
		writeFile(FILE_MANAGERS, managers);
		writeFile(FILE_RESERVATIONS, reservations);
	}
	
	// need to edit the employee and manager constructor here to include the information from the super classes.
	public static <T> ArrayList<T> readFile(String file_name) throws NumberFormatException, IOException {
		// initializing BufferedReader.
		FileReader fr = new FileReader("./" + file_name);
		BufferedReader br = new BufferedReader(fr);

		// initializing the array to hold all of the items from the text file.
		ArrayList<T> items = new ArrayList<>();

		String line;

		// storing the item into items array.
		while ((line = br.readLine()) != null) {
			if (file_name == "Cars.txt") {
				// Creating the object Cars and storing it in an arrayList
				// Car(model, year, make, color, price, mileage, MPG)
				items.add((T) new Car(line, Integer.parseInt(br.readLine()), br.readLine(), br.readLine(), Double.parseDouble(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), br.readLine()));
			}
			
			if (file_name =="Customers.txt") {
				// Creating the object Customer and storing it in an array
				// Customer(name, userName, email, password, phoneNumber, birthday, creditCardNumber)
				items.add((T) new Customer(line, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine()));
			}

			if (file_name == "Employees.txt") {
				// Creating the object Employees and storing it in an array
				// Employee(salary, hireDate)
				items.add((T) new Employee(line, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
			}

			if (file_name == "Managers.txt") {
				// Creating the object Managers and storing it in an array
				// Manager(bonus)
				items.add((T) new Manager(line, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Double.parseDouble(br.readLine())));
			}

			if (file_name == "Reservations.txt") {
				// Creating the object Reservations and storing it in an array
				// car, pickupDay, dropoffDay, confirmationNumber, insurance, quote
				items.add((T) new Reservation(line, br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Boolean.parseBoolean(br.readLine()), br.readLine()));
			}
		}

		br.close();

		// returning the arrayList that holds items
		return items;
	}

	// Temporary permanent work around.
	private static <T> void writeFile(String file_name, ArrayList<T> items) throws IOException {
		FileWriter fw = new FileWriter("./" + file_name);
		BufferedWriter bw = new BufferedWriter(fw);

		String info = "";
		List<String> list = Arrays.asList(info.split(", "));

		for (T item : items) {
			for (int j = 0; j < list.size(); j++) {
				if (item instanceof Car) {
					info = ((Car) item).getAttributes();
				}
				else if (item instanceof Customer) {
					info = ((Customer) item).getAttributes();
				}
				else if (item instanceof Employee) {
					info = ((Employee) item).getAttributes();
				}
				else if (item instanceof Manager) {
					info = ((Manager) item).getAttributes();
				}
				else {
					info = ((Reservation) item).getAttributes();
				}

				list = Arrays.asList(info.split(", "));

				bw.write(list.get(j));
				bw.newLine();
			}
		}

		bw.close();
	}
}
