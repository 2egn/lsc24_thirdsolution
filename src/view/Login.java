package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import core.SQLExecutor;
import model.User;

public class Login extends JFrame{

	private JPanel contentPane;
	private JTextField IDBox;
	private JLabel lblNewLabel_1;
	private JTextField PWBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		SQLExecutor executor = new SQLExecutor();
		User.Init();
		setTitle("�α���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDBox = new JTextField();
		IDBox.setBounds(105, 10, 230, 33);
		contentPane.add(IDBox);
		IDBox.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(22, 19, 57, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(22, 59, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		PWBox = new JTextField();
		PWBox.setColumns(10);
		PWBox.setBounds(105, 50, 230, 33);
		contentPane.add(PWBox);
		
		JButton LoginButton = new JButton("�α��ι�ư");
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idstring = IDBox.getText();
				String pwstring = PWBox.getText();
				//��������Ȯ������
				try {
					if(idstring.isEmpty()||pwstring.isEmpty()) {//A. �� �׸�
						JOptionPane.showMessageDialog(null, "�Է����� ���� �׸��� �ֽ��ϴ�.","���",JOptionPane.ERROR_MESSAGE);
					}
					else {//B,C,D	
						//<��������Ȯ�� sql>
						executor.Connect();
						String query = "SELECT * FROM auction.user WHERE u_id = '"+idstring+"' AND u_pw = '"+pwstring+"'";
						ResultSet resultset = executor.executeReadQuery(query);
						executor.close();
						//</��������Ȯ�� sql>
						if(!resultset.next()){//B. ������ ȸ��
							JOptionPane.showMessageDialog(null, "�����ϴ� ȸ���� �����ϴ�.","���",JOptionPane.ERROR_MESSAGE);
						}
						else {//C,D
							executor.Connect();
							ResultSet rs = executor.executeReadQuery("SELECT * FROM auction.user WHERE u_id = '"+idstring+"'");
							while(rs.absolute(0)) {
								User.u_no = String.valueOf(rs.getInt("u_no"));
								User.u_id = String.valueOf(rs.getInt("u_id"));
								User.u_pw = String.valueOf(rs.getInt("u_pw"));
								User.q_no = String.valueOf(rs.getInt("q_no"));
								User.u_answer= String.valueOf(rs.getInt("u_answer"));
								executor.close();
							}
							executor.close();
							if(idstring.equals("admin")) {//C. ������ �α��ν�
								JOptionPane.showMessageDialog(null, "�����ڴ� ȯ���մϴ�.","����",JOptionPane.INFORMATION_MESSAGE);
							}else {//D. ���� �α��ν�
								JOptionPane.showMessageDialog(null, idstring,"����",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		LoginButton.setBackground(new Color(135, 206, 235));
		LoginButton.setBounds(22, 91, 147, 34);
		contentPane.add(LoginButton);
		//ȸ������ ��ư
		JButton RegiButton = new JButton("ȸ������");
		RegiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "dd");
				new view.Register().setVisible(true);;
				
			}
		});
		RegiButton.setForeground(new Color(255, 255, 255));
		RegiButton.setBackground(new Color(135, 206, 235));
		RegiButton.setBounds(181, 91, 147, 34);
		contentPane.add(RegiButton);
	}
}
