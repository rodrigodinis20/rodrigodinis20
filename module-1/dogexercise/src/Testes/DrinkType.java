package Testes;

public enum DrinkType {
    BEER(-2),
    HONEYMEAD(15),
    GIN_TONIC(4);

    private int temperature;

    DrinkType(int temperature){

        this.temperature = temperature;
    }

    public int getTemperature(){

        return temperature;
    }

    public void drink(){
        System.out.println("This glass of " + this.name() + " is empty.");
    }
}
