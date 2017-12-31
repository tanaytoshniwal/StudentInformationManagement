import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddNotice extends JFrame {

public static void main(String[] args) {
	AddNotice an=new AddNotice();
	an.setVisible(true);
}
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public AddNotice() {
		setTitle("Upload Notice");
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblDate = new JLabel("Date");

		JLabel lblCourse = new JLabel("Course");

		JLabel lblBranch = new JLabel("Branch");

		JLabel lblNotice = new JLabel("Notice");

		textField = new JTextField();
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox(GetValues.getCourse());

		JComboBox comboBox_1 = new JComboBox(GetValues.getBranch());

		TextArea textArea = new TextArea();

		JLabel lblUploaderName = new JLabel("Uploader Name");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String date=textField.getText();
				String course=(String)comboBox.getSelectedItem();
				String branch=(String)comboBox_1.getSelectedItem();
				String notice=textArea.getText();
				String uploader=textField_1.getText();

				Connection con=DBInfo.con;
				int i=0;
				String query="insert into notice values(?,?,?,?,?)";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, date);
					ps.setString(2, course);
					ps.setString(3, branch);
					ps.setString(4, notice);
					ps.setString(5, uploader);
					i=ps.executeUpdate();
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(AddNotice.this, "Notice Uploaded");
				}
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(null);
				textField_1.setText(null);
				textArea.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			}
		});

		JButton btnViewAllNotices = new JButton("View All Notices");
		btnViewAllNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame frm=new JFrame("View All Notices");

				frm.setSize(800, 600);
				frm.setLocationRelativeTo(AddNotice.this);
				GetValues.getNotices();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUploaderName)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSubmit)
									.addGap(18)
									.addComponent(btnReset)
									.addGap(18)
									.addComponent(btnViewAllNotices, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCourse)
										.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBranch)
										.addComponent(lblNotice))
									.addGap(83)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField)
										.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 196, Short.MAX_VALUE)
										.addComponent(textField_1))))
							.addContainerGap(49, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(133)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNotice)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUploaderName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnReset)
						.addComponent(btnViewAllNotices))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
