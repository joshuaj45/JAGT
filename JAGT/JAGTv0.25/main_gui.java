package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.Label;

@SuppressWarnings({ "serial", "unused" })
public class main_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField numText;
	private JTextField demText;

	private final JPopupMenu popupMenu = new JPopupMenu();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_ui frame = new main_ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public main_ui() {
		setTitle("JAGT v0.25 indev");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 227, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(10, 193, 89, 23);
		contentPane.add(btnCalculate);
		
		textField = new JTextField();
		textField.setBounds(13, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(13, 42, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(13, 73, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(13, 104, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		numText = new JTextField();
		numText.setBounds(140, 73, 86, 20);
		contentPane.add(numText);
		numText.setVisible(false);
		
		demText = new JTextField();
		demText.setBounds(140, 104, 86, 20);
		contentPane.add(demText);
		demText.setVisible(false);
		//Ratio label
		JLabel ratioLabel = DefaultComponentFactory.getInstance().createLabel("<html>Ratio of line lengths<br>for the<br>Line Divider Tool:</html>");
		ratioLabel.setBounds(140, 11, 114, 51);
		contentPane.add(ratioLabel);
		ratioLabel.setVisible(false);
		//Numerator label
		JLabel numLabel = DefaultComponentFactory.getInstance().createLabel("Numerator of ratio");
		numLabel.setBounds(236, 76, 131, 14);
		contentPane.add(numLabel);
		numLabel.setVisible(false);
		//Denominator label
		JLabel demLabel = DefaultComponentFactory.getInstance().createLabel("Denominator of ratio");
		demLabel.setBounds(236, 107, 131, 14);
		contentPane.add(demLabel);
		demLabel.setVisible(false);
		//Ax label
		JLabel lblAx = DefaultComponentFactory.getInstance().createLabel("AX");
		lblAx.setBounds(109, 14, 92, 14);
		contentPane.add(lblAx);
		//Ay label
		JLabel lblAy = DefaultComponentFactory.getInstance().createLabel("AY");
		lblAy.setBounds(109, 45, 92, 14);
		contentPane.add(lblAy);
		//Bx label
		JLabel lblBx = DefaultComponentFactory.getInstance().createLabel("BX");
		lblBx.setBounds(109, 76, 92, 14);
		contentPane.add(lblBx);
		//By label
		JLabel lblBy = DefaultComponentFactory.getInstance().createLabel("BY");
		lblBy.setBounds(109, 107, 92, 14);
		contentPane.add(lblBy);
		//Tools label
		JLabel lblTools = DefaultComponentFactory.getInstance().createLabel("Tools");
		lblTools.setBounds(332, 14, 92, 14);
		contentPane.add(lblTools);
		//Results label
		JLabel results = DefaultComponentFactory.getInstance().createLabel("----------------------");
		results.setBounds(109, 197, 315, 14);
		contentPane.add(results);
		//Output label; aesthetics only
		JLabel lblOutput = DefaultComponentFactory.getInstance().createLabel("Output:");
		lblOutput.setBounds(109, 172, 92, 14);
		contentPane.add(lblOutput);
		//Tool menu combo box
		@SuppressWarnings("rawtypes")
		JComboBox tool_menu = new JComboBox();
		tool_menu.setToolTipText("");
		tool_menu.setBounds(264, 39, 160, 20);
		contentPane.add(tool_menu);
		tool_menu.addItem("Select a tool");
		tool_menu.addItem("Slope Finder");
		tool_menu.addItem("Line Divider");
		tool_menu.addItem("Perpendicular Bisector");
		
		//Action Listeners
		//Tool menu list; pretty much to just hide and show stuff for different tools
		tool_menu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (tool_menu.getSelectedItem().equals("Line Divider")) {
					numText.setVisible(true);
					demText.setVisible(true);
					ratioLabel.setVisible(true);
					numLabel.setVisible(true);
					demLabel.setVisible(true);
				}
				else {
					numText.setVisible(false);
					demText.setVisible(false);
					ratioLabel.setVisible(false);
					numLabel.setVisible(false);
					demLabel.setVisible(false);
				}
			}
		});
		//Reset Button
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				numText.setText("");
				demText.setText("");
				results.setText("----------------------");
				tool_menu.setSelectedIndex(0);
			}
		});
		
		//Calculate button
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tool_menu.getSelectedItem().equals("Line Divider") && numLabel.getText().equals("") || tool_menu.getSelectedItem().equals("Line Divider") && demLabel.getText().equals("")) {
					results.setText("One or more of the required inputs is blank");
				}
				else if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.equals("") || tool_menu.getSelectedItem().equals("Select a tool")) {
					results.setText("One or more of the required inputs is blank");
				}
				else {
					String choice = (String) tool_menu.getSelectedItem();
					int ax = Integer.parseInt(textField.getText());
					int ay = Integer.parseInt(textField_1.getText());
					int bx = Integer.parseInt(textField_2.getText());
					int by = Integer.parseInt(textField_3.getText());
					String fin = null;
					String fin1 = null;
					String fin2 = null;
					switch(choice) {
					case "Slope Finder": fin = main.slopetool(ax, ay, bx, by); results.setText(fin); break;
					case "Line Divider": int[] ratio = {Integer.parseInt(numText.getText()), Integer.parseInt(demText.getText())}; fin1 = main.divider(ax, ay, bx, by, ratio); results.setText(fin1); break;
					case "Perpendicular Bisector": fin2 = main.bisector(ax, ay, bx, by); results.setText(fin2); break;
					}
				}
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
