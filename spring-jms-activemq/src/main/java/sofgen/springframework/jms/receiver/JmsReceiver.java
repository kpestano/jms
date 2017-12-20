package sofgen.springframework.jms.receiver;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import chienvh.pkg.MyCalculatorsStub;
import sofgen.springframework.jms.controller.Calculator;

/**
 * @author kpestano
 *
 */

@Component
public class JmsReceiver {

	@JmsListener(destination = "SAMPLE-JMS", containerFactory = "myFactory")
	public void receive(Calculator calc) throws RemoteException {
		MyCalculatorsStub stub = null;
		System.err.println("Num1: " + calc.getNum1());
		System.err.println("Num2: " + calc.getNum2());
		try {
			stub = new MyCalculatorsStub();
			MyCalculatorsStub.Add request = new MyCalculatorsStub.Add();
			request.setNum1(calc.getNum1());
			request.setNum2(calc.getNum2());

			MyCalculatorsStub.AddResponse addResponse = stub.add(request);
			System.out.println("Response:" + addResponse.get_return());
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
