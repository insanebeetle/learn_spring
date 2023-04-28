package hello.core.singleton;

public class StatefulService {

    //private int price; //상태를 유지하는 필드
    //변수를 보관하지 않기 - 변경될만한 껀덕지를 없애기
    public int order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        //this.price = price;  //여기가 문제
        return price;
        //아예 객체가 생성되자마자 바로 값을 넘겨 버리기
        //중간에 끼어들수 없게 설꼐
    }
    //스프링 빈은 항상 무상태 stateless로 설게해야한다
//    public int getPrice() {
//        return price;
//    }
}
