/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmanager.dal.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utils.common.ApplicationConstants;

/**
 *
 * @author b.dang
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration config = getConfiguration();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    config.getProperties()).build();
            config.setSessionFactoryObserver(new SessionFactoryObserver() {
                private static final long serialVersionUID = 1L;

                @Override
                public void sessionFactoryCreated(SessionFactory factory) {
                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    StandardServiceRegistryBuilder.destroy(serviceRegistry);
                }
            });
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    private static Configuration getConfiguration() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Contact.class);
        cfg.setProperty("hibernate.connection.driver_class", ApplicationConstants.DatabaseConfig.Driver.GetValue());
        cfg.setProperty("hibernate.connection.url", ApplicationConstants.DatabaseConfig.URL.GetValue());
        cfg.setProperty("hibernate.connection.username", ApplicationConstants.DatabaseConfig.UserName.GetValue());
        cfg.setProperty("hibernate.connection.password", ApplicationConstants.DatabaseConfig.Password.GetValue());
        cfg.setProperty("hibernate.show_sql", ApplicationConstants.DatabaseConfig.ShowSQL.GetValue());
        cfg.setProperty("hibernate.dialect", ApplicationConstants.DatabaseConfig.Dialect.GetValue());
        cfg.setProperty("hibernate.hbm2ddl.auto", ApplicationConstants.DatabaseConfig.Auto.GetValue());
        cfg.setProperty("hibernate.cache.provider_class", ApplicationConstants.DatabaseConfig.Provider.GetValue());
        cfg.setProperty("hibernate.current_session_context_class", ApplicationConstants.DatabaseConfig.Session.GetValue());
        return cfg;
    }
}
