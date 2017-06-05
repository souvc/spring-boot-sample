package sample.jpa.custom.single.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.jpa.custom.single.entry.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>, CustomRepository {

}
