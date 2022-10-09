package hello.core.singleton;

public class SingletonService {
    // 자바 기본의 static 에 대한 공부 필요
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
