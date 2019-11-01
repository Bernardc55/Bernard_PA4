package com.company;

import java.util.*;
import java.io.*;

public class DuplicateCounter {
    //Hashmap for keeping track of the words and their counts
    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    //constructor for Duplicate Counter
    public DuplicateCounter(){

    }

    //counts the words in a given text file
    public void count(String dataFile){
        String word;
        //catching all errors that may occur
        try {
            FileInputStream fileInputStream = new FileInputStream(dataFile);
            Scanner scnr = new Scanner(fileInputStream);
            //continue looping as long as the file continues
            while(scnr.hasNext()){
                //reads in the next word
                word = scnr.next();
                //checks to see if its in the map and performs the appropriate action
                if(wordCounter.containsKey(word)){
                    wordCounter.replace(word, wordCounter.get(word)+1);
                }
                else{
                    wordCounter.put(word, 1);
                }
            }
            //closing the readers
            scnr.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write all words and their counts to outputFile
    public void write(String outputFile){
        try {
            //Creates fileWriter for the output file
            File file = new File(outputFile);
            FileWriter fileWriter = new FileWriter(file);
            //writes each key, its count and then goes to the next line
            for(String key : wordCounter.keySet()) {
                fileWriter.write(key + " " + wordCounter.get(key) + System.getProperty("line.separator"));
            }
            //closes the writer
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
