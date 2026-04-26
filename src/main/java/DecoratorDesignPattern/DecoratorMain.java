package DecoratorDesignPattern;

public class DecoratorMain {
	/*
	 * The Decorator Design Pattern is a structural pattern 
	 * that lets you add new behavior to an object dynamically without changing its original code.
		🧠 Core Idea	
		Instead of creating many subclasses, you wrap the object with another object (decorator) that adds extra functionality.	
		👉 Think: “Wrap → Add behavior → Keep original intact”
		
		🍕 Real-life example (easy to remember)
		
		You order a pizza:	
		Base pizza = ₹200
		Add cheese = +₹50
		Add olives = +₹70
		
		You don’t create new classes like:	
		CheesePizza
		CheeseOlivePizza
		
		Instead, you decorate the base pizza.
	* 
	 */
	
    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }

}
