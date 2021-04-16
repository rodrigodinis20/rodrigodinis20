import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyzer {

    public static void main(String[] args) {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        fileAnalyzer.readAndCount("resources/file1.txt");
        fileAnalyzer.readAndCount("resources/file2.txt");
        fileAnalyzer.findingLongerThan("resources/file1.txt", 5);
        fileAnalyzer.findingLongerThan("resources/file2.txt", 5);
        fileAnalyzer.getLongestWord("resources/file1.txt");
        fileAnalyzer.getLongestWord("resources/file2.txt");
        fileAnalyzer.findCommonWords("resources/file1.txt", "resources/file2.txt");

    }

    public void readAndCount(String string) {
        try {

            long wordCountText = Files.lines(Paths.get(string))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .distinct()
                    .count();

            System.out.println(wordCountText);

        } catch (IOException exception) {
            System.out.println("ERROR: " + exception);
        }
    }

    public void findingLongerThan(String string, int limit) {
        try {
            Files.lines(Paths.get(string))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.length() > limit)
                    .findFirst()
                    .ifPresent(System.out::println);

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void getLongestWord(String string) {
        try {
            Files.lines(Paths.get(string))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .reduce((acc, word) -> {
                        if (acc.length() > word.length())
                            return acc;
                        else return word;
                    })
                    .ifPresent(System.out::println);

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void findCommonWords(String text1, String text2) {
        try {
            List<String> list = Files.lines(Paths.get(text1))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

            Files.lines(Paths.get(text2))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .map(String::toLowerCase)
                    .filter(list::contains)
                    .distinct()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

}

