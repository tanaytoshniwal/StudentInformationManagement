import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	public Admin(String title) 
	{
		setTitle(title);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 309);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnRegisterANew = new JButton("Register a new Student");
		btnRegisterANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				StudentRegistration sr=new StudentRegistration();
				sr.setVisible(true);
			}
		});
		contentPane.add(btnRegisterANew);
		
		JButton btnNewButton = new JButton("View/Update/Delete a student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UpdateDelete ud=new UpdateDelete();
				ud.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnUploadANew = new JButton("Upload a new notice");
		btnUploadANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AddNotice an=new AddNotice();
				an.setVisible(true);
			}
		});
		contentPane.add(btnUploadANew);
		
		JButton btnViewupdatedeleteANotice = new JButton("View/Update/Delete a notice");
		btnViewupdatedeleteANotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateDeleteNotice udn=new UpdateDeleteNotice();
				udn.setVisible(true);
			}
		});
		contentPane.add(btnViewupdatedeleteANotice);
		
		JButton btnViewAllStudents = new JButton("View all Students");
		btnViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm=new JFrame("View All Students");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getStudents();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllStudents);
		
		JButton btnViewAllNotices = new JButton("View all Notices");
		btnViewAllNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm=new JFrame("View All Notices");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getNotices();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllNotices);
		
		JButton btnViewStudentFeedback = new JButton("View student feedback");
		btnViewStudentFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm=new JFrame("View All Feedbacks");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getFeedbacks();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewStudentFeedback);
		
		JButton btnChangeSelfPassword = new JButton("Change self Password");
		btnChangeSelfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangePassword cp=new ChangePassword();
				cp.setVisible(true);
			}
		});
		contentPane.add(btnChangeSelfPassword);
		
		JButton btnResgisterANew = new JButton("Register a new faculty");
		btnResgisterANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FacultyRegistration fr=new FacultyRegistration();
				fr.setVisible(true);
			}
		});
		contentPane.add(btnResgisterANew);
		
		JButton btnViewAllFaculties = new JButton("View all faculties");
		btnViewAllFaculties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm=new JFrame("View All Faculties");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getFaculties();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllFaculties);
	}

}
