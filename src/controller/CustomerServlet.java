package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImplement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeRegExp.test;

@WebServlet(name = "CustomerServlet", urlPatterns = "/list_customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String action =  request.getParameter("action");
          if (action == null){
              action = "";
          }
          switch (action){
              case "test" : test(request, response);
//              default: showListCustomer(request, response);
          }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerServiceImplement();
         ArrayList<Customer> listCustomer = customerService.getListCustomer();
         request.setAttribute("listCustomer", listCustomer);
         request.getRequestDispatcher("/jsp/listCustomer.jsp").forward(request, response);
    }
    private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerServiceImplement();
        ArrayList<Customer> listCustomer = customerService.getListCustomer();
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("/jsp/listCustomer.jsp").forward(request, response);
    }
}
