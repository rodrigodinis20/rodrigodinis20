public class MagicLamp {

    private int rubs;
    private int totalRubs;
    private int totalGenies;

    public MagicLamp(int totalGenies) {
        this.totalGenies = totalGenies;

    }

    public void setRubs(int rubs) {
        this.rubs = rubs;
    }

    public int getRubs() {
        return rubs;
    }

    /*public void setTotalGenies(int totalGenies) {
        this.totalGenies = totalGenies;
    }

     */

    public int getTotalGenies() {
        return totalGenies;
    }

    public int getTotalRubs() {
        return totalRubs;
    }

    /*public void setTotalRubs(int totalRubs) {
        this.totalRubs = totalRubs;
    }

     */

    public Genies rub() {
        if (rubs < totalGenies) {
            rubs++;


            if (rubs % 2 == 0) {
                System.out.println("New friendly genie has been summoned.");
                return new Friendly(5);


            }
            System.out.println("New grumpy genie has been summoned.");
            return new Grumpy(5);
            //return new Demon();

        }
        System.out.println("New recyclable demon has been summoned.");
        return new Demon(5);
    }

    public void recharge(Demon demon) {
        if (rubs == totalGenies) {

            demon.recyle();
            rubs =0;
            System.out.println("The demon has been recycled.");
            System.out.println("You can now rub the lamp " + getTotalGenies() + " more times!");


        }
        System.out.println("I have already been recycled, leave me alone!");
    }
}