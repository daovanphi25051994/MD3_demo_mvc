package service;

import model.Customer;

import java.util.ArrayList;

public class CustomerServiceImplement implements CustomerService {
  static   ArrayList<Customer> listCustomer = new ArrayList<>();
    static {
        listCustomer.add(new Customer("1", "phi", "phi@gmail.com", "ha noi"));
        listCustomer.add(new Customer("2", "dao", "daovanphi@gmail.com", "hai duong"));
    }
    public CustomerServiceImplement() {
    }

    @Override
    public boolean save(Customer customer) {
        listCustomer.add(customer);
        return true;
    }

    @Override
    public boolean update(String id, Customer customer) {
        for (Customer customer1 : listCustomer) {
            if (customer1.getId().equals(id)) {
                customer1.setId(customer.getId());
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(String id) {
        for (Customer customer : listCustomer) {
            if (customer.getId().equals(id)) {
                listCustomer.remove(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer getCustomerByID(String id) {
        for (Customer customer : listCustomer) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    public ArrayList<Customer> getListCustomer(){
        return listCustomer;
    }
}
