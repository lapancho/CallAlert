/**
 * 
 */
package callAlert.model;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import callAlert.User.User;

/**
 * Interacts with form/GUI to make
 * 
 * @author Lagni Pancholi
 *
 */
public class CallAlertModel extends Observable implements Observer {

	private static CallAlertModel instance;

	public ArrayList<User> list;
	
	public String crime; 

	public User currentUser;
	/** Number of users that can be stored in the system */
	private static final int CAPACITY = 10;

	private CallAlertModel() {
		list = new ArrayList<User>(CAPACITY);
	}

	public static CallAlertModel getInstance() {
		if (instance == null) {
			instance = new CallAlertModel();
		}
		return instance;
	}

	public void createNewUser(String firstName, String lastName, int number, int emergencyNum, String password) {
		this.currentUser = new User(firstName, lastName, number, emergencyNum, password);
		list.add(currentUser);
	}

	public User getCurrentUser() {
		return this.currentUser;
	}

	public String getCrime() {
		return this.crime;
	}
	public User login(int number, String password) {
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getNumber() == number && list.get(j).getPassword().equals(password)) {
				currentUser = list.get(j);
				return currentUser;
			}
		}
		return null;
	}

	public boolean logout() {
		if (currentUser != null) {
			currentUser = null;
			return true;
		}
		return false; // not logged in = can't log out
	}


	public void emergencyCallMugged() throws URISyntaxException {
		if(this.getCrime() == "Mugged") {
			MakePhoneCall.runMugged();
		}
		if(this.getCrime() == "Domestic Violence") {
			MakePhoneCall.runDomestic();
		}
		// send type of crime
		// send location
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
