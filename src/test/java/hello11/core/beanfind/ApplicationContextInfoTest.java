package hello11.core.beanfind;

import hello11.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bdn : beanDefinitionNames) {
            Object bean = ac.getBean(bdn);
            System.out.println("BeanName = " + bdn+" Object = "+ bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void ApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bdn : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(bdn);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(bdn);
                System.out.println("BeanName = " + bdn+" Object = "+ bean);
            }
        }
    }

}
