/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Member;
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
public class MemberFacade extends AbstractFacade<Member> implements MemberFacadeLocal {
    @PersistenceContext(unitName = "MyPeoplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemberFacade() {
        super(Member.class);
    }
    
     public Member findByEmail(String email) {
        try {
            if (email == null) {
                email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            }

            String jpql = "SELECT u from Member u where u.email = :email";
            Query query = getEntityManager().createQuery(jpql, Member.class);
            query.setParameter("email", email);
            return (Member) query.getSingleResult();

        } catch (Exception e) {

            Logger.getLogger(MemberFacade.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
