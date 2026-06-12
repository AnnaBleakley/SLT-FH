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
        public void startNewGameClearsBoard() {
            TicTacToe game = new TicTacToe();

            game.getBoard().place(0, 0, 'X');
            game.getBoard().place(1, 1, 'O');

            game.startNewGame();

            assertTrue(game.getBoard().isCellEmpty(0, 0));
            assertTrue(game.getBoard().isCellEmpty(1, 1));
        }

        @Test
        public void startNewGameSetsCurrentPlayerToX() {
            TicTacToe game = new TicTacToe();

            game.switchCurrentPlayer();

            game.startNewGame();

            assertEquals('X', game.getCurrentPlayer().getMarker());
        }
    @Test
    void startNewGameSetsGameStateToInProgress() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2); // X wins

        game.startNewGame();

        assertFalse(game.isGameOver());
    }
    @Test
    void showBoardShouldPrintCurrentBoard() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1, 1);

        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));

        game.showBoard();

        String printedText = output.toString();

        assertTrue(printedText.contains("X"));
    }
    @Test
    void showBoardShouldPrintEmptyBoard() {
        TicTacToe game = new TicTacToe();

        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));

        game.showBoard();

        String printedText = output.toString();

        assertFalse(printedText.isEmpty());
    }
    }
