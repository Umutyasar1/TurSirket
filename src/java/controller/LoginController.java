package controller;

import dao.LoginDao;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Umut
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

     private User user;
    private LoginDao userdao;

    public LoginDao getUserdao() {
        if (this.userdao == null) {
            this.userdao = new LoginDao();
        }
        return userdao;
    }

    public void setUserdao(LoginDao userdao) {
        this.userdao = userdao;
    }

    public String login() {
        User tmp = getUserdao().validate(getUser().getUsername());
        if (tmp != null && tmp.getPassword().equalsIgnoreCase(getUser().getPassword())) {

            setUser(tmp);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);

            if (tmp != null && tmp.getUturu().equals("Admin")) {

                return "/secret/secret?faces-redirect=true";

            } else {
              return "/Users/View?faces-redirect=true";
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre girdiniz tekrar deneyiniz "));
            setUser(null);
            return "login.xhtml";
        }

    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
