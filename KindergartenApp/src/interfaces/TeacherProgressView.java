package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class TeacherProgressView extends JFrame implements ActionListener {
	
	private File studentPhoto;
	
	public File getStudentPhoto() {
		return studentPhoto;
	}

	public void setStudentPhoto(File studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	private JTable tblStudentRoster;
	
	public JTable getTblStudentRoster() {
		return tblStudentRoster;
	}

	public void setTblStudentRoster(JTable tblStudentRoster) {
		this.tblStudentRoster = tblStudentRoster;
	}
	
//	Slice[] slices;
	
	public TeacherProgressView(String teacherName) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setTitle("Grade School Math Tutoring Application");
		setResizable(false);
		setSize(700, 600);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcomeBanner = new JLabel("Welcome, " + teacherName + "!");
		lblWelcomeBanner.setBackground(Color.WHITE);
		lblWelcomeBanner.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		GridBagConstraints gbc_lblWelcomeBanner = new GridBagConstraints();
		gbc_lblWelcomeBanner.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeBanner.gridx = 0;
		gbc_lblWelcomeBanner.gridy = 0;
		getContentPane().add(lblWelcomeBanner, gbc_lblWelcomeBanner);
		
		JPanel pnlGraph = new JPanel();
		GridBagConstraints gbc_pnlGraph = new GridBagConstraints();
		gbc_pnlGraph.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGraph.fill = GridBagConstraints.BOTH;
		gbc_pnlGraph.gridx = 0;
		gbc_pnlGraph.gridy = 1;
		getContentPane().add(pnlGraph, gbc_pnlGraph);
		pnlGraph.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPaneStudentRoster = new JScrollPane();
		GridBagConstraints gbc_scrollPaneStudentRoster = new GridBagConstraints();
		gbc_scrollPaneStudentRoster.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneStudentRoster.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneStudentRoster.gridx = 0;
		gbc_scrollPaneStudentRoster.gridy = 2;
		getContentPane().add(scrollPaneStudentRoster, gbc_scrollPaneStudentRoster);
		
		tblStudentRoster = new JTable();
		tblStudentRoster.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Points Scored", "Points Possible", "Percentage"
			}
		));
		tblStudentRoster.setColumnSelectionAllowed(true);
		tblStudentRoster.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPaneStudentRoster.setViewportView(tblStudentRoster);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddStudent = new JButton("Add New Student");
		btnAddStudent.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		panel.add(btnAddStudent);
		btnAddStudent.addActionListener(this);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		panel.add(btnLogOut);
		btnLogOut.addActionListener(this);
		
//		slices = new Slice[2];
		//complete portion
//		slices[0] = new Slice(5, Color.GREEN);
//		slices[1] = new Slice(5, Color.RED);
		
//		Rectangle rect = new Rectangle(pnlGraph.getWidth(), pnlGraph.getHeight());
		
//		drawPie((Graphics2D)new Graphics(), pnlGraph, slices);
		
	}
	
	public static void main(String[] args) {
		TeacherProgressView tpv = new TeacherProgressView("Sally");
		tpv.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton clickedButton = (JButton)e.getSource();
			
			if (clickedButton.getText().equals("Add New Student")) {
				AddNewStudentView ansv = new AddNewStudentView(this);
				ansv.setVisible(true);
			}
			else if (clickedButton.getText().equals("Log out")) {
				System.exit(0);
			}
		}
		
	}
}

class Slice {
	double value;
	Color color;
	   
	public Slice(double value, Color color) {  
	   this.value = value;
	   this.color = color;
	}	
}
