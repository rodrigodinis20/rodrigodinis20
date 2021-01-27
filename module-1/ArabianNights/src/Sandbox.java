public class Sandbox {

    public static void main(String[] args) {

        MagicLamp ml1 = new MagicLamp(5);

        //Genies genie = new Genies(5);


        Genies genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();


        /*
        genie.grantWish();
        genie.grantWish();

         */
        Demon demon = (Demon) genie;
        ///HTF to turn a Genie into a Demon???????
        ml1.recharge(demon);
        demon.grantWish();


    }
}
