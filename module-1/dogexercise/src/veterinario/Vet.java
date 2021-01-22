package veterinario;

public class Vet {
    public static void main(String[] args) {
        Doggo dog1 = new Doggo("Good boi", 2, "white", "Corgi", "male");
        Doggo dog2 = new Doggo("big boi", 4, "brown", "labrador", "female");

        System.out.println("This dog's name is " + dog1.getName() + ", it is " + dog1.getAge() + " years old");

    }
}