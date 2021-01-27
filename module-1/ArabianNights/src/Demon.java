public class Demon extends Genies{

    @Override
    public boolean grantWish() {

        super.grantWish();
        System.out.println("Your wish has been granted.");

        if(recycled = true) {
            System.out.println("I have been recycled, you fool!");
            return false;
        }
        return false;
    }

    public Demon(int wishes){
        super(1);


    }

    private boolean recycled = false;

    public void setRecycled() {
        this.recycled = recycled;
    }

    public boolean recyle(){
        return recycled=true;
    }
}
