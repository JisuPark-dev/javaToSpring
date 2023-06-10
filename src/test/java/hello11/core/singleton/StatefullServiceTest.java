package hello11.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefullServiceTest {
    @Test
    @DisplayName("statefulService singleton에서 주의점")
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StatefullService.class);
        StatefullService statefulService1 = ac.getBean("statefullService", StatefullService.class);
        StatefullService statefulService2 = ac.getBean("statefullService", StatefullService.class);

        int userA = statefulService1.order("userA", 1000);
        int userB = statefulService2.order("userB", 2000);

//        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);
        System.out.println("price = " + userB);


    }

    static class TestConfig {
        @Bean
        public StatefullService statefullService() {
            return new StatefullService();
        }
    }

}