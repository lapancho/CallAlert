/**
 * 
 */
package callAlert.model;

import callAlert.User.User;


/**
 * Interacts with form/GUI to make
 * @author Lagni Pancholi
 *
 */
public class CallAlertModel {

	private static CallAlertModel instance;
	public User newUser;
	
	private CallAlertModel() {
		
	}
	
	public static CallAlertModel getInstance() {
		if (instance == null) {
			instance = new CallAlertModel();
		}
		return instance;
	}
	
	public void createNewUser(String firstName, String lastName, int number, int emergencyNum, String password) {
		this.newUser = new User(firstName, lastName, number, emergencyNum, password);
	}
	
	public User getUser() {
		return this.newUser;
	}
	
	public void emergencyCall() {
		//Make call
		//send type of crime
		//send location
	}
}
