package sample.jpa.custom.single.repository;

import java.util.List;

import sample.jpa.custom.single.entry.Blog;

public interface CustomRepository {
    
    List<Blog> searchTitle(String key);

}
