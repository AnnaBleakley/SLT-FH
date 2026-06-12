package org.example;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private GameState gameState;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
        gameState = GameState.IN_PROGRESS;
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

    //helper methods to support unit tests

    public boolean isGameOver() {
        return gameState != GameState.IN_PROGRESS;
    }


    public char getCurrentPlayerMarker() {
        return currentPlayer.getMarker();
    }

    public boolean isDraw() {
        return gameState == GameState.DRAW;
    }

    public char getWinnerMarker() {
        if (gameState == GameState.X_WON) {
            return 'X';
        }
        if (gameState == GameState.O_WON) {
            return 'O';
        }
            return '\0';
        }

    public char getCell(int x, int y) {
        return board.getCell(x, y);
    }

// User Story #2
    public void showBoard() {
        if (isGameOver()) {
            return;
        }

        board.print();
    }

//User Story #1
    public boolean makeMove(int x, int y){
        if (isGameOver()) {
            System.out.println("The game has already ended.");
            return false;
        }

        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Invalid position. Please choose x and y between 0 and 2.");
            return false;
        }

        if (board.isCellEmpty(x, y) == false) {
            System.out.println("This square is already taken.");
            return false;
        }

        board.place(x, y, currentPlayer.getMarker());

        if (hasWinner()) {
            if (currentPlayer.getMarker() == 'X') {
                gameState = GameState.X_WON;
            } else {
                gameState = GameState.O_WON;
            }

            printGameResult();
            return true;
        } else if (board.isFull()) {
            gameState = GameState.DRAW;
            printGameResult();
            return true;
        }

        switchCurrentPlayer();

        return true;
    }
    // User Story #3
    public void printGameResult() {

        if (gameState == GameState.X_WON) {
            System.out.println("""
█▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█   ▀▄▀   █░█░█ █▀█ █▄░█   █▀█ █░░ █▀█ █▄█ █▀▀ █▀█   █▀█   █░░ █▀█ █▀ ▀█▀
█▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄   █░█   ▀▄▀▄▀ █▄█ █░▀█   █▀▀ █▄▄ █▄█ ░█░ ██▄ █▀▄   █▄█   █▄▄ █▄█ ▄█ ░█░
""");
        } else if (gameState == GameState.O_WON) {
            System.out.println("""
█▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█   █▀█   █░█░█ █▀█ █▄░█   █▀█ █░░ █▀█ █▄█ █▀▀ █▀█   ▀▄▀   █░░ █▀█ █▀ ▀█▀
█▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄   █▄█   ▀▄▀▄▀ █▄█ █░▀█   █▀▀ █▄▄ █▄█ ░█░ ██▄ █▀▄   █░█   █▄▄ █▄█ ▄█ ░█░
""");
        } else if (gameState == GameState.DRAW) {
            System.out.println("""
█▀▄ █▀█ ▄▀█ █░█░█
█▄▀ █▀▄ █▀█ ▀▄▀▄▀
""");
        }
    }
    // User Story #4
    public void startNewGame() {
        board.clear();
        currentPlayer = player1;
        gameState = GameState.IN_PROGRESS;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


}