
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Driver<T> extends formatter {

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
		int i = -1;

		// Creating the frame and what not.
		JFrame menu_frame = new JFrame("Main Menu");
    	format(menu_frame);

		
		final String beg_emp = "E_";
		final String beg_man = "M_";
		
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
		final String beginning = username.substring(0, 2);
		
		// if the beginning of the current user's username begins with E_ then we are setting him as an employee.
		if (beginning.equals(beg_emp)) {
			for (Employee employee : employees) {
				if (employee.getUserName().equals(username)) {
					// the user is an employee
					i = employees.indexOf(employee);
				}
			}
		}
		
		// if the employee was not found, we will just set it as 0.
		// because otherwise we will get out of bounds whenever we run, even if the user isn't an employee, we still need one defined.
		if(i == -1) {
			i = 0;
		}
		
		// must have the below line as a final for some reason.
		final Employee E = employees.get(i);	
		
		// if the beginning of the current user's username begins with M_ then we are setting him as a manager.
		if (beginning.equals(beg_man)) {
			for (Manager manager : managers) {
				if (manager.getUserName().equals(username)) {
					// the user is a manager.
					i = managers.indexOf(manager);
				}
			}
		}

		// still must have the below line as a final.
		final Manager M = managers.get(i);

		// creating the customer's buttons.
		JButton b_c_logout = new JButton("Logout");
		JButton b_c_update_profile = new JButton("Update Profile");
		JButton b_c_make_resv = new JButton("Make Reservation");
		JButton b_c_view_resv = new JButton("Review your Reservations");
		
		// creating the employee's buttons.
		JButton b_e_new_vehicle = new JButton("Register New Vehicle");
		JButton b_e_update_vehicle = new JButton("Update Vehicle");
		JButton b_e_delete_vehicle = new JButton("Delete Vehicle");
		JButton b_e_display_customers = new JButton("Display All Customers");
		JButton b_e_view_cust_record = new JButton("View Customer record");
		JButton b_e_find_reservation = new JButton("Find Reservation");
		JButton b_e_review_reservation = new JButton("Review Reservation");
		
		// creating the manager's buttons.
		JButton b_m_create_customer = new JButton("Create Customer");
		JButton b_m_create_employee = new JButton("Create Employee");
		JButton b_m_make_reservation = new JButton("Make Customer Reservation");
		JButton b_m_change_password = new JButton("Change Password");
		JButton b_m_cancel_reservation = new JButton("Cancel a Reservation");
		JButton b_m_update_reservation = new JButton("Update Reservation");
		JButton display = new JButton("Display all vehicles");
		
		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_c_logout);
		b_c_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
					menu_frame.dispose();
					return;
				}
				catch (IOException e1) {
					// do something.. maybe?
				}
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_c_update_profile);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_c_make_resv);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_c_view_resv);
		b_c_view_resv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C.displayReservationHistory(reservations);	
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_new_vehicle);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_update_vehicle);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_delete_vehicle);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_display_customers);
		b_e_display_customers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.displayAllCustomers(customers);
				}
				if (beginning.equals(beg_man)) {
					M.displayAllCustomers(customers);
				}
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_view_cust_record);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_find_reservation);
		b_e_find_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.findByConfirmationNumber(reservations, cars);
				}
				if (beginning.equals(beg_man)) {
					M.findByConfirmationNumber(reservations, cars);
				}
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_e_review_reservation);
		b_e_review_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beginning.equals(beg_emp)) {
					E.findByConfirmationNumber(reservations, cars);
				}
				if (beginning.equals(beg_man)) {
					M.findByConfirmationNumber(reservations, cars);
				}
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_create_customer);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_create_employee);
		b_m_create_employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M.createEmployee(employees, customers);
				
				try {
					WRITE(FILE_CARS, FILE_CUSTOMERS, FILE_EMPLOYEES, FILE_MANAGERS, FILE_RESERVATIONS, cars, customers, employees, managers, reservations);
				} catch (IOException e1) {
					// Do Stuff
				}
			}
		});

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_make_reservation);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_change_password);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_cancel_reservation);
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

		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(b_m_update_reservation);
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
		
		// creating the action listener for the button.
		// also setting the buttons to look good.
		format(display);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Car.advancedSearch(cars);
			}
		});
		
		// okay so the below is adding the images to the menu.
		// I tried to clean up the below lines.
		// will continue to work on this.
		menu_frame.setLayout(new BorderLayout());
		//menu_frame.setUndecorated(true);
		
		ImageIcon img = new ImageIcon("./Car.jpg");
		JLabel headerLabel = new JLabel(new ImageIcon("./headermm.jpg"));
		JPanel menu_Panel = new JPanel(); 
		JPanel panel = new JPanel();


		final Color primary = new Color(55, 71, 79);
		
		menu_frame.setIconImage(img.getImage()); 
		
		menu_Panel.setLayout(new GridLayout(6,1));
	
		panel.add(headerLabel); 	
		panel.setSize(img.getIconWidth(),img.getIconHeight());

        menu_frame.add(panel, BorderLayout.NORTH);
        
        
        // creating a panel to hold the buttons.
		JPanel p1 = new JPanel();
		p1.setBackground(primary);
		
		p1.add(b_c_update_profile);
		p1.add(b_c_make_resv);
		p1.add(b_c_view_resv);
		
		// adding the panel holding the buttons to the frame.
		menu_Panel.add(p1);

		// if the user is an employee or manager we want these buttons added.
		if (beginning.equals(beg_emp) || beginning.equals(beg_man)) {
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			p2.add(b_e_new_vehicle);
			p2.add(b_e_update_vehicle);
			p2.add(b_e_delete_vehicle);
			p2.add(b_e_find_reservation);
			p3.add(b_e_display_customers);
			p3.add(b_e_view_cust_record);
			p3.add(b_e_review_reservation);
			
			p2.setBackground(primary);
			p3.setBackground(primary);
			
			menu_Panel.add(p2);
			menu_Panel.add(p3);
		}
		// iff the user is a manager then we want these buttons added.
		if (beginning.equals(beg_man)) {
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			
			p4.add(b_m_create_customer);
			p4.add(b_m_create_employee);
			p4.add(b_m_make_reservation);
			p4.add(b_m_change_password);
			p5.add(b_m_cancel_reservation);
			p5.add(b_m_update_reservation);
			p5.add(display);
			
			p5.setBackground(primary);
			p4.setBackground(primary);
			
			menu_Panel.add(p4);
			menu_Panel.add(p5);
		}
	
		
		JPanel p6 = new JPanel();
		p6.add(new JLabel(""));
		p6.add(b_c_logout);
		p6.add(new JLabel(""));
		p6.setBackground(primary);
		
		menu_Panel.add(p6);
		
		menu_frame.add(menu_Panel);

		menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu_frame.setLocationRelativeTo(null);
		menu_frame.setSize(800, 500);
		menu_frame.setVisible(true);
	}
	
	public static int login(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, ArrayList<Reservation> reservations, ArrayList<Car> cars) {
		int index = 0;
		
		final Color primary = new Color(55, 71, 79);
		
		JFrame login = new JFrame();
		login.setUndecorated(true);
		
		ImageIcon img = new ImageIcon("./Car.jpg");
		login.setIconImage(img.getImage());
		
		login.setVisible(true);
		
		JLabel headerLabel = new JLabel(new ImageIcon("./headermm.jpg"));
        login.add(headerLabel, BorderLayout.PAGE_START);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		login.setLocation(((dim.width/2)-400), ((dim.height/2)-125));
        
		JPanel login_Panel = new JPanel(); 
		login_Panel.setLayout(new FlowLayout());
		login_Panel.setSize(100,100);
		login_Panel.setBackground(primary);
		
		JPanel login_Panel1 = new JPanel(); 
		login_Panel1.setLayout(new FlowLayout());
		login_Panel1.setSize(100,100);
		login_Panel1.setBackground(primary);
		
		JLabel username_label = new JLabel("Username: ");
		format(username_label);
		
		JLabel password_label = new JLabel("Password: ");
		format(password_label);
		
		JTextField username_text_field = new JTextField(10);
		JTextField password_text_field = new JTextField(10);
		username_text_field.setText("M_loro");
		format(username_text_field);
		
		password_text_field.setText("abc123");
		format(password_text_field);
		
		JButton login_button = new JButton("Login");
		format(login_button);
		
		JButton create_button = new JButton("Create Account");
		format(create_button);
		
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
			
						// kill the program after the menu is called.
						return;
					} catch (IOException e1) {
						// do stuff.
					}
				}
			}
		});
		
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if they choose to create a new account.. we do that.
				// this is going to be an interesting one to solve.
				Customer.createNewCustomer(customers);				
				
				login.dispose(); 
				login(customers, employees, managers, reservations, cars);
				
			}
		});
		
		login_Panel.add(username_label);
		login_Panel.add(username_text_field);
		
		login_Panel.add(password_label);
		login_Panel.add(password_text_field);

		login_Panel.add(create_button);
		login_Panel.add(login_button);
		
		login.add(login_Panel, BorderLayout.CENTER);
		//login.add(login_Panel1, BorderLayout.CENTER);
		
		login.pack();
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
				} else {
					JOptionPane pane = new JOptionPane(); 
					format(pane);
					JOptionPane.showMessageDialog(null, "Password is incorrect", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
		if(!found) {
			JOptionPane pane = new JOptionPane(); 
			format(pane);
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
				items.add((T) new Reservation(line, br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Boolean.parseBoolean(br.readLine()), Double.parseDouble(br.readLine())));
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
				} else if (item instanceof Customer) {
					info = ((Customer) item).getAttributes();
				} else if (item instanceof Employee) {
					info = ((Employee) item).getAttributes();
				} else if (item instanceof Manager) {
					info = ((Manager) item).getAttributes();
				} else {
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
