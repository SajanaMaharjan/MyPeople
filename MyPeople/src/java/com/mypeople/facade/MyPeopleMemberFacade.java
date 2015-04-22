/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;


import com.mypeople.entity.MyPeopleMember;
import java.lang.reflect.Member;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sajana
 */
@Stateless
public class MyPeopleMemberFacade extends AbstractFacade<MyPeopleMember> implements MyPeopleMemberFacadeLocal {
    @PersistenceContext(unitName = "MyPeoplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyPeopleMemberFacade() {
        super(MyPeopleMember.class);
    }
    
     public MyPeopleMember findByEmail(String email) {
        try {
            if (email == null) {
                email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            }

            String jpql = "SELECT u from Member u where u.email = :email";
            Query query = getEntityManager().createQuery(jpql, Member.class);
            query.setParameter("email", email);
            return (MyPeopleMember) query.getSingleResult();

        } catch (Exception e) {

            Logger.getLogger(MyPeopleMemberFacade.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
