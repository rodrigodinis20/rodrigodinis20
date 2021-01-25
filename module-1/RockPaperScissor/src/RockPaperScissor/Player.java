package RockPaperScissor;

public class Player {

    private String name;
    private int score;


    public HandType pickHand(){

        int index = (int) Math.floor(Math.random()*3);
        return HandType.values()[index];
    }

    public void setName(String name){
        this.name=name;
        this.score=0;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void win(){
        this.score++;
    }
}
