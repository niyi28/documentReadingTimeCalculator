package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ReadFile {

    private static List<String> readFile(){
        List<String> words = new ArrayList<>();
        String path = "src/com/company/document.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String [] x = line.split(" ");
                words.addAll(Arrays.asList(x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
    public static List<String> validateWords(){
        List<String> words = readFile();
        List<String> validWords = new ArrayList<>();

        for (String word : words){
            if (word.matches("[a-zA-Z]+") || word.length() > 1){
                validWords.add(word);
            }
        }
        return validWords;
    }

    public static List<String> readUrl() throws Exception {
        String website = "https://www.bmbf.de/bmbf/en/home/_documents/west-africa-can-become-the-cli-energy-powerhouse-of-the-world.html";
        URL url = new URL(website);
        URLConnection yc = url.openConnection();
        List<String> lastIndexString = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                lastIndexString.add(inputLine);
        }

        return lastIndexString;
    }
}
