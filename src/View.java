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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;

	public View(String enrollno) 
	{
		setTitle("View Details");
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblEnrollment = new JLabel("Enrollment");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblRoll = new JLabel("Roll");
		
		JLabel lblNewLabel_1 = new JLabel("DOB");
		
		JLabel lblGender = new JLabel("Gender");
		
		JLabel lblMobile = new JLabel("Mobile");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblBranch = new JLabel("Branch");
		
		JLabel lblCourse = new JLabel("Course");
		
		JLabel lblSemester = new JLabel("Semester");
		
		JLabel lblDateOfJoining = new JLabel("Date Of Joining");
		
		JLabel lblAddress = new JLabel("Address");
		
		JLabel lblEnroll = new JLabel("enroll");
		
		JLabel lblNames = new JLabel("names");
		
		JLabel lblRollno = new JLabel("rollno");
		
		JLabel lblDateob = new JLabel("Dateob");
		
		JLabel lblGen = new JLabel("Gen");
		
		JLabel lblMob = new JLabel("Mob");
		
		JLabel lblEmail_1 = new JLabel("email");
		
		JLabel lblBranches = new JLabel("branches");
		
		JLabel lblCourses = new JLabel("courses");
		
		JLabel lblSem = new JLabel("sem");
		
		JLabel lblDoj = new JLabel("doj");
		
		JTextPane textPane = new JTextPane();
		
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
				lblEnroll.setText(res.getString(1));
				lblNames.setText(res.getString(2));
				lblRollno.setText(res.getString(3));
				lblDateob.setText(res.getString(4));
				lblGen.setText(res.getString(5));
				lblMob.setText(res.getString(6));
				lblEmail_1.setText(res.getString(7));
				lblBranches.setText(res.getString(8));
				lblCourses.setText(res.getString(9));
				lblSem.setText(res.getString(10));
				lblDoj.setText(res.getString(11));
				textPane.setText(res.getString(12));
				flag=1;
				break;
			}
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
		
		
		
		JButton btnToUpdateProfile = new JButton("To Update Profile");
		btnToUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateProfile up=new UpdateProfile(enrollno);
				up.setVisible(true);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnrollment)
						.addComponent(lblName)
						.addComponent(lblRoll)
						.addComponent(lblNewLabel_1)
						.addComponent(lblGender)
						.addComponent(lblMobile)
						.addComponent(lblEmail)
						.addComponent(lblBranch)
						.addComponent(lblCourse)
						.addComponent(lblSemester)
						.addComponent(lblDateOfJoining)
						.addComponent(lblAddress))
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnroll)
						.addComponent(lblNames)
						.addComponent(lblRollno)
						.addComponent(lblDateob)
						.addComponent(lblGen)
						.addComponent(lblMob)
						.addComponent(lblEmail_1)
						.addComponent(lblBranches)
						.addComponent(lblCourses)
						.addComponent(lblSem)
						.addComponent(lblDoj)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(165, Short.MAX_VALUE)
					.addComponent(btnToUpdateProfile)
					.addGap(154))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnrollment)
						.addComponent(lblEnroll))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblNames))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoll)
						.addComponent(lblRollno))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblDateob))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(lblGen))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(lblMob))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(lblEmail_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(lblBranches))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(lblCourses))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemester)
						.addComponent(lblSem))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfJoining)
						.addComponent(lblDoj))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnToUpdateProfile)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
