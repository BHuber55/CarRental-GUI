
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Employee class, it holds the information that is used to create, and get information about a employee.
 * 
 * @version 1.0
 * @author Loro Dumo, Brennan Huber, William Thompson, Peter Way
 *
 */
public class Employee extends Customer {

	private String name;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String birthday;
	private String credit;
	private int salary;
	private String hire;

	ArrayList<Employee> employees = new ArrayList<Employee>();

	/**
	 * This is the constructor of Employee. It will construct a manager with the given attributes.
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
	 */
	public Employee(String name1, String username1, String email1, String password1, String phone1, String birthday1, String credit1, String hire1, int salary1) {
		
		super(name1, username1, email1, password1, phone1, birthday1, credit1);

		name = name1;
		username = username1;
		email = email1;
		password = password1;
		phone = phone1;
		birthday = birthday1;
		credit = credit1;
		salary = salary1;
		hire = hire1;
	}

	/**
	 * This method will get the username of this employee
	 * 
	 * @return a string containing the username of the employee
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * This method will get the salary of this employee
	 * 
	 * @return a int containing the salary of the employee
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * This method will get the hire date of this employee
	 * 
	 * @return a string containing the hire date of the employee
	 */
	public String getHireDate() {
		return hire;
	}

	/**
	 * This method will allow the employee to update one aspect of the car.
	 * 
	 * @param cars is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars the contains every car, including the newly updated one.
	 */
	public ArrayList<Car> updateVehicle(ArrayList<Car> cars) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the ID of the car you wish to update.");
		String car_id = in.nextLine();
		
		System.out.println("What would you like to update?");
		System.out.println("1: Car Model");
		System.out.println("2: Car Year");
		System.out.println("3: Car Make");
		System.out.println("4: Car Color");
		System.out.println("5: Car Price");
		System.out.println("6: Car Mileage");
		System.out.println("7: Car MPG");
		int user = in.nextInt();
		
		System.out.println("Pleas enter the new information");
		String new_info = in.nextLine();
		new_info = in.nextLine();
		
		Car new_car = null;
		
		for(Car car : cars) {
			if(car.getID().equals(car_id)) {
				// remove this car and 
				cars.remove(car);
				if(user == 1) {
					new_car = new Car(new_info, car.getYear(), car.getMake(), car.getColor(), car.getPrice(), car.getMileage(), car.getMPG(), car.getID());
				}
				else if(user == 2) {
					new_car = new Car(car.getModel(), Integer.parseInt(new_info), car.getMake(), car.getColor(), car.getPrice(), car.getMileage(), car.getMPG(), car.getID());
				}
				else if(user == 3) {
					new_car = new Car(car.getModel(), car.getYear(), new_info, car.getColor(), car.getPrice(), car.getMileage(), car.getMPG(), car.getID());
				}
				else if(user == 4) {
					new_car = new Car(car.getModel(), car.getYear(), car.getMake(), new_info, car.getPrice(), car.getMileage(), car.getMPG(), car.getID());
				}
				else if(user == 5) {
					new_car = new Car(car.getModel(), car.getYear(), car.getMake(), car.getColor(), Integer.parseInt(new_info), car.getMileage(), car.getMPG(), car.getID());
				}
				else if(user == 6) {
					new_car = new Car(car.getModel(), car.getYear(), car.getMake(), car.getColor(), car.getPrice(), Integer.parseInt(new_info), car.getMPG(), car.getID());
				}
				else {
					new_car = new Car(car.getModel(), car.getYear(), car.getMake(), car.getColor(), car.getPrice(), car.getMileage(), Integer.parseInt(new_info), car.getID());
				}
				
				cars.add(new_car);
				break;
			}
		}
		
		System.out.println("Car has been updated.");
		
