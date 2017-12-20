package sofgen.springframework.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author kpestano
 *
 */

@Component
public class JmsSender {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String msg){
		jmsTemplate.convertAndSend("SAMPLE-JMS", msg);
	}
}