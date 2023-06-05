package com.example.springboothw27.Repository;

import com.example.springboothw27.Model.Blog;
import com.example.springboothw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>{

    Blog findBlogById(Integer id);
    Blog findBlogByTitel(String titel);


    List<Blog> findBlogsByMyUser(MyUser myUser);
}
