package service;

import model.Customer;

import java.util.ArrayList;

public interface CustomerService {
    public boolean save(Customer customer);
    public boolean update(String id, Customer customer);
    public boolean remove(String id);
    public Customer getCustomerByID(String id);
    public ArrayList<Customer> getListCustomer();
}
