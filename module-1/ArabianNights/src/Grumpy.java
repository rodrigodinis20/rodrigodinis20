public class Grumpy extends Genies {

    @Override
    public boolean grantWish() {

        super.grantWish();
        if (getWishesGranted() == 1) {
            System.out.println("Is this really what you're gonna waste your wish on?");
            return false;
        }
        System.out.println("No more wishes for you, fool!");
        return true;

    }

    public Grumpy(int wishes){
        super(5);
    }

}
