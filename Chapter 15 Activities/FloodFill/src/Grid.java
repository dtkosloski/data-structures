import java.util.Stack;

import javafx.util.Pair;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
     private Stack<Pair> stack = new Stack<>();
    private int fillNumber = 1;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int startRow, int startColumn)
    {
        stack.push(new Pair(startRow, startColumn));

        while (!stack.isEmpty())
        {
            Pair currentPair = stack.pop();
            int row = currentPair.row;
            int column = currentPair.column;

            if (pixels[row][column] == 0)
            {
                pixels[row][column] = fillNumber++;
                // Check and push unfilled neighbors
                pushUnfilledNeighbor(row - 1, column); // North
                pushUnfilledNeighbor(row + 1, column); // South
                pushUnfilledNeighbor(row, column - 1); // West
                pushUnfilledNeighbor(row, column + 1); // East
            }
        }
    }
    private void pushUnfilledNeighbor(int row, int column)
    {
        if (row >= 0 && row < SIZE && column >= 0 && column < SIZE && pixels[row][column] == 0)
        {
            stack.push(new Pair(row, column));
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
    private class Pair
    {
        int row;
        int column;

        Pair(int row, int column)
        {
            this.row = row;
            this.column = column;
        }
    }
}
