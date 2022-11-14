package com.bostic.ridesocial.post;

import com.bostic.ridesocial.user.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<Post> getAllPost(){
        return repository.findAll();
    }

    public Timestamp getTimestamp(){
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public boolean paragraphValid(String paragraph){
        return paragraph.length() <= 300;
    }


    public long savePost(String email,String paragraph, String azureBlobURL) {
        var user = userService.getUser(email);
        if( user.isPresent() &&
            paragraphValid(paragraph)){
                Post post = new Post();
                post.setUser(user.get());
                post.setParagraph(paragraph);
                post.setImage(azureBlobURL);
                post.setCreatedOn(getTimestamp());
            return repository.save(post).getId();
        }
        return -1;
    }
}
