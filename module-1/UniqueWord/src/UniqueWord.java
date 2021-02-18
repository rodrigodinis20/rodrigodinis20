
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueWord implements Iterable<String> {

    private Set<String> words;

    public UniqueWord(String word) {

        // the fancy way;
        // Collections.addAll(words, word.split(" "));

        words = new HashSet<>();

        String[] splitWords = word.split(" ");

        for (String str : splitWords) {
            words.add(str);

        }

    }

    @Override
    public Iterator<String> iterator() {
        return words.iterator();

    }

}
