package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;        

public class TeacherPage_Log {
   
	
    private static void createAndShowGUI() {
    	
    	
        //Create and set up the window.
        JFrame frame = new JFrame("Teacher Log");
        
        // add JPanel 
        JPanel panel = new JPanel(); 
        //frame.setLocation(100,150);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Welcome Teacher");
        
        // username and password labels
        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        
        
        // add username textbox 
        JTextField txtUsername = new JTextField("            "); 
        
        // add password textbox 
        JPasswordField txtPassword = new JPasswordField("            ");

        
        JButton btnSubmit = new JButton("Login"); 
      
        
        
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(label);
        panel.add(btnSubmit); 
        
        frame.getContentPane().add(panel);
        //Display the window.
       // frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        //frame.setLayout(null);
        frame.setVisible(true);
        
        
        
        
        
        // click event code
        btnSubmit.addActionListener(new ActionListener() {
       	 String userInputUsername = "" ; 
       	 String userInputPassword = ""; 
       	 boolean isAuthenticated = false; 
       	

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// grab input from the textboxes 
       		userInputUsername = txtUsername.getText();
       		userInputPassword = txtPassword.getPassword().toString(); 
       		// remove trailing whitespace
       		
       		userInputUsername= userInputUsername.trim(); 
       		userInputPassword= userInputPassword.trim(); 
       		
       		/// call authenticate method here 
       		isAuthenticated = authenticate(userInputUsername, userInputPassword);
       		
       		if(isAuthenticated) {
       			
       			label.setText("You are Logged In!");
       			JOptionPane.showMessageDialog(frame, "You Are Logged In!");
       		}
       		else
       		{
       			label.setText("Wrong Username and Password"); 
       			txtUsername.setText("            ");
       			txtPassword.setText("            ");
       		}
       		
       	}
			
       	
       
       });
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
    	
    	
    	
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static boolean authenticate(String username, String password) {
    	// username 
    	 String usernameRegs = "martin123" ;
    	// password 
    	 String passwordRegs = "123september"; 
    	
    	if(username.equals(passwordRegs) && password.equals(passwordRegs)) {
    		
    		return true; 
    	}
    	
    	return false; 
    }
}