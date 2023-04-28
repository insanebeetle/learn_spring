package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        //basePackageClasses = " " 지정한 클래스의 패키지를 시작위치로함- 디폴트값은 현재 클래스의 패키지부터 스캔
        //basePackages = "hello.core" 이런 식으로 검색하는 패키지 범위를 지정할 수도 있음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)//컴포넌트 스캔을 할 때 포함하지 않을 컴포넌트를 설정
public class AutoAppConfig {

}
