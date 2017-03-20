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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.JCheckBox;

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
	public main_ui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setTitle("JAGT v0.45 indev");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
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
		results.setBounds(109, 197, 315, 53);
		contentPane.add(results);
		//Output label
		JLabel lblOutput = DefaultComponentFactory.getInstance().createLabel("Output:");
		lblOutput.setBounds(109, 172, 92, 14);
		contentPane.add(lblOutput);
		//Tool menu combo box
		@SuppressWarnings("rawtypes")
		JComboBox tool_menu = new JComboBox();
		tool_menu.setToolTipText("");
		tool_menu.setBounds(264, 42, 160, 20);
		contentPane.add(tool_menu);
		tool_menu.addItem("Select a tool");
		tool_menu.addItem("Slope Finder");
		tool_menu.addItem("Line Divider");
		tool_menu.addItem("Perpendicular Bisector");
		tool_menu.addItem("Distance Finder");
		tool_menu.addItem("Circle Equation");
		//Slope Check box
		JCheckBox slopeCheckBox = new JCheckBox("Display slope as decimal?");
		slopeCheckBox.setBounds(10, 131, 180, 23);
		contentPane.add(slopeCheckBox);
		//Choice for circle equation to use either a point on the circle or the radius of the circle
		@SuppressWarnings("rawtypes")
		JComboBox circleChoice = new JComboBox();
		circleChoice.setToolTipText("");
		circleChoice.setBounds(264, 101, 160, 20);
		contentPane.add(circleChoice);
		circleChoice.addItem("Radius of circle");
		circleChoice.addItem("Point on the circle");
		circleChoice.setVisible(false);
		
		JLabel CX = new JLabel("X of center of circle");
		CX.setBounds(109, 13, 125, 17);
		contentPane.add(CX);
		CX.setVisible(false);
		
		JLabel CY = new JLabel("Y of center of circle");
		CY.setBounds(109, 42, 114, 20);
		contentPane.add(CY);
		CY.setVisible(false);
		
		JLabel PX = new JLabel("X of point on circle");
		PX.setBounds(109, 70, 114, 26);
		contentPane.add(PX);
		PX.setVisible(false);
		
		JLabel PY = new JLabel("Y of point on circle");
		PY.setBounds(109, 101, 114, 26);
		contentPane.add(PY);
		PY.setVisible(false);
		
		JLabel radius = new JLabel("Radius");
		radius.setBounds(109, 73, 55, 20);
		contentPane.add(radius);
		
		JLabel circleOptions = new JLabel("Circle Options");
		circleOptions.setBounds(300, 72, 92, 23);
		contentPane.add(circleOptions);
		circleOptions.setVisible(false);
		radius.setVisible(false);
		
		//Action Listeners	
		//Tool menu list; pretty much to just hide and show stuff for different tools
		tool_menu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (tool_menu.getSelectedItem().equals("Line Divider")) {
					radius.setVisible(false);
					CX.setVisible(false);
					CY.setVisible(false);
					circleOptions.setVisible(false);
					PX.setVisible(false);
					PY.setVisible(false);
					numText.setVisible(true);
					demText.setVisible(true);
					ratioLabel.setVisible(true);
					numLabel.setVisible(true);
					demLabel.setVisible(true);
					lblAx.setVisible(true);
					lblAy.setVisible(true);
					lblBx.setVisible(true);
					lblBy.setVisible(true);
					textField_3.setVisible(true);
					circleChoice.setVisible(false);
				}
				else if (tool_menu.getSelectedItem().equals("Circle Equation")){
					circleChoice.setVisible(true);
					circleChoice.setSelectedIndex(0);
					radius.setVisible(true);
					CX.setVisible(true);
					CY.setVisible(true);
					circleOptions.setVisible(true);
					PX.setVisible(false);
					PY.setVisible(false);
					lblAx.setVisible(false);
					lblAy.setVisible(false);
					lblBy.setVisible(false);
					lblBx.setVisible(false);
					textField_3.setText("0");
					textField_3.setVisible(false);
					numText.setVisible(false);
					demText.setVisible(false);
					ratioLabel.setVisible(false);
					numLabel.setVisible(false);
					demLabel.setVisible(false);
				}
				else {
					radius.setVisible(false);
					CX.setVisible(false);
					circleOptions.setVisible(false);
					CY.setVisible(false);
					PX.setVisible(false);
					PY.setVisible(false);
					numText.setVisible(false);
					demText.setVisible(false);
					ratioLabel.setVisible(false);
					numLabel.setVisible(false);
					demLabel.setVisible(false);
					lblAx.setVisible(true);
					lblAy.setVisible(true);
					lblBx.setVisible(true);
					lblBy.setVisible(true);
					textField_3.setVisible(true);
					circleChoice.setVisible(false);
				}
			}
		});
		//Circle option choice listener to get rid of extra box
		circleChoice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0){
				if (circleChoice.getSelectedItem().equals("Radius of circle")){
					textField_3.setVisible(false);
					textField_3.setText("0");
					radius.setVisible(true);
					PX.setVisible(false);
					PY.setVisible(false);
				}
				else{
					textField_3.setVisible(true);
					textField_3.setText("");
					PX.setVisible(true);
					PY.setVisible(true);
					radius.setVisible(false);
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
				slopeCheckBox.setSelected(false);
				results.setText("----------------------");
				tool_menu.setSelectedIndex(0);
			}
		});
		//Calculate button
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent button) {
				if ((tool_menu.getSelectedItem().equals("Line Divider") && numLabel.getText().equals("")) || (tool_menu.getSelectedItem().equals("Line Divider") && demLabel.getText().equals(""))) {
					results.setText("One or more of the required inputs is blank");
					return;
				}
				else if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.equals("") || tool_menu.getSelectedItem().equals("Select a tool")) {
					results.setText("One or more of the required inputs is blank");
					return;
				}
				else if (tool_menu.getSelectedItem().equals("Circle Equation") && (textField_2.getText().equals("") || (circleChoice.getSelectedItem().equals("Point on the circle") && textField_3.getText().equals("")))){
					results.setText("One or more of the required inputs is blank");
					return;
				}
				else {
					String choice = (String) tool_menu.getSelectedItem();
					int ax = Integer.parseInt(textField.getText());
					int ay = Integer.parseInt(textField_1.getText());
					int bx = Integer.parseInt(textField_2.getText());
					int by = Integer.parseInt(textField_3.getText());
					String fin;
					String fin1;
					String fin2;
					String fin3;
					String fin4;
					boolean isDecimal = slopeCheckBox.isSelected();
					switch(choice) {
					case "Slope Finder": fin = main.slopetool(ax, ay, bx, by, isDecimal); results.setText(fin); break;
					case "Line Divider": int[] ratio = {Integer.parseInt(numText.getText()), Integer.parseInt(demText.getText())}; fin1 = main.divider(ax, ay, bx, by, ratio); results.setText(fin1); break;
					case "Perpendicular Bisector": fin2 = main.bisector(ax, ay, bx, by, isDecimal); results.setText(fin2); break;
					case "Distance Finder": fin3 = main.distance(ax, ay, bx, by, 1); results.setText(fin3); break;
					case "Circle Equation":
						int py;
						if (circleChoice.getSelectedItem().equals("Radius of circle")){
							py = 0;
						}
						else{
							py = Integer.parseInt(textField_3.getText());
						}
						fin4 = main.cequation(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), py, circleChoice.getSelectedIndex());
						results.setText(fin4);
						break;
					}
				}
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
