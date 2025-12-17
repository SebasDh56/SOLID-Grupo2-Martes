package ISP.post;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Probando Phone (recargable) ===");
        Switchable phoneAsSwitchable = new Phone();
        Chargeable phoneAsChargeable = (Chargeable) phoneAsSwitchable; // Casteo seguro

        phoneAsSwitchable.turnOn();
        phoneAsChargeable.charge();
        phoneAsSwitchable.turnOff();

        System.out.println("\n=== Probando DisposableCamera (no recargable) ===");
        Switchable camera = new DisposableCamera();

        camera.turnOn();
        camera.turnOff();
        // No intentamos llamar a charge() → ¡no hay excepción!
        
        System.out.println("\nEjecución completada sin excepciones.");
    }
}