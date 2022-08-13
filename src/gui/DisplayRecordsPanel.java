package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Records;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class DisplayRecordsPanel extends JPanel{
	private MainFrame main;
 	private DefaultTableModel model;
	private JTable table;
	private JLabel lblNewLabel;
	private Records[] calculations;
	private JTextField textField;
	public DisplayRecordsPanel(MainFrame main) {
		this.main = main;
		setLayout(null);
	
	 
    this.model=new DefaultTableModel();
    this.table = new JTable(model);

    model.addColumn("Name");
    model.addColumn("Gender");
    model.addColumn("Country");
      
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(0, 0, 278, 195);
    
    add(scrollPane);
    JButton btnAddRow = new JButton("Add Row");
    btnAddRow.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		 int p = 0;
    		    model.insertRow(p, new Object[] {"kkkk", "kkkk", "999"});
    	}
    });
    btnAddRow.setBounds(10, 211, 124, 29);
    add(btnAddRow);
    
    JButton btnBackToAdd = new JButton("Back to Add");
    btnBackToAdd.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		main.showDisPanel();
    	}
    });
    btnBackToAdd.setBounds(10, 256, 124, 29);
   
    add(btnBackToAdd);
    JButton btnRemoveRow = new JButton("Remove Row");
    btnRemoveRow.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int numRows = table.getSelectedRow();
    			if(numRows == -1) 
    				return;
    			model.removeRow(numRows);
    			Records s = calculations[numRows];
    			main.getController().deleteCalculation(numRows, s); 
    	}
           
    	
    });
    btnRemoveRow.setBounds(149, 256, 129, 29);
       
    add(btnRemoveRow);
    
    JButton btnSearch = new JButton("Search");
    btnSearch.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String search = textField.getText().toString();
    		 for(int i = 0; i < table.getRowCount(); i++){//For each row
    		        for(int j = 0; j < table.getColumnCount(); j++){//For each column in that row
    		            if(table.getModel().getValueAt(i, j).equals(search)){//Search the model
    		                System.out.println(table.getModel().getValueAt(i, j));//Print if found string
    		                lblNewLabel.setText((String) table.getModel().getValueAt(i, j));
    		            }
    		        }//For loop inner
    		    }//For loop outer
    	}
    });
    btnSearch.setBounds(270, 154, 115, 29);
    
    add(btnSearch);
    
    textField = new JTextField();
    textField.setBounds(275, 212, 89, 26);
    add(textField);
    textField.setColumns(10);
    
    JLabel lblEnterForSerach = new JLabel("Enter for search");
    lblEnterForSerach.setFont(new Font("Tahoma", Font.PLAIN, 11));
    lblEnterForSerach.setBounds(275, 189, 89, 20);
    add(lblEnterForSerach);
    
    this.lblNewLabel = new JLabel("Search Result");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblNewLabel.setBounds(285, 260, 79, 20);
    add(lblNewLabel);
    
    JButton btnEdit_1 = new JButton("Edit");
    btnEdit_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int numRows = table.getSelectedRow();
    		System.out.println("The selected row is :"+numRows);
    	   

    		if(numRows == -1) 
    				return;
    		
    			Records rec = calculations[numRows]; 
    			main.showEditPanel1(numRows, rec);
 
           
    	}
    });
    btnEdit_1.setBounds(145, 211, 115, 29);
    add(btnEdit_1);
    
   
    this.populateCalculationList();
 
  }
	public void addPeople(String n, String d, String c) {
		int p = 0;
	    model.insertRow(model.getRowCount(), new Object[] {n, d, c});
		
	}
	
	private void populateCalculationList()
	{
	this.calculations = this.main.getController().getAllCalculations();
	for(int i=0; i < calculations.length; i++)
	{
	Records op = calculations[i];
	 model.insertRow(table.getRowCount(), new Object[] {op.getName(), op.getDate(), op.getCategory() });
	}
	this.table.setModel(model);
	}
		}