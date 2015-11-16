import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

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
	public static void searchByColor(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		String colors[] = { "Black", "Blue", "Green", "Orange", "Purple", "Red", "White", "Yellow" };

		JFrame search_frame = new JFrame("Search by color");
		
		JLabel prompt = new JLabel("Please choose a color.");
		
		JComboBox<String> color_choices = new JComboBox<String>(colors);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_color = (String) color_choices.getSelectedItem();
				String color = "";
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					color = car.getColor();

					if (car_color.equalsIgnoreCase(color)) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(color_choices);
		search_frame.add(select);
		
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public static void searchByModel(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle models that we have.
		String models[] = { "blah", "blah", "blah", "blah" };

		JFrame search_frame = new JFrame("Search by model");
		
		JLabel prompt = new JLabel("Please choose a model of car.");
		
		JComboBox<String> car_models = new JComboBox<String>(models);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_model = (String) car_models.getSelectedItem();
				String model = "";
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					model = car.getModel();

					if (car_model.equalsIgnoreCase(model)) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(car_models);
		search_frame.add(select);
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public static void searchByMake(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle makes that we have.
		String makes[] = { "Jeep", "Lamborghini", "Tesla", "Kia" };

		JFrame search_frame = new JFrame("Search by model");
		
		JLabel prompt = new JLabel("Please choose a model of car.");
		
		JComboBox<String> car_makes = new JComboBox<String>(makes);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_make = (String) car_makes.getSelectedItem();
				String make = "";
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					make = car.getMake();

					if (car_make.equalsIgnoreCase(make)) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(car_makes);
		search_frame.add(select);
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public static void searchByPrice(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle prices that we have.
		String prices[] = { "100", "200", "300", "400"};

		JFrame search_frame = new JFrame("Search by model");
		
		JLabel prompt = new JLabel("Please choose a model of car.");
		
		JComboBox<String> car_prices = new JComboBox<String>(prices);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double car_price = (double) car_prices.getSelectedItem();
				double price = 0;
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					price = car.getPrice();

					if (car_price == price) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(car_prices);
		search_frame.add(select);
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * 
	 * @return an array list of cars that contains the cars that match the customers constraints.
	 */
	public static void searchByMileage(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle models that we have.
		String mileages[] = { "1000", "2000", "3000", "10000", "100000" };

		JFrame search_frame = new JFrame("Search by model");
		
		JLabel prompt = new JLabel("Please choose a model of car.");
		
		JComboBox<String> car_mileages = new JComboBox<String>(mileages);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int car_mileage = (int) car_mileages.getSelectedItem();
				int mileage = 0;
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					mileage = car.getMileage();

					if (car_mileage == mileage) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(car_mileages);
		search_frame.add(select);
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
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
	public static void searchByMPG(ArrayList<Car> cars) {
		ListIterator<Car> iter = cars.listIterator();
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle models that we have.
		String MPGs[] = { "10", "20", "30", "40"};

		JFrame search_frame = new JFrame("Search by miles per gallon");
		
		JLabel prompt = new JLabel("Please select the miles per gallon your hope your car can get.");
		
		JComboBox<String> car_MPGs = new JComboBox<String>(MPGs);
		
		JButton select = new JButton("Select");
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int car_MPG = (int) car_MPGs.getSelectedItem();
				int MPG = 0;
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					MPG = car.getMileage();

					// will add cars that are as good or better than the selected MPG.
					if (car_MPG <= MPG) {
						sorted_cars.add(car);
					}
				}
				
				Car.displayVehicles(sorted_cars);
			}
		
		});

		search_frame.add(prompt);
		search_frame.add(car_MPGs);
		search_frame.add(select);
		
		search_frame.setSize(320, 200);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}
	
	public static void advancedSearch(ArrayList<Car> cars) {
		JFrame adv_search = new JFrame("Advanced Search");
		
		JLabel label = new JLabel("What criteria would you like to search by");
		
		JButton color = new JButton("Color");
		JButton make  = new JButton("Make");
		JButton model = new JButton("Model");
		JButton price = new JButton("Price");
		JButton mileage = new JButton("Mileage");
		JButton mpg = new JButton("MPG");
		
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByColor(cars);
			}
		
		});
		
		make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMake(cars);
			}
		
		});
		
		model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByModel(cars);
			}
		
		});
		
		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByPrice(cars);
			}
		
		});
		
		mileage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMileage(cars);
			}
		
		});
		
		mpg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMPG(cars);
			}
		
		});
		
		adv_search.add(label);
		adv_search.add(color);
		adv_search.add(make);
		adv_search.add(model);
		adv_search.add(price);
		adv_search.add(mileage);
		adv_search.add(mpg);
		
		adv_search.setSize(320, 200);
		adv_search.setVisible(true);
		adv_search.setLocationRelativeTo(null);
		adv_search.setLayout(new FlowLayout());
	}

	/**
	 * This method displays every car that is in the system.
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 */
	public static void displayVehicles(ArrayList<Car> cars) {
		int count = 0;
		
		JFrame frame = new JFrame("Available vehicles");
		
		String header[] = { "Model", "Year", "Make", "Color", "Price", "Mileage", "MPG"};
		Object data[][] = new Object[cars.size()][7];
		String info = "";
		List<String> list;
		
		for(Car car : cars) {
			info = car.getAttributes();
			list = Arrays.asList(info.split(", "));
			
			for(int j = 0; j < 7; j++) {
				data[count][j] = list.get(j);
			}
			
			count++;
		}

//		info = cars.get(0).getAttributes();
//		list = Arrays.asList(info.split(", "));
//		
//		for(int i = 0; i < 7; i++) {
//			data[0][i] = list.get(i);
//		}
		
		
		JTable table = new JTable(data, header) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		frame.add(table.getTableHeader());
		frame.add(table);
		
		frame.setLayout(new GridLayout(3,3));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
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
