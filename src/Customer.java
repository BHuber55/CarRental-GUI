import java.awt.BorderLayout;
import java.awt.Color;
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

	public Customer() {
		
	}
	
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
	
	public void setName(String n) {
		name = n;
	}
	
	public void setUsername(String u) {
		username = u;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public void setPhoneNumber(String p) {
		phoneNumber = p;
	}
	
	public void setBirthday(String b) {
		birthday = b;
	}
	
	public void setCreditCardNumber(String c) {
		creditCardNumber = c;
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
	 */
	public static void createNewCustomer(ArrayList<Customer> customers) {

		JFrame frame = new JFrame("Create new Customer"); 
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//change this to wherever your workspace is
		ImageIcon img = new ImageIcon("./Car.jpg");
		frame.setIconImage(img.getImage());
		
		final int TEXT_FIELD_SIZE = 20; 	
		JLabel nameLabel = new JLabel("Name: "); 
		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel userNameLabel = new JLabel("Username: ");
		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel emailLabel = new JLabel("Email: ");
		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel passwordLabel = new JLabel("Password: ");
		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel phoneLabel = new JLabel("Phone Number: ");
		final JTextField phoneField = new JTextField(10); 
		JLabel birthdayLabel = new JLabel("Birthday: ");
		final JTextField birthdayField = new JTextField(8); 
		JLabel creditLabel = new JLabel("Credit Card Number: ");
		final JTextField creditField = new JTextField(16); 
		JButton okButton = new JButton("Submit");
	
		//all the formatting that one could ever need.
        frame.setBackground(Color.BLACK);
         
        nameLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        nameLabel.setForeground(Color.DARK_GRAY);
        nameField.setBackground(Color.DARK_GRAY);
        nameField.setForeground(Color.WHITE);
        userNameLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        userNameLabel.setForeground(Color.GRAY);
        userNameField.setBackground(Color.DARK_GRAY);
        userNameField.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        emailLabel.setForeground(Color.DARK_GRAY);
        emailField.setBackground(Color.DARK_GRAY);
        emailField.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        passwordLabel.setForeground(Color.GRAY);
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        phoneLabel.setForeground(Color.DARK_GRAY);
        phoneField.setBackground(Color.DARK_GRAY);
        phoneField.setForeground(Color.WHITE);
        birthdayLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        birthdayLabel.setForeground(Color.GRAY);
        birthdayField.setBackground(Color.DARK_GRAY);
        birthdayField.setForeground(Color.WHITE);
        creditLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        creditLabel.setForeground(Color.DARK_GRAY);
        creditField.setBackground(Color.DARK_GRAY);
        creditField.setForeground(Color.WHITE);
        okButton.setBackground(Color.RED);
         
        //change this to wherever your workspace is. 
        JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
        frame.add(headerLabel, BorderLayout.NORTH);
         
         
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(8,2));
        panel.setBackground(Color.BLACK);
         
         
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(userNameLabel);
		panel.add(userNameField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(phoneLabel);
		panel.add(phoneField);
		panel.add(birthdayLabel);
		panel.add(birthdayField);
		panel.add(creditLabel);
		panel.add(creditField);
		panel.add(new JLabel(""));
		panel.add(okButton);
		frame.add(panel);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText(); 
				String userName = userNameField.getText(); 
				String email = emailField.getText(); 
				String pass = passwordField.getText();
				String phone = phoneField.getText(); 
				String birth = birthdayField.getText(); 
				String credit = creditField.getText(); 

				boolean found = findUsername(customers, userName);
				
				// if the username is not already taken.
				if(!found) {
					 UIManager UI = new UIManager();
					 UI.put("OptionPane.background", Color.DARK_GRAY);
					 UI.put("Panel.background", Color.RED);
					 UI.put("OptionPane.messageFont", new FontUIResource(new Font("High Tower Text", Font.PLAIN, 13))); 
	
	
					Customer customer = new Customer(name, userName, email, pass, phone, birth, credit);
					customers.add(customer);
					
					//final public static int index = customers.indexOf(customer);
				        
					 JOptionPane.showMessageDialog(null,
							 " Name: "+ name
							 + "\n Username: " + userName
							 + "\n Email: " + email
							 + "\n Password: " + pass
							 + "\n Phone: " + phone
							 + "\n Birthday: " + birth
							 + "\n Credit Card Number: " + credit,
							 "Information Saved",
				  			 JOptionPane.INFORMATION_MESSAGE, img);
				} else {
					// tell the user his chosen username is taken.
					JOptionPane.showMessageDialog(null,  "Sorry that username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//return index;
		
        headerLabel.addMouseListener(new MouseListener() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
    	    	    
	    	    //this is where it picks up on the menu button. 
	    	    if(x > 670 && x < 800 && y > 226 && y < 250) {
					// Originally had the x and y printed out to make sure i had the dimensions right
					// System.out.println(x+ " " + y);

					// just change this line of code to match the frame you want closed.
					// For the love of all that is holy, DO NOT use the same name for the main frame vs everything else!
					frame.dispose();
	    	    }
    	    }
 
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
	}
	
	/**
	 * This is a method that will determines if the customer's entered username was found in the list of customers.
	 * 
	 * @param customers
	 *            is to be the array list of customers that contains every customer.
	 * @param username
	 *            is the be the username of that is to be found.
	 * 
	 * @return a boolean that return true is the username is found, false if the username is not found.
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
	 * This method will update this customer profile information.
	 * @param customers
	 * 			an array list of customers that contains every customer.
	 * @param index
	 * 			an int that holds the index of the customer in the array list that is also passed in.
	 */
	public void updateProfile(int index, ArrayList<Customer> customers) {
		customers.remove(index);
		JFrame frame = new JFrame("Update Customer Info"); 
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//change this to wherever your workspace is
		ImageIcon img = new ImageIcon("./Car.jpg");
		frame.setIconImage(img.getImage());
		
		final int TEXT_FIELD_SIZE = 20; 	
		JLabel nameLabel = new JLabel("Name: "); 
		final JTextField nameField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel userNameLabel = new JLabel("Username: ");
		final JTextField userNameField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel emailLabel = new JLabel("Email: ");
		final JTextField emailField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel passwordLabel = new JLabel("Password: ");
		final JTextField passwordField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel phoneLabel = new JLabel("Phone Number: ");
		final JTextField phoneField = new JTextField(10); 
		JLabel birthdayLabel = new JLabel("Birthday: ");
		final JTextField birthdayField = new JTextField(8); 
		JLabel creditLabel = new JLabel("Credit Card Number: ");
		final JTextField creditField = new JTextField(16); 
		JButton okButton = new JButton("Submit");
	
		//all the formatting that one could ever need.
        frame.setBackground(Color.BLACK);
         
        nameLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        nameLabel.setForeground(Color.DARK_GRAY);
        nameField.setBackground(Color.DARK_GRAY);
        nameField.setForeground(Color.WHITE);
        userNameLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        userNameLabel.setForeground(Color.GRAY);
        userNameField.setBackground(Color.DARK_GRAY);
        userNameField.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        emailLabel.setForeground(Color.DARK_GRAY);
        emailField.setBackground(Color.DARK_GRAY);
        emailField.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        passwordLabel.setForeground(Color.GRAY);
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        phoneLabel.setForeground(Color.DARK_GRAY);
        phoneField.setBackground(Color.DARK_GRAY);
        phoneField.setForeground(Color.WHITE);
        birthdayLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        birthdayLabel.setForeground(Color.GRAY);
        birthdayField.setBackground(Color.DARK_GRAY);
        birthdayField.setForeground(Color.WHITE);
        creditLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
        creditLabel.setForeground(Color.DARK_GRAY);
        creditField.setBackground(Color.DARK_GRAY);
        creditField.setForeground(Color.WHITE);
        okButton.setBackground(Color.RED);
         
        //change this to wherever your workspace is. 
        JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
        frame.add(headerLabel, BorderLayout.NORTH);
         
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(8,2));
        panel.setBackground(Color.BLACK);
         
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(userNameLabel);
		panel.add(userNameField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(phoneLabel);
		panel.add(phoneField);
		panel.add(birthdayLabel);
		panel.add(birthdayField);
		panel.add(creditLabel);
		panel.add(creditField);
		panel.add(new JLabel(""));
		panel.add(okButton);
		frame.add(panel);
		
		frame.pack();
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer C = customers.get(index);
				
				String name = nameField.getText();
				String user = userNameField.getText();
				String email = emailField.getText();
				String pass = passwordField.getText();
				String phone = phoneField.getText();
				String birth = birthdayField.getText();
				String credit = creditField.getText();
				
				boolean found = findUsername(customers, user);
				
				if(!found) {
					if(name.equals(null)) {
						name = C.getName();
					}
					if(user.equals(null)) {
						user = C.getUserName();
					}
					if(email.equals(null)) {
						email = C.getEmail();
					}
					if(pass.equals(null)) {
						pass = C.getPassword();
					}
					if(phone.equals(null)) {
						phone = C.getPhoneNumber();
					}
					if(birth.equals(null)) {
						birth = C.getBirthday();
					}
					if(credit.equals(null)) {
						credit = C.getCreditCardNumber();
					}
	
			        Customer customer = new Customer(name, user, email, pass, phone, birth, credit);
			        customers.add(customer);
				} else {
					// tell the user his chosen username is taken.
					JOptionPane.showMessageDialog(null,  "Sorry that username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} 	
		});
        
        headerLabel.addMouseListener(new MouseListener() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
    	    	    
	    	    //this is where it picks up on the menu button. 
	    	    if(x > 670 && x < 800 && y > 226 && y < 250) {
					// Originally had the x and y printed out to make sure i had the dimensions right
					// System.out.println(x+ " " + y);

					// just change this line of code to match the frame you want closed.
					// For the love of all that is holy, DO NOT use the same name for the main frame vs everything else!
					frame.dispose();
	    	    }
    	    }
 
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
	}
	
	/**
	 * This method will call the make reservation method and will print the new confirmation number.
	 * 
	 * @param cars
	 *            is to be an array list of cars that contains every car.
	 * @param reservations
	 *            is to be an array list of reservation that contains every reservation.
	 * 
	 */
	public void makeReservation(ArrayList<Car> cars, ArrayList<Reservation> reservations) {
		String username = this.getUserName();
		
		Reservation.makeReservation(cars, reservations, username);
	}

	public void displayReservationHistory(ArrayList<Reservation> reservations) {
		ArrayList<Reservation> user_history = new ArrayList<Reservation>();
		
		for(Reservation R : reservations) {
			if(this.getUserName().equals(R.getUserName())) {
				user_history.add(R);
			}
		}
		
		// should make a table to display this stuff.
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
