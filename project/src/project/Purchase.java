package project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Component;

public class Purchase extends JFrame {
	private JToggleButton[][] lottoNumbers;
//	private List<JLabel> registeredLabels = new ArrayList<>();
	private JButton btnNewButton_1;
	private ImageIcon[][] originalIcons;
	private JPanel pnl;
	private JPanel pnlBall1;
	private JPanel pnlBall2;
	private JPanel pnlBall3;
	private JPanel pnlBall4;
	private JPanel pnlBall5;
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
	public Purchase() {
		setTitle("구매 화면");
		getContentPane().setBackground(Color.WHITE);
		pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		getContentPane().add(pnl);
		SpringLayout springLayout = new SpringLayout();
		pnl.setLayout(springLayout);
		
//		 아직은 토글버튼 이미지 오류 발견X
//		 미구현
//		 라벨 이미지 토글버튼 렉걸린건지 다 안나옴
// 		 해줘		
		

		int checkboxMargin = 1; // 버튼 간격

		originalIcons = new ImageIcon[rows][cols]; // 버튼 누르고 다시 눌럿을때 복구 사진 저장
		lottoNumbers = new JToggleButton[rows][cols];
		
		String gifFilePath = "구매창배경.png";
		ImageIcon imageIcon = new ImageIcon(gifFilePath);
		Image image = imageIcon.getImage().getScaledInstance(970, 550, Image.SCALE_DEFAULT);
		JLabel gifLabel = new JLabel(new ImageIcon(image));
		gifLabel.setLayout(springLayout);
//		JLayeredPane layeredPane = new JLayeredPane();
//		layeredPane.setPreferredSize(new Dimension(970, 550));
//		layeredPane.add(gifLabel, 0);
		
		
//		lbl = new JLabel(new ImageIcon("회색공.png"));
		
		
		for (int i = 0; i <= 45; i++) { // 7x7 45 버튼으로 표현
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
			gifLabel.setBackground(Color.WHITE);
			pnl.add(gifLabel);
			gifLabel.add(lottoNumbers[row][col]);
		
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
			}

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
		
			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 200, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 80, SpringLayout.WEST, pnl);
			gifLabel.add(btnNewButton);
			
			btnNewButton_1 = new JButton("반 자동");
			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 38, SpringLayout.SOUTH, btnNewButton);
			springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
			btnNewButton_1.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					halfRandom();
//					if (showBallselectedCount < 6 || showBallselectedCount > 6) {
//				        InputDialog dialog = new InputDialog(Purchase.this);
//				        dialog.setVisible(true);
//				    }
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
			gifLabel.add(btnNewButton_1);

			JButton btnNewButton_2 = new JButton("구매");
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -123, SpringLayout.EAST, pnl);
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
						PurchaseHistory.pnlpurchaseNumber.put(PurchaseHistory.numberOfPurchases, new ArrayList<>(PurchaseHistory.pnlwinningNumber));
						PurchaseHistory.numberOfPurchases++;
					}
					
					PurchaseHistory.pnlwinningNumber.clear();
				}
			});
			gifLabel.add(btnNewButton_2);

			JButton btnGoBack = new JButton("뒤로가기");
			springLayout.putConstraint(SpringLayout.SOUTH, btnGoBack, -10, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnGoBack, -10, SpringLayout.EAST, pnl);
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIMain guimain = new GUIMain();
					guimain.setVisible(true);
					setVisible(false);
				}
			});
			gifLabel.add(btnGoBack);

			btnRegistration = new JButton("");
			btnRegistration.setIcon(new ImageIcon("확인 버튼.png"));
			btnRegistration.setBorderPainted(false);
			btnRegistration.setFocusPainted(false);
			btnRegistration.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 367, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -126, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnRegistration, -380, SpringLayout.WEST, btnNewButton_2);
			btnRegistration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showBall();	

					if (showBallselectedCount < 6 || showBallselectedCount > 6) {
					        InputDialog dialog = new InputDialog(Purchase.this);
					        dialog.setVisible(true);
					    }
					}
					
			});
			gifLabel.add(btnRegistration);

			JButton btnNewButton_3 = new JButton("");
			btnNewButton_3.setIcon(new ImageIcon("초기화.png"));
			btnNewButton_3.setBorderPainted(false);
			btnNewButton_3.setFocusPainted(false);
			btnNewButton_3.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.NORTH, btnRegistration, 36, SpringLayout.SOUTH, btnNewButton_3);
			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 353, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -185, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 349, SpringLayout.WEST, pnl);
