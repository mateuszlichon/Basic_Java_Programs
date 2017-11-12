package Zadanie_3;

import java.util.Scanner;

public class komputerZgaduje {
	public static void main(String[] args) {
		int min = 0;
		int max = 1000;
		int number = settingNo(min, max);
		guessing(min, max, number, 1);
	}

	static int settingNo(int min, int max) {
		System.out.println("Pomyśl liczbę od " + min + " do " + max + ", a ja ją zgadnę w max 10 ruchach");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		while (number > max || number < min) {
			System.out.println("Liczba miała być od " + min + " do " + max + ". Spróbuj ponownie.");
			number = input.nextInt();
		}
		// input.close();
		//System.out.println(number);
		return number;
	}

	static void guessing(int min, int max, int number, int count) {
		int minMet = min;
		int maxMet = max;
		int numberMet = number;
		int countMet = count;

		int guess = ((max - min) / 2) + min;
		System.out.println("Podejście " + count);
		System.out.println("Zgaduję: " + guess);
		System.out.println("Zgadłem? tak/nie");
		Scanner input2 = new Scanner(System.in);
		String hint = input2.next();
		while (!(hint.equals("tak") || hint.equals("nie"))) {
			System.out.println("Odpowiedz tak bądź nie");
			hint = input2.next();
		}
		if (hint.equals("tak")) {
			System.out.println("Hura! Wygrałem za " + countMet + " razem!");
			System.exit(0);
			;
		} else if (hint.equals("nie")) {
			System.out.println("Za dużo? tak/nie");
			hint = input2.next();
			countMet++;
			while (!(hint.equals("tak") || hint.equals("nie"))) {
				System.out.println("Odpowiedz tak bądź nie");
				hint = input2.next();
			}
			if (hint.equals("tak")) {
				maxMet = guess;
				guessing(minMet, maxMet, numberMet, countMet);
			} else if (hint.equals("nie"))
				;
			{
				System.out.println("Za mało? tak/nie");
				hint = input2.next();
				while (!(hint.equals("tak") || hint.equals("nie"))) {
					System.out.println("Odpowiedz tak bądź nie");
					hint = input2.next();
				}
				if (hint.equals("tak")) {
					minMet = guess;
					guessing(minMet, maxMet, numberMet, countMet);
				} else if (hint.equals("nie")) {
					System.out.println("Oszukujesz! Spróbujmy ponownie");
					guessing(minMet, maxMet, numberMet, countMet);
					count--;
				}
			}
		}
		input2.close();
	}

}
