package customerproducer;

public interface CustomerService {
	public void defaultList();
	public void printCusList();
	public String LoginVerification(String username,String password);
	public void addCus(String cusName, String cusId); //customer name, customer ID
	public void removeCus(String cusId);
	
}
