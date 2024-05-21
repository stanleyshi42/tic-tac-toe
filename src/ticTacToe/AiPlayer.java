package ticTacToe;

import java.util.Random;

public class AiPlayer extends Player {
	int difficulty; // 0 = Easy, 1 = Medium, 2 = Hard
	Board board;

	AiPlayer(char type, int difficulty, Board board) {
		super(type);
		this.difficulty = difficulty;
		this.board = board;
	}

	// AI determines its turn
	@Override
	int[] turn() {
		switch (difficulty) {
		case (0):
			return easyTurn();
		case (1):
			return easyTurn(); // TODO medium
		case (2):
			return easyTurn(); // TODO hard
		default:
			return new int[] { 0, 0 };
		}
	}

	int[] easyTurn() {
		Random rand = new Random();
		int i, j;

		// Generate a random coordinate that is not already filled
		do {
			i = rand.nextInt(this.board.dimensions);
			j = rand.nextInt(this.board.dimensions);
		} while (board.board[i][j] != ' ');
		return new int[] { i, j };
	}
}
