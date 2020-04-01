package Homework;

import java.util.Random;

public class Test {

	public static Stack Player(Stack s) {

		Stack card = s;
		Stack control = new Stack(26);
		Stack temp = new Stack(26);
		Random letter = new Random();
		int bound = 14;
		int randomLetter = 0;
		

		for (char i = 'Z'; i >= 'A'; i--)
			control.Push(i);

		for (int k = 0; k < 4; k++) {

			randomLetter = letter.nextInt(bound);

			for (int i = 1; i < randomLetter; i++)
				temp.Push(control.Pop());

			card.Push(control.Pop());

			while (!temp.isEmpty())
				control.Push(temp.Pop());

			System.out.print(card.Peek() + " ");
			bound--;
		}

		while (!control.isEmpty())
			control.Pop();

		for (char i = 'Z'; i >= 'A'; i--)
			control.Push(i);

		bound = 12;

		for (int k = 0; k < 4; k++) {

			randomLetter = 15 + letter.nextInt(bound);

			for (int i = 1; i < randomLetter; i++)
				temp.Push(control.Pop());

			card.Push(control.Pop());

			while (!temp.isEmpty())
				control.Push(temp.Pop());

			System.out.print(card.Peek() + " ");
			bound--;
		}
		return card;
	}

	public static void AlphabetLotto(Stack card1, Stack card2) {

		Stack bag1 = new Stack(26);
		Stack bag2 = new Stack(26);
		Stack temp = new Stack(26);
		Stack player1 = card1;
		Stack player2 = card2;
		char tempLetter;

		Random letter = new Random();

		for (char i = 'Z'; i >= 'A'; i--) {
			bag1.Push(i);
		}
		int size1 = bag1.Size();

		int randomLetter = 0;
		int sizePlayer1 = 0;
		int sizePlayer2 = 0;

		int moneyPlayer1 = 0;
		int moneyPlayer2 = 0;

		boolean cinkoPlayer1 = false;
		boolean cinkoPlayer2 = false;

		boolean flag = true;

		while (flag) {

			randomLetter = letter.nextInt(bag1.Size()) + 1;

			for (int i = 1; i < randomLetter; i++)
				temp.Push(bag1.Pop());

			tempLetter = (char) bag1.Peek();
			bag2.Push(bag1.Pop());

			while (!temp.isEmpty())
				bag1.Push(temp.Pop());

			while (!player1.isEmpty()) {
				char peek = (char) player1.Peek();

				if (tempLetter == peek) {
					player1.Pop();
					break;
				} else
					temp.Push(player1.Pop());
			}
			while (!temp.isEmpty())
				player1.Push(temp.Pop());

			while (!player2.isEmpty()) {
				char peek = (char) player2.Peek();

				if (tempLetter == peek) {
					player2.Pop();
					break;
				} else
					temp.Push(player2.Pop());
			}
			while (!temp.isEmpty())
				player2.Push(temp.Pop());

			// Draw
			System.out.println("\n----------------------------------------------------------\n");
			Stack temp5 = new Stack(26);

			System.out.println("Letter: " + tempLetter);

			size1 = bag1.Size();
			int size2 = bag2.Size();
			System.out.print("\nBag 1: ");
			for (int i = 0; i < size1; i++) {
				temp5.Push(bag1.Peek());
				System.out.print(bag1.Pop() + " ");
			}

			while (!temp5.isEmpty()) {

				bag1.Push(temp5.Pop());
			}

			System.out.println("");
			System.out.print("Bag 2: ");
			for (int i = 0; i < size2; i++) {
				temp5.Push(bag2.Peek());
				System.out.print(bag2.Pop() + " ");
			}
			System.out.println();

			while (!temp5.isEmpty()) {

				bag2.Push(temp5.Pop());
			}

			Stack temp6 = new Stack(8);

			sizePlayer1 = player1.Size();
			for (int i = 0; i < sizePlayer1; i++) {
				temp6.Push(player1.Pop());
			}
			System.out.println();
			System.out.print("Player1: ");

			while (!temp6.isEmpty()) {
				System.out.print(temp6.Peek() + " ");
				player1.Push(temp6.Pop());
			}

			System.out.println();
			sizePlayer2 = player2.Size();
			for (int i = 0; i < sizePlayer2; i++) {
				temp6.Push(player2.Pop());
			}

			System.out.print("Player2: ");
			while (!temp6.isEmpty()) {
				System.out.print(temp6.Peek() + " ");
				player2.Push(temp6.Pop());
			}

			// cinko
			System.out.println("");
			Stack temp7 = new Stack(8);
			int firstH = 0, lastH = 0;

			while (!player1.isEmpty()) {

				if ((int) (char) player1.Peek() <= 78)
					firstH++;
				else
					lastH++;

				temp7.Push(player1.Pop());
			}

			while (!temp7.isEmpty())
				player1.Push(temp7.Pop());

			if (cinkoPlayer1 == false && (firstH == 0 || lastH == 0)) {
				cinkoPlayer1 = true;
				System.out.println("\nCinko player 1 !\n");
				moneyPlayer1 += 10;
			}

			firstH = 0;
			lastH = 0;

			while (!player2.isEmpty()) {

				if ((int) (char) player2.Peek() <= 78)
					firstH++;
				else
					lastH++;

				temp7.Push(player2.Pop());
			}

			while (!temp7.isEmpty())
				player2.Push(temp7.Pop());

			if (cinkoPlayer2 == false && (firstH == 0 || lastH == 0)) {
				cinkoPlayer2 = true;
				System.out.println("\nCinko player 2 !\n");
				moneyPlayer2 += 10;
			}

			// Kontrol
			if (player1.isEmpty() && player2.isEmpty()) {
				moneyPlayer1 += 15;
				moneyPlayer2 += 15;
				flag = false;
				System.out.println("\n\n");
				System.out.println("GAME TIE");
			} else if (player1.isEmpty()) {
				moneyPlayer1 += 30;
				flag = false;
				System.out.println("\n\n");
				System.out.println("PLAYER1 WON");
			} else if (player2.isEmpty()) {
				moneyPlayer2 += 30;
				flag = false;
				System.out.println("\n\n");
				System.out.println("PLAYER2 WON");
			}

			if (flag == false) {

				System.out.println("");
				System.out.println("Player1 Money: " + moneyPlayer1);
				System.out.println("Player2 Money: " + moneyPlayer2);

			}
		}

	}
}