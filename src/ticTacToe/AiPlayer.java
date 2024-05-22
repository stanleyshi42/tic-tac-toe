package ticTacToe;

import java.util.Random;

public class AiPlayer extends Player {
	int difficulty; // 0 = Easy, 1 = Medium, 2 = Hard
	Board board;

	public AiPlayer(char mark, int difficulty, Board board) {
		super(mark);
		this.difficulty = difficulty;
		this.board = board;
	}

	// AI makes a move based on its difficulty
	@Override
	int[] turn() {
		switch (difficulty) {
		case (0):
			return easyTurn();
		case (1):
			return mediumTurn();
		case (2):
			return easyTurn(); // TODO hard
		default:
			return new int[] { 0, 0 };
		}
	}

	// Makes a random move
	int[] easyTurn() {
		return randomCoords();
	}

	// Makes a random move unless:
	// It can make a winning move or
	// Block the opponent's winning move
	int[] mediumTurn() {
		// Check for winning moves
		for (int i = 0; i < board.dimensions; i++) {
			for (int j = 0; j < board.dimensions; j++) {
				if (board.grid[i][j] == mark) {
					// Checks for horizontal wins
					int[] move = checkHoritzontalMoves(mark, i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for vertical wins
					move = checkVerticalMoves(mark, i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for left diagonal wins
					move = checkLeftDiagonalMoves(mark, i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for right diagonal wins
					move = checkRightDiagonalMoves(mark, i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;
				}
			}
		}

		// Check for blocking opponent wins
		for (int i = 0; i < board.dimensions; i++) {
			for (int j = 0; j < board.dimensions; j++) {
				if (board.grid[i][j] == 'X') {
					// Checks for horizontal wins
					int[] move = checkHoritzontalMoves('X', i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for vertical wins
					move = checkVerticalMoves('X', i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for left diagonal wins
					move = checkLeftDiagonalMoves('X', i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;

					// Checks for right diagonal wins
					move = checkRightDiagonalMoves('X', i, j);
					if (move[0] != -1 && move[1] != -1)
						return move;
				}
			}
		}

		// Make a random move if no move was chosen
		return randomCoords();
	}

	// Look for a horitontal winning move
	int[] checkHoritzontalMoves(char mark, int x, int y) {
		int xMove, yMove;

		// i offsets the current horizontal coordinate
		for (int i = -2; i < 3; i++) {
			if (i == 0)
				continue; // Don't check current square
			if (y + i < board.dimensions && y + i >= 0) {
				if (board.grid[x][y + i] == mark) {
					if (i == -2)
						yMove = y + i + 1;
					else if (i == -1)
						yMove = y + i - 1;
					else if (i == 1)
						yMove = y + i + 1;
					else if (i == 2)
						yMove = y + i - 1;
					else
						yMove = -1;

					xMove = x;
					if (yMove >= 0 && yMove < board.dimensions) {
						if (board.grid[xMove][yMove] == ' ') {
							return new int[] { xMove, yMove };
						}
					}
				}
			}
		}

		return new int[] { -1, -1 };
	}

	// Look for a vertical winning move
	int[] checkVerticalMoves(char mark, int x, int y) {
		int xMove, yMove;

		// i offsets the current vertical coordinate
		for (int i = -2; i < 3; i++) {
			if (i == 0)
				continue; // Don't check current square
			if (x + i < board.dimensions && x + i >= 0) {
				if (board.grid[x + i][y] == mark) {
					if (i == -2)
						xMove = x + i + 1;
					else if (i == -1)
						xMove = x + i - 1;
					else if (i == 1)
						xMove = x + i + 1;
					else if (i == 2)
						xMove = x + i - 1;
					else
						xMove = -1;

					yMove = y;
					if (xMove >= 0 && xMove < board.dimensions) {
						if (board.grid[xMove][yMove] == ' ') {
							return new int[] { xMove, yMove };
						}
					}
				}
			}
		}

		return new int[] { -1, -1 };
	}

	// Look for a left diagonal winning move
	int[] checkLeftDiagonalMoves(char mark, int x, int y) {
		int xMove, yMove;

		for (int i = -2; i < 3; i++) {
			if (i == 0)
				continue; // Don't check current square
			if (x + i < board.dimensions && x + i >= 0 && y + i < board.dimensions && y + i >= 0) {
				if (board.grid[x + i][y + i] == mark) {
					if (i == -2) {
						xMove = x + i + 1;
						yMove = y + i + 1;
					} else if (i == -1) {
						xMove = x + i - 1;
						yMove = y + i - 1;
					} else if (i == 1) {
						xMove = x + i + 1;
						yMove = y + i + 1;
					} else if (i == 2) {
						xMove = x + i - 1;
						yMove = y + i - 1;
					} else {
						xMove = -1;
						yMove = -1;
					}

					if (xMove >= 0 && xMove < board.dimensions && yMove >= 0 && yMove < board.dimensions) {
						if (board.grid[xMove][yMove] == ' ') {
							return new int[] { xMove, yMove };
						}
					}
				}
			}
		}

		return new int[] { -1, -1 };
	}

	// Look for a right diagonal winning move
	int[] checkRightDiagonalMoves(char mark, int x, int y) {
		int xMove, yMove;

		for (int i = -2; i < 3; i++) {
			if (i == 0)
				continue; // Don't check current square
			if (x - i < board.dimensions && x - i >= 0 && y + i < board.dimensions && y + i >= 0) {
				if (board.grid[x - i][y + i] == mark) {
					if (i == -2) {
						xMove = x - i - 1;
						yMove = y + i + 1;
					} else if (i == -1) {
						xMove = x - i + 1;
						yMove = y + i - 1;
					} else if (i == 1) { 
						xMove = x - i - 1;
						yMove = y + i + 1;
					} else if (i == 2) {
						xMove = x - i + 1;
						yMove = y + i - 1;
					} else {
						xMove = -1;
						yMove = -1;
					}

					if (xMove >= 0 && xMove < board.dimensions && yMove >= 0 && yMove < board.dimensions) {
						System.out.println(xMove + " " + yMove);
						if (board.grid[xMove][yMove] == ' ') {
							return new int[] { xMove, yMove };
						}
					}
				}
			}
		}

		return new int[] { -1, -1 };
	}

	public int[] randomCoords() {
		Random rand = new Random();
		int i, j;

		// Generate a random coordinate that is not already filled
		do {
			i = rand.nextInt(this.board.dimensions);
			j = rand.nextInt(this.board.dimensions);
		} while (board.grid[i][j] != ' ');
		return new int[] { i, j };
	}
}
