package sample.jpa.custom.single.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import sample.jpa.custom.single.entry.Blog;

public class BlogRepositoryImpl implements CustomRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> searchTitle(String key) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Blog> query = builder.createQuery(Blog.class);
        Root<Blog> root = query.from(Blog.class);
       // query.where(builder.like(root.get("title"), "%" + key + "%"));
        return em.createQuery(query.select(root)).getResultList();
    }

}
