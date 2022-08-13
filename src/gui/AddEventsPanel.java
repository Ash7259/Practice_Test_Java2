package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.time.ZoneId;
import java.util.Date;

public class AddEventsPanel extends JPanel{
	private static final long serialVersionUID = 4090501493376554858L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public AddEventsPanel(MainFrame main) {
		setLayout(null);
		
		JLabel lblEventName = new JLabel("Event Name:");
		lblEventName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEventName.setBounds(15, 51, 99, 20);
		add(lblEventName);
		
		JLabel lblAddDisplay = new JLabel("Add Event");
		lblAddDisplay.setBounds(176, 11, 115, 20);
		lblAddDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblAddDisplay);
		
		JLabel lblYear = new JLabel("Date:");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYear.setBounds(25, 94, 69, 20);
		add(lblYear);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(12, 144, 118, 20);
		add(lblCategory);
		
		textField = new JTextField();
		textField.setBounds(135, 88, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 142, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135,35,146,26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String szTitle = textField.getText();
				String pTempDate1 = textField_1.getText();
				String a = textField_2.getText();
				main.getController().addEvent(szTitle, pTempDate1, a);
				main.showDisPanel();
				//textField.setText("");
				//textField_2.setText("");
				
			}
		});
		btnAddEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddEvent.setBounds(146, 195, 115, 29);
		add(btnAddEvent);
		
		JButton btnGoTo = new JButton("Go to Display Events");
		btnGoTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { main.showDisPanel(); }
		});
		btnGoTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGoTo.setBounds(104, 237, 202, 29);
		add(btnGoTo);


	} 
}