package LibraryInventoryconsumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import libraryInventoryproducer.LibraryService;

public class Activator implements BundleActivator {

    ServiceReference serviceReference;

    public void start(BundleContext context) throws Exception {
        System.out.println("Start Library Inventory Service");
        serviceReference = context.getServiceReference(LibraryService.class.getName());
        LibraryService libraryService = (LibraryService) context.getService(serviceReference);

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("<< Enter 'end' to exit >>");
                System.out.println("=========================================");
                System.out.println("======== Book Management Options ========");
                System.out.println("=========================================");
                System.out.println();

                System.out.println("+-------------------------------------------+");
                System.out.println("|  Options:                                 |");
                System.out.println("+-------------------------------------------+");
                System.out.println("|  (a) Add Book                             |");
                System.out.println("|  (l) List Books                           |");
                System.out.println("|  (r) Remove Book                          |");
                System.out.println("|  (end) Exit                               |");
                System.out.println("+-------------------------------------------+");

                System.out.print("Enter choice: ");
                String option = scanner.next();

                if ("end".equalsIgnoreCase(option)) {
                    System.out.println("Exiting Library Inventory Service");
                    break;
                }

                switch (option) {
                    case "a": // Add a new book
                        System.out.print("Enter Book Name: ");
                        String bookName = scanner.next();
                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.next();
                        System.out.print("Enter Book Author: ");
                        String bookAuthor = scanner.next();
                        System.out.print("Enter Book Publisher: ");
                        String bookPublisher = scanner.next();
                        libraryService.addBook(bookName, bookId, bookAuthor, bookPublisher);
                        System.out.println("Book added successfully.");
                        break;
                    case "r": // Remove a book
                        System.out.print("Enter Book ID to remove: ");
                        String removeId = scanner.next();
                        libraryService.removeBook(removeId);
                        break;
                    case "l": // List all books
                        libraryService.printBookList();
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stop Library Inventory Service");
        context.ungetService(serviceReference);
    }
}
