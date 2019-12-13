package com.lschulze.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfistws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOderWsImplPort = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOderWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Número de orders: " + orders.size());

	}

}
