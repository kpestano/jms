package sofgen.springframework.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpestano
 *
 */

@RestController
public class WebController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@PostMapping(value="/message")
	public String send(@RequestBody Calculator cal){
		System.err.println("Sending");
		jmsTemplate.convertAndSend("SAMPLE-JMS", cal);
		return "Done";
	}
}
