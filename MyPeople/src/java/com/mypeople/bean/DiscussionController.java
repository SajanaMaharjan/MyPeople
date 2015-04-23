/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.Discussion;
import com.mypeople.entity.DiscussionComment;
import com.mypeople.facade.DiscussionCommentFacadeLocal;
import com.mypeople.facade.DiscussionFacade;
import com.mypeople.facade.DiscussionFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.stream.events.Comment;

/**
 *
 * @author rejina
 */

/**
 *
 * @author rejina
 */
@ManagedBean(name = "discussionController")
@ViewScoped
public class DiscussionController implements Serializable {

    private Discussion discussion;
    private List<Discussion> discussionList;
    
    private DiscussionComment discussionComment;
    private List<DiscussionComment> commentList;
   
    
    @EJB
    private final DiscussionFacadeLocal discussionService;
    
    @EJB
    private DiscussionCommentFacadeLocal commentservice;
        
    @PostConstruct
    public void initEvents() {
        discussionList = discussionService.findAll();
    }
    public DiscussionController() {
        discussion = new Discussion();
        discussionComment = new DiscussionComment();
        discussionService = new DiscussionFacade();
        discussionList = new ArrayList<>();
        commentList = new ArrayList<>();
    }
    
    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
    }

    public DiscussionComment getDiscussionComment() {
        return discussionComment;
    }

    public void setDiscussionComment(DiscussionComment comment) {
        this.discussionComment = comment;
    }

    public List<DiscussionComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<DiscussionComment> commentList) {
        this.commentList = commentList;
    }
    


    public void viewDiscussionDetail(Long id) throws IOException{
        Discussion d = discussionService.find(id);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/discussionDetailPage.faces?discussionId=" + d.getId());
    }
    
     
    public String addDiscussion(){        
        discussionService.create(discussion);
        return "discussionDetails.jsf";
    }
    
    public List<DiscussionComment> commentListList(){
        return commentList;
    }
    
     public void preRenderView(String discussionId) {
         System.out.println("dis "+discussionId);
        if (!(discussionId.equalsIgnoreCase(""))) {
            discussion = discussionService.find(Long.parseLong(discussionId));
            System.out.println("dis "+discussion);
            commentList = discussion.getComments();
        }
        
         System.out.println("comme +++ "+commentList);
    }
    
    public void postDiscussion() throws IOException{
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Discussion provider = discussionService.find(Long.parseLong(params.get("discussionId")));
        
        
        discussionComment.setDiscussion(provider);
        
        

        Date curDate = new Date();

        discussionComment.setCreationDate(curDate);
//        commentservice.create(discussionComment);
//        provider.addComments(discussionComment);
        
        provider.addComments(discussionComment);
        discussionService.edit(provider);
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/discussionDetailPage.faces?discussionId=" + provider.getId()); 
       
    }
}
