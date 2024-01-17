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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

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

		JLabel lblNewLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -55, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("뒤로가기");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 695, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -61, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIMain().setVisible(true);
				dispose();
				
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -125, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -52, SpringLayout.SOUTH, panel);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox(round);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, -429, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -639, SpringLayout.EAST, panel);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(purchase);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, comboBox_1);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 29, SpringLayout.EAST, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, 0, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, 319, SpringLayout.EAST, comboBox);
		panel.add(comboBox_1);
		
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
