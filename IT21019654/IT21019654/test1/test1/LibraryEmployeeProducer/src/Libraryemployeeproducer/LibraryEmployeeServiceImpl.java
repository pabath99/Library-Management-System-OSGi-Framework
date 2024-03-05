package Libraryemployeeproducer;

import java.util.ArrayList;

public class LibraryEmployeeServiceImpl implements LibraryEmployeeService {
    
    private ArrayList<String> name;
    private ArrayList<String> id;
    
    public LibraryEmployeeServiceImpl() {
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
        // Find the index of the employee with the specified ID
        int index = id.indexOf(empId);

        // Check if the employee with the given ID exists
        if (index != -1) {
            // Remove the employee's name and ID from the lists at the found index
            name.remove(index);
            id.remove(index);

            // Display success message
            System.out.println("Employee with ID " + empId + " has been successfully removed.");
        } else {
            // Display a message if the employee with the specified ID is not found
        	System.out.println("Employee with ID " + empId + " was not found in the records.");
        }
    }

    public String LoginVerification(String username, String password) {
        // Check if the provided username and password match the admin credentials
        if (username.equals("admin") && password.equals("123")) {
            // Return "admin" to indicate successful admin login
            return "admin";
        } else {
            // Return "invalid" to indicate unsuccessful login
            return "invalid";
        }
    }

    public void printEmpList() {
        // Display the Employee List
        System.out.println("Employee List:");

        // Iterate through the lists of names and IDs
        for (int i = 0; i < name.size(); i++) {
            // Print each employee's name and ID
            System.out.println("Name: " + name.get(i) + ", ID: " + id.get(i));
        }
    }

}
