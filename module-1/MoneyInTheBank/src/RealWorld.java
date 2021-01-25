public class RealWorld {

    public static void main(String[] args){


        Bank bank1 = new Bank( 500);
        Bank bank2 = new Bank(300);

        People p1 = new People("Alberto", bank1, 500);
        People p2 = new People("Albertina", bank2, 0);


        /*People p2 = new People("Albertina");
        p2.setName("Albertina");


         */

        p1.pay(200);
        System.out.println(p1.checkBalance());
        System.out.println(p2.checkBalance());
    }
}
