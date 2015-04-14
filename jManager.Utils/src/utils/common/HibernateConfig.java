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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HibernateConfig {

    protected String driver;

    protected String url;

    protected String username;

    protected String password;

    protected String showsql;

    protected String dialect;

    protected String auto;

    protected String provider;

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
