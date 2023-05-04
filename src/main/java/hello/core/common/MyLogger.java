package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    //proxyMode = ScopedProxyMode.TARGET_CLASS 는 가상의 클래스(마이로거)를 만들어놓음
    //그후 실제를 requset할때 바꿔낌

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }


    public void log(String message) {
        System.out.println("[" + uuid + "]" + "["+ requestURL + "]" + "[" + message + "]");
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope create" + this );
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "]request scope close" + this );
    }
}
