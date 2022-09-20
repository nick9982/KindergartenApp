package interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import algorithms.Login;

public class LoginPageStudent implements ActionListener
{
	Login l = new Login();
	private JLabel uname_label;
	private JTextField uname;
	private JLabel pwd_label;
	private JPasswordField pwd;
	private JButton login;
	private JButton create_acc;
	private JButton i_am_a_teacher;
	private JFrame window;
	private JLabel error;
	
	Connection c;
	public LoginPageStudent(Connection c)
	{
		this.c = c;
		window = new JFrame("Student Login Page");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(550, 150);
		window.setLayout(new GridBagLayout());
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		uname_label = new JLabel("Username:");
		uname = new JTextField(40);
		pwd_label = new JLabel("Password:");
		pwd = new JPasswordField(40);
		login = new JButton("Login");
		create_acc = new JButton("Create New Account");
		i_am_a_teacher = new JButton("Login as teacher");
		error = new JLabel();
		error.setVisible(false);
		
		pwd.setEchoChar('*');
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.3;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(uname_label, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		window.add(uname, gbc);
		
		gbc.gridy = 1;
		window.add(pwd, gbc);
		
		gbc.gridx = 0;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		window.add(pwd_label, gbc);
		
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		window.add(login, gbc);
		gbc.weightx = 0.3;
		gbc.gridx = 1;
		window.add(create_acc, gbc);
		
		gbc.gridx = 2;
		window.add(i_am_a_teacher, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		window.add(error, gbc);
		
		window.setVisible(true);
		
		login.addActionListener(this);
		create_acc.addActionListener(this);
		i_am_a_teacher.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.create_acc)
		{
			CreateStudentAccount csa = new CreateStudentAccount(this.c);
			window.dispose();
		}
		
		if(e.getSource() == this.login)
		{
			window.setSize(550, 150);
			error.setVisible(false);
			String user = uname.getText();
			String pass = l.encrypt(String.valueOf(pwd.getPassword()));
			if(!user.equals("") && !(String.valueOf(pwd.getPassword()).equals("")))
			{
				try {
					Statement stmt = c.createStatement();
					
					String qry = "select * from student_account"
							+ " where uname = '" + user + "' and pwd = '" + pass + "'";
					
					ResultSet rs = stmt.executeQuery(qry);
					if(rs.next())
					{
						String id = rs.getString(1);
						//open the student window taking uname and user id as params
						window.dispose();
					}
					else
					{
						error.setText("Invalid login information");
						error.setVisible(true);
						window.setSize(550, 190);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			else
			{
				error.setText("Please fill the username and the password field");
				error.setVisible(true);
				window.setSize(550, 190);
			}
		}
		else if(e.getSource() == this.i_am_a_teacher)
		{
			LoginPageTeacher lpt = new LoginPageTeacher(c);
			window.dispose();
		}
	}
}