package project;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	private ImageDisplayApp app;
	protected ArrayList<Integer> keysList;
	protected JLabel[] imageLabels;
	protected TreeMap<Integer, String> imageMap;
	protected static JLabel lblNewLabel_9;
	static JPanel panel_2;

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
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -89, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -549, SpringLayout.EAST, getContentPane());
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 78, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -58, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -56, SpringLayout.NORTH, btnBack);
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
						lblNewLabel_9.setText("");
					} else if (index == 1) {
						textField.setText("");
						lblNewLabel_9.setText("");
					} else if (index == 2) {
						textField.setText("2023.08.16");
						lblNewLabel_9.setText("5 10 12 22 34 41 + 42");
					} else if (index == 3) {
						textField.setText("2024.01.11");
						lblNewLabel_9.setText("2 12 19 21 33 36 + 40");
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

		JLabel lblNewLabel_1 = new JLabel("당첨번호 공개 날짜");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 15, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.EAST, textField);
		panel.add(lblNewLabel_1);

		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, -118, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("총 당첨금액");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_7, -28, SpringLayout.WEST, textField_3);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("내가 받을 금액");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 30, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(lblNewLabel_8);

		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 0, SpringLayout.SOUTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(textField_4);
		textField_4.setColumns(10);
		getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("당첨 결과");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 180, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("나의 번호");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 46, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		panel_1.add(lblNewLabel_3);

		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 122, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, 281, SpringLayout.WEST, panel_1);
		textField_1.setText("00 00 00 00 00 00 + 00");
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("나의 등수");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 51, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_2);
		panel_1.add(lblNewLabel_4);

		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, 146, SpringLayout.WEST, panel_1);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 6, SpringLayout.EAST, textField_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, textField_2);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("당첨 결과");
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblNewLabel_6);

		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 37, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 156, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel.add(panel_2);
//		SpringLayout sl_panel_2 = new SpringLayout();
//		panel_2.setLayout(sl_panel_2);

		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 21));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 47, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 44, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 159, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_6);

		lblNewLabel_9 = new JLabel();
//		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 10, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_9, 10, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 109, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_9, 358, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_9);

		imageMap = new TreeMap<>();
		imageMap.put(1, "ball_1.png");
		imageMap.put(2, "ball_2.png");
		imageMap.put(3, "ball_3.png");
		imageMap.put(4, "ball_4.png");
		imageMap.put(5, "ball_5.png");
		imageMap.put(6, "ball_6.png");
		imageMap.put(7, "ball_7.png");
		imageMap.put(8, "ball_8.png");
		imageMap.put(9, "ball_9.png");
		imageMap.put(10, "ball_10.png");
		imageMap.put(11, "ball_11.png");
		imageMap.put(12, "ball_12.png");
		imageMap.put(13, "ball_13.png");
		imageMap.put(14, "ball_14.png");
		imageMap.put(15, "ball_15.png");
		imageMap.put(16, "ball_16.png");
		imageMap.put(17, "ball_17.png");
		imageMap.put(18, "ball_18.png");
		imageMap.put(19, "ball_19.png");
		imageMap.put(20, "ball_20.png");
		imageMap.put(21, "ball_21.png");
		imageMap.put(22, "ball_22.png");
		imageMap.put(23, "ball_23.png");
		imageMap.put(24, "ball_24.png");
		imageMap.put(25, "ball_25.png");
		imageMap.put(26, "ball_26.png");
		imageMap.put(27, "ball_27.png");
		imageMap.put(28, "ball_28.png");
		imageMap.put(29, "ball_29.png");
		imageMap.put(30, "ball_30.png");
		imageMap.put(31, "ball_31.png");
		imageMap.put(32, "ball_32.png");
		imageMap.put(33, "ball_33.png");
		imageMap.put(34, "ball_34.png");
		imageMap.put(35, "ball_35.png");
		imageMap.put(36, "ball_36.png");
		imageMap.put(37, "ball_37.png");
		imageMap.put(38, "ball_38.png");
		imageMap.put(39, "ball_39.png");
		imageMap.put(40, "ball_40.png");
		imageMap.put(41, "ball_41.png");
		imageMap.put(42, "ball_42.png");
		imageMap.put(43, "ball_43.png");
		imageMap.put(44, "ball_44.png");
		imageMap.put(45, "ball_45.png");

		keysList = new ArrayList<>(imageMap.keySet());

		Collections.shuffle(keysList);

		imageLabels = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			imageLabels[i] = new JLabel();
		}

		JButton 당첨번호확인버튼 = new JButton("당첨 번호 확인");
		sl_panel.putConstraint(SpringLayout.NORTH, 당첨번호확인버튼, 4, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, 당첨번호확인버튼, -10, SpringLayout.EAST, panel);

		panel.add(당첨번호확인버튼);

		당첨번호확인버튼.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PurchaseHistory.roundAdd();
				TreeMap<Integer, String> shuffledTreeMap = new TreeMap<>();
				for (Integer key : keysList) {
					shuffledTreeMap.put(key, imageMap.get(key));
				}

				List<Integer> selectedNumber = keysList.subList(0, 6);

				Collections.sort(selectedNumber);

				StringBuilder result = new StringBuilder();

				// System.out.println("맵" + shuffledTreeMap);
				// System.out.println("리스트" + selectedNumber);

				for (int i = 0; i < 6; i++) {
					String imageList = shuffledTreeMap.get(selectedNumber.get(i));
					ImageIcon icon = new ImageIcon(imageList);
					imageLabels[i].setIcon(icon);
					panel_2.add(imageLabels[i]);

					// result.append(selectedNumber.get(i)).append(" ");
				}
				// System.out.println(panel_2);
				// Result.lblNewLabel_9.setText(result.toString());

				panel_2.revalidate();
				panel_2.repaint();

			}
		});

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	protected void setLayout(Panel panel) {
		// TODO Auto-generated method stub

	}

	protected void getLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// SwingUtilities.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		new Result();

		// }
		// });
	}
}
