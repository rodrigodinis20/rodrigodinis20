package org.academiadecodigo.arabiannights.genie;

public class Demon extends Genie{

    private boolean isSacrificed;

    public Demon(int maxWishes){
        super(maxWishes);
    }

    //true - vai conceder desejo
    //false - nao vai conceder
    @Override
    public boolean hasWishesLeft(){
       return !isSacrificed;
    }

    public void sacrifice(){
        this.isSacrificed = true;
    }

    public boolean isSacrificed(){
        return isSacrificed;
    }

    @Override
    public String toString(){
        return isSacrificed? "no more wishes":"I've the best wishes";
    }

}
