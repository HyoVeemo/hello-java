package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    // == 스프링 컨테이너
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("neame = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();


        for (String definitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(definitionName);

            // ROLE_APPLICATION: 직접 등록한 어플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(definitionName);
                System.out.println("neame = " + beanDefinition + "object = " + bean);
            }

        }


    }

}