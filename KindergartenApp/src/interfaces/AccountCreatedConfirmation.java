package interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AccountCreatedConfirmation implements ActionListener {

	private JLabel label;
	private JButton btn;
	private JFrame window;
	int src;
	Connection c;
	//0 - student acc, 1 - teacher acc
	public AccountCreatedConfirmation(int src, Connection c)
	{
		this.c = c;
		this.src = src;
		window = new JFrame("Account Created Successfully");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 200);
		window.setLayout(new GridBagLayout());
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(true);
		
		label = new JLabel("Account Created Successfully");
		btn = new JButton("Continue to login");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,208,0,0);
		window.add(label, gbc);
		
		gbc.insets = new Insets(5,5,5,5);
		gbc.gridy = 1;
		window.add(btn, gbc);
		
		btn.addActionListener(this);
		
		
		window.pack();
		window.resize(600, 200);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn)
		{
			if(src == 0)
			{
				LoginPageStudent lps = new LoginPageStudent(c);
			}
			else
			{
				LoginPageTeacher lpt = new LoginPageTeacher(c);
			}
			window.dispose();
		}
	}

}
