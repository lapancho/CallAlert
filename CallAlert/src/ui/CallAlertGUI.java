package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
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
//	/** LoginPanel */
//	private LoginPanel pnlLogin;

	/** field for age min text box */
	private JLabel nameLabel;
	/** Text field for numerator 1 */
	private JTextField nameTextField;
	/** Label for denominator 1 */
	private JLabel additionalInfoLabel;
	/** Text field for denominator 1 */
	private JTextField additionalInfoTextArea;
	/** Label for numerator 2 */
	private JLabel raceDate;
	/** Text field for numerator 2 */
	private JTextField raceDateText;

	private JButton callButton;

	private JComboBox<String> reasons;

	public CallAlertGUI() {
		super();

		// Observe Manager
		CallAlertModel.getInstance().addObserver(this);

		// Set up general GUI info
		setSize(650, 300);
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

//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		setVisible(true);
	}

	private void initializeGUI() {
		// info container holds all the panels
		Container infoContainer = this.getContentPane();

		// infoPanel holds additional information
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

		// callButtonPanel holds the call button
		JPanel callButtonPanel = new JPanel();
		callButtonPanel.setLayout(new BoxLayout(callButtonPanel, BoxLayout.Y_AXIS));

		// personalInfoPanel holds personalInfo and inputPanel
		JPanel personalInfoPanel = new JPanel();
		personalInfoPanel.setBorder(new TitledBorder("Personal Information"));
		personalInfoPanel.setPreferredSize(new Dimension(600, 100));

		JPanel personalInfo = new JPanel();
		personalInfo.setLayout(new BoxLayout(personalInfo, BoxLayout.Y_AXIS));

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		personalInfoPanel.add(personalInfo);

		// PERSONAL INFO PANEL
		nameLabel = new JLabel("Name:");
		raceDate = new JLabel("Address:");
		additionalInfoLabel = new JLabel("Additional Info:");

		personalInfo.add(nameLabel);
		personalInfo.add(raceDate);
		personalInfo.add(additionalInfoLabel);

		nameTextField = new JTextField(35);
		raceDateText = new JTextField(35);
		additionalInfoTextArea = new JTextField(35);

		inputPanel.add(nameTextField);
		inputPanel.add(raceDateText);
		inputPanel.add(additionalInfoTextArea);

		personalInfoPanel.add(inputPanel, BorderLayout.NORTH);

		// ADDITIONAL INFO PANEL

		// URGENCY OPTIONS
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
		radioPanel.setBorder(new TitledBorder("Urgency Level"));
		radioPanel.setPreferredSize(new Dimension(150, 100));
		radioPanel.add(urgentButton);
		radioPanel.add(moderateButton);
		radioPanel.add(lowButton);

		// EMERGENCY SERVICES OPTION
		JCheckBox police = new JCheckBox("Police");
		JCheckBox ambulance = new JCheckBox("EMS");
		JCheckBox fire = new JCheckBox("Fire");

		List<JCheckBox> emergencyService = new ArrayList<>();
		emergencyService.add(police);
		emergencyService.add(ambulance);
		emergencyService.add(fire);

		police.addActionListener(this);
		ambulance.addActionListener(this);
		fire.addActionListener(this);

		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
		checkPanel.setBorder(new TitledBorder("Emergency Service"));
		checkPanel.setPreferredSize(new Dimension(150, 100));
		checkPanel.add(police);
		checkPanel.add(ambulance);
		checkPanel.add(fire);

		// TYPE OF CRIME PANEL
		String[] crimeStrings = { " ", "Medical Emergency", "Fire", "Car Accident", "Mugging", "Break-in",
				"Domestic Violence", "Death" };
		reasons = new JComboBox<String>(crimeStrings);
		reasons.setSelectedIndex(0);
		reasons.addActionListener(this);

		JPanel comboPanel = new JPanel();
		comboPanel.setBorder(new TitledBorder("Reason for Calling"));
		comboPanel.add(reasons);

		// add to info panel
		infoPanel.add(radioPanel);
		infoPanel.add(checkPanel);
		infoPanel.add(comboPanel);

		// CALL BUTTON PANEL
		callButton = new JButton("Call");
		callButtonPanel.add(callButton);
		callButton.addActionListener(this);

		JPanel mainPanel = new JPanel();
		mainPanel.add(personalInfoPanel, BorderLayout.NORTH);
		mainPanel.add(infoPanel, BorderLayout.SOUTH);
		mainPanel.add(callButtonPanel, BorderLayout.SOUTH);

		infoContainer.add(mainPanel);

	}

	/**
	 * Starts the CallAlert program.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		new CallAlertGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == callButton) {
			try {
				CallAlertModel.getInstance().emergencyCallMugged();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == reasons) {
			CallAlertModel.getInstance().setCrime((String) reasons.getSelectedItem());
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
