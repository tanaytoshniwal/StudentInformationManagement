import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ChangePasswordStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public ChangePasswordStudent() {
		setTitle("Change Password");
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEmpid = new JLabel("Enrollment");

		JLabel lblCurrentPassword = new JLabel("Current Password");

		JLabel lblNewPassword = new JLabel("New Password");

		textField = new JTextField();
		textField.setColumns(10);

		passwordField = new JPasswordField();

		passwordField_1 = new JPasswordField();

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String enroll=textField.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				char ch1[]=passwordField_1.getPassword();
				String new_password=String.copyValueOf(ch1);
				System.out.print(new_password);
				String query="update student_registration set password=? where enrollment=?";
				Connection con=DBInfo.con;
				int i=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, new_password);
					ps.setString(2, enroll);
					i=ps.executeUpdate();
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(ChangePasswordStudent.this, "Password Changed Successfully");
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(ChangePasswordStudent.this, "Failed!!");
				}
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addGap(193))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmpid)
						.addComponent(lblNewPassword)
						.addComponent(lblCurrentPassword)
						.addComponent(btnChangePassword))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passwordField_1)
						.addComponent(passwordField)
						.addComponent(textField))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmpid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrentPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePassword)
						.addComponent(btnReset))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
