/**
 * 
 */
package callAlert.model;

import java.util.ArrayList;

import callAlert.User.User;

/**
 * Interacts with form/GUI to make
 * 
 * @author Lagni Pancholi
 *
 */
public class CallAlertModel {

	private static CallAlertModel instance;

	public ArrayList<User> list;

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

	public void emergencyCall() {
		// Make call
		// send type of crime
		// send location
	}
}
