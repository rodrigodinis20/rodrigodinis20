public class Sandbox {

    public static void main(String[] args) {

        MagicLamp ml1 = new MagicLamp(5);
        MagicLamp ml2 = new MagicLamp(2);
        //Genies genie = new Genies(5);


        Genies genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();
        genie = ml1.rub();





        genie.grantWish();
        genie.grantWish();
        genie.grantWish();
        genie.grantWish();


        Demon demon = (Demon) genie;

        ///HTF to turn a Genie into a Demon???????
        demon.grantWish();
        ml1.recharge(demon);
        genie.grantWish();
        genie.grantWish();
        ml1.recharge(demon);

        /*genie = ml2.rub();
        genie = ml2.rub();
        genie = ml2.rub();

        genie.grantWish();

        //ml2.recharge(demon);

         */






    }
}
