package edu.frcc.j.SentimentAnalysis;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SentimentAnalyzer {

    public static void main(String[] args) {
        HashMap<String, Integer> sentimentMap = new HashMap<>(100);

        try {
            Scanner fileScanner = new Scanner(new File("sentiments.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Each line is: word<tab>value  (or two words<tab>value)
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    int sentiment = Integer.parseInt(parts[1].trim());
                    sentimentMap.put(word, sentiment);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: sentiments.txt not found.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");

        int totalSentiment = 0;
        int wordCount = 0;
        String prevWord = "";   
        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.trim().equals("END")) break;

            String[] words = line.replaceAll("[^a-zA-Z ]", "")
                                 .toLowerCase()
                                 .split("\\s+");

            for (String word : words) {
                if (word.isEmpty()) continue;

                wordCount++;

                Integer val = sentimentMap.get(word);
                if (val != null) {
                    totalSentiment += val;
                }

                if (!prevWord.isEmpty()) {
                    String phrase = prevWord + " " + word;
                    Integer phraseVal = sentimentMap.get(phrase);
                    if (phraseVal != null) {
                        totalSentiment += phraseVal;
                    }
                }

                prevWord = word;
            }
            prevWord = "";
        }

        System.out.println("\nWords: " + wordCount);
        System.out.println("Sentiment: " + totalSentiment);
        System.out.printf("Overall: %.2f%n", (double) totalSentiment / wordCount);
    }
}
