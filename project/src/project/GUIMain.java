package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GUIMain extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frame = new GUIMain();
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
	public GUIMain() {
		GUImathod();
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Purchase();
				dispose();
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Result result = new Result();
				result.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PurchaseHistory().setVisible(true);
				dispose();
			}
		});
		
	}
	public void GUImathod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel() {
			@Override
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0,1000, 600, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        getContentPane().add(panel);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		icon = new ImageIcon("C:\\Users\\GGG\\Desktop\\테스트.jpg");
		
	
		btnNewButton = new JButton("구매",new ImageIcon("C:\\Users\\GGG\\Desktop\\구매.png"));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 71, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -75, SpringLayout.SOUTH, panel);
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(btnNewButton);
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		
		btnNewButton_1 = new JButton("", new ImageIcon("C:\\Users\\GGG\\Desktop\\당첨결과2.png") );
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -63, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 337, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 386, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -75, SpringLayout.SOUTH, panel);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(btnNewButton_1);
		
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		
		btnNewButton_2 = new JButton("구매 내역");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -55, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 337, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -75, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 673, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -56, SpringLayout.EAST, panel);
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(btnNewButton_2);
		
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
	}
}
