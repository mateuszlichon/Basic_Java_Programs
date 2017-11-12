package Zadanie_4;

import java.util.Random;
import java.util.Scanner;

public class KostkaDoGry {
	public static void main(String[] args) {
		String code = declare();
		int howMany = howMany(code);
		String[] codeSplit = split(code);
		int dice = value(codeSplit);
		int add = toAdd(codeSplit);
		String addOrSub = addOrSub(code);
	//	System.out.println(howMany + " " + dice + ", " + add);
		System.out.println(finalThrow(howMany, dice, add, addOrSub));
	}

	static String declare() {
		System.out.println("Wprowadź kod rzutu");
		Scanner input = new Scanner(System.in);
		String code = input.next();
		while (!(Character.isDigit(code.charAt(0)) || code.charAt(0) == 'D')) {
			System.out.println("Upewnij się, że podałeś właściwy kod rzutu. Wpisz właściwy.");
			code = input.next();
		}
		input.close();
		return code;
	}

	static int howMany(String code) {
		if (code.charAt(0) == 'D') {
			return 0;
		} else {
			return Character.getNumericValue(code.charAt(0));

		}
	}

	static String[] split(String code) {
		String code2 = code.replace("D", " ");
		code2 = code2.replace("+", " ");
		code2 = code2.replace("-", " ");
		String[] codeSplit = code2.split(" ");
	//	System.out.println(Arrays.toString(codeSplit));
		return codeSplit;
	}

	static int value(String[] codeSplit) {
		return Integer.parseInt(codeSplit[1]);
	}

	static int toAdd(String[] codeSplit) {
		if (codeSplit.length > 2) {
			return Integer.parseInt(codeSplit[2]);
		} else {
			return 0;
		}
	}

	static String addOrSub(String code) {
		String action = "";
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '+') {
				action = "add";
				break;
			} else if (code.charAt(i) == '-') {
				action = "subtract";
				break;
			} else {
				action = "nothing";
			}
		}
	//	System.out.println(action);
		return action;
	}

	static int finalThrow(int x, int z, int add, String addOrSub) {
		Random r = new Random();
		int dice = r.nextInt(z - 1) + 1;
	//	System.out.println(addOrSub);
		if (addOrSub.equals("add")) {
			if (x == 0) {
				return dice + add;
			} else {
				return (x * dice) + add;
			}
		} else {
			if (x == 0) {
				return dice - add;
			} else {
				return (x * dice) - add;
			}

		}
	}
}
