public class App {
  public static void main(String[] args) throws Exception {
    int[] nums = { -1, 9 };
    int target = 9;

    int leftIndex = 0;
    int rightIndex = nums.length - 1;
    int middleIndex = (leftIndex + rightIndex) / 2;

    while (leftIndex < rightIndex) {
      if (nums[middleIndex] == target) {
        System.out.println(middleIndex);
        return;
      } else if (nums[middleIndex] > target) {
        rightIndex = middleIndex - 1;
        middleIndex = (leftIndex + rightIndex) / 2;
      } else if (nums[middleIndex] < target) {
        leftIndex = middleIndex + 1;
        middleIndex = (leftIndex + rightIndex) / 2;
      }
    }
    System.out.println(-1);
    return;
  }
}
