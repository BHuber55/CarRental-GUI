import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

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
	 * This is a method that will create a menu so the user can select what criteria he would like to search by.
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 */
	public static void advancedSearch(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);
		String font_name = "Harlow Solid Italic";
		
		JFrame adv_search = new JFrame("Advanced Search");

		ImageIcon img = new ImageIcon("./Car.jpg");
		adv_search.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		adv_search.add(headerLabel, BorderLayout.NORTH);

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
					adv_search.dispose();
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

		Container c = adv_search.getContentPane();
		c.setBackground(primary);

		JLabel label = new JLabel("What criteria would you like to search by");
		label.setBackground(primary);
		label.setForeground(secondary);
		label.setFont(new Font(font_name, Font.PLAIN, 18));
	

		JButton color = new JButton("Color");
		

		JButton make = new JButton("Make");

		JButton model = new JButton("Model");

		JButton price = new JButton("Price");

		JButton mileage = new JButton("Mileage");

		JButton mpg = new JButton("MPG");

		JButton none = new JButton("None");

		color.setOpaque(false);
		color.setContentAreaFilled(false);
		color.setBorderPainted(false);
		color.setBackground(primary);
		color.setForeground(secondary);
		color.setFont(new Font(font_name, Font.PLAIN, 18));
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByColor(cars);
			}
		});

		make.setOpaque(false);
		make.setContentAreaFilled(false);
		make.setBorderPainted(false);
		make.setBackground(primary);
		make.setForeground(secondary);
		make.setFont(new Font(font_name, Font.PLAIN, 18));
		make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMake(cars);
			}
		});

		model.setOpaque(false);
		model.setContentAreaFilled(false);
		model.setBorderPainted(false);
		model.setBackground(primary);
		model.setForeground(secondary);
		model.setFont(new Font(font_name, Font.PLAIN, 18));
		model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByModel(cars);
			}
		});

		price.setOpaque(false);
		price.setContentAreaFilled(false);
		price.setBorderPainted(false);
		price.setBackground(primary);
		price.setForeground(secondary);
		price.setFont(new Font(font_name, Font.PLAIN, 18));
		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByPrice(cars);
			}
		});

		mileage.setOpaque(false);
		mileage.setContentAreaFilled(false);
		mileage.setBorderPainted(false);
		mileage.setBackground(primary);
		mileage.setForeground(secondary);
		mileage.setFont(new Font(font_name, Font.PLAIN, 18));
		mileage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMileage(cars);
			}
		});

		mpg.setOpaque(false);
		mpg.setContentAreaFilled(false);
		mpg.setBorderPainted(false);
		mpg.setBackground(primary);
		mpg.setForeground(secondary);
		mpg.setFont(new Font(font_name, Font.PLAIN, 18));
		mpg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.searchByMPG(cars);
			}
		});

		none.setOpaque(false);
		none.setContentAreaFilled(false);
		none.setBorderPainted(false);
		none.setBackground(primary);
		none.setForeground(secondary);
		none.setFont(new Font(font_name, Font.PLAIN, 18));
		none.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.displayVehicles(cars);
				// in case the user doesn't want to advance search..
				// cause users are stupid.
			}
		});
		JPanel adv_search_panel = new JPanel();
		adv_search_panel.setBackground(primary);
		adv_search_panel.add(label);
		adv_search_panel.add(color);
		adv_search_panel.add(make);
		adv_search_panel.add(model);
		adv_search_panel.add(price);
		adv_search_panel.add(mileage);
		adv_search_panel.add(mpg);
		adv_search_panel.add(none);
		adv_search_panel.setSize(320, 200);
		adv_search_panel.setLayout(new FlowLayout());
		adv_search_panel.setSize(320, 200);
		adv_search.add(adv_search_panel);
		adv_search.setVisible(true);
		adv_search.setSize(800, 400);
		adv_search.setLocationRelativeTo(null);
	}

	/**
	 * This method displays every car that is in the system.
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 */
	public static void displayVehicles(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		
		int count = 0;

		JFrame cars_frame = new JFrame("Available vehicles");
		ImageIcon img = new ImageIcon("./Car.jpg");
		cars_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		cars_frame.add(headerLabel, BorderLayout.NORTH);

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
					cars_frame.dispose();
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

		String header[] = { "Model", "Year", "Make", "Color", "Price", "Mileage", "MPG" };
		Object data[][] = new Object[cars.size()][7];
		String info = "";
		List<String> list;

		for (Car car : cars) {
			info = car.getAttributes();
			list = Arrays.asList(info.split(", "));

			for (int j = 0; j < 7; j++) {
				data[count][j] = list.get(j);
			}

			count++;
		}

		...
		// <<<<<<<<<<<< TO DO >>>>>>>>>>>>
		// add pictures to this somehow.. maybe a button to select?
		// yeah I should definitely include a button to select.
		JTable table = new JTable(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		JPanel car_panel = new JPanel();
		car_panel.setLayout(new GridLayout(3, 3));
		car_panel.setBackground(primary);

		Container c = cars_frame.getContentPane();
		c.setBackground(primary);
		car_panel.add(table.getTableHeader());
		car_panel.add(table);
		cars_frame.add(car_panel);
		cars_frame.setLocationRelativeTo(null);
		cars_frame.setSize(800, 500);
		cars_frame.setVisible(true);
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *           is the array list of cars that contains every car.
	 * 
	 */
	public static void searchByColor(ArrayList<Car> cars) {

		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";
		
		String colors[] = { "Black", "Blue", "Green", "Grey", "Orange", "Purple", "Red", "White", "Yellow" };

		JFrame search_frame = new JFrame("Search by color");
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JPanel search_panel = new JPanel();
		search_panel.setBackground(primary);
		JLabel prompt = new JLabel("Please choose a color.");
		prompt.setFont(new Font(font_name, Font.PLAIN, 18));
		prompt.setForeground(secondary);
		prompt.setBackground(primary);

		JComboBox<String> color_choices = new JComboBox<String>(colors);
		color_choices.setFont(new Font(font_name, Font.PLAIN, 18));
		color_choices.setForeground(secondary);
		color_choices.setBackground(primary);

		JButton select = new JButton("Select");
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);
		select.setBackground(primary);

		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Car> iter = cars.listIterator();
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

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});

		search_panel.setLayout(new BorderLayout());
		search_panel.add(prompt, BorderLayout.NORTH);
		search_panel.add(color_choices, BorderLayout.CENTER);
		search_panel.add(select, BorderLayout.EAST);
		search_frame.add(search_panel, BorderLayout.SOUTH);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);

		search_frame.setSize(800, 350);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_panel.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *            is the array list of cars that contains every car.
	 * 
	 */
	public static void searchByModel(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";
		
		// add to this list.
		// maybe make it loop through the list and only display vehicle models that we have?
		String models[] = { "Aventador", "F1", "Model S", "Wrangler" };

		JFrame search_frame = new JFrame("Search by model");
		JPanel search_panel = new JPanel(); 
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JLabel prompt = new JLabel("Please choose a model of car.");

		JComboBox<String> car_models = new JComboBox<String>(models);

		car_models.setFont(new Font(font_name, Font.PLAIN, 18));
		car_models.setForeground(primary);
		car_models.setBackground(secondary);

		JButton select = new JButton("Select");
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);

		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Car> iter = cars.listIterator();
				
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

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});
		
		search_panel.add(prompt);
		search_panel.add(car_models);
		search_panel.add(select);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);
		search_panel.setBackground(primary);
		search_frame.add(search_panel);
		search_frame.setSize(800, 350);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *           is the array list of cars that contains every car.
	 * 
	 */
	public static void searchByMake(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";
		ListIterator<Car> iter = cars.listIterator();

		// add to this list.
		// maybe make it loop through the list and only display vehicle makes that we have.
		String makes[] = { "Jeep", "Lamborghini", "Tesla", "Kia" };

		JFrame search_frame = new JFrame("Search by model");
		JPanel search_panel = new JPanel(); 
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JLabel prompt = new JLabel("Please choose a model of car.");
		prompt.setFont(new Font(font_name, Font.PLAIN, 18));
		prompt.setForeground(secondary);
		prompt.setBackground(primary);

		JComboBox<String> car_makes = new JComboBox<String>(makes);

		car_makes.setFont(new Font(font_name, Font.PLAIN, 18));
		car_makes.setForeground(primary);
		car_makes.setBackground(secondary);

		JButton select = new JButton("Select");
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);

		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
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

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});
		
		search_panel.add(prompt);
		search_panel.add(car_makes);
		search_panel.add(select);
		search_panel.setBackground(primary);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);
		search_frame.add(search_panel);
		search_frame.setSize(800, 350);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *           is the array list of cars that contains every car.
	 * 
	 */
	public static void searchByPrice(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";

		// add to this list.
		// maybe make it loop through the list and only display vehicle prices that we have.
		String prices[] = { "5.0", "100.0", "200.0", "300.0", "400.0", "10000.0" };

		JFrame search_frame = new JFrame("Search by model");
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JLabel prompt = new JLabel("Please choose a model of car.");
		prompt.setFont(new Font(font_name, Font.PLAIN, 18));
		prompt.setForeground(secondary);
		prompt.setBackground(primary);

		JComboBox<String> car_prices = new JComboBox<String>(prices);

		car_prices.setFont(new Font(font_name, Font.PLAIN, 18));
		car_prices.setForeground(primary);
		car_prices.setBackground(secondary);

		JButton select = new JButton("Select");
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);

		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Car> iter = cars.listIterator();
				
				// car_price is the price that was in the combo box
				double car_price = Double.parseDouble((String) car_prices.getSelectedItem());
				double price = 0;
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				// <>< <>< <>< <>< <<<< FISH
				while (iter.hasNext()) {
					car = iter.next();
					price = car.getPrice();

					if (car_price >= price) {
						sorted_cars.add(car);
					}
				}

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});
		JPanel search_panel = new JPanel();
		search_panel.setBackground(primary);
		search_panel.add(prompt);
		search_panel.add(car_prices);
		search_panel.add(select);
		search_frame.add(search_panel);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);
		search_frame.setSize(800, 350);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *           is the array list of cars that contains every car.
	 */
	public static void searchByMileage(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";

		// add to this list.
		// maybe make it loop through the list and only display vehicle models that we have.
		String mileages[] = { "5", "2000", "3000", "10000", "100000" };

		JFrame search_frame = new JFrame("Search by model");
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JLabel prompt = new JLabel("Please choose a model of car.");
		prompt.setFont(new Font(font_name, Font.PLAIN, 18));
		prompt.setForeground(secondary);
		prompt.setBackground(primary);

		JComboBox<String> car_mileages = new JComboBox<String>(mileages);

		car_mileages.setFont(new Font(font_name, Font.PLAIN, 18));
		car_mileages.setForeground(primary);
		car_mileages.setBackground(secondary);

		JButton select = new JButton("Select");
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);
		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Car> iter = cars.listIterator();
				
				// car_mileage is the mileage the came from the combo box.
				int car_mileage = Integer.parseInt((String) car_mileages.getSelectedItem());
				int mileage = 0;
				Car car = null;
				ArrayList<Car> sorted_cars = new ArrayList<>();

				while (iter.hasNext()) {
					car = iter.next();
					mileage = car.getMileage();

					if (car_mileage >= mileage) {
						sorted_cars.add(car);
					}
				}

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});
		JPanel search_panel = new JPanel();

		search_panel.add(prompt);
		search_panel.add(car_mileages);
		search_panel.add(select);
		search_panel.setBackground(primary);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);
		search_frame.setSize(800, 350);
		search_frame.add(search_panel);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		search_frame.setLayout(new FlowLayout());
	}

	/**
	 * This is a search method that retrieve all of the cars that have the given parameter
	 * 
	 * @param cars
	 *           is the array list of cars that contains every car.
	 * 
	 */
	public static void searchByMPG(ArrayList<Car> cars) {
		final Color primary = new Color(55, 71, 79);
		final Color secondary = new Color(236, 239, 241);

		final String font_name = "Harlow Solid Italic";

		// add to this list.
		// maybe make it loop through the list and only display vehicle models
		// that we have.
		String MPGs[] = { "1", "150", "20", "30", "40", "5000000" };

		JFrame search_frame = new JFrame("Search by miles per gallon");
		JPanel search_panel = new JPanel(); 
		ImageIcon img = new ImageIcon("./Car.jpg");
		search_frame.setIconImage(img.getImage());

		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		search_frame.add(headerLabel, BorderLayout.NORTH);

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
					search_frame.dispose();
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

		JLabel prompt = new JLabel("Please select the miles per gallon you hope your car can get.");
		prompt.setFont(new Font(font_name, Font.PLAIN, 18));
		prompt.setForeground(secondary);
		prompt.setBackground(primary);
		
		JComboBox<String> car_MPGs = new JComboBox<String>(MPGs);

		car_MPGs.setFont(new Font(font_name, Font.PLAIN, 18));
		car_MPGs.setForeground(primary);
		car_MPGs.setBackground(secondary);

		JButton select = new JButton("Select");

		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.setFont(new Font(font_name, Font.PLAIN, 18));
		select.setForeground(secondary);
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListIterator<Car> iter = cars.listIterator();
				
				// car_mpg is the mpg that came from the combo box.
				int car_MPG = Integer.parseInt((String) car_MPGs.getSelectedItem());
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

				if (sorted_cars.size() != 0) {
					Car.displayVehicles(sorted_cars);
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", primary);
					UI.put("Panel.background", secondary);
					UI.put("OptionPane.messageFont", new FontUIResource(new Font(font_name, Font.PLAIN, 13)));

					JOptionPane.showMessageDialog(null, "Sorry, we do not have any cars that match the given criteria.", "Alert", JOptionPane.INFORMATION_MESSAGE, img);
					search_frame.dispose();
				}
			}
		});

		search_panel.setBackground(primary);
		Container c = search_frame.getContentPane();
		c.setBackground(primary);
		search_panel.add(prompt);
		search_panel.add(car_MPGs);
		search_panel.add(select);
		search_frame.add(search_panel);
		search_frame.setSize(800, 350);
		search_frame.setVisible(true);
		search_frame.setLocationRelativeTo(null);
		
	}

	/**
	 * Method that is used for the read and write file.
	 * 
	 * @return a String that displays all the attributes separated by ", "
	 */
	public String getAttributes() {
		String info = getModel() + ", " + getYear() + ", " + getMake() + ", " + getColor() + ", " + getPrice() + ", "
				+ getMileage() + ", " + getMPG() + ", " + getID();

		return info;
	}
}