//			btnNewButton_3.setBorderPainted(false); // 나중에
//			btnNewButton_3.setFocusPainted(false);
//			btnNewButton_3.setContentAreaFilled(false);
			btnNewButton_3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			gifLabel.add(btnNewButton_3);

			btnDel1 = new JButton("");
			btnDel1.setIcon(new ImageIcon("삭제.png"));
			btnDel1.setBorderPainted(false);
			btnDel1.setFocusPainted(false);
			btnDel1.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.NORTH, btnDel1, 135, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnDel1, 0, SpringLayout.EAST, btnNewButton_2);
			btnDel1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnlBall1.removeAll();
					pnlBall1.revalidate();
					pnlBall1.repaint();

				}
			});
			gifLabel.add(btnDel1);

			btnDel2 = new JButton("");
			btnDel2.setIcon(new ImageIcon("삭제.png"));
			btnDel2.setBorderPainted(false);
			btnDel2.setFocusPainted(false);
			btnDel2.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel1, -10, SpringLayout.NORTH, btnDel2);
			springLayout.putConstraint(SpringLayout.EAST, btnDel2, 0, SpringLayout.EAST, btnNewButton_2);
			springLayout.putConstraint(SpringLayout.WEST, btnDel2, -33, SpringLayout.EAST, btnNewButton_2);
			springLayout.putConstraint(SpringLayout.NORTH, btnDel2, -23, SpringLayout.NORTH, btnNewButton);
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel2, 9, SpringLayout.NORTH, btnNewButton);
			btnDel2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall2.removeAll();
					pnlBall2.revalidate();
					pnlBall2.repaint();
				}
			});
			gifLabel.add(btnDel2);

			btnDel3 = new JButton("");
			btnDel3.setIcon(new ImageIcon("삭제.png"));
			btnDel3.setBorderPainted(false);
			btnDel3.setFocusPainted(false);
			btnDel3.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.NORTH, btnDel3, 14, SpringLayout.SOUTH, btnDel2);
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel3, -306, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnDel3, 0, SpringLayout.EAST, btnNewButton_2);
			btnDel3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall3.removeAll();
					pnlBall3.revalidate();
					pnlBall3.repaint();
				}
			});
			gifLabel.add(btnDel3);

			btnDel4 = new JButton("");
			btnDel4.setIcon(new ImageIcon("삭제.png"));
			btnDel4.setBorderPainted(false);
			btnDel4.setFocusPainted(false);
			btnDel4.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.NORTH, btnDel4, 13, SpringLayout.SOUTH, btnDel3);
			springLayout.putConstraint(SpringLayout.WEST, btnDel4, 0, SpringLayout.WEST, btnDel1);
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel4, -261, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, btnDel4, 0, SpringLayout.EAST, btnNewButton_2);
			btnDel4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall4.removeAll();
					pnlBall4.revalidate();
					pnlBall4.repaint();
				}
			});
			gifLabel.add(btnDel4);

			btnDel5 = new JButton("");
			btnDel5.setIcon(new ImageIcon("삭제.png"));
			btnDel5.setBorderPainted(false);
			btnDel5.setFocusPainted(false);
			btnDel5.setContentAreaFilled(false);
			springLayout.putConstraint(SpringLayout.NORTH, btnDel5, 20, SpringLayout.SOUTH, btnDel4);
			springLayout.putConstraint(SpringLayout.WEST, btnDel5, 0, SpringLayout.WEST, btnDel1);
			springLayout.putConstraint(SpringLayout.EAST, btnDel5, 33, SpringLayout.WEST, btnDel1);
			btnDel5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlBall5.removeAll();
					pnlBall5.revalidate();
					pnlBall5.repaint();
				}
			});
			gifLabel.add(btnDel5);

			pnlBall1 = new JPanel();
			springLayout.putConstraint(SpringLayout.WEST, btnDel1, 18, SpringLayout.EAST, pnlBall1);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall1, -174, SpringLayout.EAST, pnl);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall1, 135, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall1, 539, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall1, -382, SpringLayout.SOUTH, pnl);
			pnlBall1.setBackground(Color.WHITE);
			pnl.add(pnlBall1);
			SpringLayout sl_pnlBall1 = new SpringLayout();
			pnlBall1.setLayout(sl_pnlBall1);
			
			pnlBall2 = new JPanel();
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall2, 0, SpringLayout.SOUTH, pnlBall1);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall2, 0, SpringLayout.WEST, pnlBall1);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall2, 0, SpringLayout.EAST, pnlBall1);
			pnlBall2.setBackground(Color.WHITE);
			pnl.add(pnlBall2);
			pnlBall2.setLayout(new SpringLayout());

			pnlBall3 = new JPanel();
			springLayout.putConstraint(SpringLayout.WEST, btnDel3, 18, SpringLayout.EAST, pnlBall3);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall3, 223, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall3, -294, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall2, 0, SpringLayout.NORTH, pnlBall3);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall3, 0, SpringLayout.WEST, pnlBall1);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall3, 0, SpringLayout.EAST, pnlBall1);
			pnlBall3.setBackground(Color.WHITE);
			pnl.add(pnlBall3);
			pnlBall3.setLayout(new SpringLayout());

			pnlBall4 = new JPanel();
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall4, 1, SpringLayout.SOUTH, pnlBall3);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall4, 0, SpringLayout.WEST, pnlBall1);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall4, -249, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall4, 0, SpringLayout.EAST, pnlBall1);
			pnlBall4.setBackground(Color.WHITE);
			pnl.add(pnlBall4);
			pnlBall4.setLayout(new SpringLayout());

			pnlBall5 = new JPanel();
			springLayout.putConstraint(SpringLayout.SOUTH, btnDel5, -5, SpringLayout.SOUTH, pnlBall5);
			springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -143, SpringLayout.WEST, pnlBall5);
			springLayout.putConstraint(SpringLayout.NORTH, pnlBall5, 1, SpringLayout.SOUTH, pnlBall4);
			springLayout.putConstraint(SpringLayout.SOUTH, pnlBall5, -204, SpringLayout.SOUTH, pnl);
			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 44, SpringLayout.SOUTH, pnlBall5);
			springLayout.putConstraint(SpringLayout.WEST, pnlBall5, 539, SpringLayout.WEST, pnl);
			springLayout.putConstraint(SpringLayout.EAST, pnlBall5, 0, SpringLayout.EAST, pnlBall1);

			JLabel lblNewLabel = new JLabel();
			sl_pnlBall1.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, pnlBall1);
			sl_pnlBall1.putConstraint(SpringLayout.WEST, lblNewLabel, 140, SpringLayout.WEST, pnlBall1);
			pnlBall5.setBackground(Color.WHITE);
			pnl.add(pnlBall5);
			pnlBall5.setLayout(new SpringLayout());

			showGUI();
		
//		getContentPane().add(layeredPane);
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
//					int number = Integer.parseInt(lottoNumbers[i][j].getText()); // 버튼 이미지 크기 텍스트 때문에 안맞아서 커맨드로 바꿈
					String file = "ball_" + number + ".png";
					ballIcon = new ImageIcon(file);
					
					int ballWidth = ballIcon.getIconWidth();
					int ballHeight = ballIcon.getIconHeight();

					// 이미지 크기 조절
					Image originalImage = ballIcon.getImage();
					Image resizedImage = originalImage.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
					ballIcon = new ImageIcon(resizedImage);
					
					lbl = new JLabel(ballIcon);
					registeredLabels.add(lbl);
					PurchaseHistory.pnlwinningNumber.add(lbl);
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
//	

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