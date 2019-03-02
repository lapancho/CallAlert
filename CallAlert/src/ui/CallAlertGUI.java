package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import callAlert.model.CallAlertModel;

public class CallAlertGUI {

	/** JFrame for the GUI */
	private static JFrame gui;
	/** WolfSchedulerGUI title */
	private static final String APP_TITLE = "CallAlert";
	/** Constant to identify LoginPanel */
	private static final String LOGIN_PANEL = "LoginPanel";
	/** Constant to identify CourseCatalogPanel */
	private static final String CALL_PANEL = "CallPanel";
	/** LoginPanel */
	private LoginPanel pnlLogin;
	/** RegistrarPanel */
	private JPanel pnlCall;
	/** CardLayout for GUI */
	private CardLayout cardLayout;
	/** Panel that will contain all of the application views */
	private JPanel panel;

	public CallAlertGUI() {

		gui = new JFrame();
		gui.setSize(800, 800);
		gui.setLocation(50, 50);
		gui.setTitle(APP_TITLE);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnlLogin = new LoginPanel();
		pnlCall = new JPanel();
		panel = new JPanel();
		cardLayout = new CardLayout();

		panel.setLayout(cardLayout);
		panel.add(pnlLogin, LOGIN_PANEL);
		panel.add(pnlCall, CALL_PANEL);
		cardLayout.show(panel, LOGIN_PANEL);
		Container c = gui.getContentPane();
		c.add(panel, BorderLayout.CENTER);

		gui.setVisible(true);
	}

	/**
	 * Starts the Pack Scheduler program.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		new CallAlertGUI();
	}

	/**
	 * Creates a panel for user authentication into the system.
	 * 
	 * @author SarahHeckman
	 */
	private class LoginPanel extends JPanel implements ActionListener {

		/** ID number used for object serialization. */
		private static final long serialVersionUID = 1L;

		/** JLabel for id */
		private JLabel lblId;
		/** JTextField for id */
		private JFormattedTextField phoneNum;

		/** JLabel for password */
		private JLabel lblPassword;
		/** JTextField for password */
		private JPasswordField txtPassword;

		/** JButton to Login */
		private JButton btnLogin;
		/** JButton to Clear */
		private JButton btnClear;

		/**
		 * Constructs the LoginPanel.
		 */
		public LoginPanel() {
			super(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();

			// Create ID components
			lblId = new JLabel("User Phone Number:");
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(lblId, c);

			phoneNum = new JFormattedTextField(NumberFormat.getNumberInstance());
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(phoneNum, c);

			// Create Password components
			lblPassword = new JLabel("Password:");
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(lblPassword, c);

			txtPassword = new JPasswordField(20);
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(txtPassword, c);

			// Create Buttons
			btnClear = new JButton("Clear");
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(btnClear, c);

			btnLogin = new JButton("Login");
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.fill = GridBagConstraints.RELATIVE;
			add(btnLogin, c);

			// Add ActionListeners
			btnLogin.addActionListener(this);
			btnClear.addActionListener(this);
		}

		/**
		 * Performs actions when any component with an action listener is selected.
		 * 
		 * @param e ActionEvent representing the user action
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLogin) {
				String pN = phoneNum.getText();
				int num = Integer.parseInt(pN);
				String password = new String(txtPassword.getPassword());

				CallAlertModel manager = CallAlertModel.getInstance();
				try {
					if (manager.login(num, password) != null) {
						phoneNum.setText("");
						txtPassword.setText("");
						cardLayout.show(panel, CALL_PANEL);
					} else {
						JOptionPane.showMessageDialog(this, "Invalid login information.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(this, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else if (e.getSource() == btnClear) {
				phoneNum.setText("");
				txtPassword.setText("");
			}
		}

	}
}
