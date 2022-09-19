import java.util.*;
import java.io.*;

/**
 * Gutenberg.org
 *
 * @author Programmer
 */
public class TextAnalyzer {

    private static Map<Character, Integer> letterMap;
    private static Map<String, Integer> wordMap;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Read file as list of lines
        final String fileName = "data.txt"; 
        
        // Process the file
        ArrayList<String> lines = loadText(fileName); 
        
        // build frequency
        buildFrequency(lines); 
        
        // Now print frequncies
        // words
        System.out.println("Word Frequncy");
        System.out.printf("%-20s %s%n", "Word", "Frequency");
        
        // Streams
        wordMap.forEach( (key, value) -> {
            System.out.printf("%-20s %d%n", key, value);
        } );
        
        
        
        // Letters
        System.out.println("Letter Freuqncy");
        System.out.printf("%n%n%-20s %s%n", "Letter", "Frequency");
        letterMap.forEach( (key, value) -> {
            System.out.printf("%-20c %d%n", key, value);
        } );
    }
    
    /**
     * Function to build frequency of each letter. 
     * 
     * @param lines
     * @return map of letters with frequencies 
     */
    public static void buildFrequency(ArrayList<String> lines) {
        letterMap = new TreeMap<>(); 
        wordMap = new TreeMap<>();
        
        for(String line: lines) {
            // remove punctuations, extra spaces everything
            
            String words [] = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
            
            // First iterate word array
            for(String w: words) {
                
                if(!(w.trim().isEmpty())) {
                    if(wordMap.get(w) == null) {
                        wordMap.put(w, 1);
                    } else {
                        wordMap.put(w, wordMap.get(w)+1);
                    }
                
                    for(int i=0; i<w.length(); i++) {

                        char c = w.charAt(i); 
                        //if(!Character.isSpaceChar(c)) {
                            if(letterMap.get(c) == null) {
                                letterMap.put(c, 1);
                            } else {
                                letterMap.put(c, letterMap.get(c) + 1);
                            }
                        //}
                    }
                }
            }
        }
    }
    
    /**
     * read file line by line, store into array list
     * 
     * @param fileName to read
     * @return list of lines
     */
    public static ArrayList<String> loadText(String fileName) {
        ArrayList<String> lines = new ArrayList<>(); 
        
        try{
            File file = new File(fileName); 
            Scanner reader = new Scanner(file); 
            
            while(reader.hasNextLine()) {
                
                lines.add(reader.nextLine());
            }
            
            reader.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return lines; 
    }
    
}
