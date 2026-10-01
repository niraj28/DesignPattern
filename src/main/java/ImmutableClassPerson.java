import java.util.ArrayList;
import java.util.List;

public final class ImmutableClassPerson {
	
	/*
	 * An immutable class is a class whose objects cannot be changed after creation.
	 * To create an immutable class in Java, you can follow these steps:
	 * 	1. Declare the class as final so that it cannot be subclassed.
	 * 	2. Make all fields private and final to ensure they cannot be modified after
	 * 	   object creation.
	 * 	3. Provide a constructor to initialize all fields.
	 * 	4. Do not provide any setter methods, only getter methods to access the
	 * 	   fields.
	 * 	5. If the class contains mutable objects (like lists or arrays), 
	 * make	 defensive copies of these objects in the constructor and getter methods to prevent external modification.
	 * Why immutable?
		✅ Thread-safe (no synchronization needed)
		✅ Safe to cache (like in your L1/L2 cache design)
		✅ No side effects → predictable code
		✅ Good for keys in HashMap
	 *
	 */


	    private final String name;
	    private final int age;
	    private final List<String> hobbies;

	    public ImmutableClassPerson(String name, int age, List<String> hobbies) {
	        this.name = name;
	        this.age = age;
	        this.hobbies = new ArrayList<>(hobbies);
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public List<String> getHobbies() {
	        return new ArrayList<>(hobbies);
	    }
	}

