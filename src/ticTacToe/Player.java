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

	int[] turn() throws IOException {
		System.out.println("Select a row: ");
		String input;
		input = reader.readLine();
		int rowInput = Integer.parseInt(input);

		System.out.println("Select a column: ");
		input = reader.readLine();
		int colInput = Integer.parseInt(input);

		// Return player's choice as an array
		return new int[] { rowInput, colInput };

	}
}
