package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MainFrame;

public class LoginPanel extends JPanel{
	private static final long serialVersionUID = -5923657084797906150L;

	protected String g_szLoginFieldLabel = "Login:";
	protected String m_pInternalLoginString = "test"; // "testStudent"

	protected String g_szPasswordFieldLabel = "Password:";
	protected String m_pInternalPasswordMd5String = "098f6bcd4621d373cade4e832627b4f6"; // "test"
	
	
	protected String g_szFont = "Tahoma";
	protected int g_iFontType = Font.BOLD;
	protected int g_iFontSize = 16;
	
	public static String szGetMD5OfString(String szValue) {
		if (szValue == null) return null;

		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			return null;
		}

		md5.update(StandardCharsets.UTF_8.encode(szValue));

		return String.format("%032x", new BigInteger(1, md5.digest()));
	}
	
	private JLabel pMakeNewLable(String szTitle) {
		JLabel pLabel = new JLabel(szTitle);
		pLabel.setFont(new Font(g_szFont, g_iFontType, g_iFontSize));

		return pLabel;
	}
	
	public LoginPanel(MainFrame main) {
		setLayout(null);

		final JLabel pLoginLabel = this.pMakeNewLable(g_szLoginFieldLabel);
		pLoginLabel.setBounds(15, 51, 99, 20);
		add(pLoginLabel);

		final JTextField pLoginTextField = new JTextField();
		pLoginTextField.setBounds(145, 48, 146, 26);
		add(pLoginTextField);
		pLoginTextField.setColumns(10);

		final JLabel pPasswordLabel = this.pMakeNewLable(g_szPasswordFieldLabel);
		pPasswordLabel.setBounds(15, 87, 115, 20);
		add(pPasswordLabel);

		final JPasswordField pPasswordTextField = new JPasswordField();
		pPasswordTextField.setBounds(145, 87, 146, 26);
		add(pPasswordTextField);
		pPasswordTextField.setColumns(10);
		
		JButton pButtonLogin = new JButton("Log in");
		pButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String szLogin = pLoginTextField.getText();
				if (szLogin == null || szLogin.length() < 1 || !szLogin.equals(m_pInternalLoginString)) return;

				@SuppressWarnings("deprecation")
				String szPassword = pPasswordTextField.getText();
				if (szPassword == null || szPassword.length() < 1 || !LoginPanel.szGetMD5OfString(szPassword).equals(m_pInternalPasswordMd5String)) return;

				main.showEventsPanel();
			}
		});
		pButtonLogin.setFont(new Font(g_szFont, g_iFontType, g_iFontSize));
		pButtonLogin.setBounds(155, 129, 115, 29);
		add(pButtonLogin);
	} 
}