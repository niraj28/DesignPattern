package ObserverDesignPattern;

public class ObserverMain {
	/*
	 * It is a behavioral design pattern where one object keeps a list of dependent objects and notifies them automatically when its state changes. This is a classic one-to-many relationship.

		Simple idea
		Subject / Publisher → the main object being watched
		Observers / Subscribers → objects that want updates
		When subject changes, it calls update() on all observers.
		
		Real-life example
		Think of YouTube channel subscribers:	
		Channel uploads a new video
		All subscribers get notified
	 */
	
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer user1 = new MobileObserver("Niraj");
        Observer user2 = new MobileObserver("Rahul");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Observer Pattern in Java");
    }

}
