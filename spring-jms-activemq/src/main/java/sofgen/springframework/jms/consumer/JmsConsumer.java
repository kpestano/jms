package sofgen.springframework.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author kpestano
 *
 */

@Component
public class JmsConsumer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	@JmsListener(destination= "${jms.queue.destination}", containerFactory = "myFactory")
	@SendTo("jms.received")
	public String receive(String message){
		System.err.println(message);
		return message;
	}
	
	@JmsListener(destination = "jms.received", containerFactory = "myFactory")
	public void receiveMessage(String message) {
		System.err.println("Message received " + message);
	}
}
