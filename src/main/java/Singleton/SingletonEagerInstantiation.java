package Singleton;

public class SingletonEagerInstantiation {

	 private static SingletonEagerInstantiation obj = new SingletonEagerInstantiation();
	 
	    private SingletonEagerInstantiation() {}
	 
	    public static SingletonEagerInstantiation getInstance()
	    {
	        return obj;
	    }
	    
}
