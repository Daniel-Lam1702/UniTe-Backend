package com.project.Project.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user) throws Exception;

    public User findUser(String username, String password) throws Exception;

    boolean setPassword(int ctcLinkId, String previousPassword, String newPassword) throws Exception;
}
