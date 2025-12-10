package OCP.Post;

public class Main {
    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");

        // Nueva notificación adicional sin modificar código existente
        Notification fax = new Notification() {
            @Override
            public void send(String message) {
                System.out.println("Sending Fax: " + message);
            }
        };

        service.sendNotification(fax, "Hello via Fax!");
    }
}