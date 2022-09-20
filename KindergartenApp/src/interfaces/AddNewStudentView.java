package interfaces;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class AddNewStudentView extends JFrame implements ActionListener {

	TeacherProgressView parent;
	private JTextField textField;
	private JTextField txtLastName;
	private JTextField txtPicPath;
	
	public AddNewStudentView(TeacherProgressView teacherProgressView) {
		// TODO Auto-generated constructor stub
		this.parent = teacherProgressView;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700,563);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Please Enter Student Information in the Fields Below:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblID = new JLabel("Student First Name:");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 3;
		panel.add(lblID, gbc_lblID);
		
		textField = new JTextField();
		textField.setToolTipText("Enter student's first name here!");
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Last Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 7;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Enter student's last name here!");
		txtLastName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.gridwidth = 3;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 2;
		gbc_txtLastName.gridy = 7;
		panel.add(txtLastName, gbc_txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Select Yearbook Photo:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 10;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPicPath = new JTextField();
		txtPicPath.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_txtPicPath = new GridBagConstraints();
		gbc_txtPicPath.gridwidth = 2;
		gbc_txtPicPath.insets = new Insets(0, 0, 5, 5);
		gbc_txtPicPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPicPath.gridx = 2;
		gbc_txtPicPath.gridy = 10;
		panel.add(txtPicPath, gbc_txtPicPath);
		txtPicPath.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 4;
		gbc_btnBrowse.gridy = 10;
		panel.add(btnBrowse, gbc_btnBrowse);
		btnBrowse.addActionListener(this);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_btnAddStudent = new GridBagConstraints();
		gbc_btnAddStudent.gridwidth = 2;
		gbc_btnAddStudent.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddStudent.gridx = 1;
		gbc_btnAddStudent.gridy = 13;
		panel.add(btnAddStudent, gbc_btnAddStudent);
		btnAddStudent.addActionListener(this);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddNewStudentView ansv = new AddNewStudentView(null);
		ansv.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() instanceof JButton) {
			
			JButton clickedButton = (JButton)e.getSource();
			
			if (clickedButton.getText().equals("Browse")) {
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & PNG Images", "jpg", "png");
				jfc.setFileFilter(filter);
				int chooseStatus = jfc.showOpenDialog(null);
				if (chooseStatus == JFileChooser.APPROVE_OPTION) {
					txtPicPath.setText(jfc.getSelectedFile().getAbsolutePath());
					parent.setStudentPhoto(jfc.getSelectedFile());
					if(parent.getStudentPhoto().isFile()) System.out.println("Yep, it's a file!");
				}
				
			}
		}
	}

}
