package RandomGame;

public class RealGame {
   public static void main (String[] args){

      Player benny = new Player();
      benny.setName("Alberto");

      Player alex = new Player();
      alex.setName("Albertino");

      Game guessTheNumber = new Game(benny, alex);

   }
}
