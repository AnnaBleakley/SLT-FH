package org.example;

public class Board {

    private char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public boolean isCellEmpty(int x, int y) {

        if (cells[x][y] == '\0') {
            return true;
        }

        return false;
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                if (isCellEmpty(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void clear() {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y] = '\0';
            }
        }
    }

    public void print() {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                if (cells[x][y] == '\0') {
                    System.out.print(" ");
                } else {
                    System.out.print(cells[x][y]);
                }

                if (y < 2) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (x < 2) {
                System.out.println("-----");
            }
        }
    }
}