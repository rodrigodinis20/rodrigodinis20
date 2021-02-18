import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String>{

    private String text;

    public WordReader(String text) {
        this.text = text;

    }

    private String[] readFileByLine(String text) throws IOException {
        FileReader reader = new FileReader("text");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = " ";
        String[] words = new String[5];

        try {
            int i = 0;

            while ((bufferedReader.readLine()) != null) {
                words[i] = bufferedReader.readLine();
                i++;

            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;

    }



    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            String line;
            String[] words;
            int counter = 0;

            @Override
            public boolean hasNext() {

                return false;
            }

            @Override
            public String next() {
                ++counter;
                return words[counter];
            }
        };
    }
}
