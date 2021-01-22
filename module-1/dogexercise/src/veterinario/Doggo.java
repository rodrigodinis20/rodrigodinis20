package veterinario;

public class Doggo {
    private String name;
    private String gender;
    private String race;
    private String color;
    private int age;

    public Doggo(String name, int age, String color, String race, String gender) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.race = race;
        this.gender = gender;
    }

    public void updateAge(int age){
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getColor() {
        return this.color;
    }

    public String getRace() {
        return this.race;
    }

    public String getGender() {
        return this.gender;
    }

}
/*public void updateAge(int age){
    this.age = age;
}
//
private static boolean on;

public void isOn(){
    if(on){
        System.out.println("Ta ligado");
    } else {
        System.out.println("Desligado");
    }
}

public void turnOff(){
    on = false;
}

*/



