package com.sahaj.questionanswers.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static String readFileAsString(String paragraphFilePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(paragraphFilePath))).replaceAll("\\r\\n", " ");
    }

    public static List<String> readAllLines(String questionFilePath) throws IOException {
        return Files.readAllLines((Paths.get(questionFilePath)));
    }
}
