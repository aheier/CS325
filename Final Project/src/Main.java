import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class GUI implements ActionListener {
	private static final String DIALOG_TITLE = "Title";
	final int WIDTH = 600;
	final int HEIGHT = 600;

	private JFrame frame;
	private JPanel mainPanel;
	private JButton addStudent;
	private JButton viewAll;
	private JButton searchByName;
	private JButton removeById;

	private JTextArea dataTable;
	private JScrollPane scroll;

	private JTextField fNameText;
	private JTextField lNameText;
	private JTextField dobText;
	private JTextField majorText;
	private JLabel fNameLabel;
	private JLabel lNameLabel;
	private JLabel dobLabel;
	private JLabel majorLabel;

	private JTextField searchText;
	private JTextField removeText;
	private HashMap<Integer, Student> studentMap;

	public GUI() {
	    
		frame = new JFrame("Simple Student Management System");
		mainPanel = new JPanel();

		addStudent = new JButton("Add Student");
		viewAll = new JButton("View All");
		searchByName = new JButton("Search by name");
		removeById = new JButton("Remove by id");

		dataTable = new JTextArea();
		dataTable.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		scroll = new JScrollPane(dataTable);

		fNameText = new JTextField(20);
		lNameText = new JTextField(20);
		dobText = new JTextField(20);
		majorText = new JTextField(20);
		fNameLabel = new JLabel("First Name");
		lNameLabel = new JLabel("Last Name");
		dobLabel = new JLabel("Date of birth");
		majorLabel = new JLabel("Major");

		searchText = new JTextField(15);
		removeText = new JTextField(20);
		studentMap = new HashMap<Integer, Student>();
	}

	public void setAddLayout() {
		mainPanel.setLayout(null);
		Dimension size = new Dimension();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		addStudent.addActionListener(this);

		size = fNameLabel.getPreferredSize();
		fNameLabel.setBounds(100, 20, size.width, size.height);
		mainPanel.add(fNameLabel);
		size = fNameText.getPreferredSize();
		fNameText.setBounds(200, 20, size.width, size.height);
		mainPanel.add(fNameText);

		size = lNameLabel.getPreferredSize();
		lNameLabel.setBounds(100, 50, size.width, size.height);
		mainPanel.add(lNameLabel);
		size = lNameText.getPreferredSize();
		lNameText.setBounds(200, 50, size.width, size.height);
		mainPanel.add(lNameText);

		size = dobLabel.getPreferredSize();
		dobLabel.setBounds(100, 80, size.width, size.height);
		mainPanel.add(dobLabel);
		size = dobText.getPreferredSize();
		dobText.setBounds(200, 80, size.width, size.height);
		mainPanel.add(dobText);

		size = majorLabel.getPreferredSize();
		majorLabel.setBounds(100, 110, size.width, size.height);
		mainPanel.add(majorLabel);
		size = majorText.getPreferredSize();
		majorText.setBounds(200, 110, size.width, size.height);
		mainPanel.add(majorText);

		size = addStudent.getPreferredSize();
		addStudent.setBounds(250, 140, size.width, size.height);
		mainPanel.add(addStudent);
	}

	public void setDataLayout() {
		Dimension size = new Dimension();
		searchByName.addActionListener(this);
		viewAll.addActionListener(this);

		size = searchByName.getPreferredSize();
		searchByName.setBounds(60, 180, size.width, size.height);
		mainPanel.add(searchByName);
		size = searchText.getPreferredSize();
		searchText.setBounds(200, 180, size.width, size.height);
		mainPanel.add(searchText);
		size = viewAll.getPreferredSize();
		viewAll.setBounds(400, 180, size.width, size.height);
		mainPanel.add(viewAll);

		size = dataTable.getPreferredSize();
		scroll.setBounds(20, 210, WIDTH - 50, 300);
		mainPanel.add(scroll);
	}

	public void setRemovePanelLayout() {
		Dimension size = new Dimension();
		removeById.addActionListener(this);

		size = removeById.getPreferredSize();
		removeById.setBounds(60, 520, size.width, size.height);
		mainPanel.add(removeById);
		size = removeText.getPreferredSize();
		removeText.setBounds(200, 520, size.width, size.height);
		mainPanel.add(removeText);
	}

	public void open() {
		Student newStudent = new Student("Matt", "Besek", "04/25/2000", "Computer Science");
		studentMap.put(newStudent.id, newStudent);
		newStudent = new Student("Dalton", "Prenot", "04/25/2000", "Math");
		studentMap.put(newStudent.id, newStudent);
		newStudent = new Student("Matt", "Johnson", "04/25/2000", "Buisness");
		studentMap.put(newStudent.id, newStudent);
		newStudent = new Student("Caleb", "Gundberg", "04/25/2000", "Accounting");
		studentMap.put(newStudent.id, newStudent);
		setAddLayout();
		setDataLayout();
		setRemovePanelLayout();
		setDataTable(studentsToList());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(mainPanel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addStudent) {
			if(!validateStudentInput()) {
				return;
			}
			Student newStudent = new Student(fNameText.getText(), lNameText.getText(), dobText.getText(),
					majorText.getText().isBlank() ? "Undefined" : majorText.getText());
			studentMap.put(newStudent.id, newStudent);
			setDataTable(studentsToList());
            JOptionPane.showMessageDialog(addStudent, newStudent.fName + " "+newStudent.lName + " was added.",
            		"Student Added", JOptionPane.INFORMATION_MESSAGE);
            resetAddStudent();
		} else if (e.getSource() == viewAll) {
			ArrayList<Student> list = studentsToList();
			if(list.size() == 0) {
                JOptionPane.showMessageDialog(removeById, "There are no students in the Database.",
                		"No Students Found", JOptionPane.ERROR_MESSAGE);
    			searchText.setText("");
                return;
			}
			setDataTable(list);
		} else if (e.getSource() == searchByName) {
			ArrayList<Student> list = studentsToList(searchText.getText());
			if(list.size() == 0) {
                JOptionPane.showMessageDialog(removeById, searchText.getText() + " did not match any students",
                		"No Students Found", JOptionPane.ERROR_MESSAGE);
    			searchText.setText("");
                return;
			}
			setDataTable(list);
			searchText.setText("");
		} else if (e.getSource() == removeById) {
			int id;
			try {
				id = Integer.parseInt(removeText.getText());
			} catch(Exception ex){
                JOptionPane.showMessageDialog(removeById, "Id is not in correct format.", "Invalid Id", JOptionPane.ERROR_MESSAGE);
				return;
			}
			removeStudent(id);
			removeText.setText("");
			setDataTable(studentsToList());
		}
	}

	public void setDataTable(ArrayList<Student> students) {
		String columns[] = { "Id", "First Name", "Last Name", "Date of Birth", "Major" };
		String output = "";
		output += String.format("|%-5.5s|%-15.15s|%-15.15s|%-20.20s|%-15.15s|\n", columns[0], columns[1], columns[2],
				columns[3], columns[4]);// .replace(' ', '_');
		output += "|" + "-".repeat(74) + "|\n";

		for (Student s : students) {
			output += String.format("|%-5.5s|%-15.15s|%-15.15s|%-20.20s|%-15.15s|\n", s.id, s.fName, s.lName, s.dob,
					s.major);
		}

		dataTable.setText(output);

	}

	public ArrayList<Student> studentsToList() {
		Collection<Student> values = studentMap.values();
		return new ArrayList<>(values);
	}

	public ArrayList<Student> studentsToList(String filter) {
		filter = filter.toLowerCase();
		Collection<Student> values = studentMap.values();
		ArrayList<Student> listOfValues = new ArrayList<Student>();
		for (Student s : values) {
			if (s.fName.toLowerCase().contains(filter) || s.lName.toLowerCase().contains(filter)) {
				listOfValues.add(s);
			}
		}
		return listOfValues;
	}
	
	public void removeStudent(int id) {
		if(studentMap.containsKey(id)) {
			studentMap.remove(id);
            JOptionPane.showMessageDialog(removeById, "Student " + id + " was removed", "Student Removed", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
        JOptionPane.showMessageDialog(removeById, id + " does not match a student.", "Invalid Id", JOptionPane.ERROR_MESSAGE);
	}
	
	public void resetAddStudent() {
        fNameText.setText("");
        lNameText.setText("");
        dobText.setText("");
        majorText.setText("");		
	}
	public boolean validateStudentInput() {
		boolean valid = true;
		String msg = "Fields are Required: ";
		if(fNameText.getText().isBlank()) {
			msg += "First Name, ";
			valid = false;
		}
		if(lNameText.getText().isBlank()) {
			msg += "Last Name, ";
			valid = false;
		}
		if(dobText.getText().isBlank()) {
			msg += "Date of Birth";
			valid = false;
		}
		if(!valid) {
			JOptionPane.showMessageDialog(addStudent, msg, "Student Validation Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}

class Student {
	public static int nextId = 1000;
	public String fName;
	public String lName;
	public String dob;
	public String major;
	public int id;

	public Student(String fname, String lname, String dob, String major) {
		this.fName = fname;
		this.lName = lname;
		this.dob = dob;
		this.major = major;
		this.id = nextId++;
	}

}

public class Main {
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.open();
	}

}
