/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.Member;
import com.mypeople.facade.MemberFacade;
import com.mypeople.facade.MemberFacadeLocal;
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
    private MemberFacadeLocal memberFacade;
    private Member member;
    

    /**
     * Creates a new instance of MemberBean
     */
    public MemberController() {
        member = new Member();
        memberFacade = new MemberFacade();
    }

    public void addMember(){
        memberFacade.create(member);
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

     
}
