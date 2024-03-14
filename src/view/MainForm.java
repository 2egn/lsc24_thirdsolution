package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class MainForm extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("\uBA54\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 573);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 585, 88);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Logout = new JLabel("\uACBD\uB9E4\uC54C\uB9BC\uC774");
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다","정보",JOptionPane.INFORMATION_MESSAGE);
				new Login().setVisible(true);
				dispose();
			}
		});
		Logout.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 22));
		Logout.setForeground(new Color(255, 255, 255));
		Logout.setBounds(12, 15, 121, 63);
		panel.add(Logout);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1.setBounds(426, 63, 34, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB9C8\uC774\uD648");
		lblNewLabel_1_1.setBounds(472, 63, 45, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uACBD\uB9E4\uC54C\uB9BC");
		lblNewLabel_1_2.setBounds(527, 63, 58, 15);
		panel.add(lblNewLabel_1_2);
		
		JLabel SearchBtn = new JLabel("");		
		SearchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO 검색 폼 이동
			}
		});
		SearchBtn.setBounds(413, 10, 52, 52);
		panel.add(SearchBtn);
		SearchBtn.setIcon(imagesizeset(new ImageIcon("C:\\thirdproblem\\datafiles\\image\\\uAC80\uC0C9.png"),50,50));
		
		JLabel MyhomeBtn = new JLabel("");
		MyhomeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO 마이홈 폼 이동
			}
		});
		MyhomeBtn.setIcon(imagesizeset(new ImageIcon("C:\\thirdproblem\\datafiles\\image\\\uB9C8\uC774\uD648.png"),40,40));
		MyhomeBtn.setBounds(472, 10, 52, 52);
		panel.add(MyhomeBtn);
		
		JLabel AlarmpageBtn = new JLabel("");
		AlarmpageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO 경매알림 폼 이동
			}
		});
		AlarmpageBtn.setIcon(imagesizeset(new ImageIcon("C:\\thirdproblem\\datafiles\\image\\\uACBD\uB9E4\uC77C\uC815.png"),35,35));
		AlarmpageBtn.setBounds(533, 10, 52, 52);
		panel.add(AlarmpageBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 98, 304, 426);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel ViewMapBtn = new JLabel("지도보기");
		ViewMapBtn.setBackground(Color.WHITE);
		ViewMapBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ViewMapBtn.setBounds(104, 10, 85, 27);
		ViewMapBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ViewMapBtn.setOpaque(true);
		panel_1.add(ViewMapBtn);
		
		JLabel MapImage = new JLabel("");
		MapImage.setIcon(imagesizeset(new ImageIcon("C:\\thirdproblem\\datafiles\\map\\\uC804\uCCB4.jpg"),304,426));
		MapImage.setBounds(0, 0, 304, 426);
		MapImage.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel_1.add(MapImage);
		
		JPanel PopularAuctionPanel = new JPanel();
		PopularAuctionPanel.setBounds(327, 98, 246, 215);
		PopularAuctionPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		getContentPane().add(PopularAuctionPanel);
		PopularAuctionPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC778\uAE30\uACBD\uB9E4");
		lblNewLabel_2.setBounds(12, 10, 57, 15);
		PopularAuctionPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("\uCD5C\uADFC \uB9E4\uAC01 \uB0B4\uC5ED");
		lblNewLabel.setBounds(326, 323, 124, 15);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 348, 247, 176);
		getContentPane().add(scrollPane);
		
		JPanel zoneA = new JPanel();
		zoneA.setLayout(new FlowLayout());
	}
	private ImageIcon imagesizeset(ImageIcon icon, int i, int j) {
		Image img = icon.getImage();
		Image updatedimg = img.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		ImageIcon finalimg = new ImageIcon(updatedimg);
		return finalimg;
	}
}
