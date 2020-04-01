package Yahtzee;

import java.util.Random;

public class TestYahtzee {

	public static void Yahtzee() {
		CircularQueue player1 = new CircularQueue(45);
		CircularQueue player2 = new CircularQueue(45);
		Random rnd = new Random();

		int bound = 6;
		int randomDice = 0;
		int scoreP1 = 0;
		int scoreP2 = 0;

		for (int j = 1; j <= 15; j++) {

			for (int i = 0; i < 3; i++) { // random dice for each player
				randomDice = rnd.nextInt(bound) + 1;
				player1.Enqueue(randomDice);

				randomDice = rnd.nextInt(bound) + 1;
				player2.Enqueue(randomDice);
			}

			scoreP1 += Score(player1);
			scoreP2 += Score(player2);

			CircularQueue temp = new CircularQueue(45);
			// printing
			System.out.println();
			System.out.println("                 Turn " + j);
			System.out.println();
			System.out.print("Player 1: ");
			while (!player1.isEmpty()) {
				System.out.print(player1.Peek() + " ");
				temp.Enqueue(player1.Dequeue());
			}

			while (!temp.isEmpty()) {
				player1.Enqueue(temp.Dequeue());
			}
			System.out.println();
			System.out.print("Player 2: ");
			while (!player2.isEmpty()) {
				System.out.print(player2.Peek() + " ");
				temp.Enqueue(player2.Dequeue());
			}

			while (!temp.isEmpty()) {
				player2.Enqueue(temp.Dequeue());
			}

			System.out.println();
			System.out.println("P1 Score: " + scoreP1);
			System.out.println("P2 Score: " + scoreP2);

		}

		System.out.println();
		System.out.println("GAME OVER!");

		if (scoreP1 > scoreP2) {
			System.out.println();
			System.out.println("The winner is Player 1!");
		} else {
			System.out.println();
			System.out.println("The winner is Player 2!");
		}
	}

	public static int Score(CircularQueue player) { // method of calculating scores

		int score = 0;
		CircularQueue temp = new CircularQueue(45);
		CircularQueue tempControl = new CircularQueue(45);
		CircularQueue consecutive = new CircularQueue(45);

		while (!player.isEmpty()) {

			int count = 0;

			int tempPeek = (int) player.Peek();

			boolean exist = false;

			while (!temp.isEmpty()) {
				int tempPeek2 = (int) temp.Peek();
				tempControl.Enqueue(temp.Dequeue());
				if (tempPeek2 == tempPeek) {
					exist = true;
				}
			}

			while (!tempControl.isEmpty()) {
				temp.Enqueue(tempControl.Dequeue());
			}

			temp.Enqueue(player.Dequeue());

			if (exist == true)
				continue;

			consecutive.Enqueue(tempPeek);

			int currentSize = player.Size();
			for (int k = 0; k < currentSize; k++) {

				if (tempPeek == (int) player.Peek()) {
					count++;

				}

				tempControl.Enqueue(player.Dequeue());
			}

			boolean delete4 = false; // category of yahtzee controlling and deleting
			if (count >= 4) {
				delete4 = true;
				score += 20;
			}

			int deletedCount = 0;

			while (!tempControl.isEmpty()) {

				int num = (int) tempControl.Peek();

				if (delete4 && deletedCount < 4) {

					if (num == tempPeek) {
						deletedCount++;
						tempControl.Dequeue();

						continue;
					}

				}

				player.Enqueue(tempControl.Dequeue());
			}

		}

		while (!temp.isEmpty()) {
			player.Enqueue(temp.Dequeue());
		}

		if (consecutive.Size() == 6) { // category of large straight controlling and deleting
			while (!consecutive.isEmpty()) {
				int consecutivePeek = (int) consecutive.Dequeue();
				CircularQueue consecutiveQueue = new CircularQueue(45);

				boolean deleted = false;

				while (!player.isEmpty()) {
					int playerPeek = (int) player.Dequeue();
					if (playerPeek != consecutivePeek || deleted) {
						consecutiveQueue.Enqueue(playerPeek);
					} else
						deleted = true;
				}

				while (!consecutiveQueue.isEmpty()) {
					player.Enqueue(consecutiveQueue.Dequeue());
				}

			}

			score += 10;
		}

		return score;
	}

}
