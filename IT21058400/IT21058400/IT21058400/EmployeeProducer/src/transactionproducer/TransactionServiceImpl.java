// TransactionServiceImpl class
package transactionproducer;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private List<String> transactions;
    private List<String> name;
    private List<String> id;

    public TransactionServiceImpl() {
        this.transactions = new ArrayList<>();
        this.name = new ArrayList<>();
        this.id = new ArrayList<>();
    }

    public void defaultList() {
        // Optionally, initialize default employee list here if needed
    }

    public void addEmp(String eName, String empId) {
        name.add(eName);
        id.add(empId);
    }

    public void removeEmp(String empId) {
        int index = id.indexOf(empId);
        if (index != -1) {
            name.remove(index);
            id.remove(index);
            System.out.println("Employee with ID " + empId + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + empId + " not found.");
        }
    }

    public String loginVerification(String username, String password) {
        if (username.equals("admin") && password.equals("123")) {
            return "admin";
        } else {
            return "invalid";
        }
    }

    public void printEmpList() {
        System.out.println("Employee List:");
        for (int i = 0; i < name.size(); i++) {
            System.out.println("Name: " + name.get(i) + ", ID: " + id.get(i));
        }
    }

    public void processTransaction(String bookId, String fineAmount, String transactionId, String transactionType) {
        // Handle the transaction details as needed
        String transactionDetails = "Book ID: " + bookId + ", Fine Amount: " + fineAmount +
                ", Transaction ID: " + transactionId + ", Transaction Type: " + transactionType;
        transactions.add(transactionDetails);
        System.out.println("Processing Transaction - " + transactionDetails);
    }

    // New method for viewing all transactions
    public void viewAllTransactions() {
        System.out.println("All Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // New method for removing a transaction
    public void removeTransaction(String transactionId) {
        int index = transactions.indexOf(transactionId);
        if (index != -1) {
            transactions.remove(index);
            System.out.println("Transaction with ID " + transactionId + " removed successfully.");
        } else {
            System.out.println("Transaction with ID " + transactionId + " not found.");
        }
    }
}
