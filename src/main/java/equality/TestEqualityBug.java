package equality;

import java.util.HashMap;
import java.util.Map;

public class TestEqualityBug {
	public static void main(String[] args) {

        Map<Employee, String> map = new HashMap<>();

        Employee e1 = new Employee("Niraj", 30);
        map.put(e1, "Engineer");

        Employee e2 = new Employee("Niraj", 30);

        // ❌ This will print null (BUG)
        System.out.println(map.get(e2));
        
        		
        
        EmployeeOverridden e3 = new EmployeeOverridden("Niraj", 30);
        Map<EmployeeOverridden, String> map2 = new HashMap<>();
        map2.put(e3, "Engineer");
        EmployeeOverridden e4 = new EmployeeOverridden("Niraj", 30);
        
     // ❌ This will print null (BUG)
        System.out.println(map2.get(e4));
        
        
        
        
        		
    }

}