		return cars;
	}

	/**
	 * This method will allow the employee to add a new vehicle to the list of vehicles.
	 * 
	 * @param cars is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars the contains every car, including the newly created one.
	 */
	public ArrayList<Car> registerNewVehicle(ArrayList<Car> cars) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the Model of the car");
		String model = in.nextLine();
		
		System.out.println("Please enter the Year of the car");
		int year = in.nextInt();
		
		System.out.println("Please enter the Make of the car");
		String make = in.nextLine();
		make = in.nextLine();
		
		System.out.println("Please enter the color of the car");
		String color = in.nextLine();
		
		System.out.println("Please enter the Price of the car");
		int price = in.nextInt();
		
		System.out.println("Please enter the mileage of the car");
		int mileage = in.nextInt();
		
		System.out.println("Please enter the MPG of the car");
		int mpg = in.nextInt();
		
		System.out.println("Please enter the ID of the car");
		String id = in.nextLine();
		id = in.nextLine();
		
	   	for(Car car : cars) {
    		while(car.getID() == id) {
    			System.out.println("Sorry that number is already in use. Please enter another");
    			id = in.nextLine();
    		}
    	}
		
		Car car = new Car(model, year, make, color, price, mileage, mpg, id);
		
		cars.add(car);
		
		System.out.println("Vehicle has been registed.");
		
		return cars;
	}

	/**
	 * This method will remove a selcted car from the list of cars
	 * 
	 * @param cars an array list of cars the contains every car
	 * 
	 * @return  an array list of cars the contains every car, excluding the one that gets deleted.
	 */
	public ArrayList<Car> deleteVehicle(ArrayList<Car> cars) {
		boolean found = false;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the ID of the car you wish to delete.");
		String number = in.nextLine();
		
    	// checking to see if the entered  number is an actual id number.
    	for(Car car : cars) {
    		if(car.getID() == number) {
    			found = true;
    		}
    	}
    	
    	if(found == false) {
    		System.out.println("Sorry that number was not found");
    		return cars;
    	}
		
		for(Car car : cars) {
			if(car.getID().equals(number)) {
				cars.remove(car);
				break;
			}
		}
		
		System.out.println("Vehicle has been deleted.");
		
		return cars;
	}

	/**
	 * This method will display every customer in the list.
	 * 
	 * @param customers  an array list of customers the contains every customer.
	 * 
	 * @return  an array list of customers the contains every c, including the newly updated one.
	 */
	public ArrayList<Customer> displayAllCustomers(ArrayList<Customer> customers) {
		
		for(Customer customer : customers) {
			System.out.println(customer.getAttributes());
		}
		
		return customers;
	}

	/**
	 * This will display the information about a customers previous reservations.
	 * 
	 * @param customers is an array list of customers that contains every customer.
	 */
//	public void viewCustomerRecord(ArrayList<Customer> customers) {
//		Scanner in = new Scanner(System.in);
//		
//		System.out.println("Please enter the username of the customer you are looking for");
//		String username = in.nextLine();
//		
//		for(Customer customer : customers) {
//			if(customer.getUserName().equals(username)) {
//				ArrayList<Reservation> reservations = customer.getReservations();
//				for(Reservation reservation : reservations) {
//					System.out.println(reservation.getAttributes());
//				}
//			}
//		}
//	}

	/**
	 * This method will find and print information about a certain reservation
	 * 
	 * @param reservations is an array list of reservations that contains every reservation.
	 */
	public void findByConfirmationNumber(ArrayList<Reservation> reservations) {
		boolean found = false;
    	Scanner in = new Scanner(System.in);
    	
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
    		return;
    	}
    	
		for(Reservation reservation : reservations) {
			if(reservation.getConfirmationNumber() == number) {
				System.out.println(reservation.getAttributes());
			}
		}
	}

	// still by reservation number, but this one displays it while the one above returns it to be modified.
	/**
	 * This method will find a certain reservation and print the information.
	 * 
	 * @param reservations reservations is an array list of reservations that contains every reservation.
	 * @param cars cars is an array list of cars that contains every car.
	 */
	public void reviewReservation(ArrayList<Reservation> reservations, ArrayList<Car> cars) {
		boolean found = false;
    	Scanner in = new Scanner(System.in);
    	
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
    		return;
    	}

		for(Reservation reservation : reservations) {
			if(reservation.getConfirmationNumber() == number) {
				// System.out.println(reservation.getAttributes());
				Reservation.makeReservationReport(reservation, cars);
			}
		}
	}
	
	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
    public String getAttributes() {
    	String info = getName() + ", " + getUserName() + ", " + getEmail() + ", " + getPassword() + ", " + getPhoneNumber() + ", " + getBirthday() + ", " + getCreditCardNumber() + ", " + getHireDate() + ", " + getSalary();
    	
    	return info;
    }
}
