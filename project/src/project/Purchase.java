package project;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;

public class Purchase extends JFrame {
	private JToggleButton[][] lottoNumbers;
	private JButton btnNewButton_1;

	private ImageIcon[] loadImages() {
		ImageIcon[] images = new ImageIcon[45];
		
		 for (int i = 0; i < 45; i++) {
		        int num = i + 1;
		        String file = "ball_" + num + ".png";
		        images[i] = new ImageIcon(file);
		    }

		return images;
	}

	public Purchase() {
		Random ran = new Random();
		JPanel pnl = new JPanel();
		getContentPane().add(pnl);

		SpringLayout springLayout = new SpringLayout();
		pnl.setLayout(springLayout);

		int rows = 7;
		int cols = 7;
		int checkboxMargin = 10;

		lottoNumbers = new JToggleButton[rows][cols];

		for (int i = 0; i < 45; i++) {
			int row = i / cols;
			int col = i % cols;

			lottoNumbers[row][col] = new JToggleButton(Integer.toString(i + 1));
			lottoNumbers[row][col].setPreferredSize(new Dimension(25, 25));
			pnl.add(lottoNumbers[row][col]);

			// 첫 번째 열은 왼쪽에 고정
			if (col == 0) {
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], 180, SpringLayout.WEST, pnl);
			} else {
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
				}

				Collections.shuffle(allButton);
				int Count = 0;
				for (JToggleButton button : allButton) {
					if (Count < 6) {
						button.setSelected(true);
						Count++;
					} else if (Count >= 6) {
						button.setSelected(false);
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
			private int selectedCount;

			public void actionPerformed(ActionEvent e) {
				halfRandom();
				if (selectedCount <= 0 || selectedCount >= 7) {
					InputDialog dialog = new InputDialog(Purchase.this);
					dialog.setVisible(true);
				}
			}

			public void halfRandom() {
				List<JToggleButton> allButton = new ArrayList<>();
				selectedCount = 0;

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
				btnNewButton_1.setEnabled(false);
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

		JButton btnRegistration = new JButton("등록");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 350, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -126, SpringLayout.SOUTH, pnl);
		pnl.add(btnRegistration);

		showGUI();
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
			JLabel lbl = new JLabel("1개 ~ 6개만 선택 가능 합니다.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

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
		System.out.println("테스트");
	}
}