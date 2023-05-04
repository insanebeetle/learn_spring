package hello.core.lifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//결론부터 말하면 그냥 PostConstruct, PreDestroy를 쓰세요
//아래 임플먼트는 빈의 생성, 소멸주기 콜백을 받기 위한 인터페이스
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connect : "+ url);
    }

    public void call(String message) {
        System.out.println("call : " + url +"Memssage : " + message);
    }

    public void disconnect(){
        System.out.println("디스커넥트" + url);
    }

    @PostConstruct //그냥 이거써라
    public void init() throws Exception {
        connect();
        call("초기화 연결메세지");
    }
    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }


    //임플먼트에서 받아온 메소드로 객체의 생성, 의존성 주입을 나눔, 아래는 의존주입콜백
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결메세지");
//    }
//    //요놈은 소멸주기 콜백
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
