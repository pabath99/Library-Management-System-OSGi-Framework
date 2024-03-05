// TransactionService interface
package transactionproducer;

import java.util.List;

public interface TransactionService {
    void defaultList();
    void printEmpList();
    String loginVerification(String username, String password);
    void addEmp(String eName, String empId);
    void removeEmp(String empId);

    // New method for processing transactions
    void processTransaction(String bookId, String fineAmount, String transactionId, String transactionType);

    // New methods for viewing and removing transactions
    void viewAllTransactions();
    void removeTransaction(String transactionId);
}
