package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
	
	private List<Observer> observers = new ArrayList<>();

    
	public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void uploadVideo(String title) {
        notifyObservers("New video uploaded: " + title);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
