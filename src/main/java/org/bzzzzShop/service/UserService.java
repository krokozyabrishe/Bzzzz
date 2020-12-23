package org.bzzzzShop.service;

import org.bzzzzShop.models.customer.Customer;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class UserService {

    private Set<Customer> customerSet = new HashSet<>();
    private Customer activeCustomer;

    public boolean addCustomer(Customer customer) {
        /*Если существует пользователь с таким же логином как у
        * добавляемого, ничего не делаем,
        * иначе
        * регистрируем */
        return customerSet.add(customer);
    }
    public Customer findByLogin(String login) {
        Customer a = null;
        try {
            a = customerSet.stream()
                    .filter(c -> c.getAccount().getLogin().equals(login))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException ignored) { }
        return a;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public Customer getActiveCustomer() {
        return activeCustomer;
    }

    public void setActiveCustomer(Customer activeCustomer) {
        this.activeCustomer = activeCustomer;
    }
}
