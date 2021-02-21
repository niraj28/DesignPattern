package Singleton;

public class SingletonSynchronized {

	private static SingletonSynchronized obj;
	 
    private SingletonSynchronized() {}
 
    // Only one thread can execute this at a time
    public static synchronized SingletonSynchronized getInstance()
    {
        if (obj==null)
            obj = new SingletonSynchronized();
        return obj;
    }
    
}
