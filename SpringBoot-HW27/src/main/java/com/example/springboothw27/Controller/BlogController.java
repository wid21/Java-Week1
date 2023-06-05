package com.example.springboothw27.Controller;

import com.example.springboothw27.Model.Blog;
import com.example.springboothw27.Model.MyUser;
import com.example.springboothw27.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get-all")
    public ResponseEntity getAllBlogs() {
        return ResponseEntity.status(200).body(blogService.getAllBlogs());
    }

    @GetMapping("/get")
    public ResponseEntity getUserBlogs(@AuthenticationPrincipal MyUser myUser){
        List<Blog> blogs = blogService.getUserBlogs(myUser);
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlogs(@AuthenticationPrincipal MyUser myUser,@Valid @RequestBody Blog blog){
        blogService.addblog(myUser.getId(),blog);
        return ResponseEntity.status(200).body("blog added ");
    }

    @PutMapping("/update/{blogId}")
    public ResponseEntity updateblogs(@AuthenticationPrincipal MyUser myUser, @Valid @RequestBody Blog blog, @PathVariable Integer blogId) {
        blogService.updateBlog(myUser.getId(), blog, blogId);
        return ResponseEntity.status(200).body("blog updated");
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteblog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId){
        blogService.deleteBlog(myUser.getId(), blogId);
        return ResponseEntity.status(200).body("blog deleted ");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getbytit(@PathVariable Integer id){
        Blog b= blogService.getbyid(id);
        return ResponseEntity .status(200).body(b);
    }

    @GetMapping("/get-t/{titel}")
    public ResponseEntity getbytit(@PathVariable String titel){
        Blog b= blogService.getBlogtit(titel);
        return ResponseEntity .status(200).body(b);
    }
}
