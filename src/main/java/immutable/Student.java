package immutable;

//Java Program to Create An Immutable Class
import java.util.HashMap;
import java.util.Map;

//declare the class as final
final class Student {

 // make fields private and final
 private final String name;
 private final int regNo;
 private final Map<String, String> metadata;

 // initialize all fields via constructor
 public Student(String name, int regNo, Map<String, String> metadata) {
     this.name = name;
     this.regNo = regNo;

     // deep copy of mutable object (Map)
     Map<String, String> tempMap = new HashMap<>();
     for (Map.Entry<String, String> entry : metadata.entrySet()) {
         tempMap.put(entry.getKey(), entry.getValue());
     }
     this.metadata = tempMap;
 }

 // only provide getters (no setters)
 public String getName() {
     return name;
 }

 public int getRegNo() {
     return regNo;
 }

 // return deep copy to avoid exposing internal state
 public Map<String, String> getMetadata() {
     Map<String, String> tempMap = new HashMap<>();
     for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
         tempMap.put(entry.getKey(), entry.getValue());
     }
     return tempMap;
 }
}
