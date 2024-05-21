package ticTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class TicTacToe {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Board board;
	Player player1 = new Player('X');
	Player player2 = new Player('O');
	boolean player1Turn = true;

	public TicTacToe() {

	}

	private void gameLoop() {
		while (true) {
			try {
				board.printBoard();
				char mark;
				String input;

				if (player1Turn) {
					mark = 'X';
					System.out.println("Player 1's Turn!");
				}

				else {
					mark = 'O';
					System.out.println("Player 2's Turn!");
				}

				System.out.println("Select a row: ");
				input = reader.readLine();
				int rowInput = Integer.parseInt(input);

				System.out.println("Select a column: ");
				input = reader.readLine();
				int colInput = Integer.parseInt(input);

				if (!board.mark(mark, rowInput, colInput)) {
					throw new Exception("Error: Space already filled");
				}

				player1Turn = !player1Turn; // Alternate turns
				if (board.checkWin(mark)) {
					board.printBoard();
					System.out.println(mark + " wins!!!!!!");
					return;
				}

			} catch (Exception e) {
				e.printStackTrace();
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

				gameLoop();

			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	public void play() {
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("Select Game Mode:");
		System.out.println("1. 2 Player");
		System.out.println("2. Easy");
		System.out.println("3. Medium");
		System.out.println("4. Hard");
		while (true) {
			try {
				String input = reader.readLine();

				switch (input) {
				case ("1"):
					setUp(input);
					break;
				case ("2"):
					// TODO
					break;
				case ("3"):
					// TODO
					break;
				case ("4"):
					// TODO
					break;
				default:
					throw new InputMismatchException();
				}

			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
