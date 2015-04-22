/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.MyPeopleMember;
import com.mypeople.facade.MyPeopleMemberFacade;
import com.mypeople.facade.MyPeopleMemberFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sajana
 */
@Named(value = "memberController")
@SessionScoped
public class MemberController implements Serializable{
   @EJB
    MyPeopleMemberFacadeLocal mpMemberFacade;
    private MyPeopleMember mpMember;
    

    /**
     * Creates a new instance of MemberBean
     */
    public MemberController() {
        mpMember = new MyPeopleMember();
        mpMemberFacade = new MyPeopleMemberFacade();
    }

    public void addMember(){
        mpMemberFacade.create(mpMember);
    }

    public MyPeopleMember getMpMember() {
        return mpMember;
    }

    public void setMpMember(MyPeopleMember mpMember) {
        this.mpMember = mpMember;
    }
   

     
}
