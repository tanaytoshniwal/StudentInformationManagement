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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;

	public SignUp()
	{
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSignupAs = new JLabel("SignUp as:");

		String user[]={"Select","Faculty","Student"};
		JComboBox comboBox = new JComboBox(user);

		JButton btnSignup = new JButton("Sign Up");

		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String users=(String) comboBox.getSelectedItem();
				if(users.equalsIgnoreCase("faculty")){
					FacultyRegistration fr=new FacultyRegistration();
					fr.setVisible(true);
				}
				else if(users.equalsIgnoreCase("student")){
					StudentRegistration sr=new StudentRegistration();
					sr.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(SignUp.this, "Choose a valid choice");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(lblSignupAs)
							.addGap(94)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addComponent(btnSignup))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(131)))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSignupAs)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addComponent(btnSignup)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
