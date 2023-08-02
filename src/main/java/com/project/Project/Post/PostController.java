package com.project.Project.Post;

import com.project.Project.User.User;
import com.project.Project.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post/api")
@CrossOrigin
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/createPost")
    public @ResponseBody
    Post createPost(@RequestBody Post post) throws Exception {
        //Creating a new post
        postService.savePost(post);
        System.out.println("save post done");
        return post;
    }
    //    @PostMapping("/signIn")
//    public User signInUser(@RequestBody User user) throws Exception {
//        return userService.findUser(user.getEmail(), user.getPassword());
//    }
    @PutMapping("/modifypost/{postId}")
    public boolean modifyPassword(@PathVariable("postId") int postId, @RequestParam String newTitle, @RequestParam String newContent) throws Exception {
        return postService.setPost(postId, newTitle, newContent);
    }

}
