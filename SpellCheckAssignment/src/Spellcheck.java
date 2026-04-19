	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	public class Spellcheck {

	    public static void main(String[] args) {

	        if (args.length < 1) {
	            System.err.println("Error: please provide the path to a dictionary file.");
	            System.err.println("Usage: java SpellCheck <dictionary-file>");
	            return;
	        }

	        File dictFile = new File(args[0]);
	        if (!dictFile.exists()) {
	            System.err.println("Error: dictionary file \"" + args[0] + "\" not found.");
	            return;
	        }

	        Treeset<String> dictionary = new Treeset<>();

	        try (Scanner fileScanner = new Scanner(dictFile)) {
	            while (fileScanner.hasNext()) {
	                String word = fileScanner.next();
	                dictionary.insert(word);
	            }
	        } catch (FileNotFoundException e) {
	            System.err.println("Error reading dictionary file: " + e.getMessage());
	            return;
	        }

	       
	        System.out.println("Loaded the words into a tree with height = " + dictionary.height());

	        Scanner inputScanner = new Scanner(System.in);

	        while (inputScanner.hasNextLine()) {
	            String line = inputScanner.nextLine();

	            String[] tokens = line.trim().split("\\s+");

	            for (String token : tokens) {
	                if (token.isEmpty()) {
	                    continue;
	                }

	               
	                if (token.equals("END")) {
	                    inputScanner.close();
	                    return;
	                }

	                if (!dictionary.contains(token)) {
	                    System.out.println(token + " is spelled wrong!");
	                }
	            }
	        }

	        inputScanner.close();
	    }
	}
