package kr.co.ioncares.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableAsync( proxyTargetClass = true )
@EnableCaching( proxyTargetClass = true )
@EnableAutoConfiguration
@ComponentScan( basePackages = {"kr.co.ioncares.**.*"} )
public class IoncaresApplication extends SpringBootServletInitializer {

	public static void main(String[] args)
    {
        SpringApplication.run(IoncaresApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(IoncaresApplication.class);
    }

}
