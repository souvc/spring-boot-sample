package sample.custom.jpa.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.custom.jpa.entry.Article;
import sample.custom.jpa.entry.Blog;
import sample.custom.jpa.repository.ArticleRepository;
import sample.custom.jpa.repository.BlogRepository;

@Service
public class DataInit {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);
    
    @Autowired 
    BlogRepository blogRepository;
    
    @Autowired 
    ArticleRepository articalRepository;
    
    @PostConstruct
    public void dataInit(){
        Blog blog = new Blog();
        blog.setContent("this is blog content");
        blog.setTitle("blog");
        blog = blogRepository.save(blog);
        logger.debug("id is {}", blog.getId());
        
        Article artical = new Article();
        artical.setName("artical");
        artical.setValue("this is artical value");
        artical = articalRepository.save(artical);
        logger.debug("id is {}", artical.getId());
    }

}
