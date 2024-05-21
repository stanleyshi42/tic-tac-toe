package ticTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class TicTacToe {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Board board;

	public TicTacToe() {

	}

	void setUp(String menuInput) {
		System.out.println("Enter the board size(at least 3):");
		while (true)
			try {
				String input = reader.readLine();
				int dimensions = Integer.parseInt(input);

				if (dimensions < 3)
					throw new NumberFormatException();
				else {
					this.board = new Board(dimensions);
				}

			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input");
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	void play() {
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
