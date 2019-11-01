package com.company;

public class Application {
    public static void main(String[] args) {
        //constructor for the duplicate Counter
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        final String inputFile = "problem2.txt";
        final String outputFile = "unique_word_counts.txt";
        //performs the tasks
        duplicateCounter.count(inputFile);
        duplicateCounter.write(outputFile);

        //lets the user know that the tasks have been completed
        System.out.println("Finished");
    }
}
