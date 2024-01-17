package project;

import java.awt.Choice;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class Result extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public Result() {

		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JButton btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMain guimain = new GUIMain();
				guimain.setVisible(true);
				setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 47, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -89, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -549, SpringLayout.EAST, getContentPane());
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 78, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -56, SpringLayout.NORTH, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -58, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_1);
		panel_1.setBackground(SystemColor.inactiveCaption);

		Choice choice = new Choice();
		String[] menus = new String[] { "차수를 선택하세요", "-----", "1회차", "2회차", "3회차" };
		JComboBox<String> combo = new JComboBox<>();
		combo.setModel(new DefaultComboBoxModel<>(menus));
		choice.setFont(new Font("Dialog", Font.PLAIN, 11));

		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int index = combo.getSelectedIndex();

					if (index == 0) {
						textField.setText("");
					} else if (index == 1) {
						textField.setText("");
					} else if (index == 2) {
						textField.setText("2024.01.01");
					} else if (index == 3) {
						textField.setText("2024.01.11");
					} else if (index == 4) {
						textField.setText("2024.01.16");
					}

				}
			}
		});

		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, combo, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, combo, 96, SpringLayout.WEST, panel);
		panel.setLayout(sl_panel);

		panel.add(combo);
		JLabel lblNewLabel = new JLabel("\uD68C \uB2F9\uCCA8\uACB0\uACFC");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, combo);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, combo);
		panel.add(lblNewLabel);

		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, combo);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.EAST, combo);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uB2F9\uCCA8\uB0A0\uC9DC");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 15, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.EAST, textField);
		panel.add(lblNewLabel_1);

		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, -118, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel AllMoney = new JLabel("총 당첨금액");
		sl_panel.putConstraint(SpringLayout.SOUTH, AllMoney, 0, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.EAST, AllMoney, -28, SpringLayout.WEST, textField_3);
		panel.add(AllMoney);

		JLabel MyMoney = new JLabel("내가 받을 금액");
		sl_panel.putConstraint(SpringLayout.NORTH, MyMoney, 30, SpringLayout.SOUTH, AllMoney);
		sl_panel.putConstraint(SpringLayout.EAST, MyMoney, 0, SpringLayout.EAST, AllMoney);
		panel.add(MyMoney);

		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 0, SpringLayout.SOUTH, MyMoney);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, 75, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_5, -84, SpringLayout.NORTH, textField_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, -10, SpringLayout.EAST, panel);
		panel.add(textField_5);
		textField_5.setColumns(10);
		getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		Set<Integer> setOfSix = new TreeSet<>();
		Random random = new Random();
		while (setOfSix.size() < 6) {
			setOfSix.add(random.nextInt(45) + 1);
		}
		StringBuilder result = new StringBuilder();
		for (int number : setOfSix) {
			result.append(number).append(" ");
		}
		textField_5.setText(result.toString());

		Set<Integer> setOfOne = new HashSet<>();
		Random random2 = new Random();

		while (setOfOne.size() < 1) {
			setOfOne.add(random2.nextInt(45) + 1);
		}

		result.append(" + ").append(setOfOne.iterator().next());

		textField_5.setText(result.toString());

		JLabel Result = new JLabel("당첨 결과");
		sl_panel_1.putConstraint(SpringLayout.NORTH, Result, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, Result, 180, SpringLayout.WEST, panel_1);
		panel_1.add(Result);

		JLabel MyNumber = new JLabel("나의 번호");
		sl_panel_1.putConstraint(SpringLayout.NORTH, MyNumber, 46, SpringLayout.SOUTH, Result);
		sl_panel_1.putConstraint(SpringLayout.WEST, MyNumber, 0, SpringLayout.WEST, Result);
		panel_1.add(MyNumber);

		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, MyNumber);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 122, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, 281, SpringLayout.WEST, panel_1);
		textField_1.setText("00 00 00 00 00 00 + 00");
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("나의 등수");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, Result);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -229, SpringLayout.SOUTH, panel_1);
		panel_1.add(lblNewLabel_4);

		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, 10, SpringLayout.WEST, lblNewLabel_4);
		panel_1.add(textField_2);
		textField_2.setColumns(2);

		JLabel lblNewLabel_5 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, textField_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 6, SpringLayout.EAST, textField_2);
		panel_1.add(lblNewLabel_5);

		JLabel title = new JLabel("당첨 결과");
		title.setFont(new Font("굴림", Font.PLAIN, 21));
		springLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, title, 47, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, title, 44, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, title, 159, SpringLayout.WEST, getContentPane());
		getContentPane().add(title);

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Result();

	}
}
