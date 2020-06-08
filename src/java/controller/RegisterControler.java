package controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import dao.RegisterDao;

/**
 *
 * @author Umut
 */

@Named
@javax.enterprise.context.SessionScoped

public class RegisterControler implements Serializable {

   
    private String uname;
    private String password;
    private String userTuru;
     private RegisterDao registerDao;
     
    

    public String create() {
        
        this.getRegisterDao().insert(this.uname, this.password, this.userTuru);
        this.uname = null;
        this.password = null;
        
        return "login";
    }

    public RegisterControler() {
        this.uname = "";
        this.password = "";
       
    }

    public RegisterControler( String uname, String password, String userTuru) {
        
        this.uname = uname;
        this.password = password;
        this.userTuru = userTuru;
    }
    

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserTuru() {
        return userTuru;
    }

    public void setUserTuru(String userTuru) {
        this.userTuru = userTuru;
    }

    public RegisterDao getRegisterDao() {
        return registerDao;
    }
}
