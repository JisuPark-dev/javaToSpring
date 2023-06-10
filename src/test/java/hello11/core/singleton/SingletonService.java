package hello11.core.singleton;

public class SingletonService {

    //자기 자신을 내부의 private으로 가지고 있는다.
    //static 이라서 클래스level에서 딱 하나만 가지게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자를 만든다 -> 자기자신 밖에서는 new SingletonService를 생성하지 못하게 된다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("singleton Logic");
    }

}
