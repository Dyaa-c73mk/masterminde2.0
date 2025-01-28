package mastermind2_0;

import java.util.Random;
import java.util.Scanner;

public class functieMastermind {
	public String[] genereren() {
		String[] colors = {"R","Y","G","P","B","O", };

		Random rand = new Random();

		String[] code = new String[4];

		for (int i = 0; i < code.length; i++) {
			int randomIndex = rand.nextInt(colors.length);
			code[i] = colors[randomIndex];
		}

		return code;
	}

	public void HetSpell() {

		String[] code = genereren();

		Scanner sc = new Scanner(System.in);

		for (int j = 0; j < 10; j++) {

			System.out.println("Enter your guess (Pickable colors: R, Y, G, B, P, O) - separate colors by spaces: ");
			String input = sc.nextLine(); // Gebruik nextLine() om volledige input te verkrijgen

			String[] gokken = input.split(" ");

			if (gokken.length != 4) {
				System.out.println("Invalid input! Please enter exactly 4 colors.");
				j--;
				continue;
			}

			String result = "";
			boolean[] codeUsed = new boolean[4];
			boolean[] guessUsed = new boolean[4];

			for (int i = 0; i < 4; i++) {
				if (gokken[i].equals(code[i])) {
					result += "X";
					codeUsed[i] = true;
					guessUsed[i] = true;
				} else {
					result += "-";
				}
			}

			for (int i = 0; i < 4; i++) {
				if (!guessUsed[i]) {
					for (int J = 0; J < 4; J++) {
						if (!codeUsed[J] && gokken[i].equals(code[J])) {
							result += "W";
							codeUsed[J] = true;
							break;
						}
					}
				}
			}

			System.out.println("Result: " + result);

			if (result.equals("XXXX")) {
				System.out.println("Congratulations! You've guessed the correct code!");
				break;
			}

			if (j == 9) {
				System.out.println("You lost! The correct code was: " + String.join(" ", code));
			}
		}
		sc.close();
	}
}
