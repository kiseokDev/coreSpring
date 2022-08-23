package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 객체 사용")
    void 싱글톤객체사용() {
        SingletonService service1 = SingletonService.getInstance();
        SingletonService service2 = SingletonService.getInstance();

        System.out.println("service1 = " + service1);
        System.out.println("service2 = " + service2);

        //same == 참조값 비교
        //equal == Object.equal() 비교

        //assertThat(service1).isEqualTo(service2);
        assertThat(service1).isSameAs(service2);




    }
}