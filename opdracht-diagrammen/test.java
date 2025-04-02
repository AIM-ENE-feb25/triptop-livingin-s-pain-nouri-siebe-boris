// Interface die het contract definieert
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implementatie 1: Creditcardbetaling
class CreditCardPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// Implementatie 2: PayPal-betaling
class PayPalPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Klasse die gebruik maakt van de interface
class CheckoutService {
    private PaymentProcessor paymentProcessor;

    // Dependency Injection via de constructor
    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.processPayment(amount);
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        PaymentProcessor creditCard = new CreditCardPayment();
        PaymentProcessor paypal = new PayPalPayment();

        CheckoutService checkout1 = new CheckoutService(creditCard);
        checkout1.checkout(100.0);

        CheckoutService checkout2 = new CheckoutService(paypal);
        checkout2.checkout(200.0);
    }
}
