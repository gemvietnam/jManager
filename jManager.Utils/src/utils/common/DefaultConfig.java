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

    @XmlType(name = "hibernate")
    @XmlAccessorType(XmlAccessType.PROPERTY)
    public class Hibernate {

        @XmlElement(name = "driver", required = true)
        protected String driver;

        @XmlElement(name = "url", required = true)
        protected String url;

        @XmlElement(name = "username", required = true)
        protected String username;

        @XmlElement(name = "password", required = true)
        protected String password;

        @XmlElement(name = "showsql", required = true)
        protected String showsql;

        @XmlElement(name = "dialect", required = true)
        protected String dialect;

        @XmlElement(name = "auto", required = true)
        protected String auto;

        @XmlElement(name = "provider", required = true)
        protected String provider;

        @XmlElement(name = "session", required = true)
        protected String session;

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getShowsql() {
            return showsql;
        }

        public void setShowsql(String showsql) {
            this.showsql = showsql;
        }

        public String getDialect() {
            return dialect;
        }

        public void setDialect(String dialect) {
            this.dialect = dialect;
        }

        public String getAuto() {
            return auto;
        }

        public void setAuto(String auto) {
            this.auto = auto;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }
    }
}
