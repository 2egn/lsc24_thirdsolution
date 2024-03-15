package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import core.SQLExecutor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import model.Auction;
import model.Building;
import javax.swing.JSplitPane;

public class MainForm extends JFrame {
	SQLExecutor executor = new SQLExecutor();
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
				new Search().setVisible(true);
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
		ViewMapBtn.setFont(new Font("굴림", Font.PLAIN, 12));
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
		PopularAuctionPanel.setBounds(326, 98, 246, 215);
		PopularAuctionPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		getContentPane().add(PopularAuctionPanel);
		PopularAuctionPanel.setLayout(null);
		JSplitPane popularsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JLabel populartext = new JLabel("인기경매");
		popularsplit.setTopComponent(populartext);
		
		
		JLabel lblNewLabel = new JLabel("\uCD5C\uADFC \uB9E4\uAC01 \uB0B4\uC5ED");
		lblNewLabel.setBounds(326, 323, 124, 15);
		getContentPane().add(lblNewLabel);
		
		//옥션 리스트 생성 및 값 삽입
		List<Auction> auctionlist = new ArrayList<>();//java.util.*
		try {
			executor.Connect();
			ResultSet rs = executor.executeReadQuery("SELECT * FROM auction.auction ORDER BY STR_TO_DATE(a_date,'%Y-%m-%d') DESC, b_no ASC");
			while(rs.next()) {
				auctionlist.add(new Auction(rs.getString("a_no"),rs.getString("b_no"),rs.getString("u_no"),rs.getString("a_date")));
			}
			executor.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//건물 리스트 생성 및 값 삽입
		List<Building> a_buildinglist = new ArrayList<>();
		try {
			for (Auction auc : auctionlist) {
				executor.Connect();
				ResultSet rs = executor.executeReadQuery("SELECT * FROM auction.building WHERE b_no='"+auc.returnAucNum()+"'");
				while(rs.next()) {
					a_buildinglist.add(new Building(rs.getString("b_no"),rs.getString("b_name"),rs.getString("b_price"),rs.getString("b_date"),rs.getString("b_type"),rs.getString("b_x"),rs.getString("b_y"),rs.getString("ar_no"),rs.getString("b_count")));
				}
			}
			executor.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//스크롤페인(최근경매)
		JScrollPane AuctionscrollPane = new JScrollPane();
		AuctionscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		AuctionscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		AuctionscrollPane.setBounds(326, 348, 247, 176);
		getContentPane().add(AuctionscrollPane);
		//플로우레이아웃(최근경매)
		String filepath = "C:\\thirdproblem\\datafiles\\building\\";
		JPanel zoneA = new JPanel();
		GridLayout gl_zoneA = new GridLayout(5,2);
		gl_zoneA.setHgap(5);
		gl_zoneA.setVgap(5);
		zoneA.setLayout(gl_zoneA);
		zoneA.setSize(247,176);
		AuctionscrollPane.add(zoneA);
		AuctionscrollPane.setViewportView(zoneA);
		
		
		
		
		//flowlayout에 이미지들 삽입
		for(Building bui : a_buildinglist) {
			JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			//이미지
			JPanel UpPanel = new JPanel();
			String path = filepath+bui.getBuilidngName()+"1.jpg";
			ImageIcon icon = new ImageIcon(path);
			JLabel imagelabel = new JLabel(imagesizeset(icon, 120, 80));		
			UpPanel.add(imagelabel);
			//가격,위치
			JPanel DownPanel = new JPanel(new GridLayout(2,1));
			JLabel PriceLabel = new JLabel(bui.getBuildingPrice());
			PriceLabel.setFont(new Font("돋움", Font.BOLD,15));
			JLabel AreaLabel = new JLabel(bui.getAreaName());
			DownPanel.add(PriceLabel);
			DownPanel.add(AreaLabel);
			splitPane.setTopComponent(UpPanel);
			splitPane.setBottomComponent(DownPanel);
			splitPane.setDividerSize(0);
			splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			splitPane.setSize(95,100);
			zoneA.add(splitPane);
		}
		
	}
	private ImageIcon imagesizeset(ImageIcon icon, int i, int j) {
		Image img = icon.getImage();
		Image updatedimg = img.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		ImageIcon finalimg = new ImageIcon(updatedimg);
		return finalimg;
	}
}
