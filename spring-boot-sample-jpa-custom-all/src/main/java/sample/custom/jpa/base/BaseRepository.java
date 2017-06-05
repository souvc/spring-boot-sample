package sample.custom.jpa.base;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *  自定义基类 Repository接口
 *  BaseRepository继承了PagingAndSortingRepository，这样可以保证所有Repository都有基本的增删改查以及分页等方法。
 * @param <T> 
 * @param <ID>
 */

//@NoRepositoryBean标注，这样Spring Data Jpa在启动时就不会去实例化BaseRepository这个接口
@NoRepositoryBean 
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	//添加support(String modelType)方法，表示该Repository的领域对象是否为modelType类型
    boolean support(String modelType);
    
}
