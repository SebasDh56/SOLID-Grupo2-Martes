package LSP.Post;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal fish = new Fish();

        dog.makeSound();
        fish.makeSound();

        // Solo caminadores
        Walkable walkingDog = new Dog();
        walkingDog.walk();

        // Fish no implementa Walkable → No error, no excepciones
    }
}