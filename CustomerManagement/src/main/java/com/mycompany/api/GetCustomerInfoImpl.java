/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import com.mycompany.model.*;
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
public class GetCustomerInfoImpl {
    
    List<Customer> myList = new ArrayList();
    
    public GetCustomerInfoImpl() {
        Customer c1 = new Customer();
        Address a1 = new Address();
        a1.setAddrLine1("aaa");
        a1.setAddrLine2("bbb");
        c1.setId(1);
        c1.setName("Chinmayee");
        c1.setAddress(a1);
        
        Customer c2 = new Customer();
        Address a2 = new Address();
        a2.setAddrLine1("ccc");
        a2.setAddrLine2("ddd");
        c2.setId(2);
        c2.setName("Sunanda");
        c2.setAddress(a2);
        
        myList.add(c1);
        myList.add(c2);
    }
    
    @RequestMapping(value = "/CustomerManagement/api/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return myList;
    }
    
    @RequestMapping(value = "/CustomerManagement/api/getCustById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Customer getCustomerById(@PathVariable("custId") final int id) {
        Customer cust = null;
        for (Customer c : myList) {
           if(c.getId() == id)
               cust = c;
        }
        return cust;
    }
    
    
    
}
