package project;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UpdateDeleteNotice extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public UpdateDeleteNotice() {
		setTitle("Update/Delete Notice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("update.jpg").getImage().getScaledInstance(170, 90, Image.SCALE_DEFAULT)));
		
		JLabel lblDate = new JLabel("Date");
		
		JLabel lblCourse = new JLabel("Course");
		
		JLabel lblBranch = new JLabel("Branch");
		
		JLabel lblNotice = new JLabel("Notice");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String date=textField.getText();
				String query="select * from notice where date=?";
				int flag=0;
				Connection con=DBInfo.con;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, date);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						textField_1.setText(res.getString(2));
						textField_2.setText(res.getString(3));
						textArea.setText(res.getString(4));
						flag=1;
						break;
					}
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(UpdateDeleteNotice.this, "Data Not Found!!");
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textArea.setText(null);
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String date=textField.getText();
				String query="update notice set course=?,branch=?,notice=? where date=?";
				Connection con=DBInfo.con;
				int i=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, textField_1.getText());
					ps.setString(2, textField_2.getText());
					ps.setString(3, textArea.getText());
					ps.setString(4, textField.getText());
					i=ps.executeUpdate();
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(UpdateDeleteNotice.this, "Data Updated Successfully");
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(UpdateDeleteNotice.this, " Data Updation Failed!!");
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String date=textField.getText();
				String query="delete from notice where date=?";
				Connection con=DBInfo.con;
				int i=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, date);
					i=ps.executeUpdate();
					
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(UpdateDeleteNotice.this, "Data Deleted");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textArea.setText(null);
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(UpdateDeleteNotice.this, "Failed to Delete the data!!");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate)
								.addComponent(lblCourse)
								.addComponent(lblBranch)
								.addComponent(lblNotice))
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(textField_1)
								.addComponent(textField_2)
								.addComponent(textArea))
							.addContainerGap(102, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(112))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNotice)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnReset)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addGap(44))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
