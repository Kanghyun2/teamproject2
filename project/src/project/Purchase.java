package project;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;

public class Purchase extends JFrame {
	public Purchase() {
		JPanel pnl = new JPanel();
		getContentPane().add(pnl);

		SpringLayout springLayout = new SpringLayout();
		pnl.setLayout(springLayout);

		int rows = 7;
		int cols = 7;
		int checkboxMargin = 10;

		JToggleButton[][] lottoNumbers = new JToggleButton[rows][cols];
		

		
		for (int i = 0; i < 45; i++) {
			int row = i / cols;
			int col = i % cols;

			lottoNumbers[row][col] = new JToggleButton(Integer.toString(i + 1));
			lottoNumbers[row][col].setPreferredSize(new Dimension(25,25));
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
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 222, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 67, SpringLayout.WEST, pnl);
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("반 자동");
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
		springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 387, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -49, SpringLayout.SOUTH, pnl);
		pnl.add(btnRegistration);

		// pnl.setLayout(new SpringLayout()); // 이 라인은 삭제

		showGUI();
	}

	private void showGUI() {
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Purchase();
	}
}