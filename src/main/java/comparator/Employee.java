package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
	
	   String name;
	    int age;
	    int salary;

	    Employee(String name, int age, int salary) {
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }

	    @Override
	    public String toString() {
	        return name + " " + age + " " + salary;
	    }
	    
	    public static void main(String[] args) {
	        Employee e1 = new Employee("Alice", 30, 50000);
	        Employee e2 = new Employee("Bob", 25, 60000);
	        Employee e3 = new Employee("Charlie", 35, 55000);
	        
	        List<Employee> list = new ArrayList<>();
	        
	        list.add(e1);
	        list.add(e2);
	        list.add(e3);

	        System.out.println(e1);
	        System.out.println(e2);
	        System.out.println(e3);
	        
	        comparator.Employee[] employees = {e1, e2, e3};
	     // 👉 Put comparator here
	     // 👉 Put comparator here
	        list.sort(
	            Comparator.comparingInt((Employee e) -> e.salary).reversed()
	                      .thenComparingInt(e -> e.age)
	        );

	        System.out.println(list);

	        	
	        for (Employee e : employees) {
	            System.out.println(e);
	        }
	        
	    }

}
