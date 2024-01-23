package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

public class Purchase extends JFrame {
	protected static final Collection<JLabel> PN1 = null;
	protected static final Collection<JLabel> PN2 = null;
	private JToggleButton[][] lottoNumbers;
//	private List<JLabel> registeredLabels = new ArrayList<>();
	private JButton btnNewButton_1;
	private ImageIcon[][] originalIcons;
	private JPanel pnl;
	protected static JPanel pnlBall1;
	protected static JPanel pnlBall2;
	protected static JPanel pnlBall3;
	protected static JPanel pnlBall4;
	protected static JPanel pnlBall5;
	private JLabel lbl;
	private ImageIcon ballIcon;
	private JButton btnRegistration;
	private JButton btnDel1;
	private JButton btnDel2;
	private JButton btnDel3;
	private JButton btnDel4;
	private JButton btnDel5;
	private List<JLabel> registeredLabels;
	private int rows = 7; // 행
	private int cols = 7; // 열
	private int showBallselectedCount = 0;
	protected String[] numberOfOneTwoThree;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private Object comboBox;
	private int index;
	protected Map<Integer, List<JLabel>> pnlpurchasString;
	protected Map<Integer, List<JLabel>> pnlpurchaseString;

	public Purchase() {
		getContentPane().setBackground(Color.WHITE);
		pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		getContentPane().add(pnl);
		SpringLayout springLayout = new SpringLayout();
		pnl.setLayout(springLayout);

//		String gifFilePath = "구매창.png";
//        ImageIcon imageIcon = new ImageIcon(gifFilePath);
//        Image image = imageIcon.getImage().getScaledInstance(970, 550, Image.SCALE_DEFAULT);
//        setComponentZOrder(pnl, 0);
//		
//        JLabel gifLabel = new JLabel(new ImageIcon(image));
//        gifLabel.setBackground(Color.WHITE);
//        pnl.add(gifLabel);

		int checkboxMargin = 1; // 버튼 간격

		originalIcons = new ImageIcon[rows][cols];
		lottoNumbers = new JToggleButton[rows][cols];

		for (int i = 0; i < 45; i++) { // 7x7 45 버튼으로 표현
			int row = i / cols;
			int col = i % cols;

			ImageIcon toggleIcon = new ImageIcon("num" + (i + 1) + ".png");
			lottoNumbers[row][col] = new JToggleButton();
			lottoNumbers[row][col].setIcon(toggleIcon);
			lottoNumbers[row][col].setActionCommand(Integer.toString(i + 1));// 버튼 이미지 크기 텍스트 때문에 안맞아서 커맨드로 바꿈
			lottoNumbers[row][col].setBorderPainted(false);
			lottoNumbers[row][col].setFocusPainted(false);
			lottoNumbers[row][col].setContentAreaFilled(false);

//			lottoNumbers[row][col].setText(Integer.toString(i + 1));
//			lottoNumbers[row][col].setHideActionText(true);
			lottoNumbers[row][col].setPreferredSize(new Dimension(28, 28)); // 버튼 사이즈
		
			
//			layeredPane.add(lottoNumbers[row][col], 0);
//			gifLabel.setBackground(Color.WHITE);
//			pnl.add(gifLabel);
			pnl.add(lottoNumbers[row][col]);
		
			// 첫 번째 열은 왼쪽에 고정
			if (col == 0) {
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], 224, SpringLayout.WEST, pnl);
			} else {
				pnl.add(lottoNumbers[row][col]);
				// 나머지 열은 이전 체크박스를 기준으로 위치 조정 (가로로 배치)
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], checkboxMargin, SpringLayout.EAST,
						lottoNumbers[row][col - 1]);
			}

			// 첫 번째 행은 상단에 고정
			if (row == 0) {
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], 150, SpringLayout.NORTH, pnl);
			} else {
				// 나머지 행은 이전 행의 첫 번째 열을 기준으로 위치 조정 (세로로 배치)
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], checkboxMargin,
						SpringLayout.SOUTH, lottoNumbers[row - 1][0]);
			}

			lottoNumbers[row][col].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						ImageIcon clickIcon = new ImageIcon("clicknum.png");
						lottoNumbers[row][col].setIcon(clickIcon);
					} else if (e.getStateChange() == ItemEvent.DESELECTED) {
						ImageIcon toggleIcon = new ImageIcon("num" + (row * cols + col + 1) + ".png");
						lottoNumbers[row][col].setIcon(toggleIcon);
					}

				}
			});

			JButton btnNewButton = new JButton("자동 선택");
			btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					ranSelect();

				}

				public void ranSelect() {
					List<JToggleButton> allButton = new ArrayList<>();
					for (int i = 0; i < 45; i++) {
						int row = i / cols;
						int col = i % cols;
						allButton.add(lottoNumbers[row][col]);

						ImageIcon toggleIcon = new ImageIcon("num" + (i + 1) + ".png");
						originalIcons[row][col] = toggleIcon;
					}

					Collections.shuffle(allButton);
					int count = 0;
					for (JToggleButton button : allButton) {
						if (count < 6) {
							ImageIcon clickIcon = new ImageIcon("clicknum.png");
							button.setIcon(clickIcon);
							button.setSelected(true);
							count++;
						} else if (count >= 6) {
							if (button.isSelected()) {
								int row = (count - 6) / cols;
								int col = (count - 6) % cols;
								button.setIcon(originalIcons[row][col]);
								button.setSelected(false);
							}
						} else {
							break;
						}
					}
				}
			});

			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 222, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 67, SpringLayout.WEST, pnl);
			pnl.add(btnNewButton);

			btnNewButton_1 = new JButton("반 자동");
			springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
			btnNewButton_1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					halfRandom();
					if (showBallselectedCount < 6 || showBallselectedCount > 6) {
						InputDialog dialog = new InputDialog(Purchase.this);
						dialog.setVisible(true);
					}
				}

				public void halfRandom() {
					List<JToggleButton> allButton = new ArrayList<>();
					int selectedCount = 0;

					// 모든 버튼을 리스트에 추가
					for (int i = 0; i < 45; i++) {
						int row = i / cols;
						int col = i % cols;
						allButton.add(lottoNumbers[row][col]);

						// 수동으로 선택한 버튼의 개수를 카운트
						if (lottoNumbers[row][col].isSelected()) {
							selectedCount++;
						}
					}

					Collections.shuffle(allButton);
					for (JToggleButton button : allButton) {
						if (selectedCount == 1) {
							if (!button.isSelected()) {
								button.setSelected(true);
								selectedCount++;
							}
						} else if (selectedCount >= 2 && selectedCount <= 5) {
							if (!button.isSelected()) {
								button.setSelected(true);
								selectedCount++;
							}

							if (selectedCount >= 6) {
								break;
							}
						}
					}
				}
			});

			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 64, SpringLayout.SOUTH, btnNewButton);
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
			pnl.add(btnNewButton_1);

			JButton btnNewButton_2 = new JButton("구매");
			springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, pnl);
			btnNewButton_2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (pnlBall1.getComponentCount() == 0 && pnlBall2.getComponentCount() == 0
							&& pnlBall3.getComponentCount() == 0 && pnlBall4.getComponentCount() == 0
							&& pnlBall5.getComponentCount() == 0) {
						PurchaseDialog2 dialog = new PurchaseDialog2(Purchase.this);
						dialog.setVisible(true);
					} else {
						PurchaseDialog dialog = new PurchaseDialog(Purchase.this);
						dialog.setVisible(true);
						PurchaseHistory.purchaseAdd();
						PurchaseHistory.pnlpurchaseNumber.put(PurchaseHistory.numberOfPurchases,
								new ArrayList<>(PurchaseHistory.pnlwinningNumber));
						PurchaseHistory.numberOfPurchases++;

					}

					PurchaseHistory.pnlwinningNumber.clear();
				}
			});
			pnl.add(btnNewButton_2);

			JButton btnGoBack = new JButton("뒤로가기");
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIMain guimain = new GUIMain();
					guimain.setVisible(true);
					setVisible(false);
				}
			});
			springLayout.putConstraint(SpringLayout.SOUTH, btnGoBack, -10, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnGoBack, -10, SpringLayout.WEST, btnNewButton_2);
			pnl.add(btnGoBack);

			btnRegistration = new JButton("확인");
			springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 392, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -122, SpringLayout.SOUTH, pnl);
			btnRegistration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showBall();

					if (showBallselectedCount < 6 || showBallselectedCount > 6) {
						InputDialog dialog = new InputDialog(Purchase.this);
						dialog.setVisible(true);
					}
				}

			});
			pnl.add(btnRegistration);

			JButton btnNewButton_3 = new JButton("초기화");
			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnRegistration);
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -20, SpringLayout.WEST, btnRegistration);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			pnl.add(btnNewButton_3);

			btnDel1 = new JButton("삭제");
			btnDel1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnlBall1.removeAll();
					pnlBall1.revalidate();
					pnlBall1.repaint();

				}
			});
			pnl.add(btnDel1);

			btnDel2 = new JButton("삭제");
			springLayout.putConstraint(SpringLayout.NORTH, btnDel2, 190, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, btnDel2, 894, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.WEST, btnDel1, 0, SpringLayout.WEST, btnDel2);
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel1, -45, SpringLayout.NORTH, btnDel2);
			btnDel2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall2.removeAll();
					pnlBall2.revalidate();
					pnlBall2.repaint();
				}
			});
			pnl.add(btnDel2);

			btnDel3 = new JButton("삭제");
			btnDel3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall3.removeAll();
					pnlBall3.revalidate();
					pnlBall3.repaint();
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, btnDel3, 40, SpringLayout.SOUTH, btnDel2);
			pnl.add(btnDel3);

			btnDel4 = new JButton("삭제");
			btnDel4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall4.removeAll();
					pnlBall4.revalidate();
					pnlBall4.repaint();
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, btnDel4, 44, SpringLayout.SOUTH, btnDel3);
			pnl.add(btnDel4);

			btnDel5 = new JButton("삭제");
			btnDel5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall5.removeAll();
					pnlBall5.revalidate();
					pnlBall5.repaint();
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, btnDel5, 50, SpringLayout.SOUTH, btnDel4);
			pnl.add(btnDel5);

			pnlBall1 = new JPanel();
			pnlBall1.setBackground(Color.WHITE);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall1, 100, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall1, 516, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall1, -393, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall1, -120, SpringLayout.EAST, pnl);
			pnl.add(pnlBall1);
			SpringLayout sl_pnlBall1 = new SpringLayout();
			pnlBall1.setLayout(sl_pnlBall1);

			pnlBall2 = new JPanel();
			pnlBall2.setBackground(Color.WHITE);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall2, 516, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall2, 6, SpringLayout.SOUTH, pnlBall1);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall2, -11, SpringLayout.SOUTH, btnNewButton);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall2, -120, SpringLayout.EAST, pnl);
			pnl.add(pnlBall2);
			pnlBall2.setLayout(new SpringLayout());

			pnlBall3 = new JPanel();
			springLayout.putConstraint(SpringLayout.WEST, btnDel3, 30, SpringLayout.EAST, pnlBall3);
			pnlBall3.setBackground(Color.WHITE);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall3, 6, SpringLayout.SOUTH, pnlBall2);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall3, 364, SpringLayout.EAST, btnNewButton_1);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall3, 0, SpringLayout.EAST, pnlBall1);
			pnl.add(pnlBall3);
			pnlBall3.setLayout(new SpringLayout());

			pnlBall4 = new JPanel();
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall3, -6, SpringLayout.NORTH, pnlBall4);
			springLayout.putConstraint(SpringLayout.WEST, btnDel4, 30, SpringLayout.EAST, pnlBall4);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall4, 0, SpringLayout.NORTH, btnNewButton_1);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall4, 364, SpringLayout.EAST, btnNewButton_1);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall4, -192, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall4, 0, SpringLayout.EAST, pnlBall1);
			pnlBall4.setBackground(Color.WHITE);
			pnl.add(pnlBall4);
			pnlBall4.setLayout(new SpringLayout());

			pnlBall5 = new JPanel();
			springLayout.putConstraint(SpringLayout.WEST, btnDel5, 30, SpringLayout.EAST, pnlBall5);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall5, 10, SpringLayout.SOUTH, pnlBall4);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall5, -89, SpringLayout.NORTH, btnGoBack);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall5, 0, SpringLayout.WEST, pnlBall1);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall5, 0, SpringLayout.EAST, pnlBall1);

			JLabel lblNewLabel = new JLabel();
			sl_pnlBall1.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, pnlBall1);
			sl_pnlBall1.putConstraint(SpringLayout.WEST, lblNewLabel, 140, SpringLayout.WEST, pnlBall1);
			pnlBall5.setBackground(Color.WHITE);
			pnl.add(pnlBall5);
			pnlBall5.setLayout(new SpringLayout());

			showGUI();
		}
	}

	private void reset() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (lottoNumbers[i][j] != null) {
					lottoNumbers[i][j].setSelected(false);
				} else {
					lottoNumbers[i][j] = new JToggleButton();
				}
			}
		}
	}

	private void showBall() {
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		registeredLabels = new ArrayList<>();
		pnlBall1.setLayout(flowLayout);
		pnlBall2.setLayout(flowLayout);
		pnlBall3.setLayout(flowLayout);
		pnlBall4.setLayout(flowLayout);
		pnlBall5.setLayout(flowLayout);

		showBallselectedCount = 0;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (lottoNumbers[i][j] != null && lottoNumbers[i][j].isSelected()) {
					int number = Integer.parseInt(lottoNumbers[i][j].getActionCommand());
					String file = "ball_" + number + ".png";
					ballIcon = new ImageIcon(file);
					lbl = new JLabel(ballIcon);
					registeredLabels.add(lbl);
					PurchaseHistory.pnlwinningNumber.add(lbl);

					Result.purchaseNumber1.add(lbl);

					showBallselectedCount++;
				}
			}
		}

		// 각 패널에 이미지 추가
		if (showBallselectedCount == 6) {
			for (JLabel registeredLabel : registeredLabels) {
				if (pnlBall1.getComponentCount() <= 5) {
					pnlBall1.add(registeredLabel);
				} else if (pnlBall2.getComponentCount() <= 5) {
					pnlBall2.add(registeredLabel);
				} else if (pnlBall3.getComponentCount() <= 5) {
					pnlBall3.add(registeredLabel);
				} else if (pnlBall4.getComponentCount() <= 5) {
					pnlBall4.add(registeredLabel);
				} else if (pnlBall5.getComponentCount() <= 5) {
					pnlBall5.add(registeredLabel);
				}
			}
		}

		pnlBall1.revalidate();
		pnlBall1.repaint();
		pnlBall2.revalidate();
		pnlBall2.repaint();
		pnlBall3.revalidate();
		pnlBall3.repaint();
		pnlBall4.revalidate();
		pnlBall4.repaint();
		pnlBall5.revalidate();
		pnlBall5.repaint();
	}

	private void showGUI() {
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	class InputDialog extends JDialog {
		public InputDialog(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("6개의 번호를 등록해주세요.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	class PurchaseDialog extends JDialog {
		public PurchaseDialog(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("구매완료");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	class PurchaseDialog2 extends JDialog {
		public PurchaseDialog2(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("등록된 번호가 없습니다.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	public static void main(String[] args) {
		new Purchase();
	}
}