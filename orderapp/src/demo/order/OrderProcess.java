package demo.order;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService 
public interface OrderProcess {

@WebMethod 
String processOrder(Order order);
}