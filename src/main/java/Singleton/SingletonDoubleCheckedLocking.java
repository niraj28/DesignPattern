package Singleton;

public class SingletonDoubleCheckedLocking {

	  private static volatile SingletonDoubleCheckedLocking obj  = null;
	  
	    private SingletonDoubleCheckedLocking() {}
	 
	    public static SingletonDoubleCheckedLocking getInstance()
	    {
	        if (obj == null)
	        {
	            // To make thread safe
	            synchronized (SingletonDoubleCheckedLocking.class)
	            {
	                // check again as multiple threads
	                // can reach above step
	                if (obj==null)
	                    obj = new SingletonDoubleCheckedLocking();
	            }
	        }
	        return obj;
	    }
	    
}
