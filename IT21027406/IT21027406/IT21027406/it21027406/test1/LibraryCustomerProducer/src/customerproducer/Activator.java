package customerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import customerproducer.CustomerService;
import customerproducer.CustomerServiceImpl;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	

	public void start(BundleContext Context) throws Exception {
		System.out.println("Customer Adding Start");
		CustomerService empservice = new CustomerServiceImpl();
		publishServiceRegistration = Context.registerService(
				CustomerService.class.getName(), empservice, null);
	}
	
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Customer Adding Stop");
		publishServiceRegistration.unregister();
	}

}
