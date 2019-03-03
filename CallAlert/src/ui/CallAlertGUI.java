package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.acl.Group;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import callAlert.model.CallAlertModel;

public class CallAlertGUI extends JFrame implements ActionListener, Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** JFrame for the GUI */
	private static JFrame gui;
	/** WolfSchedulerGUI title */
	private static final String APP_TITLE = "CallAlert";
	/** Constant to identify LoginPanel */
	private static final String LOGIN_PANEL = "LoginPanel";
	/** Constant to identify CourseCatalogPanel */
	private static final String CALL_PANEL = "CallPanel";
//	/** LoginPanel */
//	private LoginPanel pnlLogin;
	/** RegistrarPanel */
	private JPanel pnlCall;
	/** CardLayout for GUI */
	private CardLayout cardLayout;
	/** Panel that will contain all of the application views */
	private JPanel panel;

	/** field for age min text box */
	private JLabel nameLabel;
	/** Text field for numerator 1 */
	private JTextField nameTextField;
	/** Label for denominator 1 */
	private JLabel additionalInfoLabel;
	/** Text field for denominator 1 */
	private JTextArea additionalInfoTextArea;
	/** Label for numerator 2 */
	private JLabel raceDate;
	/** Text field for numerator 2 */
	private JTextField raceDateText;
	/** Label for denominator 2 */
	private JLabel raceLocation;
	/** Text field for denominator 2 */
	private JTextField raceLocationText;

	private JButton callButton;

	public CallAlertGUI() {
		super();

		// Observe Manager
		CallAlertModel.getInstance().addObserver(this);

		// Set up general GUI info
		setSize(650, 600);
		setLocation(50, 50);
		setTitle(APP_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(NORMAL);
			}
		});

		initializeGUI();

		// Set the GUI visible
		setVisible(true);

//
//		gui = new JFrame();
//		gui.setSize(800, 800);
//		gui.setLocation(50, 50);
//		gui.setTitle(APP_TITLE);
//		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////		pnlLogin = new LoginPanel();
//		pnlCall = new JPanel();
//		panel = new JPanel();
//		cardLayout = new CardLayout();
//
//		panel.setLayout(cardLayout);
////		panel.add(pnlLogin, LOGIN_PANEL);
//		panel.add(pnlCall, CALL_PANEL);
//		cardLayout.show(panel, LOGIN_PANEL);
//		Container c = gui.getContentPane();
//		c.add(panel, BorderLayout.CENTER);
//
//		gui.setVisible(true);
	}

	private void initializeGUI() {
		// info container holds all the panels
		Container infoContainer = this.getContentPane();

		// infoPanel holds additional information
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));

		// callButtonPanel holds the call butotn
		JPanel callButtonPanel = new JPanel();
		callButtonPanel.setLayout(new BoxLayout(callButtonPanel, BoxLayout.Y_AXIS));

		// personalInfoPanel holds personalInfo and inputPanel
		JPanel personalInfoPanel = new JPanel();
		personalInfoPanel.setBorder(new TitledBorder("Personal Information"));
		personalInfoPanel.setPreferredSize(new Dimension(600, 200));

		JPanel personalInfo = new JPanel();
		personalInfo.setLayout(new BoxLayout(personalInfo, BoxLayout.Y_AXIS));

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		personalInfoPanel.add(personalInfo);
		personalInfoPanel.add(inputPanel);

		// PERSONAL INFO PANEL
		nameLabel = new JLabel("Name:");
		personalInfo.add(nameLabel);
		nameTextField = new JTextField(35);
		inputPanel.add(nameTextField);
		
		raceDate = new JLabel("Address:");
		personalInfo.add(raceDate);
		raceDateText = new JTextField(35);
		inputPanel.add(raceDateText);

		additionalInfoLabel = new JLabel("Additional Info:");
		personalInfo.add(additionalInfoLabel);
		additionalInfoTextArea = new JTextArea(3,35);
		inputPanel.add(additionalInfoTextArea);
		
