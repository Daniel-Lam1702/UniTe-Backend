package com.project.Project.Post;

import com.project.Project.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId; //post id and the poster will never change :3
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "poster_id_user_id")
    private User posterId;

    public User getPosterId() {
        return posterId;
    }

    public void setPosterId(User posterId) {
        this.posterId = posterId;
    }

    public Post(String title, String content, int postId){
        this.title = title;
        this.content = content;
        this.postId =  postId;
    }

    public Post() {

    }

    public String getContent(){
        return content;
    }

    public String getTitle(){
        return title;
    }
    public int getPostId(){
        return postId;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void setContent(String newContent){
        content = newContent;
    }

}
