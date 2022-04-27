import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

class GUI implements ActionListener {
	final int WIDTH = 600;
	final int HEIGHT = 500;
	private File currentFile;
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel;
	private JPanel panel2;
	private JLabel selectedFile;
	private JButton browse;
	private JButton search;
	private JButton replace;
	private JButton save;
	private JTextArea textArea;
	private JScrollPane scroll;

	private JTextField searchText;
	private JLabel searchLabel;
	private JTextField replaceText;
	private JLabel replaceLabel;
	private Highlighter highlighter;
	private HighlightPainter painter;

	public GUI() {
		frame = new JFrame("Text Editor");
		mainPanel = new JPanel();
		panel = new JPanel();
		panel2 = new JPanel();
		browse = new JButton("Browse");
		selectedFile = new JLabel("No File Selected");
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);

		search = new JButton("Search Word");
		replace = new JButton("Replace All");
		save = new JButton("Save Changes");
		searchText = new JTextField(30);
		replaceText = new JTextField(30);
		searchLabel = new JLabel("Non case sensitive search");
		replaceLabel = new JLabel("case sensitive replace");
		highlighter = textArea.getHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	}

	public void open() {
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc = new GridBagConstraints();

		browse.addActionListener(this);
		search.addActionListener(this);
		replace.addActionListener(this);
		save.addActionListener(this);
		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				save.setEnabled(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx =1;

		// (1,0)
		panel.add(browse, gbc);
		gbc.gridx++; // (2,0)
		panel.add(selectedFile, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 3;
		textArea.setEditable(true);
		textArea.append("Hello World");
		scroll.setPreferredSize(new Dimension(WIDTH - 20, HEIGHT / 2));
		panel.add(scroll, gbc);
		gbc.gridwidth = 1;

		panel2.setLayout(new GridBagLayout());
		panel2.setBackground(Color.LIGHT_GRAY);
		gbc.gridy++;
		gbc.gridx = 0;
		searchText.setMinimumSize(new Dimension(100, 20));
		panel2.add(searchText, gbc);
		gbc.gridx++;
		panel2.add(search, gbc);
		gbc.gridx++;
		panel2.add(searchLabel, gbc);

		gbc.gridy++;
		gbc.gridx = 0;
		replaceText.setMinimumSize(new Dimension(100, 20));
		panel2.add(replaceText, gbc);
		gbc.gridx++;
		panel2.add(replace, gbc);
		gbc.gridx++;
		panel2.add(replaceLabel, gbc);

		gbc.gridy++;
		gbc.gridx = 3;
		save.setEnabled(false);
		panel2.add(save, gbc);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(panel);
		mainPanel.add(panel2);
		frame.add(mainPanel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == browse) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setFileFilter(new FileNameExtensionFilter("Text", "txt"));
			int option = fileChooser.showOpenDialog(frame);
			if (option != JFileChooser.APPROVE_OPTION) {
				selectedFile.setText("Open command canceled");
				return;
			}
			currentFile = fileChooser.getSelectedFile();
			highlighter.removeAllHighlights();
			selectedFile.setText("File Selected: " + currentFile.getName());
			try {
				FileReader reader = new FileReader(currentFile);
				BufferedReader br = new BufferedReader(reader);
				textArea.read(br, null);
				br.close();
				textArea.requestFocus();
			} catch (Exception ex) {
				System.out.println(ex);
			}
			save.setEnabled(false);
		} else if (e.getSource() == search) {
			String search = searchText.getText();
			String text = textArea.getText();
			if (search.isEmpty()) {
				return;
			}
			System.out.println(search);
			highlighter.removeAllHighlights();
			Pattern MY_PATTERN = Pattern.compile(search.toLowerCase());
			Matcher m = MY_PATTERN.matcher(text.toLowerCase());
			int count = 0;
			int pos = 0;
			while ((pos = text.toLowerCase().indexOf(search.toLowerCase(), pos)) >= 0) {
				try {
					highlighter.addHighlight(pos, pos + search.length(), painter);
					pos += search.length();
					count++;
				} catch (BadLocationException e1) {
				}
			}
			searchLabel.setText(count + " matches for " + search);

		} else if (e.getSource() == replace) {
			String search = searchText.getText();
			String replace = replaceText.getText();
			if (search.isEmpty()) {
				replaceLabel.setText("No words to replace");
				return;
			}
			Pattern MY_PATTERN = Pattern.compile(search);
			Matcher m = MY_PATTERN.matcher(textArea.getText());
			int count = 0;
			while (m.find()) {
				count++;
			}
			if (count == 0) {
				replaceLabel.setText("No words to replace");
				return;
			}
			replaceLabel.setText(count + " words replaced");
			textArea.setText(m.replaceAll(replace));
			save.setEnabled(true);

		} else if (e.getSource() == save) {
			try {
				FileWriter writer = new FileWriter(currentFile);
				BufferedWriter bw = new BufferedWriter(writer);
				textArea.write(bw);
				bw.close();
				textArea.requestFocus();
			} catch (Exception ex) {
				System.out.printf("Not Saved: %s", ex);
				// TODO:
				// implement save new file
			}
			save.setEnabled(false);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.open();
	}

}
