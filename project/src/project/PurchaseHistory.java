package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class PurchaseHistory extends JFrame {
	private JPanel contentPane;
	protected static Vector<Integer> round = new Vector<>(); // 회차 리스트
	protected static Vector<Integer> purchase = new Vector<>(); // 구매 리스트
	protected static int index = 1; // 회차콤보박스
	protected static int purchaseindex = 1; // 회차콤보박스
	protected static List<JLabel> pnlwinningNumber = new ArrayList<>();;
	protected static Map<Integer,List<JLabel>> pnlpurchaseNumber = new HashMap<>();;
	protected static ArrayList<Integer> winningNumber = new ArrayList<>(); // 당첨번호
	protected static ArrayList<ArrayList<Integer>> purchaseNumber = new ArrayList<>(); // 구매번호
	private JComboBox comboBox_1;
	private FlowLayout flowLayout;
	
	
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

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

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
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("굴림", Font.BOLD, 30));
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, -429, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -639, SpringLayout.EAST, panel);
		panel.add(comboBox);

		// 회차 클릭 했을때 당첨번호 출력
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox<Integer> source = (JComboBox<Integer>) e.getSource();
				Integer selectedValue = (Integer) source.getSelectedItem();
				if (round.iterator().equals(selectedValue)) {
					for (Integer element : winningNumber) {
						System.out.print(element + " ");
					}
					System.out.println();
				}
				if (round.lastElement().equals(selectedValue)) {
					comboBox_1.setEnabled(true);
				} else {
					comboBox_1.setEnabled(false);
				}
			}
		});

		comboBox_1 = new JComboBox(purchase);
		comboBox_1.setFont(new Font("굴림", Font.BOLD, 30));
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 29, SpringLayout.EAST, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, 0, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, 319, SpringLayout.EAST, comboBox);
		panel.add(comboBox_1);

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 51, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 116, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, comboBox_1);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 79, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 654, SpringLayout.WEST, panel);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, 71, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 654, SpringLayout.WEST, panel);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -92, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, -41, SpringLayout.WEST, btnNewButton);
		panel.add(panel_4);

		JPanel panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_4);
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -26, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, comboBox_1);
		panel.add(panel_5);

		// 여러장 구매했을시 내가 구매한 로또내역 출력
		comboBox_1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				panel_1.setLayout(flowLayout);
				panel_2.setLayout(flowLayout);
				panel_3.setLayout(flowLayout);
				panel_4.setLayout(flowLayout);
				panel_5.setLayout(flowLayout);
				
				Integer selectedValue = (Integer) comboBox_1.getSelectedItem();
				
//				for (Integer i : pnlpurchaseNumber.keySet()) {
//					
//				}
//				 if (selectedValue != null && pnlpurchaseNumber.keySet()) {
			            for (JLabel registeredLabel : pnlpurchaseNumber.get(selectedValue)) {
			                if (panel_1.getComponentCount() <= 5) {
			                    panel_1.add(registeredLabel);
			                } else if (panel_2.getComponentCount() <= 5) {
			                    panel_2.add(registeredLabel);
			                } else if (panel_3.getComponentCount() <= 5) {
			                    panel_3.add(registeredLabel);
			                } else if (panel_4.getComponentCount() <= 5) {
			                    panel_4.add(registeredLabel);
			                } else if (panel_5.getComponentCount() <= 5) {
			                    panel_5.add(registeredLabel);
			                }
			            }
//			        }
				 
				panel_1.revalidate();
				panel_1.repaint();
				panel_2.revalidate();
				panel_2.repaint();
				panel_3.revalidate();
				panel_3.repaint();
				panel_4.revalidate();
				panel_4.repaint();
				panel_5.revalidate();
				panel_5.repaint();
			}
		});

	}

	// 로또 당첨번호 저장 메소드
	public static void winningNumberAdd(Integer winningnumber) {
		winningNumber.add(winningnumber);
	}

	// 내가 구매한 로또 번호 저장
	public static void purchaseNumberAdd(ArrayList<Integer> purchaseumber) {
		purchaseNumber.add(purchaseumber);
	}

	// 회차 올려주는 메소드
	public static void roundAdd() {
		round.add(index);
		index++;
	}

	// 구매시 장수 올려주는 메소드
	public static void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}

	// 내 추첨번호 삭제
	public static void purchaseClear() {
		purchase.clear();
	}

}
