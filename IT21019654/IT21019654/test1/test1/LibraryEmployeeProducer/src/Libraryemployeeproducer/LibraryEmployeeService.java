package Libraryemployeeproducer;

public interface LibraryEmployeeService {
	public void defaultList();
	public void printEmpList();
	public String LoginVerification(String username,String password);
	public void addEmp(String eName, String empId); //eName, empId
	public void removeEmp(String empId);
	
}
