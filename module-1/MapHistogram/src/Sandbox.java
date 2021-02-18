public class Sandbox {

    public static void main(String[] args) {
        WordHistogram wh = new WordHistogram("quantas vezes uma palavra se repete quando se repete uma palavra n vezes");

        for (String word : wh) {
            System.out.println(word + " " + wh.get(word));

        }
    }
}
