/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmanager.test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import jmanager.dal.entity.Contact;
import jmanager.dal.entity.HibernateUtil;
import jmanager.dal.service.ContactServiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author b.dang
 */
public class JManagerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactServiceImpl contactService = new ContactServiceImpl();

        List<String> nameList = new ArrayList<String>();
        nameList.add("A");
        nameList.add("B");
        nameList.add("C");
        nameList.add("D");
        for (int i = 0; i < nameList.size(); i++) {
            Contact contact = new Contact();
            contact.setContactId(i);
            contact.setFirstName(nameList.get(i));
            contact.setLastName(nameList.get(i) + i);
            contact.setEmail(nameList.get(i) + "." + i + "@" + "test.com");

            contactService.addContact(contact);
        }

        List<Contact> contactList = contactService.listContact();

        for (Contact app : contactList) {
            System.out.println(app.getContactId() + " - " + app.getFirstName() + " - " + app.getLastName());
            System.out.println("-------------------");
        }
    }
}
