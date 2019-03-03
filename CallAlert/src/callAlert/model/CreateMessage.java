package callAlert.model;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.TwiMLException;

/**
 * 
 * @author Lagni Pancholi
 *
 */
public class CreateMessage {
	
	public CreateMessage() {
		
	}
    public static void main(String[] args) {
        Say say = new Say.Builder("Hello World").build();
        VoiceResponse response = new VoiceResponse.Builder().say(say).build();

        System.out.println(response.toXml());
    }
}
