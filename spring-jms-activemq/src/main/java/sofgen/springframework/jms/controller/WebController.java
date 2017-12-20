package sofgen.springframework.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpestano
 *
 */

@RestController
public class WebController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@GetMapping(value="/message")
	public String send(@RequestParam("msg") String msg){
		System.err.println("Sending");
		jmsTemplate.convertAndSend("SAMPLE-JMS", msg);
		return "Done";
	}
}
