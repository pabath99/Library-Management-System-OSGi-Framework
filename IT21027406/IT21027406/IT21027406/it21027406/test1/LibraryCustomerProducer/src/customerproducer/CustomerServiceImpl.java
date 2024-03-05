package customerproducer;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
    
    private ArrayList<String> name;
    private ArrayList<String> id;
    
    public CustomerServiceImpl() {
        this.name = new ArrayList<>();
        this.id = new ArrayList<>();
    }
    
    public void defaultList() {
        // Optionally, initialize default customer list here if needed
    }

    public void addCus(String cusName, String cusId) {
        name.add(cusName);
        id.add(cusId);
    }

    public void removeCus(String cusId) {
        int index = id.indexOf(cusId);
        if (index != -1) {
            name.remove(index);
            id.remove(index);
            System.out.println("Customer " + cusId + " removed successfully.");
        } else {
            System.out.println("Customer ID " + cusId + " not found.");
        }
    }

    public String LoginVerification(String username, String password) {
        if (username.equals("CusAdmin") && password.equals("Cus123")) {
            return "admin";
        } else {
            return "invalid";
        }
    }

    public void printCusList() {
        System.out.println("Customer List:");
        for (int i = 0; i < name.size(); i++) {
            System.out.println("Name: " + name.get(i) + ", ID: " + id.get(i));
        }
    }
}
