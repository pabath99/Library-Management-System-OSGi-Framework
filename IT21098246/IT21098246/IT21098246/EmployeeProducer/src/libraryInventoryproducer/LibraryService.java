package libraryInventoryproducer;

public interface LibraryService {
    // Method to initialize default list (if necessary)
    void defaultList();


    // Book management methods
    void addBook(String bookName, String bookId, String bookAuthor, String bookPublisher);
    void removeBook(String bookId);
    void printBookList();

    
}
