package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login Page");
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("login1.jpg").getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
		
		JLabel lblUsernameenrollmentempid = new JLabel("Username(enrollment/empid)");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblUsertype = new JLabel("Usertype");
		String type[]={"Select","Admin","Student"};
		JComboBox comboBox = new JComboBox(type);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String userid=textField.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				String type=(String)comboBox.getSelectedItem();
				
				Connection con=DBInfo.con;
				int flag=0;
				if(type.equalsIgnoreCase("admin"))
				{
					String query="select * from faculty_registration where empid=? and password=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
					if(flag==1)
					{
						Admin a=new Admin("Admin Page");
						a.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				if(type.equalsIgnoreCase("student"))
				{
					String query="select * from student_registration where enrollment=? and password=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
					if(flag==1)
					{
						Student s=new Student(userid);
						s.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(null);
				passwordField.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		
		JButton btnNewUserSign = new JButton("New User? Sign Up");
		btnNewUserSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new SignUp().setVisible(true); 
			}
		});
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsertype)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin)
							.addGap(26)
							.addComponent(btnReset))
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsernameenrollmentempid))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewUserSign, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, 123, 123, Short.MAX_VALUE)
						.addComponent(passwordField))
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsernameenrollmentempid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReset)
						.addComponent(btnNewUserSign))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
