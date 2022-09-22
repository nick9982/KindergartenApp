package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class StudentProgressView implements ActionListener
{

	private JFrame frame;
	private JTable table;
	JButton logoutButton;
	GridBagConstraints tableConstraint;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProgressView window = new StudentProgressView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentProgressView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		tableConstraint= new GridBagConstraints();
		tableConstraint.gridwidth = 4;
		tableConstraint.gridheight = 4;
		tableConstraint.insets = new Insets(0, 0, 0, 5);
		tableConstraint.fill = GridBagConstraints.BOTH;
		tableConstraint.gridx = 3;
		tableConstraint.gridy = 1;
		
		JLabel welcomeLabel = new JLabel("Welcome, Fayyaz!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 1;
		frame.getContentPane().add(welcomeLabel, gbc_welcomeLabel);
		
		logoutButton = new JButton("Log out");
		GridBagConstraints gbc_logoutButton = new GridBagConstraints();
		gbc_logoutButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_logoutButton.gridwidth = 3;
		gbc_logoutButton.insets = new Insets(0, 0, 0, 5);
		gbc_logoutButton.gridx = 0;
		gbc_logoutButton.gridy = 4;
		frame.getContentPane().add(logoutButton, gbc_logoutButton);

		populateTable();
		frame.repaint();
		logoutButton.addActionListener(this);
		
	}
	
	public void populateTable()
	{
		if(table != null)
		{
			frame.getContentPane().remove(table);
		}
		
        this.table = new JTable(new String[][] {
	        	{
	        		"Class","Grade","NumberRight","NumberWrong",
	        	},
	        	{
	        		"Test","0%","5","10"
	        	},
        	},        		
        		//Add column headers
        	new String[] {"Class","Grade","NumberRight","NumberWrong"});
        
        frame.getContentPane().add(table,tableConstraint);
       }
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(logoutButton))
		{
			System.out.println("logging out of student!");
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			//open loginpagestudent once connection is accessible
		}
	}

}
