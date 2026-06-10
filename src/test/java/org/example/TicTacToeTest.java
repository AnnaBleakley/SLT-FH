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
    void bothPlayersCannotMoveToTakenPlace() {
        TicTacToe game = new TicTacToe();

        boolean firstMove = game.makeMove(1, 1);
        game.switchCurrentPlayer();

        boolean secondMove = game.makeMove(1, 1);

        assertTrue(firstMove);
        assertFalse(secondMove);
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
}