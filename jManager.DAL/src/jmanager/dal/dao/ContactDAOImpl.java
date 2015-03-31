/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmanager.dal.dao;

import java.util.ArrayList;
import java.util.List;
import jmanager.dal.entity.Contact;
import jmanager.dal.entity.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author b.dang
 */
public class ContactDAOImpl implements ContactDAO {

    @Override
    public void addContact(Contact contact) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(contact);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Contact> listContact() {
        List<Contact> list = new ArrayList<>();
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        list = s.createQuery("from Contact").list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @Override
    public void removeContact(Integer id) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Contact c = (Contact) s.load(Contact.class, id);
        s.delete(c);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateContact(Contact contact) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(contact);
        s.getTransaction().commit();
        s.close();
    }
}
