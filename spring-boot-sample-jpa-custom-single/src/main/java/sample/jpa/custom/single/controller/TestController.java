package sample.jpa.custom.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.jpa.custom.single.entry.Blog;
import sample.jpa.custom.single.repository.BlogRepository;

@RestController
public class TestController {
    
    @Autowired
    private BlogRepository blogRepository;
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Blog> searchTitle(@RequestParam String key){
        return blogRepository.searchTitle(key);
    }
    

}
