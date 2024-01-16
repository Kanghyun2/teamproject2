package project;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Purchase extends JFrame{
	/**
	 * @wbp.nonvisual location=832,-1
	 */
	private final JRadioButton rdbtnNewRadioButton_1_1_31 = new JRadioButton("");
	public Purchase() {
		
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JRadioButton btnNumber1 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber1, 139, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNumber1, 141, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnNumber1);
		
		JRadioButton btnNumber2 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber2, 166, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNumber2, -799, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNumber1, -6, SpringLayout.WEST, btnNumber2);
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber2, 0, SpringLayout.NORTH, btnNumber1);
		getContentPane().add(btnNumber2);
		
		JRadioButton btnNumber3 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber3, 0, SpringLayout.NORTH, btnNumber1);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber3, 6, SpringLayout.EAST, btnNumber2);
		getContentPane().add(btnNumber3);
		
		JRadioButton btnNumber4 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber4, 216, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNumber3, -6, SpringLayout.WEST, btnNumber4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber4, 0, SpringLayout.SOUTH, btnNumber1);
		getContentPane().add(btnNumber4);
		
		JRadioButton btnNumber5 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber5, 6, SpringLayout.EAST, btnNumber4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber5, 0, SpringLayout.SOUTH, btnNumber1);
		getContentPane().add(btnNumber5);
		
		JRadioButton btnNumber6 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber6, 0, SpringLayout.NORTH, btnNumber1);
		getContentPane().add(btnNumber6);
		
		JRadioButton btnNumber7 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber7, 296, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNumber6, -6, SpringLayout.WEST, btnNumber7);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber7, 0, SpringLayout.SOUTH, btnNumber1);
		getContentPane().add(btnNumber7);
		
		JRadioButton btnNumber8 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber8, 0, SpringLayout.WEST, btnNumber1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber8, -372, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNumber8);
		
		JRadioButton btnNumber9 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber9, 0, SpringLayout.WEST, btnNumber2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber9, -372, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNumber9);
		
		JRadioButton btnNumber10 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber10, 8, SpringLayout.SOUTH, btnNumber3);
		getContentPane().add(btnNumber10);
		
		JRadioButton btnNumber11 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.EAST, btnNumber10, -6, SpringLayout.WEST, btnNumber11);
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber11, 6, SpringLayout.SOUTH, btnNumber4);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber11, 0, SpringLayout.EAST, btnNumber4);
		getContentPane().add(btnNumber11);
		
		JRadioButton btnNumber12 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber12, 6, SpringLayout.SOUTH, btnNumber5);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber12, 0, SpringLayout.EAST, btnNumber5);
		getContentPane().add(btnNumber12);
		
		JRadioButton btnNumber13 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber13, 8, SpringLayout.SOUTH, btnNumber6);
		getContentPane().add(btnNumber13);
		
		JRadioButton btnNumber14 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.EAST, btnNumber13, -5, SpringLayout.WEST, btnNumber14);
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber14, 6, SpringLayout.SOUTH, btnNumber7);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber14, 0, SpringLayout.EAST, btnNumber7);
		getContentPane().add(btnNumber14);
		
		JRadioButton btnNumber15 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber15, 195, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNumber15, 0, SpringLayout.WEST, btnNumber1);
		getContentPane().add(btnNumber15);
		
		JRadioButton btnNumber16 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber16, 0, SpringLayout.WEST, btnNumber2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber16, -345, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNumber16);
		
		JRadioButton btnNumber17 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber17, 6, SpringLayout.SOUTH, btnNumber10);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber17, 4, SpringLayout.EAST, btnNumber16);
		getContentPane().add(btnNumber17);
		
		JRadioButton btnNumber18 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber18, 6, SpringLayout.SOUTH, btnNumber11);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber18, 0, SpringLayout.WEST, btnNumber4);
		getContentPane().add(btnNumber18);
		
		JRadioButton btnNumber19 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber19, 6, SpringLayout.SOUTH, btnNumber13);
		getContentPane().add(btnNumber19);
		
		JRadioButton btnNumber20 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber20, 6, SpringLayout.SOUTH, btnNumber12);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber20, 0, SpringLayout.EAST, btnNumber5);
		getContentPane().add(btnNumber20);
		
		JRadioButton btnNumber21 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.EAST, btnNumber19, -5, SpringLayout.WEST, btnNumber21);
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber21, 6, SpringLayout.SOUTH, btnNumber14);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber21, 0, SpringLayout.EAST, btnNumber7);
		getContentPane().add(btnNumber21);
		
		JRadioButton btnNumber22 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber22, 6, SpringLayout.SOUTH, btnNumber15);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber22, 0, SpringLayout.WEST, btnNumber1);
		getContentPane().add(btnNumber22);
		
		JRadioButton btnNumber23 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber23, 0, SpringLayout.WEST, btnNumber2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber23, 0, SpringLayout.SOUTH, btnNumber22);
		getContentPane().add(btnNumber23);
		
		JRadioButton btnNumber24 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber24, 4, SpringLayout.EAST, btnNumber23);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber24, 0, SpringLayout.SOUTH, btnNumber22);
		getContentPane().add(btnNumber24);
		
		JRadioButton btnNumber25 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber25, 0, SpringLayout.WEST, btnNumber4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber25, 0, SpringLayout.SOUTH, btnNumber22);
		getContentPane().add(btnNumber25);
		
		JRadioButton btnNumber26 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber26, 0, SpringLayout.WEST, btnNumber5);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber26, 0, SpringLayout.SOUTH, btnNumber22);
		getContentPane().add(btnNumber26);
		
		JRadioButton btnNumber27 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber27, 6, SpringLayout.EAST, btnNumber26);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber27, 0, SpringLayout.SOUTH, btnNumber22);
		getContentPane().add(btnNumber27);
		
		JRadioButton btnNumber28 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber28, 6, SpringLayout.SOUTH, btnNumber19);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber28, 0, SpringLayout.EAST, btnNumber7);
		getContentPane().add(btnNumber28);
		
		JRadioButton btnNumber29 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber29, 10, SpringLayout.SOUTH, btnNumber22);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber29, 0, SpringLayout.WEST, btnNumber1);
		getContentPane().add(btnNumber29);
		
		JRadioButton btnNumber30 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber30, 0, SpringLayout.SOUTH, btnNumber29);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber30, 0, SpringLayout.EAST, btnNumber2);
		getContentPane().add(btnNumber30);
		
		JRadioButton btnNumber31 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber31, 6, SpringLayout.EAST, btnNumber30);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber31, 0, SpringLayout.SOUTH, btnNumber29);
		getContentPane().add(btnNumber31);
		
		JRadioButton btnNumber32 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber32, 0, SpringLayout.WEST, btnNumber4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber32, 0, SpringLayout.SOUTH, btnNumber29);
		getContentPane().add(btnNumber32);
		
		JRadioButton btnNumber33 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber33, 0, SpringLayout.WEST, btnNumber5);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber33, 0, SpringLayout.SOUTH, btnNumber29);
		getContentPane().add(btnNumber33);
		
		JRadioButton btnNumber34 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber34, 6, SpringLayout.EAST, btnNumber33);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber34, 0, SpringLayout.SOUTH, btnNumber29);
		getContentPane().add(btnNumber34);
		
		JRadioButton btnNumber35 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber35, 0, SpringLayout.WEST, btnNumber7);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber35, 0, SpringLayout.SOUTH, btnNumber29);
		getContentPane().add(btnNumber35);
		
		JRadioButton btnNumber36 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber36, 6, SpringLayout.SOUTH, btnNumber29);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber36, 0, SpringLayout.WEST, btnNumber1);
		getContentPane().add(btnNumber36);
		
		JRadioButton btnNumber37 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber37, 0, SpringLayout.WEST, btnNumber2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber37, 0, SpringLayout.SOUTH, btnNumber36);
		getContentPane().add(btnNumber37);
		
		JRadioButton btnNumber38 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber38, 6, SpringLayout.SOUTH, btnNumber31);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber38, 4, SpringLayout.EAST, btnNumber37);
		getContentPane().add(btnNumber38);
		
		JRadioButton btnNumber39 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNumber39, 0, SpringLayout.WEST, btnNumber4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber39, 0, SpringLayout.SOUTH, btnNumber36);
		getContentPane().add(btnNumber39);
		
		JRadioButton btnNumber40 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber40, 6, SpringLayout.SOUTH, btnNumber33);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber40, 0, SpringLayout.WEST, btnNumber5);
		getContentPane().add(btnNumber40);
		
		JRadioButton btnNumber41 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber41, 0, SpringLayout.SOUTH, btnNumber36);
		getContentPane().add(btnNumber41);
		
		JRadioButton btnNumber42 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.EAST, btnNumber41, -5, SpringLayout.WEST, btnNumber42);
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber42, 6, SpringLayout.SOUTH, btnNumber35);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber42, 0, SpringLayout.WEST, btnNumber7);
		getContentPane().add(btnNumber42);
		
		JRadioButton btnNumber43 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber43, 4, SpringLayout.SOUTH, btnNumber36);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber43, 0, SpringLayout.WEST, btnNumber1);
		getContentPane().add(btnNumber43);
		
		JRadioButton btnNumber44 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumber44, 0, SpringLayout.SOUTH, btnNumber43);
		springLayout.putConstraint(SpringLayout.EAST, btnNumber44, 0, SpringLayout.EAST, btnNumber9);
		getContentPane().add(btnNumber44);
		
		JRadioButton btnNumber45 = new JRadioButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNumber45, 6, SpringLayout.SOUTH, btnNumber38);
		springLayout.putConstraint(SpringLayout.WEST, btnNumber45, 4, SpringLayout.EAST, btnNumber44);
		getContentPane().add(btnNumber45);
		
		JButton btnNewButton = new JButton("자동 선택");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 166, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 199, SpringLayout.NORTH, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("반 자동");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 36, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNumber29);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 95, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("구매");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -50, SpringLayout.SOUTH, getContentPane());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JButton btnGoBack = new JButton("뒤로가기");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMain guimain = new GUIMain();
				guimain.setVisible(true);
				setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, -180, SpringLayout.WEST, btnGoBack);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -89, SpringLayout.WEST, btnGoBack);
		springLayout.putConstraint(SpringLayout.WEST, btnGoBack, 718, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnGoBack, -50, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnGoBack);
		
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
