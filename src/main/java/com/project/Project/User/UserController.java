package com.project.Project.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public @ResponseBody User registerUser(@RequestBody User user) throws Exception {
        //Creating a new user (sign up)
        userService.saveUser(user);
        System.out.println("yes");
        return user;
    }
    @GetMapping("/signIn")
    public User signInUser(@RequestParam String username,
                           @RequestParam String password) throws Exception {
        return userService.findUser(username, password);
    }
    @PutMapping("/modifypassword/{ctcLinkId}")
    public boolean modifyPassword(@PathVariable("ctcLinkId") int ctcLinkId, @RequestParam String previousPassword, @RequestParam String newPassword) throws Exception {
        return userService.setPassword(ctcLinkId, previousPassword, newPassword);
    }

}
