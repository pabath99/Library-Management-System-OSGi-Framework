package Libraryemployeeconsumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import Libraryemployeeproducer.LibraryEmployeeService;
import Libraryemployeeproducer.LibraryEmployeeServiceImpl;

public class Activator implements BundleActivator {

    ServiceReference serviceReference;
    
    
    // Activator start method
    public void start(BundleContext Context) throws Exception {
    	System.out.println("Initializing Library Employee Service");
    	
    	// Obtain a reference to the LibraryEmployeeService
        serviceReference = Context.getServiceReference(LibraryEmployeeService.class.getName());
        LibraryEmployeeService EmployeeConsumer = (LibraryEmployeeService) Context.getService(serviceReference);

        try {
        	// Input variables
            String username, password, eName, designation, empId;
            
            // Instantiate a new LibraryEmployeeServiceImpl
            LibraryEmployeeService employeeconsumer = new LibraryEmployeeServiceImpl();
            // Display default employee list
            employeeconsumer.defaultList();
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
            	System.out.println("To exit, type 'end' as the username.");
                System.out.println("================== Library Login =========================");
                System.out.print("Enter UserName : ");
                username = scanner.next();
                
                // Exit loop if 'end' is entered as the username
                if (username.equals("end")) {
                    System.out.println("Employee Adding Created");
                    break;
                }
                System.out.print("Enter Admin Password : ");
                password = scanner.next();
                System.out.println("======================================\n");
                
                // Verify login credentials
                designation = employeeconsumer.LoginVerification(username, password);
                if (designation.equals("admin")) {
                	System.out.println("Welcome, Administrator! You have access to administrative functions.");
                    while (true) {
                        System.out.println("Do you want to view Employee list, Add Employee, Remove Employee, or Logout?");
                        System.out.println("======================================\n");
                        System.out.print("Choose an action: View Employee List (V), Add Employee (A), Remove Employee (R), or Logout (logout) = ");
                        designation = scanner.next();
                        
                        if (designation.equals("V")) {
                        	// Display employee list
                            employeeconsumer.printEmpList();
                        } else if (designation.equals("A")) {
                        	// Add new employee
                        	System.out.print("Provide the Employee's Name: ");
                            eName = scanner.next();
                            System.out.print("Provide the Employee ID: ");
                            empId = scanner.next();
                            employeeconsumer.addEmp(eName, empId);
                            employeeconsumer.printEmpList();
                        } else if (designation.equals("R")) {
                        	// Remove employee
                        	System.out.print("Provide the Employee ID for Removal: ");
                            empId = scanner.next();
                            employeeconsumer.removeEmp(empId);
                            employeeconsumer.printEmpList();
                        } else if (designation.equals("logout")) {
                        	// Logout
                        	System.out.print("Have a great day!\n");
                            System.out.println("=================\n");
                            break;
                        } else {
                        	System.out.println("Oops! Something went wrong. Please enter a valid input.");
                        }
                    }
                } else {
                	System.out.println("Invalid login credentials. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Activator stop method
    public void stop(BundleContext Context) throws Exception {
    	System.out.println("Stopping Employee Addition Service");
        Context.ungetService(serviceReference);
    }
}

