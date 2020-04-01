package GoFish;

	import java.util.Random;
	import java.util.Scanner;

	public class TestGoFish {

		static SingleLinkedList computer = new SingleLinkedList();
		static SingleLinkedList human = new SingleLinkedList();
		static SingleLinkedList table = new SingleLinkedList();

		static int humanbook = 0;
		static int compbook = 0;
		static int turn = 1;

		static boolean playerTurn = true;

		public static void Book(SingleLinkedList list) {
			for (int j = 1; j <= 6; j++) 
			{
				Node temp = list.getHead();
				int counter = 0;
				for (int i = 0; i < list.Size(); i++) 
				{
					if ((int) temp.getData() == j)
					{
						counter++;
					}

					temp = temp.getLink();
				}

				if (counter == 4) 
				{
					for (int k = 0; k < 4; k++) 
					{
						list.Delete(j);
						System.out.print(j + " ");
					}

					System.out.println();

					if (playerTurn)
						humanbook++;
					else
						compbook++;

				}
			}

		}

		public static void Game(SingleLinkedList guesser, SingleLinkedList other, int input) {
			
			if (!guesser.Search(input)) {
				System.out.println("You should ask for ranks that you already have at least one card of. Please ask again!");
			}
			
			else if (other.Search(input)) 
			{
				Node temp = other.getHead();
				for (int i = 0; i <= other.Size(); i++) 
				{
					if ((int) temp.getData() == input) 
					{
						other.Delete(input);
						guesser.Add(input);
					}

					temp = temp.getLink();
				}

			} 
			else 
			{

				int tableHead = (int) table.getHead().getData();

				if (playerTurn) 
				{
					System.out.println("Computer say 'Go Fish'");
					playerTurn = false;
					human.Add(tableHead);
				} 
				else 
				{
					playerTurn = true;
					System.out.println("You says 'Go Fish'");
					computer.Add(tableHead);
				}

				table.Delete(tableHead);

			}

			Book(guesser);

		}

		public static void Print() {
			System.out.println("-----------------------------------------------");
			System.out.println("Turn: " + turn);
			System.out.println();
			System.out.print("You: ");
			human.Display();
			System.out.println();
			System.out.print("Book: " + humanbook);
			System.out.println("\n");
			System.out.print("Computer: ");
			computer.Display();
			System.out.println();
			System.out.print("Book: " + compbook);
			System.out.println("\n");
			System.out.print("Table: ");
			table.Display();
			System.out.println("\n");

		}

		public static void main(String[] args) {

			Random rnd = new Random();

			for (int i = 0; i < 4; i++) 
			{
				for (int j = 1; j <= 6; j++) 
				{
					table.Add(j);
				}
			}

			while (human.Size() != 7) 
			{
				int humannumbers = rnd.nextInt(7) + 1;
				
				if (table.Search(humannumbers)) 
				{
					table.Delete(humannumbers);
					human.Add(humannumbers);
				}
			}

			while (computer.Size() != 7) 
			{
				int computernumbers = rnd.nextInt(7) + 1;

				if (table.Search(computernumbers)) 
				{
					table.Delete(computernumbers);
					computer.Add(computernumbers);
				}
			}

			Book(human);
			Book(computer);

			while (true) 
			{
				Print();
				if (playerTurn) 
				{

					System.out.print("You ask: ");
					Scanner scn = new Scanner(System.in);
					int input = scn.nextInt();

					Game(human, computer, input);

				} 
				else 
				{
					int input = rnd.nextInt(6) + 1;
					System.out.println("Computer asks: " + input);
					Game(computer, human, input);
				}

				turn++;

				if (human.Size() == 0 || computer.Size() == 0 || table.Size()==0) 
				{
					break;
				}

			}

			if (humanbook > compbook) 
			{
				Print();
				System.out.println("-----------------------------------------------");
				System.out.println("GAME IS OVER!!");
				System.out.println("YOU WIN :)");
			} 
			else if (humanbook < compbook) 
			{
				Print();
				System.out.println("-----------------------------------------------");
				System.out.println("GAME IS OVER!!");
				System.out.println("COMPUTER WIN :)");
			} 
			else 
			{
				Print();
				System.out.println("-----------------------------------------------");
				System.out.println("GAME IS OVER!!");
				System.out.println("FRIENDSHIP WON :))");
			}
		}
}
