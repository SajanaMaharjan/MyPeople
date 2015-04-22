/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Member;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sajana
 */
@Local
public interface MemberFacadeLocal {

    void create(Member member);

    void edit(Member member);

    void remove(Member member);

    Member find(Object id);

    List<Member> findAll();

    List<Member> findRange(int[] range);

    int count();
    
}
