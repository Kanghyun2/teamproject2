package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class PurchaseHistory extends JFrame {

	private JPanel contentPane;
	protected Vector round;
	protected Vector purchase;
	protected int index = 1;
	protected int purchaseindex = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseHistory frame = new PurchaseHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PurchaseHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		round = new Vector();
		purchase = new Vector();

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JList list_1 = new JList(round);
		sl_panel.putConstraint(SpringLayout.NORTH, list_1, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, list_1, 53, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, list_1, 122, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, list_1, 343, SpringLayout.WEST, panel);
		panel.add(list_1);

		JList list_2 = new JList(purchase);
		sl_panel.putConstraint(SpringLayout.NORTH, list_2, 0, SpringLayout.NORTH, list_1);
		sl_panel.putConstraint(SpringLayout.WEST, list_2, 38, SpringLayout.EAST, list_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, list_2, 0, SpringLayout.SOUTH, list_1);
		sl_panel.putConstraint(SpringLayout.EAST, list_2, 671, SpringLayout.WEST, panel);
		panel.add(list_2);

		JLabel lblNewLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, list_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 374, SpringLayout.SOUTH, list_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, list_2);
		panel.add(lblNewLabel);
	}

	public void roundAdd() {
		round.add(index);
		index++;
	}

	public void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}
}
