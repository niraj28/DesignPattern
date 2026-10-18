package strategyPattern;

public class PaymentMain {
	/*
	 * The Strategy Pattern is a behavioral design pattern where you define a family of algorithms, 
	 * put each one in a separate class, 
	 * and make them interchangeable at runtime.
	 * 
	 * 
	 * Idea
  		You have:
		Strategy interface → common behavior
		Concrete strategies → different implementations
		Context → uses one strategy
	 * 
	 */
	
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.makePayment(1000);

        context.setPaymentStrategy(new UpiPayment());
        context.makePayment(500);

        context.setPaymentStrategy(new WalletPayment());
        context.makePayment(300);
    }

}
