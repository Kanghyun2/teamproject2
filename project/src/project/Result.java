package project;

import java.awt.Component;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

public class Result extends JFrame {
	protected static final String panel_3 = null;
	protected static final Object List = null;
	protected static final Object String = null;
	protected static Vector<Integer> purchase = new Vector<>();
	protected static int purchaseindex = 1;
	protected static int numberOfPurchases = 1; // 구매장수
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private ImageDisplayApp app;
	protected ArrayList<Integer> keysList;
	protected JLabel[] imageLabels;
	protected TreeMap<Integer, String> imageMap;
	protected int icon;
	private String imageList;
	protected static JLabel lblNewLabel_9;
	static JPanel panel_2;
	static JLabel lblNewLabel_10;
	private JToggleButton[][] lottoNumbers;
	private ImageIcon ballIcon;
	private JLabel lbl;
	private AbstractButton model;
	private FlowLayout flowLayout;
	protected static List<JLabel> purchaseNumber1 = new ArrayList<>();
	protected static List<JLabel> purchaseNumber2 = new ArrayList<>();
	protected static List<JLabel> purchaseNumber3 = new ArrayList<>();
	protected static Map<String, List<JLabel>> pnlpurchaseString = new HashMap<>();
	private int showBallselectedCount;
	protected static String numberOfOne = "첫번째 장";
	protected static String numberOfTwo = "두번째 장";
	protected static String numberOfThree = "세번째 장";
	protected Component lbl2;
	protected int index;
	protected Component lbl1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private Object pnlwinningNumber;
	private Object selectedNumber;
	private int Vector;

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
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 78, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -56, SpringLayout.NORTH, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, btnBack);
		panel_1.setBackground(SystemColor.inactiveCaption);

		String[] menus = new String[] { "차수를 선택하세요", "-----", "1회차", "2회차", "3회차" };
		JComboBox<String> combo = new JComboBox<>();
		combo.setModel(new DefaultComboBoxModel<>(menus));

		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int index = combo.getSelectedIndex();

					if (index == 0 || index == 1) {
						textField.setText("");
						lblNewLabel_9.setText("");
						panel_2.removeAll();
						panel_2.revalidate();
						panel_2.repaint();

					} else if (index == 2) {
						lblNewLabel_9.setText("");
						textField.setText("2023.08.16");
						TreeMap<Integer, String> imageMap3 = new TreeMap<>();
						imageMap3.put(4, "ball_4.png");
						imageMap3.put(5, "ball_5.png");
						imageMap3.put(10, "ball_10.png");
						imageMap3.put(12, "ball_12.png");
						imageMap3.put(22, "ball_22.png");
						imageMap3.put(34, "ball_34.png");
						imageMap3.put(41, "ball_41.png");
						List<Integer> keysList = new ArrayList<>(imageMap3.keySet());
						for (int j = 0; j < 8; j++) {
							if (j == 6) {
								imageLabels[j].setText("+");
							} else if (j <= 5) {
								imageList = imageMap3.get(keysList.get(j));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							} else {
								imageList = imageMap3.get(keysList.get(6));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							}
							panel_2.add(imageLabels[j]);
						}
						panel_2.revalidate();
						panel_2.repaint();

					} else if (index == 3) {
						lblNewLabel_9.setText("");
						textField.setText("2024.01.11");

						TreeMap<Integer, String> imageMap2 = new TreeMap<>();
						imageMap2.put(2, "ball_2.png");
						imageMap2.put(11, "ball_11.png");
						imageMap2.put(12, "ball_12.png");
						imageMap2.put(19, "ball_19.png");
						imageMap2.put(21, "ball_21.png");
						imageMap2.put(33, "ball_33.png");
						imageMap2.put(36, "ball_36.png");
						List<Integer> keysList = new ArrayList<>(imageMap2.keySet());
						for (int j = 0; j < 8; j++) {
							if (j == 6) {
								imageLabels[j].setText("+");
							} else if (j <= 5) {
								imageList = imageMap2.get(keysList.get(j));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							} else {
								imageList = imageMap2.get(keysList.get(6));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							}
							panel_2.add(imageLabels[j]);
						}
						panel_2.revalidate();
						panel_2.repaint();

					} else if (index == 4) {
						lblNewLabel_9.setText("");
						textField.setText("2024.01.25");

						TreeMap<Integer, String> shuffledTreeMap = new TreeMap<>();
						for (Integer key : keysList) {
							shuffledTreeMap.put(key, imageMap.get(key));
						}

						List<Integer> selectedNumber = keysList.subList(0, 8);
						Collections.sort(selectedNumber);

						StringBuilder result = new StringBuilder();

						for (int i = 0; i < 8; i++) {
							if (i == 6) {
								imageLabels[i].setText("+");
							} else {
								String imageList = shuffledTreeMap.get(selectedNumber.get(i));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[i].setIcon(icon);
							}
							panel_2.add(imageLabels[i]);

						}
						panel_2.revalidate();
						panel_2.repaint();
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
		textField.setEditable(false);
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
		textField_3.setEditable(false);
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
		textField_4.setEditable(false);
		panel.add(textField_4);
		textField_4.setColumns(10);
		getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("나의 번호");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 178, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_3);

		JPanel panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 58, SpringLayout.WEST, panel_1);
		panel_1.add(panel_4);

		JPanel panel_4_1 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, panel_4_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_4_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1, 115, SpringLayout.NORTH, panel_1);
		panel_1.add(panel_4_1);

		JPanel panel_4_1_1 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1, 186, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1, -6, SpringLayout.NORTH, panel_4_1_1);
		panel_1.add(panel_4_1_1);

		JPanel panel_4_1_1_1 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1_1, 257, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1, -6, SpringLayout.NORTH, panel_4_1_1_1);
		panel_1.add(panel_4_1_1_1);

		JPanel panel_4_1_1_1_1 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1_1, -6, SpringLayout.NORTH, panel_4_1_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1_1_1, 328, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1_1_1, -10, SpringLayout.SOUTH, panel_1);
		panel_1.add(panel_4_1_1_1_1);

		JComboBox<Integer> comboBox = new JComboBox<>(PurchaseHistory.purchase);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 7, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 9, SpringLayout.SOUTH, comboBox);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 100, SpringLayout.EAST, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox, -43, SpringLayout.EAST, panel_1);
		panel_1.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("장");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 7, SpringLayout.EAST, comboBox);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_11 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_11, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_11, -409, SpringLayout.EAST, panel_1);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_11_1, 40, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_11_1, 0, SpringLayout.SOUTH, panel_4_1);
		panel_1.add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_1_1 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_11_1_1, 0, SpringLayout.WEST, lblNewLabel_11);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_11_1_1, 0, SpringLayout.SOUTH, panel_4_1_1);
		panel_1.add(lblNewLabel_11_1_1);

		JLabel lblNewLabel_11_1_1_1 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_11_1_1_1, 0, SpringLayout.WEST, lblNewLabel_11);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_11_1_1_1, 0, SpringLayout.SOUTH, panel_4_1_1_1);
		panel_1.add(lblNewLabel_11_1_1_1);

		JLabel lblNewLabel_11_1_1_1_1 = new JLabel("등");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_11_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_11);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_11_1_1_1_1, 0, SpringLayout.SOUTH, panel_4_1_1_1_1);
		panel_1.add(lblNewLabel_11_1_1_1_1);

		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, 8, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_2, -6, SpringLayout.WEST, lblNewLabel_11);
		textField_2.setEditable(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("나의 등수 확인!");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, -4, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, textField_2);
		panel_1.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MN();
			}
		});

		textField_5 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_5, 50, SpringLayout.SOUTH, textField_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_5, -30, SpringLayout.WEST, lblNewLabel_11_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_5, -6, SpringLayout.WEST, lblNewLabel_11_1);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_6, 50, SpringLayout.SOUTH, textField_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_6, -30, SpringLayout.WEST, lblNewLabel_11_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_6, -6, SpringLayout.WEST, lblNewLabel_11_1_1);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_7, 50, SpringLayout.SOUTH, textField_6);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_7, -30, SpringLayout.WEST, lblNewLabel_11_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_7, -6, SpringLayout.WEST, lblNewLabel_11_1_1_1);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_8, -30, SpringLayout.WEST, lblNewLabel_11_1_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_8, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_8, -6, SpringLayout.WEST, lblNewLabel_11_1_1_1_1);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		panel_1.add(textField_8);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer selectedValue = (Integer) comboBox.getSelectedItem();

				// 선택된 값이 null이 아닐 때 처리
				if (selectedValue != null) {
					// 패널 내부의 모든 컴포넌트 제거
					panel_4.removeAll();
					panel_4_1.removeAll();
					panel_4_1_1.removeAll();
					panel_4_1_1_1.removeAll();
					panel_4_1_1_1_1.removeAll();

					// 선택된 값에 대한 처리
					for (Integer i : PurchaseHistory.pnlpurchaseNumber.keySet()) {
						if (i.equals(selectedValue)) {
							PurchaseHistory.pnlpurchaseNumber.get(i);
							for (JLabel lbl : PurchaseHistory.pnlpurchaseNumber.get(i))
								if (panel_4.getComponentCount() <= 5) {
									panel_4.add(lbl);
								} else if (panel_4_1.getComponentCount() <= 5) {
									panel_4_1.add(lbl);
								} else if (panel_4_1_1.getComponentCount() <= 5) {
									panel_4_1_1.add(lbl);
								} else if (panel_4_1_1_1.getComponentCount() <= 5) {
									panel_4_1_1_1.add(lbl);
								} else if (panel_4_1_1_1_1.getComponentCount() <= 5) {
									panel_4_1_1_1_1.add(lbl);

								}
						}
					}

					// 패널 리레이아웃 갱신
					panel_4.revalidate();
					panel_4.repaint();
					panel_4_1.revalidate();
					panel_4_1.repaint();
					panel_4_1_1.revalidate();
					panel_4_1_1.repaint();
					panel_4_1_1_1.revalidate();
					panel_4_1_1_1.repaint();
					panel_4_1_1_1_1.revalidate();
					panel_4_1_1_1_1.repaint();

				}

			}

		});

		JLabel lblNewLabel_6 = new JLabel("당첨 결과");
		springLayout.putConstraint(SpringLayout.NORTH, panel, 25, SpringLayout.SOUTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblNewLabel_6);

		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 37, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 156, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel.add(panel_2);

		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 21));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 47, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 44, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 159, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_6);

		lblNewLabel_9 = new JLabel();
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

		imageLabels = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			imageLabels[i] = new JLabel();
		}

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void MN() {
		// 보너스 점수 제외 비교 (1등)
		int count = 0;
		for (Integer i : keysList) {
			for (Integer j : purchase) {
				if (i == j) {
					count++;
					break;
				}
			}
		}

		if (count == 6) {
			textField_2.setText("1등");
		}
		// 보너스점수 포함 비교
		int target = keysList.get(6); // 7번째 숫자 (보너스 넘버)
		if (keysList.equals(purchase)) {
			count++;
		}

		switch (count) {
		case 1:
			textField_2.setText("2등");
			break;
		case 2:
			textField_2.setText("3등");
			break;
		case 3:
			textField_2.setText("4등");
			break;
		case 4:
			textField_2.setText("5등");
			break;
		default:
			textField_2.setText("낙첨");
			break;
		}
	}

	private int countMatchingNumbers(Object pnlwinningNumber2, Object selectedNumber2) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected JLabel textField() {
		// TODO Auto-generated method stub
		return null;
	}

	protected JLabel lblNewLabel_9() {
		// TODO Auto-generated method stub
		return null;
	}

	protected JLabel panel_2() {
		// TODO Auto-generated method stub
		return null;
	}

	protected JLabel panel_3(Object lblNewLabel_102) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void setLayout(Panel panel) {

	}

	protected void getLayout(FlowLayout flowLayout) {

	}

	public static void lblNewLabel_10(List<JLabel> registeredLabels) {
		// TODO Auto-generated method stub

	}

	public static void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}

	public static void main(String[] args) {
		new Result();

	}
}
