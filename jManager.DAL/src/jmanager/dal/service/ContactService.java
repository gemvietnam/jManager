/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmanager.dal.service;

import java.util.List;
import jmanager.dal.entity.Contact;

/**
 *
 * @author b.dang
 */
public interface ContactService {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);

    public void updateContact(Contact contact);
}
