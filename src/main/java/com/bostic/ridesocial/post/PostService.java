package com.bostic.ridesocial.post;

import com.bostic.ridesocial.user.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class PostService {
    /**n
     * TODO: save image to Bucket
     * TODO: attach user email to establish post ownership
     */
    PostRepository repository;
    UserService userService;


    public PostService(PostRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Timestamp getTimestamp(){
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public boolean paragraphValid(String paragraph){
        return paragraph.length() >= 300;
    }

    public boolean userEmailExists(String email){
       return !email.isBlank() && userService.emailExists(email);
    }

    public int savePost(String email,String paragraph, String azureBlobURL) {
        if(paragraphValid(paragraph) &&
                userEmailExists(email){
            Post post = new Post();
            post.setUser(userService.getUser(email));
            post.setParagraph(paragraph);
            post.setImage(azureBlobURL);
            post.setCreatedOn(getTimestamp());
        }
        return repository.save().getId();
    }
}
