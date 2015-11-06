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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Driver<T> {

	public static void main(String args[]) throws IOException {
		// various local variables used throughout main.
		String username = "testing";
		String beg_emp = "E_";
		String beg_man = "M_";
		int user_input = 0;
		
		// initializing a scanner for user input.
		Scanner in = new Scanner(System.in);
		
		// This is to hold the information of the person using the system.
		Customer CUSTOMER = null;
		Employee EMPLOYEE = null;
		Manager MANAGER = null;

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

		CUSTOMER = Login.loginFrame(customers);
		
		System.out.println("WE HAVE GOTTEN HERE.. THE USERNAME OF SAID CUSTOMER IS " +CUSTOMER.getUserName());
		
//		if (user_input == 1) {
//			CUSTOMER = login(customers);
//			username = CUSTOMER.getUserName();
//			// user has logged in.
//		}
//		
//		if (user_input == 2) {
//			CUSTOMER = Customer.createNewCustomer(customers);
//			customers.add(CUSTOMER);
//			username = CUSTOMER.getUserName();
//		}

		// checking if user is an employee or manager
		String beginning = username.substring(0, 2);
		
		while (user_input != 0) {
			
			// display everything for customer
			System.out.println();
			System.out.println();
			System.out.println("Do you want to:");

			System.out.println("1. Logout");
			System.out.println("2. Update Profile");
			System.out.println("3. Make Reservation");

			if ( !(beginning.equals(beg_emp)) && !(beginning.equals(beg_man))) {
				user_input = in.nextInt();
				
				while (user_input > 3 || user_input < 0) {
					System.out.println("Please choose one of the availible options");
					
					user_input = in.nextInt();
				}
			}

			// if the start of the username is a E_ or M_ then they are an employee or manager
			// and only they have access to these methods.
			if (beginning.equals(beg_emp) || beginning.equals(beg_man)) {
				// display employee methods
				System.out.println("4. Register New Vehicle");
				System.out.println("5. Update a Vehicle");
				System.out.println("6. Delete Vehicle");
				System.out.println("7. Display All Customers");
				//System.out.println("7. View Customer Record");
				System.out.println("8. Find Reservation by Confirmation Number");
				System.out.println("9. Review Reservation");
				
				// if it begins with an 'E_' then they are an employee.
				if (beginning.equals(beg_emp)) {
					
					user_input = in.nextInt();
					// setting the current user as an employee.
					for (Employee employee : employees) {

						if (employee.getUserName().equals(username)) {
							EMPLOYEE = employee;
						}
					}

					while (user_input > 9 || user_input < 0) {
						System.out.println("Please choose one of the availible options");
						
						user_input = in.nextInt();
					}
				}
				
				// if it begins with a 'M_' then they are a manger
				if (beginning.equals(beg_man)) {
					// display manager methods
					System.out.println("10. Create Customer");
					System.out.println("11. Create Employee");
					System.out.println("12. Make Reservation For Customer");
					System.out.println("13. Change Password");
					System.out.println("14. Cancel Reservation");
					System.out.println("15. Update Reservation");
					System.out.println();
					
					user_input = in.nextInt();

					while(user_input > 15 || user_input < 1) {
						System.out.println("Plese choose one of the availible options");
						
						user_input = in.nextInt();
					}
					
					// setting the current user as a manager.
					for (Manager manager : managers) {
						if (manager.getUserName().equals(CUSTOMER.getUserName())) {
							MANAGER = manager;
						}
					}
				}
			}

			if (user_input > 15 || user_input < 0) {
				while (user_input > 15 || user_input < 0) {
					System.out.println("Please choose one of the availible options");
					user_input = in.nextInt();
				}
			}
			
			else if (user_input == 1) {
				// then the user wants to logout.. so we need to save the information.
				// writing each class and every attribute to a file.
				writeFile(FILE_CARS, cars);
				writeFile(FILE_CUSTOMERS, customers);
				writeFile(FILE_EMPLOYEES, employees);
				writeFile(FILE_MANAGERS, managers);
				writeFile(FILE_RESERVATIONS, reservations);
				
				System.out.println("Thank you for using out rental service!");
				
				// exits the program.
				return;
			}
			
			else if (user_input == 2) {
				// remove the first customer.
				customers.remove(CUSTOMER);
				
				// then we modify the current customer
				CUSTOMER = CUSTOMER.updateProfile();
				
				// now we add the modified customer back to the list.
				customers.add(CUSTOMER);
			}
			
			else if (user_input == 3) {
				System.out.println("Customer attributes" +CUSTOMER.getAttributes());
				reservations = CUSTOMER.makeReservation(cars, reservations);
			}
			
			else if (user_input == 4) {
				if (beginning.equals(beg_emp)) {
					cars = EMPLOYEE.registerNewVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					cars = MANAGER.registerNewVehicle(cars);
				}
			}
			
			else if (user_input == 5) {
				if (beginning.equals(beg_emp)) {
					cars = EMPLOYEE.updateVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					cars = MANAGER.updateVehicle(cars);
				}
			}
			
			else if (user_input == 6) {
				if (beginning.equals(beg_emp)) {
					cars = EMPLOYEE.deleteVehicle(cars);
				}
				if (beginning.equals(beg_man)) {
					cars = MANAGER.deleteVehicle(cars);
				}
			}
			
			else if (user_input == 7) {
				if (beginning.equals(beg_emp)) {
					customers = EMPLOYEE.displayAllCustomers(customers);
				}
				if (beginning.equals(beg_man)) {
					customers = MANAGER.displayAllCustomers(customers);
				}
			}
			
//			else if (user_input == 7) {
//				if (beginning.equals(beg_emp)) {
//					EMPLOYEE.viewCustomerRecord(customers);
//				}
//				if (beginning.equals(beg_man)) {
//					MANAGER.viewCustomerRecord(customers);
//				}
//			}
			
			else if (user_input == 8) {
				if (beginning.equals(beg_emp)) {
					EMPLOYEE.findByConfirmationNumber(reservations);
				}
				if (beginning.equals(beg_man)) {
					MANAGER.findByConfirmationNumber(reservations);
				}
			}
			
			else if (user_input == 9) {
				if (beginning.equals(beg_emp)) {
					EMPLOYEE.reviewReservation(reservations, cars);
				}
				if (beginning.equals(beg_man)) {
					MANAGER.reviewReservation(reservations, cars);
				}
			}
			
			else if (user_input == 10) {
				if (beginning.equals(beg_man)) {
					customers = MANAGER.createCustomer(customers);
				}
			}
			
			else if (user_input == 11) {
				if (beginning.equals(beg_man)) {
					employees = MANAGER.createEmployee(employees);
				}
			}
			
			else if (user_input == 12) {
				if (beginning.equals(beg_man)) {
					reservations = MANAGER.makeReservation(cars, reservations);
				}
			}
			
			else if (user_input == 13) {
				if (beginning.equals(beg_man)) {
					managers = MANAGER.changePassword(customers, employees, managers, MANAGER.getUserName());
				}
			}
			
			else if (user_input == 14) {
				if (beginning.equals(beg_man)) {
					reservations = MANAGER.cancelReservation(reservations);
				}
			}
			
			else if (user_input == 15) {
				if (beginning.equals(beg_man)) {
					reservations = MANAGER.updateReservation(reservations, cars);
				}
			}
			
			// going to add this to write to file after each choice was selected and completed.
			writeFile(FILE_CARS, cars);
			writeFile(FILE_CUSTOMERS, customers);
			writeFile(FILE_EMPLOYEES, employees);
			writeFile(FILE_MANAGERS, managers);
			writeFile(FILE_RESERVATIONS, reservations);
		}
		// outside the while loop.
		
		in.close();
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
	public static <T> void writeFile(String file_name, ArrayList<T> items) throws IOException {
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
