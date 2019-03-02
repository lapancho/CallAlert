/**
 * 
 */
package callAlert.User;

/**
 * Class holds information about the user
 * @author Lagni Pancholi
 */
public class User {
	
	private String firstName;
	private String lastName;
	private int number;
	private int emergencyNum;
	private String password;
	
	
	// Add location field
	
	/**
	 * Creates a new user 
	 * @param firstName
	 * @param lastName
	 * @param number
	 * @param emergencyNum
	 * @param password
	 */
	public User(String firstName, String lastName, int number, int emergencyNum, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setEmergencyNum(emergencyNum);
		setPassword(password);
	}

	public void setPassword(String password) {
		if (password == null || password.length() == 0) {
			throw new IllegalArgumentException("Invalid password");
		}
		this.password = password;
		
	}

	public void setEmergencyNum(int emergencyNum) {
		if (emergencyNum == 0 || Integer.toString(emergencyNum).length() > 10) {
			throw new IllegalArgumentException("Invalid Emergency Number");
		}
		this.emergencyNum = emergencyNum;
		
	}

	public void setNumber(int number) {
		if (number == 0 || Integer.toString(number).length() > 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.number = number;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() == 0) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
		
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() == 0) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
		
	}

	public int getNumber() {
		return number;
	}

	public String getPassword() {
		return password;
	}
	
}
