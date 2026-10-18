package solidPrinciples.liskovSubstitutionPrinciple;

public class RectangleLiskov implements Shape {
	private int width;
	private int height;

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	@Override
	public int getArea() {
		return width * height;
	}
	
	public static void main(String[] args) {
		Shape s = new RectangleLiskov();
		((RectangleLiskov) s).setWidth(5);
		((RectangleLiskov) s).setHeight(10);
		
		System.out.println(s.getArea()); // Expected: 50
	}

}

/*
 * “Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.”
 * 
 * 
 * Simple meaning
👉 If your code works with a parent class, it should work exactly the same with any of its child classes.

No unexpected behavior
No errors
No changed assumptions

-----------------------------------------------------------------------------------------
Parent in both cases
1. Using extends (class inheritance)
class Animal { }   // 👈 Parent (base class)
class Dog extends Animal { }  // 👈 Child
👉 Here:
Animal = Parent (superclass)
Dog = Child (subclass)

2. Using interface
interface Animal { }   // 👈 Parent (supertype)
class Dog implements Animal { }  // 👈 Child
👉 Here:
Animal = Parent (interface / supertype)
Dog = Child (implementation / subtype)

 */
