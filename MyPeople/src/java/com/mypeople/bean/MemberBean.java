/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Ashok Subedi
 */
@Named(value = "memberBean")
@SessionScoped
public class MemberBean implements Serializable {

    /**
     * Creates a new instance of MemberBean
     */
    public MemberBean() {
    }
    
}
