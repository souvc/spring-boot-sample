package sample.custom.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.custom.jpa.base.BaseRepository;
import sample.custom.jpa.entry.Article;
import sample.custom.jpa.entry.Blog;
import sample.custom.jpa.repository.BlogRepository;

@RestController
public class TestController {
    
    @Autowired
    private List<BaseRepository> repositories;
    
    @Autowired
    private  BlogRepository  blogRepository;
    
    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public Object getEntry(@RequestParam(value="type", required = true) String type,
            @RequestParam(value="id", required=true) Integer id){
        if(type.equals("article")){
            type = Article.class.getName();
        }else if (type.equals("blog")) {
            type = Blog.class.getName();
        }
        for (BaseRepository baseRepository : repositories) {
            if(baseRepository.support(type)){
                return baseRepository.findOne(id);
            }
        }
        return null;
    }
    
    
    
    @RequestMapping(value = "/blog", method=RequestMethod.GET)
    public Iterable<Blog> blog(){
    	Iterable<Blog> list=blogRepository.findAll();
        return list;
    }
    

}
