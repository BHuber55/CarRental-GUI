
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Manager class, it holds the information that is used to create, and get information about a Manager.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Manager extends Employee {
    
    private String name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String birthday;
    private String credit;
    private String hire;
    private int salary;
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
        
        name = name1;
		username = username1;
		email = email1;
		password = password1;
		phone = phone1;
		birthday = birthday1;
		credit = credit1;
		hire = hire1;
		salary = salary1;
		bonus = bonus1;
    }
    
    /**
     * This method will get the username of the manager.
     * 
     * @retrun a String that contains the username of the manager.
     * 
     */
    public String getUsername(){
    	return username;
    }
        
    /**
     * This method will get the bonus that the manager recieves.
     * 
     * @return a double that holds the bonus this manager recieves.
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
    public ArrayList<Customer> createCustomer(ArrayList<Customer> customers){
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Please enter the name of the customer");
    	String name = in.nextLine();
    	
    	System.out.println("Please enter the username of the customers");
    	String username = in.nextLine();
    	
    	System.out.println("Please enter the email of the customer");
    	String email = in.nextLine();
    	
    	System.out.println("Please enter the password of the customer");
    	String password = in.nextLine();
    	
    	System.out.println("Please enter the phone number of the customer");
    	String phone = in.nextLine();
    	
    	System.out.println("Please enther the birthday of the customer");
    	String birthday = in.nextLine();
    	
    	System.out.println("Please enter the credit card number of the customer");
    	String credit = in.nextLine();
    	
        Customer customer = new Customer(name, username, email, password, phone, birthday, credit);
        customers.add(customer);
        
        return customers;
    }
    
    /**
     * This method will create a employee and add it to the list of employees.
     * 
     * @param customers is an array list of employees that contains every employee.
     * 
     * @return an array list of employees that contains every employee, including the newly created one.
     */
    public ArrayList<Employee> createEmployee(ArrayList<Employee> employees){
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Please enter the name of the employee");
    	String name = in.nextLine();
    	
    	System.out.println("Please enter the username of the employee");
    	String username = in.nextLine();
    	
    	System.out.println("Please enter the email of the employee");
    	String email = in.nextLine();
    	
    	System.out.println("Please enter the password of the employee");
    	String password = in.nextLine();
    	
    	System.out.println("Please enter the phone number of the employee");
    	String phone = in.nextLine();
    	
    	System.out.println("Please enther the birthday of the employee");
    	String birthday = in.nextLine();
    	
    	System.out.println("Please enter the credit card number of the employee");
    	String credit = in.nextLine();
    	
    	System.out.println("Please enther the hire date of the employee");
    	String hire = in.nextLine();

    	System.out.println("Please enter the salary of the employee");
    	int salary = in.nextInt();
    	
    	
    	Employee employee = new Employee(name, username, email, password, phone, birthday, credit, hire, salary);
        employees.add(employee);
        
     
        return employees;
    }
    
    /**
     * This method will change the password of the manager.
     * 
     * @param customers  customers is an array list of customers that contains every customer.
     * @param employees is an array list of employees that contains every employee.
     * @param managers is an array list of managers that contains every manager.
     * @param userName a String that contains the username of the manager.
     * 
     * @return
     */
    public ArrayList<Manager> changePassword(ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Manager> managers, String userName){
    	Manager m = null;
    	Employee e = null;
    	Customer c = null;
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Please enter a new password");
    	password = in.nextLine();
    	
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
    	
    	Manager manager = new Manager(m.getName(), m.getUserName(), m.getEmail(), password, m.getPhoneNumber(), m.getBirthday(), m.getCreditCardNumber(), m.getHireDate(), m.getSalary(), m.getBonus());
    	Employee employee = new Employee(e.getName(), e.getUserName(), e.getEmail(), password, e.getPhoneNumber(), e.getBirthday(), e.getCreditCardNumber(), e.getHireDate(), e.getSalary());
    	Customer customer = new Customer(c.getName(), c.getUserName(), c.getEmail(), password, c.getPhoneNumber(), c.getBirthday(), c.getCreditCardNumber());

    	managers.remove(m);
    	managers.add(manager);
    	
    	employees.remove(e);
    	employees.add(employee);
    	
    	customers.remove(c);
    	customers.add(customer);
    	
    	return managers;
    }
    
    /**
     * This method will remove a reservation from the list.
     * 
     * @param reservations is an array list of reservations that contains every reservation.
     * 
     * @return the newly updated array list of reservations
     */
    public ArrayList<Reservation> cancelReservation(ArrayList<Reservation> reservations){
    	boolean found = false;
    	
    	Scanner in = new Scanner(System.in);
    	
    	Reservation resv = null;
    	
    	System.out.println("Please enter the confirmation number of the reservation you are looking for");
    	int number = in.nextInt();
    	
    	// checking to see if the entered confirmation number is an actual reservation number.
    	for(Reservation reservation : reservations) {
    		if(reservation.getConfirmationNumber() == number) {
    			found = true;
    		}
    	}
    	
    	if(!found) {
    		System.out.println("Sorry that number was not found");
    		return reservations;
    	}
		
		for(Reservation reservation : reservations) {
			if(reservation.getConfirmationNumber() == number) {
				resv = reservation;
			}
		}
		
		reservations.remove(resv);
		
		System.out.println("The reservation has been cancelled.");
		
		return reservations;
    }
    
    /**
     * This method will update a single aspect of a reservation
     * 
     * @param reservations is an array list of reservations that contains every reservation.
     * @param cars is an array list of cars that contains every car.
     * 
     * @return an array list of reservations that contains all the reservations.
     */
    public ArrayList<Reservation> updateReservation(ArrayList<Reservation> reservations, ArrayList<Car> cars){
    	Scanner in = new Scanner(System.in);

    	Reservation resv = null;
    	Reservation resv2 = null;
    	
    	// various variables used throughout this method
    	int test = 0;
    	int user;
    	boolean found = false;
    	boolean tester = false;
    	String car_id = null;
    	String ddate = null;
    	String pdate = null;
    	Car user_car = null;
    	
    	System.out.println("Please enter the confirmation number of the reservation you are looking for");
    	int number = in.nextInt();
    	
    	// checking to see if the entered confirmation number is an actual reservation number.
    	for(Reservation reservation : reservations) {
    		if(reservation.getConfirmationNumber() == number) {
    			found = true;
    			System.out.println("The current reservation information is: ");
    			System.out.println(reservation.getAttributes());
    			System.out.println();
    		}
    	}
    	
    	if(!found) {
    		System.out.println("Sorry that number was not found");
    		return reservations;
    	}
    	
    	System.out.println("Please enter the number of the information you would like to update");
    	
    	System.out.println("1: Update car");
    	System.out.println("2: Update pick up date");
    	System.out.println("3: Update drop off date");
    	System.out.println("4: Do you want insurance?");

    	int user_input = in.nextInt();
    	
    	if(user_input == 1) {
    		// choose car
    		Car.displayVehicles(cars);
    		System.out.println("Please enter the number of the car you would like");
    		user = in.nextInt();
    		
    		user_car = cars.get(user - 1);
    		car_id = user_car.getID();
    		
    		System.out.println("the car id of the car you want is " +car_id);
    	}
    	if(user_input == 2) {
    		// choose a new date.. make sure it doesn't conflict.
    		System.out.println("Please enter a new pick up date. Formatted 11/09/1994");
    		pdate = in.nextLine();
    		pdate = in.nextLine();
    		
    		System.out.println("New = " +pdate);
    	}
    	if(user_input == 3) {
    		// choose new date.. make sure it doesn't conflict.
    		System.out.println("Please enter a new drop off date. Formatted 11/09/1994");
    		ddate = in.nextLine();
    		ddate = in.nextLine();
    		
    		System.out.println("New = " +ddate);
    	}
    	if(user_input == 4) {
    		System.out.println("Please enter 1 for yes, 2 for no");
    		test = in.nextInt();
    		
    		while(test != 1 || test != 2) {
    			System.out.println("Please choose one of the availible options.");
    			test = in.nextInt();
    		}
    		
    		if(test == 1) {
    			tester = true;
    		}
    		else {
    			tester = false;
    		}
    	}
		
		for(Reservation reservation : reservations) {
			if(reservation.getConfirmationNumber() == number) {
				resv2 = reservation;
				
				if(user_input == 1) {
					resv = new Reservation(car_id, reservation.getPickUpDate().toString(), reservation.getDropOffDate().toString(), reservation.getConfirmationNumber(), reservation.getInsurance(), String.valueOf(reservation.getQuote()));
				}
				else if(user_input == 2) {
					resv = new Reservation(reservation.getCar(), pdate, reservation.getDropOffDate().toString(), reservation.getConfirmationNumber(), reservation.getInsurance(), String.valueOf(reservation.getQuote()));
				}
				else if(user_input == 3) {
					resv = new Reservation(reservation.getCar(), reservation.getPickUpDate().toString(), ddate, reservation.getConfirmationNumber(), reservation.getInsurance(), String.valueOf(reservation.getQuote()));
				}
				else {
					resv = new Reservation(reservation.getCar(), reservation.getPickUpDate().toString(), reservation.getDropOffDate().toString(), reservation.getConfirmationNumber(), tester, String.valueOf(reservation.getQuote()));
				}
			}
		}
		
		// we remove the original one, then add the one newly updated one.
		reservations.remove(resv2);
		reservations.add(resv);
		
		System.out.println("The reservation has been updated.");
		
		return reservations;
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
