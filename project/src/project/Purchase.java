package project;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Purchase extends JFrame {
    public Purchase() {
        JPanel pnl = new JPanel();
        add(pnl);

        SpringLayout springLayout = new SpringLayout();
        pnl.setLayout(springLayout);

        JCheckBox[] lottoNumber = new JCheckBox[45];
        
        for (int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = new JCheckBox(Integer.toString(i + 1));
            pnl.add(lottoNumber[i]);
            if (i > 0) {
            	springLayout.putConstraint(SpringLayout.WEST, lottoNumber[i], 5, SpringLayout.EAST, lottoNumber[i - 1]);
            } else {
            	springLayout.putConstraint(SpringLayout.WEST, lottoNumber[i], 5, SpringLayout.WEST, pnl);
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
