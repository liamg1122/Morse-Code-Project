import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * The MorseCodeConverter class gives static methods to convert Morse code to English.
 * 
 * @author Liam Ghershony.
 */

public class MorseCodeConverter {
	
    /**
     * Converts from Morse Code to english from String.
     * 
     * @param morse -- The Morse code to be converted.
     * @return The English converted from Morse
     */
	
	public static String convertToEnglish(String morse) {
		MorseCodeTree morseTree = new MorseCodeTree();
		StringBuilder sb = new StringBuilder();
		String[] words = morse.split("/");
		for(String word: words) {
			String[] letters = word.split(" ");
			for(String letter: letters) {
				sb.append(morseTree.fetch(letter));
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
		return sb.toString().trim();
	}
	
	
	
	   /**
     * Converts a file containing Morse code into English.
     * 
     * @param file -- The file with Morse.
     * @return The English text converted from the Morse in the file.
     * @throws FileNotFoundException
     */
	
	
	public static String convertToEnglish(File file) throws FileNotFoundException {
		
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String ln;
			while((ln = br.readLine()) != null) {
				sb.append(ln).append(" / ");
			}} catch (FileNotFoundException e) {
		        throw new FileNotFoundException("File not found: " + e.getMessage());
		    } catch (IOException e) {
		        throw new RuntimeException("Error reading file: " + file.getAbsolutePath(), e);
		    }
		
		return convertToEnglish(sb.toString().trim());
		
		}
	
	 /**
     * Creates a string representation of the Morse code tree.
     * 
     * @return A string with all the letters in the Morse code tree.
     */
	
	public static String printTree() {
		MorseCodeTree morseTree = new MorseCodeTree();
		
		ArrayList<String> morseArray = morseTree.toArrayList();
		return String.join(" ", morseArray);

	}
		
	
	


}
