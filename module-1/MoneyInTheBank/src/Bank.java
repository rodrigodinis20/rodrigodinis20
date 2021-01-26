import java.awt.*;

public class Bank {


    private int balance;

    public Bank(int balance) {

        this.balance = balance;

    }


        public void receive(int amount){
            this.balance = this.balance + amount;
            System.out.println("Your new balance is: " + this.balance);
        }

        public void pay(int amount){
            this.balance = this.balance - amount;
            System.out.println("Your new balance is: " + this.balance);
        }

        public int checkBalance(){
            return this.balance;
        }
}


