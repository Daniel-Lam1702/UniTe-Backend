package com.project.Project.Post;


import com.project.Project.User.User;

import java.util.List;

public interface PostService {
    public void savePost(Post post) throws Exception;

    //public User findUser(String email, String password) throws Exception;

    boolean setPost(int ctcLinkId, String previousPassword, String newPassword) throws Exception;
}
