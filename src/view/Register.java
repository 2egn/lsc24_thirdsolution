package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import core.SQLExecutor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JFrame {
	SQLExecutor executor = new SQLExecutor();
	private JPanel contentPane;
	private JTextField NameBox;
	private JTextField IDBox;
	private JTextField PWBox;
	private JTextField PWConfirmBox;
	private JTextField PhoneNumBox;
	private JTextField ConfirmNumBox;
	private JTextField AnswerBox;
	private JComboBox QuestionCombo;
	Random random = new Random();
	int AuthCode;
	boolean isVerificated=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(22, 79, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_6.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_6.setBounds(183, 10, 142, 48);
		contentPane.add(lblNewLabel_6);
		
		NameBox = new JTextField();
		NameBox.setBounds(123, 66, 222, 41);
		contentPane.add(NameBox);
		NameBox.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(22, 130, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		IDBox = new JTextField();
		IDBox.setColumns(10);
		IDBox.setBounds(123, 117, 222, 41);
		contentPane.add(IDBox);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(22, 181, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		PWBox = new JTextField();
		PWBox.setColumns(10);
		PWBox.setBounds(123, 168, 222, 41);
		contentPane.add(PWBox);
		
		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_3.setBounds(22, 232, 82, 15);
		contentPane.add(lblNewLabel_3);
		
		PWConfirmBox = new JTextField();
		PWConfirmBox.setColumns(10);
		PWConfirmBox.setBounds(123, 219, 222, 41);
		contentPane.add(PWConfirmBox);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_4.setBounds(22, 283, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		PhoneNumBox = new JTextField();
		PhoneNumBox.setColumns(10);
		PhoneNumBox.setBounds(123, 270, 222, 41);
		contentPane.add(PhoneNumBox);
		
		JLabel lblNewLabel_5 = new JLabel("\uC778\uC99D\uBC88\uD638 \uD655\uC778");
		lblNewLabel_5.setBounds(22, 334, 89, 15);
		contentPane.add(lblNewLabel_5);
		
		ConfirmNumBox = new JTextField();
		ConfirmNumBox.setColumns(10);
		ConfirmNumBox.setBounds(123, 321, 222, 41);
		contentPane.add(ConfirmNumBox);
		
		
		JButton ConfirmNumRecieveBtn = new JButton("\uC778\uC99D\uBC88\uD638 \uBC1B\uAE30");
		ConfirmNumRecieveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phonenum = PhoneNumBox.getText();
				if(phonenum.isEmpty()) {//1. ��ȭ��ȣ���� ��ĭ�� ���.
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �Է����ּ���.","���",JOptionPane.ERROR_MESSAGE);
				}else if(!phonenum.matches("\\d{3}-\\d{4}-\\d{4}")) {//2.��ȭ��ȣ ������ ���� ���� ���.
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ Ȯ�����ּ���.","���",JOptionPane.ERROR_MESSAGE);
				}else {//3. ������ ������ ���.
					AuthCode = random.nextInt(10000);
					String CodeString = String.format("%04d", AuthCode);
					JOptionPane.showMessageDialog(null, "������ȣ�� "+CodeString+" �Դϴ�.","����",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		ConfirmNumRecieveBtn.setForeground(new Color(255, 255, 255));
		ConfirmNumRecieveBtn.setBackground(new Color(173, 216, 230));
		ConfirmNumRecieveBtn.setBounds(357, 270, 108, 41);
		contentPane.add(ConfirmNumRecieveBtn);
		
		JButton CheckBtn = new JButton("Ȯ���ϱ�");
		CheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ConfirmNumBox.getText().isEmpty() || AuthCode!=Integer.parseInt(ConfirmNumBox.getText())){//�����ڵ� ���� or �����ڵ� ����ġ
					JOptionPane.showMessageDialog(null, "�ùٸ��� ���� ������ȣ �Դϴ�","���",JOptionPane.ERROR_MESSAGE);
					AuthCode = random.nextInt(10000);
					String CodeString = String.format("%04d", AuthCode);
					JOptionPane.showMessageDialog(null, "������ȣ�� "+CodeString+" �Դϴ�.","����",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�","����",JOptionPane.INFORMATION_MESSAGE);
					isVerificated=true;
				}
			}
		});
		CheckBtn.setForeground(Color.WHITE);
		CheckBtn.setBackground(new Color(173, 216, 230));
		CheckBtn.setBounds(357, 321, 108, 41);
		contentPane.add(CheckBtn);
		
		//���� �޺����� ����
		QuestionCombo = new JComboBox();
		QuestionCombo.setBounds(12, 375, 333, 46);
		contentPane.add(QuestionCombo);
		QuestionCombo.addItem(null);
		QuestionCombo.setSelectedIndex(0);	
		try {
			executor.Connect();
			ResultSet rs = executor.executeReadQuery("SELECT q_ask FROM auction.question");
			while(rs.next()) {
				String questionString = rs.getString("q_ask");
				QuestionCombo.addItem(questionString);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		AnswerBox = new JTextField();
		//placeholder
		AnswerBox.setText("����Ȯ�� ���� �亯");
		AnswerBox.setForeground(Color.GRAY);
		AnswerBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(AnswerBox.getText().equals("����Ȯ�� ���� �亯")) {
					AnswerBox.setText(null);
					AnswerBox.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(AnswerBox.getText().isEmpty()) {
					AnswerBox.setText("����Ȯ�� ���� �亯");
					AnswerBox.setForeground(Color.gray);
				}
			}
		});
		AnswerBox.setColumns(10);
		AnswerBox.setBounds(12, 431, 333, 41);
		
		contentPane.add(AnswerBox);
		
		JButton RegisterBtn = new JButton("ȸ������");
		RegisterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emptyCheck()&&duplicateCheck()&&passwordformatcheck()&&pwEqualCheck()&&questionNullCheck()&&isVerificated) {
					JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.","����",JOptionPane.INFORMATION_MESSAGE);
					try {
						executor.Connect();
						executor.executeUpdateQuery("INSERT INTO auction.user (u_id,u_pw,q_no,u_answer) VALUES('"+IDBox.getText()+"','"+PWBox.getText()+"','"+QuestionCombo.getSelectedIndex()+"','"+AnswerBox.getText()+"')");
						executor.close();
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		RegisterBtn.setForeground(Color.WHITE);
		RegisterBtn.setBackground(new Color(173, 216, 230));
		RegisterBtn.setBounds(137, 479, 208, 41);
		contentPane.add(RegisterBtn);
	}
	private boolean emptyCheck() {/**����üũ*/
		if(NameBox.getText().isEmpty()||IDBox.getText().isEmpty()||PWBox.getText().isEmpty()||PWConfirmBox.getText().isEmpty()||PhoneNumBox.getText().isEmpty()||ConfirmNumBox.getText().isEmpty()||AnswerBox.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "��ĭ�� �ֽ��ϴ�.","���",JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
		return true;
	}
	private boolean duplicateCheck() {/**���̵��ߺ�üũ*/
		try {
			executor.Connect();
			String sql = "SELECT * FROM auction.user WHERE u_id = '"+IDBox.getText()+"'";
			ResultSet resultset = executor.executeReadQuery(sql);
			if(resultset.next()) {
				JOptionPane.showMessageDialog(null, "���̵� �ߺ��Ǿ����ϴ�","���",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	private boolean passwordformatcheck() {/**��й�ȣ����üũ*/
		String password = PWBox.getText();
		boolean isPassed = true;
		if(!password.matches("[a-zA-Z0-9!@#$%]+")) isPassed=false; //������/����/Ư������(!@#$%) ������ ������ ���� �ѱ� ���� X
		if(password.matches(".*(\\w)\\1{2,}.*")) isPassed=false; //3�ڸ� �̻� ���� ���� �Ұ�
		if(continuousPasswordCheck(password)) isPassed=false; //3�ڸ� �̻� ���ӵǴ� ���� (abc, cba, 123, 321 ��) �Ұ�
		if(password.length()<10||password.length()>25) isPassed=false; //10�ڸ� �̻� 25�ڸ� ���ϸ� ����
		if(password.equals(IDBox.getText())||password.equals(NameBox.getText())||password.equals(PhoneNumBox.getText().replace("-","")))isPassed=false;//��������(ID,Name,PhoneNum) �ߺ� üũ
		if(isPassed) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "��й�ȣ ������ Ȯ�����ּ���.","���",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	private boolean continuousPasswordCheck(String pwd) {
		 int o = 0;
		 int d = 0;
		 int p = 0;
		 int n = 0;  
		 int limit = 3;
		  
		 for(int i=0; i<pwd.length(); i++) {
			 char tempVal = pwd.charAt(i);
		  if(i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 :0) > limit -3) {
			 return true;
		  }
		  d = p;
		  o = tempVal;
		  }
		  return false;
	 }
	/*��й�ȣ Ȯ�� üũ**/
	private boolean pwEqualCheck() {
		if(!PWBox.getText().equals(PWConfirmBox.getText())) {
			JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.","���",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	/*����Ȯ�� �� üũ**/
	private boolean questionNullCheck() {
		if(QuestionCombo.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "����Ȯ�� ������ �������ּ���.","���",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
