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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class StudentRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;

	public StudentRegistration() {
		setTitle("Student Registration Form");
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEnrollmentNumber = new JLabel("Enrollment Number");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblName = new JLabel("Name");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblRoll = new JLabel("Roll");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblDob = new JLabel("DOB");

		JLabel lblGender = new JLabel("Gender");

		JLabel lblMobile = new JLabel("Mobile");

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel lblEmail = new JLabel("Email");

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JLabel lblBranch = new JLabel("Branch");

		JLabel lblSemester = new JLabel("Semester");

		JLabel lblAddmissionDate = new JLabel("Addmission Date");

		JLabel lblAddress = new JLabel("Address");

		JTextArea textArea = new JTextArea();

		JLabel lblPassword = new JLabel("Password");

		textField_9 = new JTextField();
		textField_9.setColumns(10);

		JButton btnLoginNow = new JButton("Login Now");
		Integer dd[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		String mm[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		Integer yy[]={2010,2011,2013,2014,2015,2016,2017};
		JComboBox comboBox = new JComboBox(dd);

		JComboBox comboBox_1 = new JComboBox(mm);

		JComboBox comboBox_2 = new JComboBox(yy);

		String gender[]={"Select","Male","Female"};
		JComboBox comboBox_3 = new JComboBox(gender);

		String stream[]={"Select","IT","CSE","ECE","MECH","CIVIL"};
		JComboBox comboBox_4 = new JComboBox(GetValues.getBranch());

		Integer sem[]={1,2,3,4,5,6,7,8,9,10};
		JComboBox comboBox_5 = new JComboBox(sem);

		JComboBox comboBox_6 = new JComboBox(dd);

		JComboBox comboBox_7 = new JComboBox(mm);

		JComboBox comboBox_8 = new JComboBox(yy);

		JLabel lblCourse = new JLabel("Course");
		String course[]={"BCA","MCA","BTECH","MTECH"};
		JComboBox comboBox_9 = new JComboBox(GetValues.getCourse());

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String enroll=textField.getText();
				String name=textField_1.getText();
				String roll=textField_2.getText();
				String mobile=textField_4.getText();
				String email=textField_5.getText();
				String password=textField_9.getText();
				int d1=(int)comboBox.getSelectedItem();
				String m1=(String)comboBox_1.getSelectedItem();
				int y1=(int)comboBox_2.getSelectedItem();
				String dob=d1+"/"+m1+"/"+y1;
				String gender=(String)comboBox_3.getSelectedItem();
				String branch=(String)comboBox_4.getSelectedItem();
				String course=(String)comboBox_9.getSelectedItem();
				int sem=(int)comboBox_5.getSelectedItem();
				int d2=(int)comboBox_6.getSelectedItem();
				String m2=(String)comboBox_7.getSelectedItem();
				int y2=(int)comboBox_8.getSelectedItem();
				String doj=d2+"/"+m2+"/"+y2;
				String address=textArea.getText();

				Connection con=DBInfo.con;
				String query="insert into student_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				int i=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, enroll);
					ps.setString(2, name);
					ps.setString(3, roll);
					ps.setString(4, dob);
					ps.setString(5, gender);
					ps.setString(6, mobile);
					ps.setString(7, email);
					ps.setString(8, branch);
					ps.setString(9, course);
					ps.setInt(10, sem);
					ps.setString(11, doj);
					ps.setString(12, address);
					ps.setString(13, password);
					i=ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(StudentRegistration.this,"Records Inserted");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_9.setText(null);
					textArea.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					comboBox_5.setSelectedIndex(0);
					comboBox_6.setSelectedIndex(0);
					comboBox_7.setSelectedIndex(0);
					comboBox_8.setSelectedIndex(0);
					comboBox_9.setSelectedIndex(0);
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(StudentRegistration.this,"Records Failed");
				}
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_9.setText(null);
				textArea.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				comboBox_6.setSelectedIndex(0);
				comboBox_7.setSelectedIndex(0);
				comboBox_8.setSelectedIndex(0);
				comboBox_9.setSelectedIndex(0);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGender)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnSave)
										.addGap(18)
										.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnLoginNow, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblMobile, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblEnrollmentNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblRoll, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDob, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblAddmissionDate)
											.addComponent(lblAddress)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblBranch)
												.addGap(18)
												.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblSemester, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPassword))
										.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCourse)
												.addGap(18)
												.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textField_2, Alignment.LEADING)
												.addComponent(textField_1, Alignment.LEADING)
												.addComponent(textField, Alignment.LEADING)
												.addComponent(textField_4, Alignment.LEADING)
												.addComponent(textField_5, Alignment.LEADING)
												.addComponent(textField_9)
												.addComponent(comboBox_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textArea)))))
								.addGap(79)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnrollmentNumber)
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
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourse)
						.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSemester))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddmissionDate)
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnLoginNow))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
