package com.project.Project.Post;

import com.project.Project.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //@Query("SELECT s FROM Post s WHERE s.PostId = ?1")
    //Optional<Post> findPostByPostId(int postId);

//    @Query("Select s FROM User s WHERE s.email = ?1")
//    Optional<Post> findUserByEmail(String email);

}
