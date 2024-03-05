package libraryInventoryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    ServiceRegistration publishServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Library Inventory Service Starting");
        LibraryService libraryService = new LibraryServiceImpl();
        // Registering the library service
        publishServiceRegistration = context.registerService(
                LibraryService.class.getName(), libraryService, null);
        System.out.println("Library Inventory Service successfully registered");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Library Inventory Service Stopping");
        // Unregistering the library service
        publishServiceRegistration.unregister();
        System.out.println("Library Inventory Service successfully stopped");
    }
}
