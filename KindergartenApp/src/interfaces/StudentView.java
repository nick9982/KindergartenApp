package interfaces;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

public class StudentView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_8 = new JLabel("Progress");
		lblNewLabel_8.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 2;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 0;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblAssignments = new JLabel("Assignments");
		lblAssignments.setLabelFor(this);
		lblAssignments.setBackground(new Color(128, 255, 0));
		lblAssignments.setForeground(new Color(0, 0, 0));
		lblAssignments.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		GridBagConstraints gbc_lblAssignments = new GridBagConstraints();
		gbc_lblAssignments.insets = new Insets(0, 0, 5, 0);
		gbc_lblAssignments.gridx = 8;
		gbc_lblAssignments.gridy = 0;
		contentPane.add(lblAssignments, gbc_lblAssignments);
		
		JLabel lblNewLabel = new JLabel("Assignment 1:");
		lblNewLabel.setBackground(new Color(128, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(128, 255, 0));
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridwidth = 6;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 1;
		contentPane.add(progressBar, gbc_progressBar);
		
		//Simulate values in progress bar, Value will be set to whatever the text file of the student says for each assignment. 
		progressBar.setMaximum(10);
		progressBar.setMinimum(0);
		progressBar.setValue(5);
		
		JButton btnAssignment1 = new JButton("Assignment 1");
		btnAssignment1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 1
				System.out.println("1");
			}
		});
		btnAssignment1.setBackground(new Color(128, 255, 0));
		btnAssignment1.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btnAssignment1 = new GridBagConstraints();
		gbc_btnAssignment1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment1.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment1.gridx = 8;
		gbc_btnAssignment1.gridy = 1;
		contentPane.add(btnAssignment1, gbc_btnAssignment1);
		
		JLabel lblNewLabel_1 = new JLabel("Assignment 2:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JProgressBar progressBar_1 = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.gridwidth = 6;
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_1.gridx = 2;
		gbc_progressBar_1.gridy = 2;
		contentPane.add(progressBar_1, gbc_progressBar_1);
		
		JButton btnAssignment2 = new JButton("Assignment 2");
		btnAssignment2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 2
				System.out.println("2");
			}
		});
		btnAssignment2.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment2 = new GridBagConstraints();
		gbc_btnAssignment2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment2.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment2.gridx = 8;
		gbc_btnAssignment2.gridy = 2;
		contentPane.add(btnAssignment2, gbc_btnAssignment2);
		
		JLabel lblNewLabel_2 = new JLabel("Assignment 3:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JProgressBar progressBar_2 = new JProgressBar();
		GridBagConstraints gbc_progressBar_2 = new GridBagConstraints();
		gbc_progressBar_2.gridwidth = 6;
		gbc_progressBar_2.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_2.gridx = 2;
		gbc_progressBar_2.gridy = 3;
		contentPane.add(progressBar_2, gbc_progressBar_2);
		
		JButton btnAssignment3 = new JButton("Assignment 3");
		btnAssignment3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 3
				System.out.println("3");
			}
		});
		btnAssignment3.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment3 = new GridBagConstraints();
		gbc_btnAssignment3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment3.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment3.gridx = 8;
		gbc_btnAssignment3.gridy = 3;
		contentPane.add(btnAssignment3, gbc_btnAssignment3);
		
		JLabel lblNewLabel_3 = new JLabel("Assignment 4: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JProgressBar progressBar_3 = new JProgressBar();
		GridBagConstraints gbc_progressBar_3 = new GridBagConstraints();
		gbc_progressBar_3.gridwidth = 6;
		gbc_progressBar_3.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_3.gridx = 2;
		gbc_progressBar_3.gridy = 4;
		contentPane.add(progressBar_3, gbc_progressBar_3);
		
		JButton btnAssignment4 = new JButton("Assignment 4");
		btnAssignment4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 4
				System.out.println("4");
			}
		});
		btnAssignment4.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment4 = new GridBagConstraints();
		gbc_btnAssignment4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment4.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment4.gridx = 8;
		gbc_btnAssignment4.gridy = 4;
		contentPane.add(btnAssignment4, gbc_btnAssignment4);
		
		JLabel lblNewLabel_4 = new JLabel("Assignment 5:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JProgressBar progressBar_4 = new JProgressBar();
		GridBagConstraints gbc_progressBar_4 = new GridBagConstraints();
		gbc_progressBar_4.gridwidth = 6;
		gbc_progressBar_4.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_4.gridx = 2;
		gbc_progressBar_4.gridy = 5;
		contentPane.add(progressBar_4, gbc_progressBar_4);
		
		JButton btnAssignment5 = new JButton("Assignment 5");
		btnAssignment5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 5
				System.out.println("5");
			}
		});
		btnAssignment5.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment5 = new GridBagConstraints();
		gbc_btnAssignment5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment5.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment5.gridx = 8;
		gbc_btnAssignment5.gridy = 5;
		contentPane.add(btnAssignment5, gbc_btnAssignment5);
		
		JLabel lblNewLabel_5 = new JLabel("Assignment 6:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JProgressBar progressBar_5 = new JProgressBar();
		GridBagConstraints gbc_progressBar_5 = new GridBagConstraints();
		gbc_progressBar_5.gridwidth = 6;
		gbc_progressBar_5.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_5.gridx = 2;
		gbc_progressBar_5.gridy = 6;
		contentPane.add(progressBar_5, gbc_progressBar_5);
		
		JButton btnAssignment6 = new JButton("Assignment 6");
		btnAssignment6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 6
				System.out.println("6");
			}
		});
		btnAssignment6.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment6 = new GridBagConstraints();
		gbc_btnAssignment6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment6.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment6.gridx = 8;
		gbc_btnAssignment6.gridy = 6;
		contentPane.add(btnAssignment6, gbc_btnAssignment6);
		
		JLabel lblNewLabel_6 = new JLabel("Assignment 7:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JProgressBar progressBar_6 = new JProgressBar();
		GridBagConstraints gbc_progressBar_6 = new GridBagConstraints();
		gbc_progressBar_6.gridwidth = 6;
		gbc_progressBar_6.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_6.gridx = 2;
		gbc_progressBar_6.gridy = 7;
		contentPane.add(progressBar_6, gbc_progressBar_6);
		
		JButton btnAssignment7 = new JButton("Asignment 7");
		btnAssignment7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 7
				System.out.println("7");
			}
		});
		btnAssignment7.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnAssignment7 = new GridBagConstraints();
		gbc_btnAssignment7.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignment7.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignment7.gridx = 8;
		gbc_btnAssignment7.gridy = 7;
		contentPane.add(btnAssignment7, gbc_btnAssignment7);
		
		JLabel lblNewLabel_7 = new JLabel("Assignment 8:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JProgressBar progressBar_7 = new JProgressBar();
		GridBagConstraints gbc_progressBar_7 = new GridBagConstraints();
		gbc_progressBar_7.gridwidth = 6;
		gbc_progressBar_7.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar_7.gridx = 2;
		gbc_progressBar_7.gridy = 8;
		contentPane.add(progressBar_7, gbc_progressBar_7);
		
		JButton btnNewButton_8 = new JButton("Assignment 8");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize assignment 8
				System.out.println("8");
			}
		});
		btnNewButton_8.setBackground(new Color(128, 255, 0));
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_8.gridx = 8;
		gbc_btnNewButton_8.gridy = 8;
		contentPane.add(btnNewButton_8, gbc_btnNewButton_8);
		
		String assignArr[] = {"Assignment 1", "Assignment 2", "Assignment 2"};
	}
	
		public void actionPerformed(ActionEvent e) {

	}
}
