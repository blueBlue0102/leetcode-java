public class App {
  public static void main(String[] args) throws Exception {
    int target = 7;
    int[] nums = { 2, 3, 1, 2, 4, 3 };
    int answer = 2;
    int result = minSubArrayLen(target, nums);
    System.out.println(result);

    assert answer == result : "Fail";
    System.out.println("Success");
  }

  // 執行速度 2ms，自己想出來的版本
  private static int minSubArrayLen(int target, int[] nums) {
    int leftIndex = 0;
    int rightIndex = 0;
    final int IMPOSSABLE_ANSWER = nums.length + 1;
    int minWindowLength = IMPOSSABLE_ANSWER;
    int windowSum = nums[0];

    do {
      if (windowSum >= target) {
        // try to update minWindowLength
        minWindowLength = Math.min(minWindowLength, rightIndex - leftIndex + 1);
        // move left index
        windowSum -= nums[leftIndex];
        leftIndex += 1;
      }
      // move right index
      else if (windowSum < target) {
        rightIndex += 1;
        if (rightIndex < nums.length)
          windowSum += nums[rightIndex];
        else
          break;
      }
    } while (rightIndex < nums.length && rightIndex >= leftIndex);

    return minWindowLength == IMPOSSABLE_ANSWER ? 0 : minWindowLength;
  }

  // 執行速度 1ms，網路上大家的版本
  private static int minSubArrayLen_v2(int target, int[] nums) {
    int leftIndex = 0, sum = 0, minWindowLength = Integer.MAX_VALUE;
    for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
      sum += nums[rightIndex];
      while (sum >= target) {
        minWindowLength = Math.min(minWindowLength, rightIndex - leftIndex + 1);
        sum -= nums[leftIndex];
        leftIndex++;
      }
    }
    return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
  }

}
