package sofgen.springframework.jms.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sofgen.springframework.jms.client.JmsClient;
import sofgen.springframework.jms.consumer.JmsConsumer;
import sofgen.springframework.jms.producer.JmsProducer;

/**
 * @author kpestano
 *
 */

@Service
public class JmsClientImpl implements JmsClient{

	@Autowired
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

}
