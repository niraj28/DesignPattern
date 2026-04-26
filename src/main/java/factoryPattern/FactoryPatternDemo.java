package factoryPattern;

public class FactoryPatternDemo {
	/*
	 * Factory Pattern:
		Usually means Factory Method in interviews.		
		It creates one type of product.
		
		Idea
		You ask a factory for an object, and the factory decides which concrete class to return.	
	 */
	public static void main(String[] args) {
		  ShapeFactory shapeFactory = new ShapeFactory();
		  //get an object of Circle and call its draw method.
		  Shape shape1 = shapeFactory.getShape("CIRCLE");
		  //call draw method of Circle
		  shape1.draw();
		  //get an object of Rectangle and call its draw method.
		  Shape shape2 = shapeFactory.getShape("RECTANGLE");
		  //call draw method of Rectangle
		  shape2.draw();
		 }
}
