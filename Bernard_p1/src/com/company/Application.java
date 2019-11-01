package com.company;

public class Application {
    public static void main(String[] args) {
        //creating duplicate Remover
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        //constant values for the input and output so you can customize as neccessary
        final String inputFile = "problem1.txt";
        final String outputFile = "unique_words.txt";
        //calls the 2 functions
        duplicateRemover.remove(inputFile);
        duplicateRemover.write(outputFile);
        //lets the user know that it is finished
        System.out.println("Finished");
    }
}
