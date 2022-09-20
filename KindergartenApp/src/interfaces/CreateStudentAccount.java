package interfaces;

import algorithms.Login;
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


public class CreateStudentAccount implements ActionListener
{
	Login l = new Login();
	private JLabel uname_label;
	private JTextField uname;
	private JLabel pwd_label;
	private JPasswordField pwd;
	private JLabel pwd_check_label;
	private JPasswordField pwd_check;
	private JButton create_acc;
	private JButton back;
	private JFrame window;
	private JLabel usrError;
	private JLabel pwdError;
	
	int winx = 600;
	int winy = 200;
	
	Connection c;
	public CreateStudentAccount(Connection c)
	{
		this.c = c;
		window = new JFrame("Create Student Account");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(winx, winy);
		window.setLayout(new GridBagLayout());
		window.setLocationRelativeTo(null);
		
		uname_label = new JLabel("Username:");
		uname = new JTextField(40);
		pwd_label = new JLabel("Password:");
		pwd = new JPasswordField(40);
		pwd_check_label = new JLabel("Re-enter Password:");
		pwd_check = new JPasswordField(40);
		create_acc = new JButton("Create Account");
		back = new JButton("Back");
		usrError = new JLabel();
		pwdError = new JLabel();
		usrError.setVisible(false);
		pwdError.setVisible(false);
		window.setResizable(false);
		
		pwd.setEchoChar('*');
		pwd_check.setEchoChar('*');
		
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
		gbc.weightx = 0.3;
		window.add(pwd_check_label, gbc);
		
		gbc.weightx = 1;
		gbc.gridx = 1;
		window.add(pwd_check, gbc);
		
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.weightx = 0.05;
		window.add(back, gbc);
		
		gbc.weightx = 1;
		gbc.gridx = 1;
		window.add(create_acc, gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		window.add(usrError, gbc);
		
		gbc.gridy = 5;
		window.add(pwdError, gbc);
		
		window.setVisible(true);
		
		create_acc.addActionListener(this);
		back.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.create_acc)
		{
			usrError.setVisible(false);
			pwdError.setVisible(false);
			winy = 200;
			window.setSize(winx, winy);
			
			String u_name = uname.getText();
			String pass = String.valueOf(pwd.getPassword());
			String pass_check = String.valueOf(pwd_check.getPassword());
			if(!u_name.equals("") && !pass.equals("") && !pass_check.equals(""))
			{
				try {
					Statement stmt = this.c.createStatement();
					
					String qry = "Select uname from student_account where"
								+ " uname = '" + u_name + "'";
					ResultSet rs = stmt.executeQuery(qry);
					//If the result set is empty uname unique
					boolean usrAvail = !rs.next();
					if(usrAvail && pass.equals(pass_check))
					{
						String usrErr = l.processUsr(u_name);
						String pwdErr = l.processPwd(pass);
						if(!usrErr.equals("") || !pwdErr.equals(""))
						{
							if(!usrErr.equals(""))
							{
								winy+= 34;
								window.setSize(winx, winy);
								usrError.setText(usrErr);
								usrError.setVisible(true);
							}
							if(!pwdErr.equals(""))
							{
								winy += 34;
								window.setSize(winx, winy);
								pwdError.setText(pwdErr);
								pwdError.setVisible(true);
							}
						}
						else
						{
							boolean id_valid = false;
							String id = "";
							while(!id_valid)
							{
								id = l.id_gen();
								qry = "Select SID from student_account where"
										+ " SID = '" + id + "'";
								rs = stmt.executeQuery(qry);
								if(!rs.next())
								{
									id_valid = true;
								}
							}
							pass = l.encrypt(pass);
							
							qry = "INSERT INTO STUDENT_ACCOUNT VALUES "
								+ "('"+id+"', '"+u_name+"', '"+pass+"')";
							
							stmt.execute(qry);
							AccountCreatedConfirmation acc = new AccountCreatedConfirmation(0, c);
							window.dispose();
						}
					}
					else
					{
						if(!usrAvail)
						{
							winy += 34;
							window.setSize(winx, winy);
							usrError.setText("This username is taken");
							usrError.setVisible(true);
						}
						if(!pass.equals(pass_check))
						{
							winy += 34;
							window.setSize(winx, winy);
							pwdError.setText("The passwords do not match");
							pwdError.setVisible(true);
						}
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				usrError.setText("Please fill the username and password fields");
				usrError.setVisible(true);
				winy += 34;
				window.setSize(winx, winy);
			}
		}
		else if(e.getSource() == this.back)
		{
			LoginPageStudent lps = new LoginPageStudent(c);
			window.dispose();
		}
	}
}
