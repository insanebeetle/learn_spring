package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //싱글톤 패턴 객체 생성을 미리 static final로 선언해서 - 자바 실행과 동시에 객체 생성


    private  SingletonService(){

    }
    //생성자를 private으로 두어서 다른 곳에서 생성 막기

    public  static SingletonService getInsetance(){
        return instance;
    }
    // 이 메소드를 이용해서만 인스턴스 접근 가능 + 하나의 인스턴스 재사용

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

//싱글톤 코드작성을 일일이 하는건 존나 귀찮고 solid같은 원칙을 위반할 가능성도 높음
//따라서 스프링을 이용하면 위처럼 하나하나 좆지랄 안해도 됨
