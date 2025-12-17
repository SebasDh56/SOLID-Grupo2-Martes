package DIP.Post;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    // Inyección de dependencia por constructor
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}