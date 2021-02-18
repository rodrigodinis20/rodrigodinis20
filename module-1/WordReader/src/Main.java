public class Main {

    public static final String FILE_PATH = "";

    public static void main(String[] args) {

        WordReader wordReader = new WordReader(FILE_PATH);

        for (String word : wordReader) {
            System.out.println(word);
        }
    }
}
