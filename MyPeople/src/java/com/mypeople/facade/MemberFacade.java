/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Member;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
