import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	public UpdateProfile(String enrollno) 
	{
		setTitle("Update Profile");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		setBounds(100, 100, 450, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblEnrollment = new JLabel("Enrollment");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblRoll = new JLabel("Roll");
		
		JLabel lblDob = new JLabel("DOB");
		
		JLabel lblGender = new JLabel("Gender");
		
		JLabel lblMobile = new JLabel("Mobile");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblBranch = new JLabel("Branch");
		
		JLabel lblCourse = new JLabel("Course");
		
		JLabel lblSemester = new JLabel("Semester");
		
		JLabel lblDateOfJoining = new JLabel("Date Of Joining");
		
		JLabel lblAddress = new JLabel("Address");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		
		String enroll=enrollno;
		String query="select * from student_registration where enrollment=?";
		int flag=0;
		Connection con=DBInfo.con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, enroll);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				textField.setText(res.getString(1));
				textField_1.setText(res.getString(2));
				textField_2.setText(res.getString(3));
				textField_3.setText(res.getString(4));
				textField_4.setText(res.getString(5));
				textField_5.setText(res.getString(6));
				textField_6.setText(res.getString(7));
				textField_7.setText(res.getString(8));
				textField_8.setText(res.getString(9));
				textField_9.setText(res.getString(10));
				textField_10.setText(res.getString(11));
				textArea.setText(res.getString(12));
				flag=1;
				break;
			}
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String enroll=textField.getText();
				String query="update student_registration set name=?,roll=?,dob=?,gender=?,mobile=?,email=?,branch=?,course=?,sem=?,dateofjoining=?,address=? where enrollment=?";
				Connection con=DBInfo.con;
				int i=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, textField_1.getText());
					ps.setString(2, textField_2.getText());
					ps.setString(3, textField_3.getText());
					ps.setString(4, textField_4.getText());
					ps.setString(5, textField_5.getText());
					ps.setString(6, textField_6.getText());
					ps.setString(7, textField_7.getText());
					ps.setString(8, textField_8.getText());
					ps.setString(9, textField_9.getText());
					ps.setString(10, textField_10.getText());
					ps.setString(11, textArea.getText());
					ps.setString(12, enroll);
					i=ps.executeUpdate();
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(UpdateProfile.this, "Data Updated Successfully");
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(UpdateProfile.this, " Data Updation Failed!!");
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				textArea.setText(null);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(123))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblEnrollment)
								.addComponent(lblName)
								.addComponent(lblRoll)
								.addComponent(lblDob)
								.addComponent(lblGender)
								.addComponent(lblMobile)
								.addComponent(lblEmail)
								.addComponent(lblBranch)
								.addComponent(lblCourse)
								.addComponent(lblSemester)
								.addComponent(lblDateOfJoining, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAddress)
								.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(97)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField)
									.addComponent(textField_1)
									.addComponent(textField_2)
									.addComponent(textField_3)
									.addComponent(textField_4)
									.addComponent(textField_5)
									.addComponent(textField_6)
									.addComponent(textField_7)
									.addComponent(textField_8)
									.addComponent(textField_9)
									.addComponent(textField_10)))))
					.addGap(100))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnrollment)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoll)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDob)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemester)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfJoining)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnReset))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
