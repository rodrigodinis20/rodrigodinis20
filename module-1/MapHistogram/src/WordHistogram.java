import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogram implements Iterable<String> {

    private Map<String, Integer> map;


    public WordHistogram(String string) {

        map = new HashMap<>();

        String[] splitString = string.split(" ");
        for (String word : splitString) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);

        }
    }

    public Integer get(String word) {
        return map.get(word);

    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
