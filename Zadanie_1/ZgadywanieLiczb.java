package Zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class ZgadywanieLiczb {
	public static void main(String[] args) {
		numberGeneratorGame();
		}
	
	static void numberGeneratorGame() {
		Random r = new Random();
		int number = r.nextInt(100) + 1;
		int count = 0;
		System.out.println("Zgadnij liczbę");
		Scanner input = new Scanner(System.in);
		try {
			int playerNumber = -1;
			while (!(number == playerNumber)) {
				playerNumber = input.nextInt();
				if (playerNumber > number) {
					System.out.println("Za dużo!");
				} else if (playerNumber < number) {
					System.out.println("Za mało!");
				} 
				count++;
			}
			System.out.println("Zgadłeś za " + count + " razem!");
			input.close();
		} catch (Exception e) {
			System.out.println("To nie jest liczba. Spróbuj ponownie");
			//numberInput();
			numberGeneratorGame();;
		}

	}
}
