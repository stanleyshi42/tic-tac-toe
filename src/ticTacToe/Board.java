package ticTacToe;

public class Board {
	char[][] board;
	int dimensions;

	public Board(int dimensions) {
		this.dimensions = dimensions;
		this.board = new char[dimensions][dimensions];

		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				this.board[i][j] = 'X';

			}
		}

		printBoard();
	}

	void printBoard() {
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				System.out.print("|");
				System.out.print(this.board[i][j]);
				
			}
			System.out.print("|");
			System.out.println();

		}
	}
}
