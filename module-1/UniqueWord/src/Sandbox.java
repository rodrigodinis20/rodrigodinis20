public class Sandbox {

    public static final String STRING = "test test teste abc abc";

    public static void main(String[] args) {

        UniqueWord wc = new UniqueWord(STRING);

        for (String word : wc) {
            System.out.println(word);
        }
    }
}
