public class Genies {

    private int wishes;
    private int wishesGranted;

    public Genies (int wishes) {
        this.wishes = wishes;

    }

    public void setWishes(int limit) {
        this.wishes = wishes;

    }

    public int getWishes() {
        return wishes;

    }

    public void setWishesGranted(int wishesGranted) {
        this.wishesGranted = wishesGranted;

    }

    public int getWishesGranted() {
        return wishesGranted;

    }

    public boolean grantWish() {
        if (wishesGranted < wishes) {
            wishesGranted++;
            return true;

        }

        return false;

    }

}
