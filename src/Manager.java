
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This is the Manager class, it holds the information that is used to create, and get information about a Manager.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Manager extends Employee {

    private double bonus;
    
    /**
     * This is the constructor, it will construct a manager with the given attributes.
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
     * @param bonus1 is the bonus the manager receives
     */
    public Manager(String name1, String username1, String email1, String password1, String phone1, String birthday1, String credit1, String hire1, int salary1, double bonus1) {
    	
        super(name1, username1, email1, password1, phone1, birthday1, credit1, hire1, salary1);

		bonus = bonus1;
    }
        
    /**
     * This method will get the bonus that the manager receives.
     * 
     * @return a double that holds the bonus this manager receives.
     */
    public double getBonus(){
        return bonus;
    }
    
    /**
     * This method will create a customer and add it to the list of customers.
     * 
     * @param customers is an array list of customers that contains every customer.
     * 
     * @return an array list of customers that contains every customer, including the newly created one.
     */
    public void createCustomer(ArrayList<Customer> customers){
    	JFrame frame = new JFrame("Create Customer"); 

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		
		frame.setLayout(new GridLayout(8,2));
		frame.add(nameLabel);
		frame.add(nameField);
		frame.add(userNameLabel);
		frame.add(userNameField);
		frame.add(emailLabel);
		frame.add(emailField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(phoneLabel);
		frame.add(phoneField);
		frame.add(birthdayLabel);
		frame.add(birthdayField);
		frame.add(creditLabel);
		frame.add(creditField);
		frame.add(new JLabel(""));
		frame.add(okButton);
		
		
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = nameField.getText(); 
				String userName = userNameField.getText(); 
				String email = emailField.getText(); 
				String password = passwordField.getText();
				String phone = phoneField.getText(); 
				String birthday = birthdayField.getText(); 
				String credit = creditField.getText(); 
				

		        Customer customer = new Customer(name, userName, email, password, phone, birthday, credit);
		        customers.add(customer);
				
				 JOptionPane.showMessageDialog(null," Name: "+ name + "\n Username: " + userName + "\n Email: " + email + "\n Password: " + 
				 password + "\n Phone: " + phone + "\n Birthday: " + birthday + "\n Credit Card Number: " + credit, "Information saved",
			  			 JOptionPane.INFORMATION_MESSAGE);
				 
				frame.dispose();
			}
		});
    }
    
    /**
     * This method will create a employee and add it to the list of employees.
     * 
     * @param customers is an array list of employees that contains every employee.
     * 
     * @return an array list of employees that contains every employee, including the newly created one.
     */
    public void createEmployee(ArrayList<Employee> employees){
    	JFrame frame = new JFrame("Create Employee"); 

		frame.setLayout(new GridLayout(10,2));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		JLabel hireLabel = new JLabel("Hire Date: "); 
		final JTextField hireField = new JTextField(8);
		JLabel salaryLabel = new JLabel("Salary: "); 
		final JTextField salaryField = new JTextField(8);
		JButton okButton = new JButton("Submit");
		
		frame.add(nameLabel);
		frame.add(nameField);
		frame.add(userNameLabel);
		frame.add(userNameField);
		frame.add(emailLabel);
		frame.add(emailField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(phoneLabel);
		frame.add(phoneField);
		frame.add(birthdayLabel);
		frame.add(birthdayField);
		frame.add(creditLabel);
		frame.add(creditField);
		frame.add(hireLabel); 
		frame.add(hireField); 
		frame.add(salaryLabel);
		frame.add(salaryField);
		frame.add(new JLabel(""));
		frame.add(okButton);
		
		
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
				
		        JOptionPane.showMessageDialog(null," Name: "+ name + "\n Username: " + userName + "\n Email: " + email + "\n Password: " + 
						 password + "\n Phone: " + phone + "\n Birthday: " + birthday + "\n Credit Card Number: " + credit + "\n Hire Date: " + hire + "\n Salary: " + salary, "Information saved",
					  			 JOptionPane.INFORMATION_MESSAGE);
		        
				frame.dispose();
			}
		});
    }
    
    /**
     * This method will change the password of the manager.
     * 
     * @param customers  customers is an array list of customers that contains every customer.
     * @param employees is an array list of employees that contains every employee.
     * @param managers is an array list of managers that contains every manager.
     * @param userName a String that contains the username of the manager.
     * 
     */
    public void changePassword(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, String userName){
    	
    	JFrame frame = new JFrame("Change Password"); 
		frame.setLayout(new GridLayout(8, 3));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		final int TEXT_FIELD_SIZE = 20; 
		JLabel passLabel = new JLabel("Please enter your new password: "); 
		final JTextField passField = new JTextField(TEXT_FIELD_SIZE); 
		JLabel passLabel1 = new JLabel("Please enter your new password again: "); 
		final JTextField passField1 = new JTextField(TEXT_FIELD_SIZE); 
		JButton okButton = new JButton("Submit");
		
		frame.add(passLabel);
		frame.add(passField);
		frame.add(passLabel1);
		frame.add(passField1);
		frame.add(okButton);
		
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
				Manager m = null;
				Employee e = null;
				Customer c = null;
				
				String password1 = passField.getText();
				String password2 = passField1.getText();
				
				if(!password1.equals(password2)){
					JOptionPane.showMessageDialog(null, "Passwords are not equal", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
		    	for(Manager manager : managers) {
		    		if(manager.getUserName().equals(userName)){
		    			m = manager;
		    		}
		    	}
		    	
		    	for(Employee employee : employees) {
		    		if(employee.getUserName().equals(userName)){
		    			e = employee;
		    		}
		    	}
		    	
		    	for(Customer customer : customers) {
		    		if(customer.getUserName().equals(userName)){
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
				
				 JOptionPane.showMessageDialog(null,"\n New Password: " + password1, "Information saved", JOptionPane.INFORMATION_MESSAGE);
				 
				 frame.dispose();
			}
		});
    }
    
    /**
     * This method will remove a reservation from the list.
     * 
     * @param reservations is an array list of reservations that contains every reservation.
     * 
     */
    public void cancelReservation(ArrayList<Reservation> reservations){

		final int TEXT_FIELD_SIZE = 20; 	
		
    	JFrame frame = new JFrame("Cancel Reservation"); 

		frame.setLayout(new GridLayout(2,2));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel confirmLabel = new JLabel("Confirmation Number to cancel:  "); 
		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		JButton okButton = new JButton("Submit");
		
		frame.add(confirmLabel);
		frame.add(confirmField);
		frame.add(new JLabel(""));
		frame.add(okButton);
		
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				
				int number = Integer.parseInt(confirmField.getText()); 
				
		    	// checking to see if the entered confirmation number is an actual reservation number.
		    	for(Reservation reservation : reservations) {
		    		if(reservation.getConfirmationNumber() == number) {
		    			found = true;
		    			
		    			reservations.remove(reservation);
		    			
		    			 JOptionPane.showMessageDialog(null,"Reservation had been canceled.", "Information saved", JOptionPane.INFORMATION_MESSAGE);
		    		}
		    	}
		    	
		    	if(!found) {
		    		 JOptionPane.showMessageDialog(null,"Sorry, Reservation not found. Try again", "Error", JOptionPane.ERROR_MESSAGE);
		    	}
		    	
				frame.dispose();
			}
		});
    }
    
    /**
     * This method will update a single aspect of a reservation
     * 
     * @param reservations is an array list of reservations that contains every reservation.
     * @param cars is an array list of cars that contains every car.
     * 
     * @return an array list of reservations that contains all the reservations.
     */
    public void updateReservation(ArrayList<Reservation> reservations, ArrayList<Car> cars) {

		final int TEXT_FIELD_SIZE = 20;
    	
    	// various variables used throughout this method
    	String ddate = null;
    	String pdate = null;
    	
    	JFrame frame = new JFrame("Update Reservation Info"); 
		frame.setLayout(new GridLayout(2,2));
		frame.setLocationRelativeTo(null);
		
		JLabel confirmLabel = new JLabel("Confirmation Number to update:  "); 
		final JTextField confirmField = new JTextField(TEXT_FIELD_SIZE);
		JButton okButton = new JButton("Submit");
		
		frame.add(confirmLabel);
		frame.add(confirmField);
		frame.add(new JLabel(""));
		frame.add(okButton);
		
		frame.setVisible(true);
		frame.pack(); 
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int number = Integer.parseInt(confirmField.getText()); 
				
		    	// checking to see if the entered confirmation number is an actual reservation number.
		    	for(Reservation reservation : reservations) {
		    		if(reservation.getConfirmationNumber() == number) {
		    			found = true;
		    			JOptionPane.showMessageDialog(null,"Reservation had been found.\n " + reservation.getAttributes(), "Reservation Information", JOptionPane.INFORMATION_MESSAGE);
		    			
		    			frame.setVisible(true);
		    			 	
		    			JLabel carLabel = new JLabel("Car: "); 
		    			final JTextField carField = new JTextField(TEXT_FIELD_SIZE);
		    			
		    			JLabel pickUpLabel = new JLabel("Pick Up Date: ");
		    			final JTextField pickUpField = new JTextField(TEXT_FIELD_SIZE); 
		    			
		    			JLabel dropOffLabel = new JLabel("Drop Off Date: ");
		    			final JTextField dropOffField = new JTextField(TEXT_FIELD_SIZE); 
		    			
		    			JLabel insureLabel = new JLabel("Insurance: ");
		    			final JTextField insureField = new JTextField(TEXT_FIELD_SIZE); 
		    			
		    			// modifying okay button to be an update button.
		    			JButton updateButton = new JButton("Update");
		    			
		    			frame.setLayout(new GridLayout(8,2));
		    			frame.add(carLabel);
		    			frame.add(carField);
		    			frame.add(pickUpLabel);
		    			frame.add(pickUpField);
		    			frame.add(insureLabel);
		    			frame.add(insureField);
		    			frame.add(new JLabel(""));
		    			frame.add(updateButton);
		    			frame.pack();
		    			
		    			updateButton.addActionListener(new ActionListener() {
		    				public void actionPerformed(ActionEvent e) {
		    					
		    					String carID = carField.getText(); 
		    					String pDate = pickUpField.getText(); 
		    					String dDate = dropOffField.getText(); 
		    					String insure = insureField.getText(); 
		    					Day d1 = Reservation.stringToDay(pdate);
		    					Day d2 = Reservation.stringToDay(ddate);
		    					
		    					Car c = null;
		    					
		    					for(Car car : cars) {
		    						if(car.getID().equals(carID)) {
		    							c = car;
		    						}
		    					}
		    					
		    					int days = d2.daysFrom(d1);
		    					double quote = days * (c.getPrice()); 
		    					
		    					for(Reservation reservation : reservations) {
		    						if(reservation.getConfirmationNumber() == number) {
		    							Reservation resv = new Reservation(carID, pDate, dDate, number, Boolean.parseBoolean(insure), String.valueOf(quote));
		    							
		    							// we remove the original one, then add the one newly updated one.
		    			    			reservations.remove(reservation);
		    			    			reservations.add(resv);
		    			    			
		    			    			JOptionPane.showMessageDialog(null,"Reservation had been updated.\n " + resv.getAttributes(), "Reservation Information", JFrame.DO_NOTHING_ON_CLOSE);
		    						}
		    					}
		    					
		    					frame.dispose();
		    				}
		    			});	
		    		}
		    	}
		    	
		    	if(!found) {
		    		 JOptionPane.showMessageDialog(null,"Reservation was not found.\n ", "Reservation Information", JOptionPane.ERROR_MESSAGE);
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
