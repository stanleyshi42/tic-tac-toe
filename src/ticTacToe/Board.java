package ticTacToe;

//A Tic Tac Toe board with variable size
public class Board {
	public char[][] board;
	public int dimensions;

	// Default constructor
	public Board() {
		this(3);
	}

	public Board(int dimensions) {
		this.dimensions = dimensions;
		this.board = new char[dimensions][dimensions];

		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				this.board[i][j] = ' ';
			}
		}

	}

	// Marks the board with an X or O
	public boolean mark(char mark, int x, int y) {
		// Checks if space is already marked
		if (board[x][y] != ' ')
			return false;

		board[x][y] = mark;
		return true;
	}

	public boolean checkDraw() {
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				// If there's an empty space, it's not a draw
				if (this.board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	// Checks board for a win
	public boolean checkWin(char mark) {
		for (int j = 0; j < this.dimensions; j++) {
			for (int i = 0; i < this.dimensions; i++) {
				if (this.board[i][j] == mark) {
					if (checkVerticalWin(mark, j)) {
						return true;
					}
					if (checkHorizontalWin(mark, i)) {
						return true;
					}
					if (checkLeftDiagonalWin(mark)) {
						return true;
					}
					if (checkRightDiagonalWin(mark)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean checkVerticalWin(char mark, int j) {
		int count = this.dimensions;
		for (int i = 0; i < this.dimensions; i++) {
			if (mark == this.board[i][j]) {
				count--;
				if (count <= 0)
					return true;
			}
		}

		return false;
	}

	private boolean checkHorizontalWin(char mark, int i) {
		int count = this.dimensions;
		for (int j = 0; j < this.dimensions; j++) {
			if (mark == this.board[i][j]) {
				count--;
				if (count <= 0)
					return true;
			}
		}

		return false;
	}

	private boolean checkLeftDiagonalWin(char mark) {
		int count = this.dimensions;
		for (int i = 0; i < this.dimensions; i++) {
			if (mark == this.board[i][i]) {
				count--;
				if (count <= 0)
					return true;
			}
		}

		return false;
	}

	private boolean checkRightDiagonalWin(char mark) {
		int count = this.dimensions;
		for (int i = 0; i < this.dimensions; i++) {
			if (mark == this.board[i][dimensions - 1 - i]) {
				count--;
				if (count <= 0)
					return true;
			}
		}
		return false;
	}

	// Prints the game board
	void printBoard() {
		for (int i = 0; i < this.dimensions; i++) {
			System.out.print(i + " "); // Print row numbers
			for (int j = 0; j < this.dimensions; j++) {
				System.out.print("|");
				System.out.print(this.board[i][j]);
			}
			System.out.println("|");
		}
		System.out.print("   ");
		for (int i = 0; i < this.dimensions; i++) {
			System.out.print(i + " "); // Print column numbers
		}
		System.out.println();
	}
}
