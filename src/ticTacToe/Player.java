package ticTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	char mark; // Either X or O

	Player(char mark) {
		this.mark = mark;
	}

	// Prompt player for their move
	int[] turn() throws IOException, InterruptedException, TimeoutException {
		String input;
		int seconds = 10; // Amount of time to make a move
		InputGetter getter = new InputGetter(seconds);

		System.out.println("You have " + seconds + " seconds to make a move!");
		System.out.println("Select a row: ");

		// input = reader.readLine();
		input = getter.input;
		while (input == null) {
			Thread.sleep(50);
			input = getter.input;
			if (getter.timeOut) {
				getter.executor.shutdownNow();
				throw new TimeoutException();
			}

		}
		getter.executor.shutdownNow();
		int rowInput = Integer.parseInt(input);

		System.out.println("Select a column: ");
		// input = reader.readLine();
		getter = new InputGetter(seconds);
		input = getter.input;
		while (input == null) {
			Thread.sleep(50);
			input = getter.input;
			if (getter.timeOut) {
				getter.executor.shutdownNow();
				throw new TimeoutException();
			}
		}
		getter.executor.shutdownNow();

		int colInput = Integer.parseInt(input);

		// Return player's move as an array
		return new int[] { rowInput, colInput };
	}
}
