package desafio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Counter;

public class ThirdChallenge {

	public static int countPairsWithDifferenceOf(int k, List<Integer> numbers) {
		
		int count = 0;
		// Auxiliary data structure for count the frequency of occurrences:
        Counter<Integer> counter = new Counter<>();

        // Counting the frequency of each number in the list:
        for (int number : numbers)
            counter.increment(number);

        // Verifying the condition for each pair:
        for (int number : numbers) {
        	// Calculating the value that subtracted from the current number results in k:
            int complement = number - k;
            // Checking if the complement exists in the counter and incrementing its count:
            if (counter.contains(complement))
                count += counter.getCount(complement);
        }

        return count;
    }
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);

        // Reading 'n' and 'k':
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Reading the array:
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++)
            numbers.add(scanner.nextInt());
        scanner.close();
        
        // Calculating the count of pairs with difference equal to k and printing it:
        System.out.println(countPairsWithDifferenceOf(k, numbers));
	}
}
