package org.hexlet.xo;

import org.hexlet.xo.exception.InvalidCellCoordinatesException;

public class Field {
    private static final int DEFAULT_FIELD_SIZE = 3;
    public final int SIZE;
    private CellState[][] field;

    public Field(int fieldSize) {
        SIZE = fieldSize;
        field = new CellState[SIZE][SIZE];
        clear();
    }

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public int getEmptyCellsCount() {
        int availableCells = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (field[i][j] == CellState.EMPTY)
                    availableCells++;
        return availableCells;
    }

    public void setCell(CellInfo cell) {
        field[cell.Y][cell.X] = cell.figure;
    }

    public CellInfo getCell(int x, int y) throws InvalidCellCoordinatesException {
        return new CellInfo(x, y, field[y][x]);
    }

    public void clear() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                    setCell(new CellInfo(x, y, CellState.EMPTY));
            }
        }
    }

    public CellState[][] getField() {
        /*if we returning original field
        anyone can write in field array directly
         */
        CellState [][] fieldCopy = new CellState[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                fieldCopy[i][j] = field[i][j];
            }
        }
        return fieldCopy;
    }

}
