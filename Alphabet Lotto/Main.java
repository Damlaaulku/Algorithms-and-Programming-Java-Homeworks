package Homework;

public class Main {

	public static void main(String[] args) {
		Stack card1 = new Stack(8);
		Stack card2 = new Stack(8);
		Stack bag1 = new Stack(26);
		System.out.print("Bag 1: ");
		for (char i = 'A'; i <= 'Z'; i++) {
			bag1.Push(i);
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("Bag 2: ");
		System.out.println();
		System.out.println("");
		System.out.print("Player1: ");
		Test.Player(card1);	
		System.out.println();
		System.out.print("Player2: ");
		Test.Player(card2);
		System.out.println("\n");
		Test.AlphabetLotto(card1, card2);
		System.out.println();
		
	}

}
