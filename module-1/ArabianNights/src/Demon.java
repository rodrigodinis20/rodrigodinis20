public class Demon extends Genies{

    @Override
    public boolean grantWish() {

        super.grantWish();
        if (recycled == false)
        System.out.println("Your wish has been granted.");

        if(recycled == true) {
            System.out.println("I have been recycled, you fool!");

        }
        return false;
    }

    public Demon(int wishes){
        super(1);


    }

    private boolean recycled = false;

    public boolean getRecycled(){
        return this.recycled;
    }

    public void setRecycled() {
        this.recycled = recycled;
    }

    public boolean recyle(){
        return recycled=true;
    }
}
