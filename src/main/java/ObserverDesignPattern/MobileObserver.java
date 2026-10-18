package ObserverDesignPattern;

public class MobileObserver implements Observer {
    private String name;

    public MobileObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }

}
