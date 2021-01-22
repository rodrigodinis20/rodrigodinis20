package RandomGame;

public class Player {
    private String name;

    public int pickNumber() {
        return (int) Math.ceil(Math.random()*10);
    }

    public void setName(String name){
        this.name=name;
    }


    public String getName(){
        return this.name;
    }

}

