package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
public class WordDocumentReader {

    public static List<String> wordReader(){
        File file = null;
        List<String> words = new ArrayList<>();
        WordExtractor extractor = null;
        try{
            /*File myObj = new File( "src/com/company/test_cover_letter.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                words.add(myReader.nextLine());
               *//* String data = toUpperCase();*//*
            }*/
            file = new File("src/com/company/test_cover_letter.docx");
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            HWPFDocument document = null;
            try {
                document = new HWPFDocument(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    words.add(fileData[i]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return words;
    }

}

