package callAlert.model;

//Install the Java helper library from twilio.com/docs/libraries/java
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.TwiMLException;

public class MakePhoneCall {

	public static final String ACCOUNT_SID = "AC1ea99dd078ee08edb0b046d7de8f62c0";
	public static final String AUTH_TOKEN = "7dda1d807ccdb1b9e1a5c267bccfdb77";

	public static void run() throws URISyntaxException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		String from = "+19193720966";
		String to = "+19196073378";

		Call call = Call
				.creator(new PhoneNumber(to), new PhoneNumber(from), new URI("http://demo.twilio.com/docs/voice.xml"))
				.create();
	}
}
