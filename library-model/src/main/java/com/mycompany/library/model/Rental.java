/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

/**
 *
 * @author dawid
 */
public class Rental {
    private Item item;
    private Customer customer;

    public Rental(Item item, Customer customer) {
        setItem(item);
        setCustomer(customer);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Pozycja nie może być null.");
        }
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Klient nie może być null.");
        }
        this.customer = customer;
    }
}