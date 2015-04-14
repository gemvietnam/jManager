/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.common;

import javax.xml.bind.annotation.*;

/**
 *
 * @author b.dang
 */
@XmlRootElement(name = "config")
public class DefaultConfig {

    @XmlElement(name = "hibernate")        
    protected HibernateConfig hibernate;
}
