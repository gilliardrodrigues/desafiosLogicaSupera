package desafio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstChallenge {

	private static int readPositiveInteger(BufferedReader reader, int lowerLimit, int upperLimit) throws IOException {
        
		int number;
        do {
        	number = Integer.parseInt(reader.readLine());

            if (number <= lowerLimit || number > upperLimit) {
                System.out.println("The value of n is outside the valid range. Try again:");
            }
        } while (number <= lowerLimit || number > upperLimit);

        return number;
    }
	
	private static int readNonNegativeNumber(BufferedReader reader) throws IOException {
        
		int number;
        do {
            number = Integer.parseInt(reader.readLine());

            if (number < 0) {
                System.out.println("The number must be non-negative. Try again:");
            }
        } while (number < 0);

        return number;
    }
	
	public static List<Integer> sortNumbers(List<Integer> numbers) {
		
		// Spliting the even and odd numbers:
		List<Integer> evenNumbers = new ArrayList<>();
		List<Integer> oddNumbers = new ArrayList<>();
		
		for (Integer number : numbers) {
			if(number % 2 == 0)
				evenNumbers.add(number);
			else
				oddNumbers.add(number);
		}
		
		// Sorting the numbers according to each criterion:
		Collections.sort(evenNumbers);
		Collections.sort(oddNumbers, Collections.reverseOrder());
		
		// Merging the lists into the result list and returning it:
		List<Integer> orderedNumbers = new ArrayList<>();
		orderedNumbers.addAll(evenNumbers);
		orderedNumbers.addAll(oddNumbers);
		
		return orderedNumbers;
	}
	
	public static void main(String args[]) {
		
		// Reading and storing all numbers in a list:
		List<Integer> numbers = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = readPositiveInteger(reader, 1, (int) Math.pow(10, 5));
			
			for(int i = 0; i < n; i++) {
				numbers.add(readNonNegativeNumber(reader));
			}
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		// Sorting the numbers:
		List<Integer> orderedNumbers = sortNumbers(numbers);
		
		// Printing the result:
		for (Integer number : orderedNumbers) {
			System.out.println(number);
		}
		
	}
}

