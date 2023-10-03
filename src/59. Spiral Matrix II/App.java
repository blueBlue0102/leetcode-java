import java.util.Arrays;

public class App {
  public static void main(String[] args) throws Exception {
    int n = 3;
    int[][] expectedAnswer = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };

    assert Arrays.deepEquals(expectedAnswer, generateMatrix(n)) : "Fail!";
    System.out.println("Success!");
    return;
  }

  private enum Direction {
    Up, Down, Left, Right
  };

  private static int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int row = 0;
    int col = 0;
    Direction direction = Direction.Right;

    for (int num = 1; num < n * n; num++) {
      System.out.printf("row: %d, col: %d\n", row, col);
      result[row][col] = num;

      // update next position
      boolean positionIsUpdated = false;
      while (positionIsUpdated == false) {
        switch (direction) {
          case Right:
            if (col < n - 1 && result[row][col + 1] == 0) {
              col++;
              positionIsUpdated = true;
            } else {
              direction = Direction.Down;
            }
            break;
          case Down:
            if (row < n - 1 && result[row + 1][col] == 0) {
              row++;
              positionIsUpdated = true;
            } else {
              direction = Direction.Left;
            }
            break;
          case Left:
            if (col > 0 && result[row][col - 1] == 0) {
              col--;
              positionIsUpdated = true;
            } else {
              direction = Direction.Up;
            }
            break;
          case Up:
            if (row > 0 && result[row - 1][col] == 0) {
              row--;
              positionIsUpdated = true;
            } else {
              direction = Direction.Right;
            }
            break;
          default:
            break;
        }
      }
    }
    result[row][col] = n * n;
    return result;
  }
}
