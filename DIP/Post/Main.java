package DIP.Post;

public class Main {
    public static void main(String[] args) {
        double amount = 150.0;

        System.out.println("=== Demostración de múltiples métodos de pago ===\n");

        // Tarjeta de crédito
        PaymentProcessor creditProcessor = new PaymentProcessor(new CreditCardPayment());
        creditProcessor.makePayment(amount);

        // PayPal
        PaymentProcessor paypalProcessor = new PaymentProcessor(new PayPalPayment());
        paypalProcessor.makePayment(amount);

        // Criptomoneda
        PaymentProcessor cryptoProcessor = new PaymentProcessor(new CryptoPayment());
        cryptoProcessor.makePayment(amount);
    }
}