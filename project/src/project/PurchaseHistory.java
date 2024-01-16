package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class PurchaseHistory extends JFrame {

	private JPanel contentPane;

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
		
		List<String> list = new ArrayList<>();
		List<String> round = new ArrayList<>();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, comboBox_1);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, -285, SpringLayout.WEST, comboBox_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, comboBox_1);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -11, SpringLayout.WEST, comboBox_1);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 69, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 632, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, -436, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -68, SpringLayout.EAST, panel);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 45, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -56, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, comboBox_1);
		panel.add(lblNewLabel);
		
		JList list_1 = new JList();
		sl_panel.putConstraint(SpringLayout.NORTH, list_1, -42, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, list_1, 45, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, list_1, -41, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, list_1, 255, SpringLayout.WEST, panel);
		panel.add(list_1);
	}
}
