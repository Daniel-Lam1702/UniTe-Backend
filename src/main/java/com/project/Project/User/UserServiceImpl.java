package com.project.Project.User;
import java.util.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.*;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveUser(User user) throws Exception {
        System.out.println(user.getUserId());
        authenticateId(user);
        authenticateEmail(user);
        authenticateUsername(user);
        authenticatePassword(user.getPassword());
        userRepository.save(user);
    }
    //sign in user
    @Override
    public User findUser(String username, String password) throws Exception {
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        if(userOptional.isEmpty()) throw new Exception("Username does not exist");
        if(!userOptional.get().getPassword().equals(password)) throw new Exception("Incorrect password");
        return userOptional.get();
    }
    @Transactional
    public boolean setPassword(int ctcLinkId, String previousPassword, String newPassword) throws Exception {

        User user = userRepository.findById(ctcLinkId).orElseThrow(() -> new IllegalStateException("incorrect ctcLink Id"));
        this.authenticatePassword(newPassword);
        if(previousPassword.equals(
                user.getPassword())){ user.setPassword(newPassword);
        }else{
            throw new Exception("Incorrect previous password");
        }
        return true;
    }

    private void authenticateId(User user) throws Exception {
        if(Integer.toString(user.getUserId()).length() != 9){
            throw new Exception("Insert a valid ctcLink ID");
        }
        if(userRepository.existsById(user.getUserId())){ //Checking if the user already exists
            throw new Exception("The user already exists.");
        }
    }
    private void authenticateEmail(User user) throws Exception {
        //Checking if the email already exists
        if(user.getEmail().contains(" ")) throw new Exception("The email cannot contain spaces");
        if(!user.getEmail().toLowerCase().endsWith("@bellevuecollege.edu")){ //Checking if the email is a BC email
            throw new Exception("The user must have a Bellevue College email.");
        }
        Optional<User> emailOptional = userRepository.findUserByEmail(user.getEmail());
        if(emailOptional.isPresent()) throw new Exception("The email is already taken");
    }
    private void authenticatePassword(String password) throws Exception {
        //Checking if the password is safe
        if(Pattern.compile("\s+").matcher(password).find()) throw new Exception("The password cannot contain spaces");
        if(password.length() < 8) throw new Exception("The password must have at least 8 characters");
        if(password.length() > 20) throw new Exception("The password must have less than 21 characters");
        if(!Pattern.compile("[a-z]+").matcher(password).find()) throw new Exception("The password must have at least one lowercase letter");
        if(!Pattern.compile("[A-Z]+").matcher(password).find()) throw new Exception("The password must have at least one uppercase letter");
        if(!Pattern.compile("[0-9]+").matcher(password).find()) throw new Exception("The password must have at least one digit");
        if(!Pattern.compile("[~`!@#$%^&*()<>]+").matcher(password).find()) throw new Exception("The password must have at least one of these symbols: ~`!@#$%^&*()<>");
    }
    private void authenticateUsername(User user) throws Exception{
        //Checking if the username already exists
        Optional<User> usernameOptional = userRepository.findUserByUsername(user.getUsername());
        if(usernameOptional.isPresent()) throw new Exception("Username already exists");
    }
}
