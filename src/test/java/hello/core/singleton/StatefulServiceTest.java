package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulSercviceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //Thread A 10000 order
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread B 10000 order
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA a do getPrice
//        int price = statefulService1.getPrice();
        //상황 에시 1이 먼저 만원을 주문하고 그 다음에 2가 2만원을 주문함
        //그런데 1이 가격을 확인하려 하니 2만원이 떠버림

        System.out.println(userAPrice);
    }

    static  class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}