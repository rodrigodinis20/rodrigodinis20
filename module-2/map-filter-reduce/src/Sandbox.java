import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sandbox {

    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, "
        + "I hope that someone garbage gets my message in a garbage bottle.";

        String[] words = message.split(" ");

        Optional<String> result = Stream.of(words)
                .filter(w -> !w.equals("garbage"))
                .map(String::toUpperCase)
                .reduce((acc, w) -> acc + " " + w);

        result.ifPresent(System.out::println);
    }
}
