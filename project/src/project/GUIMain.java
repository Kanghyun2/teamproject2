package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class GUIMain extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frame = new GUIMain();
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
	public GUIMain() {
		GUImathod();
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Purchase();
				dispose();

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Result result = new Result();
				result.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PurchaseHistory().setVisible(true);
				dispose();
			}
		});
	}

	public void GUImathod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		getContentPane().add(panel);

		String gifFilePath = "테스트1.gif";
		ImageIcon imageIcon = new ImageIcon(gifFilePath);
		Image image = imageIcon.getImage().getScaledInstance(982, 300, Image.SCALE_DEFAULT); // 300x200 크기로 조정

		JLabel gifLabel = new JLabel(new ImageIcon(image));
		gifLabel.setBackground(Color.WHITE);
		panel.add(gifLabel);
		setComponentZOrder(panel, 0);

		btnNewButton = new JButton("");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 86, SpringLayout.SOUTH, gifLabel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, -905, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -75, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -637, SpringLayout.EAST, panel);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("button.png"));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(btnNewButton);

		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);

		btnNewButton_1 = new JButton("");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 39, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.setIcon(new ImageIcon("button2.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 386, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -75, SpringLayout.SOUTH, panel);
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(btnNewButton_1);

		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);

		btnNewButton_2 = new JButton("");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -50, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -23, SpringLayout.EAST, panel);
		btnNewButton_2.setIcon(new ImageIcon("button3.png"));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 676, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 86, SpringLayout.SOUTH, gifLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -75, SpringLayout.SOUTH, panel);
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(btnNewButton_2);

		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);

	}
}
