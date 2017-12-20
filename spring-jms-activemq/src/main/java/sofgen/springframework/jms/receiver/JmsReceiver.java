package sofgen.springframework.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author kpestano
 *
 */

@Component
public class JmsReceiver {
	
	@JmsListener(destination= "SAMPLE-JMS", containerFactory = "myFactory")
	public void receive(String message){
		System.err.println(message);
	}
}
