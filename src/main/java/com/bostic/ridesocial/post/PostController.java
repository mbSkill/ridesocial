package com.bostic.ridesocial.post;

import com.bostic.ridesocial.azure.AzureImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@RequestMapping("/post")
public class PostController {
    PostService postService;
    AzureImageService azureImageService;

    public PostController(PostService postService, AzureImageService azureImageService) {
        this.postService = postService;
        this.azureImageService = azureImageService;
    }

    @PostMapping()
    public String createPost(@RequestParam("username") String username, @RequestParam("image") MultipartFile multipartFile ) throws IOException {
        return azureImageService.SaveImage(multipartFile, username);
    }


}
