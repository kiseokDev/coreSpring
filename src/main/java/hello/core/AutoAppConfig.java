package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters= @Filter(type = FilterType.ANNOTATION, classes = {
        Configuration.class
})
)
public class AutoAppConfig {
}
