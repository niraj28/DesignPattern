package abstractFactoryPattern;

interface GUIFactory {
	/*
	 * Abstract Factory Pattern

		Creates families of related objects.
		
		Idea
		Instead of one factory creating one product type, 
		an abstract factory creates multiple related products.
		
		Example
		Suppose you have:	
		Button
		Checkbox
		
		And two UI themes:		
		Windows
		Mac
	 */
    Button createButton();
    Checkbox createCheckbox();
}