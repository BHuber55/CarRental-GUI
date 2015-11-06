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
	
	public static int loginFrame(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, ArrayList<Reservation> reservations, ArrayList<Car> cars) {
		int index = 0;
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
				
				String username = username_text_field.getText();
				String password = password_text_field.getText();
				
				final int i = Login.login(customers, username, password);
				
				try {
					login.dispose();
					Driver.mainMenu(i, cars, customers, employees, managers, reservations);
				}
				catch (IOException e1) {
					// do stuff.
				}
				
//				Customer c = customers.get(index);
//				
//				for(Customer cus : customers) {
//					if(cus.getUserName().equals(c.getUserName())){
//						C.setName(c.getName());
//						C.setUsername(c.getUserName());
//						C.setEmail(c.getEmail());
//						C.setPassword(c.getPassword());
//						C.setBirthday(c.getBirthday());
//						C.setPhoneNumber(c.getPhoneNumber());
//						C.setCreditCardNumber(c.getCreditCardNumber());
//						
//						// I can always still call main_menu here.. but meh.
//					}
//				}
				
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
//				for(Customer cus : customers) {
//					if(cus.getUserName().equals(c.getUserName())){
//						C.setName(c.getName());
//						C.setUsername(c.getUserName());
//						C.setEmail(c.getEmail());
//						C.setPassword(c.getPassword());
//						C.setBirthday(c.getBirthday());
//						C.setPhoneNumber(c.getPhoneNumber());
//						C.setCreditCardNumber(c.getCreditCardNumber());
//
//						// I can always still call main_menu here.. but meh.
//					}
//				}
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
	
	public static int login(ArrayList<Customer> customers, String username, String password) {
		boolean found = false;
		int index = 0;
		
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
}
