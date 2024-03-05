package libraryInventoryproducer;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    // Book Attributes
    private List<String> bookNames;
    private List<String> bookIds;
    private List<String> bookAuthors;
    private List<String> bookPublishers;

    public LibraryServiceImpl() {
     
        
        // Initialize lists for book management
        this.bookNames = new ArrayList<>();
        this.bookIds = new ArrayList<>();
        this.bookAuthors = new ArrayList<>();
        this.bookPublishers = new ArrayList<>();
    }
    
    @Override
    public void defaultList() {
        // Initialize with some default books or employees if needed
        // Example initialization of default books (you can adjust or remove according to your needs)
        if (bookNames.isEmpty() && bookIds.isEmpty() && bookAuthors.isEmpty() && bookPublishers.isEmpty()) {
            addBook("Default Book Name", "DefaultBookID", "Default Author", "Default Publisher");
        }

        
        }
    

    
    // Book management methods
    @Override
    public void addBook(String bookName, String bookId, String bookAuthor, String bookPublisher) {
        bookNames.add(bookName);
        bookIds.add(bookId);
        bookAuthors.add(bookAuthor);
        bookPublishers.add(bookPublisher);
        
    }

    @Override
    public void removeBook(String bookId) {
        int index = bookIds.indexOf(bookId);
        if (index != -1) {
            bookNames.remove(index);
            bookIds.remove(index);
            bookAuthors.remove(index);
            bookPublishers.remove(index);
            System.out.println("Book with ID " + bookId + " removed successfully.");
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    @Override
    public void printBookList() {
    	System.out.println(" ========================================================");	
        System.out.println("| Book List:                                              |");
        System.out.println(" ========================================================");
        
        for (int i = 0; i < bookNames.size(); i++) { 	
            System.out.println("  Name: " + bookNames.get(i) + ", ID: " + bookIds.get(i) +
                               ", Author: " + bookAuthors.get(i) + ", Publisher: " + bookPublishers.get(i));
            System.out.println(" ========================================================");
            
        }
        
    }

    
}
