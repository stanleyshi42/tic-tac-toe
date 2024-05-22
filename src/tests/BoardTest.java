package tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import ticTacToe.Board;

public class BoardTest {
	@Test
	public void testMark() {
		Board board = new Board();
		board.mark('X', 1, 0);
		board.mark('O', 1, 1);
		board.mark('O', 1, 0);

		assertEquals('X', board.grid[1][0]);
		assertEquals('O', board.grid[1][1]);
		assertEquals(' ', board.grid[1][2]);
	}

	@Test
	public void testCheckDraw() {
		Board board = new Board();

		assertFalse(board.checkDraw());

		board.mark('X', 0, 0);
		board.mark('O', 0, 1);
		board.mark('X', 0, 2);

		board.mark('O', 1, 1);
		board.mark('X', 2, 1);
		board.mark('O', 2, 0);

		board.mark('X', 1, 0);
		board.mark('O', 1, 2);
		board.mark('X', 2, 2);

		assertTrue(board.checkDraw());
	}

	@Test
	public void testCheckWin() {
		Board board = new Board();

		assertFalse(board.checkWin('X'));

		board.mark('X', 0, 0);
		board.mark('X', 0, 1);
		board.mark('X', 0, 2);

		assertTrue(board.checkWin('X'));

		board = new Board();
		board.mark('O', 0, 0);
		board.mark('O', 1, 0);
		board.mark('O', 2, 0);

		assertTrue(board.checkWin('O'));

	}
}
