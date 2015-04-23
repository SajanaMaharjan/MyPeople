/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.DiscussionComment;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author rejina
 */
@Local
public interface DiscussionCommentFacadeLocal {
    
    void create(DiscussionComment eventComment);

    void edit(DiscussionComment eventComment);

    void remove(DiscussionComment eventComment);

    DiscussionComment find(Object id);

    List<DiscussionComment> findAll();

    List<DiscussionComment> findRange(int[] range);
    
    int count();
        List<DiscussionComment> getCommentOfDiscussion(Long discussionId);

}
