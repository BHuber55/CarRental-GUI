import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class formatter {

	private static Color primary = new Color(55, 71, 79);
	private static Color secondary = new Color(236, 239, 241);

	public static void format(JFrame frame) {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(((dim.width/2)-400), ((dim.height/2)-255));
		//frame.setUndecorated(true);
		frame.setSize(800, 510);
		frame.setBackground(primary);
		frame.setLayout(new BorderLayout());

		Container c = frame.getContentPane();
		c.setBackground(primary);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void format(JLabel label) {
		final String font_name = "Harlow Solid Italic";

		label.setBackground(primary);
		label.setForeground(secondary);
		label.setFont(new Font(font_name, Font.PLAIN, 16));
	}
	
	public static void format(JComboBox<String> box)
	{
		final String font_name = "High Tower Text";
		box.setFont(new Font(font_name, Font.PLAIN, 18));
		box.setForeground(secondary);
		box.setBackground(primary);
	}

	public static void format(JTextField field) {
		field.setBackground(new Color(66, 66, 66));
		field.setForeground(Color.WHITE);
		field.setFont(new Font("High Tower Text", Font.PLAIN, 16));
		
	}

	public static void format(JButton button) {
		final Color primary;
		final Color secondary;

		if (button.getText().equals("login_button") || button.getText().equals("create_button")) {
			primary = Color.BLACK;
			secondary = Color.RED;
		} else {
			primary = new Color(55, 71, 79);
			secondary = new Color(236, 239, 241);
		}
		final String font_name = "Harlow Solid Italic";

		button.setBackground(primary);
		button.setForeground(secondary);
		button.setFont(new Font(font_name, Font.PLAIN, 17));

		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);

	}

	public static void addHeader(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		JLabel headerLabel = new JLabel(new ImageIcon("./header.jpg"));
		panel.add(headerLabel);
		frame.add(panel, BorderLayout.PAGE_START);

		headerLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (x > 670 && x < 800 && y > 226 && y < 250) {
					frame.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {			}
			@Override
			public void mouseExited(MouseEvent e) {			}
			@Override
			public void mousePressed(MouseEvent e) {			}
			@Override
			public void mouseReleased(MouseEvent e) {			}
		});

		ImageIcon img = new ImageIcon("./Car.jpg");
		frame.setIconImage(img.getImage());


	}

	@SuppressWarnings("static-access")
	public static void format(JOptionPane pane) {

		UIManager UI = new UIManager();
		UI.put("OptionPane.background", primary);
		UI.put("Panel.background", primary);
		UI.put("OptionPane.messageForeground", secondary);		
		UI.put("OptionPane.messageFont", new FontUIResource(new Font("High Tower Text", Font.PLAIN, 13)));
		
	}

	public static void format(JPanel panel) {
		panel.setBackground(primary);

	}
	
	
}
