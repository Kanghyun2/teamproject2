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
			
			// 泥� 踰덉㎏ �뿴�� �쇊履쎌뿉 怨좎젙
			if (col == 0) {
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], 180, SpringLayout.WEST, pnl);
			} else {
				// �굹癒몄� �뿴�� �씠�쟾 泥댄겕諛뺤뒪瑜� 湲곗��쑝濡� �쐞移� 議곗젙 (媛�濡쒕줈 諛곗튂)
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], checkboxMargin, SpringLayout.EAST,
						lottoNumbers[row][col - 1]);
			}

			// 泥� 踰덉㎏ �뻾�� �긽�떒�뿉 怨좎젙
			if (row == 0) {
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], 150, SpringLayout.NORTH, pnl);
			} else {
				// �굹癒몄� �뻾�� �씠�쟾 �뻾�쓽 泥� 踰덉㎏ �뿴�쓣 湲곗��쑝濡� �쐞移� 議곗젙 (�꽭濡쒕줈 諛곗튂)
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], checkboxMargin,
						SpringLayout.SOUTH, lottoNumbers[row - 1][0]);
			}
		}

		JButton btnNewButton = new JButton("�옄�룞 �꽑�깮");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 222, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 67, SpringLayout.WEST, pnl);
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("諛� �옄�룞");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 64, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		pnl.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("援щℓ");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, pnl);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pnl.add(btnNewButton_2);

		JButton btnGoBack = new JButton("�뮘濡쒓�湲�");
		springLayout.putConstraint(SpringLayout.SOUTH, btnGoBack, -10, SpringLayout.SOUTH, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnGoBack, -10, SpringLayout.WEST, btnNewButton_2);
		pnl.add(btnGoBack);

		JButton btnRegistration = new JButton("�벑濡�");
		springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 387, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -49, SpringLayout.SOUTH, pnl);
		pnl.add(btnRegistration);

		// pnl.setLayout(new SpringLayout()); // �씠 �씪�씤�� �궘�젣

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