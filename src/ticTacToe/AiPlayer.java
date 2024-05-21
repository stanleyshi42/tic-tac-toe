package ticTacToe;

import java.util.ArrayList;
import java.util.Random;

public class AiPlayer extends Player {
	int difficulty; // 0 = Easy, 1 = Medium, 2 = Hard
	Board board;

	AiPlayer(char mark, int difficulty, Board board) {
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

	// TODO a lot of checks
	int[] mediumTurn() {
		int x = -1;
		int y = -1;

		// Check for winning moves
		for (int i = 0; i < board.dimensions; i++) {
			for (int j = 0; j < board.dimensions; j++) {
				if (board.board[i][j] == mark) {
					// Checks for horizontal wins
					if (j + 1 < board.dimensions && j + 2 < board.dimensions) {
						if (board.board[i][j + 1] == mark) {
							x = i;
							y = j + 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i][j + 2] == mark) {
							x = i;
							y = j + 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}

					} else if (j - 1 >= 0 && j + 1 < board.dimensions) {
						if (board.board[i][j - 1] == mark) {
							x = i;
							y = j + 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i][j + 1] == mark) {
							x = i;
							y = j - 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}

					} else if (j - 1 >= 0 && j - 2 >= 0) {
						if (board.board[i][j - 1] == mark) {
							x = i;
							y = j - 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i][j - 1] == mark) {
							x = i;
							y = j - 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
					// Checks for vertical wins
					if (i + 1 < board.dimensions && i + 2 < board.dimensions) {
						if (board.board[i + 1][j] == mark) {
							x = i + 2;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i + 2][j] == mark) {
							x = i + 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					} else if (i - 1 >= 0 && i + 1 < board.dimensions) {
						if (board.board[i - 1][j] == mark) {
							x = i + 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i + 1][j] == mark) {
							x = i - 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					} else if (i - 1 >= 0 && i - 2 >= 0) {
						if (board.board[i - 1][j] == mark) {
							x = i - 2;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i - 2][j] == mark) {
							x = i - 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
					// Checks for left diagonal wins
					if (i + 1 < board.dimensions && j + 1 < board.dimensions && i + 2 < board.dimensions
							&& j + 2 < board.dimensions) {
						if (board.board[i + 1][j + 1] == mark) {
							x = i + 2;
							y = j + 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i + 2][j + 2] == mark) {
							x = i + 1;
							y = j + 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
					// Checks for right diagonal wins
					if (i + 1 > board.dimensions && j - 1 >= 0 && i + 2 > board.dimensions && j - 2 >= 0) {
						if (board.board[i + 1][j - 1] == mark) {
							x = i + 2;
							y = j - 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						} else if (board.board[i + 2][j - 2] == mark) {
							x = i + 1;
							y = j - 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
				}
			}
		}

		// Check for blocking opponent wins
		for (int i = 0; i < board.dimensions; i++) {
			for (int j = 0; j < board.dimensions; j++) {
				if (board.board[i][j] == 'X') {
					// Blocks opponent's horizontal wins
					if (j + 1 < board.dimensions && j + 2 < board.dimensions) {
						if (board.board[i][j + 1] == 'X') {
							x = i;
							y = j + 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i][j + 2] == 'X') {
							x = i;
							y = j + 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}

					}
					if (j - 1 >= 0 && j + 1 < board.dimensions) {
						if (board.board[i][j - 1] == 'X') {
							x = i;
							y = j + 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i][j + 1] == 'X') {
							x = i;
							y = j - 1;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}

					}
					if (j - 1 >= 0 && j - 2 >= 0) {
						if (board.board[i][j - 1] == 'X') {
							x = i;
							y = j - 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i][j - 1] == 'X') {
							x = i;
							y = j - 2;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}

					}
					// Blocks opponent's vertical wins
					if (i + 1 < board.dimensions && i + 2 < board.dimensions) {
						if (board.board[i + 1][j] == 'X') {
							x = i + 2;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i + 2][j] == 'X') {
							x = i + 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
					if (i - 1 >= 0 && i + 1 < board.dimensions) {
						if (board.board[i - 1][j] == 'X') {
							x = i + 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i + 1][j] == 'X') {
							x = i - 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
					if (i - 1 >= 0 && i - 2 >= 0) {
						if (board.board[i - 1][j] == 'X') {
							x = i - 2;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
						if (board.board[i - 2][j] == 'X') {
							x = i - 1;
							y = j;
							if (board.board[x][y] == ' ') {
								return new int[] { x, y };
							}
						}
					}
				}
			}
		}

		// If no move was chosen, make a random move
		if (x == -1 | y == -1) {
			return randomCoords();
		}

		if (board.board[x][y] == ' ')
			return new int[] { x, y };

		return randomCoords();
	}

	// Returns the coordinates of the AI's moves
	private int[][] getOwnMarks() {
		ArrayList<int[]> coordsList = new ArrayList<>();

		for (int i = 0; i < board.dimensions; i++) {
			for (int j = 0; j < board.dimensions; j++) {
				if (board.board[i][j] == mark) {
					coordsList.add(new int[] { i, j });
				}
			}
		}

		int[][] coords = new int[coordsList.size()][2];
		int index = 0;
		for (int[] coord : coordsList) {
			coords[index] = coord;
			index++;
		}
		return coords;
	}

	private int[] randomCoords() {
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
