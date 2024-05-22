package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import ticTacToe.AiPlayer;
import ticTacToe.Board;

public class AiPlayerTest {
	@Test
	// Tests if random coordinated are within the board's dimensions
	public void testRandomCoords() {
		Board board = new Board();
		AiPlayer player = new AiPlayer('O', 0, board);

		int[] coords = player.randomCoords();

		if (coords[0] >= 0 && coords[0] < board.dimensions)
			assertTrue(true);
		else
			assertTrue(false);

		if (coords[1] >= 0 && coords[1] < board.dimensions)
			assertTrue(true);
		else
			assertTrue(false);

	}
}
