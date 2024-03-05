package transactionconsumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import transactionproducer.TransactionService;
import transactionproducer.TransactionServiceImpl;

public class Activator implements BundleActivator {

    ServiceReference serviceReference;

    public void start(BundleContext context) throws Exception {
        System.out.println("Start Supermarket Transaction Service");
        serviceReference = context.getServiceReference(TransactionService.class.getName());
        TransactionService transactionService = (TransactionService) context.getService(serviceReference);

        try {
            String bookId, fineAmount = "0", transactionId, transactionType;
            TransactionService transactionConsumer = new TransactionServiceImpl();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("<< if you want to exit, enter 'end' for Book ID >>");
                System.out.println("================== Transaction Menu =========================");
                System.out.println("1. Add a Transaction");
                System.out.println("2. View all Transactions");
                System.out.println("3. Remove a Transaction");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("================== Add Transaction =========================");
                        System.out.print("Enter Book ID : ");
                        bookId = scanner.next();
                        System.out.print("Enter Transaction ID : ");
                        transactionId = scanner.next();
                        System.out.print("Enter Transaction Type (borrow/return) : ");
                        transactionType = scanner.next();

                        if (transactionType.equals("return")) {
                            System.out.print("Enter Fine Amount : ");
                            fineAmount = scanner.next();
                        }

                        transactionService.processTransaction(bookId, fineAmount, transactionId, transactionType);
                        System.out.println("Transaction added successfully!");
                        break;

                    case 2:
                        System.out.println("================== View all Transactions =========================");
                        transactionService.viewAllTransactions();
                        break;

                    case 3:
                        System.out.println("================== Remove a Transaction =========================");
                        System.out.print("Enter Transaction ID to remove: ");
                        transactionId = scanner.next();
                        transactionService.removeTransaction(transactionId);
                        System.out.println("Transaction removed successfully!");
                        break;

                    case 4:
                        System.out.println("Exiting Transaction Menu");
                        context.ungetService(serviceReference);
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stop Transaction Service");
        context.ungetService(serviceReference);
    }
}
