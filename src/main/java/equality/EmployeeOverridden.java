package equality;

import java.util.Objects;

public class EmployeeOverridden {
	String name;
    int age;

   public  EmployeeOverridden(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeOverridden)) return false;

        EmployeeOverridden e = (EmployeeOverridden) o;
        return age == e.age &&
               Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
/*
 * By default equals() compares memory reference, so we override it to implement logical equality 
 * based on object values and maintain consistency with hashCode().
 * 
Equality Contract (Java)

In Java, when overriding equals() and hashCode(), both must follow a contract to ensure correct behavior in collections like HashMap and HashSet.

equals() defines logical equality between objects (same data → equal).
hashCode() determines the bucket location in hash-based collections.
Rules:
If x.equals(y) is true → x.hashCode() == y.hashCode() must be true
If hashCode is same → objects may or may not be equal
equals() must be reflexive, symmetric, transitive, consistent, and return false for null
In your class:
equals() compares name and age
hashCode() uses the same fields → contract is maintained

👉 This ensures objects behave correctly in hash-based collections.

*/
