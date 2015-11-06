import java.util.ArrayList;
import java.util.ListIterator;

public class Car {

	private String model;
	private int year;
	private String make;
	private String color;
	private double price;
	private int mileage;
	private int mpg;
	private String id;

	/**
	 * This is the constructor of the Car class
	 * 
	 * @param model1
	 *            is the model of the car
	 * @param year1
	 *            is the year of the car
	 * @param make1
	 *            is the make of the car
	 * @param color1
	 *            is the color of the car
	 * @param price1
	 *            is the price per day of the car
	 * @param mileage1
	 *            is the mileage of the car
	 * @param mpg1
	 *            is the MPG of the car
	 * @param id1
	 *            is the id of the car
	 */
	public Car(String model1, int year1, String make1, String color1, double price1, int mileage1, int mpg1, String id1) {
		model = model1;
		year = year1;
		make = make1;
		color = color1;
		price = price1;
		mileage = mileage1;
		mpg = mpg1;
		id = id1;
	}

	/**
	 * Will get and return the model of this car.
	 * 
	 * @return a String that holds the model of the car.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Will get and return the year of this car.
	 * 
	 * @return a int that holds the year of the car.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Will get and return the make of this car.
	 * 
	 * @return a String that holds the make of the car.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Will get and return the color of this car.
	 * 
	 * @return a String that holds the color of the car.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Will get and return the price of this car.
	 * 
	 * @return a double that holds the price of the car.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Will get and return the mileage on this car.
	 * 
	 * @return a int that holds the mileage on the car.
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * Will get and return the Miles Per Gallon of this car.
	 * 
	 * @return a int that holds the Miles Per Gallon of the car.
	 */
	public int getMPG() {
		return mpg;
	}

	/**
	 * Will get and return the ID of this car.
	 * 
	 * @return a String that holds the ID of the car.
	 */
	public String getID() {
		return id;
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param color
	 *            is the color that the user would like.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByColor(ArrayList<Car> cars, String color) {
		ListIterator<Car> iter = cars.listIterator();

		String car_color = "blue";
		Car car = null;
		ArrayList<Car> carsByColor = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_color = car.getModel();

			if (car_color.equalsIgnoreCase(color)) {
				carsByColor.add(car);
			}
		}
		return carsByColor;

	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param model
	 *            is the model of car that the customer wants.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByModel(ArrayList<Car> cars, String model) {
		ListIterator<Car> iter = cars.listIterator();

		String car_model = "rio";
		Car car = null;
		ArrayList<Car> carsByModel = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_model = car.getModel();

			if (car_model.equalsIgnoreCase(model)) {
				carsByModel.add(car);
			}
		}

		return carsByModel;

	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param make
	 *            is the make of car that the customer wants
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByMake(ArrayList<Car> cars, String make) {
		ListIterator<Car> iter = cars.listIterator();

		String car_make = "kia";
		Car car = null;
		ArrayList<Car> carsByMake = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_make = car.getModel();

			if (car_make.equalsIgnoreCase(make)) {
				carsByMake.add(car);
			}
		}
		return carsByMake;
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param price
	 *            is the price of the car that the customer wants.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByPrice(ArrayList<Car> cars, double price) {
		ListIterator<Car> iter = cars.listIterator();

		double car_price = 120;
		Car car = null;
		ArrayList<Car> carsByPrice = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_price = car.getPrice();

			if (car_price == price) {
				carsByPrice.add(car);
			}
		}
		return carsByPrice;
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param mileage
	 *            is the mileage on the car that the customer wants.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByMileage(ArrayList<Car> cars, int mileage) {
		ListIterator<Car> iter = cars.listIterator();

		int car_mileage = 12;
		Car car = null;
		ArrayList<Car> carsByMileage = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_mileage = car.getMileage();

			if (car_mileage == mileage) {
				carsByMileage.add(car);
			}
		}

		return carsByMileage;
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * @param milesPerGallon
	 *            is the MPG of the car that the customer wants.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public ArrayList<Car> searchByMPG(ArrayList<Car> cars, int milesPerGallon) {
		ListIterator<Car> iter = cars.listIterator();

		int car_MPG = 30;
		Car car = null;
		ArrayList<Car> carsByMPG = new ArrayList<>();

		while (iter.hasNext()) {
			car = iter.next();
			car_MPG = car.getMPG();

			if (car_MPG == milesPerGallon) {
				carsByMPG.add(car);
			}
		}
		return carsByMPG;
	}

	/**
	 * This method displays every car that is in the system.
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 */
	public static void displayVehicles(ArrayList<Car> cars) {
		int count = 1;

		for (Car car : cars) {
			System.out.print(count + ": ");
			System.out.println(car.getAttributes());
			count++;
		}
	}

	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
	public String getAttributes() {
		String info = getModel() + ", " + getYear() + ", " + getMake() + ", " + getColor() + ", " + getPrice() + ", " + getMileage() + ", " + getMPG() + ", " + getID();

		return info;
	}
}
