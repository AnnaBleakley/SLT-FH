package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TicTacToeTest {
    @Test
    void makeMoveShouldReturnTrueWhenCellIsEmpty() {
        TicTacToe game = new TicTacToe();

        boolean result = game.makeMove(0, 0);

        assertTrue(result);
    }

    @Test
    void makeMoveShouldReturnFalseWhenCellIsAlreadyTaken() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);

        boolean result = game.makeMove(0, 0);

        assertFalse(result);
    }

    @Test
    void makeMoveShouldReturnFalseWhenPositionIsOutsideBoard() {
        TicTacToe game = new TicTacToe();

        boolean result = game.makeMove(1, 3);

        assertFalse(result);
    }

    @Test
    void makeMoveShouldSwitchPlayerAfterSuccessfulMove() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);
        game.makeMove(0, 1);

        assertEquals('X', game.getCell(0, 0));
        assertEquals('O', game.getCell(0, 1));
    }

    @Test
    void gameShouldEndWhenPlayerXWins() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        assertTrue(game.isGameOver());
        assertEquals('X', game.getWinnerMarker());
    }

    @Test
    void gameShouldEndWhenPlayerOWins() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 2); // X
        game.makeMove(1, 2); // O wins

        assertTrue(game.isGameOver());
        assertEquals('O', game.getWinnerMarker());
    }

    @Test
    void gameShouldEndInDrawWhenBoardIsFullAndNoWinner() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 1); // X
        game.makeMove(2, 0); // O
        game.makeMove(2, 2); // X

        assertTrue(game.isGameOver());
        assertTrue(game.isDraw());
        assertEquals('\0', game.getWinnerMarker());
    }

    @Test
    void gameShouldNotAcceptMoveAfterGameIsOver() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins

        boolean result = game.makeMove(2, 2);

        assertFalse(result);
        assertEquals('\0', game.getCell(2, 2));
    }

    @Test
    void switchCurrentPlayerShouldSwitchFromXToO() {
        TicTacToe game = new TicTacToe();

        game.switchCurrentPlayer();

        assertEquals('O', game.getCurrentPlayerMarker());
    }

    @Test
    void switchCurrentPlayerShouldSwitchBackFromOToX() {
        TicTacToe game = new TicTacToe();

        game.switchCurrentPlayer();
        game.switchCurrentPlayer();

        assertEquals('X', game.getCurrentPlayerMarker());
    }

    @Test
    void hasWinnerShouldReturnFalseAtStart() {
        TicTacToe game = new TicTacToe();

        assertFalse(game.hasWinner());
    }

    @Test
    void getCellShouldReturnPlacedMarker() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);

        assertEquals('X', game.getCell(0, 0));
    }

    @Test
    void getCellShouldReturnEmptyMarkerForEmptyCell() {
        TicTacToe game = new TicTacToe();

        assertEquals('\0', game.getCell(2, 2));
    }

    @Test
    void isGameOverShouldBeFalseAtStart() {
        TicTacToe game = new TicTacToe();

        assertFalse(game.isGameOver());
    }

    @Test
    void isDrawShouldBeFalseAtStart() {
        TicTacToe game = new TicTacToe();

        assertFalse(game.isDraw());
    }

    @Test
    void getWinnerMarkerShouldReturnEmptyWhenNoWinner() {
        TicTacToe game = new TicTacToe();

        assertEquals('\0', game.getWinnerMarker());
    }

    @Test
    void makeMoveShouldReturnFalseWhenXIsNegative() {
        TicTacToe game = new TicTacToe();

        boolean result = game.makeMove(-1, 0);

        assertFalse(result);
    }

    @Test
    void makeMoveShouldReturnFalseWhenYIsNegative() {
        TicTacToe game = new TicTacToe();

        boolean result = game.makeMove(0, -1);

        assertFalse(result);
    }

    @Test
    void hasWinnerShouldReturnTrueWhenXHasTopRow() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X

        assertTrue(game.hasWinner());
    }

    @Test
    void isGameOverShouldBeTrueAfterXWins() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);

        assertTrue(game.isGameOver());
    }

    @Test
    void isDrawShouldBeTrueWhenGameEndsInDraw() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(1, 1);
        game.makeMove(1, 0);
        game.makeMove(1, 2);
        game.makeMove(2, 1);
        game.makeMove(2, 0);
        game.makeMove(2, 2);

        assertTrue(game.isDraw());
    }

    @Test
    void getWinnerMarkerShouldReturnXWhenXWins() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);

        assertEquals('X', game.getWinnerMarker());
    }

    @Test
    void getCurrentPlayerMarkerShouldReturnXAtStart() {
        TicTacToe game = new TicTacToe();

        assertEquals('X', game.getCurrentPlayerMarker());
    }

    @Test
    void getCurrentPlayerMarkerShouldReturnOAfterSwitch() {
        TicTacToe game = new TicTacToe();

        game.switchCurrentPlayer();

        assertEquals('O', game.getCurrentPlayerMarker());
    }


}