package org.academiadecodigo.bootcamp.fileanalyser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyser {


    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: FileAnalyser <source_file> <destination_file>");
            System.exit(1);
        }

        try {

            System.out.println("Number of Unique Word Occurrences in First File: " + countUniqueWords(args[0]));
            System.out.println("Number of Unique Word Occurrences in Second File: " + countUniqueWords(args[1]));

            int numberOfLongestWords = 10;

            System.out.println("\nThe " + numberOfLongestWords + " longest words in the first file are:\n");
            getLongestWords(args[0], numberOfLongestWords).forEach(System.out::println);

            System.out.println("\nThe " + numberOfLongestWords + " longest words in the second file are:\n");
            getLongestWords(args[1], numberOfLongestWords).forEach(System.out::println);

            List<String> commonWords = getCommonWords(args[0], args[1]).collect(Collectors.toList());
            System.out.println("\nThere are " + commonWords.size() + " words with over 4 characters in common" +
                " between the two files, ordered by length and alphabetically:\n");

            commonWords.forEach(System.out::println);

            // Optionals

            int length = 10;

            System.out.println("\nThe first word on the file with more than " + length + " letters is:\n");

            Optional<String> optional = getFirstWordLongerThan(args[0], length);

            System.out.println(optional.orElse("No words longer than " + length));

            // equivalent to
//            System.out.println(getFirstWordLongerThan(args[0], length).orElse("No words longer than " + length));

            // as well as

//            if (optional.isPresent()) {
//                System.out.println(optional.get());
//            } else {
//                System.out.println("No words longer than " + length);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Stream<String> getWords(String fileName) throws IOException {

        return Files.lines(Paths.get(fileName))
            .map(line -> line.split("\\W+"))
            .flatMap(Arrays::stream);
    }

    private static long countUniqueWords(String fileName) throws IOException {

        return getWords(fileName)
            .distinct()
            .count();
    }

    private static Stream<String> getLongestWords(String fileName, int numberOfWords) throws IOException {

        return getWords(fileName)
            .sorted(Comparator.comparingInt(String::length).reversed())
            .map(String::toLowerCase)
            .distinct()
            .limit(numberOfWords);
    }

    private static Stream<String> getCommonWords(String firstFile, String secondFile) throws IOException {

        int minLength = 4;

        Stream<String> first = getWords(firstFile)
            .filter(word -> word.length() > minLength)
            .distinct();

        Set<String> uniqueWordsInSecond = getWords(secondFile)
            .collect(Collectors.toSet());

        return first
            .filter(uniqueWordsInSecond::contains)
            //.sorted(Comparator.naturalOrder());
            .sorted(Comparator.comparingInt(String::length).reversed());
    }

    private static Optional<String> getFirstWordLongerThan(String filename, int length) throws IOException {

        return getWords(filename)
            .filter(word -> word.length() > length)
            .findFirst();
    }

}

