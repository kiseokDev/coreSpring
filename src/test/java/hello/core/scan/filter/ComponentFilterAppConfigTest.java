package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void FilterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        assertThat(beanA).isNotNull();


        assertThrows(
                NoSuchBeanDefinitionException.class,
                ()->ac.getBean(BeanB.class)
        );


    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
            // 자주쓰는 FilterType, 특정 클래스를 exclude 하고 싶을때 ->  FilterType.ASSIGNABLE_TYPE
            // ex) -> @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class
    )
    static class ComponentFilterAppConfig {
    }
}

