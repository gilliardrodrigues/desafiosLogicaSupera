package desafio4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthChallenge {

	private static boolean allUpperCase(String str) {
		
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c != ' ' && !Character.isUpperCase(c))
	            return false;
	    }
	    return true;
	}
	
	private static String readSentence(Scanner scanner, int lowerLimit, int upperLimit) throws IOException {
        
		String sentence = "";
        do {
        	sentence = scanner.nextLine();

            if (sentence.length() < lowerLimit || sentence.length() > upperLimit || !allUpperCase(sentence)) {
                System.out.println("The number of characters is outside the valid range. Try again:");
            }
        } while (sentence.length() < lowerLimit || sentence.length() > upperLimit || !allUpperCase(sentence));

        return sentence;
    }
	
	private static int readPositiveNumber(Scanner scanner) throws IOException {
        
		int number;
        do {
            number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("The number must be positive. Try again:");
            }
        } while (number <= 0);

        return number;
    }
	
	private static String reverseString(String str) {
		
		return new StringBuilder(str).reverse().toString();
	}
	
	public static String decryptSentence(String sentence) {
		
		var half = sentence.length() / 2;
		
	    var encryptedFirstHalf = sentence.substring(0, half);
	    var encryptedSecondHalf = sentence.substring(half);
	    
	    var decryptedFirstHalf = reverseString(encryptedFirstHalf);
	    var decryptedSecondHalf = reverseString(encryptedSecondHalf);
	    
	    var decryptedSentence = decryptedFirstHalf + decryptedSecondHalf;
	    
	    return decryptedSentence;
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			// Reading the number of sentences:
			int n = readPositiveNumber(scanner);
			scanner.nextLine();
			// Reading the encrypted sentences and storing in a list:
			List<String> encryptedSentences = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				encryptedSentences.add(readSentence(scanner, 2, 100));
			}
			scanner.close();
			
			// Decrypting the sentences and storing the results in a list:
			List<String> decryptedSentences = new ArrayList<>();
			
			for (String sentence : encryptedSentences) {
				decryptedSentences.add(decryptSentence(sentence));
			}
			
			// Showing the results:
			for (String sentence : decryptedSentences) {
				System.out.println(sentence);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
