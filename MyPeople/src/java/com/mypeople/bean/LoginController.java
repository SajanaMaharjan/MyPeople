/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.MyPeopleMember;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ashok Subedi
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController {
    
    private MyPeopleMember member;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public void logout() throws IOException {
        member = null;
        
        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        hsr.getSession().invalidate();
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/faces/" + "index.xhtml");
        
        
//        String result="/index?faces-redirect=true";
     
//    FacesContext context = FacesContext.getCurrentInstance();
//    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
//     
//    try {
//      request.logout();
//    } catch (ServletException e) {
//      log.log(Level.SEVERE, "Failed to logout user!", e);
//      result = "/loginError?faces-redirect=true";
//    }
//     
//    return result;

    }
    
}
