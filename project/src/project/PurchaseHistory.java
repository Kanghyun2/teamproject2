package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ImageIcon;

public class PurchaseHistory extends JFrame {
	private JPanel contentPane;
//	protected static Vector<Integer> round = new Vector<>(); // 회차 리스트
	protected static Vector<Integer> purchase = new Vector<>(); // 구매 리스트
//	protected static int index = 1; // 회차콤보박스
	protected static int purchaseindex = 1; // 구매콤보박스
	protected static int numberOfPurchases = 1; // 구매장수
	protected static List<JLabel> pnlwinningNumber = new ArrayList<>();;
	protected static Map<Integer, List<JLabel>> pnlpurchaseNumber = new HashMap<>();;
//	protected static ArrayList<Integer> winningNumber = new ArrayList<>(); // 당첨번호
//	protected static ArrayList<ArrayList<Integer>> purchaseNumber = new ArrayList<>(); // 구매번호
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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setTitle("로또 구매내역");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -83, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 721, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -35, SpringLayout.EAST, panel);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("뒤로가기버튼테스트-.png"));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIMain().setVisible(true);
				dispose();

			}
		});
		panel.add(btnNewButton);

//		// 회차 클릭 했을때 당첨번호 출력
//		comboBox.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				JComboBox<Integer> source = (JComboBox<Integer>) e.getSource();
//				Integer selectedValue = (Integer) source.getSelectedItem();
//				if (round.iterator().equals(selectedValue)) {
//					for (Integer element : winningNumber) {
//						System.out.print(element + " ");
//					}
//					System.out.println();
//				}
//				if (round.lastElement().equals(selectedValue)) {
//					comboBox_1.setEnabled(true);
//				} else {
//					comboBox_1.setEnabled(false);
//				}
//			}
//		});

		comboBox_1 = new JComboBox(purchase);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 77, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 259, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, -441, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -534, SpringLayout.EAST, panel);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(comboBox_1);

		JLabel lblNewLabel = new JLabel("구매 내역");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 105, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -437, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 73, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -721, SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(lblNewLabel);

//		@Override
//	    protected void paintComponent(Graphics g) {
//	        super.paintComponent(g);
//	        // 이미지 그리기
//	        g.drawImage(new ImageIcon("로또용지 테두리.png"), 0, 0, getWidth(), getHeight(), this);
//	    }

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 12, SpringLayout.SOUTH, comboBox_1);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -367, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 188, SpringLayout.NORTH, panel);
		panel.add(panel_2);
		panel_2.setBackground(Color.WHITE);

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 254, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel);
		panel.add(panel_3);
		panel_3.setBackground(Color.WHITE);

		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, -367, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, panel_4);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_4);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 320, SpringLayout.NORTH, panel);
		panel.add(panel_4);
		panel_4.setBackground(Color.WHITE);

		JPanel panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 386, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -105, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, -367, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, panel_5);
		panel.add(panel_5);
		panel_5.setBackground(Color.WHITE);

		// 여러장 구매했을시 내가 구매한 로또내역 출력
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택된 값 가져오기
				Integer selectedValue = (Integer) comboBox_1.getSelectedItem();

				// 선택된 값이 null이 아닐 때 처리
				if (selectedValue != null) {
					// 패널 내부의 모든 컴포넌트 제거
					panel_1.removeAll();
					panel_2.removeAll();
					panel_3.removeAll();
					panel_4.removeAll();
					panel_5.removeAll();

					// 선택된 값에 대한 처리
					for (Integer i : pnlpurchaseNumber.keySet()) {
						if (i.equals(selectedValue)) {
							pnlpurchaseNumber.get(i);
							for (JLabel lbl : pnlpurchaseNumber.get(i))
								if (panel_1.getComponentCount() <= 5) {
									panel_1.add(lbl);
								} else if (panel_2.getComponentCount() <= 5) {
									panel_2.add(lbl);
								} else if (panel_3.getComponentCount() <= 5) {
									panel_3.add(lbl);
								} else if (panel_4.getComponentCount() <= 5) {
									panel_4.add(lbl);
								} else if (panel_5.getComponentCount() <= 5) {
									panel_5.add(lbl);

								}
						}
					}

					// 패널 리레이아웃 갱신
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
			}
		});
	}

//	// 로또 당첨번호 저장 메소드
//	public static void winningNumberAdd(Integer winningnumber) {
//		winningNumber.add(winningnumber);
//	}

//	// 내가 구매한 로또 번호 저장
//	public static void purchaseNumberAdd(ArrayList<Integer> purchaseumber) {
//		purchaseNumber.add(purchaseumber);
//	}

//	// 회차 올려주는 메소드
//	public static void roundAdd() {
//		round.add(index);
//		index++;
//	}

	// 구매시 장수 올려주는 메소드
	public static void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}
}
