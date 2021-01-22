package RockPaperScissor;

public class Player {

    private String name;

    public HandType pickHand(){

        int index = (int) Math.floor(Math.random()*3);
        return HandType.values()[index];
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
