package controller;

import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import gui.AddEventsPanel;
import gui.DisplayEventsPanel;
import gui.EditPanel;
import gui.ItemMenu;
import gui.LoginPanel;
import data.Event;
import data.Records;
import gui.DisplayRecordsPanel;

public class MainFrame extends JFrame {
	private Controller cont;
	private CardLayout card;

	public MainFrame() {
		this.setTitle("CCA App");
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(640, 480));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.card = new CardLayout();
		this.setLayout(this.card);
		this.cont = new Controller();
		this.showLoginPanel();
		this.setVisible(true);
	}

	public void showEventsPanel() {
		AddEventsPanel p1 = new AddEventsPanel(this);
		this.add(p1, "AddEvent");
		this.card.show(this.getContentPane(), "AddEvent");
	}

	public void showLoginPanel() {
		LoginPanel p4 = new LoginPanel(this);
		this.add(p4, "ShowLogin");
		this.card.show(this.getContentPane(), "ShowLogin");
	}

	public void showEditPanel1(int ind, Records rec) {
		EditPanel p3 = new EditPanel(this, ind, rec);
		this.add(p3, "editRecord");
		this.card.show(this.getContentPane(), "editRecord");
	}

	public void showDisPanel() {
		DisplayEventsPanel p2 = new DisplayEventsPanel(this);
		this.add(p2, "DisEvent");
		this.card.show(this.getContentPane(), "DisEvent");
	}

	public Controller getController() {
		return cont;
	}

	public static void main(String args[]) {
		MainFrame gui = new MainFrame();
	}

	public void showDisplayEvents() {
		DisplayRecordsPanel p2 = new DisplayRecordsPanel(null);
		this.add(p2, "DisRecord");
		this.card.show(this.getContentPane(), "DisRecord");
	}

	public void showAddEventsPanel() {
		AddEventsPanel p1 = new AddEventsPanel(this);
		getContentPane().add(p1, "AddEvents");
		this.card.show(this.getContentPane(), "AddEvents");
	}

	public void showJList() {
		ItemMenu p3 = new ItemMenu(this);
		getContentPane().add(p3, "AddJList");
		this.card.show(this.getContentPane(), "AddJList");

	}
}