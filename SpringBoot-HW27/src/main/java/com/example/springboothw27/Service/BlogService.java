package com.example.springboothw27.Service;

import com.example.springboothw27.ApiException.ApiException;
import com.example.springboothw27.Controller.BlogController;
import com.example.springboothw27.Model.Blog;
import com.example.springboothw27.Model.MyUser;
import com.example.springboothw27.Repository.BlogRepository;
import com.example.springboothw27.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MyUserRepository myUserRepository;

    public List<Blog> getAllBlogs() {

        return blogRepository.findAll();
    }

    public List<Blog> getUserBlogs(MyUser myUser) {
        return blogRepository.findBlogsByMyUser(myUser);
    }


    public void addblog(Integer userId, Blog blog) {
        blog.setMyUser(myUserRepository.findMyUserById(userId));
        blogRepository.save(blog);
    }

    public void updateBlog(Integer userId, Blog blog, Integer blogid) {
        Blog oldBlog = blogRepository.findBlogById(blogid);
        if (oldBlog == null){
            throw new ApiException("Blog Not Found");
        }

        if (!(userId.equals(oldBlog.getMyUser().getId()))){
            throw new ApiException("Not Authorized");
        }

        oldBlog.setTitel(blog.getTitel());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }

    public void deleteBlog(Integer userId, Integer blogId) {
        Blog blog = blogRepository.findBlogById(blogId);
        if (blog == null){
            throw new ApiException("Blog Not Found");
        }

        if (!(userId.equals(blog.getMyUser().getId()))){
            throw new ApiException("Not Authorized");
        }
        blogRepository.delete(blog);
    }
    public Blog getbyid(Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b==null){
            throw new ApiException("not found");
        }
        return b;
    }

    public Blog getBlogtit(String title){
        Blog b= blogRepository.findBlogByTitel(title);
        if(b==null){
            throw new ApiException("not found");
        }
        return b;
    }
}

