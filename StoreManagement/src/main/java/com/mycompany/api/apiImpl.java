/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import com.mycompany.entity.Item;
import com.mycompany.entity.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author chinmayee
 */
public class apiImpl {

    List<Item> items = new ArrayList();
    List<Order> orders = new ArrayList();

    public apiImpl() {
        Item i1 = new Item();
        i1.setId(1);
        i1.setName("Bag");

        Item i2 = new Item();
        i2.setId(2);
        i2.setName("Bottle");

        items.add(i1);
        items.add(i2);

        Order o1 = new Order();
        o1.setId(1);
        o1.setCustomerId(1);
        o1.setItem(i1);
        o1.setQty(10);

        Order o2 = new Order();
        o2.setId(2);
        o2.setCustomerId(2);
        o2.setItem(i2);
        o2.setQty(15);

        orders.add(o1);
        orders.add(o2);
    }

    @RequestMapping(value = "/StoreManagement/api/getItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Item getItemByID(@PathVariable("itemId") final int id) {
        Item i = null;
        for (Item it : items) {
            if (it.getId() == id) {
                i = it;
            }
        }
        return i;
    }

    @RequestMapping(value = "/StoreManagement/api/getOrderByCustomer/{custId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Order> getOrderByCustomer(@PathVariable("custId") final int custId) {
        List<Order> orderList = new ArrayList();
        for (Order o : orders) {
            if (o.getCustomerId() == custId) {
                orderList.add(o);
            }
        }
        return orderList;
    }
}
