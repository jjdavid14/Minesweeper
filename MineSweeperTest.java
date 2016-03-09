
/**
 * The beginning of a unit test for MineSweeper.  
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class MineSweeperTest {

	@Test
	public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

		boolean[][] b1 =

			  { { false, false, false, false, false }, 
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);

		// Check adjacent mines around every possible GameSquare
		assertEquals(0, ms.getAdjacentMines(0, 0));
		assertEquals(1, ms.getAdjacentMines(0, 1));
		assertEquals(2, ms.getAdjacentMines(0, 2));
		assertEquals(2, ms.getAdjacentMines(0, 3));
		assertEquals(1, ms.getAdjacentMines(0, 4));

		assertEquals(0, ms.getAdjacentMines(1, 0));
		assertEquals(1, ms.getAdjacentMines(1, 1));
		assertEquals(2, ms.getAdjacentMines(1, 2)); // works even if it is a
													// mine
		assertEquals(2, ms.getAdjacentMines(1, 3));
		assertEquals(2, ms.getAdjacentMines(1, 4));

		assertEquals(0, ms.getAdjacentMines(2, 0));
		assertEquals(1, ms.getAdjacentMines(2, 1));
		assertEquals(3, ms.getAdjacentMines(2, 2));
		assertEquals(2, ms.getAdjacentMines(2, 3));
		assertEquals(2, ms.getAdjacentMines(2, 4));
	}

	@Test
	public void testGetTotalMine() {
		boolean[][] b1 =

			  { { false, false, false, false, false }, 
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };
		
		boolean[][] b2 =

			  { { true, false, false, false, false, false }, 
				{ false, false, true, true, false, true },
				{ false, false, false, true, false, false },
				{ false, false, true, false, true, false}};

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);
		MineSweeper ns = new MineSweeper(b2);

		assertEquals(3, ms.getTotalMineCount());
		assertEquals(7, ns.getTotalMineCount());
	}
	
	@Test
	public void testToggleAndIsFlagged() {
		boolean[][] b1 =

			  { { false, false, false, false, false }, 
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);

		ms.toggleFlagged(2, 4);
		ms.toggleFlagged(1, 0);
		
		assertTrue(ms.isFlagged(2, 4));
		assertTrue(ms.isFlagged(1, 0));
		assertFalse(ms.isFlagged(1, 3));
	}
	
	@Test
	public void testIsMine() {
		boolean[][] b1 =

			  { { false, false, false, false, false }, 
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);
		
		assertTrue(ms.isMine(1, 2));
		assertTrue(ms.isMine(1, 3));
		assertTrue(ms.isMine(2, 3));
		assertFalse(ms.isMine(0, 0));
	}
}