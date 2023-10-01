import java.util.Arrays;

public class App {
  public static void main(String[] args) throws Exception {
    int[] nums = { -4, -1, 0, 3, 10 };
    int[] answer = { 0, 1, 9, 16, 100 };
    assert Arrays.equals(answer, sortedSquares(nums)) : "Fail";
    System.out.println("Success");
  }

  private static int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int resultIndex = nums.length - 1;
    int leftIndex = 0;
    int rightIndex = nums.length - 1;
    while (resultIndex >= 0) {
      int squareLeft = nums[leftIndex] * nums[leftIndex];
      int squareRight = nums[rightIndex] * nums[rightIndex];

      if (squareLeft <= squareRight) {
        result[resultIndex] = squareRight;
        rightIndex--;
      } else {
        result[resultIndex] = squareLeft;
        leftIndex++;
      }
      resultIndex--;
    }
    return result;
  }
}
