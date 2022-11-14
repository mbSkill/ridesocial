package com.bostic.ridesocial.post;

import com.bostic.ridesocial.azure.AzureImageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {
    private static final Logger logger =
            LogManager.getLogger("PostController");
    PostService postService;
    AzureImageService azureImageService;

    public PostController(PostService postService, AzureImageService azureImageService) {
        this.postService = postService;
        this.azureImageService = azureImageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> findAll(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }


    @PostMapping()
    public RedirectView createPost(@RequestParam("email") String email,
                             @RequestParam("paragraph") String paragraph,
                             @RequestParam("image") MultipartFile multipartFile ) throws IOException {
       try{
           var user = postService.userService.getUser(email).orElseThrow();
           System.out.println(user);
           String azureBlobURL =  azureImageService.SaveImage(multipartFile, user.getUsername());
           System.out.println(postService.savePost(email,paragraph,azureBlobURL));
       }  catch (NoSuchElementException e) {
           logger.error(String.format("User with email:%s does not exist.",email), e);
       }catch (Exception e){
           logger.error(String.format("Error in Post Controller. Values provided:" +
                   "\nemail: %s\nparagraph: %s",email,paragraph), e);
       }

        return new RedirectView("/");
    }


}
