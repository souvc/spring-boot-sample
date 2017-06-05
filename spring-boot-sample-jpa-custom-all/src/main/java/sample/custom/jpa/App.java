package sample.custom.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import sample.custom.jpa.base.BaseRepositoryFactoryBean;

/**
 * 配置Jpa使用我们自定义的BaseRepositoryFactoryBean
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class App {

    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
