import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
 * This is the Manager class, it holds the information that is used to create,
 * and get information about a Manager.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Manager extends Employee {

	private double bonus;

	/**
	 * This is the constructor, it will construct a manager with the given
	 * attributes.
	 * 
	 * @param name1
	 *            is the name of the manager
	 * @param username1
	 *            is the username of the manager
	 * @param email1
	 *            is the email of the manager
	 * @param password1
	 *            is the password of the manager
	 * @param phone1
	 *            is the phone of the manager
	 * @param birthday1
	 *            is the birthday of the manager
	 * @param credit1
	 *            is the credit card number of the manager
	 * @param hire1
	 *            is the hire date of the manager
	 * @param salary1
	 *            is the salary of the manager
	 * @param bonus1
	 *            is the bonus the manager receives
	 */
	public Manager(String name1, String username1, String email1, String password1, String phone1, String birthday1,
			String credit1, String hire1, int salary1, double bonus1) {

		super(name1, username1, email1, password1, phone1, birthday1, credit1, hire1, salary1);

		bonus = bonus1;
	}

	/**
	 * This method will get the bonus that the manager receives.
	 * 
	 * @return a double that holds the bonus this manager receives.
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * This method will create a customer and add it to the list of customers.
	 * 
	 * @param customers
	 *            is an array list of customers that contains every customer.
	 * 
	 * @return an array list of customers that contains every customer,
	 *         including the newly created one.
	 */
	public void createCustomer(ArrayList<Customer> customers) {
		
		JFrame cust_frame = new JFrame("Create Customer");
		format(cust_frame); 
		addHeader(cust_frame); 

		JPanel cust_panel = new JPanel();
		format(cust_panel); 


		final int TEXT_FIELD_SIZE = 20;

		JLabel nameLabel = new JLabel("Name: ");
		format(nameLabel);

		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE);
		format(nameField);

		JLabel userNameLabel = new JLabel("Username: ");
		format(userNameLabel);

		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE);
		format(userNameField);

		JLabel emailLabel = new JLabel("Email: ");
		format(emailLabel);

		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE);
		format(emailField);

		JLabel passwordLabel = new JLabel("Password: ");
		format(passwordLabel);

		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE);
		format(passwordField);

		JLabel phoneLabel = new JLabel("Phone Number: ");
		format(phoneLabel);

		final JTextField phoneField = new JTextField(10);
		format(phoneField);

		JLabel birthdayLabel = new JLabel("Birthday: ");
		format(birthdayLabel);

		final JTextField birthdayField = new JTextField(10);
		format(birthdayField);

		JLabel creditLabel = new JLabel("Credit Card Number: ");
		format(creditLabel);

		final JTextField creditField = new JTextField(16);
		format(creditField);

		JButton okButton = new JButton("Submit");
		format(okButton);

		cust_panel.setLayout(new GridLayout(8, 2));
		cust_panel.add(nameLabel);
		cust_panel.add(nameField);
		cust_panel.add(userNameLabel);
		cust_panel.add(userNameField);
		cust_panel.add(emailLabel);
		cust_panel.add(emailField);
		cust_panel.add(passwordLabel);
		cust_panel.add(passwordField);
		cust_panel.add(phoneLabel);
		cust_panel.add(phoneField);
		cust_panel.add(birthdayLabel);
		cust_panel.add(birthdayField);
		cust_panel.add(creditLabel);
		cust_panel.add(creditField);
		cust_panel.add(new JLabel(""));
		cust_panel.add(okButton);
		cust_frame.add(cust_panel);
		cust_frame.pack();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String userName = userNameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				String phone = phoneField.getText();
				String birthday = birthdayField.getText();
				String credit = creditField.getText();

				Customer customer = new Customer(name, userName, email, password, phone, birthday, credit);
				customers.add(customer);

				JOptionPane pane = new JOptionPane(); 
				format(pane); 

				pane.showMessageDialog(null,
						" Name: " + name
						+ "\n Username: " + userName
						+ "\n Email: " + email
						+ "\n Password: " + password
						+ "\n Phone: " + phone
						+ "\n Birthday: " + birthday
						+ "\n Credit Card Number: " + credit,
						"Information saved", JOptionPane.INFORMATION_MESSAGE);

				cust_frame.dispose();
			}
		});
	}

	/**
	 * This method will create a employee and add it to the list of employees.
	 * 
	 * @param customers
	 *            is an array list of employees that contains every employee.
	 * 
	 * @return an array list of employees that contains every employee,
	 *         including the newly created one.
	 */
	public void createEmployee(ArrayList<Employee> employees, ArrayList<Customer> customers) {
		
		JFrame emp_frame = new JFrame("Create Employee"); 
		format(emp_frame); 
		addHeader(emp_frame);

		JPanel emp_panel = new JPanel();
		format(emp_panel); 
		
		emp_panel.setLayout(new GridLayout(10, 2));

		final int TEXT_FIELD_SIZE = 20;
		JLabel nameLabel = new JLabel("Name: ");
		format(nameLabel);

		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE);
		format(nameField);

		JLabel userNameLabel = new JLabel("Username: ");
		format(userNameLabel);

		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE);
		format(userNameField);

		JLabel emailLabel = new JLabel("Email: ");
		format(emailLabel);

		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE);
		format(emailField);

		JLabel passwordLabel = new JLabel("Password: ");
		format(passwordLabel);

		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE);
		format(passwordField);

		JLabel phoneLabel = new JLabel("Phone Number: ");
		format(phoneLabel);

		final JTextField phoneField = new JTextField(10);
		format(phoneField);

		JLabel birthdayLabel = new JLabel("Birthday: ");
		format(birthdayLabel);

		final JTextField birthdayField = new JTextField(8);
		format(birthdayField);

		JLabel creditLabel = new JLabel("Credit Card Number: ");
		format(creditLabel);

		final JTextField creditField = new JTextField(16);
		format(creditField);

		JLabel hireLabel = new JLabel("Hire Date: ");
		format(hireLabel);

		final JTextField hireField = new JTextField(8);
		format(hireField);

		JLabel salaryLabel = new JLabel("Salary: ");
		format(salaryLabel);

		final JTextField salaryField = new JTextField(8);
		format(salaryField);

		JButton okButton = new JButton("Submit");
		format(okButton);

		emp_panel.add(nameLabel);
		emp_panel.add(nameField);
		emp_panel.add(userNameLabel);
		emp_panel.add(userNameField);
		emp_panel.add(emailLabel);
		emp_panel.add(emailField);
		emp_panel.add(passwordLabel);
		emp_panel.add(passwordField);
		emp_panel.add(phoneLabel);
		emp_panel.add(phoneField);
		emp_panel.add(birthdayLabel);
		emp_panel.add(birthdayField);
		emp_panel.add(creditLabel);
		emp_panel.add(creditField);
		emp_panel.add(hireLabel);
		emp_panel.add(hireField);
		emp_panel.add(salaryLabel);
		emp_panel.add(salaryField);
		emp_panel.add(new JLabel(""));
		emp_panel.add(okButton);
		emp_frame.add(emp_panel);
		emp_frame.pack();


		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String userName = userNameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				String phone = phoneField.getText();
				String birthday = birthdayField.getText();
				String credit = creditField.getText();
				String hire = hireField.getText();
				int salary = Integer.parseInt(salaryField.getText());

				Employee emp = new Employee(name, userName, email, password, phone, birthday, credit, hire, salary);
				Customer C = new Customer(name, userName, email, password, phone, birthday, credit);
				
				employees.add(emp);
				customers.add(C);
				
				
			JOptionPane pane = new JOptionPane(); 
			format(pane); 

				JOptionPane.showMessageDialog(null,
						" Name: " + name
						+ "\n Username: " + userName
						+ "\n Email: " + email
						+ "\n Password: " + password
						+ "\n Phone: " + phone
						+ "\n Birthday: " + birthday
						+ "\n Credit Card Number: " + credit
						+ "\n Hire Date: " + hire
						+ "\n Salary: " + salary,
						"Information saved",
						JOptionPane.INFORMATION_MESSAGE);

				emp_frame.dispose();
			}
		});
	}

	/**
	 * This method will change the password of the manager.
	 * 
	 * @param customers
	 *            customers is an array list of customers that contains every
	 *            customer.
	 * @param employees
	 *            is an array list of employees that contains every employee.
	 * @param managers
	 *            is an array list of managers that contains every manager.
	 * @param userName
	 *            a String that contains the username of the manager.
	 * 
	 */
	public void changePassword(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, String userName) {
		

		JFrame pass_frame = new JFrame("Change Password"); 
		format(pass_frame); 
		addHeader(pass_frame);

		
		JPanel pass_panel = new JPanel();
		format(pass_panel); 

		
		pass_panel.setLayout(new GridLayout(8, 3));

		final int TEXT_FIELD_SIZE = 20;
		JLabel passLabel = new JLabel("Please enter your new password: ");
		format(passLabel);

		final JTextField passField = new JTextField(TEXT_FIELD_SIZE);
		format(passField);

		JLabel passLabel1 = new JLabel("Please enter your new password again: ");
		format(passLabel1);

		final JTextField passField1 = new JTextField(TEXT_FIELD_SIZE);
		format(passField1);

		JButton okButton = new JButton("Submit");
		format(okButton);

		pass_panel.add(passLabel);
		pass_panel.add(passField);
		pass_panel.add(passLabel1);
		pass_panel.add(passField1);
		pass_panel.add(okButton);
		pass_frame.add(pass_panel);
		pass_frame.pack();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				Manager m = null;
				Employee e = null;
				Customer c = null;

				String password1 = passField.getText();
				String password2 = passField1.getText();

				if (!password1.equals(password2)) {
					JOptionPane pane = new JOptionPane(); 
					format(pane); 
					pane.showMessageDialog(null, "Passwords are not equal", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}

				for (Manager manager : managers) {
					if (manager.getUserName().equals(userName)) {
						m = manager;
					}
				}

				for (Employee employee : employees) {
					if (employee.getUserName().equals(userName)) {
						e = employee;
					}
				}

				for (Customer customer : customers) {
					if (customer.getUserName().equals(userName)) {
						c = customer;
					}
				}

				Manager manager = new Manager(m.getName(), m.getUserName(), m.getEmail(), password1, m.getPhoneNumber(), m.getBirthday(), m.getCreditCardNumber(), m.getHireDate(), m.getSalary(), m.getBonus());
				Employee employee = new Employee(e.getName(), e.getUserName(), e.getEmail(), password1, e.getPhoneNumber(), e.getBirthday(), e.getCreditCardNumber(), e.getHireDate(), e.getSalary());
				Customer customer = new Customer(c.getName(), c.getUserName(), c.getEmail(), password1, c.getPhoneNumber(), c.getBirthday(), c.getCreditCardNumber());

				managers.remove(m);
				managers.add(manager);

				employees.remove(e);
				employees.add(employee);

				customers.remove(c);
				customers.add(customer);

				JOptionPane pane = new JOptionPane(); 
				format(pane); 

				pane.showMessageDialog(null, "\n New Password: " + password1, "Information saved", JOptionPane.INFORMATION_MESSAGE);

				pass_frame.dispose();
			}
		});
	}

	/**
	 * This method will remove a reservation from the list.
	 * 
	 * @param reservations
	 *            is an array list of reservations that contains every reservation.
	 * 
	 */
	public void cancelReservation(ArrayList<Reservation> reservations) {

		final int TEXT_FIELD_SIZE = 20;

		JFrame cancel_frame = new JFrame("Cancel Reservation");
		format(cancel_frame); 
		addHeader(cancel_frame); 
	

		JPanel cancel_panel = new JPanel();
		format(cancel_panel); 
		cancel_panel.setLayout(new GridLayout(1, 3));


		JLabel confirmLabel = new JLabel("Confirmation Number to cancel:  ");
		format(confirmLabel);

		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		format(confirmField);

		JButton okButton = new JButton("Submit");
		format(okButton);
		cancel_panel.add(confirmLabel);
		cancel_panel.add(confirmField);
		cancel_panel.add(okButton);
		cancel_frame.add(cancel_panel);
		cancel_frame.pack(); 

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;

				int number = Integer.parseInt(confirmField.getText());

				// checking to see if the entered confirmation number is an
				// actual reservation number.
				for (Reservation reservation : reservations) {
					if (reservation.getConfirmationNumber() == number) {
						found = true;

						reservations.remove(reservation);
						JOptionPane pane = new JOptionPane(); 
						format(pane); 
						
						pane.showMessageDialog(null, "Reservation had been canceled.", "Information saved", JOptionPane.INFORMATION_MESSAGE);
					}
				}

				if (!found) {
					JOptionPane pane = new JOptionPane(); 
					format(pane); 

					pane.showMessageDialog(null, "Sorry, Reservation not found. Try again", "Error", JOptionPane.ERROR_MESSAGE);
				}

				cancel_frame.dispose();
			}
		});
	}

    /**
     * This method will update a single aspect of a reservation
     * 
     * @param reservations
     * 				is an array list of reservations that contains every reservation.
     * @param cars
     * 			is an array list of cars that contains every car.
     * 
     */
    public void updateReservation(ArrayList<Reservation> reservations, ArrayList<Car> cars) {

		final int TEXT_FIELD_SIZE = 20;
    	
    	JFrame update_frame = new JFrame("Update Reservation Info");  
    	format(update_frame); 
    	addHeader(update_frame);
    	
    	JPanel update_panel = new JPanel(); 
		update_panel.setLayout(new GridLayout(1,3));
		format(update_panel); 
		
		JLabel confirmLabel = new JLabel("Confirmation Number to update:  "); 
		format(confirmLabel); 
		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		format(confirmField); 
		JButton okButton = new JButton("Submit");
		format(okButton); 
		
		update_panel.add(confirmLabel);
		update_panel.add(confirmField);
		update_panel.add(okButton);
		update_frame.add(update_panel);
		update_frame.pack();
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int number = Integer.parseInt(confirmField.getText());

				// checking to see if the entered confirmation number is an
				// actual reservation number.
				for (Reservation reservation : reservations) {
					if (reservation.getConfirmationNumber() == number) {
						found = true;
						JOptionPane pane = new JOptionPane(); 
						format(pane); 
						pane.showMessageDialog(null,
								"Reservation had been found.\n " + reservation.getAttributes(),
								"Reservation Information", JOptionPane.INFORMATION_MESSAGE);

						update_frame.dispose();

						// make reservation no longer returns something. so yeah.
						String username = reservation.getUserName();
						
						Reservation.makeReservation(cars, reservations, username);
						reservations.remove(reservation);
					}
				}

				if (!found) {
					JOptionPane pane = new JOptionPane(); 
					format(pane); 
					pane.showMessageDialog(null, "Reservation was not found.\n ", "Reservation Information", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
    public String getAttributes() {
    	String info = getName() + ", " + getUserName() + ", " + getEmail() + ", " + getPassword() + ", " + getPhoneNumber() + ", " + getBirthday() + ", " + getCreditCardNumber() + ", " + getHireDate() + ", " + getSalary() + ", " + getBonus();
    	
    	return info;
    }
    
}
