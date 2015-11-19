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
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";
		
		JFrame cust_frame = new JFrame("Create Customer");
		ImageIcon img = new ImageIcon("./Car.jpg");
		cust_frame.setIconImage(img.getImage());

		JPanel cust_panel = new JPanel();

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		cust_frame.add(headerLabel, BorderLayout.PAGE_START);

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
					cust_frame.dispose();
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

		Container c = cust_frame.getContentPane();
		c.setBackground(primary);
		cust_frame.setLocationRelativeTo(null);
		cust_frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBackground(primary);
		nameLabel.setForeground(secondary);
		nameLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE);
		nameField.setBackground(secondary);
		nameField.setForeground(primary);
		nameField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel userNameLabel = new JLabel("Username: ");
		userNameLabel.setBackground(primary);
		userNameLabel.setForeground(secondary);
		userNameLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE);
		userNameField.setBackground(secondary);
		userNameField.setForeground(primary);
		userNameField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBackground(primary);
		emailLabel.setForeground(secondary);
		emailLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE);
		emailField.setBackground(secondary);
		emailField.setForeground(primary);
		emailField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBackground(primary);
		passwordLabel.setForeground(secondary);
		passwordLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE);
		passwordField.setBackground(secondary);
		passwordField.setForeground(primary);
		passwordField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setBackground(primary);
		phoneLabel.setForeground(secondary);
		phoneLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField phoneField = new JTextField(10);
		phoneField.setBackground(secondary);
		phoneField.setForeground(primary);
		phoneField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel birthdayLabel = new JLabel("Birthday: ");
		birthdayLabel.setBackground(primary);
		birthdayLabel.setForeground(secondary);
		birthdayLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField birthdayField = new JTextField(10);
		birthdayField.setBackground(secondary);
		birthdayField.setForeground(primary);
		birthdayField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel creditLabel = new JLabel("Credit Card Number: ");
		creditLabel.setBackground(primary);
		creditLabel.setForeground(secondary);
		creditLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField creditField = new JTextField(16);
		creditField.setBackground(secondary);
		creditField.setForeground(primary);
		creditField.setFont(new Font(font_name, Font.PLAIN, 18));

		JButton okButton = new JButton("Submit");
		okButton.setBackground(primary);
		okButton.setForeground(secondary);
		okButton.setFont(new Font(font_name, Font.PLAIN, 18));

		cust_panel.setLayout(new GridLayout(8, 2));
		cust_panel.setBackground(primary);
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

				UIManager UI = new UIManager();
				UI.put("OptionPane.background", primary);
				UI.put("Panel.background", secondary);
				UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

				JOptionPane.showMessageDialog(null,
						" Name: " + name + "\n Username: " + userName + "\n Email: " + email + "\n Password: "
								+ password + "\n Phone: " + phone + "\n Birthday: " + birthday
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
	public void createEmployee(ArrayList<Employee> employees) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";
		
		JFrame emp_frame = new JFrame("Create Employee");
		ImageIcon img = new ImageIcon("./Car.jpg");
		emp_frame.setIconImage(img.getImage());

		JPanel emp_panel = new JPanel();
		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		emp_frame.add(headerLabel, BorderLayout.PAGE_START);

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
					emp_frame.dispose();
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

		Container c = emp_frame.getContentPane();
		c.setBackground(primary);
		emp_panel.setLayout(new GridLayout(10, 2));
		emp_frame.setLocationRelativeTo(null);
		emp_frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBackground(primary);
		nameLabel.setForeground(secondary);
		nameLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE);
		nameField.setBackground(secondary);
		nameField.setForeground(primary);
		nameField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel userNameLabel = new JLabel("Username: ");
		userNameLabel.setBackground(primary);
		userNameLabel.setForeground(secondary);
		userNameLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE);
		userNameField.setBackground(secondary);
		userNameField.setForeground(primary);
		userNameField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBackground(primary);
		emailLabel.setForeground(secondary);
		emailLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE);
		emailField.setBackground(secondary);
		emailField.setForeground(primary);
		emailField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBackground(primary);
		passwordLabel.setForeground(secondary);
		passwordLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE);
		passwordField.setBackground(secondary);
		passwordField.setForeground(primary);
		passwordField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setBackground(primary);
		phoneLabel.setForeground(secondary);
		phoneLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField phoneField = new JTextField(10);
		phoneField.setBackground(secondary);
		phoneField.setForeground(primary);
		phoneField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel birthdayLabel = new JLabel("Birthday: ");
		birthdayLabel.setBackground(primary);
		birthdayLabel.setForeground(secondary);
		birthdayLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField birthdayField = new JTextField(8);
		birthdayField.setBackground(secondary);
		birthdayField.setForeground(primary);
		birthdayField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel creditLabel = new JLabel("Credit Card Number: ");
		creditLabel.setBackground(primary);
		creditLabel.setForeground(secondary);
		creditLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField creditField = new JTextField(16);
		creditField.setBackground(secondary);
		creditField.setForeground(primary);
		creditField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel hireLabel = new JLabel("Hire Date: ");
		hireLabel.setBackground(primary);
		hireLabel.setForeground(secondary);
		hireLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField hireField = new JTextField(8);
		hireField.setBackground(secondary);
		hireField.setForeground(primary);
		hireField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBackground(primary);
		salaryLabel.setForeground(secondary);
		salaryLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField salaryField = new JTextField(8);
		salaryField.setBackground(secondary);
		salaryField.setForeground(primary);
		salaryField.setFont(new Font(font_name, Font.PLAIN, 18));

		JButton okButton = new JButton("Submit");
		okButton.setBackground(primary);
		okButton.setForeground(secondary);
		okButton.setFont(new Font(font_name, Font.PLAIN, 18));

		emp_panel.setBackground(primary);
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

				employees.add(emp);
				UIManager UI = new UIManager();
				UI.put("OptionPane.background", primary);
				UI.put("Panel.background", secondary);
				UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

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
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";

		JFrame pass_frame = new JFrame("Change Password");
		ImageIcon img = new ImageIcon("./Car.jpg");
		pass_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		pass_frame.add(headerLabel, BorderLayout.PAGE_START);

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
					pass_frame.dispose();
				}
			}

			// Eclipse was freaking out when I didn't have these methods listed,  for whatever reason.
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
		JPanel pass_panel = new JPanel();

		Container c = pass_frame.getContentPane();
		c.setBackground(primary);
		pass_panel.setLayout(new GridLayout(8, 3));
		pass_panel.setBackground(primary);
		pass_frame.setLocationRelativeTo(null);
		pass_frame.setVisible(true);

		final int TEXT_FIELD_SIZE = 20;
		JLabel passLabel = new JLabel("Please enter your new password: ");
		passLabel.setBackground(primary);
		passLabel.setForeground(secondary);
		passLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField passField = new JTextField(TEXT_FIELD_SIZE);
		passField.setBackground(secondary);
		passField.setForeground(primary);
		passField.setFont(new Font(font_name, Font.PLAIN, 18));

		JLabel passLabel1 = new JLabel("Please enter your new password again: ");
		passLabel1.setBackground(primary);
		passLabel1.setForeground(secondary);
		passLabel1.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField passField1 = new JTextField(TEXT_FIELD_SIZE);
		passField1.setBackground(secondary);
		passField1.setForeground(primary);
		passField1.setFont(new Font(font_name, Font.PLAIN, 18));

		JButton okButton = new JButton("Submit");
		okButton.setBackground(primary);
		okButton.setForeground(secondary);
		okButton.setFont(new Font(font_name, Font.PLAIN, 18));

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
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));
					
					JOptionPane.showMessageDialog(null, "Passwords are not equal", "Error", JOptionPane.WARNING_MESSAGE);
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

				UIManager UI = new UIManager();
				UI.put("OptionPane.background", primary);
				UI.put("Panel.background", secondary);
				UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

				JOptionPane.showMessageDialog(null, "\n New Password: " + password1, "Information saved", JOptionPane.INFORMATION_MESSAGE, img);

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
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";

		final int TEXT_FIELD_SIZE = 20;

		JFrame cancel_frame = new JFrame("Cancel Reservation");
		ImageIcon img = new ImageIcon("./Car.jpg");
		cancel_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		cancel_frame.add(headerLabel, BorderLayout.PAGE_START);

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
					cancel_frame.dispose();
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

		Container c = cancel_frame.getContentPane();
		c.setBackground(primary);

		JPanel cancel_panel = new JPanel();
		cancel_panel.setBackground(primary);
		cancel_panel.setLayout(new GridLayout(2, 2));
		cancel_frame.setLocationRelativeTo(null);
		cancel_frame.setVisible(true);

		JLabel confirmLabel = new JLabel("Confirmation Number to cancel:  ");
		confirmLabel.setBackground(primary);
		confirmLabel.setForeground(secondary);
		confirmLabel.setFont(new Font(font_name, Font.PLAIN, 18));

		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		confirmField.setBackground(secondary);
		confirmField.setForeground(primary);
		confirmField.setFont(new Font(font_name, Font.PLAIN, 18));

		JButton okButton = new JButton("Submit");
		okButton.setBackground(primary);
		okButton.setForeground(secondary);
		okButton.setFont(new Font(font_name, Font.PLAIN, 18));

		cancel_panel.add(confirmLabel);
		cancel_panel.add(confirmField);
		cancel_panel.add(new JLabel(""));
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

						UIManager UI = new UIManager();
						UI.put("OptionPane.background", primary);
						UI.put("Panel.background", secondary);
						UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

						JOptionPane.showMessageDialog(null, "Reservation had been canceled.", "Information saved", JOptionPane.INFORMATION_MESSAGE, img);
					}
				}

				if (!found) {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, Reservation not found. Try again", "Error", JOptionPane.ERROR_MESSAGE, img);
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
    	
    	JFrame frame = new JFrame("Update Reservation Info"); 
		frame.setLayout(new GridLayout(2,2));
		frame.setLocationRelativeTo(null);
		
		JLabel confirmLabel = new JLabel("Confirmation Number to update:  "); 
		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		JButton okButton = new JButton("Submit");
		
		JLabel blank = new JLabel();
		frame.add(confirmLabel);
		frame.add(confirmField);
		frame.add(blank);
		frame.add(okButton);
		
		frame.setVisible(true);
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int number = Integer.parseInt(confirmField.getText());

				// checking to see if the entered confirmation number is an
				// actual reservation number.
				for (Reservation reservation : reservations) {
					if (reservation.getConfirmationNumber() == number) {
						found = true;
						JOptionPane.showMessageDialog(null,
								"Reservation had been found.\n " + reservation.getAttributes(),
								"Reservation Information", JOptionPane.INFORMATION_MESSAGE);

						frame.dispose();

						// make reservation no longer returns something. so yeah.
						Reservation.makeReservation(cars, reservations);
						reservations.remove(reservation);
					}
				}

				if (!found) {
					JOptionPane.showMessageDialog(null, "Reservation was not found.\n ", "Reservation Information", JOptionPane.ERROR_MESSAGE);
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
