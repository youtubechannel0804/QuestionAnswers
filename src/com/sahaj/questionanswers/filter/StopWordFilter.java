package com.sahaj.questionanswers.filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Replace all words from Stop word file.
 */
public class StopWordFilter implements TokenFilter {

    public static final String ENGLISH_STOPWORDS_TXT = "english_stopwords.txt";
    private static List<String> stopwords;

    @Override
    public String execute(String text) {
        try {
            loadStopwords();
            return removeAll(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Replace all words from Stop word List.
     *
     * @param text
     * @return
     */
    private String removeAll(String text) {
        ArrayList<String> allWords =
                Stream.of(text.split(" "))
                        .collect(Collectors.toCollection(ArrayList<String>::new));
        allWords.removeAll(stopwords);
        return allWords.stream().collect(Collectors.joining(" "));
    }

    /**
     * load words from a file
     *
     * @throws IOException
     */
    private void loadStopwords() throws IOException {
        stopwords = Files.readAllLines(Paths.get(ENGLISH_STOPWORDS_TXT));
    }
}
