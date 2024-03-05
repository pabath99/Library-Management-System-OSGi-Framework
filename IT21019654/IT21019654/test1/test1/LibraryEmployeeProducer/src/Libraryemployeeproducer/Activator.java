package Libraryemployeeproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import Libraryemployeeproducer.LibraryEmployeeService;
import Libraryemployeeproducer.LibraryEmployeeServiceImpl;

public class Activator implements BundleActivator {

	// Service registration reference
	ServiceRegistration publishServiceRegistration;

	// Activator start method
	public void start(BundleContext Context) throws Exception {
		System.out.println("Initializing Employee Addition");
		
		// Create an instance of LibraryEmployeeServiceImpl
		LibraryEmployeeService empservice = new LibraryEmployeeServiceImpl();
		
		// Register the EmployeeService in the OSGi framework
		publishServiceRegistration = Context.registerService(
				LibraryEmployeeService.class.getName(), empservice, null);
	}
	
	// Activator stop method
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Employee Addition");
		
		// Unregister the LibraryEmployeeService when stopping the bundle
		publishServiceRegistration.unregister();
	}

}
