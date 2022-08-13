package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Event;
import data.Records;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPanel extends JPanel{
	private MainFrame main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Records rec;
	private int index;
	public EditPanel(MainFrame main, int ind, Records rec) {
		this.main = main;
		this.setSize(347, 312);
		setLayout(null);
		this.index=ind;
		this.rec = rec;
		
		JLabel lblEditScreen = new JLabel("Edit Panel");
		lblEditScreen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditScreen.setBounds(92, 16, 118, 20);
		add(lblEditScreen);
		
		textField = new JTextField();
		textField.setBounds(102, 52, 146, 26);
		add(textField);
		textField.setColumns(10);
		textField.setText(rec.getName());
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 112, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(rec.getDate());
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 175, 146, 26);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(rec.getCategory());
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String n = textField.getText();
				String d = textField_1.getText();
				String c = textField_2.getText();
				Records newrec = new Records(n,d,c);
				main.getController().editPanel(index, newrec);
			}
		
	});
	
		btnNewButton.setBounds(217, 233, 115, 29);
		add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(6, 55, 69, 20);
		add(lblName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(6, 115, 69, 20);
		add(lblDate);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(6, 178, 69, 20);
		add(lblCategory);
		
		JButton btnBackTo = new JButton("Back to Display");
		btnBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDisplayPanel();
			}

			private void showDisplayPanel() {
				main.showDisPanel();
				
			}
		});
		btnBackTo.setBounds(6, 233, 160, 29);
		add(btnBackTo);
	}
}