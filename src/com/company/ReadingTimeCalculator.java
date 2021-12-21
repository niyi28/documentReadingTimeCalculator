package com.company;

import java.util.List;

public class ReadingTimeCalculator {

    public static String calculateReadingTime(){
        List<String> words = ReadFile.validateWords();
        int averageReadingTimePerMinute = 275;
        float timeToReadWord =  (float) words.size() /averageReadingTimePerMinute;

        return "" + timeToReadWord + " min(s)";
    }
}
