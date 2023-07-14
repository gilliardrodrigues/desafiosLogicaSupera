package desafio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondChallenge {

private static double readPositiveDouble(BufferedReader reader, double lowerLimit, double upperLimit) throws IOException {
        
		double value;
		
        do {
        	value = Double.parseDouble(reader.readLine());

            if (value <= lowerLimit || value > upperLimit) {
                System.out.println("The value of n is outside the valid range. Try again:");
            }
        } while (value <= lowerLimit || value > upperLimit);

        return value;
    }
	
	public static List<Integer> calculateMinimumQuantityRequired(Double value, List<Double> availableBankNotesAndCoins) {
		
		List<Integer> necessaryAmount = new ArrayList<>();
		
		// Calculating the number of banknotes and coins needed:
        for(int i = 0; i < availableBankNotesAndCoins.size(); i++) {
        	int amount = (int) (value / availableBankNotesAndCoins.get(i));
        	necessaryAmount.add(amount);
        	value %= availableBankNotesAndCoins.get(i);
        }
        
        return necessaryAmount;
	}

	public static void main(String args[]) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
        try {
        	// Reading the value from keyboard:
            Double value = readPositiveDouble(reader, 0.00, 1000000.00);
            
            // Available banknotes/coins, along with a list to store their necessary amount:
            List<Double> availableBankNotesAndCoins = Arrays.asList(100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.25, 0.1, 0.05, 0.01);            
            List<Integer> necessaryAmount = new ArrayList<>();
            
            // Calculating the number of banknotes and coins needed:
            necessaryAmount = calculateMinimumQuantityRequired(value, availableBankNotesAndCoins);
            
            // Printing the results:
            System.out.println("NOTAS:");
            for (int i = 0; i < 6; i++)
                System.out.printf("%d nota(s) de R$ %.2f%n", necessaryAmount.get(i), availableBankNotesAndCoins.get(i));
            
            System.out.println("MOEDAS:");
            for (int i = 6; i < availableBankNotesAndCoins.size(); i++)
                System.out.printf("%d moeda(s) de R$ %.2f%n", necessaryAmount.get(i), availableBankNotesAndCoins.get(i));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
