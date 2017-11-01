package com.collaborate.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collaborate.Dao.ChatDao;
import com.collaborate.Dao.ForumDao;
import com.collaborate.Dao.FriendDao;
import com.collaborate.Dao.JobAppliedDao;
import com.collaborate.Dao.JobDao;
import com.collaborate.Dao.UserDao;
import com.collaborate.DaoImpl.BlogDaoImpl;
import com.collaborate.DaoImpl.BlogPostImpl;
import com.collaborate.DaoImpl.ChatDaoImpl;
import com.collaborate.DaoImpl.ForumDaoImpl;
import com.collaborate.DaoImpl.FriendDaoImpl;
import com.collaborate.DaoImpl.JobAppliedDaoImpl;
import com.collaborate.DaoImpl.JobDaoImpl;
import com.collaborate.DaoImpl.ProfilePicDaoImpl;
import com.collaborate.DaoImpl.UserDaoImpl;
import com.collaborate.Model.Blog;
import com.collaborate.Model.BlogComment;
import com.collaborate.Model.BlogPost;
import com.collaborate.Model.Chat;
import com.collaborate.Model.Forum;
import com.collaborate.Model.Friend;
import com.collaborate.Model.Job;
import com.collaborate.Model.JobApplied;
import com.collaborate.Model.ProfilePicture;
import com.collaborate.Model.User;

@Configuration
@ComponentScan("com.collaborate")
@EnableTransactionManagement
public class DBConfig {
	
	// 1 create a DataSource obj which is used for LocalSessionFactory
	
	@Autowired
	@Bean
	public DataSource getOracleDataSource() 
	{
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
		
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("11");
		
		System.out.println("Data Souce Created");
		
		return driverManagerDataSource ;
		
	}
	
	// 2 create a Hibernate property for Datasource itz mentory,,,, which is used for LocalSessionFactory
	
	@Autowired
	@Bean
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.show_sql","hibernate.show_sql");
        properties.put("hibernate.format_sql","hibernate.format_sql");
        properties.put("hibernate.hbm2ddl.auto", "update");
		
		System.out.println("Hibernate property Object Created");
		
		return properties;
	}
	
	// 3 create a SessionFactory Bean.....local sessionfactory.....
	// sessionFactorydepend on ("hibernate core dependency").
	//create an instance
	@Autowired
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder= new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogPost.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(Job.class);
		localSessionFactoryBuilder.addAnnotatedClass(JobApplied.class);
		localSessionFactoryBuilder.addAnnotatedClass(Chat.class);
		localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
//		localSessionFactoryBuilder.scanPackages("com.niit.collaborate");

		System.out.println("SessionFactory Bean created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	// 4 HibernateTransaction Bean
	
	@Autowired
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
	
		return new HibernateTransactionManager(sessionFactory);
		
	}
	
	
	// 5 Application Specific Dao bean.
	
	@Autowired
	@Bean
	public BlogDaoImpl getBlogDAO(SessionFactory sessionFactory)
	{
	return new BlogDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public ForumDao getForumDAO(SessionFactory sessionFactory)
	{
	return new ForumDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public FriendDao getFriendDAO(SessionFactory sessionFactory)
	{
	return new FriendDaoImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean
	public ChatDao getChatDAO(SessionFactory sessionFactory)
	{
	return new ChatDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public JobDao getJobsDAO(SessionFactory sessionFactory)
	{
	return new JobDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public JobAppliedDao getJobsAppliedDAO(SessionFactory sessionFactory)
	{
	return new JobAppliedDaoImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean
	public UserDao getUserDAO(SessionFactory sessionFactory)
	{
		//sessionFactory used for userDaoImpl class
	return new UserDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public BlogPostImpl getBlog(SessionFactory sessionFactory)
	{
	return new BlogPostImpl(sessionFactory);
	}
	
	@Autowired
	@Bean
	public ProfilePicDaoImpl getProfilePic(SessionFactory sessionFactory)
	{
	return new ProfilePicDaoImpl(sessionFactory);
	}

}
