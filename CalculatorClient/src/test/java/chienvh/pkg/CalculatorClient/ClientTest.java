package chienvh.pkg.CalculatorClient;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.junit.Assert;
import org.junit.Test;

import chienvh.pkg.MyCalculatorsStub;

public class ClientTest {

	
	@Test
	public void addTest() throws RemoteException {
		MyCalculatorsStub stub=null;
		
		try {
			stub = new MyCalculatorsStub();
			MyCalculatorsStub.Add request = new MyCalculatorsStub.Add();
			request.setNum1(450);
			request.setNum2(111);
			
			MyCalculatorsStub.AddResponse addResponse = stub.add(request);
			System.out.println("Response:" + addResponse.get_return());
		}catch(AxisFault e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertNotNull(stub);
		
	}
}
