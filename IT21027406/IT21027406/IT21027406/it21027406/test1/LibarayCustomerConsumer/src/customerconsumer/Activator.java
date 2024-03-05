package customerconsumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import customerproducer.CustomerService;
import customerproducer.CustomerServiceImpl;

public class Activator implements BundleActivator {

    ServiceReference serviceReference;

    public void start(BundleContext Context) throws Exception {
        System.out.println("Start Supermarket Customer Service");
        serviceReference = Context.getServiceReference(CustomerService.class.getName());
        CustomerService CustomerConsumer = (CustomerService) Context.getService(serviceReference);

        try {
            String username, password, cusName, designation, cusId;
            CustomerService Customerconsumer = new CustomerServiceImpl();
            Customerconsumer.defaultList();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("<< if you want to exit enter 'end' for username >>");
                System.out.println("==================Customer Login =========================");
                System.out.print("Enter UserName : ");
                username = scanner.next();
                if (username.equals("end")) {
                    System.out.println("Customer Adding Created");
                    
                }
                System.out.print("Enter Password : ");
                password = scanner.next();
                System.out.println("======================================\n");
                designation = Customerconsumer.LoginVerification(username, password);
                
                
                
                if (designation.equals("admin")) {
                    System.out.println("~~~~~~~~~~~ Welcome Customer Admin ~~~~~~~~~~~");
                    while (true) {
                        System.out.println("Do you want to view Customer list, Add Customer, Remove Customer");
                        System.out.print(" Add Customer - a / View Customer List - v / Remove Customer - r / Logout - l ");
                        designation = scanner.next();
                        if (designation.equals("v")) {
                            Customerconsumer.printCusList();
                        } else if (designation.equals("l")) {
                            System.out.print("Good bye!\n");
                            System.out.println("=================\n");
                        
                           
                        } else if (designation.equals("r")) {
                            System.out.print("Enter Customer Id For Remove : ");
                            cusId = scanner.next();
                            Customerconsumer.removeCus(cusId);
                            //Customerconsumer.printCusList();
                         
                            
                        } else if (designation.equals("a")) {
                            System.out.print("Enter Customer Name : ");
                            cusName = scanner.next();
                            System.out.print("Enter Customer ID : ");
                            cusId = scanner.next();
                            Customerconsumer.addCus(cusName, cusId);
                            //Customerconsumer.printCusList();
                         
                            
                        } else {
                            System.out.println("Error: Invalid input");
                        }
                    }
                } else {
                    System.out.println("Incorrect login");
                }
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    public void stop(BundleContext Context) throws Exception {
        System.out.println("Stop Customer Adding Service");
        Context.ungetService(serviceReference);
    }
}

