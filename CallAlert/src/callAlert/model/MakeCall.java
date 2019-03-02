/**
 * 
 */
package callAlert.model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Makes the call
 * @author Lagni Pancholi
 */
public class MakeCall {
    public static final String ACCOUNT_SID = "AC1ea99dd078ee08edb0b046d7de8f62c0";
    public static final String AUTH_TOKEN = "7dda1d807ccdb1b9e1a5c267bccfdb77";

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Call call = Call.creator(
                new com.twilio.type.PhoneNumber("+15017122661"),
                new com.twilio.type.PhoneNumber("+9196073378"),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
            .create();
    }
}
