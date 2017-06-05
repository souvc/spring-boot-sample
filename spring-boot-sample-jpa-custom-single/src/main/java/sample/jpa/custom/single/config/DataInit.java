package sample.jpa.custom.single.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.jpa.custom.single.entry.Blog;
import sample.jpa.custom.single.repository.BlogRepository;

@Component
public class DataInit {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);
    
    @Autowired 
    BlogRepository blogRepository;
    
    @PostConstruct
    public void dataInit(){
        Blog blog = new Blog();
        blog.setContent("this is blog content");
        blog.setTitle("blog");
        blog = blogRepository.save(blog);
        logger.debug("id is {}", blog.getId());
        
    }

}
