package abstractFactoryPattern;

public class AbstractFactoryMain {
	/*
	 * Abstract Factory Pattern is a design pattern 
	 * that provides an interface for creating families of related or dependent objects without specifying 
	 * their concrete classes. 
	 * 
	 * It allows you to create objects that belong to a particular family without having to know the specific classes 
	 * that implement those objects. 
	 * 
	 * This pattern is often used when you want to create a set of related objects that must be used together, 
	 * such as GUI components for different operating systems (e.g., Windows and Mac). 
	 * By using an abstract factory, you can ensure that the correct types of objects are created for each family, 
	 * and you can easily switch between different families without changing the client code.
	 */
			public static void main(String[] args) {
		GUIFactory factory = new WindowsFactory();
		Button button = factory.createButton();
		Checkbox checkbox = factory.createCheckbox();
		button.paint();
		checkbox.paint();

		factory = new MacFactory();
		button = factory.createButton();
		checkbox = factory.createCheckbox();
		button.paint();
		checkbox.paint();
	}

}
