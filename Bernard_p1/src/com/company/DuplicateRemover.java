package com.company;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {
    //array list to hold unique words
    private ArrayList<String> uniqueWords = new ArrayList<>();

    //constructor for Duplicate Remover
    public DuplicateRemover(){

    }

    //remove all duplicate words from dataFile
    public void remove(String dataFile){
        //variables needed
        String word;
        int i;
        boolean isUnique;
        //tries to do the operation, catching any errors
        try {
            //sets a scanner to scan the file
            FileInputStream fileInputStream = new FileInputStream(dataFile);
            Scanner scnr = new Scanner(fileInputStream);
            //continues as long as the file continues
            while(scnr.hasNext()){
                //reset isUnique
                isUnique = true;
                //reads the next word from the file
                word = scnr.next();
                //determines if it is unique
                for(i = 0; i < uniqueWords.size(); i++){
                    if(word.equals(uniqueWords.get(i))){
                        isUnique = false;
                    }
                }
                //if it is, then it gets added to the list
                if(isUnique){
                    uniqueWords.add(word);
                }
            }
            //closes all inputs
            scnr.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write each unique words to output file, overwrite it if it already exists
    public void write(String outputFile){
        //tries to do the process, catching if there is any issues
        try {
            File file = new File(outputFile);
            FileWriter fileWriter = new FileWriter(file);
            //prints out each unique word to the text file
            for(int i = 0; i < uniqueWords.size(); i++) {
                fileWriter.write(uniqueWords.get(i) + " ");
            }
            //closes the writer
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
