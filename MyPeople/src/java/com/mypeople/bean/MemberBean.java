/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.facade.MemberFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Ashok Subedi
 */
@Named(value = "memberBean")
@SessionScoped
public class MemberBean implements Serializable {
    @EJB
    private MemberFacade memberFacade;
    
    

    /**
     * Creates a new instance of MemberBean
     */
    public MemberBean() {
    }
    
}
