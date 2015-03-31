/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmanager.dal.service;

import java.util.List;
import jmanager.dal.dao.ContactDAO;
import jmanager.dal.dao.ContactDAOImpl;
import jmanager.dal.entity.Contact;

/**
 *
 * @author b.dang
 */
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO = new ContactDAOImpl();

    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    @Override
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

    @Override
    public void updateContact(Contact contact) {
        contactDAO.updateContact(contact);
    }

}
