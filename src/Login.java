import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
	
	public static Customer loginFrame(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, ArrayList<Reservation> reservations, ArrayList<Car> cars) {
		final Customer C = new Customer();
		// CREATING THE FRAME FOR LOGIN!!!
		JFrame login = new JFrame("Car Rental Name");
		
		JLabel username_label = new JLabel("Username: ");
		JLabel password_label = new JLabel("Password: ");
		
		JTextField username_text_field = new JTextField(15);
		JTextField password_text_field = new JTextField(15);
		
		JButton login_button = new JButton("Login");
		JButton create_button = new JButton("Create Account");
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if the user click 'login' we will check their information.
				
				// I really just want to return a 1 here so that way the driver will execute the login method.
				// same concept for the below listener.
				
				
				/* okay so here is a thought I just had.. Put all of main inside of this.
				 * This is going to be absolutely terrible coding practice.. but it should* work.
				 * 
				 * Basically what I could do is convert the 'menu' to a method and call it inside of here.
				 * However I would have to do the same even for the other button.. but I would first have 
				 * to create the users new account and then call the menu method.. 
				 * 
				 * again should work however I am not 100% sure that is the way to go.
				 */
				
				// okay so the initial way I tried
				String username = username_text_field.getText();
				String password = password_text_field.getText();
				
				Customer c = Login.login(customers, username, password);
				
//				for(Customer cus : customers) {
//					if(cus.getUserName().equals(c.getUserName())){
//						C.setName("Testing");
//						C.setUsername(c.getUserName());
//						C.setEmail(c.getEmail());
//						C.setPassword(c.getPassword());
//						C.setBirthday(c.getBirthday());
//						C.setPhoneNumber(c.getPhoneNumber());
//						C.setCreditCardNumber(c.getCreditCardNumber());
//					}
//				}
				
				
			}
		});
		
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if they choose to create a new account.. we do that.
				
				Customer CUSTOMER = Customer.createNewCustomer(customers);				
				// ^^^^^ that is the error. 
				// "Local variable CUSTOMER defined in an enclosing scope must be final or effectively final"
				try {
					login.dispose();
					Driver.mainMenu(CUSTOMER, cars, customers, employees, managers, reservations);
				}
				catch (IOException e1) {
					// I don't know why we have this.
				}
			}
		});
		
		login.add(username_label);
		login.add(username_text_field);
		
		login.add(password_label);
		login.add(password_text_field);
		
		login.add(login_button);
		login.add(create_button);
		
		login.setSize(300, 200);
		login.setLayout(new FlowLayout());
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
		
		return C;
	}
	
	public static Customer login(ArrayList<Customer> customers, String username, String password) {
		boolean found = false;
		
		Customer CUSTOMER = null;
		
		for(Customer customer : customers) {
			if(customer.getUserName().equals(username)) {
				found = true;

				if(customer.getPassword().equals(password)) {
					CUSTOMER = customer;
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is incorrect", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
		if(!found) {
			JOptionPane.showMessageDialog(null, "Username was not found.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		// This was just quickly done just so I know what I want to do later.
		
		return CUSTOMER;
	}
}
