package callAlert.model;

//Install the Java helper library from twilio.com/docs/libraries/java
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;


public class MakePhoneCall {

	public static final String ACCOUNT_SID = "AC1ea99dd078ee08edb0b046d7de8f62c0";
	public static final String AUTH_TOKEN = "7dda1d807ccdb1b9e1a5c267bccfdb77";

	public static void runBreakIn() throws URISyntaxException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		String from = "+19193720966";
		String to = "+19196073378";
     
	 // Hello, Varsha Gopal is reporting a break in at North Carolina State University. This is ugrent request for police.
     Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
             new URI("https://handler.twilio.com/twiml/EHef719ef6e2dddb923dd41ad2396c5163")).create();
    		 		
	}
	
	public static void runDomestic() throws URISyntaxException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		String from = "+19193720966";
		String to = "+19196073378";
		
		//Hello, Jenny Smith is suffering from domestic violence at 123 Random Street, Cary, NC. This is a urgent request for ems. 
	    Call call2 = Call.creator(new PhoneNumber(to), new PhoneNumber(from), 
	    		 new URI("https://handler.twilio.com/twiml/EHf54eca1ee0381770a4c522b6f79e8225")).create();
	}

}
