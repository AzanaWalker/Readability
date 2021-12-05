package com.company;

import java.math.RoundingMode; import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter text here: "); // setting up for text to be entered for analysis
        String text = keyboard.nextLine();

        int lettercount = 0;   // variable init
        int wordcount = 1;


        for (int i = 0; i < text.length(); i++)
        {
            if (Character.isLetter(text.charAt(i)))    // count amt of letter
                lettercount++;                         // incrementing letter count to lettercount
        }

        for (int i = 0; i < text.length() - 1; i++)
        {
            if ((text.charAt(i) == ' ') && (text.charAt(i + 1) != ' '))  // count amt of words --> using && rather than ||
                                                                        // to ensure that each word get properly accounted for
            {
                wordcount++;  // incrementing word count to wordcount
            }
        }
        int sentencecount = text.split("[.!?]+").length;   // setting up parameters (punctuation) for separating the sentences

        System.out.println(lettercount + " letter(s)");        // these three lines are printing the counts set to the letter,word
        System.out.println(wordcount + " word(s)");            // sentence variables
        System.out.println(sentencecount + " sentence(s)");



        float L = 1.0f * lettercount / wordcount * 100;      // using 1.0f instead of 1.0 to ensure the number is taken as a float
        float S = 1.0f * sentencecount / wordcount * 100;    // then dividing to find the L and S values

        int grade = (int) Math.round(0.0588 * L - 0.296 * S - 15.8);  // calculates the reading level

        if (grade < 1)
        {
            System.out.println("Before Grade 1");
        }
        else if (grade >= 16)
            System.out.println("Grade 16+");
        else
            System.out.println("Grade: " + grade);  // if the grade does not satisfy either of those criteria, the program
                                                    // will just print the grade

    }
}