package callAlert.model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class RecieveText {
  // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC1ea99dd078ee08edb0b046d7de8f62c0";
    public static final String AUTH_TOKEN = "7dda1d807ccdb1b9e1a5c267bccfdb77";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+19196073378"),
        new PhoneNumber("+19193720966"), 
        "").create();

  }
}
