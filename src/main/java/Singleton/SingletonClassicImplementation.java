package Singleton;

public class SingletonClassicImplementation {

	 private static SingletonClassicImplementation obj;
	 
	    // private constructor to force use of
	    // getInstance() to create Singleton object
	    private SingletonClassicImplementation() {}
	 
	    public static SingletonClassicImplementation getInstance()
	    {
	        if (obj==null)
	            obj = new SingletonClassicImplementation();
	        return obj;
	    }
	    
}