//		JPanel textBoxPanel = new JPanel();
//		textBoxPanel.add(additionalInfoTextArea);
//		
//		inputPanel.add(textBoxPanel);


		// ADDITIONAL INFO PANEL

		JRadioButton urgentButton = new JRadioButton("Urgent");
		JRadioButton moderateButton = new JRadioButton("Moderate");
		JRadioButton lowButton = new JRadioButton("Low");
		urgentButton.setSelected(true);

		ButtonGroup urgencyLevel = new ButtonGroup();
		urgencyLevel.add(urgentButton);
		urgencyLevel.add(moderateButton);
		urgencyLevel.add(lowButton);

		urgentButton.addActionListener(this);
		moderateButton.addActionListener(this);
		lowButton.addActionListener(this);

		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(urgentButton);
		radioPanel.add(moderateButton);
		radioPanel.add(lowButton);

		infoPanel.add(radioPanel);

		// CALL BUTTON PANEL
		callButton = new JButton("Call");
		callButtonPanel.add(callButton);
		callButton.addActionListener(this);

		JPanel leftPanel = new JPanel();
		leftPanel.add(personalInfoPanel, BorderLayout.NORTH);
		leftPanel.add(infoPanel, BorderLayout.SOUTH);
		leftPanel.add(callButtonPanel, BorderLayout.SOUTH);

		infoContainer.add(leftPanel);

	}

	/**
	 * Starts the Pack Scheduler program.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		new CallAlertGUI();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == callButton) {
			
		}
		
	}

//	/**
//	 * Creates a panel for user authentication into the system.
//	 *
//	 */
//	private class LoginPanel extends JPanel implements ActionListener {
//
//		/** ID number used for object serialization. */
//		private static final long serialVersionUID = 1L;
//
//		/** JTextField for phone number */
//		private JFormattedTextField phoneNum;
//
//		/** JLabel for id */
//		private JLabel lblId;
//		/** JLabel for password */
//		private JLabel lblPassword;
//		/** JTextField for password */
//		private JPasswordField txtPassword;
//
//		/** JButton to Login */
//		private JButton btnLogin;
//		/** JButton to Clear */
//		private JButton btnClear;
//		/** JButton to create new user */
//		private JButton btnCreateAccount;
//
//		
//		
//		public
//		
//		
//		
//		/**
//		 * Constructs the LoginPanel.
//		 */
//		public LoginPanel() {
//			super(new GridBagLayout());
//
//			GridBagConstraints c = new GridBagConstraints();
//
//			// Create ID components
//			lblId = new JLabel("User Phone Number:");
//			c.gridx = 0;
//			c.gridy = 0;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(lblId, c);
//
//			phoneNum = new JFormattedTextField(NumberFormat.getNumberInstance());
//			c.gridx = 1;
//			c.gridy = 0;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(phoneNum, c);
//
//			// Create Password components
//			lblPassword = new JLabel("Password:");
//			c.gridx = 0;
//			c.gridy = 1;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(lblPassword, c);
//
//			txtPassword = new JPasswordField(20);
//			c.gridx = 1;
//			c.gridy = 1;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(txtPassword, c);
//
//			// Create Buttons
//			btnClear = new JButton("Clear");
//			c.gridx = 0;
//			c.gridy = 2;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(btnClear, c);
//
//			btnLogin = new JButton("Login");
//			c.gridx = 1;
//			c.gridy = 2;
//			c.gridwidth = 1;
//			c.weightx = 0.5;
//			c.anchor = GridBagConstraints.FIRST_LINE_START;
//			c.fill = GridBagConstraints.RELATIVE;
//			add(btnLogin, c);
//
//			// Add ActionListeners
//			btnLogin.addActionListener(this);
//			btnClear.addActionListener(this);
//		}
//
//		/**
//		 * Performs actions when any component with an action listener is selected.
//		 * 
//		 * @param e ActionEvent representing the user action
//		 */
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			
//			
//			
//			
////			// LOGIN
////			if (e.getSource() == btnLogin) {
////				String pN = phoneNum.getText();
////				int num = Integer.parseInt(pN);
////				String password = new String(txtPassword.getPassword());
////
////				CallAlertModel manager = CallAlertModel.getInstance();
////				try {
////					if (manager.login(num, password) != null) {
////						phoneNum.setText("");
////						txtPassword.setText("");
////						cardLayout.show(panel, CALL_PANEL);
////					} else {
////						JOptionPane.showMessageDialog(this, "Invalid login information.", "Error",
////								JOptionPane.ERROR_MESSAGE);
////					}
////				} catch (IllegalArgumentException iae) {
////					JOptionPane.showMessageDialog(this, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
////				}
////				// CLEAR TEXT FIELDS
////			} else if (e.getSource() == btnClear) {
////				phoneNum.setText("");
////				txtPassword.setText("");
////				// CREATE NEW USER
////			} else if (e.getSource() == btnCreateAccount) {
////				try {
////					String fn = firstNameField.getText();
////					String ln = lastNameField.getText();
////					String pString = phoneNum.getText();
////					int p = Integer.parseInt(pString);
////
////				} catch (IllegalArgumentException iae2) {
////					JOptionPane.showMessageDialog(this, iae2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
////				}
////			}
//		}
//
//	}
}
