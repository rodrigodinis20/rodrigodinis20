public class Bank {


    private int balance;

    public Bank(int balance) {

        this.balance = balance;

    }


        /*public int getBalance() {
            return this.balance;
        }

         */

        public void receive(int amount){
            this.balance = this.balance + amount;
        }

        public void pay(int amount){
            this.balance = this.balance - amount;
        }

        public int checkBalance(){
            return this.balance;
        }
}


