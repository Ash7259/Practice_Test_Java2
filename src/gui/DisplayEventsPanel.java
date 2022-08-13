package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Event;
import data.Records;

public class DisplayEventsPanel extends JPanel{
	private static final long serialVersionUID = -5110448543611513151L;
	private Event[] event;
	private String aa="";
	private MainFrame main;
	public DisplayEventsPanel(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JLabel lblAddDisplay = new JLabel("Show All Events");
		lblAddDisplay.setBounds(87, 11, 158, 20);
		lblAddDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblAddDisplay);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(66, 98, 208, 69);
		add(textArea);
		
		JButton btnDisplay = new JButton("Display All Events");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event = main.getController().getEvents();
				String aa = "";
				for(int i = 0; i < event.length; i++){
					Event bk = event[i];
				    aa = aa + bk.getEventName() + " " + bk.getEventDate()+ " " + bk.getcategoryName() + "\n";
					textArea.setText(aa);
				}
			}
		});
		
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBounds(66, 43, 178, 29);
		add(btnDisplay);
		
		JButton btnBack = new JButton("Back to Add Event");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showEventsPanel();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(66, 191, 207, 29);
		add(btnBack);
		
		JButton btnGoToJlist = new JButton("Go to JList");
		btnGoToJlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showJList();
			}
		});
		btnGoToJlist.setBounds(66, 237, 97, 25);
		add(btnGoToJlist);
	
	}
}

	
