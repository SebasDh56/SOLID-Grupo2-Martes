package LSP.Post;

public class Dog  implements Animal, Walkable {

    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void walk() {
        System.out.println("Dog is walking.");
    }
}