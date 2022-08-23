package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefullServiceTest {
    @Test
    void StatefullServiceTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefullService service1 = ac.getBean(StatefullService.class);
        StatefullService service2 = ac.getBean(StatefullService.class);

        //assertThat(service1).isSameAs(service2);

        //ThreadA : 사용자 A , 주문 10000원
        service1.order("userA",10000);
        //ThreadA : 사용자 B , 주문 20000원
        service2.order("userB", 20000);

        //사용자 A의 주문은 10000원 인데????? 20000원이 출력;;;;
        int price = service1.getPrice();
        assertThat(price).isEqualTo(20000);

    }

   static class TestConfig {
       @Bean
       public StatefullService statefullService() {
           return new StatefullService();
       }
    }


}