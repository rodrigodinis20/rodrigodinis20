public class People {

    private String name;
    private Bank bank;
    private int balance;
    //private int balance;

    public People(String name, Bank bank, int balance){
        this.name = name;
        this.bank = bank;
        this.balance = balance;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return this.bank;
    }


    public void receive(int amount){
        this.balance = this.balance + amount;
        System.out.println("Your new balance is: " + this.balance);
    }

    public void pay(int amount){
        this.balance = this.balance - amount;
        System.out.println("Your new balance is: " + this.balance);
    }

    public void checkBalance(){
        System.out.println("Your current balance is: " + this.balance);
    }

    /*public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public int Receive(){
        return this.balance + Receive();
    }

    public int Pay(){
        return this.balance - Pay();
    }*/

}
