package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SiteMeshFilter());
        bean.addUrlPatterns("/*");
/*        bean.addUrlPatterns("/addUserForm.action");
        bean.addUrlPatterns("/addUser.action");
        bean.addUrlPatterns("/findUserForm.action");
        bean.addUrlPatterns("/findUser.action");
        bean.addUrlPatterns("/listAllUsers.action");*/
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean prepareAndExecuteFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());
        bean.addUrlPatterns("/*");
/*        bean.addUrlPatterns("/addUserForm.action");
        bean.addUrlPatterns("/addUser.action");
        bean.addUrlPatterns("/findUserForm.action");
        bean.addUrlPatterns("/findUser.action");
        bean.addUrlPatterns("/listAllUsers.action");
        bean.addInitParameter("actionPackages", "com.lq");*/
        bean.setOrder(2);
        return bean;
    }

}
