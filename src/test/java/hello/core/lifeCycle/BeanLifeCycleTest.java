package hello.core.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext acc = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = acc.getBean(NetworkClient.class);
        acc.close();
    }

    @Configuration
    static class  LifeCycleConfig{
        //빈사이클테스트에서 init,close 메소드를 빈생성소명 메소드로 선언시킴
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public  NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hellospring");
            return networkClient;
        }
    }
}
