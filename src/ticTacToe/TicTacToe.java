package ticTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Timer;

public class TicTacToe {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Timer timer = new Timer();
	Board board;
	Player player1 = new Player('X');
	Player player2;

	public TicTacToe() {

	}

	private void gameLoop() {
		boolean isPlayer1Turn = true;
		while (true) {
			try {
				char mark; // Either X or O
				int[] coords; // Coordinates for the player's move

				board.printBoard();

				if (isPlayer1Turn) {
					System.out.println("Player 1's Turn!");
					mark = player1.mark;
					coords = player1.turn();
				} else {
					System.out.println("Player 2's Turn!");
					mark = player2.mark;
					coords = player2.turn();
				}

				if (!board.mark(mark, coords[0], coords[1])) {
					throw new Exception("Error: Space already filled. Try again");
				}

				isPlayer1Turn = !isPlayer1Turn; // Alternate turns
				if (board.checkWin(mark)) {
					board.printBoard();
					System.out.println(mark + " wins!!!!!!");
					System.out.println("Hit enter to return");
					reader.readLine();
					return; // Return to main menu
				}
				if (board.checkDraw()) {
					board.printBoard();
					System.out.println("Draw!");
					System.out.println("Hit enter to return");
					reader.readLine();
					return; // Return to main menu
				}

			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: Invalid input");
			} catch (TimeoutException e) {
				System.out.println("Time's up!");
				isPlayer1Turn = !isPlayer1Turn; // Alternate turns
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void setUp(String menuInput) {
		System.out.println("Enter board size(at least 3):");
		while (true)
			try {
				String input = reader.readLine();
				int dimensions = Integer.parseInt(input);

				if (dimensions < 3)
					throw new NumberFormatException();
				else {
					this.board = new Board(dimensions);
				}

				// Make a human or AI player
				if (Integer.parseInt(menuInput) == 1) {
					player2 = new Player('O');
				} else if (Integer.parseInt(menuInput) == 2) {
					player2 = new AiPlayer('O', 0, this.board);

				} else if (Integer.parseInt(menuInput) == 3) {
					player2 = new AiPlayer('O', 1, this.board);

				} else if (Integer.parseInt(menuInput) == 4) {
					player2 = new AiPlayer('O', 2, this.board);

				}

				gameLoop();
				return;

			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void play() {
		while (true) {
			System.out.println("Welcome to Tic Tac Toe!");
			System.out.println("Select Game Mode:");
			System.out.println("1. 2 Player");
			System.out.println("2. Easy");
			System.out.println("3. Medium");
			System.out.println("4. Hard");
			System.out.println("5. Exit");

			try {
				String input = reader.readLine();

				switch (input) {
				case ("1"):
					setUp(input);
					break;
				case ("2"):
					setUp(input);
					break;
				case ("3"):
					setUp(input);
					break;
				case ("4"):
					setUp(input);
					break;
				case ("5"):
					System.exit(0);
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}

	}
}
