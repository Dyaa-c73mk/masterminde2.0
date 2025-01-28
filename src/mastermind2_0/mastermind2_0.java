package mastermind2_0;
public class mastermind2_0 {

	public static void main(String[] args) {
		
		functieMastermind game = new functieMastermind();

		System.out.println("Welcome to Mastermind! Pick four colors. You have 10 chances.");
		System.out.println("If you get an X, it means you have the color in the right place, "
				+ "if it's a W, it means it's at the wrong place, and - means the color doesn't exist.");

		System.out.println("Turn on caps lock, type in one line with spaces.");
		System.out.println("Pickable colors: R, Y, G, B, P, O");  

		game.genereren();
		game.HetSpell();
		
		
		

	}

}
