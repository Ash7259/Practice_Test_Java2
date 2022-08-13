package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Event;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemMenu extends JPanel{
	private JTextField txtEnterItemName;
	private JTextField txtSelectItemTo;
	private Event[] items;
	private int index;
	private JList ItemList;
	private MainFrame main;
	public ItemMenu(MainFrame main) {
		this.main=main;
		setLayout(null);
		
		JLabel lblItemMenuPage = new JLabel("Item Menu Page");
		lblItemMenuPage.setBounds(106, 11, 123, 24);
		lblItemMenuPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblItemMenuPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 38, 258, 118);
		add(scrollPane);
		
		this.ItemList = new JList();
		scrollPane.setViewportView(ItemList);
		ItemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("AAAAAAAAAAAAAAAAA valueChanged() ");
				if(e.getValueIsAdjusting())
					//This line prevents double triggering
					{
					index = ItemList.getSelectedIndex();
				if(index == -1)
					return; //To avoid triggering when model is set
				Event item = items[index];
				txtSelectItemTo.setText(""+item.getEventName());
				}
				}
			});

JButton btnAddItem = new JButton("Add Item");
btnAddItem.setBounds(20, 190, 115, 23);
btnAddItem.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		String name = txtEnterItemName.getText();
		main.getController().storeItem(name);
		populateList();
		}
		});
		add(btnAddItem);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(20, 224, 115, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Item inside Menu Name:");
				String aa= txtSelectItemTo.getText();
				Event newItem=new Event(aa);
				
				main.getController().editItem(index, newItem);
				System.out.println("Item inside Menu Name:"+aa);
				populateList();
				}
			});
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete Item");
		btnDelete.setBounds(20, 258, 115, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index= ItemList.getSelectedIndex();
				if(index == -1)
					return;
				Event item = items[index];
				txtSelectItemTo.setText(item.getEventName());
				main.getController().deleteItem(index);
				populateList();
		}
		});
		add(btnDelete);
		
		txtEnterItemName = new JTextField();
		txtEnterItemName.setBounds(150, 191, 175, 20);
		txtEnterItemName.setText("Enter item name here");
		add(txtEnterItemName);
		txtEnterItemName.setColumns(10);
		
		txtSelectItemTo = new JTextField();
		txtSelectItemTo.setBounds(150, 225, 175, 20);
		txtSelectItemTo.setText("Selected item shown here");
		add(txtSelectItemTo);
		txtSelectItemTo.setColumns(10);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(170, 258, 115, 23);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = items.length;
				String msg = "The no.items in List is: " + count;
				
				JOptionPane.showMessageDialog(null, msg, "Selection", JOptionPane.PLAIN_MESSAGE);
				}
			});
			add(btnCheckOut);
			}
			private void populateList()
			{
				this.items = this.main.getController().getAllItems();
				DefaultListModel model = new DefaultListModel();
				for(int i=0; i < items.length; i++)
			{
					Event op = items[i];
					model.addElement(op.getEventName());
			}
			this.ItemList.setModel(model);
			}
}