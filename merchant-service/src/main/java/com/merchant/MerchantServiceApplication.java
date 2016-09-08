package com.merchant;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.merchant.interceptor.TokenInterceptor;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.merchant.dao")
// 扫描mapper
@EnableTransactionManagement
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class MerchantServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MerchantServiceApplication.class).web(true).run(args);
	}

	//数据源
	@Bean
	@ConfigurationProperties(prefix = "jdbc")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapping/*.xml")); // "**"代表多个文件夹下
		return sqlSessionFactoryBean.getObject();
	}

	//事物管理
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	//配置拦截器
	/*@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/*");
		}
	}*/

}
