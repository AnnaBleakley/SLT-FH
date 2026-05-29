package org.example;

public class TicTacToe {

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();

        playerX = new Player('X');
        playerO = new Player('O');

        currentPlayer = playerX;
    }
}
