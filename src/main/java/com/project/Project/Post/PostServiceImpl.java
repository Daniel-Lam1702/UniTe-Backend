package com.project.Project.Post;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public void savePost(Post post) throws Exception {
        System.out.println(post.getPostId());
        postRepository.save(post);
    }
    //SKIP THIS FIRST WE DON'T NEED IT
//    @Override
//    public Post findPost(String email, String password) throws Exception {
//        Optional<Post> PostOptional = PostRepository.findPostByEmail(email);
//        if(PostOptional.isEmpty()) throw new Exception("Postname does not exist");
//        if(!PostOptional.get().getPassword().equals(password)) throw new Exception("Incorrect password");
//        return PostOptional.get();
//    }
    @Transactional
    public boolean setPost(int postId, String newTitle, String newContent) throws Exception {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalStateException("incorrect post Id"));
        post.setTitle(newTitle);
        post.setContent(newContent);
//        this.authenticatePassword(newPassword);
//        if(previousPassword.equals(
//                Post.getPassword())){ Post.setPassword(newPassword);
//        }else{
//            throw new Exception("Incorrect previous password");
//        }
        return true;
    }

//    private void authenticateId(Post Post) throws Exception {
//        if(Integer.toString(Post.getPostId()).length() != 9){
//            throw new Exception("Insert a valid ctcLink ID");
//        }
//        if(PostRepository.existsById(Post.getPostId())){ //Checking if the Post already exists
//            throw new Exception("The Post already exists.");
//        }
//    }
//    private void authenticateEmail(Post Post) throws Exception {
//        //Checking if the email already exists
//        if(Post.getEmail().contains(" ")) throw new Exception("The email cannot contain spaces");
//        if(!Post.getEmail().toLowerCase().endsWith("@bellevuecollege.edu")){ //Checking if the email is a BC email
//            throw new Exception("The Post must have a Bellevue College email.");
//        }
//        Optional<Post> emailOptional = PostRepository.findPostByEmail(Post.getEmail());
//        if(emailOptional.isPresent()) throw new Exception("The email is already taken");
//    }
//    private void authenticatePassword(String password) throws Exception {
//        //Checking if the password is safe
//        if(Pattern.compile("\s+").matcher(password).find()) throw new Exception("The password cannot contain spaces");
//        if(password.length() < 8) throw new Exception("The password must have at least 8 characters");
//        if(password.length() > 20) throw new Exception("The password must have less than 21 characters");
//        if(!Pattern.compile("[a-z]+").matcher(password).find()) throw new Exception("The password must have at least one lowercase letter");
//        if(!Pattern.compile("[A-Z]+").matcher(password).find()) throw new Exception("The password must have at least one uppercase letter");
//        if(!Pattern.compile("[0-9]+").matcher(password).find()) throw new Exception("The password must have at least one digit");
//        if(!Pattern.compile("[~`!@#$%^&*()<>]+").matcher(password).find()) throw new Exception("The password must have at least one of these symbols: ~`!@#$%^&*()<>");
//    }
//    private void authenticatePostname(Post Post) throws Exception{
//        //Checking if the Postname already exists
//        Optional<Post> PostnameOptional = PostRepository.findPostByPostname(Post.getPostname());
//        if(PostnameOptional.isPresent()) throw new Exception("Postname already exists");
//    }
}
