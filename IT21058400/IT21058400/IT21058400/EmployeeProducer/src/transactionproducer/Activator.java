package transactionproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    ServiceRegistration publishServiceRegistration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Transaction Service Start");
        TransactionService transactionService = new TransactionServiceImpl();
        publishServiceRegistration = context.registerService(
                TransactionService.class.getName(), transactionService, null);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Transaction Service Stop");
        publishServiceRegistration.unregister();
    }

}
