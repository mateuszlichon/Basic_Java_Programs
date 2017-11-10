package Zadanie_2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class symulatorLotto {
	public static void main(String[] args) {
		int[] player = playerNumbers();
		int[] fate = loteryNumbers();
		compare(player, fate);
	}

	static int[] playerNumbers() {
		Scanner input = new Scanner(System.in);
		int[] number = new int[6];
		System.out.println("Wprowadź 6 liczb pomiędzy 1 a 49");
		try {
			for (int i = 0; i < 6; i++) {
				System.out.println("Wybierz " + (i + 1) + " liczbę");
				int choice = input.nextInt();
				while (!((choice > 0) && (choice < 50)) || (choice == number[0] || choice == number[1]
						|| choice == number[2] || choice == number[3] || choice == number[4] || choice == number[5])) {
					if ((choice > 0) && (choice < 50)) {
						System.out.println("Już wybrałeś tę liczbę. Spróbuj z inną.");
					} else {
						System.out.println("liczba musi być pomiędzy 1 a 49");
					}
					choice = input.nextInt();
				}
				number[i] = choice;
			}
			Arrays.sort(number);
			System.out.println("-----------------------------------");
			System.out.println("Twoje liczby to " + Arrays.toString(number));
			System.out.println();
			input.close();
			return number;
		} catch (InputMismatchException e) {
			System.out.println("To nie jest liczba");
			playerNumbers();
		}
		return number;
	}

	static int[] loteryNumbers() {
		Random r = new Random();
		int[] loteryNumbers = new int[6];
		for (int i = 0; i < loteryNumbers.length; i++) {
			loteryNumbers[i] = r.nextInt(49) + 1;
			for (int j = 0; j < i; j++) {
				while ((loteryNumbers[i] == loteryNumbers[j])) {
					loteryNumbers[i] = r.nextInt(49) + 1;
				}
			}
		}
		Arrays.sort(loteryNumbers);
		System.out.println("Wylosowane liczby to " + Arrays.toString(loteryNumbers));
		System.out.println();
		return loteryNumbers;
	}

	static void compare(int[] player, int[] fate) {
		int count = 0;
		for (int number : player) {
			for (int fateNum : fate) {
				if (number == fateNum) {
					count++;
				}
			}
		}
		
		if (count >= 3) {
			System.out.println("Brawo! Wygrałeś trochę grosza. Trafiłeś " + count + "!");
		} else {
		System.out.println("Nic z tego. Trafiłeś " + count);
		}
		System.out.println("-----------------------------");
	}
}
