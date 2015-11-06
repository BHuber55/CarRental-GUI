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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

/* OKAY NEW IDEA
 * 
 * I could make each of the array list a class.. and in that class create all of these methods we are using
 * that way each method just replaces the array list with the modified ones, that way we don't have to return anything.
 * 
 * i.e.
 * 
 * reservations.makeReservations();
 * 
 * that will call the reservations class, will get the array list from its class' attributes and then modify it?
 * 
 * Maybe.
 */


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

		Login.loginFrame(customers, employees, managers, reservations, cars);
	}
	
	public static void mainMenu(Customer customer, ArrayList<Car> cars1, ArrayList<Customer> customers1, ArrayList<Employee> employees1, ArrayList<Manager> managers1, ArrayList<Reservation> reservations1) throws IOException {
		int user_input = 1;
		String beg_emp = "E_";
		String beg_man = "M_";
		
		Customer CUSTOMER = customer;
		Employee EMPLOYEE = null;
		Manager MANAGER = null;
		
		String username = CUSTOMER.getUserName();

		
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
		
		Scanner in = new Scanner(System.in);
		
		// checking if user is an employee or manager
		String beginning = username.substring(0, 2);
		
		if (beginning.equals(beg_emp)) {
			
			user_input = in.nextInt();
			// setting the current user as an employee.
			for (Employee employee : employees) {

				if (employee.getUserName().equals(username)) {
					EMPLOYEE = employee;
				}
			}
		}
		
		if (beginning.equals(beg_man)) {
			for (Manager manager : managers) {
				if (manager.getUserName().equals(CUSTOMER.getUserName())) {
					MANAGER = manager;
				}
			}
		}
		
		// Creating the frame and what not.
		JFrame menu_frame = new JFrame("Main Menu");
		menu_frame.setLayout(new FlowLayout());
		
		// creating all of the buttons.
		JButton b_c_logout = new JButton("Logout");
		JButton b_c_update_profile = new JButton("Update Profile");
		JButton b_c_make_resv = new JButton("Make Reservation");
		
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
		
		
		// creating the action listener for these buttons.
//		
//		b_c_logout.setOpaque(false);
//		b_c_logout.setContentAreaFilled(false);
//		b_c_logout.setBorderPainted(false);
//		b_c_logout.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e){
//				try {
//					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
//				}
//				catch (IOException e1) {
//					// do something.. maybe.
//				}
//			}
//		});
//		
//		b_c_update_profile.setOpaque(false);
//		b_c_update_profile.setContentAreaFilled(false);
//		b_c_update_profile.setBorderPainted(false);
//		b_c_update_profile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// remove the first customer.
//				customers.remove(CUSTOMER);
//				
//				// now we add the modified customer back to the list.
//				customers.add(CUSTOMER.updateProfile());
//			}
//		});
//
//		b_c_make_resv.setOpaque(false);
//		b_c_make_resv.setContentAreaFilled(false);
//		b_c_make_resv.setBorderPainted(false);
//		b_c_make_resv.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				reservations = CUSTOMER.makeReservation(cars, reservations);
//			}
//		});
//
//		b_e_new_vehicle.setOpaque(false);
//		b_e_new_vehicle.setContentAreaFilled(false);
//		b_e_new_vehicle.setBorderPainted(false);
//		b_e_new_vehicle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					cars = EMPLOYEE.registerNewVehicle(cars);
//				}
//				if (beginning.equals(beg_man)) {
//					cars = MANAGER.registerNewVehicle(cars);
//				}
//			}
//		});
//
//		b_e_update_vehicle.setOpaque(false);
//		b_e_update_vehicle.setContentAreaFilled(false);
//		b_e_update_vehicle.setBorderPainted(false);
//		b_e_update_vehicle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					cars = EMPLOYEE.updateVehicle(cars);
//				}
//				if (beginning.equals(beg_man)) {
//					cars = MANAGER.updateVehicle(cars);
//				}
//			}
//		});
//
//		b_e_delete_vehicle.setOpaque(false);
//		b_e_delete_vehicle.setContentAreaFilled(false);
//		b_e_delete_vehicle.setBorderPainted(false);
//		b_e_delete_vehicle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					cars = EMPLOYEE.deleteVehicle(cars);
//				}
//				if (beginning.equals(beg_man)) {
//					cars = MANAGER.deleteVehicle(cars);
//				}
//			}
//		});
//
//		b_e_display_customers.setOpaque(false);
//		b_e_display_customers.setContentAreaFilled(false);
//		b_e_display_customers.setBorderPainted(false);
//		b_e_display_customers.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					customers = EMPLOYEE.displayAllCustomers(customers);
//				}
//				if (beginning.equals(beg_man)) {
//					customers = MANAGER.displayAllCustomers(customers);
//				}
//			}
//		});
//
//		b_e_view_cust_record.setOpaque(false);
//		b_e_view_cust_record.setContentAreaFilled(false);
//		b_e_view_cust_record.setBorderPainted(false);
////		b_e_view_cust_record.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////			if (beginning.equals(beg_emp)) {
////				EMPLOYEE.viewCustomerRecord(customers);
////			}
////			if (beginning.equals(beg_man)) {
////				MANAGER.viewCustomerRecord(customers);
////			}
////			}
////		});
//
//		b_e_find_reservation.setOpaque(false);
//		b_e_find_reservation.setContentAreaFilled(false);
//		b_e_find_reservation.setBorderPainted(false);
//		b_e_find_reservation.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					EMPLOYEE.findByConfirmationNumber(reservations);
//				}
//				if (beginning.equals(beg_man)) {
//					MANAGER.findByConfirmationNumber(reservations);
//				}
//			}
//		});
//
//		b_e_review_reservation.setOpaque(false);
//		b_e_review_reservation.setContentAreaFilled(false);
//		b_e_review_reservation.setBorderPainted(false);
//		b_e_review_reservation.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (beginning.equals(beg_emp)) {
//					EMPLOYEE.reviewReservation(reservations, cars);
//				}
//				if (beginning.equals(beg_man)) {
//					MANAGER.reviewReservation(reservations, cars);
//				}
//			}
//		});
//
//		b_m_create_customer.setOpaque(false);
//		b_m_create_customer.setContentAreaFilled(false);
//		b_m_create_customer.setBorderPainted(false);
//		b_m_create_customer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				customers = MANAGER.createCustomer(customers);
//			}
//		});
//
//		b_m_create_employee.setOpaque(false);
//		b_m_create_employee.setContentAreaFilled(false);
//		b_m_create_employee.setBorderPainted(false);
//		b_m_create_employee.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				employees = MANAGER.createEmployee(employees);
//			}
//		});
//
//		b_m_make_reservation.setOpaque(false);
//		b_m_make_reservation.setContentAreaFilled(false);
//		b_m_make_reservation.setBorderPainted(false);
//		b_m_make_reservation.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				reservations = MANAGER.makeReservation(cars, reservations);
//			}
//		});
//
//		b_m_change_password.setOpaque(false);
//		b_m_change_password.setContentAreaFilled(false);
//		b_m_change_password.setBorderPainted(false);
//		b_m_change_password.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				managers = MANAGER.changePassword(customers, employees, managers, MANAGER.getUserName());
//			}
//		});
//
//		b_m_cancel_reservation.setOpaque(false);
//		b_m_cancel_reservation.setContentAreaFilled(false);
//		b_m_cancel_reservation.setBorderPainted(false);
//		b_m_cancel_reservation.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				reservations = MANAGER.cancelReservation(reservations);
//			}
//		});
//
//		b_m_update_reservation.setOpaque(false);
//		b_m_update_reservation.setContentAreaFilled(false);
//		b_m_update_reservation.setBorderPainted(false);
//		b_m_update_reservation.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				reservations = MANAGER.updateReservation(reservations, cars);
//			}
//		});
		
		// adding the buttons to the frame.
		menu_frame.add(b_c_logout);
		menu_frame.add(b_c_update_profile);
		menu_frame.add(b_c_make_resv);

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
			menu_frame.add(b_m_cancel_reservation);
			menu_frame.add(b_m_update_reservation);
		}
		
		menu_frame.setLocationRelativeTo(null);
		menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu_frame.setSize(500, 300);
		menu_frame.setVisible(true);

		// going to add this to write to file after each choice was selected and completed.
		WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
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
