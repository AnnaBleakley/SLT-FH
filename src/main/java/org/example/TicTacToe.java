package org.example;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.print();
    }

    public void switchCurrentPlayer() {

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {

        char marker = currentPlayer.getMarker();

        if (board.getCell(0, 0) == marker && board.getCell(0, 1) == marker && board.getCell(0, 2) == marker) {
            return true;
        }

        if (board.getCell(1, 0) == marker && board.getCell(1, 1) == marker && board.getCell(1, 2) == marker) {
            return true;
        }

        if (board.getCell(2, 0) == marker && board.getCell(2, 1) == marker && board.getCell(2, 2) == marker) {
            return true;
        }

        if (board.getCell(0, 0) == marker && board.getCell(1, 0) == marker && board.getCell(2, 0) == marker) {
            return true;
        }

        if (board.getCell(0, 1) == marker && board.getCell(1, 1) == marker && board.getCell(2, 1) == marker) {
            return true;
        }

        if (board.getCell(0, 2) == marker && board.getCell(1, 2) == marker && board.getCell(2, 2) == marker) {
            return true;
        }

        if (board.getCell(0, 0) == marker && board.getCell(1, 1) == marker && board.getCell(2, 2) == marker) {
            return true;
        }

        if (board.getCell(0, 2) == marker && board.getCell(1, 1) == marker && board.getCell(2, 0) == marker) {
            return true;
        }

        return false;
    }
// User Story #2
    public void showBoard() {
        board.print();
    }

}