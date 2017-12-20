package sofgen.springframework.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sofgen.springframework.jms.client.JmsClient;

/**
 * @author kpestano
 *
 */

@RestController
public class WebController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	@Autowired
	JmsClient jmsClient;
	
	@RequestMapping(value="/message")
	public String send(@RequestParam("msg") String msg){
		System.err.println("Sending");
		jmsClient.send(msg);
		return "Done";
	}
}
