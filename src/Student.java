import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private JPanel contentPane;


	public Student(String enroll)
	{
		setTitle("Student Form");
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnViewSelfProfile = new JButton("View/Update Profile");
		btnViewSelfProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				View v=new View(enroll);
				v.setVisible(true);
			}
		});
		contentPane.add(btnViewSelfProfile, BorderLayout.NORTH);

		JButton btnViewAllNotices = new JButton("View All Notices");
		btnViewAllNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame frm=new JFrame("View All Notices");

				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Student.this);
				GetValues.getNotices();
				System.out.print(GetValues.records);
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllNotices, BorderLayout.WEST);

		JButton btnUpdateProfile = new JButton("Change Password");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ChangePasswordStudent cps=new ChangePasswordStudent();
				cps.setVisible(true);
			}
		});
		contentPane.add(btnUpdateProfile, BorderLayout.SOUTH);

		JButton btnSubmitFeedback = new JButton("Submit Feedback");
		btnSubmitFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Feedback f=new Feedback();
				f.setVisible(true);
			}
		});
		contentPane.add(btnSubmitFeedback, BorderLayout.EAST);
		


	}

}
