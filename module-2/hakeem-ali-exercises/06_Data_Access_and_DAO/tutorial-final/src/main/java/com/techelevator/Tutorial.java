package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.JdbcCustomerDao;
import com.techelevator.dao.JdbcSaleDao;
import com.techelevator.dao.SaleDao;
import com.techelevator.model.Customer;
import com.techelevator.model.Sale;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;

public class Tutorial {

    private SaleDao saleDao;
    private CustomerDao customerDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/PizzaShop");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        Tutorial tutorial = new Tutorial(dataSource);
        tutorial.run();
    }

    public Tutorial(DataSource dataSource) {
        saleDao = new JdbcSaleDao(dataSource);
        customerDao = new JdbcCustomerDao(dataSource);
    }

    private void run() {
        System.out.println("Total Sales: $" + saleDao.getTotalSales());

        Sale sale50 = saleDao.getSale(50);
        System.out.println(sale50);

        Customer customerForSale50 = customerDao.getCustomer(sale50.getCustomerId());
        System.out.println("Customer for that sale was " + customerForSale50);

        List<Customer> matchingCustomers = customerDao.findCustomersByName("Ma");
        System.out.println("All customers with \"Ma\" in their first or last name:");
        for (Customer customer : matchingCustomers) {
            System.out.println(customer);
        }

    }
}
